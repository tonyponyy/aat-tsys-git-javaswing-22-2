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
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class Vista_gestion_peliculas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable tabla_pelicula;
	public static JTable tabla_pelicula2;
	private static String[] nombre_columnas = {"id", "titulo", "director", "id_cliente"};
    public static DefaultTableModel modelo_tabla = new DefaultTableModel(nombre_columnas, 0);
    public static DefaultTableModel modelo_tabla2 = new DefaultTableModel(nombre_columnas, 0);
    public static JLabel nombre_cliente = new JLabel("nombre cliente");
    public static JLabel direccion_cliente = new JLabel("direccion cliente");
    public static JLabel fecha_cliente = new JLabel("fecha");
    public static JButton aniadir_pelicula_cliente = new JButton("Añadir pelicula");
    public static JButton eliminar_pelicula_cliente = new JButton("Eliminar pelicula");
    
	/**
	 * Create the frame.
	 */
	public Vista_gestion_peliculas() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 150, 766, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		getContentPane().setLayout(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("New button");
		button.setBounds(0, 0, 0, 0);
		contentPane.add(button);
		
		//modelo tabla 
		tabla_pelicula = new JTable(modelo_tabla);
		tabla_pelicula.setBounds(1, 26, 579, 0);
		contentPane.add(tabla_pelicula);
	    JScrollPane scrollPane = new JScrollPane(tabla_pelicula);
	    scrollPane.setBounds(21, 92, 581, 124);
        contentPane.add(scrollPane);
        
        tabla_pelicula2 = new JTable(modelo_tabla2);
        tabla_pelicula2.setBounds(1, 26, 579, 0);
		contentPane.add(tabla_pelicula2);
	    JScrollPane scrollPane2 = new JScrollPane(tabla_pelicula2);
	    scrollPane2.setBounds(21, 261, 581, 124);
        contentPane.add(scrollPane2);
        nombre_cliente.setBounds(21, 11, 336, 14);
        contentPane.add(nombre_cliente);
        direccion_cliente.setBounds(21, 36, 669, 14);
        contentPane.add(direccion_cliente);
        fecha_cliente.setBounds(362, 11, 339, 14);
        contentPane.add(fecha_cliente);
        
        
        aniadir_pelicula_cliente.setBounds(612, 264, 129, 23);
        contentPane.add(aniadir_pelicula_cliente);
        
        
        eliminar_pelicula_cliente.setBounds(612, 95, 129, 23);
        contentPane.add(eliminar_pelicula_cliente);
        
        JLabel lblNewLabel = new JLabel("Peliculas del cliente");
        lblNewLabel.setBounds(21, 73, 581, 14);
        contentPane.add(lblNewLabel);
        
        JLabel lblPeliculasDisponibles = new JLabel("Peliculas disponibles");
        lblPeliculasDisponibles.setBounds(21, 236, 581, 14);
        contentPane.add(lblPeliculasDisponibles);

	}
}
