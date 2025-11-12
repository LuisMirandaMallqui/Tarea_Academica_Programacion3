using SquirLearnBusiness;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using static SquirlearnWA.ListadoPublicaciones;

namespace SquirlearnWA
{
    public partial class Publicar : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Si hay una publicación para editar
                var pubEditar = Session["EditarPublicacion"] as Publicacion;

                if (pubEditar != null)
                {

                    // 1️⃣ Establecer categoría primero
                    switch (pubEditar.Categoria)
                    {
                        case "Libros":
                            ddlCategoria.SelectedValue = "Libro";
                            break;
                        case "Instrumentos":
                            ddlCategoria.SelectedValue = "Instrumento";
                            break;
                        case "Clases":
                            ddlCategoria.SelectedValue = "Clases";
                            break;
                        case "Apuntes":
                            ddlCategoria.SelectedValue = "Apuntes";
                            break;
                        case "Cursos":
                            ddlCategoria.SelectedValue = "Cursos";
                            break;
                        default:
                            ddlCategoria.SelectedValue = "Otros";
                            break;
                    }

                    // 2️⃣ Mostrar panel general
                    panelGeneral.Visible = true;

                    // 3️⃣ Cargar subcategorías según categoría
                    CargarSubcategorias(ddlCategoria.SelectedValue);

                    // 4️⃣ Asignar los valores guardados
                    txtNombreLibro.Text = pubEditar.Titulo;
                    txtDescripcionLibro.Text = pubEditar.Descripcion;
                    rblAccionLibro.SelectedValue = pubEditar.Accion;
                    txtPrecioLibro.Text = pubEditar.Precio.ToString();

                    // ✅ Usa Value, no Text
                    if (ddlFormatoLibro.Items.FindByValue(pubEditar.Formato) != null)
                        ddlFormatoLibro.SelectedValue = pubEditar.Formato;

                    if (ddlEstadoLibro.Items.FindByValue(pubEditar.EstadoProducto) != null)
                        ddlEstadoLibro.SelectedValue = pubEditar.EstadoProducto;

                    if (ddlSubcategoria.Items.FindByValue(pubEditar.Subcategoria) != null)
                        ddlSubcategoria.SelectedValue = pubEditar.Subcategoria;

                    // Si es Alquiler
                    if (pubEditar.Accion == "Alquilar")
                    {
                        panelAlquiler.Visible = true;
                        txtPeriodoLibro.Text = pubEditar.Periodo.ToString();
                    }
                }
                else
                {
                    // Si es nuevo
                    CargarSubcategorias(null);
                }
            }
        }
        private void CargarSubcategorias(string categoria)
        {
            ddlSubcategoria.Items.Clear();
            ddlSubcategoria.Items.Add(new ListItem("Seleccionar subcategoría", ""));

            if (string.IsNullOrEmpty(categoria))
                return;

            List<ListItem> opciones = new List<ListItem>();

            switch (categoria)
            {
                case "Libro":
                    opciones.AddRange(new[]
                    {
                new ListItem("Académico", "Academico"),
                new ListItem("Científico", "Cientifico"),
                new ListItem("Literario", "Literario"),
                new ListItem("Técnico", "Tecnico"),
                new ListItem("Arte y Cultura", "ArteCultura"),
                new ListItem("Historia", "Historia"),
                new ListItem("Filosofía y Ensayo", "Filosofia"),
                new ListItem("Otros", "Otros")
            });
                    break;

                case "Instrumento":
                    opciones.AddRange(new[]
                    {
                new ListItem("Cálculo y medición", "CalculoMedicion"),
                new ListItem("Dibujo técnico", "DibujoTecnico"),
                new ListItem("Accesorios electrónicos", "Electronica"),
                new ListItem("Laboratorio químico", "Quimica"),
                new ListItem("Arte y diseño", "ArteDiseno"),
                new ListItem("Otros", "Otros")
            });
                    break;

                case "Apuntes":
                    opciones.AddRange(new[]
                    {
                new ListItem("Apuntes de clase", "Clase"),
                new ListItem("Resúmenes", "Resumen"),
                new ListItem("Guías de práctica", "Guia"),
                new ListItem("Otros", "Otros")
            });
                    break;

                case "Cursos":
                    opciones.AddRange(new[]
                    {
                new ListItem("Practica calificada", "practicaCalificada"),
                new ListItem("Practica dirigida", "practicaDiriga"),
                new ListItem("Examen", "examen"),
                new ListItem("Laboratorio", "laboratorio")

            });
                    break;

                case "Clases":
                    opciones.AddRange(new[]
                    {
                new ListItem("Estudios generales ciencias", "ciencias"),
                new ListItem("Estudios generales letras", "letras"),
                new ListItem("Facultad de ciencias e ingineria", "ingenieria"),
                new ListItem("Facultad de economia","economia"),
                new ListItem("Facultad de derecho", "derecho"),
                new ListItem("Facultad psicologia", "Psicologia"),
                new ListItem("Facultad gestión y alta dirección", "gestion"),
                 new ListItem("Facultad educación", "educacion"),
                 new ListItem("Facultad ciencias sociales", "sociales"),
                 new ListItem("Facultad comunicación", "comunicacion"),
                 new ListItem("Facultad artes", "artes"),
                 new ListItem("Facultad arquitectura", "arquitectura")
            });
                    break;

                case "otros":
                    opciones.AddRange(new[]
                    {
                new ListItem("Accesorios", "Accesorios"),
                new ListItem("Mochila", "mochila"),
                new ListItem("Prenda de vestir", "Prenda"),

            });
                    break;
            }

            ddlSubcategoria.Items.AddRange(opciones.ToArray());
        }

        private void CargarDatos(Publicacion pub)
        {
            ddlCategoria.SelectedValue = pub.Categoria == "Libro" ? "Libro" : "";
            panelGeneral.Visible = (ddlCategoria.SelectedValue == "Libro");

            txtNombreLibro.Text = pub.Titulo;
            txtDescripcionLibro.Text = pub.Descripcion;
            rblAccionLibro.SelectedValue = pub.Accion;
            txtPrecioLibro.Text = pub.Precio.ToString();
            ddlFormatoLibro.SelectedValue = pub.Formato;
            ddlEstadoLibro.SelectedValue = pub.EstadoProducto;
        }

        protected void btnCancelar_Click(object sender, EventArgs e)
        {
            Response.Redirect("../PantallaInicio/SquirLearnInicio.aspx");
        }

        protected void ddlCategoria_SelectedIndexChanged(object sender, EventArgs e)
        {
            string categoriaSeleccionada = ddlCategoria.SelectedValue;

            // Mostrar el panel de publicación general
            panelGeneral.Visible = !string.IsNullOrEmpty(categoriaSeleccionada);

            // Actualizar las subcategorías dinámicamente
            CargarSubcategorias(categoriaSeleccionada);

            // Limpiar selección previa
            ddlSubcategoria.ClearSelection();

            bool esClaseGrabada = (categoriaSeleccionada == "Clases");

            panelAccion.Visible = !esClaseGrabada;
            panelFormato.Visible = !esClaseGrabada;
            panelEstado.Visible = !esClaseGrabada;
            panelFoto.Visible = !esClaseGrabada;

            bool esApuntes = (categoriaSeleccionada == "Apuntes");
            panelAccion.Visible = !esApuntes;
            panelEstado.Visible = !esApuntes;

            bool esCursos = (categoriaSeleccionada == "cursos");
            panelAccion.Visible = !esCursos;
            panelEstado.Visible = !esCursos;



            panelColorProducto.Visible = (categoriaSeleccionada == "otros");
            panelTamanoProducto.Visible = (categoriaSeleccionada == "otros");
            bool esOtros = (categoriaSeleccionada == "otros");
            panelAccion.Visible = !esOtros;
            panelFormato.Visible = !esOtros;


        }

        protected void rblAccionLibro_SelectedIndexChanged(object sender, EventArgs e)
        {
            panelAlquiler.Visible = (rblAccionLibro.SelectedValue == "Alquilar");
        }

        protected void btnGuardarBorrador_Click_Click(object sender, EventArgs e)
        {
            GuardarPublicacion("Borrador");
        }

        protected void btnEnviarPublicacion_Click_Click(object sender, EventArgs e)
        {
            GuardarPublicacion("Pendiente");
            ScriptManager.RegisterStartupScript(this, GetType(), "mostrarModal",
             "mostrarModalConfirmacion();", true);

        }
        protected void btnContinuar_Click(object sender, EventArgs e)
        {
            Response.Redirect("../PublicacionDelUsuario/ListadoPublicaciones.aspx");



        }
        /*
        private void GuardarPublicacion(string estado)
        {
            
             * SIMULACION
            var publicaciones = Session["Publicaciones"] as List<Publicacion> ?? new List<Publicacion>();

            var nueva = new Publicacion
            {
                Id = publicaciones.Count > 0 ? publicaciones.Max(p => p.Id) + 1 : 1,
                Categoria = ddlCategoria.SelectedItem.Text,
                Titulo = txtNombreLibro.Text,
                Descripcion = txtDescripcionLibro.Text,
                Accion = rblAccionLibro.SelectedValue,
                Precio = decimal.TryParse(txtPrecioLibro.Text, out var precio) ? precio : 0,
                Formato = ddlFormatoLibro.SelectedValue,       
                EstadoProducto = ddlEstadoLibro.SelectedItem.Text,
                EstadoPublicacion = estado,
                FechaEnvio = DateTime.Now,
                Subcategoria = ddlSubcategoria.SelectedValue
            };

            var pubEditando = Session["EditarPublicacion"] as Publicacion;
            if (pubEditando != null)
            {
                int index = publicaciones.FindIndex(p => p.Titulo == pubEditando.Titulo);
                if (index != -1) publicaciones[index] = nueva;
                Session["EditarPublicacion"] = null;
            }
            else
            {
                publicaciones.Add(nueva);
            }

            Session["Publicaciones"] = publicaciones;
            if(estado == "Borrador")
            {
                Response.Redirect("ListadoPublicaciones.aspx");
            }   
            */

        private void GuardarPublicacion(string estado)
        {
            
            // Obtener lista de publicaciones en sesión (DTOs)
            //var publicaciones = Session["Publicaciones"] as List<PublicacionDTO> ?? new List<PublicacionDTO>();

            // Crear DTO desde los controles del formulario
            var dto = new PublicacionDTO
            {
                UsuarioId = (int)Session["UsuarioId"],
                Categoria = ddlCategoria.SelectedValue,
                Titulo = string.IsNullOrWhiteSpace(txtNombreLibro.Text) ? null : txtNombreLibro.Text,
                Descripcion = string.IsNullOrWhiteSpace(txtDescripcionLibro.Text) ? null : txtDescripcionLibro.Text,
                Accion = rblAccionLibro.SelectedValue,
                Precio = decimal.TryParse(txtPrecioLibro.Text, out var precio) ? precio : (decimal?)null,
                Periodo = int.TryParse(txtPeriodoLibro.Text, out var periodo) ? periodo : (int?)null,
                Formato = ddlFormatoLibro.SelectedValue,
                EstadoProducto = ddlEstadoLibro.SelectedValue,
                Foto = fuFotoLibro.HasFile ? fuFotoLibro.FileName : null,
                Subcategoria = ddlSubcategoria.SelectedValue,
                EstadoPublicacion = estado,
                FechaEnvio = DateTime.Now
            };
            /*
            // Editando borrador existente
            var editar = Session["EditarPublicacion"] as PublicacionDTO;
            if (editar != null)
            {
                int index = publicaciones.FindIndex(p => p.Titulo == editar.Titulo);
                if (index != -1) publicaciones[index] = dto;
                Session["EditarPublicacion"] = null;
            }
            else
            {
                publicaciones.Add(dto);
            }

            // Guardar lista actualizada en sesión
            Session["Publicaciones"] = publicaciones;

            // Redirección según estado
            if (estado == "Borrador")

            {
                var publicacionBO = new PublicacionBO();
                int idGenerado = publicacionBO.Insertar(dto); // Enviar al backend

                Response.Redirect("ListadoPublicaciones.aspx");
            }
            else // Pendiente
            {
                var publicacionBO = new PublicacionBO();
                int idGenerado = publicacionBO.Insertar(dto); // Enviar al backend
                Response.Redirect("ListadoPublicaciones.aspx");
            }
            */

            var publicacionBO = new PublicacionBO();

            // Si estamos editando (tenemos el DTO original en sesión)
            var editar = Session["EditarPublicacion"] as PublicacionDTO;
            if (editar != null)
            {
                dto.Id = editar.Id;                     // conservar el id existente
                 publicacionBO.Actualizar(dto); // llama al SOAP para actualizar
                                                         // opcional: comprobar ok y mostrar mensaje si falla
               
            }
            else
            {
                // Inserta y recibe el id generado por el backend
                int idGenerado = publicacionBO.Insertar(dto);
                dto.Id = idGenerado;                     // opcional: asignarlo al dto local
                 Session["UltimaPublicacionId"] = idGenerado;
            }

            // Redirigir o mostrar confirmación
            Response.Redirect("../PublicacionDelUsuario/ListadoPublicaciones.aspx");
        }
    }


        /*
         * SIMULACION
        public class Publicacion
        {
            public int Id { get; set; } // 🔹 ID único
            public string Categoria { get; set; }
            public string Titulo { get; set; }
            public string Descripcion { get; set; }
            public string Accion { get; set; }
            public decimal Precio { get; set; }
            public int Periodo { get; set; }
            public string Formato { get; set; }
            public string EstadoProducto { get; set; }
            public string Foto { get; set; }
            public string Subcategoria { get; set; }
            public string EstadoPublicacion { get; set; } // Borrador, Pendiente, Aceptado, Rechazado
            public DateTime FechaEnvio { get; set; } = DateTime.Now;
        }
        */
    
}
