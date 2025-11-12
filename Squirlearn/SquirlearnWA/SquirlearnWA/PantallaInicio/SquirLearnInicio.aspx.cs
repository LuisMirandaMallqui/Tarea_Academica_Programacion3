using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class SquirLearnInicio : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

            if (!IsPostBack)
            {
                // Llamar al método que lista las categorías (por ahora simuladas)
                List<CategoriaDTO> categorias = ObtenerCategorias();

                // Enlazar al control Repeater o DataList (por ejemplo: rptCategorias)
                rptCategorias.DataSource = categorias;
                rptCategorias.DataBind();
            }

        }

        protected void rptCategorias_ItemCommand(object source, System.Web.UI.WebControls.RepeaterCommandEventArgs e)
        {
            if (e.CommandName == "VerCategoria")
            {
                // Guardar el ID en Session
                Session["idCategoria"] = e.CommandArgument.ToString();

                // Obtener el nombre desde el control literal o label dentro del Repeater
                string nombreCategoria = ((Label)e.Item.FindControl("lblNombreCategoria")).Text;
                Session["Nombre"] = nombreCategoria;

                // Redirigir a la página de categoría
                Response.Redirect("Categoria.aspx");
            }
        }

        protected void btnBuscar_Click(object sender, EventArgs e)
        {

        }
        protected void btnMostrarFiltro_Click(object sender, EventArgs e)
        {
            pnlFiltro.Visible = !pnlFiltro.Visible;
        }
        protected void btnFiltrar_Click(object sender, EventArgs e)
        {
            string busqueda = txtBuscar.Text.Trim();
            string categoria = ddlCategoria.SelectedValue;
            string tipo = rblVentaAlquiler.SelectedValue;
            string estado = rblEstado.SelectedValue;
            string tamano= RadioButtonList1.SelectedValue;

            // Ejemplo: llamar a tu BO para obtener resultados
           // var resultados = miBO.BuscarProductos(busqueda, categoria, tipo, estado);
           /*
            if (resultados.Count == 0)
            {
                lblNoResultados.Text = "No se encontraron coincidencias";
                gvResultados.DataSource = null;
                gvResultados.DataBind();
            }
            else
            {
                lblNoResultados.Text = "";
                gvResultados.DataSource = resultados;
                gvResultados.DataBind();
            }
           */
        }
        protected void btnLimpiar_Click(object sender, EventArgs e)
        {
            txtBuscar.Text = "";
            ddlCategoria.SelectedIndex = 0;
            rblVentaAlquiler.SelectedIndex = 0;
            rblEstado.SelectedIndex = 0;
            gvResultados.DataSource = null;
            gvResultados.DataBind();
        }
    }
}