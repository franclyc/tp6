package ar.edu.unju.escmi.tp6.exceptions;

public class LimiteTarjetaInsuficienteException extends RuntimeException {//esta clase es para poder lanzar una excepcion si el limite de la tarjeta de credito es insuficiente para realizar una compra

	private static final long serialVersionUID = 1L;//esta variable es para poder serializar la clase LimiteTarjetaInsuficienteException

	public LimiteTarjetaInsuficienteException(String errorMessage) {//este constructor es para poder crear una excepcion con un mensaje de error
		super(errorMessage);//este super es para poder llamar al constructor de la clase padre RuntimeException y pasarle el mensaje de error
	}

}
