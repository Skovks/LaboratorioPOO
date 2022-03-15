import java.io.*;
import java.net.*;


public class Cliente {
	public static void main(String[] args) 
	{
		
		  try
		  {	
			  
			Socket cliente = new Socket("127.0.0.1",1024);
			
		    InputStream se = cliente.getInputStream();
		    DataInputStream entrada = new DataInputStream(se);
			    
		    OutputStream so = cliente.getOutputStream();
		    DataOutputStream salida = new DataOutputStream(so);

		    String mensajeEntrada = ""; 
		    String mensajeSalida = "";
		    BufferedReader consola = new BufferedReader( 
					new InputStreamReader(System.in));
		    
		    do
		    {
		    	
		    	mensajeEntrada = entrada.readUTF();
			    System.out.println(mensajeEntrada);
				mensajeSalida = consola.readLine(); 
				salida.writeUTF(mensajeSalida);
		    	
		    }while(!mensajeSalida.equalsIgnoreCase("ADIOS"));
		    
		    
			
			
			cliente.close();

		    
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
	}
}
