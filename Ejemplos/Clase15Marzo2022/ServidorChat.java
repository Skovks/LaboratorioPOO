import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorChat 
{
	private static int port = 1001;
	public static void main(String[] args) throws IOException 
	{
		try 
		{
			ServerSocket servidor = new ServerSocket(port);
			
			Socket cliente = servidor.accept();
			
			String direccion = cliente.getInetAddress().getCanonicalHostName();
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			
			PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
			
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Esta es la consola del Servidor");
			salida.println("Aceptando conexión con " + direccion);
			
			String mensajeDelCliente;
			String mensajeConsola;
			while ((mensajeDelCliente = entrada.readLine()) != null) 
			{
				if(mensajeDelCliente.equalsIgnoreCase("ADIOS")) 
				{
					System.out.println("cliente>> " + mensajeDelCliente);
					break;
				}
				
				System.out.println("cliente>> " + mensajeDelCliente);
				System.out.print("servidor>> ");
				mensajeConsola = teclado.readLine();
				salida.println(mensajeConsola);
			}
			cliente.close();
		} 
		catch (IOException e) 
		{
			System.err.println("Falla");
			System.err.println(e);
		}
	}

}
