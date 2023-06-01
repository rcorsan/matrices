package multiplicacionmatriz;

import static org.junit.jupiter.api.Assertions.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import java.io.FileWriter;
import java.io.PrintWriter;

class MatricesTest {

	@Test
	void testCreacionFicheros() throws IOException {

		Matrices ma= new Matrices();

		int[][] matriz1 = {
				{1, 2},
				{3, 4}
		};

		int[][] matriz2 = {
				{5, 6},
				{7, 8}
		};

		int[][] matriz3 = {
				{11, 12},
				{13, 14}
		};

		int filas = 2;
		int columnas = 2;

		ma.creacionFicheros(matriz1, matriz2,filas, columnas);

		// Verificar el contenido del archivo matriz1.txt
		BufferedReader reader1 = null;
		try {
			reader1 = new BufferedReader(new FileReader("matriz1.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line1;
		int lineCount1 = 0;
		try {
			while ((line1 = reader1.readLine()) != null) {
				String[] values = line1.trim().split(" ");
				for (int j = 0; j < columnas; j++) {
					int value = Integer.parseInt(values[j]);
					assertEquals(matriz1[lineCount1][j], value);
				}
				lineCount1++;
			}

		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reader1.close();

		// Verificar el contenido del archivo matriz2.txt
		BufferedReader reader2 = null;
		try {
			reader2 = new BufferedReader(new FileReader("matriz2.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line2;
		int lineCount2 = 0;
		try {
			while ((line2 = reader2.readLine()) != null) {
				String[] values = line2.trim().split(" ");
				for (int j = 0; j < columnas; j++) {
					int value = Integer.parseInt(values[j]);
					assertEquals(matriz2[lineCount2][j], value);
				}
				lineCount2++;
			}

		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reader2.close();
	}

	@Test
	void testMultiplicacionMatrices() throws IOException {
		Matrices ma= new Matrices();
		int[][] matriz1 = {
				{1, 2},
				{3, 4}
		};

		int[][] matriz2 = {
				{5, 6},
				{7, 8}
		};

		int filas = 2;
		int columnas = 2;

		// Llamar al método para multiplicar las matrices
		int[][] resultado = ma.multiplicacionMatrices(matriz1, matriz2, filas, columnas);

		// Verificar el resultado
		assertEquals(filas, resultado.length);
		assertEquals(columnas, resultado[0].length);
		assertEquals(19, resultado[0][0]);
		assertEquals(22, resultado[0][1]);
		assertEquals(43, resultado[1][0]);
		assertEquals(50, resultado[1][1]);

		// Leer el archivo de resultado y verificar su contenido
		BufferedReader reader = new BufferedReader(new FileReader("matrizresultado.txt"));
		String line;
		int lineCount = 0;
		while ((line = reader.readLine()) != null) {
			String[] values = line.trim().split(" ");
			for (int j = 0; j < columnas; j++) {
				int value = Integer.parseInt(values[j]);
				assertEquals(value, resultado[lineCount][j]);
			}
			lineCount++;
		}
		reader.close();
	}


	@Test
	public void testLeerMatriz() throws IOException {
		Matrices ma= new Matrices();
		String nombreArchivo = "matriz.txt";
		int filas = 2;
		int columnas = 3;

		// Crear archivo de prueba con contenido
		FileWriter fw = new FileWriter(nombreArchivo);
		PrintWriter pw = new PrintWriter(fw);
		pw.println("1 2 3");
		pw.println("4 5 6");
		pw.close();

		// Leer la matriz del archivo
		int[][] matriz = ma.leerMatriz(nombreArchivo, filas, columnas);

		// Verificar la matriz leída
		assertEquals(filas, matriz.length);
		assertEquals(columnas, matriz[0].length);
		assertEquals(1, matriz[0][0]);
		assertEquals(2, matriz[0][1]);
		assertEquals(3, matriz[0][2]);
		assertEquals(4, matriz[1][0]);
		assertEquals(5, matriz[1][1]);
		assertEquals(6, matriz[1][2]);

		// Eliminar el archivo de prueba
		boolean fileDeleted = new File(nombreArchivo).delete();
		assertTrue(fileDeleted);
	}
}
	



