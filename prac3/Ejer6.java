import java.util.*;

public class Ejer6{

	public static void main(String[] args){ 
	
		LinkedList<Tupla2<Double>> lista = new LinkedList<Tupla2<Double>>();
		Tupla2<Double> a= new Tupla2<Double>(1.0,1.0);
		Tupla2<Double> b= new Tupla2<Double>(4.0,4.0);
		Tupla2<Double> c= new Tupla2<Double>(2.0,2.0);
		Tupla2<Double> d= new Tupla2<Double>(1.0,5.0);
		Tupla2<Double> e= new Tupla2<Double>(4.0,2.0);
		lista.add(a);
		lista.add(b);
		lista.add(c);
		lista.add(d);
		lista.add(e);
		System.out.println("puntos mas cercanos: "+ puntos(lista,0,lista.size()-1).toString());
	}

	public static Tupla2<Tupla2<Double>> puntos(LinkedList<Tupla2<Double>> array, int begin, int end){
			
		Tupla2<Tupla2<Double>> ret = new Tupla2<Tupla2<Double>>();
		if (begin == end) {
      		return new Tupla2<Tupla2<Double>> (array.get(begin),array.get(end));
    	}
		if (begin<end){
			int mid = (begin+end)/2;
			Tupla2<Tupla2<Double>> a = puntos(array,begin,mid);
			Tupla2<Tupla2<Double>> b = puntos(array,mid+1,end);
			Tupla2<Tupla2<Double>> c = cercano (array,begin,mid,end);
			ret = minTup ( minTup (a, b) , c);	
		}
		return ret;
	}
	// raiz (4-4)
	
	public static Tupla2<Tupla2<Double>> cercano(LinkedList<Tupla2<Double>> array, int begin, int mid, int end) {

		Double dmin = Double.MAX_VALUE;
		Tupla2<Tupla2<Double>> resultado = new Tupla2<Tupla2<Double>>(new Tupla2<Double>(dmin,dmin), new Tupla2<Double>(dmin,dmin));
		for (int i=0; i<=mid; i++){
			for (int j=mid+1; j<=end; j++){
				Double x1 = array.get(i).fst;
				Double x2 =	array.get(j).fst;
				Double y1 =	array.get(i).snd;
				Double y2 =	array.get(j).snd;
				Double d = Math.sqrt( Math.pow((x2-x1),2) + Math.pow((y2-y1),2) );
				if (d < dmin){
					dmin = d;
					resultado = new Tupla2<Tupla2<Double>>(array.get(i),array.get(j));
					System.out.println(dmin);
				}
			}
		}
/* for (int i=mid+1; i<=end; i++){
			for (int j=i+1; j<=end; j++){
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
	}*/
		return resultado;
	}
	
	public static Tupla2<Tupla2<Double>> minTup(Tupla2<Tupla2<Double>> tup1, Tupla2<Tupla2<Double>> tup2) {
		
		Double x1 = tup1.fst.fst;
		Double x2 =	tup1.snd.fst;
		Double y1 =	tup1.fst.snd;
		Double y2 =	tup1.snd.snd;
		Double d1 = Math.sqrt( Math.pow((x2-x1),2) + Math.pow((y2-y1),2) );
		
		Double x11 = tup2.fst.fst;
		Double x22 = tup2.snd.fst;
		Double y11 = tup2.fst.snd;
		Double y22 = tup2.snd.snd;
		Double d2 = Math.sqrt( Math.pow((x22-x11),2) + Math.pow((y22-y11),2) );

		if (d1 < d2)
			return tup2;
		else
			return tup1; 
	}


}  
