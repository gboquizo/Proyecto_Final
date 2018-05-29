package gestor.GUI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ListIterator;

import javax.swing.JDialog;

import gestor.estructura.Contenido;
import gestor.estructura.Gestion;
import gestor.estructura.Videojuego;
import java.awt.Color;


public class ListarVideojuegos extends AnnadirVideojuego {

	private static final long serialVersionUID = 1L;
	private ListIterator<Contenido> it;
	private Contenido contenido;
	private int controlMovimiento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarVideojuegos dialog = new ListarVideojuegos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarVideojuegos() {
		chckbxPrestado.setBounds(10, 355, 123, 23);
		comboboxUbicacion.setEnabled(false);		
		textFieldID.setDisabledTextColor(Color.BLACK);
		chckbxPrestado.setEnabled(false);
		contentPanel.setEnabled(false);
		textFieldID.setEditable(false);
		textFieldEstilo.setBounds(500, 246, 219, 20);
		btnEnviar.setLocation(38, 482);
		textFieldPrestadoA.setLocation(246, 356);
		setTitle("Listar Videojuegos");
		setModal(true);
		movimientoBotones();
		controlDelIterador();
		establecerTextField();
		establecerComboBox();
		establecerSpinnerFecha();
		establecerBotonesPredefinidos();
	}
	
	private void controlDelIterador() {
		it = Gestion.catalogo.listarVideojuegos();
		contenido = it.next();
		mostrarVideojuego();
		btnIzda.setEnabled(false);
	}

	private void movimientoBotones() {
		btnDcha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				videojuegoAdelante();
			}
		});

		btnIzda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				videojuegoAtras();
			}
		});
	}

	private void videojuegoAdelante() {
		if (it.hasNext())
			contenido = it.next();
		mostrarVideojuego();
		if (controlMovimiento == 1)
			if (it.hasNext())
				contenido = it.next();
		mostrarVideojuego();
		controlMovimiento = 0;
		comprobarBotones();
	}

	private void videojuegoAtras() {
		if (it.hasPrevious())
			contenido = it.previous();
		mostrarVideojuego();
		if (controlMovimiento == 0)
			if (it.hasPrevious())
				contenido = it.previous();
		mostrarVideojuego();
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
		chckbxPrestado.setEnabled(false);
		cancelButton.setVisible(false);
		btnEnviar.setVisible(false);
		okButton.setText("Aceptar");
		btnDcha.setToolTipText("Permite avanzar el listado");
		btnIzda.setToolTipText("Permite retroceder el listado");
		btnDcha.setLocation(392, 452);
		btnIzda.setLocation(319, 452);
	}
	
	private void establecerSpinnerFecha() {
		spinnerFechaDeAlta.setEnabled(false);
		spinnerFechaPrestamo.setEnabled(false);
		spinnerFechaDevolucion.setEnabled(false);
	}

	private void establecerTextField() {
		textFieldTitulo.setEditable(false);
		textFieldTituloOriginal.setEditable(false);
		textFieldEstado.setEditable(false);
		textFieldCalificacion.setEditable(false);
		textFieldCompannia.setEditable(false);
		textFieldPlataforma.setEditable(false);
		textFieldEstilo.setEditable(false);
		textFieldTotalJuegos.setEditable(false);
		textFieldHorasJuegos.setEditable(false);
		textFieldPrestadoA.setEditable(false);
	}


	private void establecerComboBox() {
		comboboxUbicacion.setSelectedItem(contenido.getUbicacion());
		comboboxFormato.setSelectedItem(((Videojuego) contenido).getFormato());
		comboboxFormato.setEditable(true);
		comboboxFormato.setEnabled(false);
	}

	private void mostrarVideojuego() {
		textFieldID.setText((contenido.getId() + 1) + "");
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
		
		textFieldCompannia.setText(((Videojuego) contenido).getCompannia());
		comboboxFormato.setSelectedItem(((Videojuego) contenido).getFormato());
		textFieldPlataforma.setText(((Videojuego) contenido).getPlataforma());
		textFieldEstilo.setText(((Videojuego) contenido).getEstilo());
		textFieldTotalJuegos.setText(((Videojuego) contenido).getTotalJuegos() + "");
		textFieldHorasJuegos.setText(((Videojuego) contenido).getHorasJuego() + "");
		establecerCamposPrestamo();
		textFieldPrestadoA.setText(((Videojuego) contenido).getPrestadoA() + "");
		String fechaPrestamo = ((Videojuego) contenido).getFechaPrestamo().toString();
		try {
			if(!((Videojuego) contenido).getPrestado()) {
				spinnerFechaPrestamo.setVisible(false);
				spinnerFechaDevolucion.setVisible(false);
				textFieldPrestadoA.setText("El videojuego no se encuentra prestado");
			}
			Date estreno = new SimpleDateFormat("yyyy-MM-dd").parse(fechaPrestamo);
			spinnerFechaPrestamo.setValue(estreno);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		comprobarBotones();
	}

	
	private void establecerCamposPrestamo()  {
		if(!((Videojuego) contenido).getPrestado()) {
			chckbxPrestado.setText("No prestado");
			chckbxPrestado.setSelected(false);
			labelFechadePrestamo.setVisible(false);
			labelFechaDevolucion.setVisible(false);
			
		} else {
			spinnerFechaPrestamo.setVisible(true);
			spinnerFechaDevolucion.setVisible(true);
			chckbxPrestado.setText("Prestado");
			chckbxPrestado.setSelected(true);
			labelFechadePrestamo.setVisible(true);
			labelFechaDevolucion.setVisible(true);
		}	
	}
}