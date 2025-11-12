using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA.MasterPages
{
    public partial class SquirLearn : System.Web.UI.MasterPage
    {
        protected void Page_Load(object sender, EventArgs e)
        {

            if (Session["Rol"] != null)
            {
                if (Session["Rol"].ToString() == "Administrador")
                {
                    // Mostrar o habilitar opciones especiales
                    menuAdmin.Visible = true;
                }
                else
                {
                    menuAdmin.Visible = false;
                }
            }


   }      }
}