
public class Ejemplo2 extends Ejemplo1 {
	
	private String genero;
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Ejemplo2(String nombre, int edad, String genero) {
		super(nombre,edad);
		this.genero=genero;
	}

	public static int suma(int a , int b){
		return a + b;
	}
	public String toString(){
		return super.toString() +", genero="+ genero;
	}
}
