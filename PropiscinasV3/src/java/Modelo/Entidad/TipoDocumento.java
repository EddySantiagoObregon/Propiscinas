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
public class TipoDocumento {
    private int idTipoDocumento;
    private String descripcion;
    private String observacion;
    private String estado;

    public TipoDocumento(String descripcion, String observacion, String estado) {
        this.descripcion = descripcion;
        this.observacion = observacion;
        this.estado = estado;
    }

    public TipoDocumento() {
    }

    public TipoDocumento(String descripcion) {
        this.descripcion=descripcion;
    }

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
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
