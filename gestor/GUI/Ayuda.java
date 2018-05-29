package gestor.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.ComponentOrientation;
import javax.swing.JScrollPane;

/**
 * Clase para la ventana GUI de ayuda.
 * 
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class Ayuda extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	/**
	 * Create the dialog.
	 */
	public Ayuda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ayuda.class.getResource("/resources/favicon.png")));
		setResizable(false);
		setTitle("Ayuda del gestor de contenidos");
		setBounds(100, 100, 640, 447);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 614, 344);
		contentPanel.add(scrollPane);
		{
			JTextPane txtpnAyuda = new JTextPane();
			txtpnAyuda.setContentType("text/html");
			scrollPane.setViewportView(txtpnAyuda);
			txtpnAyuda.setEditable(false);
			txtpnAyuda.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtpnAyuda.setForeground(SystemColor.desktop);
			txtpnAyuda.setToolTipText("Desarrollado por Guillermo Boquizo Sánchez");
			txtpnAyuda.setBackground(Color.WHITE);
			txtpnAyuda.setText("\r\n<h1>Ayuda del gestor de contenidos multimedia:</h1>\r\n\r\n<ul>\r\n<li>Menú Archivo:\r\n\t<ul>\r\n\t<li>- Nuevo: Permite generar un nuevo gestor.</li>\r\n\t<li>- Abrir: Permite abrir un gestor ya creado.</li>\r\n\t<li>- Guardar: Permite guardar los cambios en un gestor ya creado. Si éste no ha sido guardado nunca, guarda el gestor en un nuevo \r\n\t   archivo .gbs</li>\r\n\t<li>- Guardar como: Permite guardar los cambios de un gestor en un archivo .gbs. Si éste ya existe, pide confirmación para el reemplazo.</li>\r\n\t<li>- Salir: Permite salir del gestor de contenidos.</li>\r\n</ul>\r\n</li>\r\n\r\nMenú Edición:\r\n\t- Submenú Añadir:\r\n\t\t- Película: Permite añadir una película.\r\n</ul>\r\n\t\t- Videojuego: Permite añadir un videojuego.\r\n\t\t- Serie: Permite añadir una serie.\r\n\t");
		}
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnAceptar.setToolTipText("Pulsa para salir");
		btnAceptar.setBounds(380, 366, 91, 23);
		contentPanel.add(btnAceptar);
	}
}