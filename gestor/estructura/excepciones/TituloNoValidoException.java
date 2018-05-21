package gestor.estructura.excepciones;

/**
 * Clase para controlar la excepción si un título no es válido.
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class TituloNoValidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public TituloNoValidoException(String mensaje) {
		super(mensaje);
	}
}