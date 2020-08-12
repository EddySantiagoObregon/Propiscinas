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
public class DetalleProducto  extends Producto{
    private int idDetalleGrupo;
    private Grupo unGrupo;
    private Presentacion unaPresentacion;
    private Forma unaForma;
    private double cantidadUnidad;
    private UnidadMedida unaUnidadMedida;
    private String observacion;
    private String estado;

    public DetalleProducto(String idProducto,String referencia,String nombre,String abreviatura,Grupo unGrupo,Presentacion unaPresentacion,Forma unaForma,double cantidadUnidad,UnidadMedida unaUnidadMedida,String observacion,String estado){
       super(idProducto, referencia, nombre, abreviatura);
        this.unGrupo=unGrupo;
        this.unaPresentacion=unaPresentacion;
        this.unaForma=unaForma;
        this.cantidadUnidad=cantidadUnidad;
        this.unaUnidadMedida=unaUnidadMedida;
        this.observacion=observacion;
        this.estado=estado;

    }


    public DetalleProducto() {
        unGrupo = new Grupo();
        unaPresentacion = new Presentacion();
        unaForma= new Forma();
        unaUnidadMedida = new UnidadMedida();
    }

  

    public Forma getUnaForma() {
        return unaForma;
    }

    public void setUnaForma(Forma unaForma) {
        this.unaForma = unaForma;
    }

   
    public double getCantidadUnidad() {
        return cantidadUnidad;
    }

    public void setCantidadUnidad(double cantidadUnidad) {
        this.cantidadUnidad = cantidadUnidad;
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
    

    public int getIdDetalleGrupo() {
        return idDetalleGrupo;
    }

    public void setIdDetalleGrupo(int idDetalleGrupo) {
        this.idDetalleGrupo = idDetalleGrupo;
    }

    public Grupo getUnGrupo() {
        return unGrupo;
    }

    public void setUnGrupo(Grupo unGrupo) {
        this.unGrupo = unGrupo;
    }

  
    public Presentacion getUnaPresentacion() {
        return unaPresentacion;
    }

    public void setUnaPresentacion(Presentacion unaPresentacion) {
        this.unaPresentacion = unaPresentacion;
    }


    public UnidadMedida getUnaUnidadMedida() {
        return unaUnidadMedida;
    }

    public void setUnaUnidadMedida(UnidadMedida unaUnidadMedida) {
        this.unaUnidadMedida = unaUnidadMedida;
    }

}
