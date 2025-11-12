using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SquirLearnBusiness
{
    public class PublicacionBO
    {

        private PublicacionClient publicacionSoap;

        public PublicacionBO()
        {
            publicacionSoap = new PublicacionClient();
        }


        //MANDA UNA PUBLICACION A LA BD
        //LO UTILIZA PUBLICA.ASPX.CS
        public void InsertarPublicacion(PublicacionDTO dto)
        {
            publicacionSoap.InsertarPublicacion(
                dto.UsuarioId,
                dto.Categoria,
                dto.Titulo,
                dto.Descripcion,
                dto.Accion,
                dto.Precio,
                dto.Periodo,
                dto.Formato,
                dto.EstadoProducto,
                dto.Foto,
                dto.Subcategoria,
                dto.EstadoPublicacion,
                dto.FechaEnvio
            );
        }

        //RECIBE LAS PUBLICACIONES
        //LO UTILIZA LISTADODEPUBLICACIONES.ASPX.CS
        public List<PublicacionDTO> ObtenerTodas()
        {
            return publicacionSoap.ListarPublicaciones().ToList();
        }

        //ELIMINA UNA PUBLICACION 
        //LO UTILIZA LISTADODEPUBLICACIONES.ASPX.CS

        public void EliminarPublicacion(int idPublicacion)
        {
            publicacionSoap.EliminarPublicacion(idPublicacion);
        }


        //ACTUALIZA UNA PUBLICACION EXISTENTE Y DEVUELVE TRUE SI FUE EXITOSA
        //LO UTILIZA PUBLICA.ASPX.CS

        public bool Actualizar(PublicacionDTO dto)
        {

            return publicacionSoap.actualizarPublicacion(
                dto.IdPublicacion,
                dto.UsuarioId,
                dto.Categoria,
                dto.Titulo,
                dto.Descripcion,
                dto.Accion,
                dto.Precio,
                dto.Periodo,
                dto.Formato,
                dto.EstadoProducto,
                dto.Foto,
                dto.Subcategoria,
                // dto.EstadoPublicacion, esto no se deberia actuzalizar
                dto.FechaEnvio
            );


        }

        //LO UTILIZA ACEPTACIONPUBLICACION.ASPX.CS Y RECHAZOPUBLICACION.ASPX.CS
        public void CambiarEstado(int idPublicacion, string nuevoEstado)
        {
            publicacionSoap.CambiarEstadoPublicacion(idPublicacion, nuevoEstado);
        }


        //LO UTILIZA CATEGORIA.ASPX.CS
        public List<PublicacionDTO> ObtenerPublicacionPorCategoria(string modo,string categoria)
        {


            return publicacionSoap.ListarPublicacionesPorCategoria(modo, categoria).ToList();
        }




        /*
        public class PublicacionDTO
        {
            public int IdPublicacion { get; set; }
            public int UsuarioId { get; set; }
            public string Categoria { get; set; }
            public string Subcategoria { get; set; }
            public string Titulo { get; set; }
            public string Descripcion { get; set; }
            public string Accion { get; set; } // Venta o Alquiler
            public decimal Precio { get; set; }
            public string Formato { get; set; } // Físico o Digital
            public string EstadoProducto { get; set; } // Nuevo o Usado
            public string Periodo { get; set; } // Solo para alquileres
            public string Foto { get; set; } // URL o ruta de la imagen
            public string EstadoPublicacion { get; set; } // Pendiente, Aprobada, Rechazada
            public DateTime FechaEnvio { get; set; }    
        }
        */

    }
}
