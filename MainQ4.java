import java.util.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    System.out.println("Kahns");
    TopSort.Kahns(createRandomDAGIter(1000));
    System.out.println("DFS");
    TopSort.mDFS(createRandomDAGIter(1000));
  }
  
  public static DirectedGraph createRandomDAGIter(final int x) {
    Graph g = new Graph();
    Random rand = new random();
    HashSet<Node> set = g.getAllNodes();
    for(int i = 0; i < x; i++){
      g.addNode(i);
      Node n = g.nodegraph.get(i);
      for(Node node: set){
        //randomly assign edges
        ri = rand.nextInt(x);      
        if((ri%2 == 0)){
          g.addUndirectedEdge(n, node);
        }
      }
    }
    return g;
  }

}
