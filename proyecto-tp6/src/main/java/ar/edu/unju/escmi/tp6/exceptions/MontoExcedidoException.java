package ar.edu.unju.escmi.tp6.exceptions;

public class MontoExcedidoException extends RuntimeException {//esta clase es para poder lanzar una excepcion si el monto de la factura excede el limite de la tarjeta de credito

	private static final long serialVersionUID = 1L;//esta variable es para poder serializar la clase MontoExcedidoException

	public MontoExcedidoException(String errorMessage) {//este constructor es para poder crear una excepcion con un mensaje de error
		super(errorMessage);//este super es para poder llamar al constructor de la clase padre RuntimeException y pasarle el mensaje de error
	}

}
