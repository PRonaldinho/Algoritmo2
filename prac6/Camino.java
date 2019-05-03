// Represents an entry in the priority queue for Dijkstra's algorithm.
class Camino<V> implements Comparable<Camino>{
	
	public Vertice<V> destino; // w
	public double costo; // d(w)

	public Camino(Vertice<V> d, double c){
		
		destino = d;
		costo = c;
	}

	public int compareTo(Camino a){

		return (this.costo < a.costo ? -1 : this.costo > a.costo ? 1 : 0);
	}
	
	public int compare(Camino a, Camino b){

		return a.costo < b.costo ? -1 : a.costo > b.costo ? 1 : 0;
	}

	public boolean equals(Camino a){

		return (this.destino.info.equals(a.destino.info) && this.costo == a.costo);
	}
}
