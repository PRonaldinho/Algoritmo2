import java.util.Scanner;

public class Mcd2 {

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
		while (n!=0){
			int r = m % n;
			m=n;
			n=r;
		}
		return m;
	}

}

