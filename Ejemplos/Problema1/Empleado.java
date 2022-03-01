
public class Empleado extends Persona {
	private float ingreso;

	public float getIngreso() {
		return ingreso;
	}

	public void setPromCal(float ingreso) {
		this.ingreso = ingreso;
	}
	
	public Empleado(String nombre, int fechaNac, String genero,
			String edoCivil, float ingreso) {
		super(nombre, fechaNac, genero, edoCivil);
		this.ingreso = ingreso;
	}

	public String getOcupacion() {
		return super.getOcupacion() + " empleado ";
	}
	
	

}
