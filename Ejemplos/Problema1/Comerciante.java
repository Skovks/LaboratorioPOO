
public class Comerciante extends Empleado {
	private String zona;

	public String getZona() {
		return zona;
	}

	public Comerciante(String nombre, int fechaNac, String genero,
			String edoCivil, float ingreso, String zona) {
		super(nombre, fechaNac, genero, edoCivil, ingreso);
		this.zona = zona;
	}

	public String getOcupacion() {
		return super.getOcupacion() + "comerciante de la zona " +zona;
	}
	
}
