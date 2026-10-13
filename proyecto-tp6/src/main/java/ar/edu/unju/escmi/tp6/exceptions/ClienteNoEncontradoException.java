package ar.edu.unju.escmi.tp6.exceptions;

public class ClienteNoEncontradoException extends RuntimeException {//esta clase es para poder lanzar una excepcion si no se encuentra un cliente por su dni

	private static final long serialVersionUID = 1L;//esta variable es para poder serializar la clase ClienteNoEncontradoException

	public ClienteNoEncontradoException(String errorMessage) {//este constructor es para poder crear una excepcion con un mensaje de error
		super(errorMessage);
	}//este constructor es para poder crear una excepcion con un mensaje de error

}
