import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

public class TopSort{

  public static ArrayList<Node> Kahns(final DirectedGraph graph){
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    HashSet<Node> set = new HashSet<Node>();
    set = graph.nodeset;
    ArrayList<Node> aln = new Arraylist<Node>();
    Queue<Node> q = new Queue<Node>();
   
    for(Node n: set){
      map.put(n.degrees(), n);
      if(n.degrees() == 0){
        q.add(n);
      }
    }

    while(!q.isEmpty()){
      Node node = q.remove();
      aln.add(node);
      map.put(-1, node);
      HashMap<Integer, Node> nodemap = node.nodes();
      for(Node nd: nodemap){
        if(nd.degrees() == 0){
          map.put(nd.degrees(), nd);
        }
      }
    }

    return aln;
  }

  public static ArrayList<Node> mDFS(Node n, ArrayList<Node> al, final DirectedGraph graph){
    ArrayList<Node> aln = new Arraylist<Node>();

    HashSet<Integer> mapset = graph.nodeset();
    for(Node node: mapset){
      if(!node.isvisited()){
        node.setTrue();
        HashMap<Integer, Node> nodemap = node.nodes();
        for(Node next: nodemap.data()){
          if(!next.isvisited()){
            mDFS(next, aln, graph);
          }
        }
        aln.add(node);
      }
    }
    return aln;
  }

}
