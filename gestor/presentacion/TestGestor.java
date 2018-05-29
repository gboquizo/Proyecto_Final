package gestor.presentacion;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import gestor.estructura.Catalogo;
import gestor.estructura.Fichero;
import gestor.estructura.Formato;
import gestor.estructura.Genero;
import gestor.estructura.Idioma;
import gestor.estructura.Serie;
import gestor.estructura.Soporte;
import gestor.estructura.Ubicacion;
import gestor.estructura.excepciones.CalificacionNoValidaException;
import gestor.estructura.excepciones.ContenidoNoExisteException;
import gestor.estructura.excepciones.FechaNoValidaException;
import gestor.estructura.excepciones.PeliculaYaExisteException;
import gestor.estructura.excepciones.SerieYaExisteException;
import gestor.estructura.excepciones.TemporadaVaciaException;
import gestor.estructura.excepciones.TituloNoValidoException;
import gestor.estructura.excepciones.UbicacionNoValidaException;
import gestor.estructura.excepciones.VideojuegoYaExisteException;
import gestor.utiles.Menu;
import gestor.utiles.Teclado;

public class TestGestor {
	private static Menu menuPrincipal = new Menu("Catálogo de contenidos multimedia",
			new String[] { "Alta de contenido", "Baja de contenido", "Buscar contenido", "Mostrar catalogo",
					"Contar contenidos del catálogo", "Gestión de series", "Ficheros" });
	private static Menu menuAltas = new Menu("Menú de altas",
			new String[] { "Alta de película", "Alta de videojuego", "Alta de serie", "Alta predefinidos" });
	private static Menu menuBajas = new Menu("Menú de bajas", new String[] { "Baja por nombre", "Baja por id" });
	private static Menu menuListar = new Menu("Menú listar",
			new String[] { "Catálogo completo", "Listar películas", "Listar videojuegos", "Listar series" });
	private static Menu menuBuscar = new Menu("Menú buscar", new String[] { "Por título", "Por id" });
	private static Menu menuSerie = new Menu("Menú de series", new String[] { "Añadir temporada", "Eliminar temporada",
			"Buscar temporada", "Mostrar temporada", "Contar número de capítulos de la temporada" });
	private static Menu menuUbicaciones = new Menu("Ubicación del contenido", Ubicacion.generarOpcionesMenu());
	private static Menu menuGeneros = new Menu("Género del contenido", Genero.generarOpcionesMenu());
	private static Menu menuIdiomas = new Menu("Idioma del contenido", Idioma.generarOpcionesMenu());
	private static Menu menuSoportes = new Menu("Soporte del contenido", Soporte.generarOpcionesMenu());
	private static Menu menuFormatos = new Menu("Formato del contenido", Formato.generarOpcionesMenu());
	private static Menu menuFicheros = new Menu("FICHEROS",
			new String[] { "Nuevo", "Abrir", "Guardar", "Guardar como..." });
	private static Menu menuGuardarCambios = new Menu("El catalogo ha sido modificado. ¿Desea guardar los cambios?",
			new String[] { "Si", "No" });
	private static Catalogo catalogo = new Catalogo();

	private static File file;
	private static boolean modificado;
	private static boolean prestado;
	private static Serie serie;

	public static void main(String[] args) {
		int opcion;
		do {
			opcion = menuPrincipal.gestionar();
			realizarOpcionMenuPrincipal(opcion);
		} while (opcion != menuPrincipal.SALIR);
	}

	/**
	 * Realiza la opción del menú.
	 * 
	 * @param opcion
	 *            la opción a realizar.
	 */
	private static void realizarOpcionMenuPrincipal(int opcion) {
		if (opcion != menuPrincipal.SALIR && opcion != 1 && catalogo.vacio() && opcion != 7) {
			System.err.println("\n\tCatálogo vacío.");
			return;
		}
		switch (opcion) {
		case 1:
			annadir();
			break;
		case 2:
			eliminar();
			break;
		case 3:
			buscar();
			break;
		case 4:
			listar();
			break;
		case 5:
			contar();
			break;
		case 6:
			gestionarSerie();
			break;
		case 7:
			gestionarFicheros();
			break;
		default:
			System.out.println("\n\tHasta pronto.");
			return;
		}
	}

