using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftInvBusiness
{
    public class NotificacionBO
    {

        private NotificacionClient notificacionSOAP;



        public NotificacionBO()
        {
            this.notificacionSOAP = new NotificacionClient();
        }
        //LO UTILIZA NOTIFICACIONES.ASPX.CS, ENVIA EL ID Y RECIBE EL MENSAJE Y LA FECHA
        public List<NotificacionDTO> ObtenerPorUsuario(int usuarioId)
        {
            return notificacionSOAP.ListarNotificacionesPorUsuario(usuarioId).ToList();
        }

        public void Insertar(NotificacionDTO dto)
        {
            this.notificacionSOAP.InsertarNotificacion(
                dto.UsuarioId,
                dto.Mensaje,
                dto.Fecha
            );
        }
    }
}
