	import java.sql.*;

public class ConexionBBDD {

	private String bd;
	private String url= "jdbc:oracle:thin:@localhost:1521:XE";
	private String usr = "SYSTEM";
	private String pwd = "Miro_5838";
	private Connection conexion;


	public ConexionBBDD()  {

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conexion = DriverManager.getConnection(url, usr, pwd);

				if(!conexion.isClosed()) {
					System.out.println("Conexión establecida");

					//conexion.close();
				}
				else
					System.out.println("Fallo en Conexión");


			}catch (Exception e) {
				System.out.println("ERROR en conexión con ORACLE");
				e.printStackTrace();
			}

		}


	public void CrearTablaPersonas() throws SQLException{

		//Preparo la conexión para ejecutar sentencias SQL de tipo update
		Statement stm = conexion.createStatement();

		// Preparo la sentencia SQL CrearTablaPersonas
		String createsql = "CREATE TABLE DANIEL.PERSONAS ( Nombre VARCHAR2(50), Apellido1 VARCHAR2(50), Apellido2 VARCHAR2(50), email VARCHAR2(50)CONSTRAINT PERSONAS_PK PRIMARY KEY)";

		//ejecuto la sentencia

		try{
			int resultado = stm.executeUpdate(createsql);

			if(resultado != 0)
				System.out.println("Error en la inserción " + resultado);
			else
				System.out.println("Tabla PERSONAS creada con éxito!!!");

		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			if(codeErrorSQL.equals("ORA-00955") )
				System.out.println("ERROR.la tabla PERSONAS ya estaba creada!!!");
			else
				System.out.println("Ha habido algún problema con  Oracle al hacer la creación de tabla");

		}
	}
	public void BorrarTablaPersonas() throws SQLException{
		Statement stm = conexion.createStatement();

		// Preparo la sentencia SQL CrearTablaPersonas
		String createsql = "DROP TABLE DANIEL.PERSONAS CASCADE CONSTRAINTS";

		try{
			int resultado = stm.executeUpdate(createsql);

			if(resultado != 0)
				System.out.println("Error en la eliminacion " + resultado);
			else
				System.out.println("Tabla PERSONAS no existe!!!");

		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			if(codeErrorSQL.equals("ORA-00942") )
				System.out.println("ERROR.la tabla PERSONAS no esta creada!!!");
			else
				System.out.println("Ha habido algún problema con  Oracle al hacer la creación de tabla");

		}
	}


	public void InsertarPersona(String nombre, String apellido, String apellido2, String email) throws SQLException{

		//Preparo la conexión para ejecutar sentencias SQL de tipo update
		Statement stm = conexion.createStatement();

		// Preparo la sentencia SQL CrearTablaPersonas
		String insertsql = "INSERT INTO DANIEL.PERSONAS VALUES ('" + nombre + "','" + apellido + "','" + apellido2 + "','" + email + "')";

			int resultado = stm.executeUpdate(insertsql);

			if(resultado != 1)
				System.out.println("Error en la inserción " + resultado);
			else
				System.out.println("Persona insertada con éxito!!!");

	}

}

