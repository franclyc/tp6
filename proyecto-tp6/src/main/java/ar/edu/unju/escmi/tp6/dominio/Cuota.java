// Indica el paquete al que pertenece la clase.
package ar.edu.unju.escmi.tp6.dominio;

// Importa LocalDate para representar fechas sin hora.
import java.time.LocalDate;

// Declara la clase pública Cuota.
public class Cuota {

    // Guarda el importe que se debe pagar por esta cuota.
    private double monto;

    // Guarda el número de la cuota, por ejemplo del 1 al 20.
    private int nroCuota;

    // Guarda la fecha en que se generó la cuota.
    private LocalDate fechaGeneracion;

    // Guarda la fecha en que vence la cuota.
    private LocalDate fechaVencimiento;

    // Constructor vacío: permite crear una cuota sin pasar datos.
    public Cuota() {

        // Los números quedan en 0 y las fechas en null.

    } // Finaliza el constructor vacío.

    // Constructor que recibe todos los datos de la cuota.
    public Cuota(double monto, int nroCuota,
                 LocalDate fechaGeneracion, LocalDate fechaVencimiento) {

        // Asigna el monto recibido al atributo de este objeto.
        this.monto = monto;

        // Asigna el número recibido al atributo de este objeto.
        this.nroCuota = nroCuota;

        // Asigna la fecha de generación recibida.
        this.fechaGeneracion = fechaGeneracion;

        // Asigna la fecha de vencimiento recibida.
        this.fechaVencimiento = fechaVencimiento;

    } // Finaliza el constructor con parámetros.

    // Permite consultar el monto de la cuota.
    public double getMonto() {

        // Devuelve el monto guardado.
        return monto;

    } // Finaliza getMonto.

    // Permite modificar el monto; void indica que no devuelve un valor.
    public void setMonto(double monto) {

        // Reemplaza el monto del objeto por el recibido.
        this.monto = monto;

    } // Finaliza setMonto.

    // Permite consultar el número de cuota.
    public int getNroCuota() {

        // Devuelve el número guardado.
        return nroCuota;

    } // Finaliza getNroCuota.

    // Permite modificar el número de cuota.
    public void setNroCuota(int nroCuota) {

        // Reemplaza el número del objeto por el recibido.
        this.nroCuota = nroCuota;

    } // Finaliza setNroCuota.

    // Permite consultar la fecha de generación.
    public LocalDate getFechaGeneracion() {

        // Devuelve la fecha de generación guardada.
        return fechaGeneracion;

    } // Finaliza getFechaGeneracion.

    // Permite modificar la fecha de generación.
    public void setFechaGeneracion(LocalDate fechaGeneracion) {

        // Reemplaza la fecha de generación por la recibida.
        this.fechaGeneracion = fechaGeneracion;

    } // Finaliza setFechaGeneracion.

    // Permite consultar la fecha de vencimiento.
    public LocalDate getFechaVencimiento() {

        // Devuelve la fecha de vencimiento guardada.
        return fechaVencimiento;

    } // Finaliza getFechaVencimiento.

    // Permite modificar la fecha de vencimiento.
    public void setFechaVencimiento(LocalDate fechaVencimiento) {

        // Reemplaza la fecha de vencimiento por la recibida.
        this.fechaVencimiento = fechaVencimiento;

    } // Finaliza setFechaVencimiento.

    // Indica que se redefine el método toString heredado de Object.
    @Override

    // Devuelve una representación de la cuota como texto.
    public String toString() {

        // Comienza el texto con el monto y el número de cuota.
        return "Monto: " + monto + ", N° De Cuota:" + nroCuota
                // Añade la fecha en que se generó.
                + ", Fecha De Generacion: " + fechaGeneracion
                // Añade el vencimiento y un salto de línea.
                + ", Fecha De Vencimiento: " + fechaVencimiento + "\n";

    } // Finaliza toString.

} // Finaliza la clase Cuota.
