package proyecto;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoConfigurarObsequios extends JDialog implements ActionListener {
	private JLabel lblTipoDeObsequio;
	private JTextField txtTipoDeObsequio;
	private JButton btnAceptar;
	private JLabel lblCantidad1;
	private JTextField txtCantidad1;
	private JButton btnCancelar;
	private JLabel lblCantidad2;
	private JTextField txtCantidad2;
	private JLabel lblCantidad3;
	private JTextField txtCantidad3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogoConfigurarObsequios dialog = new DialogoConfigurarObsequios();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DialogoConfigurarObsequios() {
		setResizable(false);
		setTitle("Configurar obsequios");
		setModal(true);
		setBounds(100, 100, 400, 150);
		getContentPane().setLayout(null);
		
		lblTipoDeObsequio = new JLabel("Tipo de obsequio");
		lblTipoDeObsequio.setBounds(10, 13, 78, 13);
		getContentPane().add(lblTipoDeObsequio);
		
		txtTipoDeObsequio = new JTextField();
		txtTipoDeObsequio.setBounds(108, 10, 96, 19);
		getContentPane().add(txtTipoDeObsequio);
		txtTipoDeObsequio.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(291, 9, 85, 21);
		getContentPane().add(btnAceptar);
		
		lblCantidad1 = new JLabel("1 a 5 unidades");
		lblCantidad1.setBounds(10, 36, 67, 13);
		getContentPane().add(lblCantidad1);
		
		txtCantidad1 = new JTextField();
		txtCantidad1.setBounds(108, 33, 96, 19);
		getContentPane().add(txtCantidad1);
		txtCantidad1.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(291, 32, 85, 21);
		getContentPane().add(btnCancelar);
		
		lblCantidad2 = new JLabel("6 a 10 unidades");
		lblCantidad2.setBounds(10, 59, 73, 13);
		getContentPane().add(lblCantidad2);
		
		txtCantidad2 = new JTextField();
		txtCantidad2.setBounds(108, 56, 96, 19);
		getContentPane().add(txtCantidad2);
		txtCantidad2.setColumns(10);
		
		lblCantidad3 = new JLabel("11 a m\u00E1s unidades");
		lblCantidad3.setBounds(10, 82, 86, 13);
		getContentPane().add(lblCantidad3);
		
		txtCantidad3 = new JTextField();
		txtCantidad3.setBounds(108, 79, 96, 19);
		getContentPane().add(txtCantidad3);
		txtCantidad3.setColumns(10);
		
		mostrarObsequio(Tienda.tipoObsequio, Tienda.obsequioCantidad1, Tienda.obsequioCantidad2, Tienda.obsequioCantidad3);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
	
	void mostrarObsequio(String obs, int can1, int can2, int can3) {
		txtTipoDeObsequio.setText(obs);
		txtCantidad1.setText(can1 + "");
		txtCantidad2.setText(can2 + "");
		txtCantidad3.setText(can3 + "");
	}
	
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		String obs;
		int can1, can2, can3;
		try {
		obs = leerObsequio();
		can1 = leerCantidad1();
		can2 = leerCantidad2();
		can3 = leerCantidad3();
		if(obs.length() == 0) {
			JOptionPane.showMessageDialog(this, "El obsequio no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
			txtTipoDeObsequio.requestFocus();
		}
		else if(can1 < 0) {
			JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor que 0", "Error", JOptionPane.ERROR_MESSAGE);
			txtCantidad1.requestFocus();
			txtCantidad1.selectAll();
		}
		else if(can2 < 0) {
			JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor que 0", "Error", JOptionPane.ERROR_MESSAGE);
			txtCantidad2.requestFocus();
			txtCantidad2.selectAll();
		}
		else if(can3 < 0) {
			JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor que 0", "Error", JOptionPane.ERROR_MESSAGE);
			txtCantidad3.requestFocus();
			txtCantidad3.selectAll();
		}
		else {
			Tienda.tipoObsequio = obs;
			Tienda.obsequioCantidad1 = can1;
			Tienda.obsequioCantidad2 = can2;
			Tienda.obsequioCantidad3 = can3;
			dispose();
		}
	}
		catch (Exception x){
			JOptionPane.showMessageDialog(this, "Ingrese el dato correcto que se requiere" , "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	String leerObsequio() {
		return txtTipoDeObsequio.getText();
	}
	
	int leerCantidad1() {
		return Integer.parseInt(txtCantidad1.getText());
	}
	
	int leerCantidad2() {
		return Integer.parseInt(txtCantidad2.getText());
	}
	
	int leerCantidad3() {
		return Integer.parseInt(txtCantidad3.getText());
	}
}
