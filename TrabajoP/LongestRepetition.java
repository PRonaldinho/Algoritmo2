import java.util.Scanner;
import java.util.LinkedList;

public class LongestRepetition {

	/**
	∗ Calcula Longest repetition usando Fuerza Bruta.
	∗ @param text texto a analizar	
	∗ @return ssubString de mayor longitud que se repite.
	*/
	
	public static String repetition( String texto ) {
		
		LinkedList<String> subLista = subList(texto);
		int k = maxSub(subLista).length();
		if (k > 1)
			return maxSub(subLista);	
		else
			return "";
	}

	public static String maxSub(LinkedList<String> lista ) {

		int n = lista.size();
		String aux2 = "";
		for (int i=0; i<n; i++){
			for(int j=i+1; j<n-1; j++){
				if (lista.get(i).equals(lista.get(j)) && (lista.get(i).length() > aux2.length())){
					aux2 = lista.get(i);
				}
			}
		}
		return aux2;
	}
				

	public static LinkedList<String> subList (String text){

		int n = text.length();
		LinkedList<String> resul = new LinkedList<String>();
		for (int i=0; i<n; i++)
			resul.add(text.substring(i,n));

		for(int j=n-1; j>0; j--)
			resul.add(text.substring(0, j));

		for (int a=1; a<=n-1; a++){
			for(int b = n-1; b>a; b--){
				resul.add(text.substring(a, b));
			}
		}
		return resul;
	}			

	/**
	* Calcula Longest repetition usando D&C.
	* @param text texto a analizar
	* @return ssubString de mayor longitud que se repite.
	*
	public static String repetitionDc( String text ) {
	
		return ""; 
	}
	*/
	
		
	
	public static String toString(LinkedList<String> array){
		String s = new String();
		int j=0;
		int n = array.size();
		while (j < n){
			if (j == n-1){
				s = s + array.get(j);
			}
			else{
				s = s + array.get(j) + ",";
			}
			j++;
		}	
		return "["+s+"]";
	}

	static public void main(String[] args){
	
		System.out.println("--------------------------------------------------------");
		System.out.println("ingrese un texto");
        Scanner leer = new Scanner(System.in);			
		String texto = leer.nextLine();
		
		System.out.println( "SubSecuencia Maxima: "+ repetition(texto) );
		
	
	}

}
