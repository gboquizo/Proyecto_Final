package gestor.estructura.excepciones;

public class TemporadaNoExisteException extends Exception {

	private static final long serialVersionUID = 1L;

	public TemporadaNoExisteException(String mensaje) {
		super(mensaje);
	}
}