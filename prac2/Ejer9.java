import java.util.*;
import java.lang.*;

public class Ejer9 {

   public static void main(String[] args){ 
	
		LinkedList<Tupla2<Double>> lista = new LinkedList<Tupla2<Double>>();
		Tupla2<Double> a= new Tupla2<Double>(1.0,1.0);
		Tupla2<Double> b= new Tupla2<Double>(2.0,2.0);
		Tupla2<Double> c= new Tupla2<Double>(4.0,4.0);
		Tupla2<Double> d= new Tupla2<Double>(1.0,5.0);
		Tupla2<Double> e= new Tupla2<Double>(4.0,2.0);
		lista.add(a);
		lista.add(b);
		lista.add(c);
		lista.add(d);
		lista.add(e);
		System.out.println("puntos mas cercanos: "+ puntos(lista,lista.size()).toString());
	}	


	public static Tupla2<Tupla2<Double>> puntos(LinkedList<Tupla2<Double>> array,int n){
		
		Double dmin = Double.MAX_VALUE;
		Tupla2<Tupla2<Double>> resultado = new Tupla2<Tupla2<Double>>(new Tupla2<Double>(dmin,dmin), new Tupla2<Double>(dmin,dmin));
		for (int i=0; i<n-1; i++){
			for (int j=i+1; j<n; j++){
				Double x1 = array.get(i).fst;
				Double x2 =	array.get(j).fst;
				Double y1 =	array.get(i).snd;
				Double y2 =	array.get(j).snd;
				Double d = Math.sqrt( Math.pow((x2-x1),2) + Math.pow((y2-y1),2) );
				if (d < dmin){
					dmin = d;
					resultado = new Tupla2<Tupla2<Double>>(array.get(i),array.get(j));
				}
			}
		}
		return resultado;
	}
}

