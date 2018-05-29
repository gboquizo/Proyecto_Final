package gestor.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import gestor.estructura.Contenido;
import gestor.estructura.Genero;
import gestor.estructura.Gestion;
import gestor.estructura.Idioma;
import gestor.estructura.Soporte;
import gestor.estructura.Ubicacion;
import gestor.estructura.excepciones.CalificacionNoValidaException;
import gestor.estructura.excepciones.FechaNoValidaException;
import gestor.estructura.excepciones.PeliculaYaExisteException;
import gestor.estructura.excepciones.TituloNoValidoException;
import gestor.estructura.excepciones.UbicacionNoValidaException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.Date;
import java.util.Calendar;

public class AnnadirPelicula extends GestorGUI {

	private static final long serialVersionUID = 1L;
	protected JTextField textFieldDirector;
	protected JComboBox<Genero> comboboxGenero;
	protected JLabel labelDirector;
	protected JLabel labelGenero;
	protected JLabel labelIdioma;
	protected JComboBox<Idioma> comboBoxIdioma;
	protected JSpinner spinnerFechaEstreno;
	protected JLabel labelFechadeEstreno;
	protected JLabel labelSoporte;
	protected JComboBox<Soporte> comboBoxSoporte;
	protected JLabel labelVisionados;
	protected JLabel labelDuracion;
	protected JLabel labelPremios;
	protected JTextField textFieldVisionados;
	protected JTextField textFieldDuracion;
	protected JTextField textFieldPremios;

