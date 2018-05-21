package gestor.estructura.excepciones;

/**
 * Clase para controlar la excepción si un videojuego ya existe.
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class VideojuegoYaExisteException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public VideojuegoYaExisteException(String mensaje) {
		super(mensaje);
	}
}