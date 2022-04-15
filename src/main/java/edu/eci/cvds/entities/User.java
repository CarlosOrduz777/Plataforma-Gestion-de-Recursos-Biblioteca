package edu.eci.cvds.entities;

import lombok.Getter;
import lombok.Setter;
public class User {
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
}
