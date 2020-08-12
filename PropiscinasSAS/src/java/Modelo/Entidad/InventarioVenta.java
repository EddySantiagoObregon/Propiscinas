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
public class InventarioVenta {
    private DetalleProducto unDetalleProducto;
    private String fecharegistro;
    private double cantidadTotal;
    private UnidadMedida unaUnidadMedida;
    private Documento unDocumento;
    private String observacion;
    private String estado;
    private Usuario unUsuario;
    public InventarioVenta(DetalleProducto unDetalleProducto,String fecharegistro,double cantidadTotal,UnidadMedida unaUnidadMedida,Documento unDocumento,String observacion,String estado,Usuario unUsuario){
        this.unDetalleProducto=unDetalleProducto;
        this.fecharegistro=fecharegistro;
        this.cantidadTotal=cantidadTotal;
        this.unaUnidadMedida=unaUnidadMedida;
        this.unDocumento=unDocumento;
        this.observacion=observacion;
        this.estado=estado;
        this.unUsuario=unUsuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public InventarioVenta(){
        unDetalleProducto= new DetalleProducto();
        unaUnidadMedida = new UnidadMedida();
        unDocumento = new Documento();
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

    public double getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(double cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }



    public UnidadMedida getUnaUnidadMedida() {
        return unaUnidadMedida;
    }

    public void setUnaUnidadMedida(UnidadMedida unaUnidadMedida) {
        this.unaUnidadMedida = unaUnidadMedida;
    }

    public Documento getUnDocumento() {
        return unDocumento;
    }

    public void setUnDocumento(Documento unDocumento) {
        this.unDocumento = unDocumento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
}
