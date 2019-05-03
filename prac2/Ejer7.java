import java.util.*;
import java.lang.*;

public class Ejer7 {

    public static void main(String[] args){ 
        
		LinkedList<Tupla<String,Integer>> send = new LinkedList<>();
		LinkedList<Tupla<String,Integer>> more = new LinkedList<>();
		LinkedList<Tupla<String,Integer>> money = new LinkedList<>();
    	inicializarSend (send);
		inicializarMore (more);
		money = calcularMoney (send,more);
		mostrar(send,more,money);
	}	

	public static void inicializarSend(LinkedList lista){
			Scanner leer = new Scanner(System.in);
			Tupla<String,Integer> ss = new Tupla();
			Tupla<String,Integer> ee = new Tupla();
			Tupla<String,Integer> nn = new Tupla();
			Tupla<String,Integer> dd = new Tupla();
        	System.out.println ("Ingrese cifra de s: ");
			Integer s = leer.nextInt();
			ss.changeFst("s");
			ss.changeSnd(s);
			lista.add(0,ss);
			System.out.println ("Ingrese cifra de e: ");
			Integer e = leer.nextInt();
			ee.changeFst("e");
			ee.changeSnd(e);
			lista.add(1,ee);
			System.out.println ("Ingrese cifra de n: ");
			Integer n = leer.nextInt();
			nn.changeFst("n");
			nn.changeSnd(n);
			lista.add(2,nn);
			System.out.println ("Ingrese cifra de d: ");
			Integer d = leer.nextInt();
			dd.changeFst("d");
			dd.changeSnd(d);
			lista.add(3,dd);
	}

	public static void inicializarMore(LinkedList lista){
			Scanner leer = new Scanner(System.in);
			Tupla<String,Integer> mm = new Tupla();
			Tupla<String,Integer> oo = new Tupla();
			Tupla<String,Integer> rr = new Tupla();
			Tupla<String,Integer> ee = new Tupla();
        	System.out.println ("Ingrese cifra de m: ");
			Integer m = leer.nextInt();
			mm.changeFst("m");
			mm.changeSnd(m);
			lista.add(0,mm);
			System.out.println ("Ingrese cifra de o: ");
			Integer o = leer.nextInt();
			oo.changeFst("o");
			oo.changeSnd(o);
			lista.add(1,oo);
			System.out.println ("Ingrese cifra de r: ");
			Integer r = leer.nextInt();
			rr.changeFst("r");
			rr.changeSnd(r);
			lista.add(2,rr);
			System.out.println ("Ingrese cifra de e: ");
			Integer e = leer.nextInt();
			ee.changeFst("e");
			ee.changeSnd(e);
			lista.add(3,ee);
	}

	public static LinkedList<Tupla<String,Integer>> calcularMoney(LinkedList<Tupla<String,Integer>> send, LinkedList<Tupla<String,Integer>> more){
		
		LinkedList<Tupla<String,Integer>> aux = new LinkedList<>();
		aux.add(0,more.get(0));
		aux.add(1,more.get(1));
		aux.add(2,send.get(1));
		aux.add(3,more.get(3));
		Integer calcu = send.get(3).snd() + more.get(3).snd();
		String c = String.valueOf(calcu);
		if (c.length() == 2){
			Integer b = Integer.parseInt(String.valueOf(c.charAt(1)));
			calcu=b;
		}
		Tupla<String,Integer> yy = new Tupla<String,Integer>("y",calcu);
		aux.add(4,yy);
		return aux;
	}

	public static void mostrar(LinkedList<Tupla<String,Integer>> send, LinkedList<Tupla<String,Integer>> more, LinkedList<Tupla<String,Integer>> money){

		System.out.print ("   send      ");
		for (int i=0; i<4; i++){
            System.out.print (send.get(i).snd());
		}
		System.out.println ("");
		System.out.print ("  +more     +");
		for (int i=0; i<4; i++){
            System.out.print (more.get(i).snd());
		}
		System.out.println ("");
		System.out.println ("   _____     ______");
		System.out.print ("   money     ");
		for (int i=0; i<5; i++){
            System.out.print (money.get(i).snd());
		}
		System.out.println ("");
	}
}
