package edu.eci.cvds.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class User implements Serializable {
    @Getter @Setter private int id;
    @Getter @Setter private String nombre;
    @Getter @Setter private String email;
    @Getter @Setter private String role;


    public User(int id, String nombre, String email, String role){
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.role = role;
    }
    public User(int id,String role){
        this.id=id;
        this.role=role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
