package Ejercicio1;

public class Ciudad {

	private String nombre;
	private int poblacion;
	private String nombreAlcalde;
	private String nombrePartido;
	private String gentilicio;
	private String comunidadAutonoma;
	
	public Ciudad(String nombre, int poblacion, String nombreAlcalde, String nombrePartido, String gentilicio,
			String comunidadAutonoma) {
		this.nombre = nombre;
		this.poblacion = poblacion;
		this.nombreAlcalde = nombreAlcalde;
		this.nombrePartido = nombrePartido;
		this.gentilicio = gentilicio;
		this.comunidadAutonoma = comunidadAutonoma;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}
	public String getNombreAlcalde() {
		return nombreAlcalde;
	}
	public void setNombreAlcalde(String nombreAlcalde) {
		this.nombreAlcalde = nombreAlcalde;
	}
	public String getNombrePartido() {
		return nombrePartido;
	}
	public void setNombrePartido(String nombrePartido) {
		this.nombrePartido = nombrePartido;
	}
	public String getGentilicio() {
		return gentilicio;
	}
	public void setGentilicio(String gentilicio) {
		this.gentilicio = gentilicio;
	}
	public String getComunidadAutonoma() {
		return comunidadAutonoma;
	}
	public void setComunidadAutonoma(String comunidadAutonoma) {
		this.comunidadAutonoma = comunidadAutonoma;
	}
	
}
