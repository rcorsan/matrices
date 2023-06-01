package multiplicacionmatriz;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Matrices {

	public static void main(String[] args) {
		//Dimension filas y columnas
		int f=3;
		int c =3;
		
		//Creacion de arrays para iniciar matrice
		int[][] matriz1= new int[f][c];
		int[][] matriz2= new int[f][c];
		int[][] nuevamatriz= new int[f][c];
		
		
		//matriz 1
		
		matriz1[0][0]= 1;
		matriz1[0][1]= 2;
		matriz1[0][2]= 3;
		matriz1[1][0]= 4;
		matriz1[1][1]= 5;
		matriz1[1][2]= 6;
		matriz1[2][0]= 7;
		matriz1[2][1]= 8;
		matriz1[2][2]= 9;
		
		//matriz 2
		
		matriz2[0][0]= 9;
		matriz2[0][1]= 8;
		matriz2[0][2]= 7;
		matriz2[1][0]= 6;
		matriz2[1][1]= 5;
		matriz2[1][2]= 4;
		matriz2[2][0]= 3;
		matriz2[2][1]= 2;
		matriz2[2][2]= 1;
		
		for (int i = 0; i < f; i++) {
		    for (int j = 0; j < c; j++) {
		        for (int k = 0; k < c; k++) {
		            nuevamatriz[i][j] += matriz1[i][k] * matriz2[k][j];
		        }
		    }
		}
		
		

		
		
		//escribir matrices
		try {
			FileWriter fw = new FileWriter("matriz1.txt");
			PrintWriter pw = new PrintWriter("matriz1.txt");
			FileWriter fw2 = new FileWriter("matriz2.txt");
			PrintWriter pw2 = new PrintWriter("matriz2.txt");
			FileWriter fw3 = new FileWriter("matrizresultado.txt");
			PrintWriter pw3 = new PrintWriter("matrizresultado.txt");
			for (int i = 0; i < f; i++) {
	            for (int j = 0; j < c; j++) {
	                pw.write(matriz1[i][j] + " ");
	                pw2.write(matriz2[i][j]+" ");
	                pw3.write(nuevamatriz[i][j]+" ");
	            }
	            pw.println();
	            pw2.println();
	            pw3.println();
	        }
			pw.close();
			pw2.close();
			pw3.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
