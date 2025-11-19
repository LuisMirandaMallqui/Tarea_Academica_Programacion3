
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
                CargarYMostrarSolicitudes();
            }
        }


        // --- ¡AQUÍ ESTÁ TU IDEA! ---
        private void CargarYMostrarSolicitudes()
        {
            try
            {
                // 1. Llamada al Backend
                listadoPublicacionGestionDto listado = publicacionSoap.obtenerListaPublicacionGestion(
                    0, 
                    PublicacionesPorPagina,
                    PaginaActual,
                    "Pendiente"
                );

                // 2. Obtener datos limpios (Variables locales = Memoria se libera al terminar la función)
                var listaPublicaciones = listado.lista; // Tu lista de DTOs
                int totalRegistros = listado.totalPaginas;

                // 3. Cálculo de páginas (Lógica C# que acordamos)
                int totalPaginas = (int)Math.Ceiling((double)totalRegistros / PublicacionesPorPagina);

                // 4. Pasar datos DIRECTAMENTE a la UI
                MostrarDatosEnPantalla(listaPublicaciones, totalPaginas, totalRegistros);
            }
            catch (Exception ex)
            {
                // Manejo de error limpio
                rptSolicitudes.DataSource = null;
                rptSolicitudes.DataBind();
                lblCantidadResultados.Text = "Error al cargar: " + ex.Message;
                phPaginacion.Controls.Clear();
            }
        }

        // Este método ahora recibe los datos por parámetro. No busca nada en Session.
        private void MostrarDatosEnPantalla(object lista, int totalPaginas, int totalRegistros)
        {
            rptSolicitudes.DataSource = lista;
            rptSolicitudes.DataBind();

            lblCantidadResultados.Text = $"Mostrando {totalRegistros} resultados"; 

            GenerarPaginacion(totalPaginas);
        }

        // --- EVENTOS (Idénticos) ---

        protected void ddlEstados_SelectedIndexChanged(object sender, EventArgs e)
        {
            PaginaActual = 1;
            CargarYMostrarSolicitudes();
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

    }
}