package principal;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import biblioteca.Bibliotecario;
import biblioteca.Boleta;

public class InterfazAddBoleta extends JFrame {
	
	public JPanel panel;

	
	public InterfazAddBoleta(){
		this.setSize(500, 380);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("A�adir Boleta");
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.gray);
		
		iniciarComponentes();
		
	}
	
	Bibliotecario bi=new Bibliotecario();
	Boleta b=new Boleta();
	
	public void iniciarComponentes() {
		
		colocarPaneles();
		colocarEtiquetas();
		addTxtAndButton();
		
	}
	
	private void colocarPaneles() {
		panel=new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
	}
	private void colocarEtiquetas() {
		
		JLabel etiqueta=new JLabel();
		etiqueta.setText("Pr�stamo");
		etiqueta.setBounds(150, 5, 200, 60);
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta.setFont(new Font("arial",Font.ITALIC,35));
		panel.add(etiqueta);
		
		JLabel etiqueta2=new JLabel();
		etiqueta2.setText("Nombre: ");
		etiqueta2.setBounds(50, 80, 300, 30);
		etiqueta2.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta2);
		
		JLabel etiqueta3=new JLabel();
		etiqueta3.setText("C�dula: ");
		etiqueta3.setBounds(50, 130, 300, 30);
		etiqueta3.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta3);
		
		JLabel etiqueta4Cod=new JLabel();
		etiqueta4Cod.setText("C�digo del libro: ");
		etiqueta4Cod.setBounds(50, 180, 300, 30);
		etiqueta4Cod.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta4Cod);
		
	}
	
	private void addTxtAndButton() {
		JTextField txtNombre=new JTextField();
		txtNombre.setBounds(270, 80, 170, 30);
		panel.add(txtNombre);
		
		JTextField txtCedula=new JTextField();
		txtCedula.setBounds(270, 130, 170, 30);
		panel.add(txtCedula);
		
		JTextField txtCodigoLibro=new JTextField();
		txtCodigoLibro.setBounds(270, 180, 170, 30);
		panel.add(txtCodigoLibro);

	
		JButton btnGuardar = new JButton();
		btnGuardar.setBounds(100, 280, 300,40);
		btnGuardar.setText("Confirmar");
		btnGuardar.setEnabled(true);
		btnGuardar.setFont(new Font("arial",3,20));
		btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				b.setNombreUsuario(txtNombre.getText());
				b.setCedulaUsuario(txtCedula.getText());
				b.setCodigo(Integer.parseInt(txtCodigoLibro.getText()));
				b.setNombreLibro(bi.buscarLibro(b.getCodigo()).getNombre());
				
				Date d=new Date();
				d.getTime();
				
				b.setFechaPrestamo(d);
				b.setFechaEntrega(bi.fechaEntrega(d));
				b.setEstado(false);
				
				bi.addBoleta(b);
				
				
				if(bi.prestarLibro(b.getCodigo(), b.getCodigoBoleta())) {
					JLabel lblprestamo=new JLabel();
					lblprestamo.setText("Se entreg� el libro");
					lblprestamo.setBounds(150, 330, 200, 20);
					lblprestamo.setHorizontalAlignment(SwingConstants.CENTER);
					lblprestamo.setFont(new Font("arial",Font.ITALIC,35));
					panel.add(lblprestamo);
				}else {
					JLabel lblprestamo=new JLabel();
					lblprestamo.setText("El libro no est� diponible");
					lblprestamo.setBounds(150, 330, 200, 20);
					lblprestamo.setHorizontalAlignment(SwingConstants.CENTER);
					lblprestamo.setFont(new Font("arial",Font.ITALIC,35));
					panel.add(lblprestamo);
				}
			}
		});
		panel.add(btnGuardar);
	}
	
	

}
