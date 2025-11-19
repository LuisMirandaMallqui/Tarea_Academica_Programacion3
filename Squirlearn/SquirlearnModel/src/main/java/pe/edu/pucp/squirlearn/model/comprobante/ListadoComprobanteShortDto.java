/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.squirlearn.model.comprobante;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabri
 */
public class ListadoComprobanteShortDto {
    
    private ArrayList<ComprobanteShortDto> lista;
    private Integer totalRegistros;
    
    public ListadoComprobanteShortDto() {
        this.lista = null;
        this.totalRegistros = null;
    }
    
    public ListadoComprobanteShortDto(ArrayList<ComprobanteShortDto> lista, Integer totalRegistros) {
        this.lista = lista;
        this.totalRegistros = totalRegistros;
    }
    
    public List<ComprobanteShortDto> getLista() {
        return lista;
    }

    public void setLista(ArrayList<ComprobanteShortDto> lista) {
        this.lista = lista;
    }

    public Integer getTotalRegistros() {
        return totalRegistros;
    }

    public void setTotalRegistros(Integer totalRegistros) {
        this.totalRegistros = totalRegistros;
    }
    
 }
