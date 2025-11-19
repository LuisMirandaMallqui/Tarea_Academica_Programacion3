using SquirlearnWA.comprobanteSOAP;
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
    public partial class Pedidos : System.Web.UI.Page
    {
        private ComprobanteClient comprobanteSoap;
        private const int RegistrosPorPagina = 10;

        public Pedidos()
        {
            comprobanteSoap = new ComprobanteClient();
        }

        // Propiedades para mantener el estado en la vista
        private int PaginaActual
        {
            get => ViewState["PaginaActual"] != null ? (int)ViewState["PaginaActual"] : 0;
            set => ViewState["PaginaActual"] = value;
        }

        private int TotalRegistros
        {
            get => ViewState["TotalRegistros"] != null ? (int)ViewState["TotalRegistros"] : 0;
            set => ViewState["TotalRegistros"] = value;
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                PaginaActual = 0;
                CargarPedidos();
            }
        }

        private void CargarPedidos()
        {
            int idUsuario = Convert.ToInt32(Session["UsuarioId"]);

            // Determinar si filtramos por Venta o Alquiler
            // (Idealmente este filtro debería ir al Backend en el futuro)
            bool esVentaFiltro = chkCompra.Checked;
            string tipoEtiqueta = esVentaFiltro ? "Compra" : "Alquiler";

            try
            {
                // 1. Llamada al backend (Nota: Si el backend no filtra por tipo, traerá mezcla)
                var resultado = comprobanteSoap.listarPorDuenoComprobante(idUsuario, esVentaFiltro, RegistrosPorPagina, PaginaActual);

                if (resultado?.lista != null && resultado.lista.Length > 0)
                {
                    // 2. TRANSFORMACIÓN DE DATOS (Aquí armamos tu comprobanteShortDto)
                    // Convertimos la lista cruda en la lista visual que necesitamos
                    var listaVisual = resultado.lista;
                        

                    // 4. Enlazamos al Repeater
                    rptPedidos.DataSource = listaVisual;
                    rptPedidos.DataBind();

                    // 5. Actualizamos Paginación
                    TotalRegistros = resultado.totalRegistros; // Guardamos el total real
                    int totalPaginas = (int)Math.Ceiling((double)TotalRegistros / RegistrosPorPagina);

                    // Ajuste visual si filtramos en memoria (la cantidad mostrada puede ser menor)
                    lblCantidadResultados.Text = $"Mostrando {listaVisual.Length} pedidos de {tipoEtiqueta}";

                    // Control de botones
                    btnAnterior.Enabled = PaginaActual > 0;
                    btnSiguiente.Enabled = PaginaActual < (totalPaginas - 1);

                    // Ocultar paginación si no hay suficientes datos o si filtramos todo
                    phPaginacion.Visible = totalPaginas > 1 && listaVisual.Length > 0;
                }
                else
                {
                    rptPedidos.DataSource = null;
                    rptPedidos.DataBind();
                    lblCantidadResultados.Text = "No se encontraron pedidos.";
                    btnAnterior.Enabled = false;
                    btnSiguiente.Enabled = false;
                }
            }
            catch (Exception ex)
            {
                lblCantidadResultados.Text = "Error al cargar pedidos.";
            }
        }

        // --- Eventos de Botones ---

        protected void btnAnterior_Click(object sender, EventArgs e)
        {
            if (PaginaActual > 0)
            {
                PaginaActual--;
                CargarPedidos();
            }
        }

        protected void btnSiguiente_Click(object sender, EventArgs e)
        {
            int totalPaginas = (int)Math.Ceiling((double)TotalRegistros / RegistrosPorPagina);
            if (PaginaActual < totalPaginas - 1)
            {
                PaginaActual++;
                CargarPedidos();
            }
        }

        // --- Eventos de Filtros (Radio-Checkbox Logic) ---

        protected void btnFiltrarCompra_Click(object sender, EventArgs e)
        {
            if (chkCompra.Checked)
            {
                chkAlquiler.Checked = false; // Desmarca el otro
                PaginaActual = 0; // Resetea página
                CargarPedidos();
            }
            else
            {
                // Evitar que ambos queden desmarcados (opcional)
                chkCompra.Checked = true;
            }
        }

        protected void btnFiltrarAlquiler_Click(object sender, EventArgs e)
        {
            if (chkAlquiler.Checked)
            {
                chkCompra.Checked = false; // Desmarca el otro
                PaginaActual = 0; // Resetea página
                CargarPedidos();
            }
            else
            {
                chkAlquiler.Checked = true;
            }
        }

        protected void btnVolver_Click3(object sender, EventArgs e)
        {
            Response.Redirect("../PerfilUsuario/Perfil.aspx");
        }

    }
}