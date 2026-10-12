// Indica el paquete al que pertenece la clase.
package ar.edu.unju.escmi.tp6.dominio;

// Declara la clase pública Detalle.
public class Detalle {

    // Guarda la cantidad de unidades compradas.
    private int cantidad;

    // Guarda el importe correspondiente a este detalle.
    private double importe;

    // Guarda si el detalle está marcado como parte del programa Ahora 20.
    private boolean estadoAhora20;

    // Guarda la referencia al producto comprado.
    private Producto producto;

    // Constructor vacío: permite crear un detalle sin pasar datos.
    // Los números quedan en 0, el boolean en false y producto en null.
    public Detalle() {}

    // Constructor que recibe cantidad, producto e indicador de Ahora 20.
    public Detalle(int cantidad, Producto producto, boolean estadoAhora20) {

        // Asigna la cantidad recibida al atributo de este objeto.
        this.cantidad = cantidad;

        // Asigna el producto recibido al atributo de este objeto.
        this.producto = producto;

        // Asigna el indicador recibido al atributo de este objeto.
        this.estadoAhora20 = estadoAhora20;

        // Calcula y guarda el importe del detalle.
        calcularImporte();

    } // Finaliza el constructor con parámetros.

    // Permite consultar la cantidad de unidades.
    public int getCantidad() {

        // Devuelve la cantidad guardada.
        return cantidad;

    } // Finaliza getCantidad.

    // Permite modificar la cantidad.
    public void setCantidad(int cantidad) {

        // Reemplaza la cantidad por la recibida.
        // Esta asignación no recalcula el importe.
        this.cantidad = cantidad;

    } // Finaliza setCantidad.

    // Permite consultar el importe del detalle.
    public double getImporte() {

        // Devuelve el importe guardado.
        return importe;

    } // Finaliza getImporte.

    // Permite modificar directamente el importe.
    public void setImporte(double importe) {

        // Reemplaza el importe por el recibido.
        this.importe = importe;

    } // Finaliza setImporte.

    // Permite consultar el indicador de Ahora 20.
    // Se usa el prefijo is porque devuelve un boolean.
    public boolean isEstadoAhora20() {

        // Devuelve true o false según el valor guardado.
        return estadoAhora20;

    } // Finaliza isEstadoAhora20.

    // Permite modificar el indicador de Ahora 20.
    public void setEstadoAhora20(boolean estadoAhora20) {

        // Reemplaza el indicador por el recibido.
        this.estadoAhora20 = estadoAhora20;

    } // Finaliza setEstadoAhora20.

    // Permite consultar el producto asociado al detalle.
    public Producto getProducto() {

        // Devuelve la referencia al producto.
        return producto;

    } // Finaliza getProducto.

    // Permite modificar el producto asociado.
    public void setProducto(Producto producto) {

        // Reemplaza el producto por el recibido.
        // Esta asignación no recalcula el importe.
        this.producto = producto;

    } // Finaliza setProducto.

    // Declara un método que solo puede llamarse desde esta clase.
    // void indica que no devuelve un valor.
    private void calcularImporte() {

        // Multiplica cantidad por precio unitario.
        // Llama a setImporte para guardar el resultado.
        this.setImporte(this.cantidad * this.producto.getPrecioUnitario());

    } // Finaliza calcularImporte.

    // Indica que se redefine el método toString heredado de Object.
    @Override

    // Devuelve los datos del detalle como texto.
    public String toString() {

        // Incluye el producto, la cantidad y el importe.
        // Al concatenar producto, se utiliza su método toString().
        // \n agrega un salto de línea.
        return "PRODUCTO: " + producto
                + "\nCANTIDAD: " + cantidad
                + " | IMPORTE: " + importe + "\n";

    } // Finaliza toString.

} // Finaliza la clase Detalle.
