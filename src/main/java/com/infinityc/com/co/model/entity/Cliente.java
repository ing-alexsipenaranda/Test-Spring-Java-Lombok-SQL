package com.infinityc.com.co.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
@Table(name = "clientes")
public class Cliente implements Serializable {
    @Id
    @Column(name = "id_cliente") //hacer referencia a la columna de la table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //
    private Integer idCliente;
    @Column(name ="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;
    @Column(name="correo")
    private String correo;
    @Column(name = "fechaRegistro")
    private Date fechaRegistro;



}