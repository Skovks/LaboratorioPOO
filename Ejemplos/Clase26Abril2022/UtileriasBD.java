package paq;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UtileriasBD 
{
	//Registrar nuevos alumnos
	public static void registroPerfil(Perfil alumno, Connection con)
	{
		try
		{
			Statement stmt = con.createStatement();
			String alta = "insert into Alumnos values (\"" +
			alumno.getNombre() + "\",\"" + 
			alumno.getCorreo() + "\"," +
			alumno.getClave() + ",\"" +
                        alumno.getEdad() + ",\"" +
                        alumno.getExperiencia() + ",\"" +
                        alumno.getEspecialidad() + ",\"" +
			alumno.getInteres() + "\")";
			
			System.out.println(alta);
			stmt.executeUpdate(alta);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
}
