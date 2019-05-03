// utilizado para señalar violaciones de condiciones
// previas para varios algoritmos de ruta mas corta.

class GraphException extends RuntimeException {

	public GraphException(String name){ 
		super(name); 
	}
}
