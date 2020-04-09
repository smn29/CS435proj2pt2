import java.util.*;
import java.util.HashMap;
import java.util.HashSet;
 

public class DirectedGraph{
  HashSet<Node> nodeset;
  HashMap<Integer, Node> nodegraph;

  public DirectedGraph(){
    nodeset = new HashSet<Node>();
    nodegraph = new HashMap<Integer, Node>();
  }

  public void addNode(final int nodeVal){
    Node n = new Node(nodeVal);
    nodeset.add(n);
    nodegraph.put(nodeVal, n);
  }

  public void addDirectedEdge(final Node first, final Node second){
    sval = second.data();
    HashMap<Integer, Node> fmap = first.nodes();
    HashMap<Integer, Node> smap = second.nodes();
    if(nodegraph.containsValue(first) && nodegraph.containsValue(second)){
      if(!fmap.containsValue(second)&&
       !smap.containsValue(first)){
        fmap.put(sval, second);
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
