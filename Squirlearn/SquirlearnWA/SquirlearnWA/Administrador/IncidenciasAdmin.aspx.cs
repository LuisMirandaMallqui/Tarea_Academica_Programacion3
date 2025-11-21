using SquirlearnWA.personaSOAP;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA.Administrador
{
    public partial class IncidenciasAdmin : System.Web.UI.Page
    {
        private IncidenciaClient incidenciaSOAP;
        private MotivoClient motivoSOAP;
        private PersonaClient personaSOAP;
        public IncidenciasAdmin()
        {

            incidenciaSOAP = new IncidenciaClient();
            motivoSOAP = new MotivoClient();
            personaSOAP = new PersonaClient();


        }

        protected void Page_Load(object sender, EventArgs e)
        {

            if (!IsPostBack)
            {
                CargarIncidencias();


            }

        }

        protected void ddlEstado_SelectedIndexChanged(object sender, EventArgs e)
        {
            CargarIncidencias();
        }

        private void CargarIncidencias()
        {


            List<incidenciaDto> incidencia = incidenciaSOAP.listarTodasIncidencias().ToList();
            // 🔹 FILTRO POR ESTADO
            if (!string.IsNullOrEmpty(ddlEstado.SelectedValue))
            {
                bool estado = Convert.ToBoolean(ddlEstado.SelectedValue);
                incidencia = incidencia
             .Where(x => (x.resuelto == 1) == estado)
             .ToList();
            }

            rptIncidencias.DataSource = incidencia;
            rptIncidencias.DataBind();

        }




        protected void rptIncidencias_ItemDataBound(object sender, RepeaterItemEventArgs e)
        {
            if (e.Item.ItemType == ListItemType.Item || e.Item.ItemType == ListItemType.AlternatingItem)
            {
                var incidencia = (incidenciaDto)e.Item.DataItem;


                int idMotivo = incidencia.motivo.motivoId;
                int idPersona = incidencia.persona.personaId;


                var motivo = motivoSOAP.obtenerPorIdMotivo(idMotivo);
                var usuario = personaSOAP.obtenerPorIdPersona(idPersona);


                var lblMotivo = (Label)e.Item.FindControl("lblMotivo");
                var lblUsuario = (Label)e.Item.FindControl("lblUsuario");

                lblMotivo.Text = motivo.nombre;
                lblUsuario.Text = usuario.nombres + ' ' + usuario.primerApellido + ' ' + usuario.segundoApellido;
            }
        }

    }

}
}