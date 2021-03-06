package gestor.estructura;

import java.io.Serializable;
import java.time.LocalDate;

import gestor.estructura.excepciones.CalificacionNoValidaException;
import gestor.estructura.excepciones.FechaNoValidaException;
import gestor.estructura.excepciones.TituloNoValidoException;
import gestor.estructura.excepciones.UbicacionNoValidaException;

/**
 * 
 * Clase que permite la creación de un videojuego.
 * @author Guillermo Boquizo Sánchez.
 * @version 1.0
 *
 */
public class Videojuego extends Contenido implements Serializable, Clasificable {

	private static final long serialVersionUID = 1L;

	private String compannia;

	private Formato formato;

	private String plataforma;

	private String estilo;

	private int totalJuegos;

	private int horasJuego;

	private boolean prestado;

	private String prestadoA;

	private LocalDate fechaPrestamo;

	private String mensaje = "";
	
	private LocalDate fechaDevolucion;

	/**
	 * 
	 * @param titulo
	 * @param tituloOriginal
	 * @param ubicacion
	 * @param estado
	 * @param fechaDeAlta
	 * @param calificacion
	 * @param compannia
	 * @param formato
	 * @param plataforma
	 * @param estilo
	 * @param totalJuegos
	 * @param horasJuego
	 * @param prestado
	 * @param prestadoA
	 * @param fechaPrestamo
	 * @throws CalificacionNoValidaException
	 * @throws TituloNoValidoException 
	 * @throws UbicacionNoValidaException 
	 * @throws FechaNoValidaException 
	 */
	public Videojuego(String titulo, String tituloOriginal, Ubicacion ubicacion, String estado, LocalDate fechaDeAlta,
			double calificacion, String compannia, Formato formato, String plataforma, String estilo, int totalJuegos,
			int horasJuego, boolean prestado, String prestadoA, LocalDate fechaPrestamo, LocalDate fechaDevolucion)
			throws CalificacionNoValidaException, TituloNoValidoException, UbicacionNoValidaException, FechaNoValidaException {
		super(titulo, tituloOriginal, ubicacion, estado, fechaDeAlta, calificacion);
		setCompannia(compannia);
		setFormato(formato);
		setPlataforma(plataforma);
		setEstilo(estilo);
		setTotalJuegos(totalJuegos);
		setHorasJuego(horasJuego);
		setPrestado(prestado);
		setPrestadoA(prestadoA);
		setFechaPrestamo(fechaPrestamo);
		setFechaDevolucion(fechaDevolucion);
	}

	/**
	 * @return the compannia
	 */
	public String getCompannia() {
		return compannia;
	}

	/**
	 * @param compannia
	 *            the compannia to set
	 */
	protected void setCompannia(String compannia) {
		this.compannia = compannia;
	}

	/**
	 * @return the formato
	 */
	public Formato getFormato() {
		return formato;
	}

	/**
	 * @param formato
	 *            the formato to set
	 */
	protected void setFormato(Formato formato) {
		this.formato = formato;
	}

	/**
	 * @return the plataforma
	 */
	public String getPlataforma() {
		return plataforma;
	}

	/**
	 * @param plataforma
	 *            the plataforma to set
	 */
	protected void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	/**
	 * @return the estilo
	 */
	public String getEstilo() {
		return estilo;
	}

	/**
	 * @param estilo
	 *            the estilo to set
	 */
	protected void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	/**
	 * @return the numJuego
	 */
	public int getTotalJuegos() {
		return totalJuegos;
	}

	/**
	 * @param numJuego
	 *            the numJuego to set
	 */
	protected void setTotalJuegos(int totalJuegos) {
		this.totalJuegos = totalJuegos;
	}

	/**
	 * @return the horasJuego
	 */
	public int getHorasJuego() {
		return horasJuego;
	}

	/**
	 * @param horasJuego
	 *            the horasJuego to set
	 */
	protected void setHorasJuego(int horasJuego) {
		this.horasJuego = horasJuego;
	}

	/**
	 * @return the prestadoA
	 */
	public String getPrestadoA() {
		return prestadoA;
	}

	/**
	 * @param prestadoA
	 *            the prestadoA to set
	 */
	protected void setPrestadoA(String prestadoA) {
		if(prestadoA == null)
			prestadoA = "El videojuego no se encuentra prestado";
		this.prestadoA = prestadoA;
	}

	/**
	 * @return the fechaPrestamo
	 */
	public LocalDate getFechaPrestamo() {
		return fechaPrestamo;
	}

	/**
	 * @param fechaPrestamo
	 *            the fechaPrestamo to set
	 * @throws FechaNoValidaException 
	 */
	protected void setFechaPrestamo(LocalDate fechaPrestamo) throws FechaNoValidaException {
		if (prestado == false)
			fechaPrestamo = LocalDate.of(0000, 1, 1);
		this.fechaPrestamo = fechaPrestamo;	
	}

	/**
	 * @return the prestado
	 */
	public boolean getPrestado() {
		return prestado;
	}

	/**
	 * @param prestado
	 *            the prestado to set
	 */
	private void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}
	
	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	private void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public void calcularCalificacion() {

	}
	
	public int compareTo(Videojuego o) {
		return (int) Math.round((o.getFechaDevolucion().compareTo(this.getFechaDevolucion())));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" + "\n\tVideojuego: " + "\n\tCompañía: " + getCompannia() + ". \n\tFormato:"
				+ getFormato() + ". \n\tPlataforma:" + getPlataforma() + ". \n\tEstilo:" + getEstilo()
				+ ". \n\tVeces jugado:" + getTotalJuegos() + ". \n\tTotal de horas jugadas:" + getHorasJuego()
				+ ". \n\tPrestado:" + getPrestado() + ". \n\tPrestado a:" + getPrestadoA() + ". \n\tFecha de préstamo: "
				+ getFechaPrestamo() + mensaje +"\n";
	}
}