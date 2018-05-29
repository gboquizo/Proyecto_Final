package gestor.estructura;

/**
 * 
 * Enumeración que define los formatos de los videojuegos.
 * 
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public enum Formato {
	
	CARTUCHO, CD, DVD, DIGITAL;
	
	/**
	 * Genera las opciones para un menú de formato.
	 * @return opcionesMenu las opciones del menú de formato.
	 */
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[values().length];
		int i = 0;
		for (Formato formato : Formato.values()) {
			opcionesMenu[i++] = formato.name();
		}
		return opcionesMenu;
	}
}