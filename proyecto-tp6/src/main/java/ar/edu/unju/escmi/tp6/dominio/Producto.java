// Indica el paquete al que pertenece la clase.
package ar.edu.unju.escmi.tp6.dominio;

// Declara la clase pública Producto.
public class Producto {

    // Guarda el código del producto como un entero de tipo long.
    private long codigo;

    // Guarda la descripción del producto.
    private String descripcion;

    // Guarda el precio de una unidad.
    private double precioUnitario;

    // Guarda el origen de fabricación del producto.
    private String origenFabricacion;

    // Indica si el producto es un teléfono.
    // Credito utiliza este dato para controlar el límite de $1.000.000.
    private boolean esTelefono;

    // Constructor vacío: permite crear un producto sin pasar datos.
    public Producto() {}

    // Constructor que recibe cuatro datos y un precio de tipo double.
    public Producto(long codigo, String descripcion,
                    double precioUnitario, String origenFabricacion) {

        // Llama al constructor de cinco parámetros de esta misma clase.
        // false indica que inicialmente no se considera un teléfono.
        this(codigo, descripcion, precioUnitario, origenFabricacion, false);

    } // Finaliza el constructor.

    // Otra versión del constructor que recibe el precio como int.
    // Tener constructores con distintos parámetros se llama sobrecarga.
    public Producto(long codigo, String descripcion,
                    int precioUnitario, String origenFabricacion) {

        // Convierte el precio a double y llama al constructor de cinco parámetros.
        // También asigna false al indicador esTelefono.
        this(codigo, descripcion, (double) precioUnitario, origenFabricacion, false);

    } // Finaliza el constructor.

    // Constructor que recibe todos los datos, incluido el indicador de teléfono.
    public Producto(long codigo, String descripcion,
                    double precioUnitario, String origenFabricacion,
                    boolean esTelefono) {

        // Asigna el código recibido al atributo de este objeto.
        this.codigo = codigo;

        // Asigna la descripción recibida.
        this.descripcion = descripcion;

        // Asigna el precio unitario recibido.
        this.precioUnitario = precioUnitario;

        // Asigna el origen de fabricación recibido.
        this.origenFabricacion = origenFabricacion;

        // Asigna el indicador recibido: true para teléfono, false para otro producto.
        this.esTelefono = esTelefono;

    } // Finaliza el constructor con todos los parámetros.

    // Permite consultar el código.
    public long getCodigo() {

        // Devuelve el código guardado.
        return codigo;

    } // Finaliza getCodigo.

    // Permite modificar el código.
    public void setCodigo(long codigo) {

        // Reemplaza el código por el recibido.
        this.codigo = codigo;

    } // Finaliza setCodigo.

    // Permite consultar la descripción.
    public String getDescripcion() {

        // Devuelve la descripción guardada.
        return descripcion;

    } // Finaliza getDescripcion.

    // Permite modificar la descripción.
    public void setDescripcion(String descripcion) {

        // Reemplaza la descripción por la recibida.
        this.descripcion = descripcion;

    } // Finaliza setDescripcion.

    // Permite consultar el precio unitario.
    public double getPrecioUnitario() {

        // Devuelve el precio guardado.
        return precioUnitario;

    } // Finaliza getPrecioUnitario.

    // Permite modificar el precio unitario.
    public void setPrecioUnitario(double precioUnitario) {

        // Reemplaza el precio por el recibido.
        this.precioUnitario = precioUnitario;

    } // Finaliza setPrecioUnitario.

    // Permite consultar el origen de fabricación.
    public String getOrigenFabricacion() {

        // Devuelve el origen guardado.
        return origenFabricacion;

    } // Finaliza getOrigenFabricacion.

    // Permite modificar el origen de fabricación.
    public void setOrigenFabricacion(String origenFabricacion) {

        // Reemplaza el origen por el recibido.
        this.origenFabricacion = origenFabricacion;

    } // Finaliza setOrigenFabricacion.

    // Permite consultar si el producto es un teléfono.
    public boolean isEsTelefono() {

        // Devuelve el indicador guardado.
        return esTelefono;

    } // Finaliza isEsTelefono.

    // Permite modificar el indicador de teléfono.
    public void setEsTelefono(boolean esTelefono) {

        // Reemplaza el indicador por el recibido.
        this.esTelefono = esTelefono;

    } // Finaliza setEsTelefono.

    // Indica que se redefine el método toString heredado de Object.
    @Override

    // Devuelve una representación del producto como texto.
    public String toString() {

        // Añade el código, la descripción y el precio unitario.
        return "Codigo: " + codigo
                + " Descripcion: " + descripcion
                + " Precio Unitario: " + precioUnitario

                // Añade el origen de fabricación y devuelve el texto completo.
                + " Origen fabricacion: " + origenFabricacion;

    } // Finaliza toString.

} // Finaliza la clase Producto.
