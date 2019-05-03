import java.util.PriorityQueue;
import java.util.Scanner;

public class HeapSort {

	public static void main(String [] args){
	int n=10;
	Integer[] lista = new Integer[n];
	Scanner leer = new Scanner(System.in);
	for (int i=0; i<n; i++){
		System.out.println("ingrese el "+i+" elemento de la secuencia");
		Integer b = new Integer(leer.nextInt());
		lista[i] = b;
	}
	String s = new String();
	int j=0;
	while (j < n){
		if (j == n-1){
			s = s + lista[j];
		}
		else{
		 s = s + lista[j] + ",";
		}
		 j++;
	}	
	System.out.println("Lista: "+"["+s+"]");
	heapSort (lista , n);
	String s2 = new String();
	int j2=0;
	while (j2 < n){
		if (j2 == n-1){
			s2 = s2 + lista[j2];
		}
		else{
		 s2 = s2 + lista[j2] + ",";
		}
		 j2++;
	}	
	System.out.println("Lista Ordenada: "+"["+s2+"]");

	}

	public static void heapSort (Integer[] a, int n){
		
		PriorityQueue<Integer> cola = new PriorityQueue<Integer>();
		for (int i=0; i<n; i++)
			cola.add(a[i]);
		for (int i=0; i<n; i++)
			a[i] = cola.remove();
	}

}

 
