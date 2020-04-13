import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Math;


public class Main {

	public static void main(String[] args) {
			GridGraph Graph = createRandomGridGraph(100);
			GridNode sourceNode = Graph.getNode(0, 0);
			GridNode destNode = Graph.getNode(100, 100);
			ArrayList<GridNode> asp = astar(sourceNode, destNode);
			for (GridNode n: asp) {
				System.out.print(n.data() + " ");
      }		
	  }
  
  public static GridGraph createRandomGridGraph(int n){
    GridGraph g = new GridGraph();
    Random rand = new Random();
    g.addGridNode(0, 0, 0);
    int tot = 0;
    for(int i = 1; i<= n; i++){
      for(int j = 1; j<= n; j++){
        tot++;
        g.addGridNode(tot, i, j);
        GridNode cur = g.nodegraph.get(i-1).get(j-1)
        if(rand.nextInt(n)%2 == 0){ 
          GridNode rightn = g.nodegraph.get(i-1).get(j)
          g.addUndirectedEdge(cur, rightn);
        }
        if(rand.nextInt(n)%2 == 0){
          GridNode leftn = g.nodegraph.get(i).get(j-1)
          g.addUndirectedEdge(leftn, cur);
        }
      }
    }
  }

  private static int heuristic(final GridNode cur, final GridNode end) {
		int xdistance = Math.abs(cur.getXCoordinate() - end.getXCoordinate());
		int ydistance = Math.abs(cur.getYCoordinate() - end.getYCoordinate());
    int h = xdistance + ydistance;
		return h;
	}
  
  public static ArrayList<GridNode> astar(final GridNode sourceNode, final GridNode destNode) {
  /*
  1. Create an empty map of nodes to pairs of distances (g, h). g is the distance so far, and his the estimated distance to the goal using the heuristic. Initialize every node to map to infinity g.
  2.Calculate the heuristic value for the origin h and set the distance for the origin to (0, h). Let curr be the origin.
  3.While curr is not the destination node:
    a.“Finalize” curr.
    b.Iterate over its neighbors, “relax” each neighbor:
    c.For each neighbor that is not finalized, update its distance (if less than the current g value) to the sum of curr’s distance and the weight of the edge between curr and this neighbor.  Calculate the heuristic value for this neighbor and assign it to h.
    d.Set curr to the next min node – the node with the smallest g+h value not yet finalized.
    4.Return the g value for the destination node.
  */
  HashMap<Integer, Node> mapdist = new HashMap<Integer, Node>();
  HashMap<Integer, Node> visited = new HashMap<Integer, Node>();
  HashSet<Node> set = new HashSet<Node>();
  PriorityQueue<Node> q = new PriorityQueue<Node>();
  int dist = 0;

  set = sourceNode.nodeset();
  for(Node n: set){
    sourceNode.isTrue();
    mapdist.put(heuristic(soruceNode, destNode), sourceNode);
    visited.put(0, sourceNode);
    HashMap<Integer, Node> nmap = n.nodes();
    if(!nmap.isEmpty()){
      Node prev = ssourceNode;
      HashMap<Integer, Node> prevmap = prev.nodes();
      dist = prevmap.get(n);
      }
    mapdist.put(dist, n);
    if(n != sourceNode){
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
