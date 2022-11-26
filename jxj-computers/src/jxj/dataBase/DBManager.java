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
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import jxj.clasesBasicas.Usuario;
import jxj.dataBase.DBManager;

import jxj.seccionDisp.Movil;
import jxj.seccionDisp.Portatil;
import jxj.seccionDisp.Sobremesa;
import jxj.seccionDisp.Tablet;

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
						+ " sensorReconocimiento integer, " + " bateria integer)");

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
				statement.executeUpdate("CREATE TABLE if not exists usuario "
						+ "(id integer, nombre string, apellidos string, usuario string, contrasenia string, email string");
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
			statement.executeUpdate("drop table if exists usuario");
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
	
	public int obtenerId(String usuario) throws DBException {
		int idUsuario = 0;
		if (!usuario.contains("@")) {
			try (PreparedStatement stmt = conn.prepareStatement(
					"SELECT id, nombre, apellidos, usuario, contrasenia, email FROM usuario WHERE usuario = ?")) {
				stmt.setString(1, usuario);
				ResultSet rs = stmt.executeQuery();
				rs.next();
				idUsuario = rs.getInt("id");

			} catch (SQLException e) {
				throw new DBException("Error obteniendo todos los usuarios'", e);
			}
		} else {
			try (PreparedStatement stmt = conn.prepareStatement(
					"SELECT id, nombre, apellidos, usuario, contrasenia, email FROM usuario WHERE email = ?")) {
				stmt.setString(1, usuario);
				ResultSet rs = stmt.executeQuery();
				rs.next();
				idUsuario = rs.getInt("id");

			} catch (SQLException e) {
				throw new DBException("Error obteniendo todos los usuarios'", e);
			}
		}

		return idUsuario;
	}
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
	
	/**
	 * Nos permite iniciar sesion en ERM
	 * 
	 * @param nomUsuario
	 * @param contrasenia
	 * @return
	 * @throws DBException
	 */
	public boolean loginUsuario(String nomUsuario, String contrasenia) throws DBException {

		boolean acceso = false;

		if (nomUsuario.contains("@")) {
			try (PreparedStatement stmt = conn.prepareStatement(
					"SELECT id, usuario, contrasenia, email FROM usuario WHERE email = ? AND contrasenia = ?")) {
				stmt.setString(1, nomUsuario);
				stmt.setString(2, contrasenia);

				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					acceso = true;
				} else {
					acceso = false;
				}

			} catch (SQLException e) {
				throw new DBException("Error obteniendo datos de la query", e);
			} 

		} else {
			try (PreparedStatement stmt = conn.prepareStatement(
					"SELECT id, usuario, contrasenia, email FROM usuario WHERE usuario = ? AND contrasenia = ?")) {
				stmt.setString(1, nomUsuario);
				stmt.setString(2, contrasenia);

				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					acceso = true;
				} else {
					acceso = false;
				}

			} catch (SQLException e) {
				throw new DBException("Error obteniendo datos de la query", e);
			}
		}

		return acceso;
	}

	/**
	 * Este metodo nos permitir� poder registrarnos como usuarios de ERM
	 * 
	 * @param u
	 * @return
	 * @throws DBException
	 */

	public boolean registrar(Usuario u) throws DBException {

		try {

			// cambiar la conexion a la nueva bd
			Connection con = initBD("jdbc:sqlite:jxj-computers/data/JXJComputers.db");
			String sql = "INSERT INTO usuario (id, nombre,	apellidos, usuario, contrasenia, email) VALUES(?,?,?,?,?,?)";

			ps = con.prepareStatement(sql);
			ps.setInt(1, u.getId());
			ps.setString(2, u.getNombre());
			ps.setString(3, u.getApellidos());
			ps.setString(4, u.getUsuario());
			ps.setString(5, u.getContrasenia());
			ps.setString(6, u.getEmail());
			

			ps.execute();
			System.out.println("Usuario registrado");
			log(Level.INFO, "Usuario registrado", null);

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log(Level.SEVERE, "Error al insertar usuario", e);
			return false;

		}

	}
