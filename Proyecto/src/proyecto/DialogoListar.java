package proyecto;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoListar extends JDialog implements ActionListener {
	private JScrollPane scpBarras;
	private JButton btnCerrar;
	private JButton btnListar;
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
					DialogoListar dialog = new DialogoListar();
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
	public DialogoListar() {
		setAlwaysOnTop(true);
		setResizable(false);
		setModal(true);
		setTitle("Listado de maletas");
		setBounds(100, 100, 480, 355);
		getContentPane().setLayout(null);
		
		scpBarras = new JScrollPane();
		scpBarras.setBounds(10, 11, 444, 260);
		getContentPane().add(scpBarras);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setWrapStyleWord(true);
		scpBarras.setViewportView(txtS);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(138, 282, 89, 23);
		getContentPane().add(btnCerrar);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(237, 282, 89, 23);
		getContentPane().add(btnListar);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		
	}
	
	protected void actionPerformedBtnListar(ActionEvent e) {
		txtS.setText("Listado de Maletas\n\n");
		
		
		mostrarMaleta(Tienda.modelo0, Tienda.precio0, Tienda.fondo0, Tienda.ancho0, Tienda.alto0);
		mostrarMaleta(Tienda.modelo1, Tienda.precio1, Tienda.fondo1, Tienda.ancho1, Tienda.alto1);
		mostrarMaleta(Tienda.modelo2, Tienda.precio2, Tienda.fondo2, Tienda.ancho2, Tienda.alto2);
		mostrarMaleta(Tienda.modelo3, Tienda.precio3, Tienda.fondo3, Tienda.ancho3, Tienda.alto3);
		mostrarMaleta(Tienda.modelo4, Tienda.precio4, Tienda.fondo4, Tienda.ancho4, Tienda.alto4);
	}
	
	void mostrarMaleta(String mod, double pre, double fondo0, double ancho0, double alto0) {
		inprimir("Modelo      : " + mod);
		inprimir("Profundidad : " + fondo0);
		inprimir("Ancho       : " + ancho0);
		inprimir("Alto        : " + alto0);
		inprimir("Precio      : S/ " + pre + "\n");
		
	}
	
	void inprimir(String cad) {
		txtS.append(cad + "\n");
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}  