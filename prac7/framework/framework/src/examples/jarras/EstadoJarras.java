package examples.jarras;

import framework.State;

public class EstadoJarras implements State {

	private int contenidoA;
	private int contenidoB;
	
	private EstadoJarras predecesor = null;
	
	
	public EstadoJarras() { }
	
	public EstadoJarras(int contA, int contB) {
		this.contenidoA = contA;
		this.contenidoB = contB;
	}
	
	public EstadoJarras(int contA, int contB, EstadoJarras predecesor) {
		this.contenidoA = contA;
		this.contenidoB = contB;
		this.predecesor = predecesor;
	}
	
	public int getContenidoA() {
		return contenidoA;
	}

	public void setContenidoA(int contenidoA) {
		this.contenidoA = contenidoA;
	}

	public int getContenidoB() {
		return contenidoB;
	}

	public void setContenidoB(int contenidoB) {
		this.contenidoB = contenidoB;
	}


	@Override
	public boolean equals(State other) {
		if (!(other instanceof EstadoJarras)) return false;
		EstadoJarras otro = (EstadoJarras) other;
		return (this.contenidoA==otro.getContenidoA() && this.contenidoB==otro.getContenidoB());
	}
	
	@Override
	public String toString() {
		return "("+contenidoA+","+contenidoB+")";
	}

	@Override
	public State predecessor() {
		return predecesor;
	}
	
}
