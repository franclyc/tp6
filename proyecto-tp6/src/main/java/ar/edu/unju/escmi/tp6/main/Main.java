// Indica el paquete al que pertenece la clase.
package ar.edu.unju.escmi.tp6.main;

// Importa LocalDate para trabajar con fechas.
import java.time.LocalDate;

// Importa ArrayList para crear listas.
import java.util.ArrayList;

// Importa la interfaz List para declarar listas.
import java.util.List;

// Importa Scanner para leer datos ingresados por teclado.
import java.util.Scanner;

// Importa la colección que administra clientes.
import ar.edu.unju.escmi.tp6.collections.CollectionCliente;

// Importa la colección que administra créditos.
import ar.edu.unju.escmi.tp6.collections.CollectionCredito;

// Importa la colección que administra facturas.
import ar.edu.unju.escmi.tp6.collections.CollectionFactura;

// Importa la colección que administra productos.
import ar.edu.unju.escmi.tp6.collections.CollectionProducto;

// Importa la colección que administra el stock.
import ar.edu.unju.escmi.tp6.collections.CollectionStock;

// Importa la colección que administra tarjetas de crédito.
import ar.edu.unju.escmi.tp6.collections.CollectionTarjetaCredito;

// Importa la clase Cliente.
import ar.edu.unju.escmi.tp6.dominio.Cliente;

// Importa la clase Credito.
import ar.edu.unju.escmi.tp6.dominio.Credito;

// Importa la clase Detalle.
import ar.edu.unju.escmi.tp6.dominio.Detalle;

// Importa la clase Factura.
import ar.edu.unju.escmi.tp6.dominio.Factura;

// Importa la clase Producto.
import ar.edu.unju.escmi.tp6.dominio.Producto;

// Importa la clase Stock.
import ar.edu.unju.escmi.tp6.dominio.Stock;

// Importa la clase TarjetaCredito.
import ar.edu.unju.escmi.tp6.dominio.TarjetaCredito;

// Importa la excepción para un cliente no encontrado.
import ar.edu.unju.escmi.tp6.exceptions.ClienteNoEncontradoException;

// Importa la excepción para un límite de tarjeta insuficiente.
import ar.edu.unju.escmi.tp6.exceptions.LimiteTarjetaInsuficienteException;

// Importa la excepción para un monto que supera el permitido.
import ar.edu.unju.escmi.tp6.exceptions.MontoExcedidoException;

// Importa la excepción para stock insuficiente.
import ar.edu.unju.escmi.tp6.exceptions.StockInsuficienteException;

// Declara la clase pública Main.
public class Main {

    // Crea un Scanner compartido por los métodos de la clase.
    // private: solo se accede desde Main.
    // static: pertenece a la clase.
    // final: la variable no puede recibir otro Scanner.
    private static final Scanner scanner = new Scanner(System.in);

