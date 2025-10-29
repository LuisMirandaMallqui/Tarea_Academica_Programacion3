using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class Publicar : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Cargar categorías desde la BD en el futuro (por ahora es estático)
            }
        }

        protected void btnCancelar_Click(object sender, EventArgs e)
        {
            Response.Redirect("SquirLearnInicio.aspx");
        }

        protected void btnSiguiente_Click(object sender, EventArgs e)
        {
            // Validar campos básicos
            if (string.IsNullOrWhiteSpace(txtNombre.Text) ||
                string.IsNullOrWhiteSpace(txtDescripcion.Text) ||
                string.IsNullOrWhiteSpace(txtPrecio.Text) ||
                ddlCategoria.SelectedValue == "")
            {
                // En un entorno real: mostrar alerta visual
                Response.Write("<script>alert('Por favor completa todos los campos obligatorios.');</script>");
                return;
            }

            // Guardar la imagen (si se subió)
            string imagenUrl = "";
            if (fuImagen.HasFile)
            {
                string fileName = Path.GetFileName(fuImagen.FileName);
                string savePath = Server.MapPath("~/Imagenes/") + fileName;
                fuImagen.SaveAs(savePath);
                imagenUrl = "~/Imagenes/" + fileName;
            }

            // Crear una “publicación temporal” en sesión
            Session["PublicacionNombre"] = txtNombre.Text;
            Session["PublicacionDescripcion"] = txtDescripcion.Text;
            Session["PublicacionPrecio"] = txtPrecio.Text;
            Session["PublicacionTipo"] = rblTipo.SelectedValue;
            Session["PublicacionCategoria"] = ddlCategoria.SelectedItem.Text;
            Session["PublicacionPeriodo"] = txtPeriodo.Text;
            Session["PublicacionImagen"] = imagenUrl;

            // Redirigir a la pantalla de confirmación
            Response.Redirect("PublicacionConfirmacion.aspx");
        }
    }
}