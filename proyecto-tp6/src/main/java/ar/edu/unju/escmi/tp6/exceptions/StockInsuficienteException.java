package ar.edu.unju.escmi.tp6.exceptions;

public class StockInsuficienteException extends RuntimeException {//	esta clase es para poder lanzar una excepcion si el stock de un producto es insuficiente para realizar una compra

	private static final long serialVersionUID = 1L;//esta variable es para poder serializar la clase StockInsuficienteException

	public StockInsuficienteException(String errorMessage) {//este constructor es para poder crear una excepcion con un mensaje de error
		super(errorMessage);//este super es para poder llamar al constructor de la clase padre RuntimeException y pasarle el mensaje de error
	}

}
