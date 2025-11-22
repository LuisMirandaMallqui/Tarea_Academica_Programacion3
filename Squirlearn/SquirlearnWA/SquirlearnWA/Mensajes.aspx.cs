using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class Mensajes : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Más adelante aquí se cargarán los chats desde la BD.
                // Por ahora, solo simula la carga inicial.
            }
        }
    }
}