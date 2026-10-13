package ar.edu.unju.escmi.tp6.collections;

import java.util.ArrayList; //este import es para poder usar la clase ArrayList
import java.util.List; // este import es para poder usar la clase List

import ar.edu.unju.escmi.tp6.dominio.Cliente;// este import es para poder usar la clase Cliente
import ar.edu.unju.escmi.tp6.exceptions.ClienteNoEncontradoException;// este import es para poder usar la clase ClienteNoEncontradoException

public class CollectionCliente {//esta clase es para poder guardar los clientes en una lista y poder buscarlos por su dni

	public static List<Cliente> clientes = new ArrayList<Cliente>();//esta lista es para poder guardar los clientes en memoria y poder buscarlos por su dni


    public static void precargarClientes() {
        if (clientes.isEmpty()) {
            clientes.add(new Cliente(45111222, "Mario Barca", "Alvear 120", "65454686"));
            clientes.add(new Cliente(36888666, "Juan Perez", "Av. Belgrano 300", "35185695"));
            clientes.add(new Cliente(25777555, "Ana Juarez", "Islas Malvinas 731", "38845224"));
        }
    }//este metodo es para poder precargar los clientes en la lista de clientes, si la lista esta vacia


    public static void agregarCliente(Cliente cliente) {//este metodo es para poder agregar un cliente a la lista de clientes   
    	try {
    		clientes.add(cliente);
		} catch (Exception e) {
			System.out.println("\nNO SE PUEDE GUARDAR EL CLIENTE");
		}
        
    }////este metodo es para poder agregar un cliente a la lista de clientes

    public static Cliente buscarCliente(long dni) {//este metodo es para poder buscar un cliente por su dni, si no lo encuentra lanza una excepcion
        Cliente clienteEncontrado = null;//este objeto es para poder guardar el cliente encontrado, si no se encuentra el cliente se devuelve null

        try {
        	for (Cliente cli : clientes) {//este for es para poder recorrer la lista de clientes y buscar el cliente por su dni
                if (cli.getDni() == dni) {
                    clienteEncontrado = cli;
                }
            }//este for es para poder recorrer la lista de clientes y buscar el cliente por su dni
		} catch (Exception e) {//este catch es para poder capturar cualquier excepcion que pueda ocurrir al buscar el cliente por su dni
			return null;
		}
        
        if (clienteEncontrado == null) {//este if es para poder lanzar una excepcion si no se encuentra el cliente por su dni
            throw new ClienteNoEncontradoException("No existe un cliente con el DNI " + dni);
        }
        return clienteEncontrado;//este return es para devolver el cliente encontrado por su dni
    }
}
