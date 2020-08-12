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
public class ProveedorProductoCompra {
    private int idProveedorProductoCompra;
    private ProveedorProducto  unProveedorProducto;
    private Documento unDocuemento;
    public String fecha;
    public String compra;
    public Usuario unUsuario;

    public ProveedorProductoCompra(ProveedorProducto unProveedorProducto, Documento unDocuemento, String fecha, String compra,Usuario unUsuario) {
        this.unProveedorProducto = unProveedorProducto;
        this.unDocuemento = unDocuemento;
        this.fecha = fecha;
        this.compra = compra;
        this.unUsuario = unUsuario;
    }
    
    public ProveedorProductoCompra() {
       unProveedorProducto = new ProveedorProducto();
       unDocuemento = new Documento();
       unUsuario = new Usuario();
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

    public int getIdProveedorProductoCompra() {
        return idProveedorProductoCompra;
    }

    public void setIdProveedorProductoCompra(int idProveedorProductoCompra) {
        this.idProveedorProductoCompra = idProveedorProductoCompra;
    }

    public ProveedorProducto getUnProveedorProducto() {
        return unProveedorProducto;
    }

    public void setUnProveedorProducto(ProveedorProducto unProveedorProducto) {
        this.unProveedorProducto = unProveedorProducto;
    }

    public Documento getUnDocuemento() {
        return unDocuemento;
    }

    public void setUnDocuemento(Documento unDocuemento) {
        this.unDocuemento = unDocuemento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCompra() {
        return compra;
    }

    public void setCompra(String compra) {
        this.compra = compra;
    }
    
    
            
}
