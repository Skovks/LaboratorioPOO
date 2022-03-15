import java.io.*;
import java.net.*;

public class ServidorEcoHilos 
{
	public static void main(String[] args) 
	{
		try 
		{
			int clienteId = 1;
			ServerSocket servidor = new ServerSocket(1024);
			while (true) 
			{
				Socket cliente = servidor.accept();
				System.out.println("Generando hilo " + clienteId);
				Runnable proceso = new ManejadorHilos(cliente, clienteId);
				Thread hilo = new Thread(proceso);
				hilo.start();
				clienteId++;
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
