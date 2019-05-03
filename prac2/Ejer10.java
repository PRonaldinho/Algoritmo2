import java.util.*;
import java.lang.*;

public class Ejer10 {

    public static void main(String[] args){ 
        Scanner leer = new Scanner(System.in);
		LinkedList<Integer> lista = new LinkedList<>();
		System.out.println("long lista");
		Integer n = leer.nextInt();
    	cargar (lista,n);
		permutacion (lista, 0,n,lista.size());
		System.out.println (mostrar(lista,n));
	}	

	public static void cargar(LinkedList<Integer> lista, Integer n){
		
		for (int i=0; i<n; i++){
        	lista.add(i);
		}
	}

	private static void permutacion (LinkedList<Integer> elem, Integer act, int n, int r) {
        if (n == 0) {
            System.out.println(act);
        } else {
            for (int i = 0; i < r; i++) {
                if (!act.contains(elem.get(i))) { // Controla que no haya repeticiones
                    permutacion(elem, act + elem.get(i) + ", ", n - 1, r);
                }
            }
        }
    }
//	public static LinkedList<Integer> desarreglo(LinkedList<Integer> lista, Integer n){
//		
//		LinkedList<Integer> aux = new LinkedList<Integer>();
//		for 
//	}


	public static String mostrar (LinkedList<Integer> lista, Integer n){
		String s = new String();
		int j=0;
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
