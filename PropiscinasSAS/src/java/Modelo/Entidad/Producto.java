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
public class Producto {
     private String idProducto;
     private String referencia;
     private String nombre;
     private String abreviatura;
 
     public Producto(String idProducto,String referencia,String nombre,String abreviatura){; 
         this.idProducto=idProducto; 
         this.referencia=referencia;
         this.nombre=nombre;
         this.abreviatura=abreviatura;
       
     }

    public Producto() {
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

 
     

   

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }



 
     
}