    // Es el método desde el que comienza la ejecución del programa.
    public static void main(String[] args) {

        // Carga los clientes iniciales.
        CollectionCliente.precargarClientes();

        // Carga las tarjetas iniciales.
        CollectionTarjetaCredito.precargarTarjetas();

        // Carga los productos iniciales.
        CollectionProducto.precargarProductos();

        // Carga el stock inicial.
        CollectionStock.precargarStocks();

        // Declara la variable que guarda la opción elegida.
        int opcion;

        // Inicia un ciclo que ejecuta el menú al menos una vez.
        do {

            // Muestra las opciones disponibles.
            mostrarMenu();

            // Lee y guarda la opción ingresada.
            opcion = leerOpcion();

            // Inicia el bloque cuyas excepciones se controlan con catch.
            try {

                // Selecciona qué acción ejecutar según la opción.
                switch (opcion) {

                    // Si la opción es 1, realiza una venta.
                    case 1:

                        // Llama al método que gestiona la venta.
                        realizarVenta();

                        // Sale del switch.
                        break;

                    // Si la opción es 2, consulta las compras.
                    case 2:

                        // Llama al método que muestra las compras de un cliente.
                        consultarCompras();

                        // Sale del switch.
                        break;

                    // Si la opción es 3, muestra los productos.
                    case 3:

                        // Llama al método que imprime los productos.
                        mostrarProductos();

                        // Sale del switch.
                        break;

                    // Si la opción es 4, consulta el stock.
                    case 4:

                        // Llama al método que imprime el stock.
                        consultarStock();

                        // Sale del switch.
                        break;

                    // Si la opción es 5, consulta los créditos.
                    case 5:

                        // Llama al método que muestra los créditos de un cliente.
                        consultarCreditos();

                        // Sale del switch.
                        break;

                    // Si la opción es 6, informa que se sale del programa.
                    case 6:

                        // Imprime el mensaje de despedida.
                        System.out.println("Hasta luego.");

                        // Sale del switch.
                        break;

                    // Se ejecuta si no coincide ninguna opción anterior.
                    default:

                        // Informa que la opción está fuera del rango permitido.
                        System.out.println(
                            "Opcion invalida. Ingrese un numero del 1 al 6."
                        );

                } // Finaliza el switch.

            // Captura cualquiera de estas cuatro excepciones.
            // La variable e guarda la excepción que ocurrió.
            } catch (ClienteNoEncontradoException
                    | StockInsuficienteException
                    | MontoExcedidoException
                    | LimiteTarjetaInsuficienteException e) {

                // Imprime una línea en blanco y el mensaje de la excepción.
                System.out.println("\n" + e.getMessage());

            } // Finaliza el catch.

        // Repite el menú mientras la opción sea distinta de 6.
        } while (opcion != 6);

        // Cierra el Scanner cuando termina el menú.
        scanner.close();

    } // Finaliza main.

    // Declara un método privado y estático que muestra el menú.
    // void indica que no devuelve ningún valor.
    private static void mostrarMenu() {

        // Imprime el título del menú precedido por un salto de línea.
        System.out.println("\n====== Menu Principal =====");

        // Muestra la opción para realizar una venta.
        System.out.println("1- Realizar una venta");

        // Muestra la opción para consultar las compras por DNI.
        System.out.println(
            "2- Revisar compras realizadas por el cliente (debe ingresar el DNI del cliente)"
        );

        // Muestra la opción para listar los electrodomésticos.
        System.out.println("3- Mostrar lista de los electrodomesticos");

        // Muestra la opción para consultar el stock.
        System.out.println("4- Consultar stock");

        // Muestra la opción para consultar los créditos por DNI.
        System.out.println(
            "5- Revisar creditos de un cliente (debe ingresar el DNI del cliente)"
        );

        // Muestra la opción para salir.
        System.out.println("6- Salir");

    } // Finaliza mostrarMenu.

    // Declara un método que lee una opción y devuelve un int.
    private static int leerOpcion() {

        // Repite la lectura hasta que se pueda devolver un número entero.
        while (true) {

            // Muestra el mensaje y guarda el texto ingresado.
            String entrada = leerTexto("Ingrese su opcion: ");

            // Intenta convertir el texto a un entero.
            try {

                // Convierte el texto a int y termina el método devolviéndolo.
                return Integer.parseInt(entrada);

            // Captura el error si el texto no representa un int válido.
            } catch (NumberFormatException e) {

                // Informa el error; el ciclo vuelve a pedir el dato.
                System.out.println("Debe ingresar un numero valido.");

            } // Finaliza el catch.

        } // Finaliza el while.

    } // Finaliza leerOpcion.

    // Recibe un mensaje y devuelve un número entero de tipo long.
    private static long leerLong(String mensaje) {

        // Repite la lectura hasta obtener un long válido.
        while (true) {

            // Muestra el mensaje recibido y lee la entrada.
            String entrada = leerTexto(mensaje);

            // Intenta convertir la entrada a long.
            try {

                // Convierte el texto a long y lo devuelve.
                return Long.parseLong(entrada);

            // Captura el error de conversión.
            } catch (NumberFormatException e) {

                // Informa que debe ingresarse un número válido.
                System.out.println("Debe ingresar un numero valido.");

            } // Finaliza el catch.

        } // Finaliza el while.

    } // Finaliza leerLong.

