package ar.edu.unju.escmi.tp6.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp6.dominio.Producto;
import ar.edu.unju.escmi.tp6.dominio.Stock;
import ar.edu.unju.escmi.tp6.exceptions.StockInsuficienteException;

public class CollectionStock {

	public static List<Stock> stocks = new ArrayList<Stock>();//esta lista es para poder guardar los stocks en memoria y poder buscarlos por su producto

	public static void precargarStocks() {
		if (stocks.isEmpty()) {
			stocks = new ArrayList<Stock>();
			stocks.add(new Stock(12, CollectionProducto.productos.get(0)));
			stocks.add(new Stock(22, CollectionProducto.productos.get(1)));
			stocks.add(new Stock(13, CollectionProducto.productos.get(2)));
			stocks.add(new Stock(101, CollectionProducto.productos.get(3)));
			stocks.add(new Stock(87, CollectionProducto.productos.get(4)));
			stocks.add(new Stock(45, CollectionProducto.productos.get(5)));
			stocks.add(new Stock(16, CollectionProducto.productos.get(6)));
			stocks.add(new Stock(8, CollectionProducto.productos.get(7)));
			stocks.add(new Stock(5, CollectionProducto.productos.get(8)));
			stocks.add(new Stock(21, CollectionProducto.productos.get(9)));
			stocks.add(new Stock(17, CollectionProducto.productos.get(10)));
			stocks.add(new Stock(11, CollectionProducto.productos.get(11)));
			stocks.add(new Stock(8, CollectionProducto.productos.get(12)));
			stocks.add(new Stock(14, CollectionProducto.productos.get(13)));
			stocks.add(new Stock(4, CollectionProducto.productos.get(14)));
			stocks.add(new Stock(15, CollectionProducto.productos.get(15)));
			stocks.add(new Stock(28, CollectionProducto.productos.get(16)));
			stocks.add(new Stock(47, CollectionProducto.productos.get(17)));
			stocks.add(new Stock(33, CollectionProducto.productos.get(18)));
			stocks.add(new Stock(13, CollectionProducto.productos.get(19)));
		}
	}//este metodo es para poder precargar los stocks en la lista de stocks, si la lista esta vacia

	public static void agregarStock(Stock stock) {//este metodo es para poder agregar un stock a la lista de stocks
		
		try {
			if (stocks.isEmpty()) {// este if es para poder verificar si la lista de stocks esta vacia, si esta vacia agrega el stock a la lista
				stocks.add(stock);
			} else {
				Producto controlProducto = stock.getProducto();// este objeto es para poder guardar el producto del stock que se quiere agregar a la lista de stocks
				boolean band = true;
				int i = 0;

				for (Stock sto : stocks) {// este for es para poder recorrer la lista de stocks y verificar si el producto del stock que se quiere agregar ya existe en la lista de stocks
					if (band) {
						if (controlProducto == sto.getProducto()) {// este if es para poder verificar si el producto del stock que se quiere agregar ya existe en la lista de stocks
							stocks.set(i, stock);
							band = false;
						}
					}
					i++;
				}
				if (band) {// este if es para poder verificar si el producto del stock que se quiere agregar ya existe en la lista de stocks, si no existe agrega el stock a la lista
					stocks.add(stock);
				}
			}
		} catch (Exception e) {// este catch es para poder capturar cualquier excepcion que pueda ocurrir al agregar un stock a la lista de stocks			
			System.out.println("\nNO SE PUEDE GUARDAR EL STOCK");
		}
		
	}

	public static void reducirStock(Stock stock, int cantidad) {// este metodo es para poder reducir la cantidad de un stock en la lista de stocks, si no hay suficiente stock lanza una excepcion
		int i = stocks.indexOf(stock);// este objeto es para poder guardar el indice del stock que se quiere reducir en la lista de stocks
		if (i >= 0) {
			if (stock.getCantidad() - cantidad >= 0) {// este if es para poder verificar si hay suficiente stock para reducir la cantidad, si no hay suficiente stock lanza una excepcion
				stock.setCantidad(stock.getCantidad() - cantidad);
				stocks.set(i, stock);
			} else {// este else es para poder lanzar una excepcion si no hay suficiente stock para reducir la cantidad
				throw new StockInsuficienteException("Stock insuficiente. Disponible: " + stock.getCantidad());
			}
		} else {
			System.out.println("\nERROR");// este else es para poder capturar cualquier excepcion que pueda ocurrir al reducir la cantidad de un stock en la lista de stocks
		}
	}

	public static Stock buscarStock(Producto producto) {// este metodo es para poder buscar un stock por su producto, si no lo encuentra devuelve null
		Stock stockTotal = null;
		
		try {
			if (stocks != null) {// este if es para poder verificar si la lista de stocks no es nula, si es nula devuelve null
				for (Stock sto : stocks) {// este for es para poder recorrer la lista de stocks y buscar el stock por su producto
					if (sto.getProducto() == producto) {
						stockTotal = sto;
					}
				}
			}
		} catch (Exception e) {// este catch es para poder capturar cualquier excepcion que pueda ocurrir al buscar el stock por su producto
			return null;
		}
		
		return stockTotal;
	}
}
