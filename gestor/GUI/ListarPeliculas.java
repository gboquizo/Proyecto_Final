package gestor.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ListIterator;

import gestor.estructura.Gestion;
import gestor.estructura.Pelicula;
import gestor.estructura.Contenido;

public class ListarPeliculas extends AnnadirPelicula {

	private static final long serialVersionUID = 1L;
	private ListIterator<Contenido> it;
	private Contenido contenido;
	private int controlMovimiento;

	/**
	 * Create the dialog.
	 */
	public ListarPeliculas() {
		setTitle("Listar Películas");
		setModal(true);
		movimientoBotones();
		controlDelIterador();
		establecerTextField();
		establecerComboBox();
		establecerSpinnerFecha();
		establecerBotonesPredefinidos();
	}
	
	private void controlDelIterador() {
		it = Gestion.catalogo.listarPeliculas();
		contenido = it.next();
		mostrarPelicula();
		btnIzda.setEnabled(false);
	}

	private void movimientoBotones() {
		btnDcha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				peliculaAdelante();
			}
		});

		btnIzda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				peliculaAtras();
			}
		});
	}

	private void peliculaAdelante() {
		if (it.hasNext())
			contenido = it.next();
		mostrarPelicula();
		if (controlMovimiento == 1)
			if (it.hasNext())
				contenido = it.next();
		mostrarPelicula();
		controlMovimiento = 0;
		comprobarBotones();
	}

	private void peliculaAtras() {
		if (it.hasPrevious())
			contenido = it.previous();
		mostrarPelicula();
		if (controlMovimiento == 0)
			if (it.hasPrevious())
				contenido = it.previous();
		mostrarPelicula();
		controlMovimiento = 1;
		comprobarBotones();
	}

	private void comprobarBotones() {
		btnIzda.setEnabled(true);
		btnDcha.setEnabled(true);
		if (!it.hasPrevious()) {
			btnIzda.setEnabled(false);
		}
		if (!it.hasNext()) {
			btnDcha.setEnabled(false);
		}
	}
	
	private void establecerBotonesPredefinidos() {
		cancelButton.setVisible(false);
		btnEnviar.setVisible(false);
		okButton.setText("Aceptar");
		btnDcha.setToolTipText("Permite avanzar el listado");
		btnIzda.setToolTipText("Permite retroceder el listado");
		btnDcha.setLocation(387, 369);
		btnIzda.setLocation(331, 369);
	}
	
	private void establecerSpinnerFecha() {
		spinnerFechaDeAlta.setEnabled(false);
		spinnerFechaEstreno.setEnabled(false);
	}

	private void establecerTextField() {
		textFieldTitulo.setEditable(false);
		textFieldTituloOriginal.setEditable(false);
		textFieldEstado.setEditable(false);
		textFieldCalificacion.setEditable(false);
		textFieldDirector.setEditable(false);
		textFieldVisionados.setEditable(false);
		textFieldDuracion.setEditable(false);
		textFieldPremios.setEditable(false);
	}


	private void establecerComboBox() {
		comboboxUbicacion.setSelectedItem(contenido.getUbicacion());
		comboboxUbicacion.setEditable(true);
		comboboxUbicacion.setEnabled(false);
		comboboxGenero.setSelectedItem(((Pelicula) contenido).getGenero());
		comboboxGenero.setEditable(true);
		comboboxGenero.setEnabled(false);
		comboBoxIdioma.setSelectedItem(((Pelicula) contenido).getIdioma());
		comboBoxIdioma.setEditable(true);
		comboBoxIdioma.setEnabled(false);
		comboBoxSoporte.setSelectedItem(((Pelicula) contenido).getSoporte());
		comboBoxSoporte.setEditable(true);
		comboBoxSoporte.setEnabled(false);
	}

	private void mostrarPelicula() {
		textFieldID.setText(contenido.getId() + "");
		textFieldTitulo.setText(contenido.getTitulo());
		textFieldTituloOriginal.setText(contenido.getTituloOriginal());
		comboboxUbicacion.setSelectedItem(contenido.getUbicacion());
		textFieldEstado.setText(contenido.getEstado());
		String fechaAlta = contenido.getFechaDeAlta().toString();
		try {
			Date alta = new SimpleDateFormat("yyyy-MM-dd").parse(fechaAlta);
			spinnerFechaDeAlta.setValue(alta);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		textFieldCalificacion.setText(contenido.getCalificacion() + "");
		textFieldDirector.setText(((Pelicula) contenido).getDirector());
		comboboxGenero.setSelectedItem(((Pelicula) contenido).getGenero());
		comboBoxIdioma.setSelectedItem(((Pelicula) contenido).getIdioma());
		String fechaEstreno = ((Pelicula) contenido).getAnnoEstreno().toString();
		try {
			Date estreno = new SimpleDateFormat("yyyy-MM-dd").parse(fechaEstreno);
			spinnerFechaEstreno.setValue(estreno);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		comboBoxSoporte.setSelectedItem(((Pelicula) contenido).getSoporte());
		textFieldVisionados.setText(((Pelicula) contenido).getVisionado() + "");
		textFieldDuracion.setText(((Pelicula) contenido).getDuracion() + "");
		textFieldPremios.setText(((Pelicula) contenido).getPremios() + "");
		comprobarBotones();
	}
}