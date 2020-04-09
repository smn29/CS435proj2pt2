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
    //used Geek for Geeks as reference: https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/
    // used Geek for Geeks as reference: https://www.geeksforgeeks.org/java-program-for-dijkstras-shortest-path-algorithm-greedy-algo-7/

    HashMap<Integer, Node> mapdist = new HashMap<Integer, Node>();
    HashMap<Integer, Node> visited = new HashMap<Integer, Node>();
    HashSet<Node> set = new HashSet<Node>();
    PriorityQueue<Node> pq = new PriorityQueue<Node>();
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
        visited.put(1, nd);
      }
    }
    return mapdist;
  }

}