/**
	 * Insertar un usuario en la base de datos
	 * 
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param usuario
	 * @param email
	 * @param contrasenia
	 * @throws DBException
	 */

	public static void insertarUsuario(String id, String nombre, String apellidos, String usuario, String email,
			String contrasenia) throws DBException {

		String s = "INSERT INTO usuario VALUES(" + id + ",'" + nombre + "','" + apellidos + "','"
				+ usuario + "','" + contrasenia + "','" + email + "')";
		Connection c = DBManager.initBD("JXJComputers.db");
		try {
			Statement st = c.createStatement();
			st.executeUpdate(s);
			cerrarBD(c, st);
			logger.log(Level.INFO, "Statement correctamente");
		} catch (SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
		}

	}
	
	public void eliminarUsuario(int idUsuario) throws DBException {
		try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM usuario WHERE id = ?")) {
			stmt.setInt(1, idUsuario);
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new DBException("No ha sido posible ejecutar la query");
		}
	}
	
	public void actualizarPassword(Usuario usuario, String newPassword) {
		//Se abre la conexi�n y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(newPassword);
		     Statement stmt = con.createStatement()) {
			//Se ejecuta la sentencia de borrado de datos
			String sql = "UPDATE Usuario SET contrasenia = '%s' WHERE id = %d;";
			
			int result = stmt.executeUpdate(String.format(sql, newPassword, usuario.getId()));
			
			System.out.println(String.format("- Se ha actulizado %d usuario", result));
		} catch (Exception ex) {
			System.err.println(String.format("* Error actualizando datos de la BBDD: %s", ex.getMessage()));
			ex.printStackTrace();						
		}		
	}
	
	/**
	 * Metodo para insertar un dispositivo en Movil
	 * 
	 * @param id
	 * @param nombre
	 * @param seccion
	 * @param marca
	 * @param fecha_fabricacion
	 * @param sistemaOperativo
	 * @param precio
	 * @param rutaFoto
	 * @throws DBException
	 */
	
	public static void insertarMovil(String id, String nombre, String seccion, String marca, String fecha_fabricacion,
			String sistemaOperativo, String precio, String rutaFoto) throws DBException {
		
		String s = "INSERT INTO Movil (id, nombre, seccion, marca, fecha_fabricacion, sistemaOperativo, precio, rutaFoto) VALUES('"
				+ id + "','" + nombre + "','" + seccion + "', '" + marca + "','" + fecha_fabricacion + "', '"
				+ sistemaOperativo + "', '" + precio + "','" + rutaFoto + "')";
		Connection c = DBManager.initBD("JXJComputers.db");
		try {
			Statement st = c.createStatement();
			st.executeUpdate(s);
			cerrarBD(c, st);
			logger.log(Level.INFO, "Statement correctamente");
		} catch (SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
		}
		
	}
	
	/**
	 * Metodo para insertar un dispositivo en Portatil
	 * 
	 * @param id
	 * @param nombre
	 * @param seccion
	 * @param marca
	 * @param fecha_fabricacion
	 * @param sistemaOperativo
	 * @param precio
	 * @param rutaFoto
	 * @throws DBException
	 */
	public static void insertarPortatil(String id, String nombre, String seccion, String marca, String fecha_fabricacion,
			String sistemaOperativo, String precio, String rutaFoto) throws DBException {
		
		String s = "INSERT INTO Portatil (id, nombre, seccion, marca, fecha_fabricacion, sistemaOperativo, precio, rutaFoto) VALUES('"
				+ id + "','" + nombre + "','" + seccion + "', '" + marca + "','" + fecha_fabricacion + "', '"
				+ sistemaOperativo + "', '" + precio + "','" + rutaFoto + "')";
		Connection c = DBManager.initBD("JXJComputers.db");
		try {
			Statement st = c.createStatement();
			st.executeUpdate(s);
			cerrarBD(c, st);
			logger.log(Level.INFO, "Statement correctamente");
		} catch (SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
		}
		
	}
	
	/**
	 * Metodo para insertar un dipositivo en Sobremesa
	 * 
	 * @param id
	 * @param nombre
	 * @param seccion
	 * @param marca
	 * @param fecha_fabricacion
	 * @param sistemaOperativo
	 * @param precio
	 * @param rutaFoto
	 * @throws DBException
	 */
	public static void insertarSobremesa(String id, String nombre, String seccion, String marca, String fecha_fabricacion,
			String sistemaOperativo, String precio, String rutaFoto) throws DBException {
		
		String s = "INSERT INTO Sobremesa (id, nombre, seccion, marca, fecha_fabricacion, sistemaOperativo, precio, rutaFoto) VALUES('"
				+ id + "','" + nombre + "','" + seccion + "', '" + marca + "','" + fecha_fabricacion + "', '"
				+ sistemaOperativo + "', '" + precio + "','" + rutaFoto + "')";
		Connection c = DBManager.initBD("JXJComputers.db");
		try {
			Statement st = c.createStatement();
			st.executeUpdate(s);
			cerrarBD(c, st);
			logger.log(Level.INFO, "Statement correctamente");
		} catch (SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
		}
		
	}
	
	/**
	 * Metodo para insertar un dispositivo en Tablet
	 * 
	 * @param id
	 * @param nombre
	 * @param seccion
	 * @param marca
	 * @param fecha_fabricacion
	 * @param sistemaOperativo
	 * @param precio
	 * @param rutaFoto
	 * @throws DBException
	 */
	public static void insertarTablet(String id, String nombre, String seccion, String marca, String fecha_fabricacion,
			String sistemaOperativo, String precio, String rutaFoto) throws DBException {
		
		String s = "INSERT INTO Tablet (id, nombre, seccion, marca, fecha_fabricacion, sistemaOperativo, precio, rutaFoto) VALUES('"
				+ id + "','" + nombre + "','" + seccion + "', '" + marca + "','" + fecha_fabricacion + "', '"
				+ sistemaOperativo + "', '" + precio + "','" + rutaFoto + "')";
		Connection c = DBManager.initBD("JXJComputers.db");
		try {
			Statement st = c.createStatement();
			st.executeUpdate(s);
			cerrarBD(c, st);
			logger.log(Level.INFO, "Statement correctamente");
		} catch (SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
		}
		
	}

	public static void disconnect() throws DBException {
		try {
			conn = initBD("JXJComputers.db");
			conn.close();
		} catch (SQLException e) {
			throw new DBException("Error cerrando la conexiÃ³n con la BD", e);
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

	public static ArrayList<String> listarDispositvos() throws DBException{
		ArrayList<String> dispositivos = new ArrayList<>();
		Connection con = initBD("JXJComputers.db");

		try (Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT nombre FROM Sobremesa");

			while (rs.next()) {
				String dispositivo = rs.getString("nombre");
				dispositivos.add(dispositivo);
			}

		} catch (SQLException e) {
			throw new DBException("Error obteniendo todos los dispositivos de Sobremesa ", e);
		}

		try (Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT nombre FROM Movil");

			while (rs.next()) {
				String dispositivo = rs.getString("nombre");
				dispositivos.add(dispositivo);
			}

		} catch (SQLException e) {
			throw new DBException("Error obteniendo todos los dispositivos de Movil", e);
		}

		try (Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT nombre FROM Portatil");

			while (rs.next()) {
				String dispositivo = rs.getString("nombre");
				dispositivos.add(dispositivo);
			}

		} catch (SQLException e) {
			throw new DBException("Error obteniendo todos los dispositivos de Portatil", e);
		}

		try (Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT nombre FROM Tablet");

			while (rs.next()) {
				String dispositivo = rs.getString("nombre");
				dispositivos.add(dispositivo);
			}

		} catch (SQLException e) {
			throw new DBException("Error obteniendo todos los dispositivos de Tablet", e);
		}

		return dispositivos;

	}
	
	public static ArrayList<Sobremesa> listarSobremesa() throws DBException  {
		ArrayList<Sobremesa> Sobremesa = new ArrayList<>();
		Connection conn = initBD("JXJComputers.db");
		String sql = "Select id, nombre, seccion, marca, fecha_fabricacion, sistemaOperativo, rutaFoto, precio, "
				+ "fuenteAlimentacion, ventilador, numPuertosUSB FROM Sobremesa";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Sobremesa Sobremesas = new Sobremesa();
				Sobremesas.setId(rs.getString("id"));
				Sobremesas.setNombre(rs.getString("nombre"));
				Sobremesas.setSeccion(rs.getString("seccion"));
				Sobremesas.setMarca(rs.getString("marca"));
				Sobremesas.setFecha_fabricacion(rs.getString("fecha_fabricacion"));
				Sobremesas.setSistemaOperativo(rs.getString("sistemaOperativo"));
				Sobremesas.setRutaFoto(rs.getString("rutaFoto"));
				Sobremesas.setPrecio(rs.getInt("precio"));
				Sobremesas.setFuenteAlimentacion(rs.getString("fuenteAlimentacion"));
				Sobremesas.setVentilador(rs.getString("ventilador"));
				if (rs.getInt("numPuertosUSB") == 1) {
					Sobremesas.setNumPuertosUSB(1);
				} else {
					Sobremesas.setNumPuertosUSB(0);
				}
				Sobremesa.add(Sobremesas);
			}

		} catch (SQLException e) {
			throw new DBException("Error obteniendo todos los dispositivos de Sobremesa", e);
		}
		return Sobremesa;
		
	}

	public static ArrayList<Movil> listarMovil() throws DBException {
		ArrayList<Movil> Movil = new ArrayList<>();
		Connection conn = initBD("JXJComputers.db");
		String sql = "Select id, nombre, seccion, marca, fecha_fabricacion, sistemaOperativo, rutaFoto, precio, "
				+ "bateria, sensorReconocimiento, tactil FROM Movil";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Movil Movils = new Movil();
				Movils.setId(rs.getString("id"));
				Movils.setNombre(rs.getString("nombre"));
				Movils.setSeccion(rs.getString("seccion"));
				Movils.setMarca(rs.getString("marca"));
				Movils.setFecha_fabricacion(rs.getString("fecha_fabricacion"));
				Movils.setSistemaOperativo(rs.getString("sistemaOperativo"));
				Movils.setRutaFoto(rs.getString("rutaFoto"));
				Movils.setPrecio(rs.getInt("precio"));
				Movils.setBateria(rs.getInt("bateria"));
				Movils.setSensorReconocimiento(rs.getString("sensorReconocimiento"));
				if (rs.getInt("tactil") == 1) {
					Movils.setTactil(true);
				} else {
					Movils.setTactil(false);
				}
				Movil.add(Movils);
			}

		} catch (SQLException e) {
			throw new DBException("Error obteniendo todos los dispositivos de Movil", e);
		}
		return Movil;
		
	}

	public static ArrayList<Portatil> listarPortatil() throws DBException{
		ArrayList<Portatil> Portatil = new ArrayList<>();
		Connection conn = initBD("JXJComputers.db");
		String sql = "Select id, nombre, seccion, marca, fecha_fabricacion, sistemaOperativo, rutaFoto, precio, "
				+ "bateria, sensorReconocimiento, tactil FROM Portatil";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Portatil Portatils = new Portatil();
				Portatils.setId(rs.getString("id"));
				Portatils.setNombre(rs.getString("nombre"));
				Portatils.setSeccion(rs.getString("seccion"));
				Portatils.setMarca(rs.getString("marca"));
				Portatils.setFecha_fabricacion(rs.getString("fecha_fabricacion"));
				Portatils.setSistemaOperativo(rs.getString("sistemaOperativo"));
				Portatils.setRutaFoto(rs.getString("rutaFoto"));
				Portatils.setPrecio(rs.getInt("precio"));
				Portatils.setTipoTeclado(rs.getString("tipoTeclado"));
				Portatils.setTouchpad(rs.getString("touchpad"));
				if (rs.getInt("webcam") == 1) {
					Portatils.setWebcam(true);
				} else {
					Portatils.setWebcam(false);
				}
				Portatil.add(Portatils);
			}

		} catch (SQLException e) {
			throw new DBException("Error obteniendo todos los dispositivos de Portatil", e);
		}
		return Portatil;
	}

	public static ArrayList<Tablet> listarTablet() throws DBException{
		ArrayList<Tablet> Tablet = new ArrayList<>();
		Connection conn = initBD("JXJComputers.db");
		String sql = "Select id, nombre, seccion, marca, fecha_fabricacion, sistemaOperativo, rutaFoto, precio, "
				+ "color, sensorReconocimiento, conectividadTeclado FROM Tablet";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Tablet Tablets = new Tablet();
				Tablets.setId(rs.getString("id"));
				Tablets.setNombre(rs.getString("nombre"));
				Tablets.setSeccion(rs.getString("seccion"));
				Tablets.setMarca(rs.getString("marca"));
				Tablets.setFecha_fabricacion(rs.getString("fecha_fabricacion"));
				Tablets.setSistemaOperativo(rs.getString("sistemaOperativo"));
				Tablets.setRutaFoto(rs.getString("rutaFoto"));
				Tablets.setPrecio(rs.getInt("precio"));
				Tablets.setColor(rs.getString("color"));
				Tablets.setPixelesCamara(rs.getInt("pixelesCamara"));
				if (rs.getInt("conectividadTeclado") == 1) {
					Tablets.setConectividadTeclado(true);
				} else {
					Tablets.setConectividadTeclado(false);
				}
				Tablet.add(Tablets);
			}

		} catch (SQLException e) {
			throw new DBException("Error obteniendo todos los dispositivos de Tablet", e);
		}
		return Tablet;
	}
	
}
