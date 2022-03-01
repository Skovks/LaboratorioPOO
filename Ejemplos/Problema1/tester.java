import java.util.ArrayList;
import java.util.List;
public class tester {
	public static void main(String[] args){
		List<Persona> listaPersonas = new ArrayList<Persona>();
		
		listaPersonas.add(new Estudiante("Hugo", 1995, "Masculino", "Soltero", (float) 8.8));
		listaPersonas.add(new Ejecutivo("Gabriela Juarez", 1985, "Femenino", "Casada", (float) 12000.70, "Supervisar obras civiles"));
		listaPersonas.add(new Comerciante("Gabriela Juarez", 1985, "Femenino", "Casada", (float) 15600.50, "Estados de Guerrero y Oaxaca"));
		
		System.out.println(listaPersonas);
	}
}
