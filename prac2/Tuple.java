public class Tuple<T>{

	public T fst;
	public T snd;
	public T ter; 

	public Tuple(){
	
		this.fst = null;
		this.snd = null;
		this.ter = null;
	}

	public Tuple (T xx ,T yy, T zz){
	
		this.fst = xx;
		this.snd = yy;
		this.ter = zz;
	}

	public String toString (){
	
		return (" ("+this.fst+","+this.snd+this.ter+") ");
	}
	
}
