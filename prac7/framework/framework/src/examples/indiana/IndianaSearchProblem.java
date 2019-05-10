/**
 * Title:        IndianaSearchProblem<p>
 * Description:  class describing the basics of the Indiana Jones problem as 
                 a search problem.<p>
 * Copyright:    Copyright (c) N. Aguirre 2009<p>
 * Company:      Dpto. de Computacion, FCEFQyN, Univ. Nac. de Rio Cuarto<p>
 * @author N. Aguirre
 * @version 0.1
 */

package examples.indiana;

import framework.AbstractSearchProblem;
import java.util.LinkedList;
import java.util.List;


/* ------------------------------------------------------------------------- */
/* ------------------------------------------------------------------------- */
/* class IndianaSearchProblem: class which defines the basic elements        */
/* necessary for the characterisation of search of solutions to the Indiana  */
/* Jones problem.                                                            */
/* It implements the AbstractSearchProblem interface.                        */
/* ------------------------------------------------------------------------- */
/* ------------------------------------------------------------------------- */

public class IndianaSearchProblem implements AbstractSearchProblem<IndianaState> {


  private IndianaState initial;
  
  /**
   * IndianaSearchProblem initialization.
   */
  public IndianaSearchProblem() {

    initial = new IndianaState(true, true, true, true, true,0);

  } 

  /**
   * Implements initialState from AbstractSearchProblem.
   */
  public IndianaState initialState() {

    return initial;

  } // end of initialState

  /**
   * method getSuccessors(State s): returns a list containing the possible
     positions to move to from s.                                          
     Precondition: s is an instance of IndianaState, containing valid     
     contents of the Indiana Jones problem.                               
     Postcondition: the list of possible valid positions to move to from s 
     is returned. 
   */
  public List<IndianaState> getSuccessors(IndianaState s) {
    // list to store the successors of s
    List<IndianaState>  successors = new LinkedList<IndianaState>(); 
    IndianaState js = (IndianaState) s;
    if (js.getTime() <= 60) { 
      if (js.getTorchIsNear()) {
        if (js.getIndianaIsNear() && js.getGirlIsNear()) {
          successors.add(0,new IndianaState(false, false, js.getFatherIsNear(), 
                            js.getFilIsNear(), false, js.getTime() + 10));
        }
        if (js.getIndianaIsNear() && js.getFatherIsNear()) {
          successors.add(0,new IndianaState(false, js.getGirlIsNear(), false, 
                          js.getFilIsNear(), false, js.getTime() + 20));
        }
        if (js.getIndianaIsNear() && js.getFilIsNear()) {
          successors.add(0,new IndianaState(false, js.getGirlIsNear(), 
                          js.getFatherIsNear(), false, false, js.getTime() + 25));
        }
        if (js.getGirlIsNear() && js.getFatherIsNear()) {
          successors.add(0,new IndianaState(js.getIndianaIsNear(), false, false, 
                          js.getFilIsNear(), false, js.getTime() + 20));
        }
        if (js.getGirlIsNear() && js.getFilIsNear()) {
          successors.add(0,new IndianaState(js.getIndianaIsNear(), false, 
                        js.getFatherIsNear(), false, false, js.getTime() + 25));
        }
        if (js.getFatherIsNear() && js.getFilIsNear()) {
          successors.add(0,new IndianaState(js.getIndianaIsNear(), 
                          js.getGirlIsNear(), false, false, false, js.getTime() + 25));
        }
      } else {
        if (!js.getIndianaIsNear()) {
          successors.add(0, new IndianaState(true, js.getGirlIsNear(), 
               js.getFatherIsNear(), js.getFilIsNear(), true, js.getTime() + 5));
        }    
        if (!js.getGirlIsNear()) {
          successors.add(0, new IndianaState(js.getIndianaIsNear(), true, 
              js.getFatherIsNear(), js.getFilIsNear(), true, js.getTime() + 10));
        }  
        if (!js.getFatherIsNear()) {
          successors.add(0, new IndianaState(js.getIndianaIsNear(),
              js.getGirlIsNear(), true, js.getFilIsNear(), true, js.getTime() + 20));
        }  
        if (!js.getFilIsNear()) {
          successors.add(0, new IndianaState(js.getIndianaIsNear(), 
               js.getGirlIsNear(), js.getFatherIsNear(), true, true, js.getTime() + 25));
        }  
      }
    }
    return successors;
  } // end of getSuccessors

  /**
   * Implements success from AbstractSearchProblem.
   */
  public boolean success(IndianaState s)  {
    IndianaState ms = (IndianaState) s;
    return (!ms.getIndianaIsNear() && !ms.getGirlIsNear() && !ms.getFatherIsNear() 
        && !ms.getFilIsNear() && (ms.getTime() <= 60));
  } // end of success

 
}
