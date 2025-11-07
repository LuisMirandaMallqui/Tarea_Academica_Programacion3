using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class Otros : Page
    {
        private List<dynamic> listaOtros;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
                CargarOtros();
        }

        private void CargarOtros()
        {
            listaOtros = new List<dynamic>
            {
                new { Nombre = "Mochila universitaria", Descripcion = "Color negro, espaciosa y resistente.", Precio = 45.00, Condicion = "Nuevo", Tamano = "Grande", Color = "Negro", Subcategoria = "Mochila", ImagenUrl = "../Imagenes/productoGeneral.png" },
                new { Nombre = "Estuche de lápices", Descripcion = "Color azul con cierre reforzado.", Precio = 15.00, Condicion = "Nuevo", Tamano = "Chico", Color = "Azul", Subcategoria = "Estuche", ImagenUrl = "../Imagenes/productoGeneral.png" },
                new { Nombre = "Set de material de escritorio", Descripcion = "Incluye plumones, tijeras, regla y más.", Precio = 20.00, Condicion = "Seminuevo", Tamano = "Mediano", Color = "Rojo", Subcategoria = "Material de escritorio", ImagenUrl = "../Imagenes/productoGeneral.png" },
                new { Nombre = "Polo institucional PUCP", Descripcion = "Ropa deportiva para actividades universitarias.", Precio = 35.00, Condicion = "Nuevo", Tamano = "Mediano", Color = "Blanco", Subcategoria = "Ropa", ImagenUrl = "../Imagenes/productoGeneral.png" }
            };

            rptOtros.DataSource = listaOtros;
            rptOtros.DataBind();
        }

        protected void btnBuscar_Click(object sender, EventArgs e)
        {
            string texto = txtBusqueda.Text.Trim().ToLower();
            string condicion = ddlCondicion.SelectedValue;
            string tamano = ddlTamano.SelectedValue;
            string color = ddlColor.SelectedValue;
            string subcategoria = ddlSubcategoria.SelectedValue;

            var filtrados = new List<dynamic>();
            foreach (dynamic item in listaOtros)
            {
                bool cumple = true;

                if (!string.IsNullOrEmpty(texto) && !item.Nombre.ToLower().Contains(texto))
                    cumple = false;
                if (!string.IsNullOrEmpty(condicion) && item.Condicion != condicion)
                    cumple = false;
                if (!string.IsNullOrEmpty(tamano) && item.Tamano != tamano)
                    cumple = false;
                if (!string.IsNullOrEmpty(color) && item.Color != color)
                    cumple = false;
                if (!string.IsNullOrEmpty(subcategoria) && item.Subcategoria != subcategoria)
                    cumple = false;

                if (cumple)
                    filtrados.Add(item);
            }

            rptOtros.DataSource = filtrados;
            rptOtros.DataBind();
        }

        protected void rptOtros_ItemCommand(object source, RepeaterCommandEventArgs e)
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
                        Tipo = "Accesorio"
                    };

                    Response.Redirect("DetalleProductoCompra.aspx");
                }
            }
        }

       
    }
}