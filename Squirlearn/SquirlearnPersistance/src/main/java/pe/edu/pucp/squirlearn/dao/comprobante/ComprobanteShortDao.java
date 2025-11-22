/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.squirlearn.dao.comprobante;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.IDAO;
import pe.edu.pucp.squirlearn.model.comprobante.ComprobanteShortDto;

/**
 *
 * @author luism
 */

public interface ComprobanteShortDao extends IDAO<ComprobanteShortDto> {
    public ArrayList<ComprobanteShortDto> listarPorDuenoComprobanteShort(
            Integer personaId,
            Boolean esVenta,
            Integer pagina,
            Integer cantidadPorPagina
    );
    public Integer listarPorDuenoCantidadComprobanteShort(
            Integer personaId,
            Boolean esVenta
    );
}
