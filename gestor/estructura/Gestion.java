package gestor.estructura;

import java.io.File;
import java.io.Serializable;
//import java.time.LocalDate;

public class Gestion implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Campo para el arrayList de Catalogo.
	 */
	public static Catalogo catalogo = new Catalogo();	
	
//	static{
//		try {
//			catalogo.annadirPelicula("La guerra de las galaxias: Una nueva esperanza", "Star Wars: A New Hope",
//					Ubicacion.DELL, "Vista", LocalDate.of(2018, 05, 14), 8.0, "George Lucas", Genero.CIENCIA_FICCION,
//						Idioma.DUAL, LocalDate.of(1977, 05, 25), Soporte.DIGITAL, 999, 124, 2);
//				catalogo.annadirPelicula("La guerra de las galaxias: El imperio contraataca",
//					"Star Wars: The Empire Strikes Back", Ubicacion.DELL, "Vista", LocalDate.of(2018, 05, 14), 9.0,
//					"Irvin Kershner", Genero.CIENCIA_FICCION, Idioma.DUAL, LocalDate.of(1980, 06, 20), Soporte.DIGITAL, 999,
//						127, 2);
//				catalogo.annadirPelicula("La guerra de las galaxias: El retorno del jedi", "Star Wars: The Return of the Jedi",
//					Ubicacion.DELL, "Vista", LocalDate.of(2018, 05, 14), 7.0, "Richard Marquand", Genero.CIENCIA_FICCION,
//						Idioma.DUAL, LocalDate.of(1983, 05, 25), Soporte.DIGITAL, 999, 135, 2);
//				catalogo.annadirPelicula("Bailando con lobos", "Dances with Wolves",
//						Ubicacion.SALON, "Vista", LocalDate.of(2018, 05, 27), 9.0, "Kevin Costner", Genero.AVENTURAS,
//							Idioma.DUAL, LocalDate.of(1990, 10, 19), Soporte.FISICO, 999, 236, 7);
//				catalogo.annadirVideojuego("Super Mario Bros 3", "Super Mario Bros 3", Ubicacion.RASP, "jugado",
//						LocalDate.of(2018, 05, 14), 5.0, "Nintendo", Formato.CARTUCHO, "N.E.S", "Plataformas scroll lateral", 999,
//						999, false, null, null,null);
//				catalogo.annadirVideojuego("Super Mario Bros 2", "Super Mario Bros 2", Ubicacion.RASP, "jugado",
//						LocalDate.of(2018, 05, 14), 5.0, "Nintendo", Formato.CARTUCHO, "N.E.S", "Plataformas scroll lateral", 999,
//						999, true, "Guillermo Boquizo Sánchez", LocalDate.of(2018, 05, 14),LocalDate.of(2018, 12, 27));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	/**
	 * Fichero
	 */
	private static File file = new File("Sin titulo");
	
	/**
	 * Bandera que me indica si el catalogo ha sido modificado
	 */
	private static boolean modificado;

	
	public static Catalogo getCatalogo() {
		return catalogo;
	}

	/**
	 * Modifica el catalogo
	 * 
	 * @param catalogo Representa el nuevo catalogo de contenidos
	 */
	public static void setCatalogo(Catalogo catalogo) {
		Gestion.catalogo = catalogo;
	}
	
	/**
	 * Permite establecer una representación del fichero.
	 * @return file el fichero a establecer.
	 */
	public static File getFile() {
		return file;
	}
	
	/**
	 * Permite establecer una representación del fichero.
	 * @param file el fichero a establecer.
	 */
	public static void setFile(File file) {
		Gestion.file = file;
	}
	
	/**
	 * Permite establecer una modificación en el catalogo.
	 * @param modificado la modificación en el catalogo.
	 */
	public static void setModificado(boolean modificado) {
		Gestion.modificado = modificado;
	}

	/**
	 * Permite comprobar si el concesionario ha sido modificado.
	 * @return true o false, en función de si el catalogo ha sido o no modificado.
	 */
	public static boolean isModificado() {
		return modificado;
	}
}