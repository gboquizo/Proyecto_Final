package gestor.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import gestor.estructura.Contenido;
import gestor.estructura.Formato;
import gestor.estructura.Gestion;
import gestor.estructura.Ubicacion;
import gestor.estructura.excepciones.CalificacionNoValidaException;
import gestor.estructura.excepciones.FechaNoValidaException;
import gestor.estructura.excepciones.TituloNoValidoException;
import gestor.estructura.excepciones.UbicacionNoValidaException;
import gestor.estructura.excepciones.VideojuegoYaExisteException;

import javax.swing.JCheckBox;

public class AnnadirVideojuego extends GestorGUI {

	private static final long serialVersionUID = 1L;
	protected JComboBox<Formato> comboboxFormato;
	protected JLabel labelPlataforma;
	protected JLabel labelEstilo;
	protected JSpinner spinnerFechaPrestamo;
	protected JTextField textFieldTotalJuegos;
	protected JTextField textFieldHorasJuegos;
	protected JTextField textFieldPlataforma;
	protected JTextField textFieldEstilo;
	protected JCheckBox chckbxPrestado;
	protected JTextField textFieldPrestadoA;
	protected JLabel labelFechadePrestamo;
	protected JTextField textFieldCompannia;
	protected JLabel labelCompannia;
	protected JLabel labelFormato;
	protected JLabel labelPrestadoA;
	protected JLabel labelHorasJuego;
	protected JLabel labelTotalJuegos;
	protected JLabel labelFechaDevolucion;
	protected JSpinner spinnerFechaDevolucion;
	
