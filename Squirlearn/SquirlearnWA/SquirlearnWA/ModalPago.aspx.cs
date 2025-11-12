using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class ModalPago : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                string metodo = Request.QueryString["metodo"];

                if (metodo == "tarjeta")
                {
                    tarjetaModal.Visible = true;
                    yapeModal.Visible = false;
                }
                else if (metodo == "yape")
                {
                    tarjetaModal.Visible = false;
                    yapeModal.Visible = true;
                }
            }

        }

        protected void btnVolver_Click(object sender, EventArgs e)
        {
            string origen = Request.QueryString["origen"];
            Response.Redirect(origen);
        }

        protected void btnConfirmar(object sender, EventArgs e)
        {


            string numTarjeta = txtNumeroTarjeta?.Text?.Trim(); // si existe control server
            string numYape = txtNumeroYape?.Text?.Trim();
            if(!IsDigitsOnly(numTarjeta) && !IsDigitsOnly(numYape))
            {
                Session["PagoError"]="Ha ocurrido un error con el método de pago. Inténtelo de nuevo.";
            }
            string origen = Request.QueryString["origen"];
            Response.Redirect("QuillaTip.aspx?origen="+ Server.UrlEncode(origen));


        }
        private bool IsDigitsOnly(string input)
        {
            // Retorna true si no está vacío y contiene solo dígitos
            return  System.Text.RegularExpressions.Regex.IsMatch(input, @"^\d+$");
        }
    }
}