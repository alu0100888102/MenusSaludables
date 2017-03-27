package Algoritmia;

import java.util.ArrayList;

import menusSaludables.*;

public class Resoluciones {
	Menu menu;

	public Resoluciones(){
		menu = new Menu();
	}
	public Resoluciones(Menu m){
		menu = m;
	}
	public int solveRecursive(){
		menu.reset();
		return solveRecursiveStep(menu.getPlatos(), menu.getPlatos().size()-1, menu.getNocivoRestante());
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
		menu.reset();
		return solveTopDownStep(menu.getMatriz(), menu.getPlatos(), menu.getPlatos().size()-1, menu.getNocivoRestante());
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
		menu.reset();
		solveBottomUpStep(menu.getMatriz(), menu.getPlatos(), menu.getPlatos().size()-1, menu.getNocivoRestante());
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
	
	
	public String printSol(){
		String out = printSol(menu.getMatriz(), menu.getPlatos(), menu.getPlatos().size()-1, menu.getNocivoRestante());
		out += "Nutrientes nocivos: " + menu.getNocivoTotal() + " / " + menu.getNocivoUmbral() + ".\n";
		out += "Valor nutricional total: " + menu.getNutrientesTotal();
		return out;
	}
	public static String printSol(MatrizValores matrix, ArrayList<Plato> list, int index, int nocivoLeft){
		String out = new String();
		out += "Los platos que hemos incluido son:\n";
		int j = nocivoLeft;
		for(int i = index; i >0; i++){
			if((list.get(i).getNocivos() <= j) && ((matrix.getElement(i-1, j-(list.get(i).getNocivos()) + list.get(i).getNutrientes()) == matrix.getElement(i, j)))){
				out += list.get(i)+"\n";
				j= j-list.get(i).getNocivos();
			}
		}
		return out;
	}
}
