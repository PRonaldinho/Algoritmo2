package examples.indiana;
import framework.State;
 
public class IndianaState implements State {


    private int time;
    private boolean indianaIsNear; 
    private boolean girlIsNear; 
    private boolean fatherIsNear; 
    private boolean filIsNear; 
    private boolean torchIsNear; 



     public IndianaState(boolean iState, boolean gState, boolean fState, boolean sState, boolean tState, int time)  {
         indianaIsNear = iState;
         girlIsNear = gState;
         fatherIsNear = fState;
         filIsNear = sState;
         torchIsNear = tState;
         this.time = time;
     } // end of constructor JugsState
     

     public boolean getIndianaIsNear() {
         return indianaIsNear;
     } 
     
     public boolean getGirlIsNear() {
         return girlIsNear;
     } 

     public boolean getFatherIsNear() {
         return fatherIsNear;
     } 

     public boolean getFilIsNear() {
         return filIsNear;
     } 

    public int getTime() {
         return time;
    } 

    public boolean getTorchIsNear() {
        return torchIsNear;
    }


     public boolean equals(State other) {
     
	IndianaState e = (IndianaState) other;
        boolean equal = true;
        if (indianaIsNear != e.getIndianaIsNear()) equal = false;
        if (girlIsNear != e.getGirlIsNear()) equal = false;
        if (fatherIsNear != e.getFatherIsNear()) equal = false;
        if (filIsNear != e.getFilIsNear()) equal = false;
        if (torchIsNear != e.getTorchIsNear()) equal = false;
        if (time != e.getTime()) equal = false;
	return equal;
     } // end of equals
  

    /* --------------------------------------------------------------------- */ 
    /* method toString(): returns a printable version of a JugsState.        */
    /* Precondition: None.                                                   */
    /* Postcondition: a string containing the contents of the jugs A and B   */
    /* is returned.                                                          */
    /* --------------------------------------------------------------------- */ 
     public String toString() {
         String nearPeople = "";
         String farPeople = "";
         if (indianaIsNear) nearPeople = nearPeople + "[Indiana]";
         else farPeople = farPeople + "[Indiana]";
         if (girlIsNear) nearPeople = nearPeople + "[Girl]";
         else farPeople = farPeople + "[Girl]";
         if (fatherIsNear) nearPeople = nearPeople + "[Father]";
         else farPeople = farPeople + "[Father]";
         if (filIsNear) nearPeople = nearPeople + "[Fil]";
         else farPeople = farPeople + "[Fil]";
         if (torchIsNear) nearPeople = nearPeople + "[Torch]";
         else farPeople = farPeople + "[Torch]";
         return ("("+nearPeople+","+farPeople+","+time+")");
	      
     } // end of toString


	@Override
	public State predecessor() {
		// TODO Auto-generated method stub
		return null;
	}


} // end of class JugsState
