import java.util.*;
import java.util.HashMap;
import java.util.HashSet;
 

public class WeightedGraph{
  HashSet<Node> nodeset;
  HashMap<Integer, Node> nodegraph;

  public WeightedGraph(){
    nodeset = new HashSet<Node>();
    nodegraph = new HashMap<Integer, Node>();
  }

  public void addNode(final int nodeVal){
    Node n = new Node(nodeVal);
    nodeset.add(n);
    nodegraph.put(nodeVal, n);
  }

  public void addWeightedEdge(final Node first, final Node second, final int edgeweight){
    HashMap<Integer, Node> fmap = first.nodes();
    HashMap<Integer, Node> smap = second.nodes();
    if(nodegraph.containsValue(first) && nodegraph.containsValue(second)){
      if(!fmap.containsValue(second)&&
       !smap.containsValue(first)){
        fmap.put(edgeweight, second);
      }
    }
  }

  public void removeDirectedEdge(final Node first, final Node second){
    sval = second.data();
    HashMap<Integer, Node> fmap = first.nodes();
    if(nodegraph.containsValue(first) && nodegraph.containsValue(second)){
      fmap.remove(sval);
    }
  }

  public HashSet<Node> getAllNodes(){
    return nodeset;
  }
}
