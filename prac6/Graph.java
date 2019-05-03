import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.LinkedList;

public class Graph<V>{

	public static final double INFINITY = Double.MAX_VALUE;
	private Map<V,Vertice<V>> cAlv = new HashMap<V,Vertice<V>>();
	
	//Constructor grafo
	public Graph(){
	}

	//dice si el grafo es vacio
	public boolean esVacio() {
		return ( cantVertices() == 0 );
	}

	// cantidad de vertices del grafo
	public int cantVertices() {
		return cAlv.keySet().size();
	}

	public Map<V,Vertice<V>> getcAlv() {
		return cAlv;
	}

	//cantidad de arista del grafo
	public int cantArista() {
		int a=0;
		Set<V> aux = cAlv.keySet(); 
		Iterator<V> it = aux.iterator();
		while (it.hasNext()){
			Vertice<V> p = getVertice(it.next());
			a = a + p.adj.size();
		}
		return a;	 
	}

	public LinkedList<Arista<V>> getAristas() {
		
		LinkedList<Arista<V>> aux = new LinkedList<Arista<V>>();
		for(Vertice<V> v : cAlv.values()){
			for (Arista<V> x: v.adj){
				aux.add(x);
			}
		}
		return aux;	 
	}

	//determna si hay un arco entre dos vertices dados
	public boolean contieneArista (V ve,V we){
		Vertice<V> v = getVertice(ve);
		Vertice<V> w = getVertice(we);
		boolean a = false;
		for (Arista<V> x: v.adj){
			if ( we.equals(x.destino.info) ){
				a=true;
				break;
			}
		}
		boolean b= false;		
		for (Arista<V> x: w.adj){
			if ( ve.equals(x.destino.info) ){
				a=true;
				break;
			}
		}
		return ( a || b );
	}

	//inserta un vertice al grafo
	public void agregarVertice(V v) {
		cAlv.put(v, new Vertice<V>(v,cantVertices()+1));
	}

	/**
	 * agregar una nueva arista al grafo.
	 */
	public void agregarArista (V nombreDeOrigen, V nombreDeDestino, double costo){
		
		Vertice<V> v = getVertice(nombreDeOrigen);
		Vertice<V> w = getVertice(nombreDeDestino);
		v.adj.add(new Arista(v,w,costo));
	}

	//borra un vertice del grafo
	public void borrarVertice(V v) {
		cAlv.remove(v);
	}

	// borra una arista del grafo
	public void borrarArista(V ve, V we) {
		Vertice<V> v = getVertice(ve);
		for (Arista<V> x: v.adj){
			if ( we.equals(x.destino.info) ){
				v.adj.remove(x);
				break;
			}
		}
	}

	//dice si un vertice pertenece al grafo
	public boolean contieneVertice(V v) {
		return cAlv.containsKey(v);
	}

	// implementa recursivamente el Depth-First Search (DFS)
	public void dfs(V ve){
		Vertice<V> v = getVertice(ve); 
		System.out.println(v.info); //process
		v.marcar(); 
		for ( Arista<V> w: v.adj){ 
			if (w.destino.marca == 0) 
				dfs(w.destino.info);
		}
	}

	

	// implementa Breadth-First Search (BFS) con cola
	public void bfs(V ve){
		clearAll();
		Vertice<V> v = getVertice(ve);
		Queue<Vertice<V>> q = new LinkedList<Vertice<V>>();
		q.add(v);
		v.marcar();
		while (! q.isEmpty()){
			Vertice<V> w = q.remove();
			System.out.println(w.info); //process
			for (Arista<V> x: w.adj) {
				if (x.destino.marca == 0){
					x.destino.marcar(); 
					q.add(x.destino); 
				}
			}
		}
	}

	/**
	 * Rutina del conductor para manejar los inalcanzable e imprimir el costo total
	 * Llama a la rutina recursiva para imprimir la ruta mas corta al nodo
	 * nombreDeDestino despues de que se haya ejecutado un algoritmo de la ruta mas corta
	 */
	public void printCamino (V nombreDeDestino){

		Vertice<V> w = cAlv.get(nombreDeDestino);
		if ( w == null )
			throw new NoSuchElementException();
		else if (w.dist == INFINITY)
			System.out.println (nombreDeDestino +" es inalcanzable");
		else{
			System.out.print("(el costo es: "+ w.dist +") ");
			printCamino(w);
			System.out.println();
		}
	}

	/**
	 * Si vertexName no esta, lo agrega a cAlv.
	 * el cualquier caso, devuelve el vertice.
	 */
	private Vertice<V> getVertice (V vertexName){

		Vertice<V> v = cAlv.get( vertexName );
	/*	if( v == null ){
			v = new Vertice<V>( vertexName );
			cAlv.put( vertexName, v );
		}*/
		return v;
	}

	/**
	 * Rutina recursiva para imprimir la ruta mas corta a destino
	 * despues de ejecutar el algoritmo de ruta mas corta.
	 * se sabe que el camino existe.
	 */
	private void printCamino (Vertice<V> destino){

		if (destino.anterior != null){
			printCamino( destino.anterior );
			System.out.print(" to ");
		}
		System.out.print(destino.info);
	}

	/**
	 * Inicializa la informacion de saida de vertice antes de ejecutar
	 * cualquier algoritmo de ruta mas corta.
	 */
	private void clearAll(){
	
		for(Vertice<V> v : cAlv.values())
			v.reset();
	}

	public void mostrarGrafo(){
		System.out.println ("  #############");
		System.out.println ("  ### GRAFO ###");
		System.out.println ("  #############");
		for(Vertice<V> v : cAlv.values()){
			System.out.println ("-> "+v.info+"   Num :"+v.numNodo);
			for (Arista<V> x: v.adj){
				System.out.println ("-----> "+x.destino.info);
			}
			System.out.println (" ");
		}
	}

	public void printCamino2 (V nombreDeDestino){

		Vertice<V> w = cAlv.get(nombreDeDestino);
		if ( w == null )
			throw new NoSuchElementException();
		else if (w.dist2 < 0)
			System.out.println (nombreDeDestino +" es inalcanzable");
		else{
			System.out.print("(cantidad de Nodos : "+ w.dist2 +") ");
			printCamino(w);
			System.out.println();
		}
	}

}
