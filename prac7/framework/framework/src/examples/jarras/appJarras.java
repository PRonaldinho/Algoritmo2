package examples.jarras;

import framework.BreadthFirstEngine;
import framework.DepthFirstEngine;
import framework.IterativeDeepening;

public class appJarras {

	public static void main(String args[]) {
		
		ProblemaJarras p = new ProblemaJarras();
		BreadthFirstEngine<EstadoJarras,ProblemaJarras> motorBfs = new BreadthFirstEngine<EstadoJarras,ProblemaJarras>();
		motorBfs.setProblem(p);
		motorBfs.performSearch();
		motorBfs.report();
		
		ProblemaJarras p3 = new ProblemaJarras();
		IterativeDeepening <EstadoJarras,ProblemaJarras> motorID = new IterativeDeepening <EstadoJarras,ProblemaJarras>();
		motorID.setProblem(p3);
		motorID.performSearch();
		motorID.report();
		
		ProblemaJarras p2 = new ProblemaJarras();
		DepthFirstEngine <EstadoJarras,ProblemaJarras> motorDfs = new DepthFirstEngine <EstadoJarras,ProblemaJarras>();
		motorDfs.setProblem(p2);
		motorDfs.performSearch();
		motorDfs.report();
		
	}
}
