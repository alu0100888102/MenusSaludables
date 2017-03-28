/**
 * PRACTICA 3: Programación dinámica
 * 
 * Esta clase representa el menú. Contiene los platos y los datos generales.
 * 
 * @author alu0100888102
 * @version 1.0
 * Ángel Hamilton Lopez
 * alu0100888102@ull.es
 */

package menusSaludables;

import java.util.*;
import java.io.*;

public class Menu {
	private ArrayList<Plato> platos;
	private int nutrientesTotal;
	private int nocivoUmbral;
	
	//constructores
	public Menu(){
		platos = new ArrayList<Plato>();
		nocivoUmbral =0;
	}
	public Menu(File input){
		platos = new ArrayList<Plato>();
		nocivoUmbral =0;
		try{
			FileInputStream istream = new FileInputStream(input);
			 
			//Construct BufferedReader from InputStreamReader
			BufferedReader bufferreader = new BufferedReader(new InputStreamReader(istream));
			
			String line = null;
			line = bufferreader.readLine();
			int platosRestantes = Integer.parseInt(line);
			line = bufferreader.readLine();
			nocivoUmbral = Integer.parseInt(line);
			while ((line = bufferreader.readLine()) != null && platosRestantes > 0) {
				if(line.isEmpty())
					continue;
				platos.add(new Plato(line));
				platosRestantes--;
			}
			bufferreader.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Error en el fichero: no se encuentra " + e);
			System.exit(1);
		}
		catch(IOException e){
			System.out.println("Error en el fichero: error de entrada/salida " + e);
			System.exit(1);
		}
	}
	
	//setters y getters
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
}
