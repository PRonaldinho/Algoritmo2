import java.util.Arrays;
import java.util.ArrayList;
public class Capicuas {

	public static Boolean isCapicua(int[] nro) {
		
		if (nro[0]==nro[4] && nro[1]==nro[3])
			return true;
		else return false;

	}

	public static int arrayToInteger(int[] arrNumb) {
		int num = 0;
		//ignoramos los 0 no significativos
		/*while ((arrNumb[j] == 0) && (j< 4))
			j++;
			*/
		//sumamos
		
		for (int i=4; i>=0; i--) {
			num= num+ arrNumb[i]*(int)(Math.pow(10, 4-i));
		}
		return num;		
	}

	public static void shiftZerosR(int[] arrNumb) {
		int j= 0;

		while (j==0 && (j < arrNumb.length))
			j++;

		for(int i=arrNumb.length-1; i>=j; i--)
			arrNumb[i]=arrNumb[i-1];
	}

	public static void main(String[] args) {

		int[] nros= new int[5];

		ArrayList<Integer> capicuas = new ArrayList<Integer>();

		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				for (int k=0; k<5; k++) {
					for (int l=0; l<5; l++) {
						for (int m=0; m<5; m++) {
							//generamos todos los numeros posibles de 5 digitos incluyendo 0 no sign
							nros[0]= i;
							nros[1]= j;
							nros[2]= k;
							nros[3]= l;
							nros[4]= m;
							
							if (isCapicua(nros))
								capicuas.add(arrayToInteger(nros));
						}
					}
				}
			}
		}

		/* se podria modularizar lo siguiente como una funcion que retorne los 
		2 numeros de un ArrayList, cuya distancia sea minima */

		int minDist= 99999; //max nro de 5 digitos -> dist maxima entre 2 de ellos
		Integer[] result= new Integer[2];
		System.out.println(capicuas.size());
		System.out.println(capicuas.get(0));

		for (int x=0; x < capicuas.size()-1; x++) {
			for (int y=x+1; y < capicuas.size(); y++) {
				if (minDist > (capicuas.get(y) - capicuas.get(x))) {
					minDist= capicuas.get(y) - capicuas.get(x);
					result[0]= capicuas.get(x);
					result[1]= capicuas.get(y);
				}				
			}
		}

		System.out.println(Arrays.toString(result));
		System.out.println("Distancia: "+minDist);


	}
}						
