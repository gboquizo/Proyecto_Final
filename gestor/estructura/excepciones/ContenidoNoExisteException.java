package gestor.estructura.excepciones;

/**
 * 
 * Clase para controlar la excepción si un contenido no existe.
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class ContenidoNoExisteException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ContenidoNoExisteException(String mensaje) {
		super(mensaje);
	}
}