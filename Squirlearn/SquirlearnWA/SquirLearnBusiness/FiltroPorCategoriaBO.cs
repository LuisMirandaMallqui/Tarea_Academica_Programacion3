using SquirLearnBusiness;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftInvBusiness
{
    public class FiltroPorCategoriaBO
    {

        private CategoriaClient categoriaSoap;

        //FILTRO DE BUSQUEDA POR CATEGORIA, LO UTILIZA LIBROS.ASPX.CS, INSTRUMENTOS.ASPX.CS,OTROS.ASPX.CS,CURSOS.ASPX.CS,
        //APUNTES.ASPX.CS,CLASES ASPX.CS
        public FiltroPorCategoriaBO()
        {
            categoriaSoap = new CategoriaClient();
        }


        public List<PublicacionDTO> FiltrarPorCategoria(
              string categoria,      // “Libros”, “Instrumentos”, etc.
              string tipo,           // “Venta” o “Alquiler”
              string palabraClave,   // texto de búsqueda
              string condicion,      // Nuevo / Usado
              string subcategoria,    // subcategoría específica
              string tamano,
              string color
            )
        {
            // 🔹 Llamada al servicio SOAP pasando los parámetros del filtro
            var resultadoSoap = categoriaSoap.FiltrarPublicaciones(
                categoria, tipo, palabraClave, condicion, subcategoria, tamano, color
            );

            // 🔹 Mapeamos la respuesta al DTO
            List<PublicacionDTO> lista = new List<PublicacionDTO>();
            foreach (var item in resultadoSoap)
            {
                lista.Add(new PublicacionDTO
                {
                    IdPublicaion = item.IdPublicacion,
                    IdVendedor = item.IdVendedor,
                    ImagenUrl = item.Foto,
                    Titulo = item.Titulo,
                    Subcategoria = item.Subcategoria,
                    Precio = item.Precio,
                    Descripcion = item.Descripcion,
                    EstadoProducto = item.EstadoProducto
                });
            }

            return lista;
        }

    }

   


}
