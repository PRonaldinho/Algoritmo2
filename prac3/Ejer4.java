import java.util.LinkedList;
import java.util.Scanner;

public class Ejer4{

	public static void main(String[] args){ 
		Scanner leer = new Scanner(System.in);
		LinkedList<Integer> lista = new LinkedList<>();
		System.out.println("long lista");
		int n = leer.nextInt();
    	cargar (lista,n,leer);
		System.out.println ("SubSecMin: "+subSecMin (lista, 0, lista.size()-1));
		System.out.println (mostrar(lista));
	

	}

	public static int subSecMin(LinkedList<Integer> lista, int begin, int end){
		
		int ret = -1;
		if (begin == end) {
      		return lista.get(begin);
    	}
		if (begin<end){
			int mid = (begin+end)/2;
			int a = subSecMin(lista,begin,mid);
			int b = subSecMin(lista,mid+1,end);
			int c = min (lista,begin,mid,end);
			ret = Math.min(Math.min(a,b) , c);	
		}
		return ret;
	}


	public static int min(LinkedList<Integer> lista, int begin, int mid,int end){
		
		int sumMin = Integer.MAX_VALUE;

		int sum = 0;
		for (int i=begin; i<=mid; i++){
			sum = sum + lista.get(i);
			if (sum < sumMin){
				sumMin = sum;
			}
		}

		sum = 0;
		for (int h=mid+1; h<=end; h++){
			sum = sum + lista.get(h);
			if (sum < sumMin){
				sumMin = sum; 
			}
		}
		return sumMin;
	}

	public static void cargar(LinkedList<Integer> lista, int n, Scanner leer){
		
		for (int i=0; i<n; i++){
			System.out.println("ingrese un numero");
			Integer p = leer.nextInt();
        	lista.add(p);
		}
	}

	public static String mostrar (LinkedList<Integer> lista){
		String s = new String();
		int j=0;
		int n = lista.size();
		while (j < n){
			if (j == n-1){
				s = s + lista.get(j);
			}
			else{
				s = s + lista.get(j) + ",";
			}
			j++;
		}	
		return "["+s+"]";
	}
}
