
public class Ejecutivo extends Empleado{
	private String descPuesto;

	public String getDesPuesto() {
		return descPuesto;
	}

	public Ejecutivo(String nombre, int fechaNac, String genero,
			String edoCivil, float ingreso, String descPuesto) {
		super(nombre, fechaNac, genero, edoCivil, ingreso);
		this.descPuesto = descPuesto;
	}

	public String getOcupacion() {
		return super.getOcupacion() + descPuesto;
	}
	
	
	
}
