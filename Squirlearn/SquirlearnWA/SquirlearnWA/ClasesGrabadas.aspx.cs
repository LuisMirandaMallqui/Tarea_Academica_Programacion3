using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class ClasesGrabadas : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
                CargarClases("Compra");
        }

        protected void btnCompra_Click(object sender, EventArgs e)
        {
            CargarClases("Compra");
        }

        protected void btnAlquiler_Click(object sender, EventArgs e)
        {
            CargarClases("Alquiler");
        }

        private void CargarClases(string categoria)
        {
            lblCategoria.InnerText = categoria.ToUpper();

            var clases = new List<dynamic>();

            if (categoria == "Compra")
            {
                clases = new List<dynamic>
                {
                    new { Nombre = "Matemática Básica - 1", Descripcion = "Clases introductorias de matemáticas básicas", Precio = 15.50, ImagenUrl = "../Imagenes/clases.png" },
                    new { Nombre = "Historia Universal", Descripcion = "3 clases que resumen la I y II Guerra Mundial", Precio = 30.50, ImagenUrl = "../Imagenes/clases.png" },
                    new { Nombre = "Programación Inicial", Descripcion = "Conceptos básicos de algoritmos", Precio = 20.00, ImagenUrl = "../Imagenes/clases.png" }
                };
            }
            else
            {
                clases = new List<dynamic>
                {
                    new { Nombre = "Matemática Básica - 1", Descripcion = "Alquiler por semana – Matemáticas Básicas", Precio = 5.00, ImagenUrl = "../Imagenes/clases.png" },
                    new { Nombre = "Historia Universal", Descripcion = "Alquiler por semana – Historia Universal", Precio = 5.00, ImagenUrl = "../Imagenes/clases.png" },
                    new { Nombre = "Programación Inicial", Descripcion = "Alquiler por semana – Algoritmos básicos", Precio = 5.00, ImagenUrl = "../Imagenes/clases.png" }
                };
            }

            ViewState["CategoriaActual"] = categoria;
            rptClases.DataSource = clases;
            rptClases.DataBind();
        }

        protected void btnBuscar_Click(object sender, EventArgs e)
        {
            string texto = txtBusqueda.Text.Trim().ToLower();
            string subcategoria = ddlSubcategoria.SelectedValue;
            string categoria = ViewState["CategoriaActual"]?.ToString() ?? "Compra";

            // Vuelve a cargar la lista completa
            CargarClases(categoria);

            // Aplica filtros simples
            var filtradas = new List<dynamic>();
            foreach (dynamic item in rptClases.DataSource as List<dynamic>)
            {
                bool cumple = true;
                if (!string.IsNullOrEmpty(texto) && !item.Nombre.ToLower().Contains(texto))
                    cumple = false;
                if (!string.IsNullOrEmpty(subcategoria) && !item.Descripcion.ToLower().Contains(subcategoria))
                    cumple = false;

                if (cumple)
                    filtradas.Add(item);
            }

            rptClases.DataSource = filtradas;
            rptClases.DataBind();
        }

        protected void rptClases_ItemCommand(object source, RepeaterCommandEventArgs e)
        {
            if (e.CommandName == "VerDetalle")
            {
                string categoria = ViewState["CategoriaActual"].ToString();
                string[] datos = e.CommandArgument.ToString().Split('|');

                if (datos.Length >= 4)
                {
                    Session["ProductoSeleccionado"] = new
                    {
                        Nombre = datos[0],
                        Descripcion = datos[1],
                        Precio = datos[2],
                        ImagenUrl = datos[3]
                    };

                    Session["PaginaAnterior"] = "ClasesGrabadas.aspx";

                    string url = categoria == "Compra"
                        ? "DetalleProductoCompra.aspx"
                        : "DetalleProductoAlquiler.aspx";

                    Response.Redirect(url);
                }
            }
        }

        protected void btnInicio_Click(object sender, EventArgs e)
        {
            Response.Redirect("SquirLearnInicio.aspx");
        }
    }
}