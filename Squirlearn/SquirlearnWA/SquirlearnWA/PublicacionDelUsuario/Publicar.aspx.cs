using SquirlearnWA.categoriaSOAP;
using SquirlearnWA.colorSOAP;
using SquirlearnWA.condicionSOAP;
using SquirlearnWA.formatoSOAP;
using SquirlearnWA.publicacionSOAP;
using SquirlearnWA.subcategoriaSOAP;
using SquirlearnWA.tamanoSOAP;
using System;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using static SquirlearnWA.ListadoPublicaciones;


namespace SquirlearnWA.PublicacionDelUsuario
{
    public partial class Publicar : System.Web.UI.Page
    {
        // --- 1. DEFINE TUS CLIENTES SOAP ---
        // (Asegúrate que los nombres coincidan)
        private CategoriaClient categoriaSoap = new CategoriaClient();
        private SubcategoriaClient subcategoriaSoap = new SubcategoriaClient();
        private PublicacionClient publicacionSoap = new PublicacionClient();
        private FormatoClient formatoSoap = new FormatoClient();
        private CondicionClient condicionSoap = new CondicionClient();
        private TamanoClient tamanoSoap = new TamanoClient();
        private ColorClient colorSoap = new ColorClient();


        // (Reemplaza estos IDs con los de tu Base de Datos)
        private const int ID_ESTADO_PENDIENTE = 1;
        private const int ID_ESTADO_BORRADOR = 2;
        private const int ID_ESTADO_ACEPTADO = 3; // (Solo para lógica de 'Enabled')

        // --- 3. PROPIEDAD PARA GUARDAR EL ID ---
        private int IdPublicacionActual
        {
            get { return ViewState["IdPublicacionActual"] != null ? (int)ViewState["IdPublicacionActual"] : -1; }
            set { ViewState["IdPublicacionActual"] = value; }
        }

        // --- 4. PAGE_LOAD (EL CEREBRO) ---
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // 1. Carga todos los DropDowns desde el Backend
                CargarDropDownsIniciales();

