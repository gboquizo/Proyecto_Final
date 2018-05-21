package gestor.estructura;

import java.io.Serializable;
import java.time.LocalDate;

import gestor.estructura.excepciones.CalificacionNoValidaException;
import gestor.estructura.excepciones.FechaNoValidaException;
import gestor.estructura.excepciones.TituloNoValidoException;
import gestor.estructura.excepciones.UbicacionNoValidaException;

/**
 * Clase que permite la creación de una Pelicula.
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class Pelicula extends Contenido implements Serializable, Clasificable {
	
	/**
	 * Id único para la clase.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Campo para el director.
	 */
	private String director;
	
	/**
	 * Campo para el género.
	 */
	private Genero genero;
	
	/**
	 * Campo para el idioma.
	 */
	private Idioma idioma;
	
	/**
	 * Campo para la fecha de estreno.
	 */
	private LocalDate annoEstreno;
	
	/**
	 * Campo para el soporte.
	 */
	private Soporte soporte;
	
	/**
	 * Campo para el visionado.
	 */
	private int visionado;
	
	/**
	 * Campo para la duración.
	 */
	private int duracion;
	
	/**
	 * Campo para los premios.
	 */
	private int premios;
	
	/**
	 * Constructor de la película.
	 * @param titulo título de la película.
	 * @param tituloOriginal título original de la película.
	 * @param ubicacion ubicación de la película.
	 * @param estado estado de visionado de la película.
	 * @param fechaDeAlta fecha de alta en el sistema de la película.
	 * @param calificacion calificación de la película.
	 * @param director director de la película.
	 * @param genero género de la película.
	 * @param idioma idioma de la película.
	 * @param annoEstreno año de estreno de la película.
	 * @param soporte soporte en el que se edita la película.
	 * @param visionado nº de veces que se ha visto la película.
	 * @param duracion duración de la película.
	 * @param premios premios de la película.
	 * @throws CalificacionNoValidaException 
	 * @throws TituloNoValidoException 
	 * @throws UbicacionNoValidaException 
	 * @throws FechaNoValidaException 
	 */
	public Pelicula(
			String titulo, String tituloOriginal, Ubicacion ubicacion, String estado, LocalDate fechaDeAlta,
			double calificacion, String director, Genero genero, Idioma idioma, LocalDate annoEstreno, Soporte soporte,
			int visionado, int duracion, int premios) throws CalificacionNoValidaException, TituloNoValidoException, UbicacionNoValidaException, FechaNoValidaException {
		super(titulo, tituloOriginal, ubicacion, estado, fechaDeAlta, calificacion);
		setDirector(director);
		setGenero(genero);
		setIdioma(idioma);
		setAnnoEstreno(annoEstreno);
		setSoporte(soporte);
		setVisionado(visionado);
		setDuracion(duracion);
		setPremios(premios);
	}

	/**
	 * Método que permite establecer el director.
	 * @param director director a establecer.
	 */
	private void setDirector(String director) {
		this.director = director;
	}

	/**
	 * Método que permite obtener el director.
	 * @return director el director a obtener.
	 */
	String getDirector() {
		return director;
	}

	/**
	 * @param genero the genero to set
	 */
	private void setGenero(Genero genero) {
		this.genero = genero;
	}

	/**
	 * @return the genero
	 */
	Genero getGenero() {
		return genero;
	}

	/**
	 * @param idioma the idioma to set
	 */
	private void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
	
	/**
	 * @return the idioma
	 */
	Idioma getIdioma() {
		return idioma;
	}

	/**
	 * @param annoEstreno the annoEstreno to set
	 */
	private void setAnnoEstreno(LocalDate annoEstreno) {
		this.annoEstreno = annoEstreno;
	}
	
	/**
	 * @return the annoEstreno
	 */
	LocalDate getAnnoEstreno() {
		return annoEstreno;
	}

	/**
	 * @param soporte the soporte to set
	 */
	private void setSoporte(Soporte soporte) {
		this.soporte = soporte;
	}

	/**
	 * @return the soporte
	 */
	Soporte getSoporte() {
		return soporte;
	}

	/**
	 * @param visionado the visionado to set
	 */
	private void setVisionado(int visionado) {
		this.visionado = visionado;
	}
	
	/**
	 * @return the visionado
	 */
	int getVisionado() {
		return visionado;
	}

	/**
	 * @param duracion the duracion to set
	 */
	private void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	/**
	 * @return the duracion
	 */
	int getDuracion() {
		return duracion;
	}

	/**
	 * @param premios the premios to set
	 */
	private void setPremios(int premios) {
		this.premios = premios;
	}
	
	/**
	 * @return the premios
	 */
	int getPremios() {
		return premios;
	}

	public void calcularCalificacion() {
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString() + "\n");
		builder.append("\n\tPelicula: \n\tDirector:");
		builder.append(getDirector());
		builder.append(". \n\tGénero:");
		builder.append(getGenero());
		builder.append(". \n\tIdioma:");
		builder.append(getIdioma());
		builder.append(". \n\tAño de estreno:");
		builder.append(getAnnoEstreno());
		builder.append(". \n\tSoporte:");
		builder.append(getSoporte());
		builder.append(". \n\tNº de veces vista:");
		builder.append(getVisionado());
		builder.append(". \n\tDuración(min):");
		builder.append(getDuracion());
		builder.append(". \n\tPremios obtenidos:");
		builder.append(getPremios());
		builder.append(".\n");
		return builder.toString();
	}
}