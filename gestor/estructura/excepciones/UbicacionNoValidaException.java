package gestor.estructura.excepciones;

/**
 * 
 * Clase para controlar la excepción si una ubicación no es válida.
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class UbicacionNoValidaException extends Exception {

	private static final long serialVersionUID = 1L;

	public UbicacionNoValidaException(String mensaje) {
		super(mensaje);
	}
}