package gestor.utiles;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Permite lectura desde teclado
 */
public class Teclado {

	/**
	 * Lee un carácter del teclado
	 * 
	 * @return carácter introducido por el usuario
	 */
	public static char leerCaracter() {
		char caracter = 0;
		boolean valida = false;
		do {
			try {
				caracter = leerCadena().charAt(0);
				
				valida = true;
			} catch (Exception e) {
				System.err.println("\nError, esto no es un carácter. Introduzca un carácter");
			} 
		} while (!valida);
		return caracter;
	}

	/**
	 * Lee un carácter del teclado
	 * 
	 * @param msj
	 *            mensaje mostrado al usuario
	 * @return carácter introducido por el usuario
	 */
	public static char leerCaracter(String msj) {
		System.out.println(msj);
		return leerCaracter();
	}

	/**
	 * Lee una cadena del teclado
	 * 
	 * @param msj
	 *            mensaje mostrado al usuario
	 * @return cadena introducida por el usuario
	 */
	public static String leerCadena(String msj) {
		System.out.println(msj);
		return leerCadena();
	}

	/**
	 * Lee una cadena del teclado
	 * 
	 * @return cadena introducida por el usuario
	 */

	public static String leerCadena() {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(
				System.in));
		String cadena = "";
		boolean valida = false;
		do {
			try {
				cadena = bReader.readLine(); // Lee una línea de texto (hasta intro)
				
				valida = true;
			} catch (Exception e) {
				System.err.println("\nError, esto no es una cadena. Introduzca una cadena");
			} 
		} while (!valida);
		return cadena;
	}

	/**
	 * Lee un entero del teclado
	 * 
	 * 
	 * @return entero introducido por el usuario
	 */
	public static int leerEntero() {
		int x = 0;
		boolean valida = false;
		
		do {
			try {
				x = Integer.parseInt(leerCadena().trim()); // Quita los espacios del
															// String y convierte a
					valida = true;									// int
			} catch (Exception e) {
				System.err.println("\nError, esto no es un entero. Introduzca un entero");
			} 
		} while (!valida);
		return x;
	}

	/**
	 * Lee una entero del teclado
	 * 
	 * @param msj
	 *            mensaje mostrado al usuario
	 * @return entero introducida por el usuario
	 */
	public static int leerEntero(String msj) {
		System.out.println(msj);
		return leerEntero();
	}

	/**
	 * Lee un decimal del teclado
	 * 
	 * @return decimal introducido por el usuario
	 */
	public static double leerDecimal() {
		double x = 0;
		boolean valida = false;
		do {
			try {
				x = Double.parseDouble(leerCadena().trim()); // Quita los espacios
																// del String y
				valida = true;												// convierte a
																// double
			} catch (Exception e) {
				System.err.println("\nError, esto no es un decimal. Introduzca un decimal");
			} 
		} while (!valida);
		return x;
	}

	/**
	 * Lee una decimal del teclado
	 * 
	 * @param msj
	 *            mensaje mostrado al usuario
	 * @return decimal introducida por el usuario
	 */
	public static double leerDecimal(String msj) {
		System.out.println(msj);
		return leerDecimal();
	}

	/**
    *
    * Verifica si el usuario quiere o no continuar con el proceso dado
    * @return true, en el caso de que introduzca car\u00e1cter v\u00e1lido, false para el resto de casos
    */
    public static boolean deseaContinuar() {
        char caracter;
        do {
            caracter = Teclado.leerCaracter("\n\u00BFDesea continuar? S/N\n");
            if (caracter != 'S' && caracter != 's' && caracter != 'N' && caracter != 'n')
                System.out.println("\nError, no ha introducido un caracter v\u00e1lido.");
        } while(caracter != 'S' && caracter != 's' && caracter != 'N' && caracter != 'n');

        if (caracter == 'S' || caracter == 's')
        	return true;
            return false;     
	}

	public static boolean deseaContinuar(String mensaje) {
		char caracter;
        do {
            caracter = Teclado.leerCaracter(mensaje);
            if (caracter != 'S' && caracter != 's' && caracter != 'N' && caracter != 'n')
                System.out.println("\nError, no ha introducido un caracter v\u00e1lido.");
        } while(caracter != 'S' && caracter != 's' && caracter != 'N' && caracter != 'n');
        
        if (caracter == 'S' || caracter == 's')
        	return true;  
            return false;     
	}
}