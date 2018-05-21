package gestor.estructura;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import gestor.estructura.excepciones.CalificacionNoValidaException;
import gestor.estructura.excepciones.FechaNoValidaException;
import gestor.estructura.excepciones.TemporadaNoExisteException;
import gestor.estructura.excepciones.TemporadaVaciaException;
import gestor.estructura.excepciones.TemporadaYaExisteException;
import gestor.estructura.excepciones.TituloNoValidoException;
import gestor.estructura.excepciones.UbicacionNoValidaException;

public class Serie extends Contenido implements Serializable, Clasificable {

	private static final long serialVersionUID = 1L;

	private ArrayList<Temporada> temporadas = new ArrayList<Temporada>();

	private String medio;

	private String sinopsis;

	private Genero genero;

	private Idioma idioma;

	private int visualizaciones;

	/**
	 * 
	 * @param titulo
	 * @param tituloOriginal
	 * @param ubicacion
	 * @param estado
	 * @param fechaDeAlta
	 * @param calificacion
	 * @param medio
	 * @param sinopsis
	 * @param numTemporadas
	 * @param genero
	 * @param idioma
	 * @param visualizaciones
	 * @throws CalificacionNoValidaException
	 * @throws TituloNoValidoException
	 * @throws TemporadaVaciaException
	 * @throws UbicacionNoValidaException 
	 * @throws FechaNoValidaException 
	 */
	public Serie(String titulo, String tituloOriginal, Ubicacion ubicacion, String estado, LocalDate fechaDeAlta,
			double calificacion, String medio, String sinopsis, int numTemporadas, Genero genero, Idioma idioma,
			int visualizaciones)
			throws CalificacionNoValidaException, TituloNoValidoException, TemporadaVaciaException, UbicacionNoValidaException, FechaNoValidaException {
		super(titulo, tituloOriginal, ubicacion, estado, fechaDeAlta, calificacion);
		setMedio(medio);
		setSinopsis(sinopsis);
		setTemporadas(temporadas);
		setGenero(genero);
		setIdioma(idioma);
		setVisualizaciones(visualizaciones);
	}

	public Serie(int id, double calificacion) throws CalificacionNoValidaException {
		super(id, calificacion);
	}

	private void setTemporadas(ArrayList<Temporada> temporada) throws TemporadaVaciaException {
		//if (temporada.isEmpty())
			//throw new TemporadaVaciaException("Temporada vacía");
		this.temporadas = temporada;
	}

	public ArrayList<Temporada> getTemporadas() {
		return temporadas;
	}

	int tamannoSerie() {
		return temporadas.size();
	}

	/**
	 * @return the medio
	 */
	String getMedio() {
		return medio;
	}

	/**
	 * @return the sinopsis
	 */
	String getSinopsis() {
		return sinopsis;
	}

	/**
	 * @return the genero
	 */
	Genero getGenero() {
		return genero;
	}

	/**
	 * @return the idioma
	 */
	Idioma getIdioma() {
		return idioma;
	}

	/**
	 * @return the visualizaciones
	 */
	int getVisualizaciones() {
		return visualizaciones;
	}

	/**
	 * @param medio
	 */
	private void setMedio(String medio) {
		this.medio = medio;
	}

	/**
	 * @param sinopsis
	 */
	private void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	private void setGenero(Genero genero) {
		this.genero = genero;
	}

	private void setIdioma(Idioma idioma) {
		this.idioma = idioma;

	}

	private void setVisualizaciones(int visualizaciones) {
		this.visualizaciones = visualizaciones;
	}

	public void annadirTemporada(LocalDate fechaDeInicio, LocalDate fechaDeFin) throws CalificacionNoValidaException,
			TemporadaYaExisteException, TituloNoValidoException, TemporadaVaciaException {
		Temporada temporada = new Temporada(fechaDeInicio, fechaDeFin);
		if (temporadas.contains(temporada))
			throw new TemporadaYaExisteException("\n\tLa temporada ya está registrada en la serie. ");
		temporadas.add(temporada);
	}

	public void eliminarTemporada(int id) throws TemporadaNoExisteException {
		try {
			temporadas.remove(id);
		} catch (IndexOutOfBoundsException e) {
			throw new TemporadaNoExisteException("La temporada no existe.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" + "\n\tSerie: " + "\n\tMedio: " + getMedio() + ". \n\tSinopsis: " + getSinopsis()
				+ ". \n\tTemporadas: " + getTemporadas() + ". \n\tGenero: " + getGenero() + ". \n\tIdioma: "
				+ getIdioma() + ". \n\tVisualizaciones: " + getVisualizaciones();
	}
}