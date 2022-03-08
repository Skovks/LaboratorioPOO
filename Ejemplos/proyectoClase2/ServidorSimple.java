import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class ServidorSimple {

	public static void main(String[] args) {
		try{
			System.out.println("Esperando...");
			ServerSocket servidor = new ServerSocket(2100);
			Socket cliente = servidor.accept();
			System.out.println("Cliente en línea");
			DataInputStream entrada = new DataInputStream(cliente.getInputStream());
			DataOutputStream salida = new DataOutputStream(cliente.getOutputStream()); 
			
			//Recibir mensajes del cliente
			String linea = entrada.readLine();
			System.out.println("Mensaje recibido del cliente" + linea);
			
			//Enviar mensaje al cliente 
			salida.writeBytes("Hola soy el servidor");
			
			cliente.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

}
