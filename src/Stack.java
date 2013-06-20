class Stack {
    Node top;

    Node pop() {
        if (top != null) {
            int item = top.data;
            top = top.next;
            return new Node(item);
        }
        return null;
    }

    void push(int item) {
        Node t = new Node(item);
        t.next = top;
        top = t;
    }
}