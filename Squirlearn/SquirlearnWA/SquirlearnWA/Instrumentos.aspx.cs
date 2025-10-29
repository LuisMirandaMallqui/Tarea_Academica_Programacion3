using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class Instrumentos : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
                CargarInstrumentos("Compra");
        }

        protected void btnCompra_Click(object sender, EventArgs e)
        {
            CargarInstrumentos("Compra");
        }

        protected void btnAlquiler_Click(object sender, EventArgs e)
        {
            CargarInstrumentos("Alquiler");
        }

        private void CargarInstrumentos(string categoria)
        {
            lblCategoria.InnerText = categoria.ToUpper();

            var instrumentos = new List<dynamic>();

            if (categoria == "Compra")
            {
                instrumentos = new List<dynamic>
                {
                    new { Nombre = "Calculadora fx-1500", Descripcion = "Calculadora científica modelo fx-350 PLUS", Precio = 30.50, ImagenUrl = "../Imagenes/instrumentos.png" },
                    new { Nombre = "Multímetro digital", Descripcion = "Ideal para prácticas de electrónica y física", Precio = 25.00, ImagenUrl = "../Imagenes/instrumentos.png" },
                    new { Nombre = "Regla metálica 30cm", Descripcion = "Alta precisión, aluminio anodizado", Precio = 10.00, ImagenUrl = "../Imagenes/instrumentos.png" }
                };
            }
            else
            {
                instrumentos = new List<dynamic>
                {
                    new { Nombre = "Calculadora fx-1500", Descripcion = "Alquila la fx-350 PLUS por días o semanas", Precio = 2.00, ImagenUrl = "../Imagenes/instrumentos.png" },
                    new { Nombre = "Multímetro digital", Descripcion = "Alquiler para prácticas de laboratorio", Precio = 2.00, ImagenUrl = "../Imagenes/instrumentos.png" },
                    new { Nombre = "Regla metálica 30cm", Descripcion = "Alquiler por semana - aluminio anodizado", Precio = 2.00, ImagenUrl = "../Imagenes/instrumentos.png" }
                };
            }

            ViewState["CategoriaActual"] = categoria;
            rptInstrumentos.DataSource = instrumentos;
            rptInstrumentos.DataBind();
        }

        protected void rptInstrumentos_ItemCommand(object source, RepeaterCommandEventArgs e)
        {
            if (e.CommandName == "VerDetalle")
            {
                // Obtenemos la categoría actual (Compra o Alquiler)
                string categoria = ViewState["CategoriaActual"].ToString();

                // 🔹 Obtenemos los datos del producto seleccionado
                string nombre = ((Label)e.Item.FindControl("lblNombre")).Text;
                string descripcion = ((Label)e.Item.FindControl("lblDescripcion")).Text;
                string precio = ((Label)e.Item.FindControl("lblPrecio")).Text;
                string imagen = ((Image)e.Item.FindControl("imgProducto")).ImageUrl;

                // 🔹 Guardamos la info en la sesión para pasarla al detalle
                Session["ProductoSeleccionado"] = new
                {
                    Tipo = "Instrumento",
                    Nombre = nombre,
                    Descripcion = descripcion,
                    Precio = precio,
                    ImagenUrl = imagen
                };

                // 🔹 Guardamos la página actual antes de ir al detalle
                Session["PaginaAnterior"] = "Instrumentos.aspx";

                // 🔹 Redirigimos según la categoría
                string url = categoria == "Compra"
                    ? "DetalleProductoCompra.aspx"
                    : "DetalleProductoAlquiler.aspx";

                Response.Redirect(url);
            }
        }
        protected void btnBuscar_Click(object sender, EventArgs e)
        {
            // 🔹 Esto por ahora solo refresca los datos filtrando en memoria (más adelante será desde BO)
            string texto = txtBusqueda.Text.Trim().ToLower();
            string condicion = ddlCondicion.SelectedValue;
            string subcategoria = ddlSubcategoria.SelectedValue;
            string categoria = ViewState["CategoriaActual"]?.ToString() ?? "Compra";

            // Vuelve a cargar
            CargarInstrumentos(categoria);

            // Aplica filtros simples (solo visuales)
            var filtrados = new List<dynamic>();
            foreach (dynamic item in rptInstrumentos.DataSource as List<dynamic>)
            {
                bool cumple = true;
                if (!string.IsNullOrEmpty(texto) && !item.Nombre.ToLower().Contains(texto))
                    cumple = false;
                if (!string.IsNullOrEmpty(condicion) && condicion == "Usado" && item.Nombre.Contains("Nuevo"))
                    cumple = false;
                if (!string.IsNullOrEmpty(subcategoria) && !item.Descripcion.ToLower().Contains(subcategoria.ToLower()))
                    cumple = false;

                if (cumple)
                    filtrados.Add(item);
            }

            rptInstrumentos.DataSource = filtrados;
            rptInstrumentos.DataBind();
        }

        protected void btnInicio_Click(object sender, EventArgs e)
        {
            Response.Redirect("SquirLearnInicio.aspx");
        }
    }
}