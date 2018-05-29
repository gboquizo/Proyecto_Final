package gestor.GUI;

import java.awt.event.ActionEvent;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import gestor.estructura.Contenido;
import gestor.estructura.Gestion;
import gestor.estructura.Pelicula;
import gestor.estructura.Ubicacion;
import gestor.estructura.Videojuego;
import gestor.estructura.excepciones.ContenidoNoExisteException;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class BorrarPorTitulo extends GestorGUI {
	private ListIterator<Contenido> it;
	private Contenido contenido;
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BorrarPorTitulo dialog = new BorrarPorTitulo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getUbicacion(Contenido contenido) {
		if (contenido instanceof Pelicula)
			comboboxUbicacion.setSelectedItem(((Pelicula) contenido).getUbicacion());
		else if (contenido instanceof Videojuego)
			comboboxUbicacion.setSelectedItem(((Videojuego) contenido).getUbicacion());
	}

	/**
	 * Create the dialog.
	 */
	public BorrarPorTitulo() {
		deshabilitarCampos();
		cancelButton.setText("Aceptar");
		okButton.setVisible(false);
		btnDcha.setVisible(false);
		btnIzda.setVisible(false);
		setTitle("Borrar por nombre");
		btnEnviar.setText("Buscar");
		btnEnviar.setEnabled(true);
		comboboxUbicacion.setModel(new DefaultComboBoxModel<Ubicacion>(Ubicacion.values()));
		spinnerFechaDeAlta.setModel(new SpinnerDateModel(new Date(1497045600000L), null, null, Calendar.YEAR));
		spinnerFechaDeAlta.setEditor(new JSpinner.DateEditor(spinnerFechaDeAlta, "dd/MM/yyyy, EEEE"));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					it = Gestion.catalogo.buscarPorTitulo((textFieldTitulo.getText()));
					contenido = it.next();
					textFieldID.setText(contenido.getId() + "");
					textFieldTitulo.setText(contenido.getTitulo());
					textFieldTituloOriginal.setText(contenido.getTituloOriginal());
					getUbicacion(contenido);
					textFieldEstado.setText(contenido.getEstado());
					textFieldCalificacion.setText(contenido.getCalificacion() + "");

					String fechaDeAlta = contenido.getFechaDeAlta().toString();
					Date alta = new SimpleDateFormat("yyyy-MM-dd").parse(fechaDeAlta);
					spinnerFechaDeAlta.setValue(alta);
					
					//Mensaje de aviso para el borrado
					int respuesta = JOptionPane.showConfirmDialog(contentPanel,
							"Se va a eliminar el contenido, ¿Está seguro?", "¡Atención!", JOptionPane.YES_NO_OPTION,
							JOptionPane.WARNING_MESSAGE);

					if (respuesta == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(contentPanel, "Contenido eliminado correctamente", "INFORMACIÓN",
								JOptionPane.INFORMATION_MESSAGE);
						Gestion.catalogo.eliminar(textFieldTitulo.getText());
						limpiar();
						// Actualizamos estado del fichero
						Gestion.setModificado(true);

					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Id no válido!", "Error!", JOptionPane.ERROR_MESSAGE);
				} catch (ContenidoNoExisteException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
				} catch (ParseException e2) {
					e2.printStackTrace();
				} catch (NullPointerException e3) {
					JOptionPane.showMessageDialog(null, "El contenido no existe!", "Error!", JOptionPane.ERROR_MESSAGE);
				} catch (NoSuchElementException e3) {
					JOptionPane.showMessageDialog(null, "Indique un título primero", "¡Error!", JOptionPane.ERROR_MESSAGE);
				}
			}

			private void limpiar() throws ContenidoNoExisteException {
				textFieldTitulo.setText("");
				textFieldTituloOriginal.setText("");
				textFieldID.setText("");
				textFieldEstado.setText("");
				textFieldCalificacion.setText("");
				comboboxUbicacion.setSelectedItem(null);
				try {
					String fechaEstandar = LocalDate.now().toString();
					Date estandar = new SimpleDateFormat("yyyy-MM-dd").parse(fechaEstandar);
					spinnerFechaDeAlta.setModel(new SpinnerDateModel(new Date(1497045600000L), null, null, Calendar.YEAR));
					spinnerFechaDeAlta.setEditor(new JSpinner.DateEditor(spinnerFechaDeAlta, "dd/MM/yyyy, EEEE"));
					spinnerFechaDeAlta.setValue(estandar);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void deshabilitarCampos() {
		textFieldTituloOriginal.setEditable(false);
		textFieldCalificacion.setEditable(false);
		textFieldEstado.setEditable(false);
		comboboxUbicacion.setEnabled(false);
		spinnerFechaDeAlta.setEnabled(false);
	}
}