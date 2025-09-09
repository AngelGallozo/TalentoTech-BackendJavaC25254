package com.techlab.clase5;

public class Cliente {
    private String nombre;
    private String email;

    public Cliente(String nom, String mail){
        this.nombre = nom;
        this.email = mail;
    }

    public void mostrarInformacion(){
        System.out.println("Nombre: "+this.nombre+", E-mail: "+this.email);
    }

}
