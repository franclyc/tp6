package ar.edu.unju.escmi.tp6.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.escmi.tp6.collections.CollectionCliente;
import ar.edu.unju.escmi.tp6.collections.CollectionCredito;
import ar.edu.unju.escmi.tp6.collections.CollectionFactura;
import ar.edu.unju.escmi.tp6.collections.CollectionProducto;
import ar.edu.unju.escmi.tp6.collections.CollectionStock;
import ar.edu.unju.escmi.tp6.collections.CollectionTarjetaCredito;
import ar.edu.unju.escmi.tp6.dominio.Cliente;
import ar.edu.unju.escmi.tp6.dominio.Credito;
import ar.edu.unju.escmi.tp6.dominio.Detalle;
import ar.edu.unju.escmi.tp6.dominio.Factura;
import ar.edu.unju.escmi.tp6.dominio.Producto;
import ar.edu.unju.escmi.tp6.dominio.Stock;
import ar.edu.unju.escmi.tp6.dominio.TarjetaCredito;
import ar.edu.unju.escmi.tp6.exceptions.ClienteNoEncontradoException;
import ar.edu.unju.escmi.tp6.exceptions.LimiteTarjetaInsuficienteException;
import ar.edu.unju.escmi.tp6.exceptions.MontoExcedidoException;
import ar.edu.unju.escmi.tp6.exceptions.StockInsuficienteException;

public class Main {//esta clase es para poder ejecutar el programa y probar las funcionalidades de la aplicacion

	private static final Scanner scanner = new Scanner(System.in);//esta variable es para poder leer la entrada del usuario desde la consola

	public static void main(String[] args) {//este metodo es para poder ejecutar el programa y probar las funcionalidades de la aplicacion
		CollectionCliente.precargarClientes();//este metodo es para poder precargar los datos de los clientes, tarjetas de credito, productos y stocks en memoria para poder probar las funcionalidades de la aplicacion
		CollectionTarjetaCredito.precargarTarjetas();//este metodo es para poder precargar los datos de los clientes, tarjetas de credito, productos y stocks en memoria para poder probar las funcionalidades de la aplicacion
		CollectionProducto.precargarProductos();//este metodo es para poder precargar los datos de los clientes, tarjetas de credito, productos y stocks en memoria para poder probar las funcionalidades de la aplicacion
		CollectionStock.precargarStocks();//este metodo es para poder precargar los datos de los clientes, tarjetas de credito, productos y stocks en memoria para poder probar las funcionalidades de la aplicacion

		int opcion;//esta variable es para poder guardar la opcion que el usuario ingresa desde la consola para poder ejecutar la funcionalidad correspondiente
		do {
			mostrarMenu();
			opcion = leerOpcion();
			try {
				switch (opcion) {
				case 1:
					realizarVenta();
					break;
				case 2:
					consultarCompras();
					break;
				case 3:
					mostrarProductos();
					break;
				case 4:
					consultarStock();
					break;
				case 5:
					consultarCreditos();
					break;
				case 6:
					System.out.println("Hasta luego.");
					break;
				default:
					System.out.println("Opcion invalida. Ingrese un numero del 1 al 6.");
				}
			} catch (ClienteNoEncontradoException | StockInsuficienteException | MontoExcedidoException
					| LimiteTarjetaInsuficienteException e) {
				System.out.println("\n" + e.getMessage());
			}
		} while (opcion != 6);//este while es para poder ejecutar el menu principal del programa hasta que el usuario ingrese la opcion 6 para salir del programa
		scanner.close();
	}

	private static void mostrarMenu() {//este metodo es para poder mostrar el menu principal del programa y las opciones que el usuario puede elegir para ejecutar las funcionalidades de la aplicacion
		System.out.println("\n====== Menu Principal =====");
		System.out.println("1- Realizar una venta");
		System.out.println("2- Revisar compras realizadas por el cliente (debe ingresar el DNI del cliente)");
		System.out.println("3- Mostrar lista de los electrodomesticos");
		System.out.println("4- Consultar stock");
		System.out.println("5- Revisar creditos de un cliente (debe ingresar el DNI del cliente)");
		System.out.println("6- Salir");
	}

	private static int leerOpcion() {
		while (true) {
			String entrada = leerTexto("Ingrese su opcion: ");
			try {
				return Integer.parseInt(entrada);
			} catch (NumberFormatException e) {
				System.out.println("Debe ingresar un numero valido.");
			}
		}
	}//este metodo es para poder leer la opcion que el usuario ingresa desde la consola y validar que sea un numero valido, si no lo es vuelve a pedir la opcion hasta que sea valida

	private static long leerLong(String mensaje) {
		while (true) {
			String entrada = leerTexto(mensaje);
			try {
				return Long.parseLong(entrada);
			} catch (NumberFormatException e) {
				System.out.println("Debe ingresar un numero valido.");
			}
		}
	}//	este metodo es para poder leer un numero largo que el usuario ingresa desde la consola y validar que sea un numero valido, si no lo es vuelve a pedir el numero hasta que sea valido

