package jxj.dataBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import jxj.clasesBasicas.Usuario;
import jxj.dataBase.DBException;
import jxj.dataBase.DBManager;

public class DBManager {
	
	private static Connection conn = null;
	private static Logger logger = Logger.getLogger(DBManager.class.getName());
	private static boolean LOGGING = true;
	private static PreparedStatement ps = null;
	private static Properties properties = new Properties();
	
	/**
	 * Inicializa una BD SQLITE y devuelve una conexion con ella
	 * 
	 * @param nombre Nombre de fichero de la base de datos
	 * @return Conexion con la base de datos indicada. Si hay algún error, se
	 *         devuelve null 
	 * @throws DBException Excepcion de la BD
	 */
	
	public static Connection initBD(String nombre) throws DBException {
		try {
		      properties.load(new FileInputStream(new File("config.properties")));
		    } catch (FileNotFoundException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    } catch (IOException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    } 
		try {
			Class.forName(properties.getProperty("DRIVER"));		
			conn = DriverManager.getConnection(properties.getProperty("jdbc"));
			return conn;
		} catch (ClassNotFoundException e) {
			throw new DBException("Error cargando el driver de la BD", e);
		} catch (SQLException e) {
			throw new DBException("Error conectando a la BD", e);
		}
	}

	/**
	 * Crea las tablas de la base de datos. Si ya existen, las deja tal cual.
	 * Devuelve un statement para trabajar con esa base de datos.
	 * 
	 * @param con Conexión ya creada y abierta a la base de datos
	 * @return sentencia de trabajo si se crea correctamente, null si hay cualquier
	 *         error
	 * @throws DBException
	 */
	
	public static Statement usarCrearTablasBD(Connection con) throws DBException {

		// statement.executeUpdate : Cuando queramos hacer create, insert, delete,
		// update, drop
		// statement.executeQuery : Cuando queramos hacer select

		logger.log(Level.INFO, "Creando tablas...");
		try {
			Statement statement = con.createStatement();
			try {
				statement.executeUpdate("create table if not exists Dispositivo " + "(id string, " + " nombre string, "
						+ " seccion string, " + " marca string, " + " fecha_fabricacion string, "
						+ " sistemaOperativo string," + " precio double," + " rutaFoto string");

			} catch (SQLException ex) {
				logger.log(Level.WARNING, "Tabla Dispositivo ya existente");
				throw new DBException("Error creando tabla de Dispositivo a la BD", ex);
			} // Si la tabla ya existe, no hacemos nada

			try {
				statement.executeUpdate("create table if not exists Movil " + "(id String, " + " nombre string, "
						+ " seccion string, " + " marca string, " + " fecha_fabricacion string, "
						+ " sistemaOperativo string," + " precio double," + " rutaFoto string," + " tactil integer,"
						+ " sensorReconocimiento string, " + " bateria integer)");

			} catch (SQLException ex) {
				logger.log(Level.WARNING, "Tabla Movil ya existente");
				throw new DBException("Error creando tabla de Movil a la BD", ex);

			} // Si la tabla ya existe, no hacemos nada

			try {
				statement.executeUpdate("create table if not exists Portatil " + "(id String, " + " nombre string, "
						+ " seccion string, " + " marca string, " + " fecha_fabricacion string, "
						+ " sistemaOperativo string," + " precio double," + " rutaFoto string," + " webcam integer,"
						+ " tipoTeclado string, " + " touchpad string)");

			} catch (SQLException ex) {
				logger.log(Level.WARNING, "Tabla Portatil ya existente");
				throw new DBException("Error creando tabla de Portatil a la BD", ex);

			} // Si la tabla ya existe, no hacemos nada

			try {
				statement.executeUpdate("create table if not exists Sobremesa " + "(id String, " + " nombre string, "
						+ " seccion string, " + " marca string, " + " fecha_fabricacion string, "
						+ " sistemaOperativo string," + " precio double," + " rutaFoto string," + " fuenteAlimentacion string,"
						+ " ventilador string,"+ " numPuertosUSB integer)");
			} catch (SQLException ex) {
				logger.log(Level.WARNING, "Tabla Sobremesa ya existente");
				throw new DBException("Error creando tabla de Sobremesa a la BD", ex);

			} // Si la tabla ya existe, no hacemos nada

			try {
				statement.executeUpdate("create table if not exists Tablet " + "(id String, " + " nombre string, "
						+ " seccion string, " + " marca string, " + " fecha_fabricacion string, "
						+ " sistemaOperativo string," + " precio double," + " rutaFoto string," + " color string,"
						+ " conectividadTeclado integer," + " pixelesCamara integer)");
			} catch (SQLException ex) {
				logger.log(Level.WARNING, "Tabla Tablet ya existente");
				throw new DBException("Error creando tabla de Tablet a la BD", ex);

			} // Si la tabla ya existe, no hacemos nada

			try {
				statement.executeUpdate("CREATE TABLE if not exists Usuario "
						+ "(id integer, nombre String, apellidos string, usuario string, contrasenia string, email string");
			} catch (SQLException ex) {
				logger.log(Level.WARNING, "Tabla Usuario ya existente");
				throw new DBException("Error creando tabla de Usuarios a la BD", ex);
			} // Si la tabla ya existe, no hacemos nada

			/*try {
				statement.executeUpdate("CREATE TABLE if not exists opinion "
						+ "(idUsuario INTEGER PRIMARY KEY AUTOINCREMENT, titulo string, descripcion string");
			} catch (SQLException ex) {
				logger.log(Level.WARNING, "Tabla Opinion ya existente");
				throw new DBException("Error creando tabla de Ventas a la BD", ex);
			} // Si la tabla ya existe, no hacemos nad*/

			return statement;
		} catch (SQLException e) {
			return null;
		}
	} 
	
