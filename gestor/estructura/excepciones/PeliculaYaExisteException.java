package gestor.estructura.excepciones;

/**
 * Clase para controlar la excepción si una película ya existe.
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class PeliculaYaExisteException extends Exception {

	private static final long serialVersionUID = 1L;

	public PeliculaYaExisteException(String mensaje) {
		super(mensaje);
	}
}