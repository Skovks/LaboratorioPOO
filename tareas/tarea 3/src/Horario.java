
public class Horario {
	private String claveHorario;
	private String materia;
	private String dias;
	private String horaInicio;
	private String horaFin;
	private String profesor;
	public Horario(String claveHorario, String materia, String dias, String horaInicio, String horaFin,
			String profesor) {
		super();
		this.claveHorario = claveHorario;
		this.materia = materia;
		this.dias = dias;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.profesor = profesor;
	}
	public String getClaveHorario() {
		return claveHorario;
	}
	public void setClaveHorario(String claveHorario) {
		this.claveHorario = claveHorario;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public String getDias() {
		return dias;
	}
	public void setDias(String dias) {
		this.dias = dias;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	@Override
	public String toString() {
		return "Horario [claveHorario=" + claveHorario + ", materia=" + materia + ", dias=" + dias + ", horaInicio="
				+ horaInicio + ", horaFin=" + horaFin + ", profesor=" + profesor + "]";
	}
}
