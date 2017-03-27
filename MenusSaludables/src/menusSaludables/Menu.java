package menusSaludables;

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
}
