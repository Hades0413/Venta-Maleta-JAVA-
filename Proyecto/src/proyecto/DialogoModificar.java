package proyecto;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoModificar extends JDialog implements ActionListener {
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblAncho;
	private JLabel lblAlto;
	private JLabel lblFondo;
	private JButton btnCerrar;
	private JButton btnGrabar;
	private JComboBox<String> cboModelo;
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtAlto;
	private JTextField txtFondo;

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
					DialogoModificar dialog = new DialogoModificar();
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
	public DialogoModificar() {
		setResizable(false);
		setModal(true);
		setTitle("Modificar maleta");
		setBounds(100, 100, 427, 174);
		getContentPane().setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 11, 46, 14);
		getContentPane().add(lblModelo);
		
		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(10, 36, 56, 14);
		getContentPane().add(lblPrecio);
		
		lblAncho = new JLabel("Ancho (cm)");
		lblAncho.setBounds(10, 61, 56, 14);
		getContentPane().add(lblAncho);
		
		lblAlto = new JLabel("Alto (cm)");
		lblAlto.setBounds(10, 86, 56, 14);
		getContentPane().add(lblAlto);
		
		lblFondo = new JLabel("Fondo (cm)");
		lblFondo.setBounds(10, 111, 56, 14);
		getContentPane().add(lblFondo);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(312, 7, 89, 23);
		getContentPane().add(btnCerrar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(312, 32, 89, 23);
		getContentPane().add(btnGrabar);
		
		cboModelo = new JComboBox<String>();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel<String>(new String[] {"Aviator", "Century", "Benneton", "Lucas", "Sansonite"}));
		cboModelo.setBounds(104, 7, 200, 22);
		getContentPane().add(cboModelo);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(104, 33, 200, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtAncho = new JTextField();
		txtAncho.setBounds(104, 58, 200, 20);
		getContentPane().add(txtAncho);
		txtAncho.setColumns(10);
		
		txtAlto = new JTextField();
		txtAlto.setBounds(104, 83, 200, 20);
		getContentPane().add(txtAlto);
		txtAlto.setColumns(10);
		
		txtFondo = new JTextField();
		txtFondo.setBounds(104, 108, 200, 20);
		getContentPane().add(txtFondo);
		txtFondo.setColumns(10);
	 mostrarModeloMaleta(Tienda.precio0, Tienda.ancho0, Tienda.alto0, Tienda.fondo0);
	
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
		
	}
	
	protected void actionPerformedCboModelo(ActionEvent e) {
		int Mod;
		Mod=leerModeloMaleta();
		switch(Mod) {
		case 0: mostrarModeloMaleta(Tienda.precio0, Tienda.ancho0, Tienda.alto0, Tienda.fondo0);
			break;
		case 1:
			mostrarModeloMaleta(Tienda.precio1, Tienda.ancho1, Tienda.alto1, Tienda.fondo1);
			break;
		case 2:
			mostrarModeloMaleta(Tienda.precio2, Tienda.ancho2, Tienda.alto2, Tienda.fondo2);
			break;
		case 3:
			mostrarModeloMaleta(Tienda.precio3, Tienda.ancho3, Tienda.alto3, Tienda.fondo3);
			break;
		default:
			mostrarModeloMaleta(Tienda.precio4, Tienda.ancho4, Tienda.alto4, Tienda.fondo4);
		}
			
	}
		int leerModeloMaleta() {
			return cboModelo.getSelectedIndex();
		}
		double leerPrecio() {
			return Double.parseDouble(txtPrecio.getText());
		}
		double leerAncho() {
			return Double.parseDouble(txtAncho.getText());
		}
		double leerAlto() {
			return Double.parseDouble(txtAlto.getText());
		}
		double leerFondo() {
			return Double.parseDouble(txtFondo.getText());
        }
		void mostrarModeloMaleta(double Pre, double Anc, double Alt, double Fon) {
			txtPrecio.setText(Pre+"");
			txtAncho.setText(Anc+"");
			txtAlto.setText(Alt+"");
			txtFondo.setText(Fon+"");
        }
		
	protected void actionPerformedBtnGrabar(ActionEvent e) {
		try {
			
			//Se crean las variables provicionales
			int Mod = leerModeloMaleta();
			
			//Validación de los nuevos datos.
			double Pre=leerPrecio();
			double Anc=leerAncho();
			double Alt=leerAlto();
			double Fon=leerFondo();
			
			//Validación del nuevo precio
			if (Pre <= 0) {
				JOptionPane.showMessageDialog(this, "El precio a debe ser mayor que 0");
				txtPrecio.requestFocus();
				txtPrecio.selectAll();
			}
			
			//Validación del nuevo ancho
			else if (Anc <= 0) {
				JOptionPane.showMessageDialog(this, "El ancho debe ser mayor que 0");
				txtAncho.requestFocus();
				txtAncho.selectAll();
			}
			
			//Validación del nuevo alto
			else if (Alt <= 0) {
				JOptionPane.showMessageDialog(this, "El alto debe ser mayor que 0");
				txtAlto.requestFocus();
			}
			
			//Validación del nuevo fondo
			else if (Fon <= 0) {
				JOptionPane.showMessageDialog(this, "El fondo debe ser mayor que 0");
				txtFondo.requestFocus();
			}
			
			//Se guarda los nuevos datos
			else {
				switch (Mod) {
					case 0:
						Tienda.precio0=Pre;
						Tienda.ancho0=Anc;
						Tienda.alto0=Alt;
						Tienda.fondo0=Fon;
						break;

					case 1:
						Tienda.precio1=Pre;
						Tienda.ancho1=Anc;
						Tienda.alto1=Alt;
						Tienda.fondo1=Fon;
						break;

					case 2:
						Tienda.precio2=Pre;
						Tienda.ancho2=Anc;
						Tienda.alto2=Alt;
						Tienda.fondo2=Fon;
						break;

					case 3:
						Tienda.precio3=Pre;
						Tienda.ancho3=Anc;
						Tienda.alto3=Alt;
						Tienda.fondo3=Fon;
						break;

					default:
						Tienda.precio4=Pre;
						Tienda.ancho4=Anc;
						Tienda.alto4=Alt;
						Tienda.fondo4=Fon;
				}
				dispose();
			} 
		}
		catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "El precio de la maleta debe ser expresado en números");
			txtPrecio.requestFocus();
			}//Fin de la validación
		}
	
}		
