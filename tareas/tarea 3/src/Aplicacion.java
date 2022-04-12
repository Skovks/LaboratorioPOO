import java.sql.*;
import java.util.Scanner;

public class Aplicacion {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		try
		{
			int opcion=0;
			String entradaTeclado = "";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Horario","skovks", "skovksskovks");
			System.out.println ("Conexion a base de datos exitosa...");
			while(opcion!=5){
				System.out.println ("Teclee el numero de la opcion \n 1.-Impresion de horarios \n 2.-Registro de horario \n 3.-Busqueda de horario \n 4.-Eliminacion de horario \n 5.-salir");
				System.out.print("Opcion: ");
		        entradaTeclado = sc.nextLine();
		        if (entradaTeclado.matches("[+-]?\\d*(\\.\\d+)?")==true){
		        	opcion = Integer.parseInt(entradaTeclado);
			        switch (opcion){
			            case 1:  UtileriasHorarios.imprimeTabla(con);
			                     break;
			            case 2:  UtileriasHorarios.registraHorario(con,sc);
			                     break;
			            case 3:  System.out.println(UtileriasHorarios.obtenerHorario(con,sc)); 
			                     break;
			            case 4:  System.out.println(UtileriasHorarios.eliminarHorario(con,sc));
			                     break;
			            case 5: System.out.println("Programa finalizado");
	                    		break;
			            default: System.out.println("Opcion invalida: Elige un numero valido");
			                     break;
			        }
		        }
		        else{
		        	System.out.println("Opcion invalida: Elige un numero valido");
		        }   
			}
		    sc.close();
		}
		
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}

	}

}
