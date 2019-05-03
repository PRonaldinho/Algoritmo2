public class Tupla<T,E>{

	private T x;
	private E y;

	public Tupla(){
	
		this.x = null;
		this.y = null;
	}

	/**
	* Constructor of the class
	* @param x the first component
	* @param y the second component
	* @precondition true
	* @postcondition creates the new object
	**/
	public Tupla(T xx ,E yy){
	
		this.x = xx;
		this.y = yy;
	}

	/**
	* Get the first coordinate
	* @return the first value of the tupla
	* @precondition true
	* @postcondition return the first item
	**/
	public T fst(){

		return this.x;
	}

	/**
	* Get the second coordinate
	* @return the second value of the tupla
	* @precondition true
	* @postcondition return the second value.
	**/
	public E snd(){
	
		return this.y;
	}

	/**
	* Change the first coordinate
	* @param x change the first value
	* @precondition true
	* @postcondition change x
	**/
	public void changeFst(T x){
	
		this.x = x;
	}

	/**
	* Change the second coordinate
	* @param y change the second value
	* @precondition true
	* @postcondition change the second value
	**/
	public void changeSnd(E y){

		this.y = y;
	}

	public String toString (){
	
		return (" ("+this.x+","+this.y+") ");
	}
	
}
