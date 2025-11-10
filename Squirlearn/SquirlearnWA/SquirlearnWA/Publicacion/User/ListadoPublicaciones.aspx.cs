using SquirLearnBusiness;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using static SquirlearnWA.Publicar;

namespace SquirlearnWA
{
    public partial class ListadoPublicaciones : System.Web.UI.Page
    {
        private readonly PublicacionBO _publicacionBO = new PublicacionBO();


        protected void Page_Init(object sender, EventArgs e)
        {
            /*
            if (Session["Publicaciones"] == null)
                Session["Publicaciones"] = new List<PublicacionDTO>();
            */
            if (!IsPostBack)
            {
                MostrarPublicaciones();
            }
        }

            // Si es postback, necesitamos recrear los controles para que ASP.NET encuentre sus eventos

            
        
        
        protected void Page_Load(object sender, EventArgs e)
        {

            // Si NO es postback (primera carga), generamos los controles iniciales
            MostrarPublicaciones();



        }
        //---------------------------------QUITAR----------------------------//
        /*
        private List<Publicacion> ObtenerPublicacionesDemo()
        {
            return new List<Publicacion>
    {
        new Publicacion
        {
            Id = 1,
            Categoria = "Libros",
            Titulo = "Matemáticas Avanzadas",
            Descripcion = "Libro de cálculo avanzado con ejemplos prácticos.",
            Accion = "Vender",
            Precio = 60,
            Formato = "Físico",
            EstadoProducto = "Usado",
            EstadoPublicacion = "Aceptado",
            FechaEnvio = DateTime.Now.AddDays(-10)
        },
        new Publicacion
        {
            Id = 2,
            Categoria = "Instrumentos",
            Titulo = "Microscopio Biológico",
            Descripcion = "Microscopio óptico en perfecto estado.",
            Accion = "Vender",
            Precio = 250,
            Formato = "Físico",
            EstadoProducto = "Nuevo",
            EstadoPublicacion = "Rechazado",
            FechaEnvio = DateTime.Now.AddDays(-8)
        },
        new Publicacion
        {
            Id = 3,
            Categoria = "Clases",
            Titulo = "Curso de Física Mecánica",
            Descripcion = "Grabaciones completas de un curso universitario.",
            Accion = "Alquilar",
            Precio = 30,
            Formato = "Virtual",
            EstadoProducto = "Nuevo",
            EstadoPublicacion = "Pendiente",
            FechaEnvio = DateTime.Now.AddDays(-5)
        },
        new Publicacion
        {
            Id = 4,
            Categoria = "Apuntes",
            Titulo = "Apuntes de Estadística II",
            Descripcion = "Resumen completo con ejercicios resueltos.",
            Accion = "Vender",
            Precio = 15,
            Formato = "Virtual",
            EstadoProducto = "Nuevo",
            EstadoPublicacion = "Borrador",
            FechaEnvio = DateTime.Now.AddDays(-2)
        }
            };
        }
        //---------------------------------QUITAR----------------------------//
        */
        private void MostrarPublicaciones()
        {
            contenedorPublicaciones.Controls.Clear();

            //  var publicaciones = Session["Publicaciones"] as List<PublicacionDTO> ?? new List<PublicacionDTO>();
            var publicaciones = _publicacionBO.ObtenerTodas();
            string filtro = ddlEstados.SelectedValue ?? "Todos";

            var filtradas = (filtro == "Todos")
                ? publicaciones
                : publicaciones.Where(p => p.EstadoPublicacion == filtro).ToList();

            foreach (var pub in filtradas)
            {
                // Panel principal de la tarjeta
                Panel card = new Panel { CssClass = "p-3 mb-3 bg-light rounded shadow-sm" };
                card.Controls.Add(new Literal { Text = $"<small>Enviado: {pub.FechaEnvio:dd/MM/yyyy}</small><br>" });
                card.Controls.Add(new Literal { Text = $"<strong>{pub.Categoria} - {pub.Titulo}</strong><br>" });

                // Panel horizontal para checkbox, estado y botón
                Panel panelAcciones = new Panel { CssClass = "d-flex align-items-center mt-2" };

                // Checkbox
                CheckBox chkSeleccion = new CheckBox
                {
                    ID = "chkSeleccion" + pub.Id,
                    CssClass = "form-check-input me-2",
                   // InputAttributes = { ["data-id"] = pub.Id.ToString() },
                    Enabled = (pub.EstadoPublicacion == "Aceptado" || pub.EstadoPublicacion == "Borrador")
                };
                panelAcciones.Controls.Add(chkSeleccion);

                // Label Estado
                string color = GetEstadoColor(pub.EstadoPublicacion);
                Label lblEstado = new Label
                {
                    Text = pub.EstadoPublicacion,
                    CssClass = $"{color} badge p-2 me-2"
                };
                panelAcciones.Controls.Add(lblEstado);

                // Botón Revisar (solo para Borrador)
                if (pub.EstadoPublicacion == "Borrador")
                {
                    Button btnRevisar = new Button
                    {
                        Text = "Revisar",
                        CssClass = "btn btn-outline-dark btn-sm",
                        CommandArgument = pub.Id.ToString()
                    };
                    btnRevisar.Click += BtnRevisar_Click;
                    panelAcciones.Controls.Add(btnRevisar);
                }

                // Agregar panel de acciones a la tarjeta
                card.Controls.Add(panelAcciones);

                // Agregar tarjeta al contenedor principal
                contenedorPublicaciones.Controls.Add(card);

            }
            // Reconectar eventos de botones Revisar dinámicos
            foreach (Control ctrl in contenedorPublicaciones.Controls)
            {
                if (ctrl is Panel card)
                {
                    foreach (Button btn in card.Controls.OfType<Button>())
                    {
                        if (btn.CommandArgument != null)
                            btn.Click += BtnRevisar_Click;
                    }
                }
            }
        }

