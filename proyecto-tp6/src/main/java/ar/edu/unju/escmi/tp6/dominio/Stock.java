// Indica el paquete al que pertenece la clase.
package ar.edu.unju.escmi.tp6.dominio;

// Importa la excepción utilizada cuando no hay suficiente stock.
import ar.edu.unju.escmi.tp6.exceptions.StockInsuficienteException;

// Declara la clase pública Stock.
public class Stock {

    // Guarda la cantidad de unidades disponibles.
    private int cantidad;

    // Guarda la referencia al producto al que corresponde este stock.
    private Producto producto;

    // Constructor vacío: cantidad queda en 0 y producto en null.
    public Stock() {}

    // Constructor que recibe la cantidad inicial y el producto.
    public Stock(int cantidad, Producto producto) {

        // Asigna la cantidad recibida al atributo de este objeto.
        this.cantidad = cantidad;

        // Asigna el producto recibido al atributo de este objeto.
        this.producto = producto;

    } // Finaliza el constructor con parámetros.

    // Permite consultar la cantidad disponible.
    public int getCantidad() {

        // Devuelve la cantidad guardada.
        return cantidad;

    } // Finaliza getCantidad.

    // Permite modificar directamente la cantidad.
    public void setCantidad(int cantidad) {

        // Reemplaza la cantidad por la recibida, sin validarla.
        this.cantidad = cantidad;

    } // Finaliza setCantidad.

    // Permite consultar el producto asociado al stock.
    public Producto getProducto() {

        // Devuelve la referencia al producto.
        return producto;

    } // Finaliza getProducto.

    // Permite modificar el producto asociado.
    public void setProducto(Producto producto) {

        // Reemplaza el producto por el recibido.
        this.producto = producto;

    } // Finaliza setProducto.

    // Comprueba si la cantidad disponible alcanza para la solicitada.
    public boolean validarStockDisponible(int cantidadRequerida) {

        // Devuelve true si hay suficientes unidades y false si no alcanza.
        // No modifica el stock ni comprueba que lo solicitado sea positivo.
        return this.cantidad >= cantidadRequerida;

    } // Finaliza validarStockDisponible.

    // Permite reemplazar la cantidad disponible por una nueva cantidad.
    public void actualizarStock(int nuevaCantidad) {

        // Asigna la nueva cantidad; no la suma a la anterior ni la valida.
        this.cantidad = nuevaCantidad;

    } // Finaliza actualizarStock.

    // Descuenta del stock las unidades vendidas.
    public void decrementarStock(int cantidadVendida) {

        // Comprueba si la cantidad a descontar es cero o negativa.
        if (cantidadVendida <= 0) {

            // Lanza una excepción por recibir un argumento inválido.
            // La ejecución del método se interrumpe sin descontar stock.
            throw new IllegalArgumentException(
                "La cantidad a descontar debe ser mayor a 0"
            );

        } // Finaliza el if.

        // Comprueba si no hay suficientes unidades.
        // ! invierte el resultado de validarStockDisponible.
        if (!validarStockDisponible(cantidadVendida)) {

            // Lanza una excepción e informa cuántas unidades quedan.
            // El stock todavía no se modificó.
            throw new StockInsuficienteException(
                "Stock insuficiente. Disponible: " + this.cantidad
            );

        } // Finaliza el if.

        // Resta las unidades vendidas a la cantidad disponible.
        // Equivale a: this.cantidad = this.cantidad - cantidadVendida.
        this.cantidad -= cantidadVendida;

    } // Finaliza decrementarStock.

} // Finaliza la clase Stock.
