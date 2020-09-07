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
public class ProveedorProducto {
    private int idProveedorProducto;
    private Proveedor unProveedor;
    private DetalleProducto unDetalleProducto;
    private String estado;
    public ProveedorProducto(Proveedor unProveedor,DetalleProducto unDetalleProducto,String estado){
        this.unProveedor=unProveedor;
        this.unDetalleProducto=unDetalleProducto;
        this.estado=estado;
    }
    public ProveedorProducto(){
        unDetalleProducto = new DetalleProducto();
        unProveedor = new Proveedor();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdProveedorProducto() {
        return idProveedorProducto;
    }

    public void setIdProveedorProducto(int idProveedorProducto) {
        this.idProveedorProducto = idProveedorProducto;
    }

    public Proveedor getUnProveedor() {
        return unProveedor;
    }

    public void setUnProveedor(Proveedor unProveedor) {
        this.unProveedor = unProveedor;
    }

    public DetalleProducto getUnDetalleProducto() {
        return unDetalleProducto;
    }

    public void setUnDetalleProducto(DetalleProducto unDetalleProducto) {
        this.unDetalleProducto = unDetalleProducto;
    }

   
    
}
