package com.yourcompany.facturacion.modelo;

import javax.persistence.*;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.openxava.annotations.*;

import lombok.*;

@Entity 
@Getter @Setter
public class Cliente {
 
    @Id
    @Column(length=6)
    int numero;
 
    @Column(length=50)
    @Required
    String nombre;
    
    @Embedded @NoFrame
    private Direccion direccion;
 
}
