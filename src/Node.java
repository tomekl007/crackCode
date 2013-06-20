class Node {
    Node next = null;
    int data;

    public Node(int d) {
        data = d;
    }

    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    @Override
    public String toString() {
        String result ="";
        Node current = this;

        while(current!=null){
            result += "->" + current.data;
            current = current.next;
        }
        return result;
    }
}