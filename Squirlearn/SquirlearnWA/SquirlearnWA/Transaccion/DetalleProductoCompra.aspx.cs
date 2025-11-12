using SoftInvBusiness;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class DetalleProductoCompra : Page
    {
        BuscarPersonaBO buscarPersonaBO=new BuscarPersonaBO();
        
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack && Session["ProductoSeleccionado"] != null)
            {
                dynamic producto = Session["ProductoSeleccionado"];

                PersonaDto personaDto = buscarPersonaBO.BuscarPersonaPorId(producto.UsuarioId,producto.Id);
                lblVendedor.Text = personaDto.Nombre;
                lblNombreProducto.Text = producto.Titulo;
                lblDescripcion.Text = producto.Descripcion;
                lblSubcategoria.Text = producto.Subcategoria;
                lblEstado=producto.EstadoProducto;
                lblPrecio.Text = "S/ " +
                Convert.ToDecimal(producto.Precio.Replace("S/", "").Trim(),
                System.Globalization.CultureInfo.InvariantCulture).ToString("F2");
                imgProducto.ImageUrl = producto.ImagenUrl;



                Session["ProductoSeleccionado"] = new
                {
                    producto.UsuarioId,
                    producto.ImagenUrl,
                     producto.Titulo,
                     producto.Subcategoria,
                     producto.Precio,
                     producto.Descripcion,
                     producto.EstadoProducto,
                    producto.Periodo,
                    producto.IdPublicacion,
                    producto.Tipo, //categoria
                    Vendedor= personaDto.Nombre
                };
            }

            
        }

        protected void btnVolver_Click(object sender, EventArgs e)
        {
            // Recupera la página anterior desde la sesión
            string paginaAnterior = Session["PaginaAnterior"] != null
                ? Session["PaginaAnterior"].ToString()
                : "../PaginaInicio/SquirLearnInicio.aspx"; // Si no hay nada guardado, va al inicio

            Response.Redirect(paginaAnterior);
        }

        protected void btnComprar_Click(object sender, EventArgs e)
        {
            // Redirige al flujo de compra (donde se hace el cálculo de totales, etc.)
            Response.Redirect("DetalleCompra.aspx");
        }
    }
}