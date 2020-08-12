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
public class InventarioInfraestructura {
    private int idInventenario;
    private DetalleProducto unDetalleProducto;
    private String fecha;
    private Infraestructura unaInfraestructura;
    private int cantidad;
    private String observacion;
    private Usuario unUsuario;

    public InventarioInfraestructura(DetalleProducto unDetalleProducto, String fecha, Infraestructura unaInfraestructura, int cantidad, String observacion,Usuario unUsuario) {
        this.unDetalleProducto = unDetalleProducto;
        this.fecha = fecha;
        this.unaInfraestructura = unaInfraestructura;
        this.cantidad = cantidad;
        this.observacion = observacion;
        this.unUsuario=unUsuario;
    }

    public InventarioInfraestructura() {
        unDetalleProducto = new DetalleProducto();
        unaInfraestructura = new Infraestructura();
        unUsuario = new Usuario();
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

   

    public int getIdInventenario() {
        return idInventenario;
    }

    public void setIdInventenario(int idInventenario) {
        this.idInventenario = idInventenario;
    }

    public DetalleProducto getUnDetalleProducto() {
        return unDetalleProducto;
    }

    public void setUnDetalleProducto(DetalleProducto unDetalleProducto) {
        this.unDetalleProducto = unDetalleProducto;
    }



    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Infraestructura getUnaInfraestructura() {
        return unaInfraestructura;
    }

    public void setUnaInfraestructura(Infraestructura unaInfraestructura) {
        this.unaInfraestructura = unaInfraestructura;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    
}
