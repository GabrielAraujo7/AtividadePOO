package q4_JoaoGabrielNunes;
import java.util.Random;
public class Matrix {

	public static void main(String[] args) {
		//cria matrizes;
		int [][] matriza = gerarMatriz(3,3);
		int [][] matrizb = gerarMatriz(3,4);
		
		// mostra as matrizes na tela, através do metodo "imprimirMatriz"
		System.out.println("\n --- MATRIZ A --- ");
		imprimirMatriz(matriza);
		System.out.println("\n --- MATRIZ B --- ");
		imprimirMatriz(matrizb);
		
		// recebe o total da matriz que são multiplicadas no método "multiplicaMatrizes";
		int[][] totalmatrix = multiplicarMatrizes(matriza,matrizb);
		
		// exibe o resultado da multiplicação das matrizes recebendo o "multiplicaMatrizes" ;
		int[][] matrizResultado = multiplicarMatrizes(matriza, matrizb);
	        System.out.println("\n --- MATRIZ RESULTANTE --- ");
	        imprimirMatriz(matrizResultado);
		
	}
		//gera duas matrizes com elementos aleatórios;
	   private static int[][] gerarMatriz(int linhas, int colunas) {
	        int[][] matriz = new int[linhas][colunas];
	        Random rand = new Random();
	        for (int i = 0; i < linhas; i++) {
	            for (int j = 0; j < colunas; j++) {
	                matriz[i][j] = rand.nextInt(10);
	            }
	        }
	        return matriz;
	    }
	   //imprime os resultados;
	    private static void imprimirMatriz(int[][] matriz) {
	        for (int i = 0; i < matriz.length; i++) {
	            for (int j = 0; j < matriz[i].length; j++) {
	                System.out.print(matriz[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }
	    //multiplica as matrizes;
	    private static int[][] multiplicarMatrizes(int[][] matrizA, int[][] matrizB) {
	        int linhasA = matrizA.length;
	        int colunasA = matrizA[0].length;
	        int colunasB = matrizB[0].length;

	        if (colunasA != matrizB.length) {
	            System.out.println("A multiplicação de matrizes não é possível. O número de colunas em A deve ser igual ao número de linhas em B.");
	            return null;
	        }
	        
	        // mostra o resultado das matrizes; 
	        int[][] resultado = new int[linhasA][colunasB];
	        for (int i = 0; i < linhasA; i++) {
	            for (int j = 0; j < colunasB; j++) {
	                for (int k = 0; k < colunasA; k++) {
	                    resultado[i][j] += matrizA[i][k] * matrizB[k][j];
	                }
	            }
	        }

	        return resultado;
	    }
	}
