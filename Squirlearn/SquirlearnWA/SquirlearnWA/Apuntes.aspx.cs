using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class Apuntes : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
                CargarApuntes();
        }

        private void CargarApuntes()
        {
            var apuntes = new List<dynamic>
            {
                new { Nombre = "Apuntes de Cálculo Aplicado", Descripcion = "Conjunto de fórmulas y anotaciones teóricas", Precio = 15.50, ImagenUrl = "../Imagenes/apuntes.png" },
                new { Nombre = "Apuntes de Química 2", Descripcion = "Incluyen imágenes y ejemplos de laboratorio", Precio = 12.00, ImagenUrl = "../Imagenes/apuntes.png" },
                new { Nombre = "Apuntes de Física 1", Descripcion = "Resumen de cinemática y dinámica", Precio = 14.00, ImagenUrl = "../Imagenes/apuntes.png" },
                new { Nombre = "Apuntes de Programación", Descripcion = "Ejercicios resueltos y estructuras comunes en C++", Precio = 18.00, ImagenUrl = "../Imagenes/apuntes.png" }
            };

            rptApuntes.DataSource = apuntes;
            rptApuntes.DataBind();
        }

        protected void rptApuntes_ItemCommand(object source, RepeaterCommandEventArgs e)
        {
            if (e.CommandName == "VerDetalle")
            {
                string[] datos = e.CommandArgument.ToString().Split('|');

                if (datos.Length >= 4)
                {
                    Session["ProductoSeleccionado"] = new
                    {
                        Nombre = datos[0],
                        Descripcion = datos[1],
                        Precio = datos[2],
                        ImagenUrl = datos[3],
                        Tipo = "Apunte"
                    };

                    Response.Redirect("DetalleProductoCompra.aspx");
                }
            }
        }

        protected void btnBuscar_Click(object sender, EventArgs e)
        {
            string texto = txtBusqueda.Text.Trim().ToLower();
            string subcategoria = ddlSubcategoria.SelectedValue;

            var todos = new List<dynamic>
            {
                new { Nombre = "Apuntes de Cálculo Aplicado", Descripcion = "Conjunto de fórmulas y anotaciones teóricas", Precio = 15.50, ImagenUrl = "../Imagenes/apuntes.png" },
                new { Nombre = "Apuntes de Química 2", Descripcion = "Incluyen imágenes y ejemplos de laboratorio", Precio = 12.00, ImagenUrl = "../Imagenes/apuntes.png" },
                new { Nombre = "Apuntes de Física 1", Descripcion = "Resumen de cinemática y dinámica", Precio = 14.00, ImagenUrl = "../Imagenes/apuntes.png" },
                new { Nombre = "Apuntes de Programación", Descripcion = "Ejercicios resueltos y estructuras comunes en C++", Precio = 18.00, ImagenUrl = "../Imagenes/apuntes.png" }
            };

            var filtrados = new List<dynamic>();
            foreach (dynamic a in todos)
            {
                bool cumple = true;
                if (!string.IsNullOrEmpty(texto) && !a.Nombre.ToLower().Contains(texto))
                    cumple = false;
                if (!string.IsNullOrEmpty(subcategoria) && !a.Descripcion.ToLower().Contains(subcategoria.ToLower()))
                    cumple = false;

                if (cumple)
                    filtrados.Add(a);
            }

            rptApuntes.DataSource = filtrados;
            rptApuntes.DataBind();
        }

        protected void btnInicio_Click(object sender, EventArgs e)
        {
            Response.Redirect("SquirLearnInicio.aspx");
        }
    }
}