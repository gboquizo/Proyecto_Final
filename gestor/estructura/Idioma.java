package gestor.estructura;

/**
 * 
 * Enumeración que define el idioma en el que se encuentran las películas y
 * series.
 * 
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public enum Idioma {
	ESP, DUAL, VOSE;
	
	/**
	 * Genera las opciones para un menú de ubicacion.
	 * @return opcionesMenu las opciones del menú de ubicacion.
	 */
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[values().length];
		int i = 0;
		for (Idioma idioma : Idioma.values()) {
			opcionesMenu[i++] = idioma.name();
		}
		return opcionesMenu;
	}
}