using SquirlearnWA.notificacionSOAP;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;


namespace SquirlearnWA
{
    ppublic partial class Notificaciones : System.Web.UI.Page
    {
        private NotificacionClient notificacionSOAP;
        private const int RegistrosPorPagina = 4;

        public Notificaciones()
        {
            notificacionSOAP = new NotificacionClient();
        }

        private int PaginaActual
        {
            get => ViewState["PaginaActual"] != null ? (int)ViewState["PaginaActual"] : 0;
            set => ViewState["PaginaActual"] = value;
        }

        private int TotalPaginas
        {
            get => ViewState["TotalPaginas"] != null ? (int)ViewState["TotalPaginas"] : 0;
            set => ViewState["TotalPaginas"] = value;
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                PaginaActual = 0;
                CargarNotificaciones();
            }
        }

        private void CargarNotificaciones()
        {
            int usuarioId = Convert.ToInt32(Session["UsuarioId"]);


            int pagina = PaginaActual + 1;
            int registrosPorPagina = RegistrosPorPagina;

            listadoNotificacionesDto resultado = notificacionSOAP.listarPorPersonaNotificacion(usuarioId, pagina, registrosPorPagina);


            if (resultado?.lista != null && resultado.lista.Length > 0)
            {
                rptNotificaciones.DataSource = resultado.lista;
                rptNotificaciones.DataBind();

                int totalPaginas = (int)Math.Ceiling((double)resultado.totalRegistros / registrosPorPagina);
                TotalPaginas = totalPaginas;

                lblTotalResultados.Text = $"Se encontraron {resultado.totalRegistros} notificaciones.";
                lblSinResultados.Text = "";
                lblPagina.Text = $"Página {PaginaActual + 1} de {totalPaginas}";

                btnAnterior.Enabled = PaginaActual > 0;
                btnSiguiente.Enabled = PaginaActual < totalPaginas - 1;
            }
            else
            {
                rptNotificaciones.DataSource = null;
                rptNotificaciones.DataBind();
                lblTotalResultados.Text = "";
                lblSinResultados.Text = "No tienes notificaciones disponibles.";
                lblPagina.Text = "";
                btnAnterior.Enabled = false;
                btnSiguiente.Enabled = false;
            }
        }

        protected void btnAnterior_Click(object sender, EventArgs e)
        {
            if (PaginaActual > 0)
            {
                PaginaActual--;
                CargarNotificaciones();
            }
        }

        protected void btnSiguiente_Click(object sender, EventArgs e)
        {
            if (PaginaActual < TotalPaginas - 1)
            {
                PaginaActual++;
                CargarNotificaciones();
            }
        }

        protected void btnVolver_Click(object sender, EventArgs e)
        {
            Response.Redirect("../PantallaInicio/SquirlearnInicio.aspx");
        }
    }
}