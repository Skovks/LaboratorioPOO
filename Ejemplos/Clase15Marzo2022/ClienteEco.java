import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteEco 
{
	public static void main(String[] args) 
	{
		  try
		  {	
			Socket servidor = new Socket("127.0.0.1",1024);
		    DataInputStream entrada = new DataInputStream(servidor.getInputStream());
		    DataOutputStream salida = new DataOutputStream(servidor.getOutputStream());
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
		    	
			servidor.close();    
		  }
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
}
