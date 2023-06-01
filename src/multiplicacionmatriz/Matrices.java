package multiplicacionmatriz;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

public class Matrices {
	
	public static void creacionFicheros(int[][]matriz1,int[][]matriz2,int filas,int columnas) {
		if (matriz1 == null || matriz1.length == 0 || matriz1[0] == null || matriz1[0].length == 0 || matriz2 == null || matriz2.length == 0 || matriz2[0] == null || matriz2[0].length == 0 || filas <= 0 || columnas <= 0) {
	        throw new IllegalArgumentException("Error en formato");
	    }
		try {
			FileWriter fw = new FileWriter("matriz1.txt");
			PrintWriter pw = new PrintWriter("matriz1.txt");
			FileWriter fw2 = new FileWriter("matriz2.txt");
			PrintWriter pw2 = new PrintWriter("matriz2.txt");
			for (int i = 0; i < filas; i++) {
	            for (int j = 0; j < columnas; j++) {
	                pw.write(matriz1[i][j] + " ");
	                pw2.write(matriz2[i][j]+" ");
	            }
	            pw.println();
	            pw2.println();
	        }
			pw.close();
			pw2.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static int[][] leerMatriz(String nombreArchivo, int filas, int columnas) throws IOException {
			File af= new File(nombreArchivo);
			if(af.exists()==false || filas <= 0 || columnas <= 0 ) {
				throw new IllegalArgumentException("Error en formato o archivo no existe");
				
			}
	        int[][] matriz = new int[filas][columnas];
	        
	        BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
	        String line;
	        int lineCount = 0;
	        while ((line = reader.readLine()) != null) {
	            String[] values = line.trim().split(" ");
	            for (int j = 0; j < columnas; j++) {
	                int value = Integer.parseInt(values[j]);
	                matriz[lineCount][j] = value;
	            }
	            lineCount++;
	        }
	        reader.close();
	        
	        return matriz;
	}
	
	
	public static int[][] multiplicacionMatrices(int[][]matriz1,int[][]matriz2,int filas, int columnas) {
		if (matriz1 == null || matriz1.length == 0 || matriz1[0] == null || matriz1[0].length == 0 || matriz2 == null || matriz2.length == 0 || matriz2[0] == null || matriz2[0].length == 0 || filas <= 0 || columnas <= 0) {
	        throw new IllegalArgumentException("Error en formato");
	    }
		
		int[][] nuevamatriz= new int[filas][columnas];
		for (int i = 0; i < filas; i++) {
		    for (int j = 0; j < columnas; j++) {
		        for (int k = 0; k < columnas; k++) {
		            nuevamatriz[i][j] += matriz1[i][k] * matriz2[k][j];
		        }
		    }
		}
		try {
			FileWriter fw = new FileWriter("matrizresultado.txt");
			PrintWriter pw = new PrintWriter("matrizresultado.txt");
			for (int i = 0; i < filas; i++) {
	            for (int j = 0; j < columnas; j++) {
	                pw.write(nuevamatriz[i][j] + " ");
	            }
	            pw.println();
	           
	        }
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return nuevamatriz;
	}

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
		creacionFicheros(matriz1,matriz2,f,c);
		
		try {
			int[][] matrizleer1= leerMatriz("matriz1.txt",f,c);
			int[][] matrizleer2= leerMatriz("matriz1.txt",f,c);
			multiplicacionMatrices(matrizleer1,matrizleer2,f,c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
