package gestor.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gestor.estructura.Ubicacion;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.awt.Toolkit;

public class GestorGUI extends JDialog {

	protected static final long serialVersionUID = 1L;

	protected final JPanel contentPanel = new JPanel();
	protected JLabel labelID;
	protected JTextField textFieldID;
	protected JLabel labelTitulo;
	protected JTextField textFieldTitulo;
	protected JLabel labelTituloOriginal;
	protected JTextField textFieldTituloOriginal;
	protected JLabel labelUbicacion;
	protected JComboBox<Ubicacion> comboboxUbicacion;
	protected JLabel labelEstado;
	protected JTextField textFieldEstado;
	protected JLabel labelFechaDeAlta;
	protected JSpinner spinnerFechaDeAlta;
	protected JButton btnEnviar;
	protected JButton btnIzda;
	protected JButton btnDcha;
	protected JButton okButton;
	protected JButton cancelButton;
	protected JLabel labelCalificacion;
	protected JTextField textFieldCalificacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestorGUI dialog = new GestorGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GestorGUI() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalGUI.class.getResource("/resources/favicon.png")));
		setModal(true);
		setBounds(100, 100, 807, 567);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		labelTitulo = new JLabel("Título:");
		labelTitulo.setBounds(10, 56, 46, 23);
		contentPanel.add(labelTitulo);

		labelFechaDeAlta = new JLabel("Fecha de alta:");
		labelFechaDeAlta.setBounds(10, 185, 86, 23);
		contentPanel.add(labelFechaDeAlta);

		labelID = new JLabel("ID:");
		labelID.setBounds(10, 22, 24, 23);
		contentPanel.add(labelID);

		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(110, 57, 341, 20);
		contentPanel.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);

		textFieldID = new JTextField();
		textFieldID.setEnabled(false);
		textFieldID.setBounds(110, 23, 68, 20);
		contentPanel.add(textFieldID);
		textFieldID.setColumns(10);

		labelUbicacion = new JLabel("Ubicación");
		labelUbicacion.setBounds(10, 117, 86, 23);
		contentPanel.add(labelUbicacion);

		comboboxUbicacion = new JComboBox<Ubicacion>();
		comboboxUbicacion.setBounds(110, 118, 136, 20);
		contentPanel.add(comboboxUbicacion);

		btnEnviar = new JButton("Enviar");
		btnEnviar.setEnabled(false);
		btnEnviar.setBounds(356, 243, 95, 23);
		contentPanel.add(btnEnviar);

		btnIzda = new JButton("<");
		btnIzda.setBounds(356, 289, 46, 23);
		contentPanel.add(btnIzda);

		btnDcha = new JButton(">");
		btnDcha.setBounds(406, 289, 45, 23);
		contentPanel.add(btnDcha);

		SimpleDateFormat model = new SimpleDateFormat("dd/MM/yyyy");
		spinnerFechaDeAlta = new JSpinner();
		spinnerFechaDeAlta.setModel(new SpinnerDateModel());
		spinnerFechaDeAlta.setEditor(new JSpinner.DateEditor(spinnerFechaDeAlta, model.toPattern()));
		spinnerFechaDeAlta.setBounds(110, 188, 136, 20);

		contentPanel.add(spinnerFechaDeAlta);

		labelTituloOriginal = new JLabel("Título original:");
		labelTituloOriginal.setBounds(10, 86, 86, 23);
		contentPanel.add(labelTituloOriginal);

		textFieldTituloOriginal = new JTextField();
		textFieldTituloOriginal.setColumns(10);
		textFieldTituloOriginal.setBounds(110, 87, 341, 20);
		contentPanel.add(textFieldTituloOriginal);

		labelEstado = new JLabel("Estado:");
		labelEstado.setBounds(10, 151, 86, 23);
		contentPanel.add(labelEstado);

		textFieldEstado = new JTextField();
		textFieldEstado.setColumns(10);
		textFieldEstado.setBounds(110, 152, 136, 20);
		contentPanel.add(textFieldEstado);

		labelCalificacion = new JLabel("Calificación:");
		labelCalificacion.setBounds(10, 223, 86, 23);
		contentPanel.add(labelCalificacion);

		textFieldCalificacion = new JTextField();
		textFieldCalificacion.setColumns(10);
		textFieldCalificacion.setBounds(110, 224, 136, 20);
		contentPanel.add(textFieldCalificacion);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Aceptar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	void limpiar() {
		textFieldTitulo.setText("");
		textFieldTituloOriginal.setText("");
		textFieldEstado.setText("");
		//textFieldID.setText("");
		textFieldCalificacion.setText("");
		comboboxUbicacion.setSelectedItem(null);
	}
}