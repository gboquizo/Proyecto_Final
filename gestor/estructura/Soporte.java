package gestor.estructura;

/**
 * 
 * Enumeración que define el soporte en el que se encuentran las películas.
 * 
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public enum Soporte {
	FISICO, DIGITAL;
	
	/**
	 * Genera las opciones para un menú de ubicacion.
	 * @return opcionesMenu las opciones del menú de ubicacion.
	 */
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[values().length];
		int i = 0;
		for (Soporte soporte : Soporte.values()) {
			opcionesMenu[i++] = soporte.name();
		}
		return opcionesMenu;
	}
}