                // 2. Revisa si venimos de "Editar" o "Crear"
                if (Session["EditarPublicacionId"] != null)
                {
                    int id = (int)Session["EditarPublicacionId"];
                    Session.Remove("EditarPublicacionId"); // Limpia la sesión

                    IdPublicacionActual = id; // Guarda el ID en la página

                    if (id > 0)
                    {
                        // --- MODO EDICIÓN ---
                        hTitulo.InnerText = "EDITAR PUBLICACIÓN";

                        // Llama al SOAP para traer el DTO *completo*
                        var pubCompleta = publicacionSoap.obtenerPorIdPublicacion(id);

                        // Llena el formulario con los datos
                        if (pubCompleta != null)
                        {
                            LlenarFormulario(pubCompleta);
                        }
                    }
                    else
                    {
                        // --- MODO CREACIÓN ---
                        hTitulo.InnerText = "NUEVA PUBLICACIÓN";
                        // Esconde el formulario hasta que elija categoría
                        panelGeneral.Visible = false;
                    }
                }
            }
        }

        #region "MÉTODOS DE CARGA DE DROPDOWNS"

        // Tu método adaptado
        private void CargarDropDownList(DropDownList ddl, object dataSource, string textField, string valueField)
        {
            ddl.DataSource = dataSource;
            ddl.DataTextField = textField;
            ddl.DataValueField = valueField;
            ddl.DataBind();
            ddl.Items.Insert(0, new ListItem("Seleccionar...", ""));
        }

        // Carga todo lo que no depende de nada
        private void CargarDropDownsIniciales()
        {
            try
            {
                // Categorías
                CargarDropDownList(ddlCategoria, categoriaSoap.listarTodosCategoria(), "Nombre", "categoriaId");

                // Formatos (usando ddlFormato en vez de rblFormato)
                CargarDropDownList(ddlFormato, formatoSoap.listarTodosFormato(), "Nombre", "formatoId");

                // Condiciones (usando ddlCondicion en vez de rblCondicion/ddlEstadoLibro)
                CargarDropDownList(ddlCondicion, condicionSoap.listarTodosCondicion(), "Nombre", "condicionId");

                // Tamaños (usando ddlTamano en vez de rblTamano)
                CargarDropDownList(ddlTamano, tamanoSoap.listarTodosTamano(), "Nombre", "tamanoId");

                // Colores
                CargarDropDownList(ddlColor, colorSoap.listarTodosColor(), "Nombre", "colorId");
            }
            catch (Exception ex)
            {
                // Manejar error (ej: mostrar un label de error)
            }
        }

        // Carga las subcategorías (depende de la categoría)
        private void CargarSubcategorias(int categoriaId)
        {
            try
            {
                if (categoriaId > 0)
                {
                    var subcategorias = subcategoriaSoap.listarPorCategoriaSubcategoria(categoriaId);
                    CargarDropDownList(ddlSubcategoria, subcategorias, "Nombre", "subcategoriaId");
                    ddlSubcategoria.Enabled = true;
                }
                else
                {
                    ddlSubcategoria.Items.Clear();
                    ddlSubcategoria.Items.Insert(0, new ListItem("Seleccionar...", ""));
                    ddlSubcategoria.Enabled = false;
                }
            }
            catch (Exception ex)
            {
                // Manejar error
            }
        }

        #endregion

        #region "LÓGICA DEL FORMULARIO (EVENTOS)"

        // Evento al cambiar la Categoría
        protected void ddlCategoria_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (!string.IsNullOrEmpty(ddlCategoria.SelectedValue))
            {
                // Muestra el formulario
                panelGeneral.Visible = true;

                // Carga las subcategorías
                int idCategoria = int.Parse(ddlCategoria.SelectedValue);
                CargarSubcategorias(idCategoria);
            }
            else
            {
                panelGeneral.Visible = false;
            }
        }

        // Método para llenar el formulario en MODO EDICIÓN
        private void LlenarFormulario(publicacionDto pub)
        {
            // Muestra el panel
            panelGeneral.Visible = true;

            // --- Llena el Item ---
            var item = pub.item;
            txtNombreLibro.Text = item.nombre;
            txtDescripcionLibro.Text = item.descripcion;
            txtPrecioLibro.Text = item.precio.ToString();
            rblAccionLibro.SelectedValue = item.esVenta ? "Vender" : "Alquilar";

            // --- Llena los DropDowns ---
            // (Usamos .ToString() para asegurar que el valor coincida)
            ddlCategoria.SelectedValue = item.categoria.categoriaId.ToString();

            // Carga las subcategorías ANTES de seleccionar una
            CargarSubcategorias(item.categoria.categoriaId);
            ddlSubcategoria.SelectedValue = item.subcategoria.subcategoriaId.ToString();

            ddlFormato.SelectedValue = item.formato.formatoId.ToString();
            ddlCondicion.SelectedValue = item.condicion.condicionId.ToString();
            ddlTamano.SelectedValue = item.tamano.tamanoId.ToString();
            ddlColor.SelectedValue = item.color.colorId.ToString();

        }

        #endregion

        #region "BOTONES DE GUARDAR Y NAVEGACIÓN"

        // --- LÓGICA DE GUARDADO (EL OTRO CORTE VERTICAL) ---

        // Un solo método para Guardar o Enviar
        private void GuardarPublicacion(String nuevoEstado)
        {
            try
            {
                // 1. Crea el DTO que el backend espera
                publicacionDto pub = new publicacionDto();

                // 2. Rellena el DTO con TODOS los campos del formulario
                string nombre = txtNombreLibro.Text;
                string descripcion = txtDescripcionLibro.Text;
                double precio = Double.Parse(txtPrecioLibro.Text);
                bool esVenta = (rblAccionLibro.SelectedValue == "Vender");

                // Asigna los objetos anidados solo con su ID
                int categoriaId = int.Parse(ddlCategoria.SelectedValue);
                int subcategoriaId = int.Parse(ddlSubcategoria.SelectedValue);
                int formatoId = int.Parse(ddlFormato.SelectedValue);
                int condicionId = int.Parse(ddlCondicion.SelectedValue);
                int tamanoId = int.Parse(ddlTamano.SelectedValue);
                int colorId = int.Parse(ddlColor.SelectedValue);
                // ... etc ...


                if (IdPublicacionActual > 0)
                {//cambiar el nuevo estado
                    publicacionSoap.modificarPublicacion(IdPublicacionActual, Session["nombreUsuario"], nuevoEstado, precio, nombre, descripcion, esVenta, colorId, condicionId, tamanoId, formatoId, categoriaId, subcategoriaId);
                }
                else
                {
                    // esta eliminando el parámetro crear
                    int personaid = (int)Session["UsuarioId"] ;
                    publicacionSoap.insertarPublicacion(personaid, Session["nombreUsuario"], nuevoEstado, precio,nombre,descripcion,esVenta,colorId,condicionId,tamanoId,formatoId,categoriaId,subcategoriaId);
                }

                // 5. Si no fue borrador, muestra el modal de éxito
                if (nuevoEstadoId == "Pendiente")
                {
                    ScriptManager.RegisterStartupScript(this, GetType(), "ShowModal", "mostrarModalConfirmacion();", true);
                }
                else
                {
                    // Si fue "Guardar Borrador", solo regresa al listado
                    Response.Redirect("ListadoPublicaciones.aspx");
                }
            }
            catch (Exception ex)
            {
                // Mostrar un error
            }
        }

        protected void btnGuardarBorrador_Click_Click(object sender, EventArgs e)
        {
            // Llama al método de guardado con el ID de "Borrador"
            GuardarPublicacion("Borrador");
        }

        protected void btnEnviarPublicacion_Click_Click(object sender, EventArgs e)
        {
            // Llama al método de guardado con el ID de "Pendiente"
            GuardarPublicacion("Pendiente");
        }

        // --- Botones de Navegación ---
        protected void btnCancelar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListadoPublicaciones.aspx");
        }

        protected void btnContinuar_Click(object sender, EventArgs e)
        {
            // El botón del modal también te regresa al listado
            Response.Redirect("ListadoPublicaciones.aspx");
        }

        #endregion
    }
}
