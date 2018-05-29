package gestor.estructura;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import gestor.estructura.excepciones.CalificacionNoValidaException;
import gestor.estructura.excepciones.CapituloYaExisteException;
import gestor.estructura.excepciones.TemporadaVaciaException;
import gestor.estructura.excepciones.TituloNoValidoException;

/**
 * Clase envoltorio de capítulos.
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class Temporada implements Serializable, Clasificable {

	private static final long serialVersionUID = 1L;

	private ArrayList<Capitulo> capitulos = new ArrayList<Capitulo>();

	private int numCapitulos;

	private LocalDate fechaDeInicio;

	private LocalDate fechaDeFin;

	public Temporada(LocalDate fechaDeInicio, LocalDate fechaDeFin)
			throws CalificacionNoValidaException, TituloNoValidoException, TemporadaVaciaException {
		setCapitulos(numCapitulos);
		setFechaDeInicio(fechaDeInicio);
		setFechaDeFin(fechaDeFin);
	}

	private void setCapitulos(int numCapitulos) throws TemporadaVaciaException {
		//if (numCapitulos <= 0 || numCapitulos > tamannoTemporada())
			//throw new TemporadaVaciaException("Temporada vacía");
		this.numCapitulos = numCapitulos;
	}

	int getCapitulos() {
		return numCapitulos;
	}

	/**
	 * @return the fechaDeInicio
	 */
	LocalDate getFechaDeInicio() {
		return fechaDeInicio;
	}

	/**
	 * @return the fechaDeFin
	 */
	LocalDate getFechaDeFin() {
		return fechaDeFin;
	}

	/**
	 * @param fechaDeFin
	 */
	private void setFechaDeFin(LocalDate fechaDeFin) {
		this.fechaDeFin = fechaDeFin;
	}

	public ArrayList<Capitulo> getCapitulo() {
		return capitulos;
	}

	public void setCapitulo(ArrayList<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}

	private void setFechaDeInicio(LocalDate fechaDeInicio) {
		this.fechaDeInicio = fechaDeInicio;
	}

	void annadirCapitulo(LocalDate fechaEmision, String descripcion, String nombre, String nombreOriginal, int duracion)
			throws CapituloYaExisteException, CalificacionNoValidaException {
		Capitulo capitulo = new Capitulo(fechaEmision, descripcion, nombre, nombreOriginal, duracion);
		if (capitulos.contains(capitulo))
			throw new CapituloYaExisteException("\n\tEl capítulo ya existe en la temporada. ");
		capitulos.add(capitulo);
	}

	int tamannoTemporada() {
		return capitulos.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Temporada [capitulos=" + getCapitulos() + ", fechaDeInicio=" + getFechaDeInicio() + ", fechaDeFin="
				+ getFechaDeFin() + "]";
	}

	@Override
	public void calcularCalificacion() {

	}
}