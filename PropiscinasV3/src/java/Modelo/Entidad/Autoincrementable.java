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

public class Autoincrementable {
 private int idAutoicrementable;
 private int numero;

    public Autoincrementable(int idAutoicrementable, int numero) {
        this.idAutoicrementable = idAutoicrementable;
        this.numero = numero;
    }

    public Autoincrementable() {
    }

    public int getIdAutoicrementable() {
        return idAutoicrementable;
    }

    public void setIdAutoicrementable(int idAutoicrementable) {
        this.idAutoicrementable = idAutoicrementable;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}
