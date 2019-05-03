public class Tupla2<A> {
	
	public A fst;
	public A snd;
	
	public Tupla2() {
		    
		this.fst = null;
		this.snd = null;
	}
	
	/** 
	 *Constructor de la clase Tupla. 
	 */
	public Tupla2(A x, A y) {
		   
		this.fst = x;
		this.snd = y;
	}

	/** 
	 *Overriding toString() to convert Tuple objects to String. 
	 */
	@Override
	public String toString() {
		    
		return ("(" + fst.toString() + "," + snd.toString() + ")");
	}
		  
		  
}
