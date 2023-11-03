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

public class Vista_cliente_peliculas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable tabla_pelicula;
	private static String[] nombre_columnas = {"id", "titulo", "director", "id_cliente"};
    public static DefaultTableModel modelo_tabla = new DefaultTableModel(nombre_columnas, 0);
    public static JLabel nombre_cliente = new JLabel("nombre cliente");
    public static JLabel direccion_cliente = new JLabel("direccion cliente");
    public static JLabel fecha_cliente = new JLabel("fecha");
	/**
	 * Create the frame.
	 */
	public Vista_cliente_peliculas() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 733, 387);
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
		tabla_pelicula.setBounds(21, 11, 422, 292);
		contentPane.add(tabla_pelicula);
	    JScrollPane scrollPane = new JScrollPane(tabla_pelicula);
        scrollPane.setBounds(21, 61, 680, 269);
        contentPane.add(scrollPane);
        

        nombre_cliente.setBounds(21, 11, 336, 14);
        contentPane.add(nombre_cliente);
        
        direccion_cliente.setBounds(21, 36, 669, 14);
        contentPane.add(direccion_cliente);
        
        fecha_cliente.setBounds(362, 11, 339, 14);
        contentPane.add(fecha_cliente);

	}
}