	private static int leerEntero(String mensaje) {//este metodo es para poder leer un numero entero que el usuario ingresa desde la consola y validar que sea un numero valido, si no lo es vuelve a pedir el numero hasta que sea valido
		while (true) {
			String entrada = leerTexto(mensaje);//este metodo es para poder leer un numero entero que el usuario ingresa desde la consola y validar que sea un numero valido, si no lo es vuelve a pedir el numero hasta que sea valido
			try {
				return Integer.parseInt(entrada);
			} catch (NumberFormatException e) {
				System.out.println("Debe ingresar un numero entero valido.");
			}
		}//este metodo es para poder leer un numero entero que el usuario ingresa desde la consola y validar que sea un numero valido, si no lo es vuelve a pedir el numero hasta que sea valido
	}

	private static String leerTexto(String mensaje) {//este metodo es para poder leer un texto que el usuario ingresa desde la consola y devolverlo como un String
		System.out.print(mensaje);
		return scanner.nextLine().trim();
	}//este metodo es para poder leer un texto que el usuario ingresa desde la consola y devolverlo como un String

	private static void realizarVenta() {//este metodo es para poder realizar una venta, el usuario debe ingresar el DNI del cliente, los productos que desea comprar y la tarjeta de credito con la que desea pagar, si el cliente no tiene tarjeta de credito registrada o no tiene limite suficiente para realizar la compra se lanza una excepcion
		long dni = leerLong("Ingrese el DNI del cliente: ");
		Cliente cliente = CollectionCliente.buscarCliente(dni);
		List<TarjetaCredito> tarjetasCliente = new ArrayList<>();
		for (TarjetaCredito tarjeta : CollectionTarjetaCredito.tarjetas) {
			if (tarjeta.getCliente().getDni() == cliente.getDni()) {
				tarjetasCliente.add(tarjeta);
			}//este for es para poder recorrer la lista de tarjetas de credito y buscar las tarjetas de credito que pertenecen al cliente que se esta realizando la venta
		}
		if (tarjetasCliente.isEmpty()) {
			System.out.println("El cliente no tiene una tarjeta de credito registrada.");
			return;
		}//este if es para poder verificar si el cliente tiene una tarjeta de credito registrada, si no la tiene se muestra un mensaje y se termina la venta

		mostrarProductos();
		List<Detalle> detalles = new ArrayList<>();
		List<Stock> stocksVendidos = new ArrayList<>();
		List<Integer> cantidadesVendidas = new ArrayList<>();
		while (true) {
			long codigo = leerLong("Ingrese el codigo del producto (0 para finalizar): ");
			if (codigo == 0) {
				break;
			}
			Producto producto = CollectionProducto.buscarProducto(codigo);
			if (producto == null) {
				System.out.println("No existe un producto con ese codigo.");
				continue;
			}

			Stock stock = CollectionStock.buscarStock(producto);
			if (stock == null) {
				System.out.println("El producto no tiene stock registrado.");
				continue;
			}
			int cantidad = leerEntero("Ingrese la cantidad: ");
			if (cantidad <= 0) {
				System.out.println("La cantidad debe ser mayor que cero.");
				continue;
			}
			if (!stock.validarStockDisponible(cantidad)) {
				System.out.println("Stock insuficiente. Disponible: " + stock.getCantidad());
				continue;
			}

			detalles.add(new Detalle(cantidad, producto, true));
			stocksVendidos.add(stock);
			cantidadesVendidas.add(cantidad);
		}//este while es para poder ingresar los productos que el cliente desea comprar, se valida que el producto exista, que tenga stock disponible y que la cantidad ingresada sea mayor que cero, si alguna de estas condiciones no se cumple se muestra un mensaje y se vuelve a pedir el producto

		if (detalles.isEmpty()) {
			System.out.println("No se agregaron productos; la venta fue cancelada.");
			return;//este if es para poder verificar si se agregaron productos a la venta, si no se agregaron se muestra un mensaje y se termina la venta
		}

		System.out.println("Tarjetas disponibles para " + cliente.getNombre() + ":");
		for (TarjetaCredito tarjeta : tarjetasCliente) {
			System.out.println("Numero: " + tarjeta.getNumero() + " | Limite disponible: "
					+ tarjeta.getLimiteCompra());
		}
		long numeroTarjeta = leerLong("Ingrese el numero de la tarjeta: ");
		TarjetaCredito tarjetaSeleccionada = null;
		for (TarjetaCredito tarjeta : tarjetasCliente) {
			if (tarjeta.getNumero() == numeroTarjeta) {
				tarjetaSeleccionada = tarjeta;
				break;
			}//este for es para poder buscar la tarjeta de credito que el cliente desea utilizar para realizar la compra, se valida que la tarjeta exista y que pertenezca al cliente, si no se encuentra se muestra un mensaje y se termina la venta
		}
		if (tarjetaSeleccionada == null) {
			System.out.println("La tarjeta ingresada no pertenece al cliente. La venta fue cancelada.");
			return;
		}//este if es para poder verificar si la tarjeta de credito ingresada por el cliente pertenece al cliente, si no pertenece se muestra un mensaje y se termina la venta

		long numeroFactura = CollectionFactura.facturas.size() + 1L;
		Factura factura = new Factura(LocalDate.now(), numeroFactura, cliente, detalles);//este objeto es para poder crear una factura con la fecha actual, el numero de factura generado automaticamente, el cliente que realiza la compra y los detalles de los productos comprados
		Credito credito = new Credito(tarjetaSeleccionada, factura, new ArrayList<>());//este objeto es para poder crear un credito con la tarjeta de credito seleccionada, la factura generada y una lista vacia de cuotas, se valida que el limite de la tarjeta sea suficiente para realizar la compra, si no lo es se lanza una excepcion

		for (int i = 0; i < stocksVendidos.size(); i++) {//este for es para poder recorrer la lista de stocks vendidos y reducir el stock disponible de cada producto vendido, se valida que haya suficiente stock disponible, si no lo hay se lanza una excepcion
			CollectionStock.reducirStock(stocksVendidos.get(i), cantidadesVendidas.get(i));
		}//este for es para poder recorrer la lista de stocks vendidos y reducir el stock disponible de cada producto vendido, se valida que haya suficiente stock disponible, si no lo hay se lanza una excepcion
		CollectionFactura.agregarFactura(factura);
		CollectionCredito.agregarCredito(credito);
		tarjetaSeleccionada.setLimiteCompra(tarjetaSeleccionada.getLimiteCompra() - factura.calcularTotal());

		System.out.println("Venta realizada correctamente. Compra financiada en 20 cuotas.");
		System.out.println(factura);
		System.out.printf("Total: $%.2f%n", factura.calcularTotal());
	}//este metodo es para poder realizar una venta, el usuario debe ingresar el DNI del cliente, los productos que desea comprar y la tarjeta de credito con la que desea pagar, si el cliente no tiene tarjeta de credito registrada o no tiene limite suficiente para realizar la compra se lanza una excepcion

