import java.util.Scanner;

public class Ejer9b {

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
		int[] array= new int[a];
		int j=0;
		for (int p=2;p<a;p++)
			array[p]=p;
		for (int p=2; p < Math.sqrt(a);p++){
			if (array[p]!=0){
				j= p*p;
				while (j<a){
					array[j]=0;
					j=j+p;
				}
			}
		}
		int[] aux = new int[a];
		int i=0;
		for (int p=2;p<a;p++){
			if (array[p]!=0){			
				aux[i]=array[p];
				i=i+1;
			}
		}
		return aux;
	}
}