	private static void gestionarSerie() {
		int opcion;
		do {
			opcion = menuSerie.gestionar();
			realizarOpcionMenuSeries(opcion);
		} while (opcion != menuSerie.SALIR);

	}

	private static void realizarOpcionMenuSeries(int opcion) {
		switch (opcion) {
		case 1:
			annadirTemporada();
			break;
		case 2:
			// eliminarTemporada();
			break;
		case 3:
			// buscarTemporada();
			break;
		case 4:
			break;
		default:
			return;
		}
	}

	private static void annadirTemporada() {
		try {
			serie.annadirTemporada(pedirFecha("Fecha de inicio de la serie"),
					pedirFecha("Fecha de finalización de la serie"));
			setModificado(true);
			System.out.println("\n\tTemporada añadida con éxito.");
		} catch (Exception e) {
			System.err.println(e.getMessage() + "\n\tNo se ha podido añadir la temporada en la serie");
		}
	}

	/**
	 * Método que permite añadir elementos al catálogo.
	 */
	private static void annadir() {
		int opcion;
		do {
			opcion = menuAltas.gestionar();
			realizarOpcionMenuAltas(opcion);
		} while (opcion != menuAltas.SALIR);
	}

	private static void realizarOpcionMenuAltas(int opcion) {
		switch (opcion) {
		case 1:
			annadirPelicula();
			break;
		case 2:
			annadirVideojuego();
			break;
		case 3:
			annadirSerie();
			break;
		case 4:
			try {
				cargarPredefinidos();
				System.out.println("\n\tContenido añadido con éxito");
			} catch (CalificacionNoValidaException | PeliculaYaExisteException | VideojuegoYaExisteException
					| TituloNoValidoException | SerieYaExisteException | TemporadaVaciaException
					| UbicacionNoValidaException | FechaNoValidaException e) {
				System.err.println(e.getMessage());
			}
			break;
		default:
			return;
		}
	}

	private static void annadirPelicula() {
		try {
			catalogo.annadirPelicula(Teclado.leerCadena("\nTítulo de la película"),
					Teclado.leerCadena("Título original de la película"), pedirUbicacion("Ubicación de la película"),
					Teclado.leerCadena("Estado de la película "), pedirFecha("Fecha de alta en el sistema"),
					Teclado.leerDecimal("Calificación"), Teclado.leerCadena("Director de la película"),
					pedirGenero("Género de la película"), pedirIdioma("Idioma de la película"),
					pedirFecha("Año de estreno"), pedirSoporte("Soporte de la película"),
					Teclado.leerEntero("Nº de veces vista"), Teclado.leerEntero("Duración en minutos"),
					Teclado.leerEntero("Nº de premios"));
			setModificado(true);
			System.out.println("\n\tPelícula añadida con éxito.");
		} catch (Exception e) {
			System.err.println(e.getMessage() + "\n\tNo se ha podido añadir la película en el catálogo");
		}
	}

	private static void annadirVideojuego() {
		try {
			catalogo.annadirVideojuego(Teclado.leerCadena("Título del videojuego"),
					Teclado.leerCadena("Título original del videojuego"), pedirUbicacion("Ubicación del videojuego"),
					Teclado.leerCadena("Estado de juego del videojuego "), pedirFecha("Fecha de alta en el sistema"),
					Teclado.leerDecimal("Calificación"), Teclado.leerCadena("Compañía del videojuego"),
					pedirFormato("Formato del videojuego"), Teclado.leerCadena("Plataforma del videojuego"),
					Teclado.leerCadena("Estilo del videojuego"), Teclado.leerEntero("Nº de veces jugado"),
					Teclado.leerEntero("Horas de juego"),  prestado, Teclado.leerCadena("Prestado a"),
					pedirFecha("Fecha de préstamo"),pedirFecha("Fecha de devolución"));
			setModificado(true);
			System.out.println("\n\tVideojuego añadido con éxito.");
		} catch (Exception e) {
			System.err.println(e.getMessage() + "\n\tNo se ha podido añadir el videojuego en el catálogo");
		}
	}

