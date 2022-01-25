package cl.prueba.globalLogic.exception;

public class MissingPathVariableException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public MissingPathVariableException(String mensaje) {
		super(mensaje);
	}
	
	public MissingPathVariableException(String mensaje, Throwable throwable) {
		super(mensaje, throwable);
	}
}
