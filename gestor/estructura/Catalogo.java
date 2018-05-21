package gestor.estructura;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ListIterator;

import gestor.estructura.excepciones.CalificacionNoValidaException;
import gestor.estructura.excepciones.ContenidoNoExisteException;
import gestor.estructura.excepciones.FechaNoValidaException;
import gestor.estructura.excepciones.PeliculaYaExisteException;
import gestor.estructura.excepciones.SerieYaExisteException;
import gestor.estructura.excepciones.TemporadaVaciaException;
import gestor.estructura.excepciones.TituloNoValidoException;
import gestor.estructura.excepciones.UbicacionNoValidaException;
import gestor.estructura.excepciones.VideojuegoYaExisteException;

/**
 * Clase envoltorio de Contenido
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class Catalogo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Campo para el nombre del catálogo.
	 */
	private final String NOMBRE = "Gestor de contenidos Guillermo Boquizo Sánchez";
	
	/**
	 * Campo Arraylist que contiene objetos de tipo Contenido.
	 */
	private ArrayList<Contenido> catalogo = new ArrayList<Contenido>();
	
	/**
	 * Campo Arraylist que contiene objetos de tipo Contenido para los iteradores.
	 */
	private ArrayList<Contenido> lista;
	
	/**
	 * Método que permite añadir una película al catálogo.
	 * @param titulo título de la película.
	 * @param tituloOriginal título original de la película.
	 * @param ubicacion ubicación en la que se encuentra la película.
	 * @param estado estado de visualización de la película.
	 * @param fechaDeAlta fecha de alta en el sistema de la película.
	 * @param calificacion calificación de la película.
	 * @param director director de la película.
	 * @param genero genero de la película.
	 * @param idioma idioma de la película.
	 * @param annoEstreno año de estreno de la película.
	 * @param soporte soporte en el que se encuentra almacenada la película.
	 * @param visionado nº de veces que se ha visionado la película.
	 * @param duracion duración (en minutos de la película).
	 * @param premios premios importantes que posee la película.
	 * @throws CalificacionNoValidaException si la calificación es inválida.
	 * @throws PeliculaYaExisteException si la película ya existe en el catálogo.
	 * @throws TituloNoValidoException si el título no cumple con un patrón predefinido.
	 * @throws UbicacionNoValidaException 
	 * @throws FechaNoValidaException 
	 */
	public void annadirPelicula(String titulo, String tituloOriginal, Ubicacion ubicacion, String estado,
			LocalDate fechaDeAlta, double calificacion, String director, Genero genero, Idioma idioma,
			LocalDate annoEstreno, Soporte soporte, int visionado, int duracion, int premios)
			throws CalificacionNoValidaException, PeliculaYaExisteException, TituloNoValidoException, UbicacionNoValidaException, FechaNoValidaException {
		Pelicula pelicula = new Pelicula(titulo, tituloOriginal, ubicacion, estado, fechaDeAlta, calificacion, director,
				genero, idioma, annoEstreno, soporte, visionado, duracion, premios);
		if (catalogo.contains(pelicula))
			throw new PeliculaYaExisteException("La película ya está en el catálogo");
		catalogo.add(pelicula);
	}
	
	/**
	 * Método que permite añadir un videojuego al catálogo.
	 * @param titulo título del videojuego.
	 * @param tituloOriginal titulo original del videojuego.
	 * @param ubicacion ubicación del videojuego.
	 * @param estado estado de juego del videojuego.
	 * @param fechaDeAlta fecha de alta en el sistema del videojuego.
	 * @param calificacion calificación del videojuego.
	 * @param compannia compañía del videojuego.
	 * @param formato formato en el que se almacena el videojuego.
	 * @param plataforma plataforma para la que se edita el videojuego.
	 * @param estilo estilo del videojuego.
	 * @param totalJuegos nº de veces jugado el videojuego.
	 * @param horasJuego nº de horas de juego del videojuego.
	 * @param prestado estado de préstamo del videojuego.
	 * @param prestadoA persona a la que se realiza el préstamo del videojuego.
	 * @param fechaPrestamo fecha de préstamo del videojuego.
	 * @throws CalificacionNoValidaException si la calificación es inválida.
	 * @throws VideojuegoYaExisteException si el videojuego ya existe en el catálogo.
	 * @throws TituloNoValidoException si el título no cumple con un patrón predefinido.
	 * @throws UbicacionNoValidaException 
	 * @throws FechaNoValidaException 
	 */
	public void annadirVideojuego(String titulo, String tituloOriginal, Ubicacion ubicacion, String estado,
			LocalDate fechaDeAlta, double calificacion, String compannia, Formato formato, String plataforma,
			String estilo, int totalJuegos, int horasJuego, boolean prestado, String prestadoA, LocalDate fechaPrestamo)
			throws CalificacionNoValidaException, VideojuegoYaExisteException, TituloNoValidoException, UbicacionNoValidaException, FechaNoValidaException {
		Videojuego videojuego = new Videojuego(titulo, tituloOriginal, ubicacion, estado, fechaDeAlta, calificacion,
				compannia, formato, plataforma, estilo, totalJuegos, horasJuego, prestado, prestadoA, fechaPrestamo);
		if (catalogo.contains(videojuego))
			throw new VideojuegoYaExisteException("El videojuego ya está en el catálogo");
		catalogo.add(videojuego);
	}
	
	/**
	 * 
	 * Método que permite añadir una serie al catálogo.
	 * @param titulo título de la serie.
	 * @param tituloOriginal titulo original de la serie.
	 * @param ubicacion ubicación de la serie.
	 * @param estado estado de visionado de la serie.
	 * @param fechaDeAlta fecha de alta en el sistema de la serie.
	 * @param calificacion calificación de la serie.
	 * @param medio medio en el que se emite la serie.
	 * @param sinopsis
	 * @param numTemporadas
	 * @param genero
	 * @param idioma
	 * @param visualizaciones
	 * @throws SerieYaExisteException
	 * @throws CalificacionNoValidaException
	 * @throws TituloNoValidoException
	 * @throws TemporadaVaciaException
	 * @throws UbicacionNoValidaException 
	 * @throws FechaNoValidaException 
	 */
	public void annadirSerie(String titulo, String tituloOriginal, Ubicacion ubicacion, String estado,
			LocalDate fechaDeAlta, double calificacion, String medio, String sinopsis, int numTemporadas,
			Genero genero, Idioma idioma, int visualizaciones)
			throws SerieYaExisteException, CalificacionNoValidaException, TituloNoValidoException, TemporadaVaciaException, UbicacionNoValidaException, FechaNoValidaException {
		Serie serie = new Serie(titulo, tituloOriginal, ubicacion, estado, fechaDeAlta, calificacion, medio, sinopsis,
				numTemporadas, genero, idioma, visualizaciones);
		if (catalogo.contains(serie))
			throw new SerieYaExisteException("La serie ya está en el catálogo");
		catalogo.add(serie);
	}

	public void eliminar(String titulo) throws ContenidoNoExisteException {
		try {
			for (int i = 0; i < tamanno(); i++) {
				if (catalogo.get(i).getTitulo().equals(titulo))
					catalogo.remove(catalogo.get(i));
			}
		} catch (IndexOutOfBoundsException e) {
			throw new ContenidoNoExisteException("El contenido no existe.");
		}

	}

	/**
	 * Elimina por identificador un contenido.
	 * 
	 * @param id
	 * @throws ContenidoNoExisteException
	 */
	public void eliminarId(int id) throws ContenidoNoExisteException {
		try {
			catalogo.remove(id);
		} catch (IndexOutOfBoundsException e) {
			throw new ContenidoNoExisteException("El contenido no existe.");
		}
	}

	/**
	 * Devuelve el iterador del catálogo
	 * 
	 * @return listiterator de catálogo
	 */
	public ListIterator<Contenido> listarCatalogo() {
		return catalogo.listIterator();
	}

	/**
	 * Lista las películas del catálogo.
	 * 
	 * @return listiterator de películas.
	 */
	public ListIterator<Contenido> listarPeliculas() {
		lista = new ArrayList<Contenido>();
		for (Contenido contenido : catalogo) {
			if (contenido instanceof Pelicula)
				lista.add((Pelicula) contenido);
		}
		return lista.listIterator();
	}

	/**
	 * Lista los videojuegos del catálogo.
	 * 
	 * @return listiterator de videojuegos.
	 */
	public ListIterator<Contenido> listarVideojuegos() {
		lista = new ArrayList<Contenido>();
		for (Contenido contenido : catalogo) {
			if (contenido instanceof Videojuego)
				lista.add((Videojuego) contenido);
		}
		return lista.listIterator();
	}

	/**
	 * Lista los videojuegos del catálogo.
	 * 
	 * @return listiterator de videojuegos.
	 */
	public ListIterator<Contenido> listarSeries() {
		lista = new ArrayList<Contenido>();
		for (Contenido contenido : catalogo) {
			if (contenido instanceof Serie)
				lista.add((Serie) contenido);
		}
		return lista.listIterator();
	}

	/**
	 * Busca un contenido por título
	 * 
	 * @param titulo
	 * @return
	 * @throws ContenidoNoExisteException
	 */
	public ListIterator<Contenido> buscarPorTitulo(String titulo) throws ContenidoNoExisteException {
		lista = new ArrayList<Contenido>();
		if (lista.isEmpty())
			throw new ContenidoNoExisteException("El contenido no existe.");
		for (Contenido contenido : catalogo) {
			if (contenido.getTitulo().equalsIgnoreCase(titulo))
				lista.add(contenido);
		}
		return lista.listIterator();
	}

	/**
	 * Busca un Contenido por id
	 * 
	 * @param id
	 * @return
	 * @throws ContenidoNoExisteException
	 */
	public Contenido buscarPorID(int id) throws ContenidoNoExisteException {
		try {
			Contenido buscado = null;
			for (Contenido contenido : catalogo) {
				if (contenido.getId() == id)
					buscado = contenido;
			}
			return buscado;
		} catch (NullPointerException e) {
			throw new ContenidoNoExisteException("El contenido no existe.");

		}
	}

	public Contenido obtener(int i) {
		return catalogo.get(i);
	}

	public int tamanno() {
		return catalogo.size();
	}

	public boolean vacio() {
		return catalogo.isEmpty();
	}

	public int indexOf(Contenido contenido) {
		return catalogo.indexOf(contenido);
	}

	@Override
	public String toString() {
		return "\n\t" + NOMBRE + "\n\t" + "Catálogo = " + catalogo;
	}
}