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

public class DialogoConfigurarCuotaDiaria extends JDialog implements ActionListener {
	private JLabel lblCuotaDiariaEsperada;
	private JTextField txtCuotaDiariaEsperada;
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
					DialogoConfigurarCuotaDiaria dialog = new DialogoConfigurarCuotaDiaria();
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
	public DialogoConfigurarCuotaDiaria() {
		setResizable(false);
		setModal(true);
		setTitle("Configurar cuota diaria");
		setBounds(100, 100, 415, 100);
		getContentPane().setLayout(null);
		
		lblCuotaDiariaEsperada = new JLabel("Cuota diaria esperada (S/.)");
		lblCuotaDiariaEsperada.setBounds(10, 13, 147, 13);
		getContentPane().add(lblCuotaDiariaEsperada);
		
		txtCuotaDiariaEsperada = new JTextField();
		txtCuotaDiariaEsperada.setBounds(171, 9, 105, 19);
		getContentPane().add(txtCuotaDiariaEsperada);
		txtCuotaDiariaEsperada.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(306, 9, 85, 21);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(306, 32, 85, 21);
		getContentPane().add(btnCancelar);
		
		mostrarCuotaDiaria(Tienda.cuotaDiaria);
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
	
	void mostrarCuotaDiaria(double cudi) {
		txtCuotaDiariaEsperada.setText(cudi + "");
	}
	
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		double cudi;
		try {
		cudi = leerCuotaDiaria();
		if(cudi < 0) {
			JOptionPane.showMessageDialog(this, "La cuota diaria debe ser mayor que 0");
			txtCuotaDiariaEsperada.requestFocus();
			txtCuotaDiariaEsperada.selectAll();
		}
		else {
			Tienda.cuotaDiaria = cudi;
			dispose();
		} 
		} 
		catch (Exception x){
			JOptionPane.showMessageDialog(this, "La cuota diaria debe contener un número" , "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	double leerCuotaDiaria() {
		return Double.parseDouble(txtCuotaDiariaEsperada.getText());
	}
}
