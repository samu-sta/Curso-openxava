package com.yourcompany.facturacion.modelo;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter
@View(extendsView="super.DEFAULT",
members="pedidos { pedidos }"
)
@View( name="SinClienteNiPedidos",
members=
    "anyo, numero, fecha;" +
    "detalles;" +
    "observaciones"
)
@Tab(baseCondition = "${eliminado} = false")
@Tab(name="Eliminado", baseCondition = "${eliminado} = true")
public class Factura extends DocumentoComercial{
	
	@OneToMany(mappedBy="factura")
	@CollectionView("SinClienteNiFactura")
    Collection<Pedido> pedidos;

    public static Factura crearDesdePedidos(Collection<Pedido> pedidos)
        throws CrearFacturaException
    {
        Factura factura = null;
        for (Pedido pedido: pedidos) {
            if (factura == null) { // El primero pedido
                pedido.crearFactura(); // Reutilizamos la lógica para crear una
                                       // factura desde un pedido
                factura = pedido.getFactura(); // y usamos la factura creada
            }
            else { // Para el resto de los pedidos la factura ya está creada
                pedido.setFactura(factura); // Asigna la factura
                pedido.copiarDetallesAFactura(); // Un método de Pedido para copiar las lineas
            } 
        } 
        if (factura == null) { // Si no hay pedidos
            throw new CrearFacturaException("pedidos_no_especificados");
        }
        return factura;
    }
}
	
