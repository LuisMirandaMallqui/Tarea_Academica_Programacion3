using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA.PantallaInicio
{
    public partial class Categoria : System.Web.UI.Page
    {

        PublicacionBO publicacionBO = new PublicacionBO();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // 🟩 Recuperar la categoría seleccionada desde Session
                string categoria = Session["Nombre"]?.ToString() ?? "Libros";

                // 🟦 Guardar en ViewState para mantenerla durante los postbacks
                ViewState["CategoriaActual"] = categoria;
                ViewState["ModoActual"] = "Compra";

                // 🟢 Cargar las publicaciones iniciales
                CargarPublicaciones("Compra", categoria);
            }
        }

        protected void btnCompra_Click(object sender, EventArgs e)
        {
            ViewState["ModoActual"] = "Compra";
            string categoria = ViewState["CategoriaActual"]?.ToString() ?? "Libros";
            CargarPublicaciones("Compra", categoria);
        }

        protected void btnAlquiler_Click(object sender, EventArgs e)
        {
            ViewState["ModoActual"] = "Alquiler";
            string categoria = ViewState["CategoriaActual"]?.ToString() ?? "Libros";
            CargarPublicaciones("Alquiler", categoria);
        }

        private void CargarPublicaciones(string modo, string categoria)
        {
            // 🟢 Mostrar el encabezado principal
            lblCategoria.Text = $"{categoria.ToUpper()} -  {modo.ToUpper()}";
            //MODO SE REFIERE A COMPRA O ALQUILER

            List<PublicacionDTO> publicacion = publicacionBO.ObtenerPublicacionPorCategoria(modo, categoria);



            ddlSubcategoria.Items.Clear();

            switch (categoria.ToLower())
            {
                case "libros":
                    ddlSubcategoria.Items.Add(new ListItem("Matemáticas", "Matemáticas"));
                    ddlSubcategoria.Items.Add(new ListItem("Física", "Física"));
                    ddlSubcategoria.Items.Add(new ListItem("Álgebra", "Álgebra"));
                    break;

                case "apuntes":
                    ddlSubcategoria.Items.Add(new ListItem("Universitarios", "Universitarios"));
                    ddlSubcategoria.Items.Add(new ListItem("Escolares", "Escolares"));
                    break;

                case "clases grabadas":
                    ddlSubcategoria.Items.Add(new ListItem("Programación", "Programación"));
                    ddlSubcategoria.Items.Add(new ListItem("Idiomas", "Idiomas"));
                    break;

                case "instrumentos":
                    ddlSubcategoria.Items.Add(new ListItem("Cuerdas", "Cuerdas"));
                    ddlSubcategoria.Items.Add(new ListItem("Viento", "Viento"));
                    break;

                case "otros":
                    ddlSubcategoria.Items.Add(new ListItem("Servicios", "Servicios"));
                    ddlSubcategoria.Items.Add(new ListItem("Avisos", "Avisos"));
                    break;

                default:
                    ddlSubcategoria.Items.Add(new ListItem("General", "General"));
                    break;
            }

            // Mostrar el panel solo si tiene subcategorías
            pnlSubcategorias.Visible = ddlSubcategoria.Items.Count > 0;
            // 🟦 Guarda los valores en ViewState
            ViewState["CategoriaActual"] = categoria;
            ViewState["ModoActual"] = modo;

            // 🔹 Enlaza los datos al Repeater
            rptLibros.DataSource = publicaciones;
            rptLibros.DataBind();
        }

        protected void rptLibros_ItemCommand(object source, RepeaterCommandEventArgs e)
        {
            if (e.CommandName == "VerDetalle")
            {
                string modo = ViewState["ModoActual"]?.ToString() ?? "Compra";
                string categoria = ViewState["CategoriaActual"]?.ToString() ?? "Libros";

                string[] datos = e.CommandArgument.ToString().Split('|');

                if (datos.Length >= 4)
                {
                    Session.Remove("ProductoSeleccionado");

                    Session["ProductoSeleccionado"] = new
                    {
                        Tipo = categoria,
                        Nombre = datos[0],
                        Descripcion = datos[1],
                        Precio = datos[2],
                        ImagenUrl = datos[3],
                        Modo = modo
                    };

                    Session["PaginaAnterior"] = "../PantallaInicio/Categoria.aspx";

                    string url = modo == "Compra"
                        ? "../Transaccion/DetalleProductoCompra.aspx"
                        : "../Transaccion/DetalleAlquiler.aspx";

                    Response.Redirect(url);
                }
            }
        }

        protected void btnBuscar_Click(object sender, EventArgs e)
        {
            string textoBusqueda = txtBusqueda.Text.Trim();
            string condicion = ddlCondicion.SelectedValue;
            string subcategoria = ddlSubcategoria.SelectedValue;
            string modo = ViewState["ModoActual"]?.ToString() ?? "Compra";
            string categoria = ViewState["CategoriaActual"]?.ToString() ?? "Libros";

            // 🟣 Filtrado simulado
            CargarPublicaciones(modo, categoria);
        }
    }
}