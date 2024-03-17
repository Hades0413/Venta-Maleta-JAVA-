package proyecto;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoAcercaDeTienda extends JDialog implements ActionListener {
	private JLabel lblTienda;
	private JLabel lblAutores;
	private JLabel lblSebastian;
	private JButton btnCerrar;
	private JLabel lblLinea;
	private JLabel lblYasidh;
	private JLabel lblDiego;
	private JLabel lblPedro;
	private JLabel lblJoel;
	private JLabel lblJoan;

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
					DialogoAcercaDeTienda dialog = new DialogoAcercaDeTienda();
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
	public DialogoAcercaDeTienda() {
		setResizable(false);
		setModal(true);
		setTitle("Acerca de Tienda");
		setBounds(100, 100, 320, 340);
		getContentPane().setLayout(null);
		
		lblTienda = new JLabel("TIENDA 1.0");
		lblTienda.setForeground(Color.BLACK);
		lblTienda.setFont(new Font("Dubai Light", Font.BOLD, 20));
		lblTienda.setBounds(106, 10, 102, 30);
		getContentPane().add(lblTienda);
		
		lblAutores = new JLabel("AUTORES");
		lblAutores.setForeground(Color.DARK_GRAY);
		lblAutores.setFont(new Font("Dubai Light", Font.PLAIN, 15));
		lblAutores.setBounds(122, 58, 63, 30);
		getContentPane().add(lblAutores);
		
		lblSebastian = new JLabel("Hades0413");
		lblSebastian.setFont(new Font("Dubai Light", Font.ITALIC, 14));
		lblSebastian.setBounds(64, 109, 180, 14);
		getContentPane().add(lblSebastian);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(108, 267, 89, 23);
		getContentPane().add(btnCerrar);
		
		lblLinea = new JLabel("______________________________________________________________________________________________");
		lblLinea.setFont(new Font("Tahoma", Font.PLAIN, 5));
		lblLinea.setBounds(10, 40, 284, 14);
		getContentPane().add(lblLinea);
		
		lblYasidh = new JLabel("xxxxxxxxxx");
		lblYasidh.setFont(new Font("Dubai Light", Font.ITALIC, 14));
		lblYasidh.setBounds(64, 127, 180, 14);
		getContentPane().add(lblYasidh);
		
		lblDiego = new JLabel("xxxxxxxxxx");
		lblDiego.setFont(new Font("Dubai Light", Font.ITALIC, 14));
		lblDiego.setBounds(64, 145, 180, 14);
		getContentPane().add(lblDiego);
		
		lblPedro = new JLabel("xxxxxxxxxx");
		lblPedro.setFont(new Font("Dubai Light", Font.ITALIC, 14));
		lblPedro.setBounds(64, 163, 180, 14);
		getContentPane().add(lblPedro);
		
		lblJoel = new JLabel("xxxxxxxxxx");
		lblJoel.setFont(new Font("Dubai Light", Font.ITALIC, 14));
		lblJoel.setBounds(64, 181, 180, 14);
		getContentPane().add(lblJoel);
		
		lblJoan = new JLabel("xxxxxxxxxx");
		lblJoan.setFont(new Font("Dubai Light", Font.ITALIC, 14));
		lblJoan.setBounds(64, 199, 180, 14);
		getContentPane().add(lblJoan);

	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