	private static void consultarCompras() {//este metodo es para poder consultar las compras realizadas por un cliente, el usuario debe ingresar el DNI del cliente, si el cliente no tiene compras registradas se muestra un mensaje
		long dni = leerLong("Ingrese el DNI del cliente: ");
		Cliente cliente = CollectionCliente.buscarCliente(dni);
		List<Factura> compras = cliente.consultarCompras();
		if (compras.isEmpty()) {
			System.out.println("El cliente no tiene compras registradas.");
			return;
		}//este if es para poder verificar si el cliente tiene compras registradas, si no las tiene se muestra un mensaje y se termina la consulta
		for (Factura factura : compras) {
			System.out.println(factura);
			System.out.printf("Total: $%.2f%n", factura.calcularTotal());
		}
	}//este metodo es para poder consultar las compras realizadas por un cliente, el usuario debe ingresar el DNI del cliente, si el cliente no tiene compras registradas se muestra un mensaje

	private static void mostrarProductos() {
		System.out.println("\n--- Productos disponibles ---");
		for (Producto producto : CollectionProducto.productos) {
			System.out.println(producto);
		}
	}//este metodo es para poder mostrar los productos disponibles en la lista de productos, se recorre la lista de productos y se muestra cada producto en la consola

	private static void consultarStock() {
		System.out.println("\n--- Stock disponible ---");
		for (Stock stock : CollectionStock.stocks) {
			System.out.println(stock.getProducto().getCodigo() + " - " + stock.getProducto().getDescripcion()
					+ " | Cantidad: " + stock.getCantidad());
		}
	}//	este metodo es para poder consultar el stock disponible de los productos, se recorre la lista de stocks y se muestra el codigo, descripcion y cantidad disponible de cada producto en la consola

	private static void consultarCreditos() {//este metodo es para poder consultar los creditos de un cliente, el usuario debe ingresar el DNI del cliente, si el cliente no tiene creditos registrados se muestra un mensaje
		long dni = leerLong("Ingrese el DNI del cliente: ");
		Cliente cliente = CollectionCliente.buscarCliente(dni);//este objeto es para poder buscar el cliente por su dni, si no se encuentra el cliente se lanza una excepcion
		boolean encontroCredito = false;//este booleano es para poder verificar si se encontraron creditos del cliente, si no se encuentran se muestra un mensaje
		for (Credito credito : CollectionCredito.creditos) {
			if (credito.getTarjetaCredito().getCliente().getDni() == cliente.getDni()) {
				credito.mostarCredito();
				encontroCredito = true;
			}//este for es para poder recorrer la lista de creditos y buscar los creditos del cliente, si se encuentran se muestra el credito en la consola y se cambia el booleano encontroCredito a true
		}
		if (!encontroCredito) {
			System.out.println("El cliente no tiene creditos registrados.");
		}//este if es para poder verificar si se encontraron creditos del cliente, si no se encontraron se muestra un mensaje
	}
}
