// Indica el paquete al que pertenece la clase.
package ar.edu.unju.escmi.tp6.dominio;

// Importa LocalDate para guardar la fecha de la factura.
import java.time.LocalDate;

// Importa ArrayList para crear la lista de detalles.
import java.util.ArrayList;

// Importa List para declarar una lista de objetos Detalle.
import java.util.List;

// Declara la clase pública Factura.
public class Factura {

    // Guarda la fecha de la factura.
    private LocalDate fecha;

    // Guarda el número de la factura.
    private long nroFactura;

    // Guarda la referencia al cliente que realizó la compra.
    private Cliente cliente;

    // Inicializa una lista vacía para guardar los detalles de la compra.
    private List<Detalle> detalles = new ArrayList<Detalle>();

    // Constructor vacío: permite crear una factura sin pasar datos.
    public Factura() {}

    // Constructor que recibe fecha, número, cliente y detalles.
    public Factura(LocalDate fecha, long nroFactura,
                   Cliente cliente, List<Detalle> detalles) {

        // Asigna la fecha recibida al atributo de este objeto.
        this.fecha = fecha;

        // Asigna el número de factura recibido.
        this.nroFactura = nroFactura;

        // Asigna el cliente recibido.
        this.cliente = cliente;

        // Asigna la referencia a la lista recibida, sin copiarla.
        this.detalles = detalles;

    } // Finaliza el constructor con parámetros.

    // Permite consultar la fecha.
    public LocalDate getFecha() {

        // Devuelve la fecha guardada.
        return fecha;

    } // Finaliza getFecha.

    // Permite modificar la fecha.
    public void setFecha(LocalDate fecha) {

        // Reemplaza la fecha por la recibida.
        this.fecha = fecha;

    } // Finaliza setFecha.

    // Permite consultar el número de factura.
    public long getNroFactura() {

        // Devuelve el número guardado.
        return nroFactura;

    } // Finaliza getNroFactura.

    // Permite modificar el número de factura.
    public void setNroFactura(long nroFactura) {

        // Reemplaza el número por el recibido.
        this.nroFactura = nroFactura;

    } // Finaliza setNroFactura.

    // Permite consultar el cliente asociado.
    public Cliente getCliente() {

        // Devuelve la referencia al cliente.
        return cliente;

    } // Finaliza getCliente.

    // Permite modificar el cliente asociado.
    public void setCliente(Cliente cliente) {

        // Reemplaza el cliente por el recibido.
        this.cliente = cliente;

    } // Finaliza setCliente.

    // Permite consultar la lista de detalles.
    public List<Detalle> getDetalles() {

        // Devuelve la lista original; no crea una copia.
        return detalles;

    } // Finaliza getDetalles.

    // Permite reemplazar la lista de detalles.
    public void setDetalles(List<Detalle> detalles) {

        // Asigna la referencia a la lista recibida.
        this.detalles = detalles;

    } // Finaliza setDetalles.

    // Calcula y devuelve el importe total de todos los detalles.
    public double calcularTotal() {

        // Inicializa en cero la suma de los importes.
        double total = 0;

        // Recorre la lista; detalle representa el elemento actual.
        for (Detalle detalle : detalles) {

            // Suma el importe del detalle al total acumulado.
            total += detalle.getImporte();

        } // Finaliza el for.

        // Devuelve la suma de todos los importes.
        return total;

    } // Finaliza calcularTotal.

    // Calcula el total de los detalles marcados como Ahora 20.
    public double calcularTotalAhora20() {

        // Inicializa en cero la suma.
        double total = 0;

        // Recorre todos los detalles de la factura.
        for (Detalle detalle : detalles) {

            // Comprueba si el detalle está marcado como Ahora 20.
            if (detalle.isEstadoAhora20()) {

                // Suma su importe únicamente si el indicador es true.
                total += detalle.getImporte();

            } // Finaliza el if.

        } // Finaliza el for.

        // Devuelve el total correspondiente a Ahora 20.
        return total;

    } // Finaliza calcularTotalAhora20.

    // Comprueba si existe al menos un detalle marcado como Ahora 20.
    public boolean esFacturaAhora20() {

        // Recorre todos los detalles de la factura.
        for (Detalle detalle : detalles) {

            // Consulta el indicador del detalle actual.
            if (detalle.isEstadoAhora20()) {

                // Devuelve true y termina el método al encontrar uno.
                return true;

            } // Finaliza el if.

        } // Finaliza el for.

        // Devuelve false si ningún detalle estaba marcado como Ahora 20.
        return false;

    } // Finaliza esFacturaAhora20.

    // Indica que se redefine el método toString heredado de Object.
    @Override

    // Devuelve una representación de la factura como texto.
    public String toString() {

        // Comienza con dos saltos de línea y el título.
        return "\n\n******************** Factura ********************"

                // Añade la fecha y el número de factura.
                + "\nFecha: " + fecha + " N° de Factura: " + nroFactura

                // Añade el nombre del cliente asociado.
                + "\nCliente: " + cliente.getNombre()

                // Añade el título de la sección de detalles.
                + "\n************ Detalles de la Factura *************"

                // Convierte la lista a texto y elimina sus corchetes.
                // Luego elimina todas las apariciones de coma seguida de espacio.
                // Finalmente agrega un salto de línea.
                + "\n" + detalles.toString()
                    .replaceAll("\\[|\\]", "")
                    .replaceAll(", ", "") + "\n";

    } // Finaliza toString.

} // Finaliza la clase Factura.
