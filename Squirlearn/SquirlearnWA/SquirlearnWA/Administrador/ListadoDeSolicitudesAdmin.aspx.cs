
using SquirlearnWA.estadoPublicacionSOAP;
using SquirlearnWA.incidenciaSOAP;
using SquirlearnWA.personaSOAP;
using SquirlearnWA.publicacionSOAP;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;



namespace SquirlearnWA.Administrador
{
    public partial class ListadoDeSolicitudesAdmin : System.Web.UI.Page
    {
        private PublicacionClient publicacionSoap;
        private EstadoPublicacionClient estadoPublicacionSoap;
        private const int PublicacionesPorPagina = 4;
        private PersonaClient personaSOAP;
        // ❗️ Define el ID de tu estado "Pendiente"

        public ListadoDeSolicitudesAdmin()
        {
            publicacionSoap = new PublicacionClient();
            estadoPublicacionSoap = new EstadoPublicacionClient();
            personaSOAP = new PersonaClient();
        }

        private int PaginaActual
        {
            get { return ViewState["PaginaActual"] != null ? (int)ViewState["PaginaActual"] : 1; }
            set { ViewState["PaginaActual"] = value; }
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                PaginaActual = 1;
                CargarYMostrarSolicitudes();
            }
        }


        
        private void CargarYMostrarSolicitudes()
        {
            try
            {
                // 1. Llamada al Backend
                listadoPublicacionGestionDto listado = publicacionSoap.obtenerListaPublicacionGestion(
                    0,
                    PublicacionesPorPagina,
                    PaginaActual,
                    1
                );
                
                var listaPublicaciones = listado.lista.ToList(); // Lista de DTOs
                int totalRegistros = listado.totalPaginas; // Total de registros en la BD

                var listaPublicacionesPersona = new List<dynamic>();

                foreach (var pub in listaPublicaciones)
                {
                    var persona = personaSOAP.obtenerPorIdPersona(pub.personaId);

                    listaPublicacionesPersona.Add(new
                    {
                        pub.publicacionId,
                        pub.nombre,
                        pub.categoriaNombre,
                        pub.estadoNombre,
                        pub.personaId,
                        NombrePersona = persona != null ? persona.nombres + ' ' + persona.primerApellido+ ' '+ persona.segundoApellido : "Desconocido"
                    });
                }
                
                // 2. Cálculo de páginas
                int totalPaginas = (int)Math.Ceiling((double)totalRegistros / PublicacionesPorPagina);

                // 3. Mostrar datos
                MostrarDatosEnPantalla(listaPublicacionesPersona, totalPaginas, totalRegistros);
            }
            catch (Exception ex)
            {
                // Manejo de error limpio
                rptSolicitudes.DataSource = null;
                rptSolicitudes.DataBind();
                lblCantidadResultados.Text = "Error al cargar: " + ex.Message;
            }
        }

        // Este método ahora recibe los datos por parámetro. No busca nada en Session.
        private void MostrarDatosEnPantalla(object lista, int totalPaginas, int totalRegistros)
        {
            

            rptSolicitudes.DataSource = lista;
            rptSolicitudes.DataBind();

            lblCantidadResultados.Text = $"Se encontraron {totalRegistros} publicaciones.";
            lblPagina.Text = $"Página {PaginaActual} de {totalPaginas}";

            btnAnterior.Enabled = PaginaActual > 1;
            btnSiguiente.Enabled = PaginaActual < totalPaginas;
        }

        // --- EVENTOS (Idénticos) ---

        protected void ddlEstados_SelectedIndexChanged(object sender, EventArgs e)
        {
            PaginaActual = 1;
            CargarYMostrarSolicitudes();
        }

       

        protected void BtnPagina_Click(object sender, EventArgs e)
        {
            var btn = (Button)sender;
            if (int.TryParse(btn.CommandArgument, out int pagina))
            {
                PaginaActual = pagina;
                CargarYMostrarSolicitudes();
            }
        }

        protected string GetEstadoColor(string estado)
        {
            string color;
            switch (estado)
            {
                case "Pendiente":
                    color = "bg-success text-white";
                    break;
                default:
                    color = "bg-secondary text-white";
                    break;
            }
            return color;
        }

        protected void rptSolicitudes_ItemDataBound(object sender, RepeaterItemEventArgs e)
        {
            if (e.Item.ItemType == ListItemType.Item || e.Item.ItemType == ListItemType.AlternatingItem)
            {
                // Usamos el DTO que SÍ tiene 'EstadoNombre'
                var pub = e.Item.DataItem as publicacionShortDto;
                if (pub == null) return;

                string estado = pub.estadoNombre;

                Label lblEstado = e.Item.FindControl("lblEstado") as Label;
                if (lblEstado != null)
                {
                    lblEstado.CssClass = $"{GetEstadoColor(estado)} badge p-2 me-3";
                }
            }
        }
        protected void btnAnterior_Click(object sender, EventArgs e)
        {
            if (PaginaActual > 1)
            {
                PaginaActual--;
                CargarYMostrarSolicitudes();
            }
        }

        protected void btnSiguiente_Click(object sender, EventArgs e)
        {
            PaginaActual++;
            CargarYMostrarSolicitudes();
        }

    }
}