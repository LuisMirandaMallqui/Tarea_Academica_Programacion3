using SquirlearnWA.incidenciaSOAP;
using SquirlearnWA.motivoSOAP;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class RegistrarIncidencia : System.Web.UI.Page
    {

        private IncidenciaClient incidenciaSOAP;
        private MotivoClient motivoSOAP;



        public RegistrarIncidencia()
        {

            incidenciaSOAP = new IncidenciaClient();
            motivoSOAP = new MotivoClient();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                CargarMotivos();
            }

        }

        private void CargarMotivos()
        {

            var lista = motivoSOAP.listarTodosMotivo(); // List<motivoDto>

            ddlTipoIncidencia.DataSource = lista;
            ddlTipoIncidencia.DataTextField = "nombre";     // Lo que se muestra
            ddlTipoIncidencia.DataValueField = "motivoId";  // El ID real
            ddlTipoIncidencia.DataBind();

            ddlTipoIncidencia.Items.Insert(0, new ListItem("Seleccionar...", ""));


        }



        protected void btnEnviar_Click(object sender, EventArgs e)
        {
            string mensaje = txtIncidencia.Text.Trim();
            int usuarioId = Convert.ToInt32(Session["UsuarioId"]);
            string usuarioNombre = Session["nombreUsuario"].ToString();

            if (!string.IsNullOrEmpty(mensaje) && !string.IsNullOrEmpty(ddlTipoIncidencia.SelectedValue))
            {
                int motivoId = Convert.ToInt32(ddlTipoIncidencia.SelectedValue);

                // GUARDAR INCIDENCIA
                incidenciaSOAP.insertarIncidencia(mensaje,"-",usuarioId, motivoId,0, usuarioNombre); //ELIMINAR NOTIFICACION ID  DE LA BD

                // Mostrar modal
                ScriptManager.RegisterStartupScript(this, GetType(), "mostrarModal", "mostrarModalConfirmacion();", true);

                // Limpiar texto
                txtIncidencia.Text = "";
                ddlTipoIncidencia.SelectedIndex = 0;
            }
            else
            {

                ScriptManager.RegisterStartupScript(
                                this,
                                GetType(),
                                "modalErrorMotivo",
                                "mostrarModalErrorMotivo();",
                                true
                            );
            }
        }

        protected void btnContinuar_Click(object sender, EventArgs e)
        {
            Response.Redirect("../PantallaInicio/SquirLearnInicio.aspx");
        }
        protected void btnVolver_Click(object sender, EventArgs e)
        {
            Response.Redirect("../PantallaInicio/SquirlearnInicio.aspx");
        }
    }
}