package gestor.estructura;

/**
 * Enumeración que define los géneros de las películas y series.
 * 
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public enum Genero {
	
	THRILLERS,
	ACCION,
	AVENTURAS,
	TERROR,
	SUSPENSE,
	DRAMA,
	COMEDIA,
	FANTASTICO,
	BELICO,
	ANIMACION,
	INFANTIL,
	MUSICAL,
	CIENCIA_FICCION,
	OTROS;
	
	/**
	 * Genera las opciones para un menú de género.
	 * @return opcionesMenu las opciones del menú de género.
	 */
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[values().length];
		int i = 0;
		for (Genero genero : Genero.values()) {
			opcionesMenu[i++] = genero.name();
		}
		return opcionesMenu;
	}
}