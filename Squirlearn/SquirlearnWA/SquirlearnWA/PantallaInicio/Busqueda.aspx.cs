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

        private const int PublicacionesPorPagina = 12; // 12 es bueno para una cuadrícula de 4

        private int PaginaActual
        {
            get { return ViewState["PaginaActual"] != null ? (int)ViewState["PaginaActual"] : 1; }
            set { ViewState["PaginaActual"] = value; }
        }

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
                // ❗️ 2. SIMPLIFICAMOS EL PAGE_LOAD
                // Carga los filtros y luego ejecuta la búsqueda inicial para la página 1
                CargarFiltros();
                PaginaActual = 1;

                // 🟩 Recuperar la categoría seleccionada desde Session
                int categoriaId = Convert.ToInt32(Session["idCategoria"]);
                if (categoriaId != 0)
                {
                    // Pre-selecciona el dropdown si viene de la home
                    ddlCategoria.SelectedValue = categoriaId.ToString();
                    CargarSubcategorias(categoriaId); // Carga las subcategorías
                }

                BuscarProductos(); // Carga la primera página
            }
        }

        private void CargarFiltros()
        {
            if (!IsPostBack)
            {
                //Categorías
                IList<categoriaSOAP.categoriaDto> categorias = categoriaSoap.listarTodosCategoria();
                CargarDropDownList(ddlCategoria, categorias, "nombre", "categoriaId");
                //Subacategorías
                CargarSubcategorias(0);
            }

            // Colores
            IList<colorSOAP.colorDto> colores = colorSoap.listarTodosColor();
            CargarDropDownList(ddlColor, colores, "nombre", "colorId");

            // Tamaños
            IList<tamanoSOAP.tamanoDto> tamanos = tamanoSoap.listarTodosTamano();
            CargarRadioButtonList(rblTamano, tamanos, "nombre", "tamanoId");

            // Formatos
            IList<formatoSOAP.formatoDto> formatos = formatoSoap.listarTodosFormato();
            CargarRadioButtonList(rblFormato, formatos, "nombre", "formatoId");

            // Condiciones
            IList<condicionSOAP.condicionDto> condiciones = condicionSoap.listarTodosCondicion();
            CargarRadioButtonList(rblCondicion, condiciones, "nombre", "condicionId");
        }

        private void CargarSubcategorias(int categoriaId)
        {
            IList<subcategoriaSOAP.subcategoriaDto> subcategorias = new List<subcategoriaSOAP.subcategoriaDto>();

            if (categoriaId > 0)
            {
                // Llama al servicio SOAP para obtener solo las subcategorías de la Categoría seleccionada
                // ¡Este método debe existir en tu servicio subcategoriaSoap!
                subcategorias = subcategoriaSoap.listarPorCategoriaSubcategoria(categoriaId);
            }
            CargarDropDownList(ddlSubcategoria, subcategorias, "nombre", "subcategoriaId");
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
            PaginaActual = 1;
            BuscarProductos();
        }

        protected void btnFiltrar_Click(object sender, EventArgs e)
        {
            PaginaActual = 1;
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
            PaginaActual = 1;
            BuscarProductos();
        }

        private void BuscarProductos()
        {
            string terminoBusqueda = txtBuscar.Text.Trim() ?? "";
            int tipoTransaccion = rbVenta.Checked ? 1 : rbAlquiler.Checked ? 0 : 2;
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

            try
            {
                // 1. Llama al método SOAP actualizado
                listadoPublicacionGestionDto resultado = publicacionSoap.listarPorFiltrosPublicacion(
                    terminoBusqueda, tipoTransaccion, categoriaId, subcategoriaId, color, tamano,
                    formato, condicion, PaginaActual, PublicacionesPorPagina); 

                // 2. Desempaca el DTO
                var publicaciones = resultado.lista;
                int totalRegistros = resultado.totalPaginas;
                int totalPaginas = (int)Math.Ceiling((double)totalRegistros / PublicacionesPorPagina);

                // 3. Enlaza los datos y genera la paginación
                rptProductos.DataSource = publicaciones;
                rptProductos.DataBind();
                GenerarPaginacion(totalPaginas);
            }
            catch (Exception ex)
            {
                // Manejar error
                rptProductos.DataSource = null;
                rptProductos.DataBind();
                GenerarPaginacion(0);
            }
        }

        private void GenerarPaginacion(int totalPaginas)
        {
            phPaginacion.Controls.Clear();
            for (int i = 1; i <= totalPaginas; i++)
            {
                Button btnPagina = new Button
                {
                    Text = i.ToString(),
                    CssClass = i == PaginaActual ? "btn btn-dark btn-sm me-1" : "btn btn-outline-dark btn-sm me-1",
                    CommandArgument = i.ToString(),
                    ID = "btnPagina_" + i
                };
                btnPagina.Click += BtnPagina_Click;
                ScriptManager.GetCurrent(this).RegisterAsyncPostBackControl(btnPagina);
                phPaginacion.Controls.Add(btnPagina);
            }
        }

        protected void BtnPagina_Click(object sender, EventArgs e)
        {
            var btn = (Button)sender;
            if (int.TryParse(btn.CommandArgument, out int pagina))
            {
                PaginaActual = pagina;
                BuscarProductos(); // Vuelve a buscar, pero para la nueva página
            }
        }

        protected void rptProductos_ItemCommand(object source, RepeaterCommandEventArgs e)
        {
            if (e.CommandName == "Solicitar")
            {
                // Separar los valores
                string[] args = e.CommandArgument.ToString().Split('|');
                int publicacionId = Convert.ToInt32(args[0]);
                bool esVenta = Convert.ToBoolean(args[1]);
                string nombreProducto = args[2];
                int itemId = Convert.ToInt32(args[3]);
                double precio = Convert.ToDouble(args[4]);
                int vendedorId = Convert.ToInt32(args[5]);

                // Guardar en sesión
                Session["productoSeleccionado"] = publicacionId;
                Session["esVenta"] = esVenta ? "venta" : "alquiler";
                Session["nombreProducto"] = nombreProducto;
                Session["itemId"] = itemId;
                Session["precioProducto"] = precio;
                Session["vendedorId"] = vendedorId;

                if (esVenta)
                    Response.Redirect("../Transaccion/DetalleCompra.aspx");
                else
                    Response.Redirect("../Transaccion/DetalleAlquiler.aspx");
            }

        }

        protected void ddlCategoria_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (int.TryParse(ddlCategoria.SelectedValue, out int categoriaId))
            {
                CargarSubcategorias(categoriaId);
            }
            else
            {
                CargarSubcategorias(0); 
            }
        }


    }
}