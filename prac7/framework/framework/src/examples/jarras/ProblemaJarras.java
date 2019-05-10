package examples.jarras;

import java.util.LinkedList;
import java.util.List;

import framework.AbstractSearchProblem;

public class ProblemaJarras implements AbstractSearchProblem<EstadoJarras> {

	@Override
	public EstadoJarras initialState() {
		return (new EstadoJarras(0,0));
	}

	@Override
	public List<EstadoJarras> getSuccessors(EstadoJarras s) {
		List<EstadoJarras> resultado = new LinkedList<EstadoJarras>();
		
		resultado.add(new EstadoJarras(0, s.getContenidoB(), s));
		
		resultado.add(new EstadoJarras(s.getContenidoA(), 0, s));
		
		resultado.add(new EstadoJarras(4, s.getContenidoB(), s));
		
		resultado.add(new EstadoJarras(s.getContenidoA(), 3, s));
		EstadoJarras aAb = new EstadoJarras(s.getContenidoA(), s.getContenidoB(), s);
		while (aAb.getContenidoB()<3 && aAb.getContenidoA()>0) {
			aAb.setContenidoB(aAb.getContenidoB()+1);
			aAb.setContenidoA(aAb.getContenidoA()-1);
		}
		resultado.add(aAb);
		EstadoJarras bAa = new EstadoJarras(s.getContenidoA(), s.getContenidoB(), s);
		while (bAa.getContenidoA()<4 && bAa.getContenidoB()>0) {
			bAa.setContenidoA(bAa.getContenidoA()+1);
			bAa.setContenidoB(bAa.getContenidoB()-1);
		}
		resultado.add(bAa);
		return resultado;
	}

	@Override
	public boolean success(EstadoJarras s) {
		return (s.getContenidoA()==2 || s.getContenidoB()==2);
	}

}
