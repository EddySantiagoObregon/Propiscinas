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
public class Documento {
    private int idDocumento;
    private String numerodocumento;
    private TipoDocumento unTipoDocumento;
    private String observacion;
 

    public Documento(String numerodocumento, TipoDocumento unTipoDocumento, String observacion) {
        this.numerodocumento = numerodocumento;
        this.unTipoDocumento = unTipoDocumento;
        this.observacion = observacion;
  
    }

    public Documento() {
       unTipoDocumento = new TipoDocumento();
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public TipoDocumento getUnTipoDocumento() {
        return unTipoDocumento;
    }

    public void setUnTipoDocumento(TipoDocumento unTipoDocumento) {
        this.unTipoDocumento = unTipoDocumento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }


    
}
