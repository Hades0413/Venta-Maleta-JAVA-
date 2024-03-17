package proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class Tienda extends JFrame implements ActionListener {
	//maleta 1//
	public static String modelo0 = "Aviator";
	public static double precio0 = 124.9;
	public static double ancho0 = 63.5;
	public static double alto0 = 30.9;
	public static double fondo0 = 29.2;
	//maleta 2//
	public static String modelo1 = "Century";
	public static double precio1 = 174.9;
	public static double ancho1 = 75.0;
	public static double alto1 = 28.5;
	public static double fondo1 = 30.0;
	//maleta 3//
	public static String modelo2 = "Benneton";
	public static double precio2 = 159.9;
	public static double ancho2 = 65.2;
	public static double alto2 = 31.2;
	public static double fondo2 = 29.4;
	//maleta 4//
	public static String modelo3 = "Lucas";
	public static double precio3 = 99.9;
	public static double ancho3 = 45.0;
	public static double alto3 = 70.0;
	public static double fondo3 = 25.0;
	//maleta 5//
	public static String modelo4 = "Samsonite";
	public static double precio4 = 84.9;
	public static double ancho4 = 50.2;
	public static double alto4 = 60.4;
	public static double fondo4 = 25.0;
	// Porcentajes de descuento
	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10.0;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15.0;
	// Obsequios
	public static String tipoObsequio = "Lapicero";
	public static int obsequioCantidad1 = 2;
	public static int obsequioCantidad2 = 3;
	public static int obsequioCantidad3 = 4;
	public static String obsequio1 = "USB";
	public static String obsequio2 = "Cuaderno";
	public static String obsequio3 = "Lapicero";
	
	// Número de ventas
		public static int numeroVentas;

		// Importe total general acumulado
		public static double imptotgen;

		// Cuota diaria esperada
		public static double cuotaDiaria = 30000.0;

		// Cantidad óptima de unidades vendidas
		public static int cantidadOptima = 10;

		// Cantidad de ventas
		public static int cantvent0;
		public static int cantvent1;
		public static int cantvent2;
		public static int cantvent3;
		public static int cantvent4;

		// Cantidad de unidades vendidas
		public static int cantunid0;
		public static int cantunid1;
		public static int cantunid2;
		public static int cantunid3;
		public static int cantunid4;

		// Importe total vendido
		public static double imptot0;
		public static double imptot1;
		public static double imptot2;
		public static double imptot3;
		public static double imptot4;
		
		public static double precioMayor;
		public static double precioMenor;
	
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenuItem mntmConsultar;
	private JMenuItem mntmListar;
	private JMenu mnAyuda;
	private JMenuItem mntmAcercaDeTienda;
	private JMenu mnVentas;
	private JMenu mnConfiguracion;
	private JMenuItem mntmVender;
	private JMenuItem mntmGenerarReportes;
	private JMenuItem mntmConfigurarDescuentos;
	private JMenuItem mntmConfigurarObsequios;
	private JMenuItem mntmConfigurarCantidadOptima;
	private JMenuItem mntmConfigurarCuotaDiaria;
	private JMenuItem mntmModificar;

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
					Tienda frame = new Tienda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tienda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tienda.class.getResource("/proyecto/icono.png")));
		setResizable(false);
		setTitle("Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 487);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmConsultar = new JMenuItem("Consultar maleta");
		mntmConsultar.addActionListener(this);
		mnMantenimiento.add(mntmConsultar);
		
		mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(this);
		
		mntmModificar = new JMenuItem("Modificar maleta");
		mntmModificar.addActionListener(this);
		mnMantenimiento.add(mntmModificar);
		mnMantenimiento.add(mntmListar);
		
		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);
		
		mntmGenerarReportes = new JMenuItem("Generar reportes");
		mntmGenerarReportes.addActionListener(this);
		mnVentas.add(mntmGenerarReportes);
		
		mnConfiguracion = new JMenu("Configuraci\u00F3n");
		menuBar.add(mnConfiguracion);
		
		mntmConfigurarDescuentos = new JMenuItem("Configurar descuentos");
		mntmConfigurarDescuentos.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarDescuentos);
		
		mntmConfigurarObsequios = new JMenuItem("Configurar obsequios");
		mntmConfigurarObsequios.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarObsequios);
		
		mntmConfigurarCantidadOptima = new JMenuItem("Configurar cantidad \u00F3ptima");
		mntmConfigurarCantidadOptima.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarCantidadOptima);
		
		mntmConfigurarCuotaDiaria = new JMenuItem("Configurar cuota diaria");
		mntmConfigurarCuotaDiaria.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarCuotaDiaria);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAcercaDeTienda = new JMenuItem("Acerca de Tienda");
		mntmAcercaDeTienda.addActionListener(this);
		mnAyuda.add(mntmAcercaDeTienda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmModificar) {
			actionPerformedMntmModificar(e);
		}
		if (e.getSource() == mntmConfigurarCuotaDiaria) {
			actionPerformedMntmConfigurarCuotaDiaria(e);
		}
		if (e.getSource() == mntmConfigurarCantidadOptima) {
			actionPerformedMntmConfigurarCantidadOptima(e);
		}
		if (e.getSource() == mntmConfigurarObsequios) {
			actionPerformedMntmConfigurarObsequios(e);
		}
		if (e.getSource() == mntmConfigurarDescuentos) {
			actionPerformedMntmConfigurarDescuentos(e);
		}
		if (e.getSource() == mntmGenerarReportes) {
			actionPerformedMntmGenerarReportes(e);
		}
		if (e.getSource() == mntmVender) {
			actionPerformedMntmVender(e);
		}
		if (e.getSource() == mntmAcercaDeTienda) {
			actionPerformedMntmAcercaDeTienda(e);
		}
		if (e.getSource() == mntmListar) {
			actionPerformedMntmListar(e);
		}
		if (e.getSource() == mntmConsultar) {
			actionPerformedMntmConsultar(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	}
	protected void actionPerformedMntmConsultar(ActionEvent e) {
		DialogoConsultar d;
		d =new DialogoConsultar();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMntmListar(ActionEvent e) {
		DialogoListar d;
		d =new DialogoListar();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMntmAcercaDeTienda(ActionEvent e) {
		DialogoAcercaDeTienda d;
		d =new DialogoAcercaDeTienda();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMntmVender(ActionEvent e) {
		DialogoVender d;
		d =new DialogoVender();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMntmGenerarReportes(ActionEvent e) {
		DialogoGenerarReportes d;
		d =new DialogoGenerarReportes();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMntmConfigurarDescuentos(ActionEvent e) {
		DialogoConfigurarDescuentos d;
		d =new DialogoConfigurarDescuentos();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMntmConfigurarObsequios(ActionEvent e) {
		DialogoConfigurarObsequios d;
		d =new DialogoConfigurarObsequios();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMntmConfigurarCantidadOptima(ActionEvent e) {
		DialogoConfigurarCantidadOptima d;
		d =new DialogoConfigurarCantidadOptima();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMntmConfigurarCuotaDiaria(ActionEvent e) {
		DialogoConfigurarCuotaDiaria d;
		d =new DialogoConfigurarCuotaDiaria();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMntmModificar(ActionEvent e) {
		DialogoModificar d;
		d = new DialogoModificar();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
}
