package examples.indiana;

import framework.DepthFirstEngine;
import framework.BreadthFirstEngine;
import java.util.List;

/**
 * Main application of Indiana example.
 *
 */
public class AppIndiana {
  /**
   * main function of Indiana application.
   * @param args - 
   */
  public static void main(String[] args) {
        
    if (args.length != 0) {
      System.out.println("*** Usage: java appIndiana");
    } else {
    	
      //DFS
      IndianaSearchProblem p = new IndianaSearchProblem();
      DepthFirstEngine<IndianaState,IndianaSearchProblem> engine2 = 
                    new DepthFirstEngine<IndianaState,IndianaSearchProblem>(p);
      boolean success = engine2.performSearch();
      System.out.println();
      System.out.println("*** Result using depth-first search ***");
      System.out.println("Solution found? " + success);
      if (success) {
        System.out.print("Path to goal: ");
        List<IndianaState> path = engine2.getPath();
        for (int i = 0; i < path.size(); i++) {
          IndianaState current = (IndianaState) path.get(i);
          System.out.print(current.toString());
        }
        System.out.println();
      }
      engine2.report();
      
      //BFS
      IndianaSearchProblem pp = new IndianaSearchProblem();
      BreadthFirstEngine<IndianaState,IndianaSearchProblem> engine3 = 
                    new BreadthFirstEngine<IndianaState,IndianaSearchProblem>(pp);
      boolean success2 = engine3.performSearch();
      System.out.println();
      System.out.println("*** Result using breadth-first search ***");
      System.out.println("Solution found? " + success2);
      if (success2) {
        System.out.print("Path to goal: ");
        List<IndianaState> path2 = engine3.getPath();
        for (int i = 0; i < path2.size(); i++) {
          IndianaState current2 = (IndianaState) path2.get(i);
          System.out.print(current2.toString());
        }
        System.out.println();
      }
      engine3.report();
      
    }
     
  } // end of main
    
} // end of appSearch