	public AnnadirPelicula() {
		textFieldID.setEditable(false);
		textFieldTituloOriginal.setSize(316, 20);
		spinnerFechaDeAlta.setModel(new SpinnerDateModel(new Date(1527414256914L), null, null, Calendar.DAY_OF_MONTH));
		textFieldCalificacion.setLocation(100, 238);
		labelCalificacion.setLocation(14, 237);
		textFieldID.setLocation(100, 23);
		labelID.setLocation(14, 22);
		textFieldTituloOriginal.setLocation(100, 91);
		labelTituloOriginal.setLocation(10, 90);
		comboboxUbicacion.setLocation(100, 125);
		labelUbicacion.setLocation(14, 124);
		labelEstado.setLocation(14, 158);
		textFieldEstado.setLocation(100, 159);
		labelFechaDeAlta.setLocation(14, 203);
		btnEnviar.setLocation(529, 275);
		btnDcha.setLocation(581, 309);
		btnIzda.setLocation(515, 309);
		textFieldTitulo.setBounds(100, 57, 316, 20);
		spinnerFechaDeAlta.setLocation(100, 204);
		labelTitulo.setLocation(14, 56);

		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					// Obtenemos las fechas
					SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
					LocalDate fechaDeAlta = LocalDate.parse(formater.format(spinnerFechaDeAlta.getValue()));
					LocalDate fechaDeEstreno = LocalDate.parse(formater.format(spinnerFechaEstreno.getValue()));
					
					// Añadimos película
					Gestion.catalogo.annadirPelicula(Integer.parseInt(textFieldID.getText()), textFieldTitulo.getText(),
							textFieldTituloOriginal.getText(), (Ubicacion) comboboxUbicacion.getSelectedItem(),
							textFieldEstado.getText(), fechaDeAlta, Double.parseDouble(textFieldCalificacion.getText()),
							textFieldDirector.getText(), (Genero) comboboxGenero.getSelectedItem(),
							(Idioma) comboBoxIdioma.getSelectedItem(), fechaDeEstreno,
							(Soporte) comboBoxSoporte.getSelectedItem(),
							Integer.parseInt(textFieldVisionados.getText()),
							Integer.parseInt(textFieldDuracion.getText()),
							Integer.parseInt(textFieldPremios.getText()));
					
					limpiar();
					

					SimpleDateFormat model = new SimpleDateFormat("dd/MM/yyyy");
					spinnerFechaDeAlta.setModel(new SpinnerDateModel());
					spinnerFechaDeAlta.setEditor(new JSpinner.DateEditor(spinnerFechaDeAlta, model.toPattern()));
					
					// Actualizamos estado del fichero
					Gestion.setModificado(true);
					
				} catch (CalificacionNoValidaException | PeliculaYaExisteException | TituloNoValidoException
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
					JOptionPane.showMessageDialog(contentPanel, "Fecha no válida!", "ERROR!!!!",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		comboboxUbicacion.setModel(new DefaultComboBoxModel<Ubicacion>(Ubicacion.values()));
		btnEnviar.setEnabled(true);
		setResizable(false);
		setModal(true);
		setTitle("Añadir película");
		btnEnviar.setText("Añadir");

		textFieldDirector = new JTextField();
		textFieldDirector.setColumns(10);
		textFieldDirector.setBounds(100, 276, 316, 20);
		contentPanel.add(textFieldDirector);
		setBounds(100, 100, 756, 502);

		comboboxGenero = new JComboBox<Genero>();
		comboboxGenero.setModel(new DefaultComboBoxModel<Genero>(Genero.values()));
		comboboxGenero.setBounds(529, 23, 136, 20);
		contentPanel.add(comboboxGenero);

		labelDirector = new JLabel("Director:");
		labelDirector.setBounds(14, 279, 55, 14);
		contentPanel.add(labelDirector);

		labelGenero = new JLabel("Género:");
		labelGenero.setBounds(437, 26, 55, 14);
		contentPanel.add(labelGenero);

		labelIdioma = new JLabel("Idioma:");
		labelIdioma.setBounds(437, 60, 55, 14);
		contentPanel.add(labelIdioma);

		comboBoxIdioma = new JComboBox<Idioma>();
		comboBoxIdioma.setModel(new DefaultComboBoxModel<Idioma>(Idioma.values()));
		comboBoxIdioma.setBounds(529, 57, 136, 20);
		contentPanel.add(comboBoxIdioma);

		spinnerFechaEstreno = new JSpinner();
		SimpleDateFormat estreno = new SimpleDateFormat("dd/MM/yyyy");
		spinnerFechaEstreno.setModel(new SpinnerDateModel());
		spinnerFechaEstreno.setEditor(new JSpinner.DateEditor(spinnerFechaEstreno, estreno.toPattern()));
		spinnerFechaEstreno.setBounds(529, 91, 136, 20);
		contentPanel.add(spinnerFechaEstreno);

		labelFechadeEstreno = new JLabel("Estreno:");
		labelFechadeEstreno.setBounds(437, 94, 55, 14);
		contentPanel.add(labelFechadeEstreno);

		labelSoporte = new JLabel("Soporte:");
		labelSoporte.setBounds(437, 128, 68, 14);
		contentPanel.add(labelSoporte);

		comboBoxSoporte = new JComboBox<Soporte>();
		comboBoxSoporte.setModel(new DefaultComboBoxModel<Soporte>(Soporte.values()));
		comboBoxSoporte.setBounds(529, 125, 136, 20);
		contentPanel.add(comboBoxSoporte);

		labelVisionados = new JLabel("Nº visionados:");
		labelVisionados.setBounds(437, 162, 95, 14);
		contentPanel.add(labelVisionados);

		labelDuracion = new JLabel("Duración:");
		labelDuracion.setBounds(437, 207, 68, 14);
		contentPanel.add(labelDuracion);

		labelPremios = new JLabel("Nº premios:");
		labelPremios.setBounds(437, 241, 68, 14);
		contentPanel.add(labelPremios);

		textFieldVisionados = new JTextField();
		textFieldVisionados.setColumns(10);
		textFieldVisionados.setBounds(529, 159, 136, 20);
		contentPanel.add(textFieldVisionados);

		textFieldDuracion = new JTextField();
		textFieldDuracion.setColumns(10);
		textFieldDuracion.setBounds(529, 204, 136, 20);
		contentPanel.add(textFieldDuracion);

		textFieldPremios = new JTextField();
		textFieldPremios.setColumns(10);
		textFieldPremios.setBounds(529, 238, 136, 20);
		contentPanel.add(textFieldPremios);

		btnIzda.setVisible(true);
		btnDcha.setVisible(true);
		okButton.setVisible(true);
		okButton.setText("Aceptar");
		cancelButton.setText("Cancelar");
		try {
			if(!Gestion.catalogo.vacio()) { 
				textFieldID.setText((Gestion.catalogo.get(Gestion.catalogo.size() - 1).getId() + 1) + "");
				
			}
				textFieldID.setText("1");	
		} catch (IndexOutOfBoundsException e) {
			Contenido contenido = new Contenido("");
			textFieldID.setText(contenido.getId() + "");
			
		}
	}
	
	void limpiar() {
		super.limpiar();
		textFieldDirector.setText("");
		textFieldCalificacion.setText("");
		textFieldID.setText((Gestion.catalogo.get(Gestion.catalogo.size() - 1).getId() + 1) + "");
	}
}