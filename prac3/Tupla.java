public class Tupla<A,B> {
	
	public A fst;
	public B snd;
	
	/** 
	 *Constructor de la Clase tupla 
	 */
	public Tupla() {
		    
		this.fst = null;
		this.snd = null;
	}
	
	/** 
	 *Constructor de la clase Tupla. 
	 */
	public Tupla(A x, B y) {
		   
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
