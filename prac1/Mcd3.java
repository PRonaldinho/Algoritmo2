import java.util.Scanner;

public class Mcd3 {

	public static void main(String [] args){
		Scanner leer = new Scanner(System.in);
		System.out.println("ingrese num1");
		int a = leer.nextInt();
		System.out.println("ingrese num2");
		int b = leer.nextInt();
		//int a = 55;
		//int b = 66;
		System.out.println("MCD de "+a+" y "+b+" es: "+gcd(a,b));
	}

	public static int gcd (int m, int n){
		int[] primoM = sacarCero (primos(m));
		int[] primoN = sacarCero (primos(n));
		int[] pEnComun = enComun(primoM,primoN);
		int p = 1;
		for (int i=0; i < pEnComun.length ;i++)
			p = p * pEnComun[i];
		return p;
	}

	public static int[] enComun (int[] m, int[] n){
		int k=0;
		int l = Math.min (m.length,n.length);
		int[] t = new int[l];
		for (int i=0; i< m.length; i++){
			for (int j=0; j< n.length; j++){
				if (m[i]==n[j]){
					t[k]=m[j];
					k++;
				}
			}
		}
		return t;						
	}

	public static int[] sacarCero (int[] array){
		int t=0;
		for (int i=0; i< array.length; i++){
				if (array[i] != 0)
					t++;
		}		
		int[] aux = new int[t];
		int k =0;		
		for (int i=0; i< array.length; i++){
				if (array[i] != 0){
					aux[k] = array[i];
					k++;
				}
		}
		return aux;						
	}

	public static int[] primos (int a){
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
