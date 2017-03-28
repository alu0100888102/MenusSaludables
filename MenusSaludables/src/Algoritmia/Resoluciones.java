/**
 * PRACTICA 3: Programación dinámica
 * 
 * Esta es la clase que implementea los algoritmos para resolver mediante recursividad y programación dinámica el poblema de los menús saludables
 * 
 * @author alu0100888102
 * @version 1.0
 * Ángel Hamilton Lopez
 * alu0100888102@ull.es
 */

package Algoritmia;

import java.util.ArrayList;

import menusSaludables.*;

public class Resoluciones {
	private MatrizValores matriz;
	private Menu menu;

	//constructores
	public Resoluciones(){
		menu = new Menu();
		matriz = new MatrizValores();
	}
	public Resoluciones(Menu m){
		menu = m;
		resetMatriz();
	}
	
	//setters y getters
	public MatrizValores getMatriz() {
		return matriz;
	}
	public void setMatriz(MatrizValores matriz) {
		this.matriz = matriz;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	/**
	 * Este metodo nos sirve para reiniciar la matriz antes de cada método para así evitar conflictos
	 */
	public void resetMatriz(){
		matriz = new MatrizValores(menu.getPlatos().size(), menu.getNocivoUmbral());
	}
	
	/**
	 * Para resolver el problema mediante un algoritmo recursivo de complejidad 2^n
	 *  
	 * @return
	 */
	public int solveRecursive(){
		resetMatriz();
		return solveRecursiveStep(menu.getPlatos(), menu.getPlatos().size(), menu.getNocivoUmbral());
	}
	private int solveRecursiveStep(ArrayList<Plato> lista, int index, int nocivoLeft){
		if(index == 0 && nocivoLeft >= 0)
			return 0;
		if(nocivoLeft < 0)
			return Integer.MIN_VALUE;
		int v1 = solveRecursiveStep(lista, index-1, nocivoLeft);
		int v2 = solveRecursiveStep(lista, index-1, nocivoLeft- lista.get(index-1).getNocivos())+ lista.get(index-1).getNutrientes();
		menu.setNutrientesTotal(Integer.max(v1, v2));
		return Integer.max(v1, v2);
	}
	
	/**
	 * Para resolver el problema mediante un algoritmo de programación dinámica con enfoque top-down y complejidad nW (siendo W el umbral de nutrientes nocivos)
	 *  
	 * @return
	 */
	public int solveTopDown(){
		resetMatriz();
		return solveTopDownStep(getMatriz(), menu.getPlatos(), menu.getPlatos().size(), menu.getNocivoUmbral());
	}
	private int solveTopDownStep(MatrizValores matrix, ArrayList<Plato> list, int index, int nocivoLeft){
		if(index == 0 && nocivoLeft >= 0)
			return 0;
		if(nocivoLeft < 0)
			return Integer.MIN_VALUE;
		if(matrix.getElement(index, nocivoLeft) != -1)
			return matrix.getElement(index, nocivoLeft);
		int v1 = solveTopDownStep(matrix, list, index - 1, nocivoLeft);
		int v2 = solveTopDownStep(matrix, list, index - 1, nocivoLeft - list.get(index-1).getNocivos()) + list.get(index-1).getNutrientes();
		matrix.setElement(index, nocivoLeft, Integer.max(v1, v2));
		menu.setNutrientesTotal(matrix.getElement(index, nocivoLeft));
		return matrix.getElement(index, nocivoLeft);
	}
	
	/**
	 * Para resolver el problema mediante un algoritmo de programación dinámica con enfoque bottom-up y complejidad nW (siendo W el umbral de nutrientes nocivos)
	 *  
	 * @return
	 */
	public void solveBottomUp(){
		resetMatriz();
		solveBottomUpStep(getMatriz(), menu.getPlatos(), menu.getPlatos().size(), menu.getNocivoUmbral());
	}
	private void solveBottomUpStep(MatrizValores matrix, ArrayList<Plato> list, int index, int nocivoLeft){
		for(int i =0; i<=nocivoLeft; i++)
			matrix.setElement(0, i, 0);
		for(int i = 1; i <= index; i++ ){
			for(int j =0; j<= nocivoLeft; j++){
				if(list.get(i-1).getNocivos() <= j){
					int v1 = matrix.getElement(i - 1, j);
					int v2 = matrix.getElement(i - 1, j - list.get(i-1).getNocivos()) + list.get(i-1).getNutrientes();
					matrix.setElement(i, j, Integer.max(v1, v2));
					menu.setNutrientesTotal(matrix.getElement(i, j));
				}
				else{
					matrix.setElement(i, j, matrix.getElement(i - 1, j));
				}
			}
		}
	}
	
	
	public String printSol(){
		String out = printSol(getMatriz(), menu.getPlatos(), menu.getPlatos().size(), menu.getNocivoUmbral());
		out += "Valor nutricional total: " + menu.getNutrientesTotal();
		return out;
	}
	public static String printSol(MatrizValores matrix, ArrayList<Plato> list, int index, int nocivoLeft){
		String out = new String();
		out += "Los platos que hemos incluido son:\n";
		int j = nocivoLeft;
		for(int i = index; i > 0; i--){
			if((list.get(i-1).getNocivos() <= j) && ((matrix.getElement(i-1, j-(list.get(i-1).getNocivos())) + list.get(i-1).getNutrientes()) == matrix.getElement(i, j))){
				out += list.get(i-1)+"\n";
				j= j-list.get(i-1).getNocivos();
			}
		}
		return out;
	}
}