	/**
	 * Reinicia en blanco las tablas de la base de datos. UTILIZAR ESTE MËTODO CON
	 * PRECAUCIÓN. Borra todos los datos que hubiera ya en las tablas
	 * 
	 * @param con Conexión ya creada y abierta a la base de datos
	 * @return sentencia de trabajo si se borra correctamente, null si hay cualquier
	 *         error
	 * @throws DBException
	 */
	public static Statement reiniciarBD(Connection con) throws DBException {
		logger.log(Level.INFO, "Reiniciando la base de datos...");

		try {
			Statement statement = con.createStatement();
			statement.executeUpdate("drop table if exists Dispositivo");
			statement.executeUpdate("drop table if exists Movil");
			statement.executeUpdate("drop table if exists Portatil");
			statement.executeUpdate("drop table if exists Sobremesa");
			statement.executeUpdate("drop table if exists Tablet");
			statement.executeUpdate("drop table if exists Usuario");
			//statement.executeUpdate("drop table if exists opinion");
			return usarCrearTablasBD(con);
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "No se ha podido reiniar la base de datos");
			throw new DBException("Error al reiniciar la BD", e);

		}
	}

	/**
	 * Logging
	 * 
	 * @param level
	 * @param msg
	 * @param exception
	 */
	private static void log(Level level, String msg, Throwable exception) {
		if (!LOGGING) {
			return;
		}
		if (logger == null) {
			logger = Logger.getLogger(DBManager.class.getName());
			logger.setLevel(level.ALL);
		}
		if (exception == null) {
			logger.log(level, msg);
		} else {
			logger.log(level, msg, exception);
		}
	}
	/**
	 * Busca el usuario por su id
	 * 
	 * @param id
	 * @return
	 * @throws DBException
	 */
	public Usuario buscarUsuarioId(int id) throws DBException {
		try (PreparedStatement stmt = conn.prepareStatement(
				"SELECT id, nombre, apellidos, usuario, contrasenia, email FROM usuario WHERE id = ?")) {
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellidos(rs.getString("apellidos"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setContrasenia(rs.getString("contrasenia"));
				usuario.setEmail(rs.getString("email"));
				return usuario;

			} else {
				return new Usuario();
			}
		} catch (SQLException e) {
			throw new DBException("Error obteniendo el usuario con id " + id, e);
		}
	}
	
	public static void cerrarBD(Connection con, Statement st) {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
			logger.log(Level.INFO, "Se ha cerrado correctamente");
		} catch (SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
		}
	}

	public static void insertarMovil(String id, String nombre, String seccion, String marca, String fecha_fabricacion,
			String sistema_operativo, String precio, String rutaFoto) {
		// TODO Auto-generated method stub
		
	}

	public static void insertarPortatil(String id, String nombre, String seccion, String marca,
			String fecha_fabricacion, String sistema_operativo, String precio, String rutaFoto) {
		// TODO Auto-generated method stub
		
	}

	public static void insertarSobremesa(String id, String nombre, String seccion, String marca,
			String fecha_fabricacion, String sistema_operativo, String precio, String rutaFoto) {
		// TODO Auto-generated method stub
		
	}

	public static void insertarTablet(String id, String nombre, String seccion, String marca, String fecha_fabricacion,
			String sistema_operativo, String precio, String rutaFoto) {
		// TODO Auto-generated method stub
		
	}

	

	


}
