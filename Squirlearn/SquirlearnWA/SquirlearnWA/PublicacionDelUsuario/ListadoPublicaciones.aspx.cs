using SquirlearnWA.estadoPublicacionSOAP;
using SquirlearnWA.publicacionSOAP;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class ListadoPublicaciones : System.Web.UI.Page
    {
        private PublicacionClient publicacionSoap;
        private EstadoPublicacionClient estadoPublicacionSoap;
        private const int PublicacionesPorPagina = 10;


        public ListadoPublicaciones()
        {
            this.publicacionSoap = new PublicacionClient();
            this.estadoPublicacionSoap = new EstadoPublicacionClient();
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
                CargarEstados();
                PaginaActual = 1;
                CargarPublicacionesDesdeBackend();
                MostrarPublicaciones();
            }
        }

        private void CargarEstados()
        {
            try
            {
                IList<estadoPublicacionSOAP.estadoPublicacionDto> estados = estadoPublicacionSoap.listarTodosEstadoPublicacion();
                ddlEstados.DataSource = estados;
                ddlEstados.DataTextField = "nombre";
                ddlEstados.DataValueField = "estadoPublicacionId";
                ddlEstados.DataBind();

                // ❗️ CORRECCIÓN 1: El valor "Todos" debe ser un número (como "-1")
                // Tu código `int.Parse()` fallará si el valor es el texto "Todos".
                ddlEstados.Items.Insert(0, new ListItem("Todos", "-1"));
                ddlEstados.SelectedValue = "-1";
            }
            catch (Exception ex)
            {
                lblCantidadResultados.Text = "Error al cargar estados.";
                ddlEstados.Items.Insert(0, new ListItem("Todos", "-1"));
            }
        }

        private void CargarPublicacionesDesdeBackend()
        {
            // ❗️ CORRECCIÓN 2: Usar TryParse y manejar el "-1" de "Todos"
            if (!int.TryParse(ddlEstados.SelectedValue, out int filtroEstado))
            {
                filtroEstado = 0; // Valor por defecto si algo falla
            }

            try
            {
                // Asumo que tu método SOAP 'obtenerListaPublicacionGestion'
                // devuelve un DTO que contiene 'lista' (de tipo List<publicacionShortDto>)
                // y 'totalPaginas'.
                listadoPublicacionGestionDto listadoDePublicacionesPorPaginacion = publicacionSoap.obtenerListaPublicacionGestion(
                    (int)Session["UsuarioId"],
                    PublicacionesPorPagina,
                    PaginaActual,
                    filtroEstado // Ahora SÍ es un 'int'
                );

                Session["Publicaciones"] = listadoDePublicacionesPorPaginacion.lista;
                Session["TotalPaginas"] = listadoDePublicacionesPorPaginacion.totalPaginas;
            }
            catch (Exception ex)
            {
                // Asegúrate que el tipo de lista coincida
                Session["Publicaciones"] = new List<publicacionShortDto>();
                Session["TotalPaginas"] = 0;
                lblCantidadResultados.Text = "Error al cargar publicaciones.";
            }
        }

        private void MostrarPublicaciones()
        {
            // ❗️ CORRECCIÓN 3: La Sesión contiene una lista de 'publicacionShortDto'
            var publicaciones = Session["Publicaciones"] as List<publicacionShortDto>;
            if (publicaciones == null) return;

            rptPublicaciones.DataSource = publicaciones;
            rptPublicaciones.DataBind();

            lblCantidadResultados.Text = $"Mostrando {publicaciones.Count} resultados";

            int totalPaginas = Session["TotalPaginas"] != null ? (int)Session["TotalPaginas"] : 1;
            GenerarPaginacion(totalPaginas);
        }

        protected void rptPublicaciones_ItemDataBound(object sender, RepeaterItemEventArgs e)
        {
            if (e.Item.ItemType == ListItemType.Item || e.Item.ItemType == ListItemType.AlternatingItem)
            {
                // ❗️ CORRECCIÓN 4: ¡El error más crítico!
                // El DataItem es un 'publicacionShortDto', no 'publicacionDto'.
                var pub = e.Item.DataItem as publicacionShortDto;
                if (pub == null) return;

                // Ahora usamos las propiedades planas del 'publicacionShortDto'
                // (Asegúrate que tu DTO tenga 'EstadoNombre' y 'FechaEnvio' como planeamos)
                string estado = pub.EstadoNombre;

                // 1. Configurar el color
                Label lblEstado = e.Item.FindControl("lblEstado") as Label;
                if (lblEstado != null)
                {
                    lblEstado.CssClass = $"{GetEstadoColor(estado)} badge p-2 me-2";
                }

                // 2. Habilitar CheckBox
                CheckBox chkSeleccion = e.Item.FindControl("chkSeleccion") as CheckBox;
                if (chkSeleccion != null)
                {
                    // La lógica funciona porque 'estado' es el nombre (ej: "Aceptado")
                    chkSeleccion.Enabled = (estado == "Aceptado" || estado == "Borrador");
                }

                Button btnRevisar = e.Item.FindControl("btnRevisar") as Button;
                if (btnRevisar != null)
                {
                    btnRevisar.Visible = (estado == "Borrador");
                }
            }
        }

        protected void ddlEstados_SelectedIndexChanged(object sender, EventArgs e)
        {
            PaginaActual = 1;
            CargarPublicacionesDesdeBackend();
            MostrarPublicaciones();
        }

        protected void BtnPagina_Click(object sender, EventArgs e)
        {
            var btn = (Button)sender;
            if (int.TryParse(btn.CommandArgument, out int pagina))
            {
                PaginaActual = pagina;
                CargarPublicacionesDesdeBackend();
                MostrarPublicaciones();
            }
        }

        protected void btnEditar_Click(object sender, EventArgs e)
        {
            foreach (RepeaterItem item in rptPublicaciones.Items)
            {
                CheckBox chk = item.FindControl("chkSeleccion") as CheckBox;
                HiddenField hdnId = item.FindControl("hdnPublicacionId") as HiddenField;

                if (chk != null && chk.Checked && hdnId != null)
                {
                    if (int.TryParse(hdnId.Value, out int id))
                    {
                        Session["EditarPublicacionId"] = id; 
                        Response.Redirect(ResolveUrl("../PublicacionDelUsuario/Publicar.aspx"));
                        return;
                    }
                }
            }
        }

        protected void btnConfirmarEliminar_Click(object sender, EventArgs e)
        {
            List<int> idsEliminar = new List<int>();

            foreach (RepeaterItem item in rptPublicaciones.Items)
            {
                CheckBox chk = item.FindControl("chkSeleccion") as CheckBox;
                HiddenField hdnId = item.FindControl("hdnPublicacionId") as HiddenField;

                if (chk != null && chk.Checked && hdnId != null)
                {
                    if (int.TryParse(hdnId.Value, out int id))
                    {
                        idsEliminar.Add(id);
                    }
                }
            }

            if (idsEliminar.Count > 0)
            {
                foreach (var id in idsEliminar)
                {
                    publicacionSoap.cambiarEstadoPublicacion(id, Session["nombreUsuario"].ToString, "Eliminada");
                }

                CargarPublicacionesDesdeBackend();
                MostrarPublicaciones();
            }

            ScriptManager.RegisterStartupScript(this, GetType(), "HideModal", "var myModalEl = document.getElementById('modalEliminar'); var modal = bootstrap.Modal.getInstance(myModalEl); if(modal) { modal.hide(); }", true);
        }

        private void GenerarPaginacion(int totalPaginas)
        {
            phPaginacion.Controls.Clear();
            for (int i = 1; i <= totalPaginas; i++)
            {
                Button btnPagina = new Button
                {
                    Text = i.ToString(),
                    CssClass = i == PaginaActual ? "btn btn-dark btn-sm me-1" : "btn btn-outline-dark btn-sm me-1",
                    CommandArgument = i.ToString(),
                    ID = "btnPagina_" + i
                };
                btnPagina.Click += BtnPagina_Click;
                phPaginacion.Controls.Add(btnPagina);
            }
        }

        protected void BtnRevisar_Click(object sender, EventArgs e)
        {
            if (!int.TryParse(((Button)sender).CommandArgument, out int id)) return;

            Session["EditarPublicacionId"] = id;
            Response.Redirect(ResolveUrl("../PublicacionDelUsuario/Publicar.aspx"));
        }

        protected void btnCrear_Click(object sender, EventArgs e)
        {
            Session["EditarPublicacionId"] = -1;
            Response.Redirect("../PublicacionDelUsuario/Publicar.aspx");
        }

        protected string GetEstadoColor(string estado)
        {
            string color;
            switch (estado)
            {
                case "Aceptado": color = "bg-success text-white"; break;
                case "Rechazado": color = "bg-danger text-white"; break;
                case "Pendiente": color = "bg-warning text-dark"; break;
                case "Borrador": color = "bg-primary text-white"; break;
                default: color = "bg-secondary text-white"; break;
            }
            return color;
        }
    }
}