        protected void BtnRevisar_Click(object sender, EventArgs e)
        {
            /*
            // CommandArgument contiene el Id (pub.Id.ToString())
            if (!int.TryParse(((Button)sender).CommandArgument, out int id))
                return;

            var publicaciones = Session["Publicaciones"] as List<PublicacionDTO>;
            var pub = publicaciones?.FirstOrDefault(x => x.Id == id);
            if (pub != null)
            {
                Session["EditarPublicacion"] = pub; // Guardar en sesión
                Response.Redirect("Publicar.aspx"); // Ir a la pantalla de edición
            }
            */



            if (!int.TryParse(((Button)sender).CommandArgument, out int id)) return;

            var pub = _publicacionBO.ObtenerTodas().FirstOrDefault(x => x.Id == id);
            if (pub != null)
            {
                Session["EditarPublicacion"] = pub;
                Response.Redirect("Publicar.aspx");
            }
        }






        protected void ddlEstados_SelectedIndexChanged(object sender, EventArgs e) => MostrarPublicaciones();

        protected void btnCrear_Click(object sender, EventArgs e)
        {
            Session["EditarPublicacion"] = null;
            Response.Redirect("Publicar.aspx");
        }

       

        protected string GetEstadoColor(string estado) { 
            string color;
                switch (estado)
                {
                    case "Aceptado":
                        color = "bg-success text-white";
                        break;
                    case "Rechazado":
                        color = "bg-danger text-white";
                        break;
                    case "Pendiente":
                        color = "bg-warning text-dark";
                        break;
                    case "Borrador":
                        color = "bg-primary text-white";
                        break;
                    default:
                        color = "bg-secondary text-white";
                        break;
                }
                return color;
        }

