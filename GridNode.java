import java.util.*;

public class GraphNode{
  private int data;
  private boolean isvisited;
  private int xcoor;
  private int ycoor;
  private GridNode [] neighbors;

  public GraphNode(int i, int x, int y){
    data = i;
    isvisited = false;
    nodes = new HashMap<Integer, Node>();
    xcoor = x;
    ycoor = y;
    neighbors = new GridNode[4];
    neighbors[0] = null; //left
    neighbors[1] = null; //right
    neighbors[2] = null; //down
    neighbors[3] = null; //up
  }
}
