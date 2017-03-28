/**
 * PRACTICA 3: Programación dinámica
 * 
 * Nodo para el problema opcional de recogida de alimentos
 * 
 * @author alu0100888102
 * @version 1.0
 * Ángel Hamilton Lopez
 * alu0100888102@ull.es
 */


package busquedaAlimentos;

public class Nodo {
	private int valor;
	private String direccion;
	
	public Nodo(){
		setValor(0);
		setDireccion("");
	}
	public Nodo(int v, String s){
		setValor(v);
		setDireccion(s);
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
