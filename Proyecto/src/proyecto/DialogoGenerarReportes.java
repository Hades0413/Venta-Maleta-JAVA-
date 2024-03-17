package proyecto;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoGenerarReportes extends JDialog implements ActionListener {
	private JLabel lblTipoDeReporte;
	private JComboBox<String> cboTipoDeReporte;
	private JButton btnCerrar;
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
					DialogoGenerarReportes dialog = new DialogoGenerarReportes();
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
	public DialogoGenerarReportes() {
		setResizable(false);
		setModal(true);
		setTitle("Generar reportes");
		setBounds(100, 100, 600, 300);
		getContentPane().setLayout(null);
		
		lblTipoDeReporte = new JLabel("Tipo de reporte");
		lblTipoDeReporte.setBounds(10, 14, 71, 13);
		getContentPane().add(lblTipoDeReporte);
		
		cboTipoDeReporte = new JComboBox<String>();
		cboTipoDeReporte.addActionListener(this);
		cboTipoDeReporte.setModel(new DefaultComboBoxModel<String>(new String[] {"Ventas por modelo", "Raz\u00F3n de precios en relaci\u00F3n al precio mayor", "Estad\u00EDstica sobre la cantidad \u00F3ptima", "Estad\u00EDstica sobre el precio"}));
		cboTipoDeReporte.setBounds(91, 10, 315, 21);
		getContentPane().add(cboTipoDeReporte);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(491, 10, 85, 21);
		getContentPane().add(btnCerrar);
		
		scpBarras = new JScrollPane();
		scpBarras.setBounds(10, 41, 566, 212);
		getContentPane().add(scpBarras);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scpBarras.setViewportView(txtS);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboTipoDeReporte) {
			actionPerformedCboTipoDeReporte(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedCboTipoDeReporte(ActionEvent e) {
		int tire;
		tire = leerTipoReporte();
		switch(tire) {
			case  0: VentasModelo(); break;
			case  1: RazonPrecios(); break;
			case  2: EstadisticaCantidadOptima(); break;
			default: EstadisticaPrecio();
		}
	}
	
	int leerTipoReporte() {
		return cboTipoDeReporte.getSelectedIndex();
	}
	
	// Ventas por modelo 
	void VentasModelo() {
		double cudi0, cudi1, cudi2, cudi3, cudi4;
		cudi0 = calcularAporteCuotaDiaria0();
		cudi1 = calcularAporteCuotaDiaria1();
		cudi2 = calcularAporteCuotaDiaria2();
		cudi3 = calcularAporteCuotaDiaria3();
		cudi4 = calcularAporteCuotaDiaria4();
		mostrarVentasModelo(cudi0, cudi1, cudi2, cudi3, cudi4);
	}
	
	double calcularAporteCuotaDiaria0() {
		return Tienda.imptot0 * 100 / Tienda.cuotaDiaria;	
	}
	
	double calcularAporteCuotaDiaria1() {
		return Tienda.imptot1 * 100 / Tienda.cuotaDiaria;
	}
	
	double calcularAporteCuotaDiaria2() {
		return Tienda.imptot2 * 100 / Tienda.cuotaDiaria;
	}
	
	double calcularAporteCuotaDiaria3() {
		return Tienda.imptot3 * 100 / Tienda.cuotaDiaria;
	}
	
	double calcularAporteCuotaDiaria4() {
		return Tienda.imptot4 * 100 / Tienda.cuotaDiaria;
	}
	
	void mostrarVentasModelo(double cudi0, double cudi1, double cudi2, double cudi3, double cudi4) {
		txtS.setText("VENTAS POR MODELO" + "\n\n");
		imprimir("Modelo                        : " + Tienda.modelo0);
		imprimir("Cantidad de ventas            : " + Tienda.cantvent0);
		imprimir("Cantidad de unidades vendidas : " + Tienda.cantunid0);
		imprimir("Importe total vendido         : S/" + Tienda.imptot0);
		imprimir("Aporte a la cuota diaria      : " + cudi0 + "%" + "\n");
		imprimir("Modelo                        : " + Tienda.modelo1);
		imprimir("Cantidad de ventas            : " + Tienda.cantvent1);
		imprimir("Cantidad de unidades vendidas : " + Tienda.cantunid1);
		imprimir("Importe total vendido         : S/" + Tienda.imptot1);
		imprimir("Aporte a la cuota diaria      : " + cudi1 + "%" + "\n");
		imprimir("Modelo                        : " + Tienda.modelo2);
		imprimir("Cantidad de ventas            : " + Tienda.cantvent2);
		imprimir("Cantidad de unidades vendidas : " + Tienda.cantunid2);
		imprimir("Importe total vendido         : S/" + Tienda.imptot2);
		imprimir("Aporte a la cuota diaria      : " + cudi2 + "%" + "\n");
		imprimir("Modelo                        : " + Tienda.modelo3);
		imprimir("Cantidad de ventas            : " + Tienda.cantvent3);
		imprimir("Cantidad de unidades vendidas : " + Tienda.cantunid3);
		imprimir("Importe total vendido         : S/" + Tienda.imptot3);
		imprimir("Aporte a la cuota diaria      : " + cudi3 + "%" + "\n");
		imprimir("Modelo                        : " + Tienda.modelo4);
		imprimir("Cantidad de ventas            : " + Tienda.cantvent4);
		imprimir("Cantidad de unidades vendidas : " + Tienda.cantunid4);
		imprimir("Importe total vendido         : S/" + Tienda.imptot4);
		imprimir("Aporte a la cuota diaria      : " + cudi4 + "%");
	}
		
	void imprimir(String cad) {
		txtS.append(cad + "\n");
	}
	
	// Razón de precios en relación al precio mayor
	void RazonPrecios() {
		double raz0, raz1, raz2, raz3, raz4;
		hallarPrecioMayor();
		raz0 = calcularRazon0();
		raz1 = calcularRazon1();
		raz2 = calcularRazon2();
		raz3 = calcularRazon3();
		raz4 = calcularRazon4();
		mostrarRazonPrecios(raz0, raz1, raz2, raz3, raz4);
	}
	
	void hallarPrecioMayor() {
		if(Tienda.precio0 > Tienda.precio1 && Tienda.precio0 > Tienda.precio2 && Tienda.precio0 > Tienda.precio3 && Tienda.precio0 > Tienda.precio4)
			Tienda.precioMayor = Tienda.precio0;
		if(Tienda.precio1 > Tienda.precio0 && Tienda.precio1 > Tienda.precio2 && Tienda.precio1 > Tienda.precio3 && Tienda.precio1 > Tienda.precio4)
			Tienda.precioMayor = Tienda.precio1;
		if(Tienda.precio2 > Tienda.precio0 && Tienda.precio2 > Tienda.precio1 && Tienda.precio2 > Tienda.precio3 && Tienda.precio2 > Tienda.precio4)
			Tienda.precioMayor = Tienda.precio2;
		if(Tienda.precio3 > Tienda.precio0 && Tienda.precio3 > Tienda.precio1 && Tienda.precio3 > Tienda.precio2 && Tienda.precio3 > Tienda.precio4)
			Tienda.precioMayor = Tienda.precio3;
		if(Tienda.precio4 > Tienda.precio0 && Tienda.precio4 > Tienda.precio1 && Tienda.precio4 > Tienda.precio2 && Tienda.precio4 > Tienda.precio3)
			Tienda.precioMayor = Tienda.precio4;
	}
	
	double calcularRazon0() {
		return Tienda.precio0 / Tienda.precioMayor;
	}
	
	double calcularRazon1() {
		return Tienda.precio1 / Tienda.precioMayor;
	}
	
	double calcularRazon2() {
		return Tienda.precio2 / Tienda.precioMayor;
	}
	
	double calcularRazon3() {
		return Tienda.precio3 / Tienda.precioMayor;
	}
	
	double calcularRazon4() {
		return Tienda.precio4 / Tienda.precioMayor;
	}
	
	void mostrarRazonPrecios(double raz0, double raz1, double raz2, double raz3, double raz4) {
		txtS.setText("RAZÓN DE PRECIOS EN RELACIÓN AL PRECIO MAYOR" + "\n\n");
		imprimir("Modelo : " + Tienda.modelo0);
		imprimir("Precio : S/" + Tienda.precio0);
		imprimir("Razón  : " + raz0 + "\n");
		imprimir("Modelo : " + Tienda.modelo1);
		imprimir("Precio : S/" + Tienda.precio1);
		imprimir("Razón  : " + raz1 + "\n");
		imprimir("Modelo : " + Tienda.modelo2);
		imprimir("Precio : S/" + Tienda.precio2);
		imprimir("Razón  : " + raz2 + "\n");
		imprimir("Modelo : " + Tienda.modelo3);
		imprimir("Precio : S/" + Tienda.precio3);
		imprimir("Razón  : " + raz3 + "\n");
		imprimir("Modelo : " + Tienda.modelo4);
		imprimir("Precio : S/" + Tienda.precio4);
		imprimir("Razón  : " + raz4);
	}
	
	// Estadística sobre la cantidad óptima
	void EstadisticaCantidadOptima() {
		int sup = 0, nosup = 0, ig = 0;
		if(Tienda.cantunid0 > Tienda.cantidadOptima)
			sup ++;
		if(Tienda.cantunid0 < Tienda.cantidadOptima)
			nosup ++;
		if(Tienda.cantunid0 == Tienda.cantidadOptima)
			ig ++;
		if(Tienda.cantunid1 > Tienda.cantidadOptima)
			sup ++;
		if(Tienda.cantunid1 < Tienda.cantidadOptima)
			nosup ++;
		if(Tienda.cantunid1 == Tienda.cantidadOptima)
			ig ++;
		if(Tienda.cantunid2 > Tienda.cantidadOptima)
			sup ++;
		if(Tienda.cantunid2 < Tienda.cantidadOptima)
			nosup ++;
		if(Tienda.cantunid3 > Tienda.cantidadOptima)
			sup ++;
		if(Tienda.cantunid3 < Tienda.cantidadOptima)
			nosup ++;
		if(Tienda.cantunid3 == Tienda.cantidadOptima)
			ig ++;
		if(Tienda.cantunid4 > Tienda.cantidadOptima)
			sup ++;
		if(Tienda.cantunid4 < Tienda.cantidadOptima)
			nosup ++;
		if(Tienda.cantunid4 == Tienda.cantidadOptima)
			ig ++;
		mostrarEstadisticaCantidadOptima(sup, nosup, ig);
	}
	void mostrarEstadisticaCantidadOptima(int sup, int nosup, int ig) {
		txtS.setText("ESTADÍSTICA SOBRE LA CANTIDAD ÓPTIMA" + "\n" + "\n");
		imprimir("Cantidad de modelos que superaron la cantidad óptima    : " + sup);
		imprimir("Cantidad de modelos que no superaron la cantidad óptima : " + nosup);
		imprimir("Cantidad de modelos que igualaron la cantidad óptima    : " + ig);
	}
	
	// Estadística sobre el precio
	void EstadisticaPrecio() {
		double precprom;
		precprom = calcularPrecioPromedio();
		hallarPrecioMayor();
		hallarPrecioMenor();
		mostrarEstadisticaPrecio(precprom);
	}
	
	double calcularPrecioPromedio() {
		return (Tienda.precio0 + Tienda.precio1 + Tienda.precio2 + Tienda.precio3 + Tienda.precio4) / 5;
	}
	
	void hallarPrecioMenor() {
		if(Tienda.precio0 < Tienda.precio1 && Tienda.precio0 < Tienda.precio2 && Tienda.precio0 < Tienda.precio3 && Tienda.precio0 < Tienda.precio4)
			Tienda.precioMenor = Tienda.precio0;
		if(Tienda.precio1 < Tienda.precio0 && Tienda.precio1 < Tienda.precio2 && Tienda.precio1 < Tienda.precio3 && Tienda.precio1 < Tienda.precio4)
			Tienda.precioMenor = Tienda.precio1;
		if(Tienda.precio2 < Tienda.precio0 && Tienda.precio2 < Tienda.precio1 && Tienda.precio2 < Tienda.precio3 && Tienda.precio2 < Tienda.precio4)
			Tienda.precioMenor = Tienda.precio2;
		if(Tienda.precio3 < Tienda.precio0 && Tienda.precio3 < Tienda.precio1 && Tienda.precio3 < Tienda.precio2 && Tienda.precio3 < Tienda.precio4)
			Tienda.precioMenor = Tienda.precio3;
		if(Tienda.precio4 < Tienda.precio0 && Tienda.precio4 < Tienda.precio1 && Tienda.precio4 < Tienda.precio2 && Tienda.precio4 < Tienda.precio3)
			Tienda.precioMenor = Tienda.precio4;
	}
	
	void mostrarEstadisticaPrecio(double precprom) {
		txtS.setText("ESTADÍSTICA SOBRE EL PRECIO" + "\n" + "\n");
		imprimir("Precio promedio : S/" + precprom);
		imprimir("Precio mayor    : S/" + Tienda.precioMayor);
		imprimir("Precio menor    : S/" + Tienda.precioMenor);
	}
}