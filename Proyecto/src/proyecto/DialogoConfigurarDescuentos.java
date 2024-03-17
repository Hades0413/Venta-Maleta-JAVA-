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

public class DialogoConfigurarDescuentos extends JDialog implements ActionListener {
	private JLabel lblCantidad1;
	private JTextField txtPorcentaje1;
	private JLabel lblPorcentaje1;
	private JButton btnAceptar;
	private JLabel lblCantidad2;
	private JTextField txtPorcentaje2;
	private JLabel lblPorcentaje2;
	private JLabel lblCantidad3;
	private JTextField txtPorcentaje3;
	private JLabel lblPorcentaje3;
	private JButton btnCerrar;
	private JLabel lblCantidad4;
	private JTextField txtPorcentaje4;
	private JLabel lblPorcentaje4;

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
					DialogoConfigurarDescuentos dialog = new DialogoConfigurarDescuentos();
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
	public DialogoConfigurarDescuentos() {
		setResizable(false);
		setModal(true);
		setTitle("Configurar porcentajes de descuento");
		setBounds(100, 100, 450, 145);
		getContentPane().setLayout(null);
		
		lblCantidad1 = new JLabel("1 a 5 unidades");
		lblCantidad1.setBounds(10, 13, 67, 13);
		getContentPane().add(lblCantidad1);
		
		txtPorcentaje1 = new JTextField();
		txtPorcentaje1.setBounds(117, 10, 96, 19);
		getContentPane().add(txtPorcentaje1);
		txtPorcentaje1.setColumns(10);
		
		lblPorcentaje1 = new JLabel("%");
		lblPorcentaje1.setBounds(223, 13, 45, 13);
		getContentPane().add(lblPorcentaje1);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(341, 10, 85, 21);
		getContentPane().add(btnAceptar);
		
		lblCantidad2 = new JLabel("6 a 10 unidades");
		lblCantidad2.setBounds(10, 36, 73, 13);
		getContentPane().add(lblCantidad2);
		
		txtPorcentaje2 = new JTextField();
		txtPorcentaje2.setBounds(117, 33, 96, 19);
		getContentPane().add(txtPorcentaje2);
		txtPorcentaje2.setColumns(10);
		
		lblPorcentaje2 = new JLabel("%");
		lblPorcentaje2.setBounds(223, 36, 45, 13);
		getContentPane().add(lblPorcentaje2);
		
		lblCantidad3 = new JLabel("11 a 15 unidades");
		lblCantidad3.setBounds(10, 59, 78, 13);
		getContentPane().add(lblCantidad3);
		
		txtPorcentaje3 = new JTextField();
		txtPorcentaje3.setBounds(117, 56, 96, 19);
		getContentPane().add(txtPorcentaje3);
		txtPorcentaje3.setColumns(10);
		
		lblPorcentaje3 = new JLabel("%");
		lblPorcentaje3.setBounds(223, 59, 45, 13);
		getContentPane().add(lblPorcentaje3);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(341, 32, 85, 21);
		getContentPane().add(btnCerrar);
		
		lblCantidad4 = new JLabel("M\u00E1s de 15 unidades");
		lblCantidad4.setBounds(10, 82, 91, 13);
		getContentPane().add(lblCantidad4);
		
		txtPorcentaje4 = new JTextField();
		txtPorcentaje4.setBounds(117, 79, 96, 19);
		getContentPane().add(txtPorcentaje4);
		txtPorcentaje4.setColumns(10);
		
		lblPorcentaje4 = new JLabel("%");
		lblPorcentaje4.setBounds(223, 82, 45, 13);
		getContentPane().add(lblPorcentaje4);
		
		mostrarPorcentajes();
	}
	
	void mostrarPorcentajes() {
		txtPorcentaje1.setText(Tienda.porcentaje1 + "");
		txtPorcentaje2.setText(Tienda.porcentaje2 + "");
		txtPorcentaje3.setText(Tienda.porcentaje3 + "");
		txtPorcentaje4.setText(Tienda.porcentaje4 + "");
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		try {
			double porc1, porc2, porc3, porc4;
			porc1 = leerPorcentaje1();
			porc2 = leerPorcentaje2();
			porc3 = leerPorcentaje3();
			porc4 = leerPorcentaje4();
			if(porc1 < 0) {
				JOptionPane.showMessageDialog(this, "Porcentaje debe ser mayor que 0", "Error", JOptionPane.ERROR_MESSAGE);
				txtPorcentaje1.requestFocus();
				txtPorcentaje1.selectAll();
			}
			else if(porc2 < 0) {
				JOptionPane.showMessageDialog(this, "Porcentaje debe ser mayor que 0", "Error", JOptionPane.ERROR_MESSAGE);
				txtPorcentaje2.requestFocus();
				txtPorcentaje2.selectAll();
			}
			else if(porc3 < 0) {
				JOptionPane.showMessageDialog(this, "Porcentaje debe ser mayor que 0", "Error", JOptionPane.ERROR_MESSAGE);
				txtPorcentaje3.requestFocus();
				txtPorcentaje3.selectAll();
			}
			else if(porc4 < 0) {
				JOptionPane.showMessageDialog(this, "Porcentaje debe ser mayor que 0", "Error", JOptionPane.ERROR_MESSAGE);
				txtPorcentaje4.requestFocus();
				txtPorcentaje4.selectAll();
			}
			else {
				Tienda.porcentaje1 = porc1;
				Tienda.porcentaje2 = porc2;
				Tienda.porcentaje3 = porc3;
				Tienda.porcentaje4 = porc4;
				dispose();
			}
		}
		catch(Exception e2) {
			JOptionPane.showMessageDialog(this, "Porcentaje debe contener un número", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	double leerPorcentaje1() {
		return Double.parseDouble(txtPorcentaje1.getText());
	}
	
	double leerPorcentaje2() {
		return Double.parseDouble(txtPorcentaje2.getText());
	}
	
	double leerPorcentaje3() {
		return Double.parseDouble(txtPorcentaje3.getText());
	}
	
	double leerPorcentaje4() {
		return Double.parseDouble(txtPorcentaje4.getText());
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
