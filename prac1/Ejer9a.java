import java.util.Scanner;

public class Ejer9a {

	public static void main(String [] args){
		//Scanner leer = new Scanner(System.in);
		//System.out.println("ingrese un num");
		//int b = leer.nextInt();
		int b = 9999;
		int[] lista = primo(b);
		String s = new String();
		int j=0;
		int n = lista.length;
		while ((j < n) && (lista[j] != 0)){
				if (j == n-1){
					s = s + lista[j];
				}
				else{
			 		s = s + lista[j] + ",";
				}
		 j++;
			
		}	
		System.out.println("Lista: "+"["+s+"]");
	}

	public static int[] primo (int a){
		int[] primos= new int[a];
		int n=2;
		int i=0;
		while (n<a){
			if (esPrimo(n)){
				primos[i] = n;
				i++;
			}
			n++;
		}
		return primos;		
	}
	
	public static boolean esPrimo (int a){		
		int n=2;
		int i=0;	
		while (n<a){
			if (a % n == 0){
				i++;
			}
			n++;
		}
		return (i==0);		
	}

}

