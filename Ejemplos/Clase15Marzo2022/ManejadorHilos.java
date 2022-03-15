import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ManejadorHilos implements Runnable
{
	private Socket entrante;
	private int contador;

	public ManejadorHilos(Socket cliente, int clienteId) 
	{
		this.entrante = cliente;
		this.contador = clienteId;
	}

	public void run() 
	{
		try 
		{
			DataInputStream entrada = new DataInputStream(entrante.getInputStream());
			DataOutputStream salida = new DataOutputStream(entrante.getOutputStream());
			
			salida.writeUTF("Escriba ADIOS para salir");
			
			boolean terminado = false;
			while (!terminado) 
			{
				String linea = entrada.readUTF();
				System.out.println("El cliente num " + contador + ", me dijo: " + linea);
				salida.writeUTF("Eco:  " + linea);
				if (linea.trim().equals("ADIOS"))
					terminado = true;
			}
			entrante.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