    // Recibe un mensaje y devuelve un número entero de tipo int.
    private static int leerEntero(String mensaje) {

        // Repite la lectura hasta obtener un int válido.
        while (true) {

            // Muestra el mensaje recibido y guarda el texto ingresado.
            String entrada = leerTexto(mensaje);

            // Intenta convertir el texto a int.
            try {

                // Convierte la entrada a int y la devuelve.
                return Integer.parseInt(entrada);

            // Captura el error si la conversión no es posible.
            } catch (NumberFormatException e) {

                // Informa que la entrada debe ser un entero válido.
                System.out.println("Debe ingresar un numero entero valido.");

            } // Finaliza el catch.

        } // Finaliza el while.

    } // Finaliza leerEntero.

    // Recibe un mensaje y devuelve el texto ingresado por teclado.
    private static String leerTexto(String mensaje) {

        // Muestra el mensaje sin agregar un salto de línea.
        System.out.print(mensaje);

        // Lee una línea y elimina los espacios de sus extremos.
        return scanner.nextLine().trim();

    } // Finaliza leerTexto.

    // Declara el método que gestiona una venta.
    private static void realizarVenta() {

        // Pide y guarda el DNI del cliente.
        long dni = leerLong("Ingrese el DNI del cliente: ");

        // Busca al cliente con ese DNI.
        Cliente cliente = CollectionCliente.buscarCliente(dni);

        // Crea una lista para guardar las tarjetas del cliente.
        List<TarjetaCredito> tarjetasCliente = new ArrayList<>();

        // Recorre todas las tarjetas registradas.
        for (TarjetaCredito tarjeta : CollectionTarjetaCredito.tarjetas) {

            // Compara el DNI del titular de la tarjeta con el del cliente.
            if (tarjeta.getCliente().getDni() == cliente.getDni()) {

                // Agrega la tarjeta a la lista si pertenece al cliente.
                tarjetasCliente.add(tarjeta);

            } // Finaliza el if.

        } // Finaliza el for.

        // Comprueba si el cliente no tiene tarjetas registradas.
        if (tarjetasCliente.isEmpty()) {

            // Informa que no se puede continuar sin una tarjeta.
            System.out.println(
                "El cliente no tiene una tarjeta de credito registrada."
            );

            // Termina realizarVenta y vuelve al menú.
            return;

        } // Finaliza el if.

        // Muestra los productos registrados.
        mostrarProductos();

        // Crea la lista de detalles de esta compra.
        List<Detalle> detalles = new ArrayList<>();

        // Crea una lista para guardar los stocks que se reducirán.
        List<Stock> stocksVendidos = new ArrayList<>();

        // Crea una lista para guardar las cantidades que se descontarán.
        List<Integer> cantidadesVendidas = new ArrayList<>();

        // Permite cargar productos hasta que se ingrese 0.
        while (true) {

            // Pide el código del producto; 0 indica terminar la carga.
            long codigo = leerLong(
                "Ingrese el codigo del producto (0 para finalizar): "
            );

            // Comprueba si se ingresó el valor de finalización.
            if (codigo == 0) {

                // Sale del ciclo de carga de productos.
                break;

            } // Finaliza el if.

            // Busca el producto con el código ingresado.
            Producto producto = CollectionProducto.buscarProducto(codigo);

            // Comprueba si el producto no fue encontrado.
            if (producto == null) {

                // Informa que el código no corresponde a un producto.
                System.out.println("No existe un producto con ese codigo.");

                // Vuelve al inicio del while para pedir otro código.
                continue;

            } // Finaliza el if.

            // Busca el stock correspondiente al producto.
            Stock stock = CollectionStock.buscarStock(producto);

            // Comprueba si no existe un registro de stock.
            if (stock == null) {

                // Informa que el producto no tiene stock registrado.
                System.out.println("El producto no tiene stock registrado.");

                // Vuelve al inicio del while.
                continue;

            } // Finaliza el if.

            // Pide y guarda la cantidad de unidades que se comprarán.
            int cantidad = leerEntero("Ingrese la cantidad: ");

            // Comprueba si la cantidad es cero o negativa.
            if (cantidad <= 0) {

                // Informa que la cantidad debe ser positiva.
                System.out.println("La cantidad debe ser mayor que cero.");

                // Vuelve al inicio del while.
                continue;

            } // Finaliza el if.

            // Comprueba si el stock no alcanza para esta cantidad.
            // ! invierte el resultado boolean del método.
            if (!stock.validarStockDisponible(cantidad)) {

                // Muestra el mensaje y la cantidad disponible.
                System.out.println(
                    "Stock insuficiente. Disponible: " + stock.getCantidad()
                );

                // Vuelve al inicio del while.
                continue;

            } // Finaliza el if.

            // Crea y agrega el detalle de compra.
            // true se pasa como valor del indicador estadoAhora20.
            detalles.add(new Detalle(cantidad, producto, true));

            // Guarda la referencia al stock de ese producto.
            stocksVendidos.add(stock);

            // Guarda la cantidad que luego se descontará de ese stock.
            cantidadesVendidas.add(cantidad);

        } // Finaliza el ciclo de carga.

        // Comprueba si no se cargó ningún detalle.
        if (detalles.isEmpty()) {

            // Informa que la venta fue cancelada.
            System.out.println(
                "No se agregaron productos; la venta fue cancelada."
            );

            // Termina el método y vuelve al menú.
            return;

        } // Finaliza el if.

        // Muestra el nombre del cliente antes de listar sus tarjetas.
        System.out.println(
            "Tarjetas disponibles para " + cliente.getNombre() + ":"
        );

        // Recorre las tarjetas que pertenecen al cliente.
        for (TarjetaCredito tarjeta : tarjetasCliente) {

            // Imprime el número de la tarjeta y su límite de compra.
            System.out.println(
                "Numero: " + tarjeta.getNumero() + " | Limite disponible: "
                + tarjeta.getLimiteCompra()
            );

        } // Finaliza el for.

        // Pide y guarda el número de tarjeta elegido.
        long numeroTarjeta = leerLong("Ingrese el numero de la tarjeta: ");

        // Inicializa la tarjeta seleccionada sin una referencia asignada.
        TarjetaCredito tarjetaSeleccionada = null;

        // Recorre las tarjetas del cliente para encontrar la elegida.
        for (TarjetaCredito tarjeta : tarjetasCliente) {

            // Compara el número de la tarjeta con el ingresado.
            if (tarjeta.getNumero() == numeroTarjeta) {

                // Guarda la referencia a la tarjeta encontrada.
                tarjetaSeleccionada = tarjeta;

                // Sale del for porque ya encontró la tarjeta.
                break;

            } // Finaliza el if.

        } // Finaliza el for.

        // Comprueba si ninguna tarjeta del cliente coincide con el número.
        if (tarjetaSeleccionada == null) {

            // Informa que la tarjeta no pertenece al cliente.
            System.out.println(
                "La tarjeta ingresada no pertenece al cliente. La venta fue cancelada."
            );

            // Termina el método sin registrar la venta.
            return;

        } // Finaliza el if.

        // Calcula el número de factura como cantidad de facturas más uno.
        // 1L es el número 1 de tipo long.
        long numeroFactura = CollectionFactura.facturas.size() + 1L;

        // Crea la factura con fecha actual, número, cliente y detalles.
        Factura factura = new Factura(
            LocalDate.now(), numeroFactura, cliente, detalles
        );

        // Crea el crédito con la tarjeta, la factura y una lista vacía de cuotas.
        // Lo que haga después depende del constructor de Credito.
        Credito credito = new Credito(
            tarjetaSeleccionada, factura, new ArrayList<>()
        );

        // Recorre los índices de los stocks guardados para la venta.
        // i++ incrementa el índice en uno después de cada vuelta.
        for (int i = 0; i < stocksVendidos.size(); i++) {

            // Solicita reducir cada stock en la cantidad del mismo índice.
            CollectionStock.reducirStock(
                stocksVendidos.get(i), cantidadesVendidas.get(i)
            );

        } // Finaliza el for.

        // Agrega la factura a la colección de facturas.
        CollectionFactura.agregarFactura(factura);

        // Agrega el crédito a la colección de créditos.
        CollectionCredito.agregarCredito(credito);

        // Modifica el límite de compra de la tarjeta.
        // Le asigna el límite actual menos el total de la factura.
        tarjetaSeleccionada.setLimiteCompra(
            tarjetaSeleccionada.getLimiteCompra() - factura.calcularTotal()
        );

        // Informa que se realizó la venta financiada en 20 cuotas.
        System.out.println(
            "Venta realizada correctamente. Compra financiada en 20 cuotas."
        );

        // Imprime la factura utilizando su método toString().
        System.out.println(factura);

        // Imprime el total con dos decimales.
        // %.2f muestra un decimal con dos cifras; %n agrega un salto de línea.
        System.out.printf("Total: $%.2f%n", factura.calcularTotal());

    } // Finaliza realizarVenta.

