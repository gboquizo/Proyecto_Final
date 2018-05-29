package gestor.estructura.excepciones;

/**
 * 
 * Clase para controlar la excepción si un contenido ya existe.
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class ContenidoYaExisteException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public ContenidoYaExisteException(String mensaje) {
		super(mensaje);
	}
}