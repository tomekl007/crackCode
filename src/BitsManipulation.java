/**
 * Created with IntelliJ IDEA.
 * User: Tomek
 * Date: 6/20/13
 * Time: 7:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class BitsManipulation {

    public static void main(String[] args){

        int n = 256;
        int m = 21;
        System.out.println(updateBits(n, m, 2, 6));
    }


    public static int updateBits(int n, int m, int i, int j) {
        int max = ~0; /* All 1’s */

        // 1’s through position j, then 0’s
        int left = max - ((1 << j) - 1);

        // 1’s after position i
        int right = ((1 << i) - 1);
        // 1’s, with 0s between i and j
        int mask = left | right;

        // Clear i through j, then put m in there
        return (n & mask) | (m << i);
    }
}