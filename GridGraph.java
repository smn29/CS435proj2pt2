import java.util.*;
import java.util.HashMap;
import java.util.HashSet;
 

public class GridGraph{
  HashSet<Node> nodeset;
  HashMap<Integer, Node> nodegraph;

  public GridGraph(){
    nodeset = new HashSet<Node>();
    nodegraph = new HashMap<Integer, Node>();
  }

  public void addGridNode(final int x, final int y, final String nodeVal){
    Node n = new Node(nodeVal, x, y);
    nodeset.add(n);
    nodegraph.put(nodeVal, n);
  }

  public void addUndirectedEdge(final GridNode first, final GridNode second){
    fval = first.data();
    sval = second.data();
    HashMap<Integer, Node> fmap = first.nodes();
    HashMap<Integer, Node> smap = second.nodes();
    fx = first.xcoor();
    sx = second.xcoor();
    fy = first.ycoor();
    sy = second.ycoor();
    if(nodegraph.containsValue(first) && nodegraph.containsValue(second)){
      if( (fx = sx + 1) || (fx = sx - 1) || 
      (fy = sy + 1) || (fy = sy - 1) ){
        fmap.put(sval, second);
        smap.put(fval, first);
        }
      }
    }

  public void removeUndirectedEdge(final GridNode first, final GridNode second){
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
