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

		int contador =2;
		do {
		System.out.println("Introduce nombre: ");
		String nombre = in.nextLine();
		System.out.println("Introduce apellido1: ");
		String apellido1 = in.nextLine();
		System.out.println("Introduce apellido2: ");
		String apellido2 = in.nextLine();
		System.out.println("Introduce email: ");
		String email = in.nextLine();
		con.InsertarPersona(nombre, apellido1, apellido2, email);
		contador--;
		}while (contador!=0);

	}
}