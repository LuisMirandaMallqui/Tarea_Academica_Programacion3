package pe.pucp.edu.squirlearn.business.comprobante;

import java.util.Date;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.comprobante.ComprobanteDao;
import pe.edu.pucp.squirlearn.dao.comprobante.ComprobanteShortDao;
import pe.edu.pucp.squirlearn.daoImpl.comprobante.ComprobanteDaoImpl;
import pe.edu.pucp.squirlearn.model.comprobante.ComprobanteDto;
import pe.edu.pucp.squirlearn.model.comprobante.FormaPagoDto;
import pe.edu.pucp.squirlearn.model.comprobante.ListadoComprobanteShortDto;
import pe.edu.pucp.squirlearn.model.comprobante.MonedaPagoDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

public class ComprobanteBo {

    private ComprobanteDao comprobanteDao;
    private MonedaPagoBo monedaPagoBo;
    private FormaPagoBo formaPagoBo;
    private DetalleComprobanteBo detalleComprobanteBo;
    private ComprobanteShortDao comprobanteShortDao;

    public ComprobanteBo() {
        this.comprobanteDao = new ComprobanteDaoImpl();
        this.detalleComprobanteBo = new DetalleComprobanteBo();
        this.monedaPagoBo = new MonedaPagoBo();
        this.formaPagoBo = new FormaPagoBo();
    }

    //insertar comprobante listo
    public Integer insertar(Double monto, String transaccionId, Integer personaId,
            String formaPago, String moneda, Double impuesto, String fechaEmision, String usuarioCreacion,
            Integer itemId, Integer alquilerId, String nombreProducto) {

        ComprobanteDto comprobanteDto = new ComprobanteDto();
        Integer formaPagoId = formaPagoBo.obtenerId(formaPago.toUpperCase());
        Integer monedaId = monedaPagoBo.obtenerId(moneda.toUpperCase());

        PersonaDto persona = new PersonaDto();
        persona.setPersonaId(personaId);
        FormaPagoDto forma = new FormaPagoDto();
        forma.setFormaPagoId(formaPagoId);
        MonedaPagoDto monedaPago = new MonedaPagoDto();
        monedaPago.setMonedaId(monedaId);

        comprobanteDto.setMonto(monto);
        comprobanteDto.setTransaccion(transaccionId);
        comprobanteDto.setPersona(persona);
        comprobanteDto.setFormaPago(forma);
        comprobanteDto.setMoneda(monedaPago);
        comprobanteDto.setImpuesto(impuesto);
        comprobanteDto.setusuarioCreacion(usuarioCreacion);
        if (fechaEmision.compareTo("0") == 0) {
            fechaEmision = null;
        }
        comprobanteDto.setFechaEmision(fechaEmision);

        Integer comprobanteId = this.comprobanteDao.insertar(comprobanteDto);
        this.detalleComprobanteBo.insertar(nombreProducto, monto, itemId, alquilerId, comprobanteId, usuarioCreacion);
        return comprobanteId;
    }

    public Integer modificar(Integer compID, Double monto, String transaccionId, Integer personaId,
            Integer formaPagoId, Integer monedaId, Double impuesto, String fechaEmision, String usuarioCreacion) {
        ComprobanteDto comprobanteDto = new ComprobanteDto();

        PersonaDto persona = new PersonaDto();
        persona.setPersonaId(personaId);
        FormaPagoDto formaPago = new FormaPagoDto();
        formaPago.setFormaPagoId(formaPagoId);
        MonedaPagoDto monedaPago = new MonedaPagoDto();
        monedaPago.setMonedaId(monedaId);
        comprobanteDto.setComprobanteId(compID);
        comprobanteDto.setMonto(monto);
        comprobanteDto.setTransaccion(transaccionId);
        comprobanteDto.setPersona(persona);
        comprobanteDto.setFormaPago(formaPago);
        comprobanteDto.setMoneda(monedaPago);
        comprobanteDto.setImpuesto(impuesto);
        comprobanteDto.setusuarioCreacion(usuarioCreacion);
        comprobanteDto.setFechaEmision(fechaEmision);
        return this.comprobanteDao.modificar(comprobanteDto);
    }

    public ListadoComprobanteShortDto listarPorDuenoComprobanteShort(Integer personaId,Boolean esVenta, Integer pagina, Integer registrosPorPagina) {
         
        ListadoComprobanteShortDto listado = new ListadoComprobanteShortDto();
        listado.setLista(this.comprobanteShortDao.listarPorDuenoComprobanteShort(personaId,esVenta, pagina, registrosPorPagina));
        listado.setTotalRegistros(this.comprobanteShortDao.listarPorDuenoCantidadComprobanteShort(personaId, esVenta));
        return listado;
    }

    public ComprobanteDto obtenerPorId(Integer id) {
        return this.comprobanteDao.obtenerPorId(id);
    }

}
