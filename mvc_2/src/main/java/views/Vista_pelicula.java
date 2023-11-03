package views;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Vista_pelicula extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable tabla_pelicula;
	private static String[] nombre_columnas = {"id", "titulo", "director", "id_cliente"};
    public static DefaultTableModel modelo_tabla = new DefaultTableModel(nombre_columnas, 0);
    public static JButton nueva_pelicula = new JButton("Nueva Pelicula");
    public static JButton editar_pelicula = new JButton("Editar pelicula");
	public static JButton eliminar_pelicula = new JButton("Eliminar pelicula");
	private final JLabel lblNewLabel = new JLabel("Peliculas");

	/**
	 * Create the frame.
	 */
	public Vista_pelicula() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 876, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		getContentPane().setLayout(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("New button");
		button.setBounds(0, 0, 0, 0);
		contentPane.add(button);
		
		
		nueva_pelicula.setBounds(711, 41, 149, 23);
		contentPane.add(nueva_pelicula);
		
		editar_pelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		editar_pelicula.setBounds(711, 75, 149, 23);
		contentPane.add(editar_pelicula);
		

		eliminar_pelicula.setBounds(711, 109, 149, 23);
		contentPane.add(eliminar_pelicula);
		
		//modelo tabla 
		tabla_pelicula = new JTable(modelo_tabla);
		tabla_pelicula.setBounds(21, 11, 422, 292);
		contentPane.add(tabla_pelicula);
	    JScrollPane scrollPane = new JScrollPane(tabla_pelicula);
        scrollPane.setBounds(21, 38, 680, 292);
        contentPane.add(scrollPane);
        lblNewLabel.setBounds(21, 11, 367, 14);
        
        contentPane.add(lblNewLabel);

	}

}
