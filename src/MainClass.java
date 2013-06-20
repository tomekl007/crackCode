/**
 * Created with IntelliJ IDEA.
 * User: Tomek
 * Date: 6/19/13
 * Time: 4:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class MainClass {

    public static void main(String[] args){

        char[] chars = {'a','b','b','d'};
        removeDuplicatesEff(chars);

    }

    public static void removeDuplicatesEff(char[] str) {
         if (str == null) return;
         int len = str.length;
         if (len < 2) return;
         boolean[] hit = new boolean[256];
         for (int i = 0; i < 256; ++i) {
             hit[i] = false;
             }
         hit[str[0]] = true;
         int tail = 1;
         for (int i = 1; i < len; ++i) {
             if (!hit[str[i]]) {
                 str[tail] = str[i];
                 ++tail;
                 hit[str[i]] = true;
                 }
            }
         str[tail] = 0;
         }


}
