import java.util.*;
import java.util.HashMap;

public class Node{
  private int data;
  private boolean isvisited;
  private HashMap<Integer, Node> nodes;
  private int degree;

  public Node(int i){
    data = i;
    isvisited = false;
    nodes = new HashMap<Integer, Node>();
    degree = 0;
  }

  public void setTrue(){
    isvisited = true;
  }

  public HashMap<Integer, Node> getNodeData(){
    return nodes;
  }

  public void addDegree(){
    degree = degree + 1;
  }

  public void minusDegree(){
    degree = degree - 1;
  }

}
