import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ClienteSimple {

	public static void main(String[] args){
		try{
			Socket conexionServ = new Socket("localhost", 2100);
			DataInputStream entrada = new DataInputStream(conexionServ.getInputStream());
			DataOutputStream salida = new DataOutputStream(conexionServ.getOutputStream());
			
			salida.writeBytes("Hola Soy tu cliente");
			String mensajeRecibido=entrada.readLine();
			System.out.println("Mensaje recibido por parte del servidor: " + mensajeRecibido);
			conexionServ.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

}
