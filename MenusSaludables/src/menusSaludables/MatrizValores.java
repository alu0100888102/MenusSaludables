package menusSaludables;

import java.util.*;

public class MatrizValores {
	private ArrayList<ArrayList<Integer>> matrix;
	private int numPlatos;
	private int umbral;

	public MatrizValores(){
		matrix = new ArrayList<ArrayList<Integer>>();
		numPlatos = 0;
		umbral =0;
	}
	public MatrizValores(int num, int umb){
		matrix = new ArrayList<ArrayList<Integer>>();
		numPlatos = num;
		umbral = umb;
		for(int i = 0; i < numPlatos; i++)
			newRow();
	}
	public MatrizValores(ArrayList<ArrayList<Integer>> n){
		matrix = new ArrayList<ArrayList<Integer>>();
		setMatrix(n);
		numPlatos = n.size();
		umbral = n.get(0).size();
	}
	
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
		if(row.size()> umbral)
			throw new IllegalArgumentException("Fila demasiado grande");
		if(row.size()<umbral)
			for(int i =row.size(); i < umbral; i++)
				row.add(-1);
		matrix.set(n, row);
	}
	public ArrayList<Integer> getRow(){
		return getRow(getMatrix().size()-1);
	}
	public void setRow(ArrayList<Integer> row){
		setRow(getMatrix().size() - 1, row);
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
	public int getElement(int index){
		return getElement(getMatrix().size() - 1, index);
	}
	public void setElement(int index, int value){
		setElement(getMatrix().size() - 1, index, value);
	}
	
	public void addRow(ArrayList<Integer> row){
		if(row.size()> umbral)
			throw new IllegalArgumentException("Fila demasiado grande");
		if(row.size()<umbral)
			for(int i =row.size(); i < umbral; i++)
				row.add(-1);
		matrix.add(row);
	}
	public void newRow(){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i =0; i < umbral; i++)
			temp.add(-1);
		addRow(temp);
	}
	
}
