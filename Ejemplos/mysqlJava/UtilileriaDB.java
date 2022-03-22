package proyecto4;

import java.sql.*;

public class UtilileriaDB {
	//Registrar nuevos alumnos
	public static void registraAlumno(alumnos alumno, Connection con){
		try{
			Statement stmt=con.createStatement();
			String alta="insert into alumnos VALUES(\""+
			alumno.getMatricula() + "\",\"" +
			alumno.getNombre()+"\","+
			alumno.getEdad()+",\""+
			alumno.getGenero()+"\")";
			System.out.println(alta);
			stmt.executeUpdate(alta);
			
		}
		catch(SQLException ex){
			System.err.println(ex.getMessage());
		}
	}
	//imprimir toda la tabla
	public static void imprimeTablaAlumnos(Connection con){
		try{
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery ("Select * from alumnos");
			System.out.println("Nombre Edad Genero");
			while (rs.next()){
				System.out.println (
				rs.getString("Matricula")+ " " +
				rs.getString("nombre") + " " +
				rs.getInt("edad") + " " +
				rs.getString("genero") );
			}
		}
		catch(SQLException ex){
			System.err.println(ex.getMessage());
		}
	}
	//eliminar alumnos
	public String eliminaRegistro(String matricula){
		
		String res="";
		return res;
	}
	
	
}
