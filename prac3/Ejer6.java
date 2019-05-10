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
		if (begin == end+2) {
      		return fuerzaBruta (array,end);
    	}
		if (begin<end){
			int mid = (begin+end)/2;
			Tupla2<Tupla2<Double>> a = puntos(array,begin,mid);
			Tupla2<Tupla2<Double>> b = puntos(array,mid+1,end);
			Tupla2<Tupla2<Double>> c = cercano (array,begin,mid,end);
	//		System.out.println(a.toString());
//			System.out.println(b.toString());
//			System.out.println(c.toString());
			ret = minTup ( minTup (a, b) , c);	
		}
		return ret;
	}

	
	public static Tupla2<Tupla2<Double>> cercano(LinkedList<Tupla2<Double>> array, int begin, int mid, int end) {

		Double dmin = Double.MAX_VALUE;
		Tupla2<Tupla2<Double>> resultado = new Tupla2<Tupla2<Double>>(new Tupla2<Double>(dmin,dmin), new Tupla2<Double>(dmin,dmin));
		for (int i=begin; i<=mid; i++){
			if ( Math.abs(array.get(i).fst - array.get(mid).fst) < dmin){
				Double x1 = array.get(i).fst;
				Double x2 =	array.get(mid).fst;
				Double y1 =	array.get(i).snd;
				Double y2 =	array.get(mid).snd;
				Double d = Math.sqrt( Math.pow ( (Math.abs(x2-x1) ),2) + Math.pow( (Math.abs(y2-y1)),2) );
			//	if (d < dmin){ 
					dmin = d;
					resultado = new Tupla2<Tupla2<Double>>(array.get(i),array.get(mid));
					System.out.println(dmin);
			//	}
			}
		}
		return resultado;
	}
	
	public static Tupla2<Tupla2<Double>> minTup(Tupla2<Tupla2<Double>> tup1, Tupla2<Tupla2<Double>> tup2) {
		
		Double x1 = tup1.fst.fst;
		Double x2 =	tup1.snd.fst;
		Double y1 =	tup1.fst.snd;
		Double y2 =	tup1.snd.snd;
		Double d1 = Math.sqrt( Math.pow((x2-x1),2) + Math.pow((y2-y1),2) );
		System.out.println(tup1.toString());
		System.out.println(tup2.toString());
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

	public static Tupla2<Tupla2<Double>> fuerzaBruta(LinkedList<Tupla2<Double>> array,int n){
		
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