	private static void annadirSerie() {
		try {
			catalogo.annadirSerie(Teclado.leerCadena("Título de la serie"),
					Teclado.leerCadena("Título original de la serie"), pedirUbicacion("Ubicación de la serie"),
					Teclado.leerCadena("Estado de la serie "), pedirFecha("Fecha de alta en el sistema"),
					Teclado.leerDecimal("Calificación"), Teclado.leerCadena("Medio de la serie"),
					Teclado.leerCadena("Sinopsis de la serie"), Teclado.leerEntero("Temporadas"),
					pedirGenero("Género de la serie"), pedirIdioma("Idioma de la serie"),
					Teclado.leerEntero("Nº de visualizaciones de la serie"));
			setModificado(true);
			System.out.println("\n\tSerie añadida con éxito.");
		} catch (Exception e) {
			System.err.println(e.getMessage() + "\n\tNo se ha podido añadir la serie en el catálogo");
		}
	}

	/**
	 * Método que permite eliminar elementos del catálogo.
	 */
	private static void eliminar() {
		int opcion;
		do {
			opcion = menuBajas.gestionar();
			realizarOpcionMenuBajas(opcion);
		} while (opcion != menuBajas.SALIR);
	}

	private static void realizarOpcionMenuBajas(int opcion) {
		if (opcion != menuBajas.SALIR && catalogo.vacio()) {
			System.err.println("\n\tCatálogo vacío.");
			return;
		}
		switch (opcion) {
		case 1:
			try {
				System.out.println("Contenido de baja en el catálogo:"
						+ catalogo.eliminar(pedirTitulo()));
				 System.out.println(catalogo);
			} catch (ContenidoNoExisteException e) {
				System.err.println(e.getMessage() + " No se ha podido dar de baja el contenido.");
			}
			break;
		case 2:
			try {
				System.out.println("Contenido de baja en el catálogo:" + catalogo.eliminarId(pedirId()));
			} catch (ContenidoNoExisteException e) {
				System.err.println(e.getMessage());
			}
			break;
		default:
			return;
		}
	}

	/**
	 * @return
	 */
	private static int pedirId() {
		return Teclado.leerEntero("\n\tIntroduzca el id del contenido a borrar:");
	}

	/**
	 * @return
	 */
	private static String pedirTitulo() {
		return Teclado.leerCadena("Introduce el título del contenido: ");
	}

	/**
	 * Método que permite añadir elementos al catálogo.
	 */
	private static void listar() {
		int opcion;
		do {
			opcion = menuListar.gestionar();
			realizarOpcionMenuListar(opcion);
		} while (opcion != menuListar.SALIR);
	}

	/**
	 * Gestiona las opciones del menu listar
	 * 
	 * @param opcion
	 */
	private static void realizarOpcionMenuListar(int opcion) {
		switch (opcion) {
		case 1:
			// Listar todo
			System.out.println(catalogo.toString());
			break;
		case 2:
			// Listar películas
			System.out.println(catalogo.listarPeliculas());
			break;
		case 3:
			// Listar videojuegos
			System.out.println(catalogo.listarVideojuegos());
			break;
		case 4:
			// Listar series
			System.out.println(catalogo.listarSeries());
			break;
		default:
			return;
		}
	}

	/**
	 * Método que permite buscar elementos del catálogo.
	 */
	private static void buscar() {
		int opcion;
		do {
			opcion = menuBuscar.gestionar();
			realizarOpcionMenuBuscar(opcion);
		} while (opcion != menuBuscar.SALIR);
	}

	private static void realizarOpcionMenuBuscar(int opcion) {
		switch (opcion) {
		case 1:
			// Buscar por titulo
			try {
				System.out.println(catalogo.buscarPorTitulo(Teclado.leerCadena("Titulo del contenido")).toString());
			} catch (ContenidoNoExisteException e) {
				System.err.println(e.getMessage());
			}
			break;
		case 2:
			// Buscar por id
			try {
				System.out.println(catalogo.buscarPorID(Teclado.leerEntero("Itroduzca el ID:")));
			} catch (ContenidoNoExisteException e) {
				System.err.println(e.getMessage());
			}
			break;
		default:
			return;
		}

	}

