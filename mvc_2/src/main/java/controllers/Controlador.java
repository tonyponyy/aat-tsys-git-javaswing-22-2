package controllers;

import views.Vista_cliente;
import views.Vista_cliente_nuevo;
import views.Vista_cliente_peliculas;
import views.Vista_gestion_peliculas;
import views.Vista_pelicula;
import views.Vista_pelicula_nueva;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import models.Cliente;
import models.Pelicula;

public class Controlador {
	String id_cliente_temp = "0";
	String id_pelicula_temp = "0";
	Cliente clientes = new Cliente();
	Pelicula peliculas = new Pelicula();
	Vista_gestion_peliculas vista_gestion_peliculas = new Vista_gestion_peliculas();
	Vista_pelicula_nueva vista_pelicula_nueva = new Vista_pelicula_nueva();
	Vista_cliente_peliculas vista_cliente_peliculas = new Vista_cliente_peliculas();
	Vista_cliente_nuevo vista_nuevo = new Vista_cliente_nuevo();
	Vista_pelicula vista_pelicula = new Vista_pelicula();
	

	public Controlador() {
		inicio();

	}

	private void aniadir_fila_cliente() {
		List<Object[]> filas = (List<Object[]>) clientes.mostrar_todos();
		for (Object[] fila : filas) {
			Vista_cliente.modelo_tabla.addRow(fila);
		}
	}
	
	private void aniadir_fila_pelicula() {
		List<Object[]> filas = (List<Object[]>) peliculas.mostrar_todos();
		for (Object[] fila : filas) {
			Vista_pelicula.modelo_tabla.addRow(fila);
		}
	}

	private void inicio() {
		try {
			Vista_cliente.ver_cliente.addActionListener(ver_clientes);
			Vista_cliente.nuevo_cliente.addActionListener(nuevo_clientes);
			Vista_cliente.eliminar_cliente.addActionListener(borrar_clientes);
			Vista_cliente.editar_cliente.addActionListener(editar_clientes);
			Vista_cliente.ver_pelicula.addActionListener(ver_peliculas);
			Vista_cliente.gestionar_peliculas.addActionListener(gestonar_peliculas);
			Vista_cliente frame = new Vista_cliente();
			// vista peliculas
			Vista_pelicula.eliminar_pelicula.addActionListener(eliminar_peliculas);
			Vista_pelicula.nueva_pelicula.addActionListener(nueva_peliculas);
			Vista_pelicula.editar_pelicula.addActionListener(editar_peliculas);
			//vista gestion peliculas
			Vista_gestion_peliculas.aniadir_pelicula_cliente.addActionListener(nueva_pelicula_cliente);
			Vista_gestion_peliculas.eliminar_pelicula_cliente.addActionListener(eliminar_pelicula_cliente);
			
			aniadir_fila_cliente();
			aniadir_fila_pelicula();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void ver_pelicula() {
		
		vista_pelicula.setVisible(true);
	}
	private void ver_cliente() {
		
		try {
			int pos = Vista_cliente.tabla_cliente.getSelectedRow();
			int id = (int) Vista_cliente.tabla_cliente.getValueAt(pos, 0);
			String nombre = Vista_cliente.tabla_cliente.getValueAt(pos, 1) + "";
			String apellidos =Vista_cliente.tabla_cliente.getValueAt(pos, 2) + "";
			String dni = Vista_cliente.tabla_cliente.getValueAt(pos, 4) + "";
			String direccion = Vista_cliente.tabla_cliente.getValueAt(pos, 3) + "";
			String fecha = Vista_cliente.tabla_cliente.getValueAt(pos, 5) + "";
			
			vista_cliente_peliculas.nombre_cliente.setText("Nombre: "+nombre+" "+apellidos+" ("+dni+")");
			vista_cliente_peliculas.fecha_cliente.setText("Dado de alta en: "+fecha);
			vista_cliente_peliculas.direccion_cliente.setText("Direccion: "+direccion);
			vista_cliente_peliculas.modelo_tabla.setRowCount(0);
			List<Object[]> filas = (List<Object[]>) peliculas.mostrar_peliculas_cliente(id+"");
			for (Object[] fila : filas) {
				vista_cliente_peliculas.modelo_tabla.addRow(fila);
			}
			
			vista_cliente_peliculas.setVisible(true);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Seleccione una opción");
		}

	}

	private void nuevo_cliente() {
		resetear_boton_guardar();
		resetear_nombres();
		Vista_cliente_nuevo.guardar.addActionListener(guardar_clientes);
		vista_nuevo.setVisible(true);
	}

	private void resetear_boton_guardar() {
		Vista_pelicula_nueva.guardar.removeActionListener(guardar_peliculas);
		Vista_pelicula_nueva.guardar.removeActionListener(update_peliculas);
		Vista_cliente_nuevo.guardar.removeActionListener(guardar_clientes);
		Vista_cliente_nuevo.guardar.removeActionListener(update_cliente);
	}

	private void editar_cliente() {
		try {
			resetear_boton_guardar();
			Vista_cliente_nuevo.guardar.addActionListener(update_cliente);
			int pos = Vista_cliente.tabla_cliente.getSelectedRow();
			int id = (int) Vista_cliente.tabla_cliente.getValueAt(pos, 0);
			id_cliente_temp = id + "";
			vista_nuevo.nombre.setText(Vista_cliente.tabla_cliente.getValueAt(pos, 1) + "");
			vista_nuevo.apellidos.setText(Vista_cliente.tabla_cliente.getValueAt(pos, 2) + "");
			vista_nuevo.dni.setText(Vista_cliente.tabla_cliente.getValueAt(pos, 4) + "");
			vista_nuevo.direccion.setText(Vista_cliente.tabla_cliente.getValueAt(pos, 3) + "");
			vista_nuevo.fecha.setText(Vista_cliente.tabla_cliente.getValueAt(pos, 5) + "");
			vista_nuevo.setVisible(true);
			vista_nuevo.fecha.getText();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Seleccione una opción");
		}
	}

	private void resetear_nombres() {
		vista_nuevo.nombre.setText("nombre");
		vista_nuevo.apellidos.setText("apellidos");
		vista_nuevo.dni.setText("dni");
		vista_nuevo.direccion.setText("direccion");
		vista_nuevo.fecha.setText("fecha");
	}
	
	private void resetear_peliculas() {
		vista_pelicula_nueva.titulo_pelicula.setText("Titulo");
		vista_pelicula_nueva.director.setText("Director");
	}

	private void update_cliente() {
		String nombre = vista_nuevo.nombre.getText();
		String apellidos = vista_nuevo.apellidos.getText();
		String dni = vista_nuevo.dni.getText();
		String direccion = vista_nuevo.direccion.getText();
		String fecha = vista_nuevo.fecha.getText();
		if (Cliente.editar(id_cliente_temp, nombre, apellidos, dni, direccion, fecha)) {
			JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
			actualizar_index();
			vista_nuevo.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "Revise los valores y intentelo de nuevo");
		}
	}
	
	private void update_pelicula() {
		String titulo = vista_pelicula_nueva.titulo_pelicula.getText();
		String director = vista_pelicula_nueva.director.getText();
		if (peliculas.editar(id_pelicula_temp,titulo, director)) {
			JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
			actualizar_index();
			vista_pelicula_nueva.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "Revise los valores y intentelo de nuevo");
		}
	}

