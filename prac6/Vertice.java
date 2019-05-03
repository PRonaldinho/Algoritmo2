// Representa un vertice del grafo.
import java.util.Queue;
import java.util.LinkedList;

class Vertice<V>{

	public V info; // nombre de vertice
	public Queue<Arista<V>> adj;	//vertices adyacente
	public double dist; // longitud ruta mas corta (Costo)
	public double dist2;
	public Vertice<V> anterior; // Vertice anterior en el camino mas corto
	public int marca;// variable extra usada en el algoritmo
	public int numNodo;

	public Vertice(V nombre,int n){ 
		this.info = nombre;
		this.numNodo = n; 
		adj = new LinkedList<Arista<V>>();
		reset(); 
	}

	public void marcar() {
		this.marca = 1;
	}

	public void reset(){ 
		this.dist = Graph.INFINITY; 
		this.anterior = null;  
		this.marca = 0; 
		this.dist2 = -1;
	}
}
