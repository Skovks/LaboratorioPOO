package proyecto4;
import java.sql.*;

public class Pruebaconexion {

	public static void main(String[] args) throws SQLException {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "usuariotabla", "pass1234");
			UtilileriaDB.imprimeTablaAlumnos(con);
			alumnos nuevo=
					new alumnos("9656256","juan lopez",22,"masculino");
			UtilileriaDB.registraAlumno(nuevo, con);
			UtilileriaDB.imprimeTablaAlumnos(con);
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(SQLException ex){
			System.err.println(ex.getMessage());
		}
	}

}
