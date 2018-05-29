package gestor.GUI;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

/**
 * Clase para la ventana GUI AcercaDe.
 * 
 * @author Guillermo Boquizo Sánchez.
 * @version 1.0
 *
 */
public class AcercaDe extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public AcercaDe() {
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		setTitle("Acerca del catálogo\r\n");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AcercaDe.class.getResource("/resources/favicon.png")));
		setResizable(false);
		setBounds(100, 100, 677, 602);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JLabel lblAcercaDe = new JLabel(
				"<html>\r\n<h1>I.E.S Gran Capitán, 2018</h1>\t\r\n\r\n<h2>Gestor de contenidos multimedia."
						+ "</h2>\r\n<ul>\r\n\t<li>Desarrollado por:</li>\r\n\t\t\r\n\t\t\t<p>Guillermo Boquizo Sánchez</p>\r\n\r\n\t\t\t<p>Versión: 1.0</p>\r\n\t\r\n\t\t\t<p>Mayo - Junio 2018</p>\r\n</ul>\r\n</html>");
		lblAcercaDe.setForeground(new Color(0, 0, 0));
		lblAcercaDe.setBounds(96, 11, 424, 185);
		getContentPane().add(lblAcercaDe);
		lblAcercaDe.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblimagen = new JLabel("");
		lblimagen.setBounds(129, 183, 414, 300);
		getContentPane().add(lblimagen);
		lblimagen.setForeground(Color.WHITE);
		lblimagen.setIcon(new ImageIcon(PrincipalGUI.class.getResource("/resources/coche.gif")));

		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.setBounds(296, 481, 133, 92);
		getContentPane().add(panel);

		JButton btnSalir = new JButton("Aceptar");
		btnSalir.setBounds(10, 33, 117, 48);
		panel.add(btnSalir);
		btnSalir.setToolTipText("Permite salir de esta ventana");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}