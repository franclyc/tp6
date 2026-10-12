// Indica el paquete al que pertenece la clase.
package ar.edu.unju.escmi.tp6.dominio;

// Importa LocalDate para trabajar con las fechas de las cuotas.
import java.time.LocalDate;

// Importa ArrayList para crear la lista de cuotas.
import java.util.ArrayList;

// Importa List para declarar una lista de objetos Cuota.
import java.util.List;

// Importa la excepción para una tarjeta con límite insuficiente.
import ar.edu.unju.escmi.tp6.exceptions.LimiteTarjetaInsuficienteException;

// Importa la excepción para una compra que supera el monto permitido.
import ar.edu.unju.escmi.tp6.exceptions.MontoExcedidoException;

// Declara la clase pública Credito.
public class Credito {

    // Guarda el importe total financiado.
    private double montoCredito;

    // Guarda la referencia a la tarjeta utilizada para pagar.
    private TarjetaCredito tarjetaCredito;

    // Guarda la referencia a la factura financiada.
    private Factura factura;

    // Crea inicialmente una lista vacía de cuotas.
    private List<Cuota> cuotas = new ArrayList<Cuota>();

    // Constructor vacío: permite crear un crédito sin pasar datos.
    public Credito() {}

    // Constructor que recibe la tarjeta, la factura y una lista de cuotas.
    public Credito(TarjetaCredito tarjetaCredito, Factura factura, List<Cuota> cuotas) {

        // Calcula y guarda el total de la factura en una variable local.
        double total = factura.calcularTotal();

        // Inicializa en cero el importe acumulado de teléfonos.
        double totalTelefonos = 0;

        // Recorre todos los detalles de la factura.
        for (Detalle detalle : factura.getDetalles()) {

            // Comprueba si el producto del detalle es un teléfono.
            if (detalle.getProducto().isEsTelefono()) {

                // Suma su importe al total de teléfonos.
                totalTelefonos += detalle.getImporte();

            } // Finaliza el if.

        } // Finaliza el for.

        // Comprueba si la compra supera $2.500.000 o los teléfonos $1.000.000.
        // || significa que alcanza con que una de las condiciones sea verdadera.
        if (total > 2500000 || totalTelefonos > 1000000) {

            // Lanza la excepción y detiene la construcción del crédito.
            throw new MontoExcedidoException(
                "El monto de la compra supera el limite permitido por Ahora 20"
            );

        } // Finaliza el if.

        // Comprueba si el total supera el límite de compra de la tarjeta.
        if (total > tarjetaCredito.getLimiteCompra()) {

            // Lanza la excepción por límite insuficiente.
            throw new LimiteTarjetaInsuficienteException(
                "La tarjeta no tiene limite suficiente para la compra"
            );

        } // Finaliza el if.

        // Guarda la tarjeta recibida en el atributo de este crédito.
        this.tarjetaCredito = tarjetaCredito;

        // Guarda la factura recibida.
        this.factura = factura;

        // Guarda la referencia a la lista recibida.
        // No crea una copia: ambas referencias apuntan a la misma lista.
        this.cuotas = cuotas;

        // Calcula nuevamente el total y lo guarda como monto del crédito.
        this.montoCredito = factura.calcularTotal();

        // Genera las cuotas y las agrega a la lista.
        generarCuotas();

    } // Finaliza el constructor con tarjeta y factura.

    // Constructor que recibe únicamente una lista de cuotas.
    public Credito(List<Cuota> cuotas) {

        // Asigna la lista recibida al atributo.
        this.cuotas = cuotas;

    } // Finaliza el constructor.

    // Permite consultar el monto del crédito.
    public double getMontoCredito() {

        // Devuelve el importe guardado.
        return montoCredito;

    } // Finaliza getMontoCredito.

    // Permite modificar el monto del crédito.
    public void setMontoCredito(double montoCredito) {

        // Reemplaza el monto guardado por el recibido.
        this.montoCredito = montoCredito;

    } // Finaliza setMontoCredito.

    // Permite consultar la tarjeta asociada.
    public TarjetaCredito getTarjetaCredito() {

        // Devuelve la referencia a la tarjeta.
        return tarjetaCredito;

    } // Finaliza getTarjetaCredito.

    // Permite modificar la tarjeta asociada.
    public void setTarjetaCredito(TarjetaCredito tarjetaCredito) {

        // Reemplaza la tarjeta por la recibida.
        this.tarjetaCredito = tarjetaCredito;

    } // Finaliza setTarjetaCredito.

    // Permite consultar la factura asociada.
    public Factura getFactura() {

        // Devuelve la referencia a la factura.
        return factura;

    } // Finaliza getFactura.

    // Permite consultar las cuotas del crédito.
    public List<Cuota> getCuotas() {

        // Devuelve la lista original, no una copia.
        return cuotas;

    } // Finaliza getCuotas.

    // Permite reemplazar la lista de cuotas.
    public void setCuotas(List<Cuota> cuotas) {

        // Asigna la lista recibida.
        this.cuotas = cuotas;

    } // Finaliza setCuotas.

    // Declara una constante pública compartida por todos los créditos.
    // static: pertenece a la clase; final: no puede cambiar su valor.
    public static final int CANTIDAD_CUOTAS = 20;

    // Declara el método que genera las cuotas del crédito.
    public void generarCuotas() {

        // Divide el total de la factura entre las 20 cuotas.
        double montoCuota = this.factura.calcularTotal() / CANTIDAD_CUOTAS;

        // Inicializa el contador de números de cuota en cero.
        int nroCuota = 0;

        // Guarda la fecha actual como fecha de generación.
        LocalDate currentDate = LocalDate.now();

        // Guarda otra fecha actual para calcular los vencimientos.
        LocalDate auxDate = LocalDate.now();

        // Repite el bloque 20 veces, con i desde 0 hasta 19.
        for (int i = 0; i < CANTIDAD_CUOTAS; i++) {

            // Incrementa el número de cuota en uno.
            nroCuota++;

            // Crea una cuota utilizando el constructor vacío.
            Cuota cuota = new Cuota();

            // Asigna el importe correspondiente a una cuota.
            cuota.setMonto(montoCuota);

            // Asigna su número, del 1 al 20.
            cuota.setNroCuota(nroCuota);

            // Asigna la misma fecha de generación a todas las cuotas.
            cuota.setFechaGeneracion(currentDate);

            // Avanza un mes desde la fecha del vencimiento anterior.
            // plusMonths devuelve una nueva fecha; por eso se reasigna.
            auxDate = auxDate.plusMonths(1);

            // Asigna la fecha de vencimiento calculada.
            cuota.setFechaVencimiento(auxDate);

            // Agrega la cuota creada a la lista.
            cuotas.add(cuota);

        } // Finaliza el for.

    } // Finaliza generarCuotas.

    // Declara el método que muestra el crédito por consola.
    // Se conserva el nombre mostarCredito de tu código.
    public void mostarCredito() {

        // Imprime la tarjeta, la factura y el título de las cuotas.
        // \n agrega saltos de línea.
        System.out.println(
            "Tarjeta De Credito: " + tarjetaCredito
            + "\n" + factura + "\nCant. Cuotas:\n"
        );

        // Recorre todas las cuotas del crédito.
        for (Cuota cuota : cuotas) {

            // Imprime cada cuota utilizando su método toString().
            System.out.println(cuota);

        } // Finaliza el for.

    } // Finaliza mostarCredito.

} // Finaliza la clase Credito.
