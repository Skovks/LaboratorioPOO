import java.io.*;
import java.net.*;

public class server {
	public static void main(String[] args){
		try{
			ServerSocket s = new ServerSocket(1024);
			Socket entrante = s.accept();
		 
			InputStream se = entrante.getInputStream();
		  	DataInputStream in = new DataInputStream(se);
			    
		  	OutputStream so = entrante.getOutputStream();
		  	DataOutputStream out = new DataOutputStream(so);
		    
		  	out.writeUTF("Escriba ADIOS para salir");	
		    
		  	boolean terminado = false;
		  	while(!terminado){
		  		String linea = in.readUTF();
		  		out.writeUTF("Eco:  " + linea ); 
		  		if (linea.trim().equalsIgnoreCase("ADIOS"))
				terminado = true;
		  		}
		  	entrante.close();
		}
		catch(IOException e){
		e.printStackTrace();
		}
	}
}
