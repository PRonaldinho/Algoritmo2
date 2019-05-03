import java.io.FileReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Main{

	public static void main(String [] args){

		Graph<String> grafo = new Graph<String>();
		Scanner leer = new Scanner(new java.io.BufferedInputStream(System.in));
		String filename  = args[0];
    	String delimiter = "/";
		grafo = cargarDatos(filename, delimiter);
		System.out.println("___Cantidad de vertices: " + grafo.cantVertices());
		System.out.println("___Cantidad de Arista: " + grafo.cantArista());
		grafo.mostrarGrafo();
		mostrarKrusk (kruskal (grafo) );


	}

	public static Graph<String> cargarDatos(String filename, String delimiter) {

		Graph<String> grafo = new Graph<>();
		try {	
			File file = new File(filename); 
			BufferedReader br = new BufferedReader(new FileReader(file)); 	  
			String st = null;
			while ((st = br.readLine()) != null) {				  
				String[] values = st.split(delimiter);
		        for (int i = 0; i < values.length; i++) {
					if (!grafo.contieneVertice(values[i])){
						grafo.agregarVertice(values[i]);
					}
		        }
			}
			br.close();
		}
		catch (IOException e) {       	
			throw new IllegalArgumentException("Error al leer el archivo: " + filename); 
		} 
		
		try {	
			File file = new File(filename); 
			BufferedReader br = new BufferedReader(new FileReader(file)); 	  
			String st = null;
			while ((st = br.readLine()) != null) {				  
				String[] values = st.split(delimiter); 
		        for (int i = 1; i < values.length; i++) {
					System.out.println("ingrese el costo entre "+values[0]+" y "+values[i]+":");
					Scanner leer = new Scanner(new java.io.BufferedInputStream(System.in));
					double costo = leer.nextDouble();	
					grafo.agregarArista(values[0], values[i], costo);		
		        }
			}
			br.close();
		}
		catch (IOException e) {       	
			throw new IllegalArgumentException("Error al leer el archivo: " + filename); 
		} 
		
		return grafo;
	}

//------------------------------------------------------------------------------------------------

	public static void prims(V ve){
		
		clearAll();
		Vertice<V> v = getVertice(ve);
		v.dist = 0; // v es el mas cercano		
		PriorityQueue<Camino> q = new PriorityQueue<Camino>();
		for(Vertice<V> t : cAlv.values()){		
			q.addAll(new Camino(t,t.dist));
		}
		while (!q.isEmpty()){ // mientras la cola no es vacia
			Camino<V> uu = q.poll(); // se saca el mas cercano
			Vertice<V> u = uu.destino;
			for (Arista<V> we : u.adj){
				Vertice<V> w = we.destino;			
				double cuw = we.costo;
				Camino<V> qw = new Camino (w, cuw);
				if (q.contains(qw) && w.dist > cuw){
					w.dist = cuw;
					w.anterior = u;
					q.add(new Camino (w,cuw));
					System.out.println ("-----> "+w.info);
				}					
			}
		}
		//Graph<V> MST = new Graph<>();
	}

	public static Set<Arista<String>> kruskal(Graph<String> grafo){

		Set<Arista<String>> es = new HashSet<Arista<String>>();
		PriorityQueue<Arista<String>> h = new PriorityQueue<Arista<String>>(grafo.getAristas());
		DisjointSet s = new DisjointSet (grafo.cantVertices()-2);
		while (!h.isEmpty()){
			Arista<String> e = h.remove();
			Vertice<String> u = e.origen;
			Vertice<String> v = e.destino;
			System.out.println("origen: "+u.info);
			System.out.println("Destino: "+v.info);
			System.out.println("Costo: "+e.costo);
			if (s.find(u.numNodo) != s.find(v.numNodo)){
				es.add(e);
				s.union(u.numNodo,v.numNodo);
			}
		}
		return es;
	}

	public static void mostrarKrusk(Set<Arista<String>> conjunto){

		String s = "";
		Iterator<Arista<String>> it = conjunto.iterator();
		while (it.hasNext()){
			Arista<String> p = it.next();
			System.out.println("--> "+p.origen.info);
			System.out.println("-----> "+p.destino.info+" ["+p.costo+"]"); 
		}
	}

}
