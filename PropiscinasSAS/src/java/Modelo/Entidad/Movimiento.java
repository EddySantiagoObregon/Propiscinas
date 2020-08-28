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
public class Movimiento {
    private int idMovimiento;
    private Infraestructura unaInfraestructura;
    private Transaccion unaTransaccion;
    private String numerofactura;
    private DetalleProducto unDetalleProducto;
    private String fecharegistro;
    private int cantidad;
    private UnidadMedida unaUnidadMedida;
    private Documento unDocumento;
    private Infraestructura unaInfraestructuraDespacho;
    private String observacion;
    private String estado;
    private Usuario unUsuario;

    public Movimiento( Infraestructura unaInfraestructura, Transaccion unaTransaccion, String numerofactura,DetalleProducto unDetalleProducto, String fecharegistro, int cantidad,UnidadMedida unaUnidadMedida,Documento unDocumento, Infraestructura unaInfraestructuraDespacho, String observacion, String estado,Usuario unUsuario) {
        this.unaInfraestructura = unaInfraestructura;
        this.unaTransaccion = unaTransaccion;
        this.numerofactura = numerofactura;
        this.unDetalleProducto=unDetalleProducto;
        this.fecharegistro = fecharegistro;
        this.cantidad = cantidad;
        this.unaUnidadMedida = unaUnidadMedida;
        this.unDocumento=unDocumento;
        this.unaInfraestructuraDespacho = unaInfraestructuraDespacho;
        this.observacion = observacion;
        this.estado = estado;
        this.unUsuario=unUsuario;
    }

    public Movimiento() {
        unaInfraestructura = new Infraestructura();
        unaTransaccion = new Transaccion();
        unDetalleProducto= new DetalleProducto();
        unaInfraestructuraDespacho = new Infraestructura();
        unaUnidadMedida=new UnidadMedida();
       unDocumento=new Documento();
       unUsuario=new Usuario();
    }

    public Documento getUnDocumento() {
        return unDocumento;
    }

    public void setUnDocumento(Documento unDocumento) {
        this.unDocumento = unDocumento;
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }
    



    public UnidadMedida getUnaUnidadMedida() {
        return unaUnidadMedida;
    }

    public void setUnaUnidadMedida(UnidadMedida unaUnidadMedida) {
        this.unaUnidadMedida = unaUnidadMedida;
    }

    public DetalleProducto getUnDetalleProducto() {
        return unDetalleProducto;
    }

    public void setUnDetalleProducto(DetalleProducto unDetalleProducto) {
        this.unDetalleProducto = unDetalleProducto;
    }


    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Infraestructura getUnaInfraestructura() {
        return unaInfraestructura;
    }

    public void setUnaInfraestructura(Infraestructura unaInfraestructura) {
        this.unaInfraestructura = unaInfraestructura;
    }

    public Transaccion getUnaTransaccion() {
        return unaTransaccion;
    }

    public void setUnaTransaccion(Transaccion unaTransaccion) {
        this.unaTransaccion = unaTransaccion;
    }

    public String getNumerofactura() {
        return numerofactura;
    }

    public void setNumerofactura(String numerofactura) {
        this.numerofactura = numerofactura;
    }

    public String getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


   
    public Infraestructura getUnaInfraestructuraDespacho() {
        return unaInfraestructuraDespacho;
    }

    public void setUnaInfraestructuraDespacho(Infraestructura unaInfraestructuraDespacho) {
        this.unaInfraestructuraDespacho = unaInfraestructuraDespacho;
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
