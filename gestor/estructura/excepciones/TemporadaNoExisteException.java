package gestor.estructura.excepciones;

/**
 * 
 * Clase para controlar la excepción si una temporada no existe.
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class TemporadaNoExisteException extends Exception {

	private static final long serialVersionUID = 1L;

	public TemporadaNoExisteException(String mensaje) {
		super(mensaje);
	}
}