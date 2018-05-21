package gestor.estructura;

/**
 * Enumeración que define las ubicaciones de los contenidos.
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public enum Ubicacion {
	I3, 
	I7, 
	DELL,
	ASUS,
	RASP,
	SALON,
	DORMITORIO,
	EXTERNO1,
	EXTERNO2,
	EXTERNO3,
	NUBE;
	
	/**
	 * Genera las opciones para un menú de ubicacion.
	 * @return opcionesMenu las opciones del menú de ubicacion.
	 */
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[values().length];
		int i = 0;
		for (Ubicacion ubicacion : Ubicacion.values()) {
			opcionesMenu[i++] = ubicacion.name();
		}
		return opcionesMenu;
	}
}