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
public class Grupo {
    private int idGrupo;
    private String descripcion;
    private String obcervacion;
    private String estado;
    public Grupo(String descripcion,String obcervacion,String estado){
        this.descripcion=descripcion;
        this.obcervacion=obcervacion;
        this.estado=estado;
    }

    public Grupo() {
    }

    public Grupo(String descripcion) {
        this.descripcion=descripcion;
    }

    

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
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
