
using SquirlearnWA.estadoPublicacionSOAP;
using SquirlearnWA.publicacionSOAP;
using System;
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
        private const int PublicacionesPorPagina = 10;

        // ❗️ Define el ID de tu estado "Pendiente"
        private const int ID_ESTADO_PENDIENTE = 1;

        public ListadoDeSolicitudesAdmin()
        {
            publicacionSoap = new PublicacionClient();
            estadoPublicacionSoap = new EstadoPublicacionClient();
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
                CargarSolicitudesDesdeBackend();
                MostrarSolicitudes();
            }
        }


        // --- ¡AQUÍ ESTÁ TU IDEA! ---
        private void CargarSolicitudesDesdeBackend()
        {

            try
            {
                // ❗️❗️ TU IDEA: Pasamos -1 como UsuarioId para "TODOS LOS USUARIOS"
                // (O 0, lo que tu backend entienda como "Todos")
                listadoPublicacionGestionDto listado = publicacionSoap.obtenerListaPublicacionGestion(
                    0,
                    PublicacionesPorPagina,
                    PaginaActual,
                    ID_ESTADO_PENDIENTE
                );

                Session["AdminPublicaciones"] = listado.lista;
                Session["AdminTotalPaginas"] = listado.totalPaginas;
            }
            catch (Exception ex)
            {
                Session["AdminPublicaciones"] = new List<publicacionShortDto>();
                Session["AdminTotalPaginas"] = 0;
                lblCantidadResultados.Text = "Error al cargar publicaciones.";
            }
        }

        private void MostrarSolicitudes()
        {
            var publicaciones = Session["AdminPublicaciones"] as List<publicacionShortDto>;
            if (publicaciones == null) return;

            rptSolicitudes.DataSource = publicaciones;
            rptSolicitudes.DataBind();

            lblCantidadResultados.Text = $"Mostrando {publicaciones.Count} resultados";

            int totalPaginas = Session["AdminTotalPaginas"] != null ? (int)Session["AdminTotalPaginas"] : 1;
            GenerarPaginacion(totalPaginas);
        }

        // --- EVENTOS (Idénticos) ---

        protected void ddlEstados_SelectedIndexChanged(object sender, EventArgs e)
        {
            PaginaActual = 1;
            CargarSolicitudesDesdeBackend();
            MostrarSolicitudes();
        }

        private void GenerarPaginacion(int totalPaginas)
        {
            phPaginacion.Controls.Clear();
            for (int i = 1; i <= totalPaginas; i++)
            {
                Button btnPagina = new Button
                {
                    Text = i.ToString(),
                    // Marca el botón de la página actual como "activo"
                    CssClass = i == PaginaActual ? "btn btn-dark btn-sm me-1" : "btn btn-outline-dark btn-sm me-1",
                    CommandArgument = i.ToString(),
                    ID = "btnPagina_" + i
                };
                // Asigna el evento click a cada botón creado
                btnPagina.Click += BtnPagina_Click;
                phPaginacion.Controls.Add(btnPagina);
            }
        }
        protected void BtnPagina_Click(object sender, EventArgs e)
        {
            var btn = (Button)sender;
            if (int.TryParse(btn.CommandArgument, out int pagina))
            {
                // 1. Actualiza la página actual
                PaginaActual = pagina;

                // 2. Vuelve a cargar los datos (para la página 2, 3, etc.)
                // ❗️ Asegúrate de llamar al método correcto de esta página
                CargarSolicitudesDesdeBackend(); // Para el Admin
                                                 // CargarPublicacionesDesdeBackend(); // Para el Usuario

                // 3. Vuelve a pintar el Repeater
                MostrarSolicitudes(); // Para el Admin
                                      // MostrarPublicaciones(); // Para el Usuario
            }
        }
        protected string GetEstadoColor(string estado)
        {
            string color;
            switch (estado)
            {
                case "Aceptado":
                    color = "bg-success text-white";
                    break;
                case "Rechazado":
                    color = "bg-danger text-white";
                    break;
                case "Pendiente":
                    color = "bg-warning text-dark";
                    break;
                case "Borrador":
                    color = "bg-primary text-white";
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

                string estado = pub.EstadoNombre;

                Label lblEstado = e.Item.FindControl("lblEstado") as Label;
                if (lblEstado != null)
                {
                    lblEstado.CssClass = $"{GetEstadoColor(estado)} badge p-2 me-3";
                }
            }
        }

    }
}