import java.io.FileInputStream;
import java.io.IOException;
public class LeeArchivos {

	public static void main(String[] args) {
		try{
			FileInputStream archivoEntrada = new FileInputStream("Archivos/MiArchivo.txt");
			byte [] lecturaBytes = new byte[50];
			int numBytesLeidos;
			int cont = 0;
			do{
				numBytesLeidos = archivoEntrada.read(lecturaBytes);
				System.out.write(lecturaBytes, 0, numBytesLeidos);
				cont++;
			}while(numBytesLeidos == lecturaBytes.length);
			archivoEntrada.close();
			System.out.println("\nNumero de iteraciones: " + cont);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		

	}

}