	private static void cargarPredefinidos() throws CalificacionNoValidaException, PeliculaYaExisteException,
			VideojuegoYaExisteException, TituloNoValidoException, SerieYaExisteException, TemporadaVaciaException,
			UbicacionNoValidaException, FechaNoValidaException {
		catalogo.annadirPelicula("La guerra de las galaxias: Una nueva esperanza", "Star Wars: A New Hope",
				Ubicacion.DELL, "Vista", LocalDate.of(2018, 05, 14), 5.0, "George Lucas", Genero.CIENCIA_FICCION,
				Idioma.DUAL, LocalDate.of(1977, 05, 25), Soporte.DIGITAL, 999, 124, 2);
		catalogo.annadirPelicula("La guerra de las galaxias: El imperio contraataca",
				"Star Wars: The Empire Strikes Back", Ubicacion.DELL, "Vista", LocalDate.of(2018, 05, 14), 5.0,
				"Irvin Kershner", Genero.CIENCIA_FICCION, Idioma.DUAL, LocalDate.of(1980, 06, 20), Soporte.DIGITAL, 999,
				127, 2);
		catalogo.annadirPelicula("La guerra de las galaxias: El retorno del jedi", "Star Wars: The Return of the Jedi",
				Ubicacion.DELL, "Vista", LocalDate.of(2018, 05, 14), 5.0, "Richard Marquand", Genero.CIENCIA_FICCION,
				Idioma.DUAL, LocalDate.of(1983, 05, 25), Soporte.DIGITAL, 999, 135, 2);

		catalogo.annadirVideojuego("Super Mario Bros 3", "Super Mario Bros 3", Ubicacion.RASP, "jugado",
				LocalDate.of(2018, 05, 14), 5.0, "Nintendo", Formato.CARTUCHO, "N.E.S", "Plataformas scroll lateral",
				999, 999, false, null, null,null);

		catalogo.annadirSerie("Juego de tronos", "Game of Thrones", Ubicacion.NUBE, "vista", LocalDate.of(2018, 05, 14),
				5.0, "Netflix", "La guerra en Poniente ha empezado", 8, Genero.ACCION, Idioma.DUAL, 2);

	}

