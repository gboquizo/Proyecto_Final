package gestor.estructura;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.regex.Pattern;

import gestor.estructura.excepciones.CalificacionNoValidaException;
import gestor.estructura.excepciones.FechaNoValidaException;
import gestor.estructura.excepciones.TituloNoValidoException;
import gestor.estructura.excepciones.UbicacionNoValidaException;

/**
 * 
 * Clase que permite la creación de un contenido.
 * @author Guillermo Boquizo Sánchez.
 * @version 1.0
 *
 */
public class Contenido implements Serializable, Comparable<Contenido>, Clasificable {
	
	/**
	 * Id único para la clase.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Contador estático que permite generar un id autoincrementable.
	 */
	static int contador = 1;
	
	/**
	 * Id unívoco para el contenido.
	 */
	private int id;
	
	/**
	 * Título del contenido.
	 */
	private String titulo;
	
	/**
	 * Título original del contenido.
	 */
	private String tituloOriginal;
	
	private static final Pattern patronNombre = Pattern.compile("([:´,'\\-a-zA-ZáéíóúñÑ0-9]+\\s?){2,}");
	
	/**
	 * Ubicación del contenido.
	 */
	private Ubicacion ubicacion;
	
	/**
	 * Estado en el que se encuentra el contenido.
	 */
	private String estado;
	
	/**
	 * Fecha de alta del contenido en el sistema.
	 */
	private LocalDate fechaDeAlta;
	
	/**
	 * Calificación del contenido.
	 */
	private double calificacion;
	
	/**
	 * Constructor del contenido.
	 * @param titulo título del contenido.
	 * @param tituloOriginal título original del contenido.
	 * @param ubicacion ubicación del contenido.
	 * @param estado estado del contenido.
	 * @param fechaDeAlta fecha de alta del contenido.
	 * @param calificacion calificación del contenido.
	 * @throws CalificacionNoValidaException si la calificación no es válida.
	 * @throws TituloNoValidoException si el título no cumple un patrón predefinido.
	 * @throws UbicacionNoValidaException 
	 * @throws FechaNoValidaException 
	 */
	Contenido(String titulo, String tituloOriginal, Ubicacion ubicacion, String estado, LocalDate fechaDeAlta,
			double calificacion) throws CalificacionNoValidaException, TituloNoValidoException, UbicacionNoValidaException, FechaNoValidaException {
		setId();
		setTitulo(titulo);
		setTituloOriginal(tituloOriginal);
		setUbicacion(ubicacion);
		setEstado(estado);
		setfechaDeAlta(fechaDeAlta);
		setCalificacion(calificacion);
	}
	
	/**
	 * Constructor con id unívoco del contenido.
	 * @param id id del contenido.
	 * @param titulo título del contenido.
	 * @param tituloOriginal título original del contenido.
	 * @param ubicacion ubicación del contenido.
	 * @param estado estado de visionado/juego del contenido.
	 * @param fechaDeAlta fecha de alta en el sistema del contenido.
	 * @param calificacion calificación del contenido.
	 * @throws CalificacionNoValidaException si la calificación no es válida.
	 * @throws TituloNoValidoException si el título no cumple un patrón predefinido.
	 * @throws UbicacionNoValidaException 
	 * @throws FechaNoValidaException 
	 */
	public Contenido(int id, String titulo, String tituloOriginal, Ubicacion ubicacion, String estado,
			LocalDate fechaDeAlta, double calificacion) throws CalificacionNoValidaException, TituloNoValidoException, UbicacionNoValidaException, FechaNoValidaException {
		setId(id);
		setTitulo(titulo);
		setTituloOriginal(tituloOriginal);
		setUbicacion(ubicacion);
		setEstado(estado);
		setfechaDeAlta(fechaDeAlta);
		setCalificacion(calificacion);
	}
	
	/**
	 * Constructor por id y calificación del contenido.
	 * @param id
	 * @param calificacion
	 * @throws CalificacionNoValidaException 
	 */
	public Contenido(int id, double calificacion) throws CalificacionNoValidaException {
		setId(id);
		setCalificacion(calificacion);
	}
	
	/**
	 * Constructor por título del contenido.
	 * @param titulo
	 * @throws TituloNoValidoException
	 */
	public Contenido(String titulo)   {
		this.titulo = titulo;
	}

	/**
	 * Método para establecer el id, incrementado en cada establecimiento.
	 * @param id 
	 */
	private void setId() {
		id = contador++;
	}
	
