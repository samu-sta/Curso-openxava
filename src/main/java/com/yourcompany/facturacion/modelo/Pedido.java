package com.yourcompany.facturacion.modelo;

import javax.persistence.*;

@Entity
public class Pedido extends DocumentoComercial {
	@ManyToOne
    DocumentoComercial factura;

}