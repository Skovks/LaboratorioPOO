
package paq;

public class Perfil 
{
    private String nombre;
    private String correo;
    private String clave;
    private Integer edad;
    private String experiencia;
    private String especialidad;
    private String interes;

    public Perfil(String nombre, String correo, String clave, Integer edad, String experiencia, String especialidad, String interes) {
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
        this.edad = edad;
        this.experiencia = experiencia;
        this.especialidad = especialidad;
        this.interes = interes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getInteres() {
        return interes;
    }

    public void setInteres(String interes) {
        this.interes = interes;
    }

    @Override
    public String toString() {
        return "Perfil{" + "nombre=" + nombre + ", correo=" + correo + ", clave=" + clave + ", edad=" + edad + ", experiencia=" + experiencia + ", especialidad=" + especialidad + ", interes=" + interes + '}';
    }
    
    
}