	public static void main(String[] args) {
		try {
			AnnadirVideojuego dialog = new AnnadirVideojuego();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	 public AnnadirVideojuego() {
	 	labelCalificacion.setSize(76, 23);
	 	labelFechaDeAlta.setSize(86, 23);
	 	labelUbicacion.setSize(71, 23);
	 	textFieldID.setSize(33, 20);
	 	labelUbicacion.setText("Ubicación:");
	 	labelEstado.setSize(71, 23);
	 	textFieldEstado.setLocation(500, 124);
		textFieldTituloOriginal.setSize(380, 20);
		spinnerFechaDeAlta.setModel(new SpinnerDateModel(new Date(1527414256914L), null, null, Calendar.DAY_OF_MONTH));
		textFieldCalificacion.setLocation(500, 158);
		labelCalificacion.setLocation(342, 158);
		textFieldID.setLocation(100, 23);
		labelID.setLocation(10, 22);
		textFieldTituloOriginal.setLocation(100, 91);
		labelTituloOriginal.setLocation(10, 90);
		comboboxUbicacion.setLocation(144, 125);
		labelUbicacion.setLocation(10, 124);
		labelEstado.setLocation(342, 124);
		labelFechaDeAlta.setLocation(10, 158);
		btnEnviar.setLocation(342, 462);
		btnDcha.setLocation(581, 462);
		btnIzda.setLocation(512, 462);
		textFieldTitulo.setBounds(100, 57, 380, 20);
		spinnerFechaDeAlta.setLocation(144, 159);
		labelTitulo.setLocation(10, 56);

		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					// Obtenemos las fechas
					SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
					LocalDate fechaDeAlta = LocalDate.parse(formato.format(spinnerFechaDeAlta.getValue()));
					LocalDate fechaDePrestamo = LocalDate.parse(formato.format(spinnerFechaPrestamo.getValue()));
					LocalDate fechaDeDevolucion = LocalDate.parse(formato.format(spinnerFechaDevolucion.getValue()));
					
					// Añadimos videojuego
					Gestion.catalogo.annadirVideojuego(
							Integer.parseInt(textFieldID.getText()), 
							textFieldTitulo.getText(),
							textFieldTituloOriginal.getText(), 
							(Ubicacion) comboboxUbicacion.getSelectedItem(),
							textFieldPlataforma.getText(), 
							fechaDeAlta, 
							Double.parseDouble(textFieldCalificacion.getText()),
							textFieldCompannia.getText(),
							(Formato) comboboxFormato.getSelectedItem(),
							textFieldPlataforma.getText(),
							textFieldEstilo.getText(),
							Integer.parseInt(textFieldTotalJuegos.getText()),
							Integer.parseInt(textFieldHorasJuegos.getText()),							
							chckbxPrestado.isSelected(),
							textFieldPrestadoA.getText(),
							fechaDePrestamo	,
							fechaDeDevolucion
							);
					
					// Reseteamos campos de la ventana
					textFieldTitulo.setText("");
					textFieldTituloOriginal.setText("");
					textFieldPlataforma.setText("");
					textFieldCompannia.setText("");
					textFieldID.setText("");

					SimpleDateFormat model = new SimpleDateFormat("dd/MM/yyyy");
					spinnerFechaDeAlta.setModel(new SpinnerDateModel());
					spinnerFechaDeAlta.setEditor(new JSpinner.DateEditor(spinnerFechaDeAlta, model.toPattern()));
					
					// Actualizamos estado del fichero
					Gestion.setModificado(true);
					
				} catch (CalificacionNoValidaException | VideojuegoYaExisteException | TituloNoValidoException
						| UbicacionNoValidaException e1) {
					JOptionPane.showMessageDialog(contentPanel, e1.getMessage(), "ERROR!!!!",
							JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(contentPanel, "¡Tamaño inválido!", "ERROR!!!!",
							JOptionPane.ERROR_MESSAGE);
				} catch (FechaNoValidaException e1) {
					JOptionPane.showMessageDialog(contentPanel, e1.getMessage(), "ERROR!!!!",
							JOptionPane.ERROR_MESSAGE);
				} catch (DateTimeParseException e1) {
					JOptionPane.showMessageDialog(contentPanel, "Fecha no valida!", "ERROR!!!!",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnEnviar.setEnabled(true);
		setResizable(false);
		setModal(true);
		setTitle("Añadir videojuego");
		btnEnviar.setText("Añadir");
		
		comboboxUbicacion.setModel(new DefaultComboBoxModel<Ubicacion>(Ubicacion.values()));
		
		labelCompannia = new JLabel("Compañía:");
		labelCompannia.setBounds(10, 207, 76, 14);
		contentPanel.add(labelCompannia);
		
		textFieldCompannia = new JTextField();
		textFieldCompannia.setBounds(144, 204, 136, 20);
		contentPanel.add(textFieldCompannia);
		textFieldCompannia.setColumns(10);
		
		labelFormato = new JLabel("Formato:");
		labelFormato.setBounds(342, 207, 71, 14);
		contentPanel.add(labelFormato);
		
		comboboxFormato = new JComboBox<Formato>();
		comboboxFormato.setModel(new DefaultComboBoxModel<Formato>(Formato.values()));
		comboboxFormato.setBounds(500, 203, 136, 20);
		contentPanel.add(comboboxFormato);

		labelPlataforma = new JLabel("Plataforma:");
		labelPlataforma.setBounds(10, 250, 82, 14);
		contentPanel.add(labelPlataforma);
		
		textFieldPlataforma = new JTextField();
		textFieldPlataforma.setBounds(144, 247, 136, 20);
		contentPanel.add(textFieldPlataforma);
		textFieldPlataforma.setColumns(10);
		
		labelEstilo = new JLabel("Estilo:");
		labelEstilo.setBounds(342, 250, 55, 14);
		contentPanel.add(labelEstilo);
		
		textFieldEstilo = new JTextField();
		textFieldEstilo.setBounds(500, 246, 136, 20);
		contentPanel.add(textFieldEstilo);
		textFieldEstilo.setColumns(10);

		spinnerFechaPrestamo = new JSpinner();
		SimpleDateFormat prestamo = new SimpleDateFormat("dd/MM/yyyy");
		spinnerFechaPrestamo.setModel(new SpinnerDateModel(new Date(1527535977141L), null, null, Calendar.DAY_OF_MONTH));
		spinnerFechaPrestamo.setEditor(new JSpinner.DateEditor(spinnerFechaPrestamo, prestamo.toPattern()));
		spinnerFechaPrestamo.setBounds(144, 397, 136, 20);
		contentPanel.add(spinnerFechaPrestamo);
		
		labelFechaDevolucion = new JLabel("Fecha de devolución:");
		labelFechaDevolucion.setBounds(327, 400, 136, 14);
		contentPanel.add(labelFechaDevolucion);
		
		spinnerFechaDevolucion = new JSpinner();
		SimpleDateFormat devolucion = new SimpleDateFormat("dd/MM/yyyy");
		spinnerFechaDevolucion.setModel(new SpinnerDateModel(new Date(1527535954773L), null, null, Calendar.DAY_OF_MONTH));
		spinnerFechaDevolucion.setEditor(new JSpinner.DateEditor(spinnerFechaDevolucion, devolucion.toPattern()));
		spinnerFechaDevolucion.setBounds(500, 397, 136, 20);
		contentPanel.add(spinnerFechaDevolucion);

		labelFechadePrestamo = new JLabel("Fecha de préstamo:");
		labelFechadePrestamo.setBounds(10, 400, 136, 14);
		contentPanel.add(labelFechadePrestamo);

		chckbxPrestado = new JCheckBox("Prestado");
		chckbxPrestado.setSelected(false);
		chckbxPrestado.setBounds(10, 355, 82, 23);
		contentPanel.add(chckbxPrestado);
		
		labelPrestadoA = new JLabel("Prestado a:");
		labelPrestadoA.setBounds(144, 359, 76, 14);
		contentPanel.add(labelPrestadoA);
		
		textFieldPrestadoA = new JTextField();
		textFieldPrestadoA.setBounds(230, 356, 277, 20);
		contentPanel.add(textFieldPrestadoA);
		textFieldPrestadoA.setColumns(10);
		
		labelTotalJuegos = new JLabel("Nº Juegos");
		labelTotalJuegos.setBounds(10, 293, 76, 14);
		contentPanel.add(labelTotalJuegos);
		
		textFieldTotalJuegos = new JTextField();
		textFieldTotalJuegos.setColumns(10);
		textFieldTotalJuegos.setBounds(144, 290, 136, 20);
		contentPanel.add(textFieldTotalJuegos);
		
		labelHorasJuego = new JLabel("Horas de juego:");
		labelHorasJuego.setBounds(342, 293, 121, 14);
		contentPanel.add(labelHorasJuego);

		textFieldHorasJuegos= new JTextField();
		textFieldHorasJuegos.setColumns(10);
		textFieldHorasJuegos.setBounds(500, 289, 136, 20);
		contentPanel.add(textFieldHorasJuegos);

		btnIzda.setVisible(true);
		btnDcha.setVisible(true);
		okButton.setVisible(true);
		okButton.setText("Aceptar");
		cancelButton.setText("Cancelar");
		try {
			textFieldID.setText((Gestion.catalogo.get(Gestion.catalogo.size() - 1).getId() + 1) + "");
			
			
		} catch (IndexOutOfBoundsException e) {
			Contenido contenido = new Contenido("");
			textFieldID.setText(contenido.getId() + "");
		}
	}
}