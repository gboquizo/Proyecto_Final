package gestor.estructura.excepciones;

/**
 * 
 * Clase para controlar la excepción si una temporada está vacía.
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class TemporadaVaciaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public TemporadaVaciaException(String mensaje) {
		super(mensaje);
	}
}