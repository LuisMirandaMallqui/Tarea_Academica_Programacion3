using SquirlearnWA.categoriaSOAP;
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

        private CategoriaClient categoriaSoap;

        public SquirLearnInicio()
        {
            categoriaSoap = new CategoriaClient();
        }

        protected void Page_Load(object sender, EventArgs e)
        {

            if (!IsPostBack)
            {
                // Llamar al método que lista las categorías (por ahora simuladas)
                List<categoriaDto> listaCategorias = categoriaSoap.listarTodosCategoria().ToList();

                // Enlazar al control Repeater o DataList (por ejemplo: rptCategorias)
                rptCategorias.DataSource = listaCategorias;
                rptCategorias.DataBind();
            }

        }

        protected void rptCategorias_ItemCommand(object source, System.Web.UI.WebControls.RepeaterCommandEventArgs e)
        {
            if (e.CommandName == "VerCategoria")
            {
                // Guardar el ID en Session
                Session["idCategoria"] = int.Parse(e.CommandArgument.ToString());

                // Obtener el nombre desde el control literal o label dentro del Repeater
                string nombreCategoria = ((Label)e.Item.FindControl("lblNombreCategoria")).Text;
                Session["Nombre"] = nombreCategoria;

                // Redirigir a la página de categoría
                Response.Redirect("Busqueda.aspx");
            }
        }

        protected void btnBusqueda_Click(object sender, EventArgs e)
        {
            Session["idCategoria"] = null;
            Response.Redirect("Busqueda.aspx");
        }

    }
}