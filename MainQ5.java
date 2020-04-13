import java.util.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Main {
  public static void main(String[] args) {
    WeightedGraph graph = createRandomCompleteWeightedGraph(20);
    Node begin = graph.nodegraph();
    dijkstras(begin);
  }

  public static WeightedGraph createRandomCompleteWeightedGraph(final int x){
    Graph g = new Graph();
    Random rand = new random();
    HashSet<Node> set = g.getAllNodes();
    for(int i = 0; i < x; i++){
      g.addNode(i);
      Node n = g.nodegraph.get(i);
      for(Node node: set){
        ri = rand.nextInt(x);  
        //randomly assign edges    
        if((ri%2 == 0)){
          g.addWeightedEdge(n, node, ri);
          g.addWeightedEdge(node, n, ri);
        }
      }
    }
    return g;
  }

  public static WeightedGraph createLinkedList(final int n){
    Graph g = new Graph();
    for(int i = 1; i <= n; i++){
      g.addNode(i);
      Node pos = g.nodegraph.get(i);
      g.addNode(i+1);
      Node next = g.nodegraph.get(i+1);
      HashMap<Integer, Node> posmap = pos.nodes();
      posmap.put(next.data(), next);
    }
  }

   //fix and finish dijkstras (04/08) 
  public static HashMap<Node, Integer> dijkstras(final Node start){
    /*used Geek for Geeks as reference: https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/ and https://www.geeksforgeeks.org/java-program-for-dijkstras-shortest-path-algorithm-greedy-algo-7/

    1.Create an empty map of nodes to distances. Initialize every node to map to infinity.
    2.Set the distance for the origin to 0. Let curr be the origin.
    3.While curr is not null and its distance is not infinity.
      a.“Finalize” curr.
      b.Iterate over its neighbors, “relax” each neighbor:
        i.For each neighbor that is not finalized, update its distance (if less than its current distance) to the sum of curr’s distance and the weight of the edge between curr and this neighbor.
      c.Set curr to the next min distance node – the node with the smallest distance that is not yet finalized.
    */

    HashMap<Integer, Node> mapdist = new HashMap<Integer, Node>();
    HashMap<Integer, Node> visited = new HashMap<Integer, Node>();
    HashSet<Node> set = new HashSet<Node>();
    PriorityQueue<Node> q = new PriorityQueue<Node>();
    int dist = 0;

    set = start.nodeset();
    for(Node n: set){
      start.isTrue();
      mapdist.put(0, start);
      visited.put(0, start);
      HashMap<Integer, Node> nmap = n.nodes();
      if(!nmap.isEmpty()){
        Node prev = start;
        HashMap<Integer, Node> prevmap = prev.nodes();
        dist = prevmap.get(n);
      }
      mapdist.put(dist, n);
      if(n != start){
        q.add(n);
      } 
    }

    while(!q.isEmpty()){
      Node node = q.poll();
      int ndist = mapdist.get(node);
      node.isTrue();
      if(!mapdist.containsKey(node)){
        mapdist.put(ndist, node);
        visited.put(1, node);
      }
    }
    return mapdist;
  }

}
