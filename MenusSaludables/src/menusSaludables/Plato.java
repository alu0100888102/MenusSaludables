package menusSaludables;

public class Plato{
	private String nombre;
	private int nutrientes;
	private int nocivos;
	
	public Plato(){
		setNutrientes(Integer.MIN_VALUE);
		setNocivos(Integer.MAX_VALUE);
		setNombre("");
	}
	public Plato(String name, int nu, int no){
		setNutrientes(nu);
		setNocivos(no);
		setNombre(name);
	}
	public Plato (String linea){
		String division[] = linea.split("\\s+");
		nombre = division[0];
		nutrientes = Integer.parseInt(division[1]);
		nocivos = Integer.parseInt(division[2]);
	}
	
	public int getNutrientes() {
		return nutrientes;
	}
	public void setNutrientes(int nutrientes) {
		this.nutrientes = nutrientes;
	}
	public int getNocivos() {
		return nocivos;
	}
	public void setNocivos(int nocivos) {
		this.nocivos = nocivos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
