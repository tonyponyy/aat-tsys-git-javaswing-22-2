package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Vista_pelicula_nueva extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField titulo_pelicula= new JTextField();
	public JTextField director= new JTextField();
	public static JButton guardar = new JButton("guardar");


	


	public Vista_pelicula_nueva() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 395, 162);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		guardar.setVerticalAlignment(SwingConstants.TOP);
		guardar.setBounds(188, 73, 168, 23);
		contentPane.add(guardar);
		
		titulo_pelicula.setText("titulo pelicula");
		titulo_pelicula.setBounds(10, 12, 346, 20);
		contentPane.add(titulo_pelicula);
		titulo_pelicula.setColumns(10);
		
		director.setText("director");
		director.setColumns(10);
		director.setBounds(10, 43, 346, 20);
		contentPane.add(director);
	}

}
