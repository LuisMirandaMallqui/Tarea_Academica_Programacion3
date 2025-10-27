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
            }
        }
        public class Notificacion
        {
            public string Mensaje { get; set; }
            public DateTime Fecha { get; set; }
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
            Response.Redirect("~/Perfil.aspx");
        }
    }
}