/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidad;

import java.util.Random;

/**
 *
 * @author PAULA
 */
public class Usuario {
    private int idUsuario;
    private int identificacion;
    private String nombre;
    private String telefono;
    private String correo;
    private String contrasena;

    public Usuario(int identificacion, String nombre,String telefono, String correo, String contrasena) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.telefono=telefono;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Usuario() {
        
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
      public void genearPassword(){
        String minusculas= "abcdefghijklmnopqrstuvwxyz";
        String mayusculas="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String dijitos="0123456789";
        String especiales="@#$%&?";
        String passwordGenerado="";
        for(int i=0;i<2;i++){
            Random aleatorio= new Random();
            int posmin= aleatorio.nextInt(minusculas.length());
            int posmay=aleatorio.nextInt(mayusculas.length());
            int posDigitos= aleatorio.nextInt(dijitos.length());
            int posEspeciales= aleatorio.nextInt(especiales.length());
            
            passwordGenerado+=minusculas.substring(posmin,posmin+1)+
                    mayusculas.substring(posmay,posmay+1)+
                    dijitos.substring(posDigitos,posDigitos+1)+
                    especiales.substring(posEspeciales,posEspeciales+1);
        }
        
        this.contrasena=passwordGenerado;
    }
   
      
}
