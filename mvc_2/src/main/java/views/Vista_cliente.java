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
import java.awt.Font;

public class Vista_cliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable tabla_cliente;
	private static String[] nombre_columnas = {"id", "nombre", "apellido", "dni","direccion", "fecha"};
    public static DefaultTableModel modelo_tabla = new DefaultTableModel(nombre_columnas, 0);
    public static JButton nuevo_cliente = new JButton("Nuevo Cliente");
    public static JButton editar_cliente = new JButton("Editar cliente");
	public static JButton eliminar_cliente = new JButton("Eliminar cliente");
	public static JButton ver_pelicula = new JButton("Ver peliculas");
	private final JLabel lblNewLabel = new JLabel("Clientes");
	public final static JButton gestionar_peliculas = new JButton("Gestionar peliculas del cliente");
	public final static JButton ver_cliente = new JButton("Ver cliente");
	

	/**
	 * Create the frame.
	 */
	public Vista_cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 917, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		getContentPane().setLayout(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("New button");
		button.setBounds(0, 0, 0, 0);
		contentPane.add(button);
		
		
		nuevo_cliente.setBounds(711, 119, 180, 23);
		contentPane.add(nuevo_cliente);
		
		editar_cliente.setBounds(711, 153, 180, 23);
		contentPane.add(editar_cliente);
		

		eliminar_cliente.setBounds(711, 187, 180, 23);
		contentPane.add(eliminar_cliente);
		
		//modelo tabla 
		tabla_cliente = new JTable(modelo_tabla);
		tabla_cliente.setBounds(21, 11, 422, 292);
		contentPane.add(tabla_cliente);
	    JScrollPane scrollPane = new JScrollPane(tabla_cliente);
        scrollPane.setBounds(21, 38, 680, 292);
        contentPane.add(scrollPane);
        lblNewLabel.setBounds(21, 11, 46, 14);
        
        contentPane.add(lblNewLabel);
        gestionar_peliculas.setFont(new Font("Tahoma", Font.PLAIN, 10));
        gestionar_peliculas.setBounds(711, 38, 180, 42);
        
        contentPane.add(gestionar_peliculas);
        ver_pelicula.setBounds(752, 307, 139, 23);
        
        contentPane.add(ver_pelicula);
        ver_cliente.setBounds(711, 85, 180, 23);
        
        contentPane.add(ver_cliente);

	}

}
