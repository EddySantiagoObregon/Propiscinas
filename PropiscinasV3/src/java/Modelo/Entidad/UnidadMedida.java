/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidad;

/**
 *
 * @author PAULA
 */
public class UnidadMedida {
    private int idUnidadMedida;
    private String descripcion;
    private String observacion;
    private String estado;
    public UnidadMedida(String descripcion,String observacion,String estado){
        this.descripcion=descripcion;
        this.observacion=observacion;
        this.estado=estado;
    }

    public UnidadMedida(String descripcion) {
        this.descripcion = descripcion;
    }
    

    public UnidadMedida() {
    }
    
    public int getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(int idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
