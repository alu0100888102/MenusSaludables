/**
 * PRACTICA 3: Programaci�n din�mica
 * 
 * Clase principal para el problema opcional de recogida de alimentos
 * 
 * @author alu0100888102
 * @version 1.0
 * �ngel Hamilton Lopez
 * alu0100888102@ull.es
 */


package busquedaAlimentos;

import java.io.*;

public class Main {
	public static void main(String args[]){
		BuscadorAlimentos buscador = new BuscadorAlimentos(new File(args[0]));
		buscador.buscador();
		System.out.println(buscador);
	}
}