	private static LocalDate pedirFecha(String mensaje) {
		LocalDate fecha;
		try {
			int anno = Teclado.leerEntero("Año:");
			int mes = Teclado.leerEntero("Mes:");
			int dia = Teclado.leerEntero("Dia:");

			fecha = LocalDate.of(anno, mes, dia);
			return fecha;
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	private static Ubicacion pedirUbicacion(String mensaje) {
		int opcion = menuUbicaciones.gestionar();
		Ubicacion[] ubicacion = Ubicacion.values();
		if (opcion == ubicacion.length + 1)
			return null;
		return ubicacion[opcion - 1];
	}

	private static Genero pedirGenero(String mensaje) {
		int opcion = menuGeneros.gestionar();
		Genero[] genero = Genero.values();
		if (opcion == genero.length + 1)
			return null;
		return genero[opcion - 1];
	}

	private static Idioma pedirIdioma(String mensaje) {
		int opcion = menuIdiomas.gestionar();
		Idioma[] idioma = Idioma.values();
		if (opcion == idioma.length + 1)
			return null;
		return idioma[opcion - 1];
	}

	private static Soporte pedirSoporte(String mensaje) {
		int opcion = menuSoportes.gestionar();
		Soporte[] soporte = Soporte.values();
		if (opcion == soporte.length + 1)
			return null;
		return soporte[opcion - 1];
	}

	private static Formato pedirFormato(String mensaje) {
		int opcion = menuFormatos.gestionar();
		Formato[] formato = Formato.values();
		if (opcion == formato.length + 1)
			return null;
		return formato[opcion - 1];
	}

	/**
	 * Método que permite contar el número de elementos que contiene el catálogo
	 */
	private static void contar() {
		System.out.println("\n\tNúmero de elementos en el catalogo: " + catalogo.size());

	}

	/**
	 * Método para realizar la gestión de los ficheros
	 */
	private static void gestionarFicheros() {
		int opcion;
		do {
			opcion = menuFicheros.gestionar();
			realizarOpcionMenuFicheros(opcion);
		} while (opcion != menuFicheros.SALIR);
	}

	/**
	 * Método que realiza las opciones del menú de ficheros.
	 * 
	 * @param opcion
	 *            la opción a realizar.
	 */
	private static void realizarOpcionMenuFicheros(int opcion) {
		switch (opcion) {
		case 1:
			nuevo();
			break;
		case 2:
			abrir();
			break;
		case 3:
			guardar();
			break;
		case 4:
			guardarComo();
			break;
		default:
			return;
		}
	}

	private static void nuevo() {
		comprobarCambios();
		inicializar();
		setFile(null);
	}

	private static void inicializar() {
		setModificado(false);
		catalogo = new Catalogo();
	}

	/**
	 * Método que permite abrir un fichero.
	 */
	private static void abrir() {
		comprobarCambios();
		try {
			File file = new File(Teclado.leerCadena("\n\tIntroduce el nombre del fichero: "));
			catalogo = Fichero.leer(file);
			setFile(file);
		} catch (ClassNotFoundException e) {
			System.out.println("\n\tFichero con información distinta a la esperada.");
		} catch (IOException e) {
			System.out.println("\n\tEl sistema no puede abrir el fichero.");
		}
	}

	/**
	 * Método que permite guardar un fichero.
	 */
	private static void guardar() {
		if (getFile() == null)
			guardarComo();
		else {
			try {
				Fichero.escribir(getFile(), catalogo);
				setModificado(false);
				System.out.println("\n\tFichero guardado con éxito.");
			} catch (IOException e) {
				System.out.println("\n\tEl sistema no puede guardar el fichero.");
			}
		}
	}

	/**
	 * Método que permite guardar un fichero pidiendo el nombre del mismo. Si éste
	 * existe, pide confirmación.
	 */
	private static void guardarComo() {
		try {
			File file = new File(Teclado.leerCadena("\n\tIntroduce el nombre del fichero: "));
			if (Fichero.isExists(file)) {
				deseaReemplazar();
			}
			Fichero.escribir(file, catalogo);
			setModificado(false);
			setFile(file);
		} catch (IOException e) {
			System.out.println("\n\tEl sistema no puede guardar el fichero.");
		}
	}

	/**
	 * Método que consulta si se desea reemplazar o no un fichero.
	 */
	private static void deseaReemplazar() {
		char c = Teclado.leerCaracter("\n\tEl fichero ya existe. ¿Desea reemplazarlo? (s/n)");
		switch (c) {
		case 'n':
		case 'N':
			return;
		}
	}

	/**
	 * Método que comprueba si se han realizado cambios y pide confirmación para su
	 * guardado.
	 * 
	 * @return true si se desean guardar cambios, false en caso contrario.
	 */
	private static boolean comprobarCambios() {
		if (isModificado()) {
			switch (menuGuardarCambios.gestionar()) {
			case 1:
				guardar();
				return true;
			}
		}
		return false;
	}

	/**
	 * Método que permite obtener un fichero.
	 * 
	 * @return file el fichero a obtener.
	 */
	private static File getFile() {
		return file;
	}

	/**
	 * Método que permite establecer un fichero.
	 * 
	 * @param file
	 *            fichero a establecer.
	 */
	private static void setFile(File file) {
		TestGestor.file = file;
	}

	/**
	 * Método que permite comprobar si se ha modificado el catálogo.
	 * 
	 * @return modificado comprobación de la modificación.
	 */
	private static boolean isModificado() {
		return modificado;
	}

	/**
	 * Método que permite establecer la modificación del catálogo.
	 * 
	 * @param modificado
	 *            comprobación de la modificación.
	 */
	private static void setModificado(boolean modificado) {
		TestGestor.modificado = modificado;
	}
}