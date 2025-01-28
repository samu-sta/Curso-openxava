package com.tuempresa.facturacion.calculadores;

import org.openxava.calculators.*;

import com.tuempresa.facturacion.util.*;

public class CalculadorPorcentajeIVA implements ICalculator {
	 
    public Object calculate() throws Exception {
        return PreferenciasFacturacion.getPorcentajeIVADefecto();
    }
}
