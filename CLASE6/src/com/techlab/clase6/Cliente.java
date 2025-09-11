package com.techlab.clase6;

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

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEmail(String email) {
        if (email.contains("@")){
            this.email = email;
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}