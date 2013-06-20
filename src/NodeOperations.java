import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Tomek
 * Date: 6/19/13
 * Time: 9:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class NodeOperations {

    public static void main(String[] args){

        Node n = new Node(2);
        n.appendToTail(4);
        n.appendToTail(3);
        n.appendToTail(4);
        n.appendToTail(2);


        System.out.println(n);
        NodeOperations no = new NodeOperations();
        deleteMiddleElement(n);
        System.out.println("after deleting middle elem : " + n);
        System.out.println("nth last : " + findNthLastElement(n, 5));
        deleteDups2(n);

        System.out.println("after deleting duplicates:  "  + n);

        //System.out.println(no.removeDuplicates(n));
        Node after = no.deleteNode(n,3);
        System.out.println(after);
        Node first = new Node(3);
        first.appendToTail(1);
        first.appendToTail(5);

        Node second = new Node(5);
        second.appendToTail(9);
        second.appendToTail(2);

        addTwoLists(first,second);




    }

    private static Node addTwoLists(Node first, Node second) {
        List<Integer> firstVariable = new LinkedList<Integer>();
        List<Integer> secondVariable= new LinkedList<Integer>();
        while(first!=null){
            firstVariable.add(first.data);
            first = first.next;

        }

        while(second!=null){
            secondVariable.add(second.data);
            second = second.next;

        }
        int size = firstVariable.size();
        List<Integer> weights = new LinkedList<Integer>();

        //for(int i = 0; i < size ; i++){
            weights.add(100);
            weights.add(10);
            weights.add(1);
        //}
        int firstNubmer = 0;
        int index = 0;
        for(Integer nubmer : firstVariable){
           firstNubmer += nubmer*weights.get(index);
            index++;
        }

        int secondNubmer = 0;
        int index2 = 0;
        for(Integer nubmer : secondVariable){
            secondNubmer += nubmer*weights.get(index2);
            index2++;
        }

        System.out.println("first : " + firstNubmer + " sec " + secondNubmer);

        int result = firstNubmer + secondNubmer;

        return  new Node(-1);
    }

    private static void deleteMiddleElement(Node n) {
        Node first = n;
        Node second = n ;
        int counter = 0;
        int moduloCounter = 0;

        while(first!=null){
            counter ++;
            if(counter%2==0){
                moduloCounter ++;
                second = second.next;
            }

            first = first.next;
        }


        System.out.println("middle elememt : " + second);
        System.out.println("modulo counter  : " + moduloCounter);
        moduloCounter--;
        Node beforeMiddle = n;
        for(int i =0; i < moduloCounter ; i++){
            beforeMiddle = beforeMiddle.next;

        }
        beforeMiddle.next  = second.next;
        System.out.println("before middle : " + beforeMiddle);

    }

    private static Node findNthLastElement(Node n, int nrFromEnd) {
           Node first = n;
           Node second = n;
        int counter = 0;

        while(first!=null){

            first = first.next;
            if(counter%(nrFromEnd+1)==0){
                second = second.next;
            }
            counter++;
        }

           return second;
    }

    static Node nthToLast(Node head, int n) {
         if (head == null || n < 1) {
             return null;
            }
        Node p1 = head;
        Node p2 = head;
         for (int j = 0; j < n - 1; ++j) { // skip n-1 steps ahead
             if (p2 == null) {
                 return null; // not found since list size < n
                 }
             p2 = p2.next;
             }
         while (p2.next != null) {
             p1 = p1.next;
             p2 = p2.next;
             }
         return p1;
         }

    private Node removeDuplicates(Node head) {
        List<Integer> fidnedNumbers = new LinkedList<Integer>();
        Node current = head;
        while(current != null){

            if(fidnedNumbers.contains(current.data)){
                // fidnedNumbers.remove(current.data);
                 current =  deleteNode(head,current.data);

            }else{
            fidnedNumbers.add(current.data);
            }

            current = current.next;
        }
        return head;

    }

    public static void deleteDups(Node n) {
         Map<Integer,Boolean> table = new HashMap<Integer,Boolean>();
         Node previous = null;
         while (n != null) {
             if (table.containsKey(n.data)) previous.next = n.next;
             else {
                 table.put(n.data, true);
                previous = n;
                 }
             n = n.next;
             }
         }

    public static void deleteDups2(Node head) {
         if (head == null) return;
        Node previous = head;
        Node current = previous.next;
         while (current != null) {
             Node runner = head;
             while (runner != current) { // Check for earlier dups
                 if (runner.data == current.data) {
                    Node tmp = current.next; // remove current
                    previous.next = tmp;
                    current = tmp; // update current to next node
                     break; // all other dups have already been removed
                     }
                runner = runner.next;
                 }
             if (runner == current) { // current not updated - update now
                 previous = current;
                 current = current.next;
                }
             }
         }

    Node deleteNode(Node head, int d) {
         Node n = head;
         if (n.data == d) {
             return head.next; /* moved head */
             }
         while (n.next != null) {
             if (n.next.data == d) {
                 n.next = n.next.next;
                 return n; /* head didn’t change */
                 }
             n = n.next;
             }
            return new Node(-1);
         }
}
