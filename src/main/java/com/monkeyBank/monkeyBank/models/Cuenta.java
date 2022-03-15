package com.monkeyBank.monkeyBank.models;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "cuenta")
@ToString
@EqualsAndHashCode
public class Cuenta {



    @Id
    @Getter @Setter @Column(name = "id_cuenta")
    private Integer id_cuenta;

    @Getter @Setter @Column(name = "id_usuario_cuenta")
    private Integer id_usuario_cuenta;

    @Getter @Setter @Column(name = "fecha_creacion")
    private Timestamp fecha_creacion;

    @Getter @Setter @Column(name = "saldo")
    private Long saldo;

    //Relacion

    // Que columna en la tabla Cuenta tiene la FK
   /* @JoinColumn(name = "id_usuario")
    @OneToOne(fetch = FetchType.LAZY)
    @Getter @Setter
    private  Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter @Setter
    private List<Transaccion> trasacciones;

    *
    */
}
