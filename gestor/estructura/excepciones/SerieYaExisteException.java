package gestor.estructura.excepciones;

public class SerieYaExisteException extends Exception {

	private static final long serialVersionUID = 1L;

	public SerieYaExisteException(String mensaje) {
		super(mensaje);
	}
}