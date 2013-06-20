import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Tomek
 * Date: 6/20/13
 * Time: 11:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class Recursion {

    public static void main(String[] args){

        ArrayList<Integer> set = new ArrayList<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        Recursion r  = new Recursion();
        System.out.println(r.getSubsets(set,0));

    }

   /* static ArrayList<Point>  current_path = new ArrayList<Point>();
     public static boolean getPaths(int x, int y) {
        Point p = new Point(x, y);
        current_path.add(p);
         if (0 == x && 0 == y) return true; // current_path
         boolean success = false;
         if (x >= 1 && is_free(x - 1, y)) { // Try right
            success = getPaths(x - 1, y); // Free! Go right
             }
         if (!success && y >= 1 && is_free(x, y - 1)) { // Try down
             success = getPaths(x, y - 1); // Free! Go down
             }
        if (!success) {
            current_path.remove(p); // Wrong way!
             }
         return success;
         }   */

    ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set,
                                              int index) {
         ArrayList<ArrayList<Integer>> allsubsets;
         if (set.size() == index) {
             allsubsets = new ArrayList<ArrayList<Integer>>();
             allsubsets.add(new ArrayList<Integer>()); // Empty set
             } else {
             allsubsets = getSubsets(set, index + 1);
             int item = set.get(index);
             ArrayList<ArrayList<Integer>> moresubsets =
                     new ArrayList<ArrayList<Integer>>();
             for (ArrayList<Integer> subset : allsubsets) {
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                 newsubset.addAll(subset); //
                 newsubset.add(item);
                 moresubsets.add(newsubset);
                 }
            allsubsets.addAll(moresubsets);
             }
         return allsubsets;
         }
}
