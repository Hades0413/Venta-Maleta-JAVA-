package proyecto;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoVender extends JDialog implements ActionListener {
	private JLabel lblModelo;
	private JComboBox<String> cboModelo;
	private JButton btnVender;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JButton btnCerrar;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JScrollPane scpBarras;
	private JTextArea txtS;

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
					DialogoVender dialog = new DialogoVender();
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
	public DialogoVender() {
		setResizable(false);
		setTitle("Vender");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 14, 45, 13);
		getContentPane().add(lblModelo);
		
		cboModelo = new JComboBox<String>();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel<String>(new String[] {"Aviator", "Century", "Benneton", "Lucas", "Samsonite"}));
		cboModelo.setBounds(70, 10, 168, 21);
		getContentPane().add(cboModelo);
		
		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setBounds(341, 10, 85, 21);
		getContentPane().add(btnVender);
		
		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(10, 37, 50, 13);
		getContentPane().add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(70, 34, 168, 19);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(341, 33, 85, 21);
		getContentPane().add(btnCerrar);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 60, 45, 13);
		getContentPane().add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(70, 57, 168, 19);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		scpBarras = new JScrollPane();
		scpBarras.setBounds(10, 86, 416, 167);
		getContentPane().add(scpBarras);
		
		txtS = new JTextArea();
		scpBarras.setViewportView(txtS);
		
		txtPrecio.setText(Tienda.precio0 + "");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		}
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
	}
	
	protected void actionPerformedCboModelo(ActionEvent e) {
		int mod;
		mod = leerModelo();
		mostrarPrecio(mod);
		txtCantidad.requestFocus();
	}
	
	int leerModelo() {
		return cboModelo.getSelectedIndex();
	}
	
	void mostrarPrecio(int mod) {
		switch(mod) {
			case  0: txtPrecio.setText(Tienda.precio0 + ""); break;
			case  1: txtPrecio.setText(Tienda.precio1 + ""); break;
			case  2: txtPrecio.setText(Tienda.precio2 + ""); break;
			case  3: txtPrecio.setText(Tienda.precio3 + ""); break;
			default: txtPrecio.setText(Tienda.precio4 + "");
		}
	}
	
	protected void actionPerformedBtnVender(ActionEvent e) {
		try {
			int mod, cant, obs;
			double impcomp, impdesc, imppag, pocudi;
			mod = leerModelo();
			cant = leerCantidad();
			if(cant <= 0) {
				JOptionPane.showMessageDialog(this, "Cantidad debe ser mayor que 0", "Error", JOptionPane.ERROR_MESSAGE);
				txtCantidad.requestFocus();
				txtCantidad.selectAll();
			}
			else {
				impcomp = calcularImporteCompra(mod, cant);
				impdesc = calcularImporteDescuento(cant, impcomp);
				imppag = calcularImportePagar(impcomp, impdesc);
				obs = calcularObsequios(cant);
				efectuarIncrementos(mod, cant, imppag);
				pocudi = calcularPorcentajeCuotaDiaria();
				avanceVentas(pocudi);
				mostrarResultados(mod, cant, impcomp, impdesc, imppag, obs);
			}
		}
		catch(Exception e2) {
			JOptionPane.showMessageDialog(this, "Cantidad debe contener un número entero", "Error", JOptionPane.ERROR_MESSAGE);
			txtCantidad.requestFocus();
			txtCantidad.selectAll();
		}
	}
	
	int leerCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}
	
	double calcularImporteCompra(int mod, int cant) {
		switch(mod) {
			case  0: return Tienda.precio0 * cant;
			case  1: return Tienda.precio1 * cant;
			case  2: return Tienda.precio2 * cant;
			case  3: return Tienda.precio3 * cant;
			default: return Tienda.precio4 * cant;
		}
	}
	
	double calcularImporteDescuento(int cant, double impcomp) {
		if(cant <= 5) 		return (Tienda.porcentaje1 / 100) * impcomp;
		else if(cant <= 10) return (Tienda.porcentaje2 / 100) * impcomp;
		else if(cant <= 15) return (Tienda.porcentaje3 / 100) * impcomp;
		else				return (Tienda.porcentaje4 / 100) * impcomp;
	}
	
	double calcularImportePagar(double impcomp, double impdesc) {
		return impcomp - impdesc;
	}
	
	int calcularObsequios(int cant) {
		if(cant <= 5) 		return Tienda.obsequioCantidad1;
		else if(cant <= 10) return Tienda.obsequioCantidad2;
		else 				return Tienda.obsequioCantidad3;
	}
	
	void efectuarIncrementos(int mod, int can, double imppag) {
		switch(mod) {
			case  0: Tienda.cantvent0 ++; Tienda.cantunid0 += can; Tienda.imptot0 += imppag; break;
			case  1: Tienda.cantvent1 ++; Tienda.cantunid1 += can; Tienda.imptot1 += imppag; break;
			case  2: Tienda.cantvent2 ++; Tienda.cantunid2 += can; Tienda.imptot2 += imppag; break;
			case  3: Tienda.cantvent3 ++; Tienda.cantunid3 += can; Tienda.imptot3 += imppag; break;
			default: Tienda.cantvent4 ++; Tienda.cantunid4 += can; Tienda.imptot4 += imppag; break;
		}
		Tienda.numeroVentas ++;
		Tienda.imptotgen += imppag;
	}
	
	void avanceVentas(double pocudi) {
		if(Tienda.numeroVentas % 5 == 0 && Tienda.numeroVentas > 0)
			JOptionPane.showMessageDialog(this, "Venta Nro. " + Tienda.numeroVentas + "\n" + "Importe total general acumulado : S/" + Tienda.imptotgen + "\n" + "Porcentaje de la cuota diaria : " + pocudi + "%", "Avance de ventas", JOptionPane.INFORMATION_MESSAGE);
	}
	
	double calcularPorcentajeCuotaDiaria() {
		return (Tienda.imptotgen * 100) / Tienda.cuotaDiaria;
	}
	
	void mostrarResultados(int mod, int cant, double impcomp, double impdesc, double imppag, int obs) {
		txtS.setText("BOLETA DE VENTA" + "\n" + "\n");
		switch(mod) {
		case 0: 
			imprimir("Modelo               : " + Tienda.modelo0);
			imprimir("Precio               : S/" + Tienda.precio0);
			break;
		case 1: 
			imprimir("Modelo               : " + Tienda.modelo1);
			imprimir("Precio               : S/" + Tienda.precio1);
			break;
		case 2: 
			imprimir("Modelo               : " + Tienda.modelo2);
			imprimir("Precio               : S/" + Tienda.precio2);
			break;
		case 3: 
			imprimir("Modelo               : " + Tienda.modelo3);
			imprimir("Precio               : S/" + Tienda.precio3);
			break;
		default: 
			imprimir("Modelo               : " + Tienda.modelo4);
			imprimir("Precio               : S/" + Tienda.precio4);
		}
		imprimir("Cantidad adquirida   : " + cant);
		imprimir("Importe compra       : S/" + impcomp);
		imprimir("Importe descuento    : S/" + impdesc);
		imprimir("Importe pagar        : S/" + imppag);
		imprimir("Tipo de obsequio     : " + Tienda.tipoObsequio);
		imprimir("Unidades obsequiadas : " + obs);
	}
	
	void imprimir(String cad) {
		txtS.append(cad + "\n");
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
