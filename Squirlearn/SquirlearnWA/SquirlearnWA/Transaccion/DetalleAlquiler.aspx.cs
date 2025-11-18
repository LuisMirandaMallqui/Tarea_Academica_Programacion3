using SquirlearnWA.publicacionSOAP;
using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using static System.Net.Mime.MediaTypeNames;

namespace SquirlearnWA
{
    public partial class DetalleAlquiler : Page
    {

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {

                lblNombre.Text = Session["nombre"].ToString();
                lblPrecioDia.Text = $"Precio por día: s/. {Session["precioProducto"].ToString()} / día";
                imgProducto.ImageUrl = "https://via.placeholder.com/250";// imagen genérica por ahora... :¿


                string precioTexto = Session["precioProducto"].ToString()
                    .Replace("s/.", "")
                    .Replace("S/.", "")
                    .Replace("s/", "")
                    .Replace("S/", "")
                    .Trim();
                // Guardar el precio en ViewState
                ViewState["PrecioDia"] = Convert.ToDouble(precioTexto, CultureInfo.InvariantCulture);

                // Cálculo inicial
                double precio = Convert.ToDouble(precioTexto, CultureInfo.InvariantCulture);
                lblSubtotal.Text = precio.ToString("0.00");
                lblTotal.InnerText = $"s/. {precio:0.00}";

            }

        }

        // Botón "Volver"
        protected void btnVolver_Click(object sender, EventArgs e)
        {
            Response.Redirect("DetalleProductoAlquiler.aspx");

        }


        protected void txtFechas_TextChanged(object sender, EventArgs e)
        {
            // Limpieza inicial del mensaje de error y el cálculo de días
            lblMensajeFechas.Text = "";
            lblDiasCalculados.Text = "0";

            // 1. Obtener y validar valores de fecha
            if (!DateTime.TryParse(txtFechaInicio.Text, out DateTime fechaInicio) ||
                !DateTime.TryParse(txtFechaFin.Text, out DateTime fechaFin))
            {
                // Esto solo atrapa errores de formato si ambos están llenos
                if (!string.IsNullOrEmpty(txtFechaInicio.Text) && !string.IsNullOrEmpty(txtFechaFin.Text))
                {
                    lblMensajeFechas.Text = "Formato de fecha inválido. Inténtalo de nuevo.";
                }
                return;
            }

            // 2. Validar que la Fecha de Inicio no sea en el pasado
            DateTime hoy = DateTime.Today;
            if (fechaInicio < hoy)
            {
                // 🚨 LIMPIEZA Y ERROR: Fecha de inicio inválida
                txtFechaInicio.Text = string.Empty;
                txtFechaFin.Text = string.Empty;
                lblMensajeFechas.Text = "❌ La fecha de inicio no puede ser anterior al día de hoy.";
                return;
            }

            // 3. Validar orden de las fechas (Fin no puede ser antes de Inicio)
            if (fechaFin < fechaInicio)
            {
                // 🚨 LIMPIEZA Y ERROR: Fechas en orden incorrecto
                txtFechaInicio.Text = string.Empty;
                txtFechaFin.Text = string.Empty;
                lblMensajeFechas.Text = "❌ La fecha de fin no puede ser anterior a la fecha de inicio.";
                return;
            }

            TimeSpan diferencia = fechaFin.Subtract(fechaInicio);
            int diasAlquilerCalculado = (int)diferencia.TotalDays; // Variable local

            // 5. Aplicar la restricción máxima
            const int MAX_DIAS = 14;
            if (diasAlquilerCalculado > MAX_DIAS || diasAlquilerCalculado <= 0)
            {
                // 🚨 LIMPIEZA Y ERROR: Excede el máximo de días o es 0
                txtFechaInicio.Text = string.Empty;
                txtFechaFin.Text = string.Empty;
                lblMensajeFechas.Text = $"❌ Selecciona un periodo válido (1 a {MAX_DIAS} días). Seleccionaste {diasAlquilerCalculado} días.";

                // Restablece el ViewState a 0 en caso de error
                ViewState["DiasAlquiler"] = 0;
                return;
            }

            // 6. Si todo es válido: Guardar el resultado en ViewState y mostrarlo
            lblDiasCalculados.Text = diasAlquilerCalculado.ToString();
            ViewState["DiasAlquiler"] = diasAlquilerCalculado;

            // 7. CALCULAR Y MOSTRAR SUBTOTAL/TOTAL
            if (ViewState["PrecioDia"] != null)
            {
                // Obtenemos el precio por día guardado en Page_Load
                double precioDia = (double)ViewState["PrecioDia"];
                double subtotal = precioDia * diasAlquilerCalculado;

                // Actualizamos los labels de precio
                lblSubtotal.Text = subtotal.ToString("0.00");
                lblTotal.InnerText = $"s/. {subtotal:0.00}";
                Session["fechaInicio"] = fechaInicio.ToString("yyyy-MM-dd");
                Session["fechaFin"] = fechaFin.ToString("yyyy-MM-dd");
                Session["montoTotal"] = subtotal;
            }
        }

        protected void btnAlquilar_Click(object sender, EventArgs e)
        {
            // 1. RECUPERAR LOS DÍAS DESDE VIEWSTATE
            int diasAlquilerFinal = 0;
            if (ViewState["DiasAlquiler"] != null)
            {
                diasAlquilerFinal = (int)ViewState["DiasAlquiler"];
            }

            // TERMINOS Y CONDICIONES (Corregir la lógica de error, debe salir si no acepta)
            if (!chkAceptar.Checked)
            {
                lblErrorTerminos.Visible = true;
                return;
            }
            lblErrorTerminos.Visible = false;

            // 2. VALIDACIÓN DE DÍAS FINALES (Si el usuario no ha seleccionado fechas)
            if (diasAlquilerFinal <= 0)
            {
                // Usamos lblMensajeFechas para informar que faltan fechas válidas
                lblMensajeFechas.Text = "❌ Debes seleccionar un periodo de alquiler válido (mínimo 1 día).";
                return;
            }

            string metodo = "";
            // ... (restante código de selección de método y redirección) ...

            if (rdbTarjeta.Checked)
                metodo = "tarjeta";
            else if (rdbYape.Checked)
                metodo = "yape";

            Session["metodoPago"] = metodo;

            string nombrePagina = System.IO.Path.GetFileName(Request.Url.AbsolutePath);
            Response.Redirect("ModalPago.aspx?metodo=" + metodo + "&origen=" + nombrePagina);
        }


    }
}
