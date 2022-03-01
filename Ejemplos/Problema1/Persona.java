
public class Persona {
	private String nombre;
	private int fechaNac;
	private String genero;
	private String edoCivil;
	
	public Persona(String nombre, int fechaNac, String genero, String edoCivil) {
		super();
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.genero = genero;
		this.edoCivil = edoCivil;
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getFechaNac() {
		return fechaNac;
	}

	public String getGenero() {
		return genero;
	}

	public String getEdoCivil() {
		return edoCivil;
	}
	public String getOcupacion(){
		return"Mi ocupacion es...";
	}
	public String toString() {
		return "Persona [nombre=" + nombre + ", fechaNac=" + fechaNac
				+ ", genero=" + genero + ", edoCivil=" + edoCivil + "]";
	}
	
	
}