        protected void btnEditar_Click(object sender, EventArgs e)
        {
            /*
             var publicaciones = Session["Publicaciones"] as List<PublicacionDTO>;
             if (publicaciones == null) return;

             foreach (var pub in publicaciones)
             {
                 // Intentamos obtener el Panel que contiene el checkbox con ese ID
                 string chkId = "chkSeleccion" + pub.Id;
                 // Buscar en el contenedor principal: cada tarjeta es un Panel añadido.
                 foreach (Control ctrl in contenedorPublicaciones.Controls)
                 {
                     if (ctrl is Panel card)
                     {
                         var chk = card.FindControl(chkId) as CheckBox;
                         if (chk != null && chk.Checked)
                         {
                             // solo permitir editar si el estado es Aceptado (según tu lógica)
                             if (pub.EstadoPublicacion == "Aceptado" || pub.EstadoPublicacion == "Borrador")
                             {
                                 Session["EditarPublicacion"] = pub;
                                 Response.Redirect("Publicar.aspx");
                                 return;
                             }
                         }
                     }
                 }
             }
            */

            var publicaciones = _publicacionBO.ObtenerTodas();

            foreach (var pub in publicaciones)
            {
                string chkId = "chkSeleccion" + pub.Id;

                foreach (Control ctrl in contenedorPublicaciones.Controls)
                {
                    if (ctrl is Panel card)
                    {
                        var chk = card.FindControl(chkId) as CheckBox;
                        if (chk != null && chk.Checked)
                        {
                            if (pub.EstadoPublicacion == "Aceptado" || pub.EstadoPublicacion == "Borrador")
                            {
                                Session["EditarPublicacion"] = pub;
                                Response.Redirect("Publicar.aspx");
                                return;
                            }
                        }
                    }
                }
            }
        }



        protected void btnConfirmarEliminar_Click(object sender, EventArgs e)
        {

            //var publicaciones = Session["Publicaciones"] as List<PublicacionDTO>;
            //if (publicaciones == null) return;

            //List<int> idsEliminar = new List<int>();

            //foreach (Control ctrl in contenedorPublicaciones.Controls)
            //{
            //    if (ctrl is Panel card)
            //    {
            //        // Buscar recursivamente el checkbox por patrón de ID
            //        // Si no sabes el Id, puedes iterar los hijos y buscar controles CheckBox con prefijo
            //        foreach (Control nested in card.Controls)
            //        {
            //            // Hacemos una búsqueda recursiva: FindControl no funciona con prefijos,
            //            // así que intentamos localizar por ID conocida
            //            // Intentamos encontrar cualquier control CheckBox dentro del card
            //            var chk = card.FindControl("chkSeleccion" + /* intenta con cada id posible? */ "") as CheckBox;
            //            // Pero como no tenemos la lista de ids aquí, mejor método: buscar recursivamente:
            //        }

            //        // Mejor: recorrer todos los controles dentro del card recursivamente
            //        var chkRec = EncontrarCheckBoxRecursivo(card);

            //        if (chkRec != null && chkRec.Checked)
            //        {
            //            // parsear id desde chkRec.ID
            //            string idStr = chkRec.ID.Replace("chkSeleccion", "");
            //            if (int.TryParse(idStr, out int id))
            //            {
            //                var pub = publicaciones.FirstOrDefault(p => p.Id == id);
            //                if (pub != null && (pub.EstadoPublicacion == "Aceptado" || pub.EstadoPublicacion == "Borrador"))
            //                {
            //                    idsEliminar.Add(id);
            //                }
            //            }
            //        }
            //    }
            //}

            //if (idsEliminar.Any())
            //{
            //    publicaciones.RemoveAll(p => idsEliminar.Contains(p.Id));
            //    Session["Publicaciones"] = publicaciones;
            //}

            //MostrarPublicaciones();

            var publicaciones = _publicacionBO.ObtenerTodas();
            List<int> idsEliminar = new List<int>();

            foreach (Control ctrl in contenedorPublicaciones.Controls)
            {
                if (ctrl is Panel card)
                {
                    var chkRec = EncontrarCheckBoxRecursivo(card);
                    if (chkRec != null && chkRec.Checked)
                    {
                        string idStr = chkRec.ID.Replace("chkSeleccion", "");
                        if (int.TryParse(idStr, out int id))
                        {
                            var pub = publicaciones.FirstOrDefault(p => p.Id == id);
                            if (pub != null && (pub.EstadoPublicacion == "Aceptado" || pub.EstadoPublicacion == "Borrador"))
                                idsEliminar.Add(id);
                        }
                    }
                }
            }

            foreach (var id in idsEliminar)
                _publicacionBO.Eliminar(id);

            MostrarPublicaciones();

        }

        private CheckBox EncontrarCheckBoxRecursivo(Control parent)
        {
            foreach (Control c in parent.Controls)
            {
                if (c is CheckBox cb && cb.ID != null && cb.ID.StartsWith("chkSeleccion"))
                    return cb;

                var child = EncontrarCheckBoxRecursivo(c);
                if (child != null) return child;
            }
            return null;
        }
    }

}