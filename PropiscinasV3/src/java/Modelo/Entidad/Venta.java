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
public class Venta {
   private DetalleProducto unDetalleProducto;
   private String fecharegistro;
   private double cantidad;
   private String valor;
   private String observacion;
   private String estado;
   private Usuario unUsuario;
   public Venta(DetalleProducto unDetalleProducto,String fecharegistro,double cantidad,String valor,String obcervacion,String estado,Usuario unUsuario){
      this.unDetalleProducto=unDetalleProducto;
      this.fecharegistro=fecharegistro;   
      this.cantidad=cantidad;
      this.valor=valor;
      this.observacion=obcervacion;
      this.estado=estado;
      this.unUsuario=unUsuario;
   }

  public Venta() {
       unDetalleProducto = new DetalleProducto();
       unUsuario = new Usuario();
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }


    public DetalleProducto getUnDetalleProducto() {
        return unDetalleProducto;
    }

    public void setUnDetalleProducto(DetalleProducto unDetalleProducto) {
        this.unDetalleProducto = unDetalleProducto;
    }
  

    public String getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
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
