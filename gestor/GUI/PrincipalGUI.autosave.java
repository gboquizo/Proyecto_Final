package gestor.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import gestor.GUI.PrincipalGUI;
import gestor.GUI.FondoPrincipal;
import gestor.estructura.Catalogo;
import gestor.estructura.Fichero;
import gestor.estructura.Filtro;
import gestor.estructura.Gestion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.Color;

/**
 * 
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class PrincipalGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane = new FondoPrincipal();
	private Ayuda ayuda = null;
	
	private final static Filtro filtro = new Filtro(".gbs", "Gestor de contenidos.");
	private static JFileChooser filechooser = new JFileChooser();
	
	static {
		filechooser.addChoosableFileFilter(filtro);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalGUI frame = new PrincipalGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalGUI() {
		contentPane.setSize(new Dimension(1000, 600));
		contentPane.setVisible(true);
		
		// Fichero inicial para el filechooser
		filechooser.setSelectedFile(new File("*.gbs"));
		
		setTitle("Sin titulo");
		
		// favicon
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalGUI.class.getResource("/resources/favicon.png")));
		
		setBounds(200, 200, 1000, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuArchivo = new JMenu("Archivo");
		menuArchivo.setMnemonic('A');
		menuBar.add(menuArchivo);

		JMenuItem itemNuevo = new JMenuItem("Nuevo");
		itemNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevo();
			}
		});
		itemNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		menuArchivo.add(itemNuevo);

		JMenuItem itemAbrir = new JMenuItem("Abrir");
		itemAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrir();

			}
		});

		itemAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		menuArchivo.add(itemAbrir);

		JMenuItem itemGuardar = new JMenuItem("Guardar");
		itemGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();

			}
		});
		itemGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		menuArchivo.add(itemGuardar);

		JMenuItem itemGuardarComo = new JMenuItem("Guardar como...");
		itemGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarComo();
			}
		});
		menuArchivo.add(itemGuardarComo);

		JSeparator separador = new JSeparator();
		separador.setForeground(Color.BLACK);
		menuArchivo.add(separador);
		
		JMenuItem itemSalir = new JMenuItem("Salir");
		itemSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		itemSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		menuArchivo.add(itemSalir);
		
		JMenu menuEdicion = new JMenu("Edicion");
		menuEdicion.setMnemonic('E');
		menuBar.add(menuEdicion);

		JMenu menuAnnadir = new JMenu("A\u00F1adir  ");
		menuEdicion.add(menuAnnadir);

		JMenuItem itemPelicula = new JMenuItem("Película");
		itemPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//AnnadirNovela annadirNovela = new AnnadirNovela();
				//annadirNovela.setVisible(true);
			}
		});
		menuAnnadir.add(itemPelicula);

		JMenuItem itemVideojuego = new JMenuItem("Videojuego");
		itemVideojuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//AnnadirRevista annadirRevista = new AnnadirRevista();
				//annadirRevista.setVisible(true);
			}
		});
		menuAnnadir.add(itemVideojuego);

		JMenuItem itemSerie = new JMenuItem("Serie");
		itemSerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//AnnadirPeriodico annadirPeriodico = new AnnadirPeriodico();
				//annadirPeriodico.setVisible(true);
			}
		});
		menuAnnadir.add(itemSerie);

		JMenu menuBorrar = new JMenu("Borrar  ");
		menuEdicion.add(menuBorrar);

		JMenuItem itemBorrarID = new JMenuItem("Borrar por identificador");
		menuBorrar.add(itemBorrarID);

		JMenuItem itemBorrarPorNombre = new JMenuItem("Borrar por nombre");
		itemBorrarPorNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//BorrarPorNombre borrarPorNombre = new BorrarPorNombre();
				//borrarPorNombre.setVisible(true);
			}
		});
		menuBorrar.add(itemBorrarPorNombre);
		itemBorrarID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//BorrarPorID borrarPorID = new BorrarPorID();
				//borrarPorID.setVisible(true);
			}
		});

		JMenu menuBuscar = new JMenu("Buscar  ");
		menuEdicion.add(menuBuscar);

		JMenuItem itemBuscarPorID = new JMenuItem("Buscar por identificador");
		menuBuscar.add(itemBuscarPorID);

		JMenuItem itemBuscarPorNombre = new JMenuItem("Buscar por nombre");
		itemBuscarPorNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//BuscarPorNombre buscarPorNombre = new BuscarPorNombre();
				//buscarPorNombre.setVisible(true);
			}
		});
		menuBuscar.add(itemBuscarPorNombre);
		itemBuscarPorID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//BuscarPorId buscarPorId = new BuscarPorId();
				//buscarPorId.setVisible(true);
			}
		});

		JMenu mnListar = new JMenu("Listar");
		mnListar.setMnemonic('L');
		menuBar.add(mnListar);

		JMenuItem itemListarPeliculas = new JMenuItem("Listar películas");
		itemListarPeliculas
				.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		itemListarPeliculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//ListarNovelas listarNovelas = new ListarNovelas();
					//listarNovelas.setVisible(true);
				} catch (IndexOutOfBoundsException | NoSuchElementException e1) {
					JOptionPane.showMessageDialog(null, "¡No hay películas!", "Error!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnListar.add(itemListarPeliculas);

		JMenuItem itemListarVideojuegos = new JMenuItem("Listar videojuegos");
		itemListarVideojuegos
				.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		itemListarVideojuegos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//ListarRevistas listarRevistas = new ListarRevistas();
					//listarRevistas.setVisible(true);
				} catch (IndexOutOfBoundsException | NoSuchElementException e1) {
					JOptionPane.showMessageDialog(null, "¡No hay videojuegos!", "Error!", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		mnListar.add(itemListarVideojuegos);
		
		JMenu menuSeries = new JMenu("Listar series");
		mnListar.add(menuSeries);
		
		JMenuItem itemSeries = new JMenuItem("Buscar por identificador");
		menuSeries.add(itemSeries);
		
		JMenuItem menuItem_1 = new JMenuItem("Buscar por nombre");
		menuSeries.add(menuItem_1);

		JSeparator separador_2 = new JSeparator();
		mnListar.add(separador_2);

		JMenuItem mntmListarTodo = new JMenuItem("Listar todo el catálogo");
		mntmListarTodo
				.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmListarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//ListarBiblioteca listarBiblioteca = new ListarBiblioteca();
					//listarBiblioteca.setVisible(true);
				} catch (IndexOutOfBoundsException | NoSuchElementException e) {
					JOptionPane.showMessageDialog(null, "Catálogo vacío", "Error!", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		mnListar.add(mntmListarTodo);

		JMenu mnPrestamosdevoluciones = new JMenu("Prestamos/Devoluciones");
		mnPrestamosdevoluciones.setMnemonic('P');
		menuBar.add(mnPrestamosdevoluciones);

		JMenuItem mntmRealizarPrstamo = new JMenuItem("Realizar pr\u00E9stamo");
		mntmRealizarPrstamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//PrestarPublicacion prestarPublicacion = new PrestarPublicacion();
				//prestarPublicacion.setVisible(true);
			}
		});
		mnPrestamosdevoluciones.add(mntmRealizarPrstamo);

		JMenuItem mntmRealizarDevoluin = new JMenuItem("Realizar devoluci\u00F3n");
		mntmRealizarDevoluin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//DevolverPublicacion devolverPublicacion = new DevolverPublicacion();
				//devolverPublicacion.setVisible(true);
			}
		});
		mnPrestamosdevoluciones.add(mntmRealizarDevoluin);

		JMenuItem mntmListarPrestados = new JMenuItem("Videojuegos prestados");
		mntmListarPrestados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//PublicacionesPrestadas publicacionesPrestadas = new PublicacionesPrestadas();
					//publicacionesPrestadas.setVisible(true);
				} catch (IndexOutOfBoundsException | NoSuchElementException e1) {
					JOptionPane.showMessageDialog(null, "¡No hay videojuegos prestados!", "Error!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnPrestamosdevoluciones.add(mntmListarPrestados);

		JMenuItem mntmListarADevolver = new JMenuItem("A devolver hoy");
		mntmListarADevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//ADevolverHoy aDevolverHoy = new ADevolverHoy();
					//aDevolverHoy.setVisible(true);
				} catch (IndexOutOfBoundsException | NoSuchElementException e1) {
					JOptionPane.showMessageDialog(null, "¡No hay videojuegos a devolver hoy", "Error!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnPrestamosdevoluciones.add(mntmListarADevolver);

		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);

		JMenuItem itemAcercaDe = new JMenuItem("Acerca del catálogo...");
		itemAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcercaDe acercaDe = new AcercaDe();
				acercaDe.setVisible(true);
			}
		});

		JMenuItem itemVerAyuda = new JMenuItem("Acceder a la ayuda");
		itemVerAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		itemVerAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ayuda == null) 
					ayuda = new Ayuda();
					ayuda.setVisible(true);
			}
		});
		mnAyuda.add(itemVerAyuda);
		mnAyuda.add(itemAcercaDe);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		cerrar();

	}

	/**
	 * Crea un nuevo biblioteca y comprueba los cambios del anterior
	 */
	private void nuevo() {
		if (Gestion.isModificado()) {
			switch (JOptionPane.showConfirmDialog(filechooser, "No ha guardado, ¿Desea guardar?", "Atención",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE)) {
			case JOptionPane.YES_OPTION:
				// Si respondemos Aceptar
				guardarComo();
				Gestion.catalogo = new Catalogo();
				setTitle("Sin titulo");
				Gestion.setModificado(false);
				break;
			case JOptionPane.NO_OPTION:
				// Si respondemos No
				Gestion.catalogo = new Catalogo();
				setTitle(filechooser.getSelectedFile().getName());
				Gestion.setModificado(false);
				break;
			default:
				break;
			}
		} else {
			Gestion.catalogo = new Catalogo();
			setTitle("Sin_titulo");
			Gestion.setModificado(false);
		}
	}

	/**
	 * Abre un archivo a partir de un filechoose
	 * 
	 * @throws HeadlessException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void abrirArchivo() throws HeadlessException, IOException, ClassNotFoundException {
		//filechooser.setAcceptAllFileFilterUsed(false);
		//filechooser.addChoosableFileFilter(filtro);
		if (filechooser.showDialog(filechooser, "Abrir Archivo") == JFileChooser.APPROVE_OPTION) {
			Fichero.leer(filechooser.getSelectedFile());
			setTitle(filechooser.getSelectedFile().getName());
			Gestion.setModificado(false);
		}
	}

	/**
	 * Abre una nueva biblioteca y comprueba si esta modificado
	 */
	private void abrir() {
		if (Gestion.isModificado()) {
			switch (JOptionPane.showConfirmDialog(filechooser, "No ha guardado, ¿Desea guardar?", "Atención",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE)) {

			case JOptionPane.YES_OPTION:
				guardarComo();
				break;
			case JOptionPane.NO_OPTION:
				try {
					abrirArchivo();
				} catch (IOException | ClassNotFoundException ex) {
					JOptionPane.showMessageDialog(null, "Error al abrir archivo", "Error", JOptionPane.ERROR_MESSAGE);
				}
				break;
			default:
				break;
			}
		} else {
			try {
				abrirArchivo();
			} catch (IOException | ClassNotFoundException ex) {
				JOptionPane.showMessageDialog(null, "Error al abrir archivo", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Guarda un archivo
	 */
	private void guardar() {
		if (getTitle().equalsIgnoreCase("Sin titulo")) {
			guardarComo();
		} else {
			try {
				Fichero.escribir(filechooser.getSelectedFile(), Gestion.catalogo);
				Gestion.setModificado(false);
				setTitle(filechooser.getSelectedFile().getName());
			} catch (IOException ex) {
			}
		}
	}

	/**
	 * Guarda un archivo y comprueba si existe
	 */
	private void guardarComo() {
		//filechooser.setAcceptAllFileFilterUsed(false);
		//filechooser.addChoosableFileFilter(filtro);

		if (JFileChooser.APPROVE_OPTION == filechooser.showDialog(filechooser, "Guardar")) {
			filechooser.setAcceptAllFileFilterUsed(false);

			if (filechooser.getSelectedFile().exists()) {

				switch (JOptionPane.showConfirmDialog(filechooser, "El archivo ya existe, ¿Desea sobreescribir?", "Atención",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE)) {

				case JOptionPane.YES_OPTION:
					try {
						Fichero.escribir(filechooser.getSelectedFile(), Gestion.catalogo);
						JOptionPane.showMessageDialog(null, "El archivo ha sido guardado", "Aceptar",
								JOptionPane.INFORMATION_MESSAGE);
						Gestion.setModificado(false);
						setTitle(filechooser.getSelectedFile().getName());
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					break;
				// En caso de NO y CANCEL informamos de que no ha sido guardado
				default:
					JOptionPane.showMessageDialog(null, "El archivo no se ha guardado", "¡Error!",
							JOptionPane.ERROR_MESSAGE);
					break;
				}
			}
			// Si el archivo no existe guardamos
			else {
				try {
					Fichero.escribir(filechooser.getSelectedFile(), Gestion.catalogo);
					Gestion.setModificado(false);
					setTitle(filechooser.getSelectedFile().getName());
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "El archivo no se ha guardado", "¡Error!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	/**
	 * 
	 */
	private void cerrar() {
		// Cerrar ventana en X y con alt + f4
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				salir();
			}

			@Override
			public void windowClosed(WindowEvent e) {
				salir();
			}
		});
	}
	
	/**
	 * Sale del programa comprobando cambios.
	 */
	private void salir() {
		if (Gestion.isModificado()) {
			switch (JOptionPane.showConfirmDialog(filechooser, "No ha guardado, ¿Desea guardar?", "Atención",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE)) {
			case JOptionPane.YES_OPTION:
				guardarComo();
				break;
			case JOptionPane.NO_OPTION:
				System.exit(0);
				break;
			default:
				break;
			}
		} else {
			System.exit(0);
		}
	}
}