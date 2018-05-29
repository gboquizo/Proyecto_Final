package gestor.estructura.excepciones;

/**
 * 
 * Clase para controlar la excepción si una temporada ya existe.
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class TemporadaYaExisteException extends Exception {

	private static final long serialVersionUID = 1L;

	public TemporadaYaExisteException(String mensaje) {
		super(mensaje);
	}
}