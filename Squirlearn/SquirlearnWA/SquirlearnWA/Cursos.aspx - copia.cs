using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class Cursos : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                CargarCursos();
            }
        }

        private void CargarCursos()
        {
            // Datos simulados (luego los reemplazarás con BD)
            var cursos = new List<dynamic>
            {
                new { Nombre = "Programación 2", Descripcion = "Laboratorios y exámenes 2023-1", Precio = 30.50 },
                new { Nombre = "Cálculo Aplicado", Descripcion = "Ejercicios y clases grabadas", Precio = 15.50 },
                new { Nombre = "Historia del Perú", Descripcion = "Contiene lecturas guía", Precio = 10.99 }
            };

            rptCursos.DataSource = cursos;
            rptCursos.DataBind();
        }

        protected void btnBuscar_Click(object sender, EventArgs e)
        {
            // Aquí puedes filtrar la lista
            CargarCursos();
        }

        protected void btnInicio_Click(object sender, EventArgs e)
        {
            Response.Redirect("SquirLearnInicio.aspx");
        }

        protected void btnCompra_Click(object sender, EventArgs e)
        {
            lblCategoria.InnerText = " (Compra)";
        }

        protected void btnAlquiler_Click(object sender, EventArgs e)
        {
            lblCategoria.InnerText = " (Alquiler)";
        }

        protected void rptCursos_ItemCommand(object source, RepeaterCommandEventArgs e)
        {
            if (e.CommandName == "VerDetalle")
            {
                string[] data = e.CommandArgument.ToString().Split('|');
                Session["ProductoSeleccionado"] = new
                {
                    Nombre = data[0],
                    Descripcion = data[1],
                    Precio = data[2],
                    ImagenUrl = "../Imagenes/cursos.png"
                };

                Response.Redirect("DetalleProductoCompra.aspx");
            }
        }
    }
}