    // Declara el método que consulta las compras de un cliente.
    private static void consultarCompras() {

        // Pide y guarda el DNI del cliente.
        long dni = leerLong("Ingrese el DNI del cliente: ");

        // Busca al cliente por su DNI.
        Cliente cliente = CollectionCliente.buscarCliente(dni);

        // Obtiene las facturas correspondientes a las compras del cliente.
        List<Factura> compras = cliente.consultarCompras();

        // Comprueba si el cliente no tiene compras.
        if (compras.isEmpty()) {

            // Informa que no hay compras registradas.
            System.out.println("El cliente no tiene compras registradas.");

            // Termina el método y vuelve al menú.
            return;

        } // Finaliza el if.

        // Recorre las facturas del cliente.
        for (Factura factura : compras) {

            // Imprime los datos de la factura.
            System.out.println(factura);

            // Calcula e imprime el total con dos decimales.
            System.out.printf("Total: $%.2f%n", factura.calcularTotal());

        } // Finaliza el for.

    } // Finaliza consultarCompras.

    // Declara el método que muestra los productos.
    private static void mostrarProductos() {

        // Imprime el título de la lista.
        System.out.println("\n--- Productos disponibles ---");

        // Recorre todos los productos de la colección.
        for (Producto producto : CollectionProducto.productos) {

            // Imprime el producto utilizando su método toString().
            System.out.println(producto);

        } // Finaliza el for.

    } // Finaliza mostrarProductos.

