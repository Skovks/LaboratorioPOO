
/* ChatClient.java */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

class ClienteChat
{ 
	private static int port = 1001; 
	private static String host = "localhost"; 
	public static void main (String[] args) throws IOException 
	{ 
		try 
		{
			System.out.println("Esta es la consola del cliente");
			Socket server = new Socket(host, port);//Solicitar comunicación con el servidor
			PrintWriter salida = new PrintWriter(server.getOutputStream(), true);
			BufferedReader entrada = new BufferedReader(new InputStreamReader(server.getInputStream()));
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

			String mensajeServidor;
			String mensajeConsola;
			while ((mensajeServidor = entrada.readLine()) != null) 
			{
				System.out.println("servidor>> " + mensajeServidor);
				System.out.print("cliente>> ");
				mensajeConsola = teclado.readLine();
				salida.println(mensajeConsola);
			}
		} 
		catch (UnknownHostException e) 
		{
			System.err.println("Falla");
			System.err.println(e);
		}
	} 
}
