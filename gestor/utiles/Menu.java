package gestor.utiles;
/**
*Crea la clase Menu.<p> 
*M\u00e9telo en el paquete utiles.<p>
*Implementa al menos los siguientes metodos y atributos:
*<ul>
*	<li>titulo</li>
*	<li>opciones</li>
*	<li>numOpciones</li>
*	<li>gestionar()</li>
*	<li>recogerOpcion()</li>
*</ul>
*
*@author Guillermo Boquizo S\u00e1nchez.
*@version 1.0
*/
public class Menu {

	/**
	*Constante que define la opci\u00f3n de salida del men\u00fa, coincide con el n\u00famero de opciones.
	*/
	public int SALIR;

	/**
	*Constante que define la opci\u00f3n de entrada del men\u00fa.
	*/	
	private int PRIMERAOPCION;

	/**
	*T\u00edtulo del men\u00fa.
	*/
	private String titulo;
	
	/**
	*Opciones del men\u00fa.
	*/
	private String opciones[];

	/**
	*Crea un men\u00fa para comunicarse con el usuario a trav\u00e9s del teclado y de la consola.
	* 
	*@param titulo: t\u00edtulo del men\u00fa.
	*@param opciones: opciones del men\u00fa.
	*/
	public Menu(String titulo,String[] opciones){
		setTitulo(titulo);
		setOpciones(opciones);
		setSALIR(opciones.length + 1 );
	}
	
	public Menu(String titulo, Object[] array) {
		this.titulo = titulo;
		this.opciones = getOpciones(array);
		setSALIR(opciones.length + 1);
	}
	
	public static String[] getOpciones(Object[] array) {
		String[] vector = new String[array.length];
		for (int i = 0; i < array.length; i++) {
			vector[i] = array[i].toString();
		}
		
		return vector;
	}

	/**
	*Establece el t\u00edtulo del men\u00fa.
	*@param titulo: cadena que contiene el t\u00edtulo del men\u00fa.
	*/	
	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	String getTitulo() {
		return titulo;
	}	

	/**
	*Establece las opciones que se almacenar\u00e1n en el vector opciones[].
	*
	*/
	private void setOpciones(String[] opciones) {
		this.opciones = new String[opciones.length + 1];
		int i = 0;
		for (String string : opciones) {
			this.opciones[i++] = string;
		}
		this.opciones[i] = "Salir";
	}


	/**
	 * asignara el valor que introduzcamos por el parametro al campo de la clase
	 * @param opcionSalida,contiene la longitud del vector con todas las opciones
	 * */
	private void setSALIR(int SALIR){
		this.SALIR = SALIR;
	}
	
	/**
	 * @return la opcion salida que sera la longitud del vector con todas las opciones 
	 * */
	public int getSALIR(){
		return SALIR;
	}

	/**
	* Gestiona el men\u00fa. Consiste en mostrar las opciones y recoger la opci\u00f3n
	* seleccionada por el usuario.
	* @return opci\u00f3n v\u00e1lida del men\u00fa.
	*/
	public int gestionar() {
		mostrar();
		return recogerOpcion();
	}

	/**
	*Muestra las opciones del men\u00fa.
	*/
	private void mostrar() {
		int i = getPrimeraOpcion();
		System.out.println("\n\t**" + getTitulo() + "**\n" );
		for (String elemento : opciones)
			System.out.println("\t(" + (i++) + ") " + elemento);
	}

	/**
	*Recoge la opci\u00f3n v\u00e1lida del men\u00fa.
	* 
	*@return opci\u00f3n v\u00e1lida..
	*/
	private int recogerOpcion() {
		int opcion;
		do {
			opcion = Teclado.leerEntero();
			if(!esValida(opcion))
				System.out.println("\nError, no existe esa opci\u00f3n, introduzca una opci\u00f3n v\u00e1lida:" + "\n");
			if(opcion == SALIR)
				System.out.println("\n\tSaliendo de " + getTitulo());
		} while (!esValida(opcion));
		return opcion;
	}

	/**
	*Establece la primera opci\u00f3n del men\u00fa.
	*@return el valor dado a la primera opci\u00f3n.
	*/
	private int getPrimeraOpcion(){
		return 1;
	}

	/**
	*Devuelve true si la opci\u00f3n es v\u00e1lida y false en caso contrario.
	*@return true o false en funci\u00f3n de la opci\u00f3n.
	*/
	private boolean esValida(int opcion){
		if(opcion < PRIMERAOPCION || opcion > SALIR)
			return false;
		return true;	
	}
}