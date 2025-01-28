package com.tuempresa.facturacion.calculadores; // En el paquete calculadores
 
//Para usar getManager()
import static org.openxava.jpa.XPersistence.getManager;

import org.openxava.calculators.*;

import com.yourcompany.facturacion.modelo.*;

import lombok.*;
 
public class CalculadorPrecioPorUnidad implements ICalculator {
 
    @Getter @Setter
    int numeroProducto;
 
    @Override
    public Object calculate() throws Exception {
        Producto producto = getManager() // getManager()
            .find(Producto.class, numeroProducto);
        return producto.getPrecio();
    }
 
}
