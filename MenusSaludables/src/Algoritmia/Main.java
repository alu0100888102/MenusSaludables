/**
 * PRACTICA 3: Programación dinámica
 * 
 * Esta es la clase principal que ejecuta el programa.
 * 
 * @author alu0100888102
 * @version 1.0
 * Ángel Hamilton Lopez
 * alu0100888102@ull.es
 */

package Algoritmia;

import menusSaludables.*;
import java.io.*;

public class Main {
	public static void main(String args[]){
		Menu menu = new Menu(new File(args[0]));
		Resoluciones res = new Resoluciones(menu);
		
		System.out.println("Recursivo: "+ res.solveRecursive()+"\n");
		
		res.solveTopDown();
		System.out.println("Top Down:\n"+ res.printSol()+"\n");
		
		res.solveBottomUp();
		System.out.println("Bottom Up:\n"+ res.printSol()+"\n");
	}
}
