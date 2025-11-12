using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftInvBusiness
{
    public class BuscarPersonaBO
    {

        private UsuarioClient usuarioSoap;

        public BuscarPersonaBO()
        {
            usuarioSoap = new UsuarioClient();
        }


        public PersonaDto BuscarPersonaPorId(int idPersona,int idPublicacion)
        {
            var personaSoap = usuarioSoap.ObtenerPersonaPorId(idPersona,idPublicacion);
            if (personaSoap == null)
            {
                return null; // O manejar el caso de persona no encontrada según sea necesario
            }
            return new PersonaDto
            {
                Id = personaSoap.Id,
                Nombre = personaSoap.Nombre,
                Apellido = personaSoap.Apellido,
                Email = personaSoap.Email,
                Telefono = personaSoap.Telefono
            };
        }

    }
}
