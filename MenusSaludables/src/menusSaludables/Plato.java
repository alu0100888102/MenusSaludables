/**
 * PRACTICA 3: Programación dinámica
 * 
 * Esta clase representa un plato, guardando los datos de este (valor nutriciona, nutrientes nocivos, nombre)
 * 
 * @author alu0100888102
 * @version 1.0
 * Ángel Hamilton Lopez
 * alu0100888102@ull.es
 */

package menusSaludables;

public class Plato{
	private String nombre;
	private int nutrientes;
	private int nocivos;
	
	//constructores
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
	/**
	 * Este constructor construye el plato a partir de un string
	 * @param linea
	 */
	public Plato (String linea){
		String division[] = linea.split("\\s+");
		nombre = division[0];
		nutrientes = Integer.parseInt(division[1]);
		nocivos = Integer.parseInt(division[2]);
	}
	
	//setters y getters
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
	
	public String toString(){
		return getNombre() + ": " + getNutrientes() + " nutrientes saludables, " +  getNocivos() + " nutrientes nocivos.";
	}
	
}
