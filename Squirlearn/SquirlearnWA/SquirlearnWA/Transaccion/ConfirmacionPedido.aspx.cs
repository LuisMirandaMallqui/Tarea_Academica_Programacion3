using SquirlearnWA.alquilerSOAP;
using SquirlearnWA.comprobanteSOAP;
using SquirlearnWA.notificacionSOAP;
using SquirlearnWA.publicacionSOAP;
using SquirlearnWA.ItemSOAP;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class ConfirmacionPedido : Page
    {
        private ComprobanteClient comprobanteSoap;
        private NotificacionClient notificacionSoap;
        private AlquilerClient alquilerSoap;
        private PublicacionClient publicacionSoap;
        private ItemClient itemSoap;
        public ConfirmacionPedido()
        {
            this.notificacionSoap = new NotificacionClient();
            this.alquilerSoap = new AlquilerClient();
            this.comprobanteSoap = new ComprobanteClient();
            this.publicacionSoap = new PublicacionClient();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            // Si se llega a esta página, el pedido ya fue confirmado
            if (!IsPostBack)
            {
                if (Session["PagoError"] != null)
                {
                    // Mostrar el mensaje de error
                    lblError.Text = Session["PagoError"].ToString();
                    pnlError.Visible = true;

                    // Ocultar la parte de éxito
                    divExito.Visible = false;

                    // Limpiar la sesión para que no se repita el error
                    Session.Remove("PagoError");
                }
                else
                {
                    //aqui integramos el insertar alquiler y cambiar de estado a vendido

                    //regla de negocio 
                    int alquilerId = 0;

                    pnlError.Visible = false;
                    divExito.Visible = true;
                    lblNombre.Text = Session["nombreProducto"].ToString();
                    lblDescripcion.Text = Session["descripcionProducto"].ToString();
                    lblTotal.Text = Session["montoTotal"].ToString();

                    //estos datos vendrían de la pasarela de pagos
                    string fechaCompra = DateTime.Now.ToString("yyyy-MM-dd");
                    string codigoTransaccion = "";
                    string tipoMoneda = "";
                    string metodoPago = Session["metodoPago"].ToString();
                    double impuesto = 0;

                    int idUsuario = Convert.ToInt32(Session["UsuarioId"]);
                    double totalCompra = Convert.ToDouble(Session["montoTotal"]);
                    int idPublicacion = Convert.ToInt32(Session["productoSeleccionado"]);
                    string usuarioNombre = Session["nombreUsuario"].ToString();
                    string usuarioCorreo= Session["correoUsuario"].ToString();
                    int idVendedor= Convert.ToInt32(Session["VendedorId"]);

                    bool esVenta= (bool)Session["esVenta"];

                    if (!esVenta)
                    {

                        alquilerId = alquilerSoap.insertarAlquiler((int)Session["usuarioId"], (int)Session["itemId"], Session["fechaInicio"].ToString(), Session["fechaFin"].ToString(), (double)Session["montoTotal"], Session["nombreUsuario"].ToString());
                        lblTipoOperacion.Text = $"Alquiler por inicia en " + Session["fechaInicio"].ToString() + " y termina en " + Session["fechaFin"].ToString();

                        //NOTIFICACION PARA EL USUARIO QUE COMPRO
                        string mensajeAlquilerUsuario = $"Tu aquiler de"  + $" {lblNombre.Text} "
                            + "se proceso con exito " + fechaCompra;
                        //por corregir
                        notificacionSoap.insertarNotificacion(mensajeAlquilerUsuario, idUsuario) ;


                        //NOTIFICACION PARA EL VENDEDOR DE LA PUBLICACION
                        string mensajeAlquilerVendedor = $"Tu producto en alquiler"  + $" {lblNombre.Text} "
                              + "ha sido comprado por " + usuarioNombre + ", correo electronico: " + usuarioCorreo + ". Comunícate lo antes posible/n" +
                              "Inicio de alquiler: " + Session["fechaInicio"].ToString() + "/nFin de alquiler " + Session["fechaFin"].ToString();

                        notificacionSoap.insertarNotificacion(mensajeAlquilerVendedor, idVendedor);

                        itemSoap.cambiarEstadoItem((int)Session["itemId"], Session["nombreUsuario"].ToString(), "Alquilado");

                    }
                    else
                    {
                        lblTipoOperacion.Text = "Compra única";
            

                        //NOTIFICACION PARA EL USUARIO QUE COMPRO
                        string mensajeAlquilerUsuario = $"Tu compra de" + $" {lblNombre.Text} "
                            + "se proceso con exito " + fechaCompra;
                        notificacionSoap.insertarNotificacion(mensajeAlquilerUsuario, idUsuario);

                        //NOTIFICACION PARA EL VENDEDOR DE LA PUBLICACION
                        string mensajeAlquilerVendedor = $"Tu producto en venta" + $" {lblNombre.Text} "
                             + "ha sido comprado por " + usuarioNombre + ", correo electronico: " + usuarioCorreo;
                        notificacionSoap.insertarNotificacion(mensajeAlquilerVendedor, idVendedor);
                        itemSoap.cambiarEstadoItem((int)Session["itemId"], Session["nombreUsuario"].ToString(), "Vendido");

                    }
                    //por corregir
                    publicacionSoap.cambiarEstadoPublicacion(Int32.Parse(Session["productoSeleccionado"].ToString(), Session["nombreUsuario"].ToString() , "Transaccionada");
                    comprobanteSoap.insertarComprobante(totalCompra, codigoTransaccion, idUsuario, metodoPago, tipoMoneda, impuesto, fechaCompra, usuarioNombre, (int)Session["itemId"],
                        alquilerId, Session["nombreProducto"].ToString());

                }
            }           
            
        }

        protected void btnVolverInicio_Click(object sender, EventArgs e)
        {
            Session.Remove("fechaInicio");
            Session.Remove("fechaFin");
            Session.Remove("montoTotal");
            Session.Remove("productoSeleccionado");
            Session.Remove("esVenta");
            Session.Remove("nombreProducto");
            Session.Remove("itemId");
            Session.Remove("precioProducto");
            Session.Remove("vendedorId");

            Response.Redirect("../PantallaInicio/SquirLearnInicio.aspx");
        }

       
    }
}