package gestor.estructura.excepciones;

public class TemporadaVaciaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public TemporadaVaciaException(String mensaje) {
		super(mensaje);
	}
}