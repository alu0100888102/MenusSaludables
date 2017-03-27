package menusSaludables;

import java.util.*;
import java.io.*;

public class Menu {
	private MatrizValores matriz;
	private ArrayList<Plato> platos;
	private int nutrientesTotal;
	private int nocivoUmbral;
	private int nocivoTotal;
	
	public Menu(){
		platos = new ArrayList<Plato>();
		nocivoUmbral =0;
		reset();
	}
	public Menu(File input){
		platos = new ArrayList<Plato>();
		nocivoUmbral =0;
		reset();
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
