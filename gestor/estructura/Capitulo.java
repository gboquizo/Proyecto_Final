package gestor.estructura;

import java.io.Serializable;
import java.time.LocalDate;
import gestor.estructura.excepciones.CalificacionNoValidaException;

/**
 * Clase que permite la creación de un capítulo.
 * @author Guillermo Boquizo Sánchez.
 * @version 1.0
 *
 */
public class Capitulo implements Serializable, Clasificable {

	private static final long serialVersionUID = 1L;

	/**
	 * Campo para la fecha de emisión del capítulo.
	 */
	private LocalDate fechaEmision;
	
	/**
	 * Campo para la descripción del capítulo.
	 */
	private String descripcion;
	
	/**
	 * Campo para el nombre del capítulo.
	 */
	private String nombre;
	
	/**
	 * Campo para el nombre en versión original del capítulo.
	 */
	private String nombreOriginal;
	
	/**
	 * Campo para la duración del capítulo en minutos.
	 */
	private int duracion;

	/**
	 * Constructor de capítulo.
	 * @param id id del capítulo.
	 * @param calificacion calificación del capítulo.
	 * @param fechaEmision fecha de emisión del capítulo.
	 * @param descripcion descripción del capítulo.
	 * @param nombre nombre del capítulo.
	 * @param nombreOriginal nombre en versión original del capítulo.
	 * @param duracion duración del capítulo en minutos.
	 * @throws CalificacionNoValidaException
	 */
	public Capitulo(LocalDate fechaEmision, String descripcion, String nombre,
			String nombreOriginal, int duracion) throws CalificacionNoValidaException {
		setFechaEmision(fechaEmision);
		setDescripcion(descripcion);
		setNombre(nombre);
		setNombreOriginal(nombreOriginal);
		setDuracion(duracion);
	}
	
	/**
	 * Permite obtener la fecha de emisión del capítulo.
	 * @return fechaEmision la fecha de emisión del capítulo a obtener.
	 */
	LocalDate getFechaEmision() {
		return fechaEmision;
	}
	
	/**
	 * Permite establecer la fecha de emisión del capítulo.
	 * @param fechaEmision la fecha de emisión a establecer.
	 */
	private void setFechaEmision(LocalDate fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	/**
	 * Permite obtener la descripción del capítulo.
	 * @return descripcion la descripción a obtener.
	 */
	String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * Permite establecer la descripción del capítulo.
	 * @param descripcion la descripción a establecer.
	 */
	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Permite obtener el nombre del capítulo.
	 * @return nombre el nombre a obtener.
	 */
	String getNombre() {
		return nombre;
	}
	
	/**
	 * Permite establecer el nombre del capítulo.
	 * @param nombre el nombre a establecer.
	 */
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Permite obtener el nombre en versión original del capítulo.
	 * @return nombreOriginal el nombre en versión original a obtener.
	 */
	String getNombreOriginal() {
		return nombreOriginal;
	}
	
	/**
	 * Permite establecer el nombre en versión original del capítulo.
	 * @param nombreOriginal el nombre en versión original a establecer.
	 */
	private void setNombreOriginal(String nombreOriginal) {
		this.nombreOriginal = nombreOriginal;
	}

	/**
	 * Permite obtener la duración del capítulo.
	 * @return duracion la duración del capítulo a obtener.
	 */
	int getDuracion() {
		return duracion;
	}

	/**
	 * Permite establecer la duración del capítulo.
	 * @param duracion la duración del capítulo a establecer.
	 */
	private void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Capitulo [fechaEmision=" + fechaEmision + ", descripcion=" + descripcion + ", nombre=" + nombre
				+ ", nombreOriginal=" + nombreOriginal + ", duracion=" + duracion + "]";
	}

	@Override
	public void calcularCalificacion() {
		// TODO Auto-generated method stub
		
	}	
}