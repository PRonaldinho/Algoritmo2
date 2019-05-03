import java.util.LinkedList;
import java.util.Scanner;

public class Ejer5{

	public static void main(String[] args){ 
		Scanner leer = new Scanner(System.in);
		System.out.println("long lista");
		int n = leer.nextInt();
		LEAF_SIZE = 1;
		int[][] listaA = new int[n][n];
    	cargar (listaA,n,leer);
		int[][] listaB = new int[n][n];
    	cargar (listaB,n,leer);
		mostrar(strassenR(listaA, listaB),n);
		

	}

	private static int LEAF_SIZE = 0;

	public static int[][] ikjAlgorithm(int[][] A, int[][] B) {
    
		int n = A.length;
	    int[][] C = new int[n][n];
	    for (int i = 0; i < n; i++) {
    	    for (int k = 0; k < n; k++) {
    	        for (int j = 0; j < n; j++) {
    	            C[i][j] += A[i][k] * B[k][j];
    	        }
    	    }
    	}
    	return C;
	}

	private static int[][] strassenR(int[][] A, int[][] B) {

		int n = A.length;
		if (n <= LEAF_SIZE) {
        	return ikjAlgorithm(A, B);
    	} else {
		    int mid = n / 2;
		    int[][] a11 = new int[mid][mid];
		    int[][] a12 = new int[mid][mid];
		    int[][] a21 = new int[mid][mid];
		    int[][] a22 = new int[mid][mid];

		    int[][] b11 = new int[mid][mid];
		    int[][] b12 = new int[mid][mid];
		    int[][] b21 = new int[mid][mid];
		    int[][] b22 = new int[mid][mid];

		    int[][] aResult = new int[mid][mid];
		    int[][] bResult = new int[mid][mid];

		    // dividing the matrices in 4 sub-matrices:
		    for (int i = 0; i < mid; i++) {
		        for (int j = 0; j < mid; j++) {
		            a11[i][j] = A[i][j]; // top left
		            a12[i][j] = A[i][j+mid]; // top right
		            a21[i][j] = A[i + mid][j]; // bottom left
		            a22[i][j] = A[i+mid][j+mid]; // bottom right

		            b11[i][j] = B[i][j]; // top left
		            b12[i][j] = B[i][j+mid]; // top right
		            b21[i][j] = B[i+mid][j]; // bottom left
		            b22[i][j] = B[i+mid][j+mid]; // bottom right
		        }
		    }

		    // Calculating p1 to p7:
		    aResult = add(a11, a22);
		    bResult = add(b11, b22);
		    int[][] p1 = strassenR(aResult, bResult);
		    // p1 = (a11+a22) * (b11+b22)

		    aResult = add(a21, a22); // a21 + a22
		    int[][] p2 = strassenR(aResult, b11); // p2 = (a21+a22) * (b11)

		    bResult = subtract(b12, b22); // b12 - b22
		    int[][] p3 = strassenR(a11, bResult);
		    // p3 = (a11) * (b12 - b22)

		    bResult = subtract(b21, b11); // b21 - b11
		    int[][] p4 = strassenR(a22, bResult);
		    // p4 = (a22) * (b21 - b11)

		    aResult = add(a11, a12); // a11 + a12
		    int[][] p5 = strassenR(aResult, b22);
		    // p5 = (a11+a12) * (b22)

		    aResult = subtract(a21, a11); // a21 - a11
		    bResult = add(b11, b12); // b11 + b12
		    int[][] p6 = strassenR(aResult, bResult);
		    // p6 = (a21-a11) * (b11+b12)

		    aResult = subtract(a12, a22); // a12 - a22
		    bResult = add(b21, b22); // b21 + b22
		    int[][] p7 = strassenR(aResult, bResult);
		    // p7 = (a12-a22) * (b21+b22)

		    // calculating c21, c21, c11 e c22:
		    int[][] c12 = add(p3, p5); // c12 = p3 + p5
		    int[][] c21 = add(p2, p4); // c21 = p2 + p4

		    aResult = add(p1, p4); // p1 + p4
		    bResult = add(aResult, p7); // p1 + p4 + p7
		    int[][] c11 = subtract(bResult, p5);
		    // c11 = p1 + p4 - p5 + p7

		    aResult = add(p1, p3); // p1 + p3
		    bResult = add(aResult, p6); // p1 + p3 + p6
		    int[][] c22 = subtract(bResult, p2);
		    // c22 = p1 + p3 - p2 + p6

		    // Grouping the results obtained in a single matrix:
		    int[][] C = new int[n][n];
		    for (int i = 0; i < mid; i++) {
		        for (int j = 0; j < mid; j++) {
		            C[i][j] = c11[i][j];
		            C[i][j + mid] = c12[i][j];
		            C[i + mid][j] = c21[i][j];
		            C[i + mid][j + mid] = c22[i][j];
		        }
		    }
		    return C;
    	}
	}

	private static int[][] add(int[][] A, int[][] B) {
    
		int n = A.length;
    	int[][] C = new int[n][n];
    	for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        	    C[i][j] = A[i][j] + B[i][j];
        	}
    	}
    	return C;
	}

	private static int[][] subtract(int[][] A, int[][] B) {
    
		int n = A.length;
    	int[][] C = new int[n][n];
    	for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        	    C[i][j] = A[i][j] - B[i][j];
        	}
    	}
    	return C;
	}

	public static void cargar(int[][] lista, int n, Scanner leer){
		
		for (int i=0; i<n; i++){
			for (int j=0; j<n; j++){
				System.out.println("ingrese un numero");
				Integer p = leer.nextInt();
        		lista[i][j]= p;
			}
		}
	}

	public static void mostrar (int[][] lista,int n){
		
		System.out.println("");
		for (int i=0; i<n; i++){
			for (int j=0; j<n; j++){
				System.out.print (lista[i][j]+" ");
			
			}
			System.out.println("");
		}	
	}
}
