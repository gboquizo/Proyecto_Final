Trabajo Final. Anteproyecto.

Gestor de contenido multimedia en Java.

1.-Objetivos generales.
El presente proyecto tiene como finalidad gestionar diferentes tipos de colecciones personales de contenido multimedia en Java, estos contenidos pueden ser videojuegos, películas o series.
Cada catálogo puede ser gestionado de manera que se permita al usuario añadir, quitar, modificar, mostrar o buscar dichos contenidos, en función de cada tipo.
Se contempla, además, que las colecciones de contenidos del tipo videojuego puedan ser prestadas, se recoja la fecha de préstamo y la persona a la que se ha realizado el mismo, de tal modo que se pueda listar aquellos videojuegos en situación de préstamo.

2.-Estructura de datos.
La estructura de datos para el presente proyecto es una estructura de contenidos de tipo arrayList, que pueden ser de diversa tipología (videojuegos, películas, series…).
La finalidad de la estructura de datos es permitir la realización de varias acciones:
•	Añadir un contenido al catálogo: videojuego, película, serie…
•	Eliminar un contenido del catálogo: por índice en el mismo o identificador.
•	Mostrar un listado de videojuegos, de películas, de series, etc…
•	Modificar un contenido del catálogo.
•	Buscar un contenido concreto por nombre (título) o identificador.

Como se ha indicado previamente, se desea permitir el préstamo de ejemplares de videojuegos, lo que precisará de opciones para prestar y mostrar aquellos elementos prestados.

Por otra parte, las series tendrán un tratamiento diferenciado respecto de los objetos de tipo Videojuego y Película, al tratarse de objetos que presentan una composición, esto es, una Serie está compuesta de objetos de la clase Temporada que a su vez contiene objetos de la clase Capitulo. La estructura de datos propia de Series será la de un arrayList de Temporadas en Series, y otro arrayList de Capítulos en Temporada. 

3. Herencia.
El gestor de contenidos multimedia presentará herencia, puesto que todo contenido puede ser o un videojuego, o una película, o una serie.
Además, las series estarán compuestas de temporadas, que a su vez lo estarán de capítulos.

Clase Contenido:
Es la clase padre, presenta los siguientes campos:
•	Un id o identificador único.
•	Título.
•	Título original.
•	Fecha de alta en el sistema.
•	Ubicación física en el domicilio.
•	Estado
•	Calificación

Clase Videojuego:
Clase hija, presenta los siguientes campos:
•	Compañía.
•	Formato.
•	Plataforma.
•	Prestado.
•	Veces jugado totales.
•	Horas totales de juego.
•	Estilo de videojuego.
•	Prestado a (indica el nombre de la persona que lo tiene en préstamo).
•	Fecha préstamo del videojuego.

Clase Película:
Clase hija, presenta los siguientes campos:
•	Director.
•	Género.
•	Idioma.
•	Año estreno.
•	Formato.
•	Nº veces visto
•	Duración
•	Premios

Clase Serie:
Clase hija, presenta los siguientes campos:
•	Medio.
•	Sinopsis.
•	Temporadas
•	Género
•	Idioma
•	Nº visualizaciones.

Clase Temporada:
Clase hija de Serie, presenta los siguientes campos:
•	Capítulos.
•	Fecha de inicio.
•	Fecha de finalización.

Clase Capitulo:
Clase hija de Temporada, presenta los siguientes campos:
•	Fecha de emisión.
•	Reseña
•	Nombre del capítulo.
•	Nombre original del capítulo.
•	Duración del capítulo.

Clase Catálogo:
Clase envoltorio de Contenidos, contiene métodos para:
•	Añadir.
•	Eliminar
•	Modificar
•	Buscar.
•	Listar

4. Enumeraciones.
Para el presente proyecto, se contemplan las siguientes enumeraciones:
En la clase Contenido:
Ubicación:
 
