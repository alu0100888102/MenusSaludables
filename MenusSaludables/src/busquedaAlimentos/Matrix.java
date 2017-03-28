/**
 * PRACTICA 3: Programación dinámica
 * 
 * Matriz de nodos para el problema opcional de recogida de alimentos
 * 
 * @author alu0100888102
 * @version 1.0
 * Ángel Hamilton Lopez
 * alu0100888102@ull.es
 */


package busquedaAlimentos;

import java.util.*;

public class Matrix {
	private ArrayList<ArrayList<Nodo>> ruta;
	private int ancho;
	private int alto;
	
	public Matrix(){
		ruta = new ArrayList<ArrayList<Nodo>>();
	}
	public Matrix(int n, int m){
		setAncho(m);
		setAlto(n);
		ruta = new ArrayList<ArrayList<Nodo>>();
		for(int i = 0; i<m; i++){
			ArrayList<Nodo> temp = new ArrayList<Nodo>();
			for(int j = 0; j<n; j++)
				temp.add(new Nodo());
			ruta.add(temp);
		}
	}
	public ArrayList<ArrayList<Nodo>> getRuta() {
		return ruta;
	}
	public void setRuta(ArrayList<ArrayList<Nodo>> ruta) {
		this.ruta = ruta;
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public int getAlto() {
		return alto;
	}
	public void setAlto(int alto) {
		this.alto = alto;
	}
	public Nodo getElement(int y, int x){
		if(x < 0 || x >=ancho || y<0 || y>=alto)
			throw new IllegalArgumentException("Elemento invalido");
		
		ArrayList<Nodo> temp = getRow(y);
		return temp.get(x);
	}
	public void setElement(int y, int x, Nodo node){
		if(x < 0 || x >=ancho || y<0 || y>=alto)
			throw new IllegalArgumentException("Elemento invalido");
		
		ArrayList<Nodo> temp = getRow(y);
		temp.set(x, node);
		setRow(y, temp);
	}
	public ArrayList<Nodo> getRow(int y){
		if(y<0 || y>=alto)
			throw new IllegalArgumentException("Elemento invalido");
		return ruta.get(y);
	}
	public void setRow(int y, ArrayList<Nodo> row){
		if( y<0 || y>=alto)
			throw new IllegalArgumentException("Elemento invalido");
		if(row.size()> ancho)
			throw new IllegalArgumentException("Fila demasiado grande");
		if(row.size()<ancho-1)
			for(int i =row.size(); i < ancho; i++)
				row.add(new Nodo());
		ruta.set(y, row);
	}
	
	
	
}
