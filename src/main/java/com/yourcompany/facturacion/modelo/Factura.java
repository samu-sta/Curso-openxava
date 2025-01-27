package com.yourcompany.facturacion.modelo;

import java.util.*;

import javax.persistence.*;

public class Factura extends DocumentoComercial{
	
	@OneToMany(mappedBy="factura")
    Collection<Pedido> pedidos;
}
