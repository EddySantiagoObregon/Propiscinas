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
public class Forma {
    private int idForma;
    private String descripcion;
    private String obcervacion;
    private String estado;
    public Forma(String descripcion,String obcervacion,String estado){
        this.descripcion=descripcion;
        this.obcervacion=obcervacion;
        this.estado=estado;
    }

    public Forma() {
    }

    public Forma(String descripcion) {
        this.descripcion=descripcion;
    }

    

    public int getidForma() {
        return idForma;
    }

    public void setidForma(int idGrupo) {
        this.idForma = idGrupo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObcervacion() {
        return obcervacion;
    }

    public void setObcervacion(String obcervacion) {
        this.obcervacion = obcervacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
