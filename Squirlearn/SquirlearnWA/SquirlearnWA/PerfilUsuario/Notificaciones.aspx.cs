using SoftInvBusiness;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class Notificaciones : System.Web.UI.Page
    {

        private NotificacionBO notificacionBO = new NotificacionBO();
        private const int RegistrosPorPagina = 5;

        private List<NotificacionDTO> ListaNotificaciones
        {
            get => ViewState["ListaNotificaciones"] as List<NotificacionDTO>;
            set => ViewState["ListaNotificaciones"] = value;
        }

        private int PaginaActual
        {
            get => ViewState["PaginaActual"] != null ? (int)ViewState["PaginaActual"] : 0;
            set => ViewState["PaginaActual"] = value;
        }


        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // ✅ Aquí se simulan las notificaciones, pero tú luego
                // las puedes traer desde tu base de datos o lógica de negocio.
                //  List<Notificacion> notificaciones = ObtenerNotificaciones();

                // Asignar el listado al Repeater
                //rptNotificaciones.DataSource = notificaciones;
                //rptNotificaciones.DataBind();
                ddlOrden.SelectedValue = "desc";
                PaginaActual = 0;
                CargarNotificaciones();
            }
        }
        private void CargarNotificaciones()
        {
            int usuarioId = Convert.ToInt32(Session["UsuarioId"]);
            string orden = ddlOrden.SelectedValue;

            List<NotificacionDTO> lista = notificacionBO.ObtenerPorUsuario(usuarioId);

            if (orden == "desc")
                lista = lista.OrderByDescending(n => n.Fecha).ToList();
            else
                lista = lista.OrderBy(n => n.Fecha).ToList();

            if (lista != null && lista.Count > 0)
            {
                ListaNotificaciones = lista;
                lblTotalResultados.Text = $"Se encontraron {lista.Count} notificaciones.";
                lblSinResultados.Text = "";
                MostrarPagina();
            }
            else
            {
                rptNotificaciones.DataSource = null;
                rptNotificaciones.DataBind();
                lblTotalResultados.Text = "";
                lblSinResultados.Text = "No tienes notificaciones disponibles.";
            }
        }
        private void MostrarPagina()
        {
            if (ListaNotificaciones == null || ListaNotificaciones.Count == 0)
                return;

            int totalPaginas = (int)Math.Ceiling((double)ListaNotificaciones.Count / RegistrosPorPagina);
            int inicio = PaginaActual * RegistrosPorPagina;
            int fin = Math.Min(inicio + RegistrosPorPagina, ListaNotificaciones.Count);

            var pagina = ListaNotificaciones.GetRange(inicio, fin - inicio);

            rptNotificaciones.DataSource = pagina;
            rptNotificaciones.DataBind();

            lblPagina.Text = $"Página {PaginaActual + 1} de {totalPaginas}";
            btnAnterior.Enabled = PaginaActual > 0;
            btnSiguiente.Enabled = PaginaActual < totalPaginas - 1;
        }
        protected void btnAnterior_Click(object sender, EventArgs e)
        {
            if (PaginaActual > 0)
            {
                PaginaActual--;
                MostrarPagina();
            }
        }

        protected void btnSiguiente_Click(object sender, EventArgs e)
        {
            int totalPaginas = (int)Math.Ceiling((double)ListaNotificaciones.Count / RegistrosPorPagina);
            if (PaginaActual < totalPaginas - 1)
            {
                PaginaActual++;
                MostrarPagina();
            }
        }

        protected void btnFiltrar_Click(object sender, EventArgs e)
        {
            PaginaActual = 0;
            CargarNotificaciones();
        }


        /*
        private List<Notificacion> ObtenerNotificaciones()
        {
            return new List<Notificacion>
            {
                new Notificacion { Mensaje = "Tienes una nueva solicitud de amistad.", Fecha = DateTime.Now.AddMinutes(-10) },
                new Notificacion { Mensaje = "Tu publicación recibió un nuevo comentario.", Fecha = DateTime.Now.AddHours(-2) },
                new Notificacion { Mensaje = "Tu curso 'Matemáticas Avanzadas' fue aprobado.", Fecha = DateTime.Now.AddDays(-1) },
                new Notificacion { Mensaje = "Nuevo material disponible en 'Física II'.", Fecha = DateTime.Now.AddDays(-3) }
                
               
            };
        }
       */
        protected void btnVolver_Click(object sender, EventArgs e)
        {
            Response.Redirect("../PerfilUsuario/Perfil.aspx");
        }
    }
}