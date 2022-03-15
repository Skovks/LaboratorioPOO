import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class ServidorWeb 
{
	  public static void main(String[] args) 
	  {
		String solicitud;
		String nombreArchivo;
		try {
			ServerSocket servidor = new ServerSocket(1024);
			while (true){	
				Socket cliente = servidor.accept();
			
				BufferedReader mensajeDelCliente = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

				DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());

				solicitud = mensajeDelCliente.readLine();
				System.out.println(solicitud);
				
				StringTokenizer lineaTokenizada = new StringTokenizer(solicitud);

				if (lineaTokenizada.nextToken().equals("GET")) 
				{
					nombreArchivo = lineaTokenizada.nextToken();
					if (nombreArchivo.startsWith("/") == true)
						nombreArchivo = nombreArchivo.substring(1);

					File file = new File(nombreArchivo);

					int numOfBytes = (int) file.length();
					FileInputStream archivo = new FileInputStream(nombreArchivo);
					byte[] fileInBytes = new byte[numOfBytes];
					archivo.read(fileInBytes);
					
					salida.writeBytes("HTTP/1.1 200 Document Follows\r\n");

					if (nombreArchivo.endsWith(".jpg"))
						salida.writeBytes("Content-Type: image/jpeg\r\n");

					if (nombreArchivo.endsWith(".gif"))
						salida.writeBytes("Content-Type: image/gif\r\n");

					if (nombreArchivo.endsWith(".mp4"))
						salida.writeBytes("Content-Type: video/mp4\r\n");
					
					salida.writeBytes("Content-Length: " + numOfBytes + "\r\n");
					salida.writeBytes("\r\n");
					salida.write(fileInBytes, 0, numOfBytes);
					cliente.close();
				} 
				else
					System.out.println("Mensaje de solicitud equivocado");
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
