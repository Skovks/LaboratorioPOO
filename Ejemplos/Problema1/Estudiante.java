
public class Estudiante extends Persona{
	private float promCal;

	public float getPromCal() {
		return promCal;
	}

	public Estudiante(String nombre, int fechaNac, String genero,
			String edoCivil, float promCal) {
		super(nombre, fechaNac, genero, edoCivil);
		this.promCal = promCal;
	}

	public String getOcupacion() {
		return super.getOcupacion() + "estudiante";
	}
	
}
