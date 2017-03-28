/**
 * PRACTICA 3: Programación dinámica
 * 
 * Esta es la clase que plantea el problema opcional de recogida de alimentos
 * 
 * @author alu0100888102
 * @version 1.0
 * Ángel Hamilton Lopez
 * alu0100888102@ull.es
 */

package busquedaAlimentos;

import java.io.*;
import menusSaludables.MatrizValores;


public class BuscadorAlimentos {
	private MatrizValores grid; // utilizamos la matriz desarrollada para la otra parte
	private Matrix route;
	private int ancho;
	private int alto;
	
	// constructores
	public BuscadorAlimentos(){
		grid = new MatrizValores();
		route = new Matrix();
	}
	public BuscadorAlimentos(File input){
		try{
			FileInputStream istream = new FileInputStream(input);
			 
			//Construct BufferedReader from InputStreamReader
			BufferedReader bufferreader = new BufferedReader(new InputStreamReader(istream));
			
			String line = null;
			line = bufferreader.readLine();
			ancho = Integer.parseInt(line);
			line = bufferreader.readLine();
			alto = Integer.parseInt(line);
			grid = new MatrizValores(alto-1, ancho-1);
			route = new Matrix(alto, ancho);
			int nline = 0;
			while ((line = bufferreader.readLine()) != null) {
				if(line.isEmpty())
					continue;
				String division[] = line.split("\\s+");
				int j=0;
				for(String a : division){
					grid.setElement(nline, j, Integer.parseInt(a));
					j++;
				}
				nline++;
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
	public MatrizValores getGrid() {
		return grid;
	}
	public void setGrid(MatrizValores grid) {
		this.grid = grid;
	}
	public Matrix getRoute() {
		return route;
	}
	public void setRoute(Matrix route) {
		this.route = route;
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
	
	
	/**
	 * El pseudo algoritmo es el siguiente:
	 * Empezando por el nodo del final, miras a ver cuales son los valores acumulados del nodo superior y el de la izquierda de forma recursiva.
	 * El valor acumulado del nodo es el mayor de ambos mas el propio valor.
	 * Se guarda en la matriz de donde "viene" el camino junto con el valor acumulado, para no tener que repetir el problema.
	 */
	public void buscador(){
		buscadorStep(getAlto()-1, getAncho()-1);
	}
	private int buscadorStep(int y, int x){
		if(y < 0 || x < 0)
			return Integer.MIN_VALUE;
		if(!getRoute().getElement(y,x).getDireccion().isEmpty())
			return route.getElement(y,x).getValor();
		int valorCasilla = getGrid().getElement(y, x);
		if(x == 0 && y == 0){
			Nodo node = new Nodo(valorCasilla, "start");
			getRoute().setElement(y, x, node);
			return valorCasilla;
		}
		int valorArriba = buscadorStep(y-1,x);
		int valorIzda = buscadorStep(y,x-1);
		if(valorArriba >= valorIzda){
			Nodo node = new Nodo(valorArriba + valorCasilla, "up");
			getRoute().setElement(y, x, node);
			return valorArriba + valorCasilla;
		}
		else{
			Nodo node = new Nodo(valorIzda + valorCasilla, "left");
			getRoute().setElement(y, x, node);
			return valorIzda + valorCasilla;
		}
	}
	
	/**
	 * imprime recursivamente empezando por el final
	 */
	public String toString(){
		String out = recursiveWritting(getAlto()-1, getAncho()-1);
		return out;
	}
	private String recursiveWritting(int y, int x){
		String out = new String();
		if(getRoute().getElement(y, x).getDireccion().matches("up")){
			out += recursiveWritting(y-1,x) + "("+x+","+y+")";
		}
		else if(getRoute().getElement(y, x).getDireccion().matches("left")){
			out += recursiveWritting(y,x-1)+ "("+x+","+y+")";
		}
		else if(getRoute().getElement(y, x).getDireccion().matches("start")){
			out += "(0,0)";
		}
		out +=  " Recogemos "+ getGrid().getElement(y, x) + " kilos, "+getRoute().getElement(y, x).getValor()+" en total. \n";
		return out;
	}
}
