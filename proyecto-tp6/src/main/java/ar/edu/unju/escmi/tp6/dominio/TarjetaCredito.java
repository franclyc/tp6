// Indica el paquete al que pertenece la clase.
package ar.edu.unju.escmi.tp6.dominio;

// Importa LocalDate para representar la fecha de caducación.
import java.time.LocalDate;

// Declara la clase pública TarjetaCredito.
public class TarjetaCredito {

    // Guarda el número de la tarjeta.
    private long numero;

    // Guarda la fecha de caducación de la tarjeta.
    private LocalDate fechaCaducacion;

    // Guarda la referencia al cliente titular de la tarjeta.
    private Cliente cliente;

    // Guarda el límite de compra de la tarjeta.
    private double limiteCompra;

    // Constructor vacío: permite crear una tarjeta sin pasar datos.
    public TarjetaCredito() {

    } // Finaliza el constructor vacío.

    // Constructor que recibe todos los datos de la tarjeta.
    public TarjetaCredito(long numero, LocalDate fechaCaducacion,
                          Cliente cliente, double limiteCompra) {

        // Llama al constructor de Object, la clase padre implícita.
        super();

        // Asigna el número recibido al atributo de este objeto.
        this.numero = numero;

        // Asigna la fecha de caducación recibida.
        this.fechaCaducacion = fechaCaducacion;

        // Asigna el cliente titular recibido.
        this.cliente = cliente;

        // Asigna el límite de compra recibido.
        this.limiteCompra = limiteCompra;

    } // Finaliza el constructor con parámetros.

    // Permite consultar el número de la tarjeta.
    public long getNumero() {

        // Devuelve el número guardado.
        return numero;

    } // Finaliza getNumero.

    // Permite modificar el número de la tarjeta.
    public void setNumero(long numero) {

        // Reemplaza el número por el recibido.
        this.numero = numero;

    } // Finaliza setNumero.

    // Permite consultar la fecha de caducación.
    public LocalDate getFechaCaducacion() {

        // Devuelve la fecha guardada.
        return fechaCaducacion;

    } // Finaliza getFechaCaducacion.

    // Permite modificar la fecha de caducación.
    public void setFechaCaducacion(LocalDate fechaCaducacion) {

        // Reemplaza la fecha por la recibida.
        this.fechaCaducacion = fechaCaducacion;

    } // Finaliza setFechaCaducacion.

    // Permite consultar el cliente titular.
    public Cliente getCliente() {

        // Devuelve la referencia al cliente.
        return cliente;

    } // Finaliza getCliente.

    // Permite modificar el cliente titular.
    public void setCliente(Cliente cliente) {

        // Reemplaza el cliente por el recibido.
        this.cliente = cliente;

    } // Finaliza setCliente.

    // Permite consultar el límite de compra.
    public double getLimiteCompra() {

        // Devuelve el límite guardado.
        return limiteCompra;

    } // Finaliza getLimiteCompra.

    // Permite modificar el límite de compra.
    public void setLimiteCompra(double limiteCompra) {

        // Reemplaza el límite por el recibido, sin validarlo.
        this.limiteCompra = limiteCompra;

    } // Finaliza setLimiteCompra.

    // Indica que se redefine el método toString heredado de Object.
    @Override

    // Devuelve una representación de la tarjeta como texto.
    public String toString() {

        // Comienza con un salto de línea y añade número y caducación.
        return "\nNumero: " + numero
                + " Fecha De Caducacion: " + fechaCaducacion

                // Añade otro salto de línea y el nombre del titular.
                + "\nNombre Titular: " + cliente.getNombre()

                // Añade el límite de compra actual.
                + ", Limite De Compra Actual:" + limiteCompra;

    } // Finaliza toString.

} // Finaliza la clase TarjetaCredito.
