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
public class ProductoConvertir {
    private int idProductoConvertir;
    private String nombre;
    private int cantidadMedida;
    private DetalleProducto galoncanecabulto;
    private DetalleProducto botellabolsa;

    public ProductoConvertir(String nombre,int cantidadMedida,DetalleProducto galoncanecabulto, DetalleProducto botellabolsa) {
        this.nombre=nombre;
        this.cantidadMedida=cantidadMedida;
        this.galoncanecabulto = galoncanecabulto;
        this.botellabolsa = botellabolsa;
    }
    public ProductoConvertir() {
        galoncanecabulto = new DetalleProducto();
        botellabolsa = new DetalleProducto();
    }

    public ProductoConvertir(String nombre) {
        this.nombre=nombre;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadMedida() {
        return cantidadMedida;
    }

    public void setCantidadMedida(int cantidadMedida) {
        this.cantidadMedida = cantidadMedida;
    }

    

    public int getIdProductoConvertir() {
        return idProductoConvertir;
    }

    public void setIdProductoConvertir(int idProductoConvertir) {
        this.idProductoConvertir = idProductoConvertir;
    }

    public DetalleProducto getGaloncanecabulto() {
        return galoncanecabulto;
    }

    public void setGaloncanecabulto(DetalleProducto galoncanecabulto) {
        this.galoncanecabulto = galoncanecabulto;
    }

    public DetalleProducto getBotellabolsa() {
        return botellabolsa;
    }

    public void setBotellabolsa(DetalleProducto botellabolsa) {
        this.botellabolsa = botellabolsa;
    }
    
    
}
