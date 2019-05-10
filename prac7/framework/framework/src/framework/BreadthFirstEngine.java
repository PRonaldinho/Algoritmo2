package framework;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstEngine <S extends State, Problem extends AbstractSearchProblem<S>> extends AbstractSearchEngine<S,Problem>{

	private Queue<S> abiertos;
	private S resultado;
	private int estadosVisitados;


	/** 
	 * Constructor for class BreadthFirstEngine  
	 * @pre. true.
	 * @post. Lists visited and path are initialised as empty.
	 */
	public BreadthFirstEngine() {
	  super();
	  abiertos = new LinkedList<S>();
	  resultado = null;
	  estadosVisitados = 0;
	}
	
	/** 
	 * Constructor for class BreadthFirstEngine
	 * @param p is the search problem associated with the engine
	   being created.
	 * @pre. p!=null.
	 * @post. A reference to p is stored in field problem. Lists visited and
	   path are initialised as empty.
	 */
	public BreadthFirstEngine(Problem p) {
	  super(p);
	  abiertos = new LinkedList<S>();
	  resultado = null;
	  estadosVisitados = 0;
	}
	
	
	/** 
	 * Starts the search for successful states for problem, following a 
	 * breadth-first strategy.
	 * @return true iff a successful state is found.
	 * @pre. problem!=null.
	 * @post. the search is performed, the visited are stored in
	   list visited, the path in list path, and true is returned iff a       
	   successfull state is found.
	 */
	public boolean performSearch() {
	
		abiertos.clear();
		this.estadosVisitados = 0;
		abiertos.add(this.problem.initialState());
		boolean exito = false;
		while (!abiertos.isEmpty() && !exito) {
			S corriente = abiertos.poll();
			this.estadosVisitados++;
			if (this.problem.success(corriente)) {
				exito = true;
				resultado = corriente;
			}
			else {
				abiertos.addAll(this.problem.getSuccessors(corriente));
			}
		}
		
		return exito;
	}
	

	
	/** 
	 * Returns the path to a previously calculated successful state for problem.
	 * @return the list of nodes corresponding to the path from the root to
	   the successful node.
	 * @pre. performSearch() has been executed and finished successfully.
	 * @post. the path to the found success node is returned.  
	 */
	public List<S> getPath() {
		if (resultado == null) throw new IllegalStateException("you have to perform a successful search to get the path");
		List<S> camino = new LinkedList<S>();
		camino.add(resultado);
		boolean inicioAlcanzado = false;
		while (!inicioAlcanzado) {
			S primero = camino.get(0);
			if (primero.predecessor()==null) {
				inicioAlcanzado = true;
			}
			else {
				camino.add(0,(S) primero.predecessor());
			}	
		}
		return camino;
	}
	
	
	/** 
	 * Reports information regarding a previously executed search.   
	 * @pre. performSearch() has been executed and finished.
	 * @post. A report regarding the search is printed to standard output.
	   This report consists of the length of the path obtained, and the number
	   of visited states.
	 */    
	@Override
	public void report() {
		System.out.println("Resultado de la busqueda: " + resultado==null?"NO ENCONTRADO":"ENCONTRADO");
		System.out.println("Estados visitados: " + this.estadosVisitados);
		if (resultado!=null) {
			System.out.println("Camino al exito: " + this.getPath().toString());
		}
	}
	
	
	}
