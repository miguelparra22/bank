package com.monkeyBank.monkeyBank.models;


import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name = "transaccion")
@ToString
@EqualsAndHashCode
public class Transaccion {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Integer id_transaccion;

    @Getter @Setter @Column(name = "id_cuenta")
    private Long id_cuenta;

    @Getter @Setter @Column(name = "fecha_transaccion")
    private Timestamp fecha_transaccion;

    @Getter @Setter @Column(name = "tipo_transaccion")
    private String tipo_transaccion;

/*
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_transaccion")
    @Getter @Setter
    private List<Transaccion> transacciones;

*/
}
