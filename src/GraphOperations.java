

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Tomek
 * Date: 6/19/13
 * Time: 2:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class GraphOperations {


    public static void main(String[] args){
        Graph g = new Graph();
        NodeGraph n1 = new NodeGraph();
        NodeGraph n2 = new NodeGraph();
        NodeGraph n3 = new NodeGraph();

        n1.data = 1;
        n2.data = 2;
        n3.data = 3;
        n1.adjacent.add(n2);
        n2.adjacent.add(n3);
        n3.adjacent.add(n1);

        NodeGraph[] nodes = new NodeGraph[3];
        nodes[0] = n1;
        nodes[1] = n2;
        nodes[2] = n3;
        g.setNodes(nodes);

        System.out.println("is connected : ? " + search(g, n1, n3));


    }

    public static boolean search(Graph g, NodeGraph start, NodeGraph end) {
        LinkedList<NodeGraph> q = new LinkedList<NodeGraph>(); // operates as Stack
        for (NodeGraph u : g.getNodes()) {
            u.state = State.Unvisited;
        }
        start.state = State.Visiting;
        q.add(start);
        NodeGraph u;
        while(!q.isEmpty()) {
            u = q.removeFirst(); // i.e., pop()
            if (u != null) {
                for (NodeGraph v : u.getAdjacent()) {
                    if (v.state == State.Unvisited) {
                        if (v == end) {
                            return true;
                        } else {
                            v.state = State.Visiting;
                            q.add(v);
                        }
                    }
                }
                u.state = State.Visited;
            }
        }
        return false;
    }
}
