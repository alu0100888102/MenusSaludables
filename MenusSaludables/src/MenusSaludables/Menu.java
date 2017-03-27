package MenusSaludables;

import java.util.*;

public class Menu {
	MatrizValores matriz;
	ArrayList<Plato> platos;
	int nutrientesTotal;
	int nocivoUmbral;
	int nocivoTotal;
	
	
	
	public void reset(){
		matriz = new MatrizValores(platos.size(), nocivoUmbral);
		nocivoTotal = 0;
		nutrientesTotal =0;
	}
	
	public MatrizValores getMatriz() {
		return matriz;
	}
	public void setMatriz(MatrizValores matriz) {
		this.matriz = matriz;
	}
	public ArrayList<Plato> getPlatos() {
		return platos;
	}
	public void setPlatos(ArrayList<Plato> platos) {
		this.platos = platos;
	}
	public int getNutrientesTotal() {
		return nutrientesTotal;
	}
	public void setNutrientesTotal(int nutrientesTotal) {
		this.nutrientesTotal = nutrientesTotal;
	}
	public int getNocivoUmbral() {
		return nocivoUmbral;
	}
	public void setNocivoUmbral(int nocivoUmbral) {
		this.nocivoUmbral = nocivoUmbral;
	}
	public int getNocivoTotal() {
		return nocivoTotal;
	}
	public void setNocivoTotal(int nocivoTotal) {
		this.nocivoTotal = nocivoTotal;
	}
	public int getNocivoRestante(){
		return getNocivoTotal() - getNocivoUmbral();
	}
	
	
	
	public int solveRecursive(){
		reset();
		return solveRecursiveStep(platos, platos.size()-1, getNocivoRestante());
	}
	public static int solveRecursiveStep(ArrayList<Plato> lista, int index, int nocivoLeft){
		if(index == -1 && nocivoLeft >= 0)
			return 0;
		if(nocivoLeft < 0)
			return Integer.MIN_VALUE;
		int v1 = solveRecursiveStep(lista, index-1, nocivoLeft);
		int v2 = solveRecursiveStep(lista, index-1, nocivoLeft- lista.get(index).getNocivos())+ lista.get(index).getNutrientes();
		return Integer.max(v1, v2);
	}
	
	public int solveTopDown(){
		reset();
		return solveTopDownStep(matriz, platos, platos.size()-1, getNocivoRestante());
	}
	public static int solveTopDownStep(MatrizValores matrix, ArrayList<Plato> list, int index, int nocivoLeft){
		if(index == -1 && nocivoLeft >= 0)
			return 0;
		if(nocivoLeft < 0)
			return Integer.MIN_VALUE;
		if(matrix.getElement(index, nocivoLeft) != -1)
			return matrix.getElement(index, nocivoLeft);
		int v1 = solveTopDownStep(matrix, list, index - 1, nocivoLeft);
		int v2 = solveTopDownStep(matrix, list, index - 1, nocivoLeft - list.get(index).getNocivos()) + list.get(index).getNutrientes();
		matrix.setElement(index, nocivoLeft, Integer.max(v1, v2));
		return matrix.getElement(index, nocivoLeft);
	}
	
	
	public void solveBottomUp(){
		reset();
		solveBottomUpStep(matriz, platos, platos.size()-1, getNocivoRestante());
	}
	public static void solveBottomUpStep(MatrizValores matrix, ArrayList<Plato> list, int index, int nocivoLeft){
		for(int i =0; i<nocivoLeft; i++)
			matrix.setElement(0, i, 0);
		for(int i = 0; i <= index; i++ ){
			for(int j =0; j< nocivoLeft; j++){
				if(list.get(index).getNocivos() <= j){
					int v1 = matrix.getElement(i - 1, j);
					int v2 = matrix.getElement(i - 1, j - list.get(index).getNocivos()) + list.get(index).getNutrientes();
					matrix.setElement(i, j, Integer.max(v1, v2));
				}
				else{
					matrix.setElement(i, j, matrix.getElement(i - 1, j));
				}
			}
			
		}
	}
}
