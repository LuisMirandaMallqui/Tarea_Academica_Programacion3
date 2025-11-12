using Microsoft.SqlServer.Server;
using SquirlearnWA.categoriaSOAP;
using SquirlearnWA.colorSOAP;
using SquirlearnWA.condicionSOAP;
using SquirlearnWA.formatoSOAP;
using SquirlearnWA.publicacionSOAP;
using SquirlearnWA.subcategoriaSOAP;
using SquirlearnWA.tamanoSOAP;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA.PantallaInicio
{
    public partial class Busqueda : System.Web.UI.Page
    {

        private CategoriaClient categoriaSoap;
        private SubcategoriaClient subcategoriaSoap;
        private ColorClient colorSoap;
        private TamanoClient tamanoSoap;
        private FormatoClient formatoSoap;
        private CondicionClient condicionSoap;
        private PublicacionClient publicacionSoap;

        public Busqueda()
        {
            categoriaSoap = new CategoriaClient();
            subcategoriaSoap = new SubcategoriaClient();
            colorSoap = new ColorClient();
            tamanoSoap = new TamanoClient();
            formatoSoap = new FormatoClient();
            condicionSoap = new CondicionClient();
            publicacionSoap = new PublicacionClient();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // 🟩 Recuperar la categoría seleccionada desde Session
               int categoriaId = Convert.ToInt32(Session["idCategoria"]);

                //elilmine el guardado de categoría 

                // 🟢 Cargar las publicaciones iniciales
                IList<publicacionDto> publicaciones = publicacionSoap.listarPorFiltrosPublicacion(null, false, categoriaId, 0, 0, 0, 0, 0);

                rptProductos.DataSource = publicaciones;
                rptProductos.DataBind();


            }
        }

        private void CargarFiltros()
        {
            // Categorías
            IList<categoriaSOAP.categoriaDto> categorias = categoriaSoap.listarTodosCategoria();
            CargarDropDownList(ddlCategoria, categorias, "Nombre", "categoriaId");

            // Subcategorías
            IList<subcategoriaSOAP.subcategoriaDto> subcategorias = subcategoriaSoap.listarTodosSubcategoria();
            CargarDropDownList(ddlSubcategoria, subcategorias, "Nombre", "subcategoriaId");

            // Colores
            IList<colorSOAP.colorDto> colores = colorSoap.listarTodosColor();
            CargarDropDownList(ddlColor, colores, "Nombre", "colorId");

            // Tamaños
            IList<tamanoSOAP.tamanoDto> tamanos = tamanoSoap.listarTodosTamano();
            CargarRadioButtonList(rblTamano, tamanos, "Nombre", "tamanoId");

            // Formatos
            IList<formatoSOAP.formatoDto> formatos = formatoSoap.listarTodosFormato();
            CargarRadioButtonList(rblFormato, formatos, "Nombre", "formatoId");

            // Condiciones
            IList<condicionSOAP.condicionDto> condiciones = condicionSoap.listarTodosCondicion();
            CargarRadioButtonList(rblCondicion, condiciones, "Nombre", "condicionId");
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
            ddlSubcategoria.SelectedIndex = 0;
            rbVenta.Checked = false;
            rbAlquiler.Checked = false;
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
            bool tipoTransaccion = rbVenta.Checked ? true : rbAlquiler.Checked ? false : false;
            int categoriaId;
            int.TryParse(ddlCategoria.SelectedValue, out categoriaId);
            int subcategoriaId;
            int.TryParse(ddlSubcategoria.SelectedValue, out subcategoriaId);
            int condicion;
            int.TryParse(rblCondicion.SelectedValue, out condicion);
            int formato;
            int.TryParse(rblFormato.SelectedValue, out formato);
            int tamano;
            int.TryParse(rblTamano.SelectedValue, out tamano);
            int color;
            int.TryParse(ddlColor.SelectedValue, out color);
            IList<publicacionDto> publicaciones = publicacionSoap.listarPorFiltrosPublicacion(terminoBusqueda, tipoTransaccion, categoriaId, subcategoriaId, condicion, formato, tamano, color);

            rptProductos.DataSource = publicaciones;
            rptProductos.DataBind();
        }

        protected void rptPublicaciones_ItemCommand(object source, RepeaterCommandEventArgs e)
        {
            if (e.CommandName == "Solicitar")
            {
                // Separar los valores
                string[] args = e.CommandArgument.ToString().Split('|');
                int idPublicacion = Convert.ToInt32(args[0]);
                bool esVenta = Convert.ToBoolean(args[1]);

                // Guardar en sesión
                Session["ProductoSeleccionado"] = idPublicacion;
                Session["tipoOperacion"] = esVenta ? "venta" : "alquiler";

                if (esVenta)
                    Response.Redirect("../Transaccion/DetalleCompra.aspx");
                else
                    Response.Redirect("../Transaccion/DetalleAlquiler.aspx");
            }
        }

    }
}