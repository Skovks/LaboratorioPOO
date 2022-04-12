import java.sql.*;
import java.util.Scanner;

public class UtileriasHorarios {
	//Imprimir tabla de horarios
		public static void imprimeTabla(Connection con){
			try{
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("Select * from Horarios");
				System.out.println("+---------------+-----------------+--------------+--------------+-------------+----------------------------------+");
				System.out.println("| ClaveHorario  |    Materia      |    Dias      |  HoraInicio  |  HoraFin    |           Profesor               |");
				System.out.println("+---------------+-----------------+--------------+--------------+-------------+----------------------------------+");		
				while (rs.next()){
					System.out.println( "|   "+rs.getString("claveHorario") + "|        " +
					rs.getString("materia") + "          " +
					rs.getString("dias")      + "         " + 
					rs.getString("horaInicio")      + "        " + 
					rs.getString("horaFin") + "      " + 
					rs.getString("profesor")+" |"
					);
				}
				System.out.println("+---------------+-----------------+--------------+--------------+-------------+----------------------------------+");
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		//Registrar nuevo horario
		public static void registraHorario(Connection con, Scanner sc){
			try{
				System.out.println ("Inserta los datos requeridos a continuacion...");
				System.out.print("Clave de horario: ");
				String entradaTeclado0 = "";
		        entradaTeclado0=sc.nextLine();
		        
		        System.out.print("Materia: ");
				String entradaTeclado1 = "";
		        entradaTeclado1 = sc.nextLine();
		        
		        System.out.print("Dias: ");
				String entradaTeclado2 = "";
		        entradaTeclado2 = sc.nextLine();
		        
		        System.out.print("Hora de inicio: ");
				String entradaTeclado3 = "";
		        entradaTeclado3 = sc.nextLine();
		        
		        System.out.print("Hora final: ");
				String entradaTeclado4 = "";
		        entradaTeclado4 = sc.nextLine();
		        
		        System.out.print("Profesor: ");
				String entradaTeclado5 = "";
		        entradaTeclado5 = sc.nextLine();
		        
		        Horario horarioR = new Horario(entradaTeclado0, entradaTeclado1, entradaTeclado2, entradaTeclado3, entradaTeclado4, entradaTeclado5);
				
		        Statement stmt = con.createStatement();
		        if(!Coincidencia(con, entradaTeclado0).equals(horarioR.getClaveHorario())) {
		        	String alta = "insert into Horarios values (\"" +
		    				horarioR.getClaveHorario() + "\",\"" + 
		    				horarioR.getMateria() + "\",\""+
		    				horarioR.getDias() + "\",\"" +
		    				horarioR.getHoraInicio() + "\",\"" +
		    				horarioR.getHoraFin() + "\",\"" +
		    				horarioR.getProfesor()+ "\")";
		    				
		    				System.out.println(alta);
		    				stmt.executeUpdate(alta);
		        }
		        else {
		        	System.out.println("La clave de horario ya existe: Porfavor ingrese uno diferente");
		        }
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		public static Horario obtenerHorario(Connection con, Scanner sc){
			System.out.print("Ingresa la clave de horario: ");
			String claveHorario = "";
	        claveHorario = sc.nextLine();
			Horario buscado = null;
			try{
		           String query = "select * from Horarios where claveHorario ='"+claveHorario+"'";
		           Statement consulta = con.createStatement();
		           ResultSet rs = consulta.executeQuery(query);
		           if(rs.next()){
		             buscado = new Horario(rs.getString("claveHorario"),
		             rs.getString("materia"),
		             rs.getString("dias"),
		             rs.getString("horaInicio"),
		             rs.getString("horaFin"),
		             rs.getString("profesor"));
		           }
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			return buscado;
		}
		
		public static String eliminarHorario(Connection con, Scanner sc){
			System.out.print("Ingresa la clave de horario: ");
			String claveHorario = "";
	        claveHorario = sc.nextLine();
			String res = "";
			try{
				String query = 
						"delete from Horarios where claveHorario = '" + claveHorario + "'";
				Statement instruc = con.createStatement();
				if(instruc.executeUpdate(query)==1) {
					res = "Horario eliminado con exito";
				}
				else {
					res= "El horario no existe, por favor ingrese un grupo existente";
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			return res;
		}
	
		public static String Coincidencia(Connection con, String clave){
			String buscado ="";
			try{
		           String query = "select * from Horarios where claveHorario ='"+clave+"'";
		           Statement consulta = con.createStatement();
		           ResultSet rs = consulta.executeQuery(query);
		           rs.next();
		           buscado = rs.getString("claveHorario");
		           
			}
			catch(SQLException e){
				buscado="diferente";
				return buscado;
			}
			return buscado;
		}

}
