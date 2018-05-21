package gestor.estructura.excepciones;

public class UbicacionNoValidaException extends Exception {

	private static final long serialVersionUID = 1L;

	public UbicacionNoValidaException(String mensaje) {
		super(mensaje);
	}
}