package com.monkeyBank.monkeyBank.models;


import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "usuario")
@ToString
@EqualsAndHashCode
public class Usuario {
    @Id
    @Getter @Setter @Column(name = "id_usuario")
    private Long id_usuario;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "apellido")
    private String apellido;

    @Getter @Setter @Column(name = "email")
    private String email;

    @Getter @Setter @Column(name = "password")
    private String password;

    //Relacion
    /*@MapsId
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Getter @Setter
    private Cuenta cuenta;

    */

}