	private void guardar_cliente() {
		String nombre = vista_nuevo.nombre.getText();
		String apellidos = vista_nuevo.apellidos.getText();
		String dni = vista_nuevo.dni.getText();
		String direccion = vista_nuevo.direccion.getText();
		String fecha = vista_nuevo.fecha.getText();
		if (clientes.guardar(nombre, apellidos, dni, direccion, fecha)) {
			JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
			actualizar_index();
			vista_nuevo.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "Revise los valores y intentelo de nuevo");
		}
	}
	
	private void guardar_pelicula() {
		String titulo = vista_pelicula_nueva.titulo_pelicula.getText();
		String director = vista_pelicula_nueva.director.getText();
		if (peliculas.guardar(titulo, director)) {
			JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
			actualizar_index();
			vista_pelicula_nueva.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "Revise los valores y intentelo de nuevo");
		}
	}

	private void actualizar_index() {
		Vista_cliente.modelo_tabla.setRowCount(0);
		Vista_pelicula.modelo_tabla.setRowCount(0);
		aniadir_fila_cliente();
		aniadir_fila_pelicula();
	}

	private void borrar_cliente() {

		try {
		int pos = Vista_cliente.tabla_cliente.getSelectedRow();
		int id = (int) Vista_cliente.tabla_cliente.getValueAt(pos, 0);
		if (Cliente.borrar(id + "")) {
			actualizar_index();
			JOptionPane.showMessageDialog(null, "Registro con id " + id + " borrado");
		} else {
			JOptionPane.showMessageDialog(null, "Error al borrar el registro");
		}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Seleccione una opción");
		}
	}

	
	private void borrar_pelicula() {
		try {
			int pos = Vista_pelicula.tabla_pelicula.getSelectedRow();
			int id = (int) Vista_pelicula.tabla_pelicula.getValueAt(pos, 0);
			if (Pelicula.borrar(id + "")) {
				actualizar_index();
				JOptionPane.showMessageDialog(null, "Registro con id " + id + " borrado");
			} else {
				JOptionPane.showMessageDialog(null, "Error al borrar el registro");
			}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Seleccione una opción");
			}
		
	}
	
	private void nueva_pelicula() {
		resetear_boton_guardar();
		resetear_peliculas();
		Vista_pelicula_nueva.guardar.addActionListener(guardar_peliculas);
		vista_pelicula_nueva.setVisible(true);
		
	}
	private void editar_pelicula() {
		
		try {
			int pos = Vista_pelicula.tabla_pelicula.getSelectedRow();
			int id = (int) Vista_pelicula.tabla_pelicula.getValueAt(pos, 0);
			resetear_boton_guardar();
			resetear_peliculas();
			Vista_pelicula_nueva.guardar.addActionListener(update_peliculas);
			id_pelicula_temp = id + "";
			vista_pelicula_nueva.titulo_pelicula.setText(vista_pelicula.tabla_pelicula.getValueAt(pos, 1) + "");
			vista_pelicula_nueva.director.setText(vista_pelicula.tabla_pelicula.getValueAt(pos, 2) + "");		
			vista_pelicula_nueva.setVisible(true);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Seleccione una opción");
		}
	}
	
	private void gestionar_pelicula() {
		
		try {
			int pos = Vista_cliente.tabla_cliente.getSelectedRow();
			int id = (int) Vista_cliente.tabla_cliente.getValueAt(pos, 0);
			String nombre = Vista_cliente.tabla_cliente.getValueAt(pos, 1) + "";
			String apellidos =Vista_cliente.tabla_cliente.getValueAt(pos, 2) + "";
			String dni = Vista_cliente.tabla_cliente.getValueAt(pos, 4) + "";
			String direccion = Vista_cliente.tabla_cliente.getValueAt(pos, 3) + "";
			String fecha = Vista_cliente.tabla_cliente.getValueAt(pos, 5) + "";
			
			vista_gestion_peliculas.nombre_cliente.setText("Nombre: "+nombre+" "+apellidos+" ("+dni+")");
			vista_gestion_peliculas.fecha_cliente.setText("Dado de alta en: "+fecha);
			vista_gestion_peliculas.direccion_cliente.setText("Direccion: "+direccion);
			vista_gestion_peliculas.modelo_tabla.setRowCount(0);
			id_cliente_temp = id+"";
			actualizar_vista_gestion();
			vista_gestion_peliculas.setVisible(true);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Seleccione una opción");
		}
		
	}
	
	private void eliminar_pelicula_cliente() {
		try {
			int pos = Vista_gestion_peliculas.tabla_pelicula.getSelectedRow();
			int id = (int) Vista_gestion_peliculas.tabla_pelicula.getValueAt(pos, 0);
			if (Pelicula.quitar_cliente(id+"")) {
			JOptionPane.showMessageDialog(null, "Operación realizada correctamente");	
			actualizar_vista_gestion();	
			}else {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error");	
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Seleccione una opción");
		}
	}
	
	private void nueva_pelicula_cliente() {
		try {
			int pos = Vista_gestion_peliculas.tabla_pelicula2.getSelectedRow();
			int id = (int) Vista_gestion_peliculas.tabla_pelicula2.getValueAt(pos, 0);
			if (Pelicula.aniadir_cliente(id+"", id_cliente_temp)) {
			JOptionPane.showMessageDialog(null, "Operación realizada correctamente");	
			actualizar_vista_gestion();	
			}else {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error");	
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Seleccione una opción");
		}
	}
	
	private void actualizar_vista_gestion() {
		vista_gestion_peliculas.modelo_tabla.setRowCount(0);
		List<Object[]> filas = (List<Object[]>) peliculas.mostrar_peliculas_cliente(id_cliente_temp);
		for (Object[] fila : filas) {
			vista_gestion_peliculas.modelo_tabla.addRow(fila);
		}
		vista_gestion_peliculas.modelo_tabla2.setRowCount(0);
		List<Object[]> filas_sin_vincular = (List<Object[]>) peliculas.mostrar_peliculas_sin_vincular();
		for (Object[] fila : filas_sin_vincular) {
			vista_gestion_peliculas.modelo_tabla2.addRow(fila);
		}
		
	}
	
	//action listeners
	
	ActionListener borrar_clientes = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			borrar_cliente();
		}
	};
	
	ActionListener ver_peliculas = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ver_pelicula();
		}
	};


	ActionListener nuevo_clientes = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			nuevo_cliente();
		}
	};

	ActionListener guardar_clientes = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			guardar_cliente();
		}
	};

	ActionListener editar_clientes = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			editar_cliente();
		}
	};

	ActionListener update_cliente = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			update_cliente();
		}
	};
	
	ActionListener ver_clientes = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ver_cliente();
		}
	};

	ActionListener eliminar_peliculas = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			borrar_pelicula();
		}
	};
	
	ActionListener nueva_peliculas = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			nueva_pelicula();
		}
	};
	ActionListener editar_peliculas = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			editar_pelicula();
		}
	};
	
	ActionListener guardar_peliculas = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			guardar_pelicula();
		}
	};
	
	ActionListener update_peliculas = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			update_pelicula();
		}
	};
	
	ActionListener gestonar_peliculas = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			gestionar_pelicula();
		}
	};

	ActionListener eliminar_pelicula_cliente = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			eliminar_pelicula_cliente();
		}
	};
	ActionListener nueva_pelicula_cliente = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			nueva_pelicula_cliente();
		}
	};
	


	
	
	
}


