package ar.edu.unju.escmi.tp6.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp6.dominio.Factura;

public class CollectionFactura { // esta clase es para poder guardar las facturas en una lista y poder buscarlas por su numero de factura

	public static List<Factura> facturas = new ArrayList<Factura>();// esta lista es para poder guardar las facturas en memoria y poder buscarlas por su numero de factura

	

	public static void agregarFactura(Factura factura) {// este metodo es para poder agregar una factura a la lista de facturas
		
		try {
			facturas.add(factura);
		} catch (Exception e) {
			System.out.println("\nNO SE PUEDE GUARDAR LA FACTURA");
		}
		
	}

	public static Factura buscarFactura(long nroFactura) {// este metodo es para poder buscar una factura por su numero de factura, si no lo encuentra devuelve null
		Factura facturaEncontrada = null;// este objeto es para poder guardar la factura encontrada, si no se encuentra la factura se devuelve null
		
		try {
			if (facturas != null) {// este if es para poder verificar si la lista de facturas no es nula, si es nula devuelve null
				for (Factura fac : facturas) {// este for es para poder recorrer la lista de facturas y buscar la factura por su numero de factura
					if (fac.getNroFactura() == nroFactura) {// este if es para poder verificar si el numero de factura de la factura es igual al numero de factura que se esta buscando
						facturaEncontrada = fac;
					}
				}
			}
		} catch (Exception e) {// este catch es para poder capturar cualquier excepcion que pueda ocurrir al buscar la factura por su numero de factura
			return null;
		}
		
		return facturaEncontrada;// este return es para devolver la factura encontrada por su numero de factura, si no se encuentra devuelve null
	}
}
