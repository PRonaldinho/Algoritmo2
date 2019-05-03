import java.util.*;
import java.lang.*;

public class Ejer6 {

    public static void main(String[] args){ 
        Scanner leer = new Scanner(System.in);
		LinkedList<String> lista = new LinkedList<>();
    	inicializar (lista);
		lista = filtrar (lista);
		//mostrar(lista);
		Tupla<Integer,Integer> minTup = minDist(lista);
		System.out.println ("Es entre los capicuas: "+ minTup.toString());
	}	


	public static void inicializar(LinkedList lista){
		
		for (int i=0; i<=99999; i++){
                String valor = String.valueOf(i);
                if (valor.length()==5)
                    lista.add(valor);
                else if (valor.length()==4)
                    lista.add("0"+valor);
                else if (valor.length()==3)
                    lista.add("00"+valor);
                else if (valor.length()==2)
                    lista.add("000"+valor);
                else
                    lista.add("0000"+valor);
		}
	}

	public static boolean capi (String sNum){
		
		int inc = 0;
		int des = sNum.length()-1;
		boolean b = false;
		while ( (inc<des) && (!b) ){
			if (sNum.charAt(inc) == sNum.charAt(des)){
				inc++;
				des--;
			}
			else
				b = true;
		}
		if (!b)
			return true;
		else
			return false;
	} 

	public static LinkedList<String> filtrar(LinkedList<String> lista){
		
		LinkedList<String> aux = new LinkedList<String>();
		for (int i=0; i<=99999; i++){
       		if (capi (lista.get(i)))
				aux.add(lista.get(i));    
		}
		return aux;
	}

	public static Tupla<Integer,Integer> minDist (LinkedList<String> lista){
		
		Tupla<Integer,Integer> mini = new Tupla();
		Integer min = Integer.MAX_VALUE;
		for (int i=1; i < lista.size(); i++){
			Integer a = Integer.parseInt(lista.get(i-1));
			Integer b = Integer.parseInt(lista.get(i));
       		if ( b - a < min){
				min = b-a;
				mini.changeFst(a);
				mini.changeSnd(b);    
			}
		}
		System.out.println ("La distancia minima es: "+ min);
		return mini;
	}

	public static void mostrar(LinkedList<String> lista){
		
		for (int i=0; i<=99999; i++){
            System.out.print ("("+lista.get(i)+"), ");
		}
	}

}
