using SquirlearnWA.estadoPublicacionSOAP;
using SquirlearnWA.publicacionSOAP;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class ListadoPublicaciones : System.Web.UI.Page
    {
        private PublicacionClient publicacionSoap;
        private EstadoPublicacionClient estadoPublicacionSoap;
        private const int PublicacionesPorPagina = 3;


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
              
                listadoPublicacionGestionDto listadoDePublicacionesPorPaginacion = publicacionSoap.obtenerListaPublicacionGestion(
                    (int)Session["UsuarioId"],
                    PublicacionesPorPagina,
                    PaginaActual,
                    filtroEstado // Ahora SÍ es un 'int'
                );




                // Convertir a List por seguridad
                Session["Publicaciones"] = listadoDePublicacionesPorPaginacion.lista.ToList();
                Session["TotalRegistros"] = listadoDePublicacionesPorPaginacion.totalPaginas; // ❗️ almacenar total de registros
                Session["TotalPaginas"] = (int)Math.Ceiling((double)listadoDePublicacionesPorPaginacion.totalPaginas / PublicacionesPorPagina);
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
            int total = Convert.ToInt32(Session["TotalRegistros"]);
            if (publicaciones == null) return;

            rptPublicaciones.DataSource = publicaciones;
            rptPublicaciones.DataBind();

           
            lblCantidadResultados.Text = $"Se encontraron {total} publicaciones.";

            int totalPaginas = Session["TotalPaginas"] != null ? (int)Session["TotalPaginas"] : 1;
            lblPagina.Text = $"Página {PaginaActual} de {totalPaginas}";

            btnAnterior.Enabled = PaginaActual > 1;
            btnSiguiente.Enabled = PaginaActual < totalPaginas;
        }

        protected void rptPublicaciones_ItemDataBound(object sender, RepeaterItemEventArgs e)
        {
            if (e.Item.ItemType == ListItemType.Item || e.Item.ItemType == ListItemType.AlternatingItem)
            {
                // Obtener el DTO
                var pub = e.Item.DataItem as publicacionShortDto;
                if (pub == null) return;

                string estado = pub.estadoNombre; // Nombre del estado

                // Checkbox
                CheckBox chkSeleccion = e.Item.FindControl("chkSeleccion") as CheckBox;
                if (chkSeleccion != null)
                {
                    // Solo habilitar y mostrar para Borrador o Aceptado
                    if (estado == "Borrador" || estado == "Aceptado")
                        chkSeleccion.Visible = true;
                    else
                        chkSeleccion.Visible = false;
                }

                // Botón Revisar (si quieres, lo puedes controlar también)
                Button btnRevisar = e.Item.FindControl("btnRevisar") as Button;
                if (btnRevisar != null)
                {
                    btnRevisar.Visible = (estado == "Borrador");
                }

                // Etiqueta de estado (si quieres cambiar colores)
                Label lblEstado = e.Item.FindControl("lblEstado") as Label;
                if (lblEstado != null)
                {
                    lblEstado.CssClass = $"{GetEstadoColor(estado)} badge p-2 me-2";
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
                    // Cambiar estado a Eliminada vía SOAP
                    publicacionSoap.cambiarEstadoPublicacion(id, Session["nombreUsuario"].ToString(), "Eliminada");
                }

                // Actualizar listado
                CargarPublicacionesDesdeBackend();

                // Actualizar cantidad total
                int total = Convert.ToInt32(Session["TotalRegistros"]);
                total -= idsEliminar.Count;
                Session["TotalRegistros"] = total;

                MostrarPublicaciones();
            }

            // Cerrar modal
            ScriptManager.RegisterStartupScript(this, GetType(), "HideModal", "var myModalEl = document.getElementById('modalEliminar'); var modal = bootstrap.Modal.getInstance(myModalEl); if(modal) { modal.hide(); }", true);
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
                case "Aprobado": color = "bg-success text-white"; break;
                case "Rechazado": color = "bg-danger text-white"; break;
                case "Pendiente": color = "bg-warning text-dark"; break;
                case "Borrador": color = "bg-primary text-white"; break;
                case "Transaccionada": color = "bg-success text-white"; break;
                case "Eliminada": color = "bg-danger text-white"; break;
                default: color = "bg-secondary text-white"; break;
            }
            return color;
        }
        protected void btnAnterior_Click(object sender, EventArgs e)
        {
            if (PaginaActual > 1)
            {
                PaginaActual--;
                CargarPublicacionesDesdeBackend();
                MostrarPublicaciones();
            }
        }

        protected void btnSiguiente_Click(object sender, EventArgs e)
        {
            if (PaginaActual < (Session["TotalPaginas"] != null ? (int)Session["TotalPaginas"] : 1))
            {
                PaginaActual++;
                CargarPublicacionesDesdeBackend();
                MostrarPublicaciones();
            }
        }
    }
}