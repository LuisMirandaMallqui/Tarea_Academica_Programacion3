using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{ 
    //FALTA HACER MEJOR FILTRACION DE PRODUCTOS COMPRADOS Y ALQUILADOS
    public partial class Pedidos : System.Web.UI.Page
    {
        /*
        
        // Lista simulada de pedidos
        private List<Pedido> pedidosTotales = new List<Pedido>
        {
            new Pedido { TipoPedido = "Comprado", FechaCompra = "27/05/2024", FechaRecibido = "28/05/2024", NombreProducto = "Calculadora programable", Vendedor = "Angel Ramirez", Precio = 30.50m, NombreCurso="" },
            new Pedido { TipoPedido = "Comprado", FechaCompra = "27/05/2024", FechaRecibido = "28/05/2024", NombreProducto = "Laboratorio 3 FIS124-2", Vendedor = "Angel Ramirez", Precio = 10.00m,NombreCurso = "FISICA 3" },
            new Pedido { TipoPedido = "Comprado", FechaCompra = "27/05/2024", FechaRecibido = "28/05/2024", NombreProducto = "Practica 1 ALGOED 25-1", Vendedor = "Carolina Sanchez", Precio = 30.50m, NombreCurso="ALGORITMIA" },
            new Pedido { TipoPedido = "Prestado", FechaCompra = "12/06/2024", FechaRecibido = "14/06/2024", NombreProducto = "Libro FIS124", Vendedor = "Victor Sanabria", Precio = 2.00m,NombreCurso=" FISICA 2" },
            new Pedido { TipoPedido = "Prestado", FechaCompra = "10/07/2024", FechaRecibido = "12/07/2024", NombreProducto = "Multímetro digital", Vendedor = "Carlos Perez", Precio = 5.00m,NombreCurso="" }
        };
        */
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Por defecto mostrar solo los comprados
               // CargarPedidos("Comprado");
            }
        }
        
        protected void CargarPedidos(string tipo)
        {
            /*
            var filtrados = pedidosTotales.Where(p => p.TipoPedido == tipo).ToList();
            rptPedidos.DataSource = filtrados;
            rptPedidos.DataBind();
            */
        }
        
        protected void btnReseña_Click(object sender, EventArgs e)
        {
            // Ejemplo de redirección o acción al presionar “Reseñas”
            Response.Write("<script>alert('Aquí iría la lógica para las reseñas del producto.');</script>");
        }

        protected void btnVolver_Click3(object sender, EventArgs e)
        {
            Response.Redirect("../PerfilUsuario/Perfil.aspx"); 
        }
        
        // Evento que puedes enlazar si usas botones para cambiar categoría
        protected void btnFiltrarCompra_Click(object sender, EventArgs e)
        {
            /*
            if (chkCompra.Checked)
            {
                chkAlquiler.Checked = false;
                CargarPedidos("Comprado"); 
            }
            else
            {
                // Si se desmarca y "Alquiler" está marcado, mostrar alquileres
                if (chkAlquiler.Checked)
                    CargarPedidos("Prestado"); 
            }
            */
            
        }
        
            
        protected void btnFiltrarAlquiler_Click(object sender, EventArgs e)
        {
            /*
                if (chkAlquiler.Checked)
                {
                    chkCompra.Checked = false;
                    CargarPedidos("Prestado");
                }
                else
                {
                    // Si se desmarca y "Compra" está marcado, mostrar compras
                    if (chkCompra.Checked)
                        CargarPedidos("Comprado");
                }
            */

        }


        // Clase interna que representa un pedido
        public class Pedido
        {
            public string TipoPedido { get; set; }
            public string FechaCompra { get; set; }
            public string FechaRecibido { get; set; }
            public string NombreProducto { get; set; }
            public string Vendedor { get; set; }
            public decimal Precio { get; set; }
            public string NombreCurso { get; set; }
            }
        }

    }