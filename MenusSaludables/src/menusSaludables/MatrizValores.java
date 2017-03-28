/**
 * PRACTICA 3: Programación dinámica
 * 
 * Esta clase guarda la matriz que emplean los algoritmos de programación dinámica para resolver el problema.
 * La matriz tendrá tamaño n+1 * m+1, para incluir las filas de la 0 a la N
 * 
 * @author alu0100888102
 * @version 1.0
 * Ángel Hamilton Lopez
 * alu0100888102@ull.es
 */

package menusSaludables;

import java.util.*;

public class MatrizValores {
	private ArrayList<ArrayList<Integer>> matrix;
	private int numPlatos; //numero de filas
	private int umbral; //numero de columnas

	//constructores
	public MatrizValores(){
		matrix = new ArrayList<ArrayList<Integer>>();
		numPlatos = 0;
		umbral =0;
	}
	public MatrizValores(int num, int umb){
		matrix = new ArrayList<ArrayList<Integer>>();
		numPlatos = num;
		umbral = umb;
		for(int i = 0; i <= numPlatos; i++)
			newRow();
	}
	public MatrizValores(ArrayList<ArrayList<Integer>> n){
		matrix = new ArrayList<ArrayList<Integer>>();
		setMatrix(n);
		numPlatos = n.size();
		umbral = n.get(0).size();
	}
	
	//getters y setters
	public int getNumPlatos() {
		return numPlatos;
	}
	public void setNumPlatos(int numPlatos) {
		this.numPlatos = numPlatos;
	}
	public int getUmbral() {
		return umbral;
	}
	public void setUmbral(int umbral) {
		this.umbral = umbral;
	}
	public ArrayList<ArrayList<Integer>> getMatrix() {
		return matrix;
	}
	public void setMatrix(ArrayList<ArrayList<Integer>> matrix) {
		this.matrix = matrix;
	}
	public ArrayList<Integer> getRow(int n){
		if(n < 0 || matrix.size() < n)
			throw new IllegalArgumentException("La fila "+ n + " no existe.");
		return matrix.get(n);
	}
	public void setRow(int n, ArrayList<Integer> row){
		if(n < 0 || matrix.size() < n)
			throw new IllegalArgumentException("La fila "+ n  +" no existe.");
		if(row.size()> umbral+1)
			throw new IllegalArgumentException("Fila demasiado grande");
		if(row.size()<umbral+1)
			for(int i =row.size(); i < umbral+1; i++)
				row.add(-1);
		matrix.set(n, row);
	}
	public int getElement(int row, int index){
		if(index < 0 || index > umbral)
			throw new IllegalArgumentException("Elemento invalido");
		ArrayList<Integer> temp = getRow(row);
		return temp.get(index);
	}
	public void setElement(int row, int index, int value){
		if(index < 0 || index > umbral)
			throw new IllegalArgumentException("Elemento invalido");
		ArrayList<Integer> temp = getRow(row);
		temp.set(index, value);
		setRow(row, temp);
	}
	
	public void addRow(ArrayList<Integer> row){
		if(row.size()>umbral+1)
			throw new IllegalArgumentException("Fila demasiado grande");
		if(row.size()<umbral)
			for(int i =row.size(); i <= umbral; i++)
				row.add(-1);
		matrix.add(row);
	}
	public void newRow(){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i =0; i <= umbral; i++)
			temp.add(-1);
		addRow(temp);
	}
	
	public String toString(){
		String out = new String();
		for(ArrayList<Integer> row : getMatrix()){
			for(Integer i : row){
				out += i+" ";
			}
			out += "\n";
		}
		return out;
	}
	
}
