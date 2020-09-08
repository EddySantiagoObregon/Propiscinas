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
public class Transaccion {
    private int idTransaccion;
    private String descripcion;
    private String observacion;
    private String estado;
    public Transaccion(int idTransaccion,String descripcion,String observacion,String estado){
        this.descripcion=descripcion;
        this.observacion=observacion;
        this.estado=estado;
    }

    public Transaccion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Transaccion(){
        
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
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
