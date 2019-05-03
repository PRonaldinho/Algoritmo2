import java.util.*; 

public class Ejer2 {

    public static void main(String[] args){ 
        Scanner leer = new Scanner(System.in);
		LinkedList<Integer> lista = new LinkedList<>();
		System.out.println("ingrese long lista");
		int n = leer.nextInt();
		cargar (lista,n,leer);
		inversiones(lista,0,n-1);
		System.out.println("Cantidad de inversiones: "+inv);
	
	}	
	private static int inv = 0;
	
	public static void inversiones(LinkedList<Integer> lista, Integer begin, Integer end){
		
		if (begin<end){
			int mid = (begin+end)/2;
			inversiones(lista,begin,mid);
			inversiones(lista,mid+1,end);
			System.out.println("_begin: "+begin+" _mid: "+mid+" _end: "+end+" _a[b]: "+lista.get(begin)+" _a[m]: "+lista.get(mid)+" _a[e]: "+lista.get(end));
			inver (lista,begin,mid,end);
		}
	}

	public static void inver (LinkedList<Integer> lista, Integer begin, Integer mid,Integer end){
		
		int k = end;
		int j = mid;
		for (int i=begin; i<j; i++){
			if (lista.get(i) > lista.get(j)) 
				inv++;
			if (lista.get(i) > lista.get(k))
				inv++;
		}
		for (int h=mid; h<k; h++){
			if (lista.get(h) > lista.get(k))
				inv++;
		}
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