	private void setId(int id) {
		this.id = contador++;
	}
	
	public static int resetearID() {
		 int id = contador;
		   contador = 0;
		   return id;
	}

	/**
	 * Método para obtener el id.
	 * 
	 * @return id el id a establecer.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Método para establecer el título.
	 * @param titulo título obtenido.
	 * @throws TituloNoValidoException 
	 */
	private void setTitulo(String titulo) throws TituloNoValidoException {
		if (!comprobarTitulo(titulo))
			throw new TituloNoValidoException("\n\tTítulo no válido");
		this.titulo = titulo;
	}

	/**
	 * Método para obtener el título.
	 * @return titulo el título obtenido.
	 */
	public String getTitulo() {
		return titulo;
	}
	
	protected boolean comprobarTitulo(String titulo) {
		return patronNombre.matcher(titulo).matches();
	}

	/**
	 * Método para establecer el título original.
	 * @param tituloOriginal el título original del contenido.
	 * @throws TituloNoValidoException 
	 */
	private void setTituloOriginal(String tituloOriginal) throws TituloNoValidoException {
		if (!comprobarTitulo(tituloOriginal))
			throw new TituloNoValidoException("\n\tTítulo original no válido");
		this.tituloOriginal = tituloOriginal;
	}

	/**
	 * Método para obtener el título original
	 * @return tituloOriginal el título original obtenido.
	 */
	public String getTituloOriginal() {
		return tituloOriginal;
	}

	/**
	 * Método para establecer la ubicación.
	 * @param ubicacion ubicación a establecer.
	 * @throws UbicacionNoValidaException 
	 */
	private void setUbicacion(Ubicacion ubicacion) throws UbicacionNoValidaException {
		if(ubicacion == null)
			throw new UbicacionNoValidaException("\n\t La ubicación no es válida.");
		this.ubicacion = ubicacion;
	}

	/**
	 * Método para obtener la ubicación.
	 * @return ubicacion la ubicacion obtenida.
	 */
	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	/**
	 * Método para establecer el estado.
	 * @param estado estado a establecer.
	 */
	private void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Método para obtener el estado.
	 * @return estado el estado obtenido.
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Método para establecer la fecha de alta.
	 * @param fechaDeAlta fecha de alta a establecer.
	 * @throws FechaNoValidaException 
	 */
	private void setfechaDeAlta(LocalDate fechaDeAlta) throws FechaNoValidaException {
		if (fechaDeAlta == null)
			throw new FechaNoValidaException("La fecha de alta no es válida");
		this.fechaDeAlta = fechaDeAlta;
			
	}

	/**
	 * Método para obtener la fecha de alta
	 * @return fechaDeAlta la fecha de alta a obtener.
	 */
	public LocalDate getFechaDeAlta() {
		return fechaDeAlta;
	}
	
	

	/**
	 * Método que permite establecer la calificación.
	 * @param calificacion calificación a establecer.
	 * @throws CalificacionNoValidaException  si la calificación no está comprendida entre 0 y 10.
	 */
	private void setCalificacion(double calificacion) throws CalificacionNoValidaException {
		if(calificacion <= 0 || calificacion > 10)
			throw new CalificacionNoValidaException("Error, calificación inválida. Debe estar comprendida entre 0 y 10");
		this.calificacion = calificacion;
	}
	

	/**
	 * Método que permite obtener la calificación.
	 * @return calificacion la calificación a obtener.
	 */
	public double getCalificacion() {
		return calificacion;
	}

	@Override
	public void calcularCalificacion() {

	}

	/**
	 * hashCode para implementar el contains de coche.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}
	
	/**
	 * Equals para implementar el contains de coche.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contenido other = (Contenido) obj;
		if (id != other.id)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n\tContenido: \n\tId:");
		builder.append(getId());
		builder.append(". \n\tTítulo:");
		builder.append(getTitulo());
		builder.append(". \n\tTítulo original:");
		builder.append(getTituloOriginal());
		builder.append(". \n\tUbicación:");
		builder.append(getUbicacion());
		builder.append(". \n\tEstado:");
		builder.append(getEstado());
		builder.append(". \n\tFecha de alta en el sistema:");
		builder.append(getFechaDeAlta());
		builder.append(". \n\tCalificación:");
		builder.append(getCalificacion());
		return builder.toString();
	}

	@Override
	public int compareTo(Contenido o) {
		// TODO Auto-generated method stub
		return 0;
	}
}