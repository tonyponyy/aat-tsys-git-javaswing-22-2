package models;

import java.util.List;

import mysql.Conection;

public class Pelicula {
	static Conection conexion = new Conection();
	private String ATRIBUTOS = "title,director";
	private static String DATABASE_NAME = "clientes";
	private static String TABLE_NAME = "videos";
	
	public List<Object[]> mostrar_todos() {
		conexion.usar_esquema(DATABASE_NAME);
		return conexion.mostrar_tabla(TABLE_NAME);
	}
	
	public List<Object[]> mostrar_peliculas_cliente(String id) {
		conexion.usar_esquema(DATABASE_NAME);
		return conexion.mostrar_tabla(TABLE_NAME+" where cli_id = '"+id+"'");
	}
	
	public List<Object[]> mostrar_peliculas_sin_vincular() {
		conexion.usar_esquema(DATABASE_NAME);
		return conexion.mostrar_tabla(TABLE_NAME+" where cli_id is null");
	}
	
	public boolean guardar(String title,String director) {
		conexion.usar_esquema(DATABASE_NAME);
		if (conexion.agregar_registro(TABLE_NAME, ATRIBUTOS, "'"+title+"','"+director+"'")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean borrar(String id) {
		conexion.usar_esquema(DATABASE_NAME);
		if (conexion.ejecuta_sentencia("delete from "+TABLE_NAME+" where id ="+id)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean editar(String id,String title,String director) {
		conexion.usar_esquema(DATABASE_NAME);
		if (conexion.ejecuta_sentencia("update "+TABLE_NAME+" set title ='"+title+"',director ='"+director+"' where id="+id)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean aniadir_cliente(String id,String cliente_id) {
		conexion.usar_esquema(DATABASE_NAME);
		if (conexion.ejecuta_sentencia("update "+TABLE_NAME+" set cli_id ="+cliente_id+" where id="+id)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean quitar_cliente(String id) {
		conexion.usar_esquema(DATABASE_NAME);
		if (conexion.ejecuta_sentencia("update "+TABLE_NAME+" set cli_id = null where id="+id)) {
			return true;
		}else {
			return false;
		}
	}
	


}
