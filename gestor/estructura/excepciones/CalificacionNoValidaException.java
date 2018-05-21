package gestor.estructura.excepciones;

/**
 * Clase para controlar la excepción si una calificación no es válida.
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class CalificacionNoValidaException extends Exception {

	private static final long serialVersionUID = 1L;

	public CalificacionNoValidaException(String mensaje) {
		super(mensaje);
	}
}