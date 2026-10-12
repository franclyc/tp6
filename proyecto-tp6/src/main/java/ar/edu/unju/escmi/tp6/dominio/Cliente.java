// Indica el paquete al que pertenece la clase.
package ar.edu.unju.escmi.tp6.dominio;

// Importa ArrayList para crear una lista de compras.
import java.util.ArrayList;

// Importa List para declarar variables de tipo lista.
import java.util.List;

// Importa la colección que contiene las facturas registradas.
import ar.edu.unju.escmi.tp6.collections.CollectionFactura;

// Declara la clase pública Cliente.
public class Cliente {

    // Guarda el DNI como un número entero de tipo long.
    private long dni;

    // Guarda el nombre del cliente.
    private String nombre;

    // Guarda la dirección del cliente.
    private String direccion;

    // Guarda el teléfono como texto.
    private String telefono;

    // Constructor vacío: permite crear un cliente sin pasar datos.
    public Cliente() {

    } // Finaliza el constructor vacío.

    // Constructor que recibe todos los datos del cliente.
    public Cliente(long dni, String nombre, String direccion, String telefono) {

        // Llama al constructor de Object, la clase padre implícita.
        super();

        // Asigna el DNI recibido al atributo de este objeto.
        this.dni = dni;

        // Asigna el nombre recibido al atributo de este objeto.
        this.nombre = nombre;

        // Asigna la dirección recibida al atributo de este objeto.
        this.direccion = direccion;

        // Asigna el teléfono recibido al atributo de este objeto.
        this.telefono = telefono;

    } // Finaliza el constructor con parámetros.

    // Permite consultar el DNI.
    public long getDni() {

        // Devuelve el DNI guardado.
        return dni;

    } // Finaliza getDni.

    // Permite modificar el DNI; void indica que no devuelve un valor.
    public void setDni(long dni) {

        // Reemplaza el DNI del objeto por el recibido.
        this.dni = dni;

    } // Finaliza setDni.

    // Permite consultar el nombre.
    public String getNombre() {

        // Devuelve el nombre guardado.
        return nombre;

    } // Finaliza getNombre.

    // Permite modificar el nombre.
    public void setNombre(String nombre) {

        // Reemplaza el nombre del objeto por el recibido.
        this.nombre = nombre;

    } // Finaliza setNombre.

    // Permite consultar la dirección.
    public String getDireccion() {

        // Devuelve la dirección guardada.
        return direccion;

    } // Finaliza getDireccion.

    // Permite modificar la dirección.
    public void setDireccion(String direccion) {

        // Reemplaza la dirección del objeto por la recibida.
        this.direccion = direccion;

    } // Finaliza setDireccion.

    // Permite consultar el teléfono.
    public String getTelefono() {

        // Devuelve el teléfono guardado.
        return telefono;

    } // Finaliza getTelefono.

    // Permite modificar el teléfono.
    public void setTelefono(String telefono) {

        // Reemplaza el teléfono del objeto por el recibido.
        this.telefono = telefono;

    } // Finaliza setTelefono.

    // Devuelve una lista con las facturas correspondientes a este cliente.
    public List<Factura> consultarCompras() {

        // Crea una lista vacía para guardar las facturas encontradas.
        List<Factura> shoppingList = new ArrayList<Factura>();

        // Comprueba que la colección de facturas no sea null.
        if (CollectionFactura.facturas != null) {

            // Recorre todas las facturas; fac representa la factura actual.
            for (Factura fac : CollectionFactura.facturas) {

                // Compara el DNI del cliente de la factura con el de este objeto.
                if (fac.getCliente().getDni() == this.dni) {

                    // Agrega la factura si corresponde a este cliente.
                    shoppingList.add(fac);

                } // Finaliza el if.

            } // Finaliza el for.

        // Se ejecuta si la colección de facturas es null.
        } else {

            // Reemplaza la lista creada por null.
            shoppingList = null;

        } // Finaliza el if/else.

        // Devuelve la lista de compras o null, según el caso anterior.
        return shoppingList;

    } // Finaliza consultarCompras.

} // Finaliza la clase Cliente.
