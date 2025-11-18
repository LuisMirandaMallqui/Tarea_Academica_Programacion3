using SquirlearnWA.notificacionSOAP;
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
        private NotificacionClient notificacionSOAP;
        private const int RegistrosPorPagina = 10;

        public Notificaciones()
        {
            notificacionSOAP = new NotificacionClient();
        }

        private List<notificacionDto> ListaNotificaciones
        {
            get => ViewState["ListaNotificaciones"] as List<notificacionDto>;
            set => ViewState["ListaNotificaciones"] = value;
        }

        private int PaginaActual
        {
            get => ViewState["PaginaActual"] != null ? (int)ViewState["PaginaActual"] : 0;
            set => ViewState["PaginaActual"] = value;
        }

        // ❗️ CORRECCIÓN DE BUG 1: Añadido para guardar el total de páginas
        private int TotalPaginas
        {
            get => ViewState["TotalPaginas"] != null ? (int)ViewState["TotalPaginas"] : 0;
            set => ViewState["TotalPaginas"] = value;
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // (Ya no se selecciona el ddlOrden)
                PaginaActual = 0;
                CargarNotificaciones();
            }
        }

        private void CargarNotificaciones()
        {
            int usuarioId = Convert.ToInt32(Session["UsuarioId"]);
            int pagina = PaginaActual;
            int registrosPorPagina = RegistrosPorPagina;

            ListadoNotificacionesDTO resultado = notificacionSOAP.listarPorPersonaNotificacion(usuarioId, pagina, registrosPorPagina);//modificar

            if (resultado?.Lista != null && resultado.Lista.Count > 0)
            {
                // ❗️ CAMBIO 1: Lógica de ordenamiento eliminada
                // (El backend ahora lo hace por nosotros)
                ListaNotificaciones = resultado.Lista;

                lblTotalResultados.Text = $"Se encontraron {resultado.TotalRegistros} notificaciones.";
                lblSinResultados.Text = "";
                MostrarPagina(resultado.TotalRegistros);
            }
            else
            {
                rptNotificaciones.DataSource = null;
                rptNotificaciones.DataBind();
                lblTotalResultados.Text = "";
                lblSinResultados.Text = "No tienes notificaciones disponibles.";
            }
        }

        private void MostrarPagina(int totalRegistros)
        {
            if (ListaNotificaciones == null || ListaNotificaciones.Count == 0)
                return;

            int totalPaginas = (int)Math.Ceiling((double)totalRegistros / RegistrosPorPagina);

            // ❗️ CORRECCIÓN DE BUG 1 (Continuación): Guardamos el total de páginas
            TotalPaginas = totalPaginas;

            rptNotificaciones.DataSource = ListaNotificaciones;
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