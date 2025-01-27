package com.yourcompany.facturacion.modelo;

import javax.persistence.*;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.*;

import lombok.*;

@Entity @Getter @Setter
public class Producto {
 
    @Id @Column(length=9)
    int numero;
 
    @Column(length=50) @Required
    String descripcion;
 
}
