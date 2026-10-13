package ar.edu.unju.escmi.tp6.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp6.dominio.TarjetaCredito;

public class CollectionTarjetaCredito {

	public static List<TarjetaCredito> tarjetas = new ArrayList<TarjetaCredito>();//esta lista es para poder guardar las tarjetas de credito en memoria y poder buscarlas por su numero

    public static void precargarTarjetas() {//este metodo es para poder precargar las tarjetas de credito en la lista de tarjetas, si la lista esta vacia
		if (tarjetas.isEmpty()) {//este if es para poder verificar si la lista de tarjetas de credito esta vacia, si esta vacia precarga las tarjetas de credito en la lista
			tarjetas = new ArrayList<TarjetaCredito>();
			tarjetas.add(new TarjetaCredito(232323, LocalDate.of(2026,10,10), CollectionCliente.buscarCliente(45111222), 800000));
			tarjetas.add(new TarjetaCredito(4458444, LocalDate.of(2030, 3, 15), CollectionCliente.buscarCliente(36888666), 900000));
			tarjetas.add(new TarjetaCredito(8754566, LocalDate.of(2030, 4, 21), CollectionCliente.buscarCliente(25777555), 1000000));
		}
	}//este metodo es para poder precargar las tarjetas de credito en la lista de tarjetas, si la lista esta vacia

	
	public static void agregarTarjetaCredito(TarjetaCredito tarjeta) {//este metodo es para poder agregar una tarjeta de credito a la lista de tarjetas de credito
		
		try {//este try es para poder capturar cualquier excepcion que pueda ocurrir al agregar una tarjeta de credito a la lista de tarjetas de credito
			tarjetas.add(tarjeta);
		} catch (Exception e) {//	este catch es para poder capturar cualquier excepcion que pueda ocurrir al agregar una tarjeta de credito a la lista de tarjetas de credito
			System.out.println("\nNO SE PUEDE GUARDAR LA TARJETA DE CREDITO");
		}
		
	}//este metodo es para poder agregar una tarjeta de credito a la lista de tarjetas de credito

	public static TarjetaCredito buscarTarjetaCredito(long numero) {//este metodo es para poder buscar una tarjeta de credito por su numero, si no lo encuentra devuelve null
		TarjetaCredito tarjetaEncontrada = null;
		
		try {
			if (tarjetas != null) {//este if es para poder verificar si la lista de tarjetas de credito no es nula, si es nula devuelve null
				for (TarjetaCredito tarjeta : tarjetas) {
					if (tarjeta.getNumero() == numero) {//este if es para poder verificar si el numero de la tarjeta de credito es igual al numero que se esta buscando
						tarjetaEncontrada = tarjeta;
					}
				}
			}
		} catch (Exception e) {//este catch es para poder capturar cualquier excepcion que pueda ocurrir al buscar una tarjeta de credito por su numero
			return null;
		}
		
		return tarjetaEncontrada;
	}//este metodo es para poder buscar una tarjeta de credito por su numero, si no lo encuentra devuelve null
}
