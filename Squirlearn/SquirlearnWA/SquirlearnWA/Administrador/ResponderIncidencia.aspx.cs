using SquirlearnWA.notificacionSOAP;
using SquirlearnWA.personaSOAP;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA.Administrador
{
    public partial class ResponderIncidencia : System.Web.UI.Page
    {
        private IncidenciaClient incidenciaSOAP;
        private NotificacionClient notificacionSOAP;

        private PersonaClient personaSOAP;
        private MotivoClient motivoSOAP;
        public ResponderIncidencia()
        {


            incidenciaSOAP = new IncidenciaClient();
            notificacionSOAP = new NotificacionClient();
            personaSOAP = new PersonaClient();
            motivoSOAP = new MotivoClient();

        }

        protected void Page_Load(object sender, EventArgs e)
        {


            if (!IsPostBack)
            {
                if (Request.QueryString["id"] != null)
                {
                    int id = int.Parse(Request.QueryString["id"]);
                    CargarIncidencia(id);
                }
            }

        }
        private void CargarIncidencia(int id)
        {


            // Llamada a tu backend SOAP
            var incidencia = incidenciaSOAP.obtenerPorIdIncidencia(id);
            var persona = personaSOAP.obtenerPorIdPersona(incidencia.persona.personaId);
            var motivo = motivoSOAP.obtenerPorIdMotivo(incidencia.motivo.motivoId);

            bool esResuelta = incidencia.resuelto == 1;
            if (esResuelta)
            {
                // Todos los campos en ReadOnly
                txtRespuesta.ReadOnly = true;
                txtRespuesta.CssClass = "form-control readonly";

                ddlEstado.Enabled = false;

                btnGuardar.Visible = false; // Ocultar botón Guardar
            }
            else
            {
                // Pendiente → editable
                txtRespuesta.ReadOnly = false;
                ddlEstado.Enabled = true;
                btnGuardar.Visible = true;
            }



            Session["IdIncidencia"] = id;
            Session["IdUsuario"] = persona.personaId;
            Session["IdMotivo"] = motivo.motivoId;
            Session["DescripcionIncidencia"] = incidencia.descripcion;
            Session["NombrePersona"] = persona.nombres + ' ' + persona.primerApellido + ' ' + persona.segundoApellido;
            // Llenas los campos
            txtID.Text = persona.nombres + ' ' + persona.primerApellido + ' ' + persona.segundoApellido;
            txtDescripcion.Text = incidencia.descripcion;
            txtCorreo.Text = persona.correo;
            txtMotivo.Text = motivo.nombre;
            ddlEstado.SelectedValue = incidencia.resuelto == 1 ? "Resuelta" : "Pendiente";
        }

        protected void btnVolver_Click(object sender, EventArgs e)
        {
            Response.Redirect("IncidenciasAdmin.aspx");
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {

            string respuesta = txtRespuesta.Text.Trim();
            string nuevoEstado = ddlEstado.SelectedValue;
            int estado;
            if (nuevoEstado == "Pendinte")
            {
                estado = 0;

            }
            else
            {

                estado = 1;
            }

            int idIncidencia = Convert.ToInt32(Session["IdIncidencia"]);
            int idUsuario = Convert.ToInt32(Session["IdUsuario"]);
            string fechaRespuesta = DateTime.Now.ToString("yyyy-MM-dd");
            int idMotivo = Convert.ToInt32(Session["IdMotivo"]);
            string nombre = Session["NombrePersona"].ToString();
            string descripcion = Session["DescripcionIncidencia"].ToString();




            incidenciaSOAP.modificarIncidencia(idIncidencia, descripcion, 1, idUsuario, idMotivo, estado, 1, nombre);



            notificacionSOAP.insertarNotificacion(respuesta, idUsuario, fechaRespuesta);



            // Puedes redirigir de nuevo a la lista
            Response.Redirect("IncidenciasAdmin.aspx");
        }
    }

}
}