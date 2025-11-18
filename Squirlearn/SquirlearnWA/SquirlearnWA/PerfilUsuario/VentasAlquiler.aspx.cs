using SquirlearnWA.personaSOAP;
using SquirlearnWA.publicacionSOAP;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class VentasAlquiler : System.Web.UI.Page
    {

        private MisVentasAlquilerClient misVentasAlquilerSOAP;
        private PublicacionClient publicacionSoap;
        private PersonaClient personaSoap;
        private const int RegistrosPorPagina = 10; // Número de pedidos por página

        public VentasAlquiler()
        {
            misVentasAlquilerSOAP = new MisVentasAlquilerClient();
            publicacionSoap = new PublicacionClient();
            personaSoap = new PersonaClient();
        }
        // Guardar la página actual
        private int PaginaActual
        {
            get => ViewState["PaginaActual"] != null ? (int)ViewState["PaginaActual"] : 0;
            set => ViewState["PaginaActual"] = value;
        }

        private List<VentasDto> ListaPedidos
        {
            get => ViewState["ListaPedidos"] as List<VentasDto>;
            set => ViewState["ListaPedidos"] = value;
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                PaginaActual = 0;
                // Por defecto mostrar Comprado
                CargarPedidos("Comprado");
            }
        }

        protected void CargarPedidos(string tipo)
        {

            int idUsuario = Convert.ToInt32(Session["UsuarioId"]);
            int pagina = PaginaActual;

            // Llamada al backend con paginación
            ListadoVentasDto resultado = misVentasAlquilerSOAP.ObtenerListadoPedidosPaginado(idUsuario, RegistrosPorPagina, pagina);

            if (resultado?.Lista != null && resultado.Lista.Count > 0)
            {
                var listaCombinada = resultado.Lista
                     .Select(p =>
                     {
                         var publicacion = publicacionSoap.obtenerPorIdPublicacion(p.idPublicacion);
                         var persona = personaSoap.obtenerDatosPersona(p.idUsuario);

                         return new
                         {
                             Pedido = p,
                             Publicacion = publicacion,
                             Persona = persona,
                             TipoPedido = publicacion.item.esVenta ? "Comprado" : "Alquilado"
                         };
                     })
                     .Where(x => x.TipoPedido == tipo)
                     .ToList();

                rptPedidos.DataSource = listaCombinada;
                rptPedidos.DataBind();


                ViewState["TotalRegistros"] = resultado.TotalRegistros;
                // Mostrar info de paginación
                int totalPaginas = (int)Math.Ceiling((double)resultado.TotalRegistros / RegistrosPorPagina);
                lblCantidadResultados.Text = $"Página {PaginaActual + 1} de {totalPaginas}, mostrando {listaCombinada.Count} de {resultado.TotalRegistros} resultados";

                btnAnterior.Enabled = PaginaActual > 0;
                btnSiguiente.Enabled = PaginaActual < totalPaginas - 1;
            }
            else
            {
                rptPedidos.DataSource = null;
                rptPedidos.DataBind();
                lblCantidadResultados.Text = "No hay pedidos disponibles.";
            }
        }

        // Botones de paginación
        protected void btnAnterior_Click(object sender, EventArgs e)
        {
            if (PaginaActual > 0)
            {
                PaginaActual--;
                CargarPedidos(chkCompra.Checked ? "Comprado" : "Alquilado");
            }
        }

        protected void btnSiguiente_Click(object sender, EventArgs e)
        {
            int totalRegistros = (int)ViewState["TotalRegistros"];
            int totalPaginas = (int)Math.Ceiling((double)totalRegistros / RegistrosPorPagina);

            if (PaginaActual < totalPaginas - 1)
            {
                PaginaActual++;
                CargarPedidos(chkCompra.Checked ? "Comprado" : "Alquilado");
            }
        }

        // Filtro Compra
        protected void btnFiltrarCompra_Click(object sender, EventArgs e)
        {
            if (chkCompra.Checked)
            {
                chkAlquiler.Checked = false;
                PaginaActual = 0;
                CargarPedidos("Comprado");
            }
            else if (chkAlquiler.Checked)
            {
                PaginaActual = 0;
                CargarPedidos("Alquilado");
            }
        }

        // Filtro Alquiler
        protected void btnFiltrarAlquiler_Click(object sender, EventArgs e)
        {
            if (chkAlquiler.Checked)
            {
                chkCompra.Checked = false;
                PaginaActual = 0;
                CargarPedidos("Alquilado");
            }
            else if (chkCompra.Checked)
            {
                PaginaActual = 0;
                CargarPedidos("Comprado");
            }
        }

        // Botón Volver
        protected void btnVolver_Click(object sender, EventArgs e)
        {
            Response.Redirect("../PerfilUsuario/Perfil.aspx");
        }



    }

}