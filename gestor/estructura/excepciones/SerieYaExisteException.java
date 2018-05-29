package gestor.estructura.excepciones;

/**
 * 
 * Clase para controlar la excepción si una serie ya existe.
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class SerieYaExisteException extends Exception {

	private static final long serialVersionUID = 1L;

	public SerieYaExisteException(String mensaje) {
		super(mensaje);
	}
}