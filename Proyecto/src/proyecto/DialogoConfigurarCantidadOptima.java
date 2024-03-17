package proyecto;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoConfigurarCantidadOptima extends JDialog implements ActionListener {
	private JLabel lblCantidadOptimaDeUnidadesVendidas;
	private JTextField txtCantidadOptimaDeUnidadesVendidas;
	private JButton btnAceptar;
	private JButton btnCancelar;

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
					DialogoConfigurarCantidadOptima dialog = new DialogoConfigurarCantidadOptima();
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
	public DialogoConfigurarCantidadOptima() {
		setResizable(false);
		setTitle("Configurar cantidad \u00F3ptima");
		setModal(true);
		setBounds(100, 100, 382, 102);
		getContentPane().setLayout(null);
		
		lblCantidadOptimaDeUnidadesVendidas = new JLabel("Cantidad \u00F3ptima de unidades vendidas");
		lblCantidadOptimaDeUnidadesVendidas.setBounds(10, 13, 193, 13);
		getContentPane().add(lblCantidadOptimaDeUnidadesVendidas);
		
		txtCantidadOptimaDeUnidadesVendidas = new JTextField();
		txtCantidadOptimaDeUnidadesVendidas.setBounds(210, 9, 48, 19);
		getContentPane().add(txtCantidadOptimaDeUnidadesVendidas);
		txtCantidadOptimaDeUnidadesVendidas.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(271, 9, 85, 21);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(271, 32, 85, 21);
		getContentPane().add(btnCancelar);
		
		mostrarCantidadOptima(Tienda.cantidadOptima);
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
	
	void mostrarCantidadOptima(int caop) {
		txtCantidadOptimaDeUnidadesVendidas.setText(caop + "");
	}
	
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		int caop;
		try {
		caop = leerCantidadOptima();
		if(caop < 0) {
			JOptionPane.showMessageDialog(this, "La cantidad óptima debe ser mayor que 0");
			txtCantidadOptimaDeUnidadesVendidas.requestFocus();
			txtCantidadOptimaDeUnidadesVendidas.selectAll();
		}
		else {
			Tienda.cantidadOptima = caop;
			dispose();
		}
	}
		catch (Exception x){
			JOptionPane.showMessageDialog(this, "La cantidad óptima debe contener un número" , "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	int leerCantidadOptima() {
		return Integer.parseInt(txtCantidadOptimaDeUnidadesVendidas.getText());
	}
}
