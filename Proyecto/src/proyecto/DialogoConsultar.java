package proyecto;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoConsultar extends JDialog implements ActionListener {
	private JLabel lblModelo;
	private JComboBox<String> cboModelo;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblAncho;
	private JTextField txtAncho;
	private JLabel lblAlto;
	private JTextField txtAlto;
	private JLabel lblFondo;
	private JTextField txtFondo;
	private JButton btnCerrar;

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
					DialogoConsultar dialog = new DialogoConsultar();
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
	public DialogoConsultar() {
		setResizable(false);
		setModal(true);
		setTitle("Consultar maleta");
		setBounds(100, 100, 426, 174);
		getContentPane().setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 11, 69, 14);
		getContentPane().add(lblModelo);
		
		cboModelo = new JComboBox<String>();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel<String>(new String[] {"Aviator", "Century", "Benneton", "Lucas", "Sansonite"}));
		cboModelo.setBounds(104, 7, 200, 22);
		getContentPane().add(cboModelo);
		
		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(10, 36, 69, 14);
		getContentPane().add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(104, 33, 200, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		lblAncho = new JLabel("Ancho (cm)");
		lblAncho.setBounds(10, 61, 69, 14);
		getContentPane().add(lblAncho);
		
		txtAncho = new JTextField();
		txtAncho.setEditable(false);
		txtAncho.setBounds(104, 58, 200, 20);
		getContentPane().add(txtAncho);
		txtAncho.setColumns(10);
		
		lblAlto = new JLabel("Alto (cm)");
		lblAlto.setBounds(10, 86, 69, 14);
		getContentPane().add(lblAlto);
		
		txtAlto = new JTextField();
		txtAlto.setEditable(false);
		txtAlto.setBounds(104, 83, 200, 20);
		getContentPane().add(txtAlto);
		txtAlto.setColumns(10);
		
		lblFondo = new JLabel("Fondo (cm)");
		lblFondo.setBounds(10, 111, 69, 14);
		getContentPane().add(lblFondo);
		
		txtFondo = new JTextField();
		txtFondo.setEditable(false);
		txtFondo.setBounds(104, 108, 200, 20);
		getContentPane().add(txtFondo);
		txtFondo.setColumns(10);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(312, 7, 89, 23);
		getContentPane().add(btnCerrar);
		mostrarMaleta(Tienda.precio0,Tienda.ancho0,Tienda.alto0,Tienda.fondo0 );
	}
	public void actionPerformed(ActionEvent e) {
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
		int mod;
		mod = leerMaleta();
		switch(mod) {
			case 0:
				mostrarMaleta(Tienda.precio0,Tienda.ancho0,Tienda.alto0,Tienda.fondo0 );
			 break;
			case 1:	
				mostrarMaleta(Tienda.precio1,Tienda.ancho1,Tienda.alto1,Tienda.fondo1 );
				 break;
		    case 2:
		    	mostrarMaleta(Tienda.precio2,Tienda.ancho2,Tienda.alto2,Tienda.fondo2 );
		   	 break;
		    case 3:
		   		mostrarMaleta(Tienda.precio3,Tienda.ancho3,Tienda.alto3,Tienda.fondo3 );
		   		break;
		    default:
		    	mostrarMaleta(Tienda.precio4,Tienda.ancho4,Tienda.alto4,Tienda.fondo4 );
		}
	}
	void mostrarMaleta(double pre,double anc, double alt, double fon ) {
	    txtPrecio.setText  (pre  + "");
		txtAncho. setText  (anc  + "");
		txtAlto.  setText  (alt  + "");
		txtFondo. setText  (fon  + "");
	}
			
    int leerMaleta() { 
    	return cboModelo.getSelectedIndex();
    }
}
	

