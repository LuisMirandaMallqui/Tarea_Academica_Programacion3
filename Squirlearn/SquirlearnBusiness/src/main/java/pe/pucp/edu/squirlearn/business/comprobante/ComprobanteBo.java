package pe.pucp.edu.squirlearn.business.comprobante;

import java.sql.Date;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.comprobante.ComprobanteDao;
import pe.edu.pucp.squirlearn.daoImpl.comprobante.ComprobanteDaoImpl;
import pe.edu.pucp.squirlearn.model.comprobante.ComprobanteDto;
import pe.edu.pucp.squirlearn.model.comprobante.FormaPagoDto;
import pe.edu.pucp.squirlearn.model.comprobante.MonedaPagoDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

public class ComprobanteBo {
    
    private ComprobanteDao comprobanteDao;
    
    public ComprobanteBo(){
        this.comprobanteDao = new ComprobanteDaoImpl();
    }
    
    public Integer insertar(Double monto, String transaccionId, Integer personaId, 
            Integer formaPagoId, Integer monedaId, Double impuesto,Date fechaEmision ,String usuario){
        ComprobanteDto comprobanteDto = new ComprobanteDto();
        
        PersonaDto persona = new PersonaDto();
        persona.setPersonaId(personaId);
        FormaPagoDto formaPago = new FormaPagoDto();
        formaPago.setFormaPagoId(formaPagoId);
        MonedaPagoDto monedaPago = new MonedaPagoDto();
        monedaPago.setMonedaId(monedaId);
        
        comprobanteDto.setMonto(monto);
        comprobanteDto.setTransaccion(transaccionId);
        comprobanteDto.setPersona(persona);
        comprobanteDto.setFormaPago(formaPago);
        comprobanteDto.setMoneda(monedaPago);
        comprobanteDto.setImpuesto(impuesto);
        comprobanteDto.setUsuario(usuario);
        comprobanteDto.setFechaEmision(fechaEmision);
        return this.comprobanteDao.insertar(comprobanteDto);
    }
    
    public ArrayList<ComprobanteDto> listarPorDueno(Integer personaId){
        return this.comprobanteDao.listarPorDueno(personaId); // necesita implementación
    }
    
    public ComprobanteDto obtenerPorId(Integer id){
        return this.comprobanteDao.obtenerPorId(id);
    }
    
}
