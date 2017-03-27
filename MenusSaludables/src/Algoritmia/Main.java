package Algoritmia;

import menusSaludables.*;
import java.io.*;

public class Main {
	public static void main(String args[]){
		Menu menu = new Menu(new File(args[0]));
		Resoluciones res = new Resoluciones(menu);
		System.out.println("Recursivo: "+ res.solveRecursive());
		res.solveTopDown();
		System.out.println("Top Down: "+ res.printSol());
		res.solveBottomUp();
		System.out.println("Bottom Up: "+ res.printSol());
	}
}
