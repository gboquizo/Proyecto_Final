package gestor.estructura;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import gestor.estructura.Catalogo;

/**
 * 
 * Clase que contiene métodos necesarios para operar con ficheros.
 * 
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class Fichero implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * Permite la lectura de un fichero y cargar al programa su contenido, de
	 * tipo object
	 * 
	 * @param archivo el archivo a leer
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @return Gestion.catalogo el catalogo leído.
	 */
	public static Catalogo leer(File archivo) throws IOException, ClassNotFoundException {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
			Gestion.catalogo = (Catalogo) in.readObject();
			return Gestion.catalogo;
		}
	}

	/**
	 * 
	 * Método que guarda un objeto pidiendo el nombre de archivo a crear.
	 * 
	 * @param objeto objeto a guardar.
	 * @param nombre del fichero.
	 * @throws IOException Excepción lanzada al finalizar el flujo
	 */
	public static void escribir(File nombre, Catalogo catalogo) throws IOException {
		nombre = comprobarExtension(nombre);
		try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nombre)))) {
			out.writeObject(catalogo);
		}
	}

	/**
	 * Comprueba si el fichero existe.
	 * 
	 * @param file Representa el fichero a comprobar.
	 * @return true si el fichero existe, false en otro caso.
	 */
	public static boolean isExists(File file) {
		file = comprobarExtension(file);
		return file.exists();
	}

	/**
	 * Comprueba si la extensión del fichero es válida o no.
	 * 
	 * @param file Representa el fichero a comprobar.
	 * @return file Fichero con la extensión válida.
	 */
	static File comprobarExtension(File file) {
		String path = file.getPath();
		if (!path.endsWith(".gbs"))
			return new File(path + ".gbs");
		return file;
	}
}