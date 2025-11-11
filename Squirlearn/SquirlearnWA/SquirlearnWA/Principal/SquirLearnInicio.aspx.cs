using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA.Principal
{
    public partial class SquirLearnInicio : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                CargarFiltros();
            }
        }

        private void CargarFiltros()
        {
            //// Categorías
            //var categorias = CategoriaBo.Listar();
            //CargarDropDownList(ddlCategoria, categorias, "Nombre", "Id");

            //// Subcategorías
            //var subcategorias = SubcategoriaBo.Listar();
            //CargarDropDownList(ddlSubcategoria, subcategorias, "Nombre", "Id");

            //// Colores
            //var colores = ColorBo.Listar();
            //CargarDropDownList(ddlColor, colores, "Nombre", "Id");

            //// Tamaños
            //var tamanos = TamanoBo.Listar();
            //CargarRadioButtonList(rblTamano, tamanos, "Nombre", "Id");

            //// Formatos
            //var formatos = FormatoBo.Listar();
            //CargarRadioButtonList(rblFormato, formatos, "Nombre", "Id");

            //// Condiciones
            //var condiciones = CondicionBo.Listar();
            //CargarRadioButtonList(rblCondicion, condiciones, "Nombre", "Id");

            //// Estado 
            //var estados = EstadoBo.Listar();
            //CargarRadioButtonList(rblEstado, estados, "Nombre", "Id");
        }

        private void CargarDropDownList(DropDownList ddl, object dataSource, string textField, string valueField)
        {
            ddl.DataSource = dataSource;
            ddl.DataTextField = textField;
            ddl.DataValueField = valueField;
            ddl.DataBind();
            ddl.Items.Insert(0, new ListItem("Ninguno", ""));
        }

        private void CargarRadioButtonList(RadioButtonList rbl, object dataSource, string textField, string valueField)
        {
            rbl.DataSource = dataSource;
            rbl.DataTextField = textField;
            rbl.DataValueField = valueField;
            rbl.DataBind();
            rbl.Items.Insert(0, new ListItem("Ninguno", ""));
        }


        protected void btnBuscar_Click(object sender, EventArgs e)
        {
            BuscarProductos();
        }

        protected void btnFiltrar_Click(object sender, EventArgs e)
        {
            BuscarProductos();
        }

        protected void btnLimpiar_Click(object sender, EventArgs e)
        {
            txtBuscar.Text = "";
            ddlCategoria.SelectedIndex = 0;
            rbVenta.Checked = false;
            rbAlquiler.Checked = false;
            rblEstado.ClearSelection();
            rblCondicion.ClearSelection();
            rblFormato.ClearSelection();
            rblTamano.ClearSelection();
            ddlColor.SelectedIndex = 0;

            // Recargar sin filtros
            BuscarProductos();
        }

        private void BuscarProductos()
        {
            string terminoBusqueda = txtBuscar.Text.Trim() ?? "";
            string tipoTransaccion = rbVenta.Checked ? "Venta" : rbAlquiler.Checked ? "Alquiler" : "";
            string categoriaId = ddlCategoria.SelectedValue ?? "";
            string estado = rblEstado.SelectedValue ?? "";
            string condicion = rblCondicion.SelectedValue ?? "";
            string formato = rblFormato.SelectedValue ?? "";
            string tamano = rblTamano.SelectedValue ?? "";
            string color = ddlColor.SelectedValue ?? "";
            // list<publicaciones> = filtrarPublicaciones(terminoBusqueda, tipoTransaccion, categoriaId, estado, condicion, formato, tamano, color);

            //rptProductos.DataSource = productos;
            //rptProductos.DataBind();
        }

        protected void btnSolicitar_Click(object sender, EventArgs e)
        {

            Session["ProductoSeleccionado"] = null; // Aquí deberías asignar el producto seleccionado
            Response.Redirect("../Transaccion/DetalleProductoyTransaccion.aspx");

        }
    }
}