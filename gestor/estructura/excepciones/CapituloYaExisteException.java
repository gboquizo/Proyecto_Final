package gestor.estructura.excepciones;

/**
 * Clase para controlar la excepción si un capitulo ya existe.
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class CapituloYaExisteException extends Exception {

	private static final long serialVersionUID = 1L;

	public CapituloYaExisteException(String mensaje) {
		super(mensaje);
	}
}