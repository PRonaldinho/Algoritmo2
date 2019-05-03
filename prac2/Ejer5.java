import java.util.*;
import java.lang.*;

public class Ejer5 {
    public static void main(String[] args){ 
        Scanner leer = new Scanner(System.in);
		int[][] tabla = new int[8][8];
    	inicializar (tabla);
		mostrar (tabla);
		System.out.print ("Ingrese fila donde ingresar la Reina:  _");
		int a = leer.nextInt();
		System.out.print ("Ingrese Columna donde ingresar la Reina:  _");
		int b = leer.nextInt();
		agregarReina (tabla ,a ,b);
		mostrar (tabla);
	}	


	public static void inicializar(int[][] tabla){
		
		for (int i=0; i<8; i++){
			for (int j=0; j<8; j++)
				tabla [i][j] = 00;
		}
	}

	public static void mostrar (int[][] tabla){
		
		for (int i=0; i<8; i++){
			System.out.println (" ");
			System.out.println ("  ________________________________________");
			System.out.print ("  |");
			for (int j=0; j<8; j++){
				System.out.print (" "+tabla[i][j]+" | ");
			}
		}
		System.out.println (" ");
		System.out.println ("  ________________________________________");
		System.out.println (" ");
	}

	public static void agregarReina (int[][] tabla, int fila, int columna){

		if (tabla[fila][columna] == 0){
			tabla[fila][columna] = 9;
			int i = 0;
			int j = 0;
			while (j<8){
				if (tabla[fila][j] != 9)
					tabla [fila][j] =1;
				j++;
			}
			while (i<8){
				if (tabla[i][columna] != 9)
					tabla [i][columna]=1;
				i++;
			}
			i=fila+1;
			j=columna+1;
			while ((i<8) && (j<8)){
					tabla [i][j]=1;
					i++;
					j++;
	
			}
			i=fila-1;
			j=columna-1;
			while ((i>=0) && (j>=0)){
					tabla [i][j]=1;
					i--;
					j--;
			}
			i=fila+1;
			j=columna-1;
			while ((i<8) && (j>=0)){
					tabla [i][j]=1;
					i++;
					j--;
	
			}
			i=fila-1;
			j=columna+1;
			while ((i>=0) && (j<8)){
					tabla [i][j]=1;
					i--;
					j++;
			}
				
		}
	} 
}