    // Declara el método que muestra el stock registrado.
    private static void consultarStock() {

        // Imprime el título de la consulta.
        System.out.println("\n--- Stock disponible ---");

        // Recorre todos los registros de stock.
        for (Stock stock : CollectionStock.stocks) {

            // Imprime código, descripción y cantidad del producto.
            System.out.println(
                stock.getProducto().getCodigo() + " - "
                + stock.getProducto().getDescripcion()
                + " | Cantidad: " + stock.getCantidad()
            );

        } // Finaliza el for.

    } // Finaliza consultarStock.

    // Declara el método que consulta los créditos de un cliente.
    private static void consultarCreditos() {

        // Pide y guarda el DNI del cliente.
        long dni = leerLong("Ingrese el DNI del cliente: ");

        // Busca al cliente por su DNI.
        Cliente cliente = CollectionCliente.buscarCliente(dni);

        // Indica inicialmente que no se encontró ningún crédito.
        boolean encontroCredito = false;

        // Recorre todos los créditos registrados.
        for (Credito credito : CollectionCredito.creditos) {

            // Compara el DNI del titular de la tarjeta con el del cliente.
            if (credito.getTarjetaCredito().getCliente().getDni()
                    == cliente.getDni()) {

                // Llama al método que muestra los datos del crédito.
                // Se conserva mostarCredito tal como está en tu código.
                credito.mostarCredito();

                // Registra que se encontró al menos un crédito.
                encontroCredito = true;

            } // Finaliza el if.

        } // Finaliza el for.

        // Comprueba si no se encontró ningún crédito del cliente.
        if (!encontroCredito) {

            // Informa que el cliente no tiene créditos registrados.
            System.out.println("El cliente no tiene creditos registrados.");

        } // Finaliza el if.

    } // Finaliza consultarCreditos.

} // Finaliza la clase Main.
