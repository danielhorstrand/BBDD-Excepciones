import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ConexionBBDD con = new ConexionBBDD();
		con.BorrarTablaPersonas();
		con.CrearTablaPersonas();

		// Pedior por pantalla los datos de Persona a insertar
		Scanner in = new Scanner(System.in);


		for (int i=0;i<2;i++) {
			System.out.println("Introduce nombre: ");
			String nombre = in.nextLine();
			System.out.println("Introduce apellido1: ");
			String apellido1 = in.nextLine();
			System.out.println("Introduce apellido2: ");
			String apellido2 = in.nextLine();
			System.out.println("Introduce email: ");
			String email = in.nextLine();
			try{
				con.InsertarPersona(nombre, apellido1, apellido2, email);
			}catch(SQLException sqle){
				int pos = sqle.getMessage().indexOf(":");
				String codeErrorSQL = sqle.getMessage().substring(0,pos);

				if(codeErrorSQL.equals("ORA-00001") )
					System.out.println("ERROR.La clave primaria ya esta en uso.!!!");
				else
					System.out.println("Ha habido algún problema con  Oracle al hacer la insercion de datos.");
				i--;
			}
		}

	}
}