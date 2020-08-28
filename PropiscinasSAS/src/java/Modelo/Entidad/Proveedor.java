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
public class Proveedor {
    private int idProveedor;
    private String nitProveedor;
    private String nombre;
    private String telefono;
    private String correo;
    private String estado;
    public Proveedor(String nitProveedor,String nombre,String telefono,String correo,String estado){
        this.nitProveedor=nitProveedor;
        this.nombre=nombre;
        this.telefono=telefono;
        this.correo=correo;
        this.estado=estado;
       
    }
      public Proveedor(){
       
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Proveedor(String nombre) {
        this.nombre = nombre;
    }


    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }



    public String getNitProveedor() {
        return nitProveedor;
    }

    public void setNitProveedor(String nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
