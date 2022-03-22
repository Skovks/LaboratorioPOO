package proyecto4;

public class alumnos {
	private String matricula;
	private String nombre;
	private int edad;
	private String genero;
	public alumnos(String matricula, String nombre, int edad, String genero) {
		super();
		this.matricula = matricula;
		this.nombre = nombre;
		this.edad = edad;
		this.genero = genero;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	@Override
	public String toString() {
		return "alumnos [matricula=" + matricula + ", nombre=" + nombre
				+ ", edad=" + edad + ", genero=" + genero + "]";
	}
	
}
