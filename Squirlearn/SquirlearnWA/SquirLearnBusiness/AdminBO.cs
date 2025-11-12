using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SquirLearnBusiness
{
    public class AdminBO
    {
        private readonly AdminClient adminSoap;

        public AdminBO()
        {
            this.adminSoap = new AdminClient();
        }


        //RECIBE LAS SOLICITUDES PENDIENTES, SE TIENE QUE MOSTRAR LA FECHA Y EL NOMBRE DEL USUARIO
        //LO UTILIZA LISTADODESOLICITUDESADMIN.ASPX.CS


        public List<SolicitudDTO> ListarSolicitudesPendientes()
        {
            // 10 Llamamos al SOAP que devuelve publicaciones pendientes
            var publicacionesPendientes = adminSoap.listarPublicacionesPendientes();

            // 20 Convertimos a una lista de DTOs con los campos que queremos mostrar
            var lista = new List<SolicitudDTO>();

            foreach (var pub in publicacionesPendientes)
            {
                // BUSCO EL NOMBRE DE USUSARIO POR EL ID DE USUARIO
                string nombreUsuario = adminSoap.obtenerNombreUsuario(pub.UsuarioId);
                lista.Add(new SolicitudDTO
                {
                    IdSolicitud = pub.IdPublicacion,
                    UsuarioId = pub.UsuarioId,
                    NombreUsuario = pub.nombreUsuario,
                    FechaEnvio = pub.FechaEnvio,
                   
                });




            }
            return lista;

        }

        //OBTIENE UNA PUBLICACION POR SU ID
        //LO UTILIZA SOLICITUDPEDIDOSADMIN.ASPX.CS

        public PublicacionDTO ObtenerPorId(int id)
        {
            var p = adminSoap.obtenerPublicacionPorId(id);
            return new PublicacionDTO
            {
                IdPublicacion = p.Id,
                UsuarioId = p.UsuarioId,
                Categoria = p.Categoria,
                Subcategoria = p.Subcategoria,
                Titulo = p.Titulo,
                Descripcion = p.Descripcion,
                Accion = p.Accion,
                Precio = p.Precio,
                Formato = p.Formato,
                EstadoProducto = p.EstadoProducto,
                Periodo = p.Periodo,
                Foto = p.Foto,
                FechaEnvio = p.FechaEnvio
            };

        }

        //OBTIENE EL NOMBRE DE USUARIO POR SU ID
        //LO UTILIZA SOLICITUDPEDIDOSADMIN.ASPX.CS

        string obtenerNombreUsuario(int usuarioId) {

            return adminSoap.obtenerNombreUsuario(usuarioId);

        }
        /*

        public class SolicitudDTO
        {
            public int IdPublicacion { get; set; }
            public int UsuarioId { get; set; }
            public string NombreUsuario { get; set; }
            public DateTime FechaEnvio { get; set; }
        }
        */

    }
}
