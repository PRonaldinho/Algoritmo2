// Representa una arista del grafo.
class Arista<V> implements Comparable<Arista>{

	public Vertice<V> origen; //origen
	public Vertice<V> destino;	// segundo vertice en arista
	public double costo;	// Costo de arista
	
	public Arista( Vertice<V> o,Vertice<V> d, double c ){
		this.origen = o;
		this.destino = d;
		this.costo = c;
	}
	
	@Override	
	public int compareTo(Arista a){

		return (this.costo < a.costo ? -1 : this.costo > a.costo ? 1 : 0);
	}
	
	
	public int compare(Arista a, Arista b){

		return a.costo < b.costo ? -1 : a.costo > b.costo ? 1 : 0;
	}

	
	public boolean equals(Arista a){

		return (this.destino.info.equals(a.destino.info) && this.costo == a.costo);
	}
}
