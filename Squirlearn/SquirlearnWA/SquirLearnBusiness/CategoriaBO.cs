using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SquirLearnBusiness
{
    public class CategoriaBO
    {

        private ListarCategoriaClient listarCategoriaSoap;

        public CategoriaBO()
        {
            listarCategoriaSoap = new ListarCategoriaClient();
        }

        //LO USA SQUIRLEARNINICIO.ASPX.CS
        //OBTIENE LAS CATEGORIAS DE LA BD Y LO MUESTRA EN LA PANTALLA PRINCIPAL

        public List<CategoriaDTO> ObtenerCategorias()
        {
            return listarCategoriaSoap.ListarCategorias().ToList();
        }





        /*
        public class CategoriaDTO
        {
            public int IdCategoria { get; set; }
            public string Nombre{ get; set; } NOMBRE DE LA CATEGORIA CURSO,LIBRO, ETC
            public string UrlImagen { get; set; }
            
        }
        */
    }
}
