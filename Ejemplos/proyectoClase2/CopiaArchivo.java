import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class CopiaArchivo {
	public static void main(String[] args){
		File archEntrada=new File("Archivos/MiArchivo.txt");
		File archSalida=new File("Archivos/Copiado.txt");
		try{
			FileReader in= new FileReader(archEntrada);
			FileWriter out= new FileWriter(archSalida);
			int caracter;
			
			while((caracter = in.read()) != -1){
				out.write(caracter);
			}
			in.close();
			out.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

}