I3
I7
DELL
ASUS
RASP
SALON
DORMITORIO 1
EXTERNO 1
EXTERNO 2
EXTERNO 3
NUBE
 
En la clase Videojuego:
Formato:
CARTUCHO
CD
DVD
DIGITAL

En la clase Película:
Formato:
FISICO
DIGITAL.

En las clases Pelicula y Serie:
Idioma:
ESPAÑOL
DUAL
VOSE

Género:
THRILLERS
ACCION
AVENTURAS
TERROR
SUSPENSE
DRAMA
COMEDIA
FANTASTICO
BELICO
INFANTIL
ANIMACION
MUSICAL
CIENCIA-FICCION
OTROS

5. Interfaces.
Se utilizarán las interfaces Serializable y Comparable de manera obligatoria.
Se plantea el uso de una interfaz calificable, que permita, a partir de algunos campos contenidos en las clases (nº de veces jugado, nº de reproducciones, duración, etc…dotar de una valoración personal e interna para todos los contenidos del catálogo.)

6.UML.
El UML del proyecto es el que se presenta, modificable desde Gliffy.

7. Flujos de datos.
Nuestro catálogo se podrá guardar y recuperar, por lo que se deben contemplar opciones como:
1.	Nuevo
2.	Abrir
3.	Guardar
4.	Guardar como…

8. Manejo de ficheros.
El catálogo multimedia debe poder ser guardado como un objeto Serializable, que tendrá la extensión .gbs

9. Excepciones
Se contempla la creación de aquellas excepciones que se precisen, como, por ejemplo:
•	ContenidoNoExisteException
•	TituloNoValidoException
•	FechaNoValidaException
•	ContenidoYaExisteException
•	NombreCapituloNoValidoException
...y todas aquellas excepciones que se precisen al desarrollar el proyecto.

10. Expresiones regulares.
Se plantea la existencia de expresiones regulares para controlar el título de los contenidos y el nombre de los capítulos, que compruebe que el campo al menos presenta 2 letras, no se encuentra vacío y no presenta espacios al principio ni al final de los mismos.
Del mismo modo, para el formato de las fechas, como la fecha de alta en el sistema, se plantea que presenten el formato dd/mm/aaaa. 

11. Manejo de fechas.
El presente proyecto contempla el manejo de fechas en determinadas situaciones:
•	Al dar de alta en el sistema a un nuevo contenido.
•	Fecha de emisión de un capítulo.
•	Fecha de inicio de una temporada.
•	Fecha de finalización de una temporada.
•	Fecha de préstamo de un juego

Cabe la posibilidad de contemplar un manejo de fechas para los préstamos, al menos para contemplar la fecha en la que éste se realiza, pero se deja esta opción abierta a las exigencias temporales del proyecto.

12.GUI.
El gestor de contenidos dispondrá de su propio entorno gráfico, con una ventana principal o padre que contendrá menús para las siguientes opciones:
o	Archivo
o	Nuevo
o	Abrir
o	Guardar
o	Guardar como…
o	Salir (con control de guardado en la misma para el catálogo abierto)
o	Edición
o	Añadir contenido.
o	Modificar contenido.
o	Eliminar contenido.
o	Búsqueda
o	Por título o por identificador.
o	Por fecha de alta.
o	Por ubicación.
o	Por calificación.
o	Mostrar
o	Todo el catálogo.
o	Los videojuegos
o	Videojuegos prestados.
o	Las películas
o	Las series:
o	Completas.
o	Las temporadas de una serie.
o	Los capítulos de una temporada
o	Mostrar por fecha.

Para la mejora de la accesibilidad y usabilidad todos los elementos del entorno gráfico pueden ser tratados mediante aceleradores y mnemonics.

Para mostrar la Serie, se mostrará la misma y, en la misma ventana, un desplegable por temporadas con un botón o similar para la selección. Una vez seleccionado, mostrará la información del capítulo, permitiendo ir recorriéndola con un iterador.
