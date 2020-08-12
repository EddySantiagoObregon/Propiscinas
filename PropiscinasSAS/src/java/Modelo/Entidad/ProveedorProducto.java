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
    private Producto unProducto;
    public ProveedorProducto(Proveedor unProveedor,Producto unProducto){
        this.unProveedor=unProveedor;
        this.unProducto=unProducto;
    }
    public ProveedorProducto(){
        unProducto = new Producto();
        unProveedor = new Proveedor();
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

    public Producto getUnProducto() {
        return unProducto;
    }

    public void setUnProducto(Producto unProducto) {
        this.unProducto = unProducto;
    }
    
    
    
}
