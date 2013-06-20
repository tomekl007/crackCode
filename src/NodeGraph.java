import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tomek
 * Date: 6/19/13
 * Time: 2:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class NodeGraph {
    public State state;
    int data;
    List<NodeGraph> adjacent;

    public NodeGraph (){
        adjacent = new LinkedList<NodeGraph>();
        state =  State.Unvisited;
    }


    public List<NodeGraph> getAdjacent() {
        return adjacent;
    }
}
