import java.util.Scanner;

public class StringMatching {
	
	/**
	∗ Calcula String Matching usando Fuerza Bruta .
	∗ @param text texto a analizar
	∗ @param pattern patron a buscar en el texto
	∗ @return si n dice de la primera ocurrencia de pattern en text, en caso que exista, o −1 en 		* caso que no se encuentre.
	*/
	public static int match( String text, String pattern ) {
		
		int n = text.length()+1;
		int m = pattern.length();
		for (int i=0; i < n-m; i++){
			int j=0;
			while ( (j<m) && (pattern.charAt(j) == text.charAt(i+j)) ){
			
				j = j+1;
			}
			if (j==m){
				return i;
			}
		}
		return -1;
	}

   /**
	∗ Calcula String Matching usando Knuth−Morris−Pratt.
	∗ @param text texto a analizar
	∗ @param pattern patron a buscar en el texto
	∗ @return si n dice de la primera ocurrencia de pattern en text, en caso que exista,
	*/
	public static int matchKmp( String text, String pattern ) {
		
    	int[] table = shiftTable(pattern);
    	int j=0;
    	for (int i=0; i<text.length(); i++) {
        	while ( (j>0) && (text.charAt(i) != pattern.charAt(j)) ) {
            	j = table[j-1];
        	}
        	if ( text.charAt(i) == pattern.charAt(j) ) {
            	j++;
            	if ( j == pattern.length() )
                	return ( i-(j-1) );
        	}
    	}
		return -1;
	}

	public static int[] shiftTable( String pattern ) {
    
		int n = pattern.length();
		int[] table = new int[n];
	    table[0] = 0;
    	for (int i = 1; i < n; i++) {
        	int j = table[i-1];
        	while ( (j>0) && (pattern.charAt(i) != pattern.charAt(j)) )
            	j = table[j-1];
        	if ( pattern.charAt(i) == pattern.charAt(j) )
            	j++;
        	table[i] = j;
    	}
    	return table;
	}

	static public void main(String[] args){
	
		System.out.println("--------------------------------------------------------");
		System.out.println("ingrese un texto");
        Scanner leer = new Scanner(System.in);			
		String texto = leer.nextLine();
		System.out.println("ingrese un patron a buscar en el texto");			
		String patron = leer.nextLine();
		System.out.println("El patron esta con FuerzaBruta?: "+ match(texto,patron));
		System.out.println("El patron esta con KMP?: "+ matchKmp(texto,patron));
	
	}	
}

