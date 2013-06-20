/** * Created with IntelliJ IDEA.
 * User: Tomek
 * Date: 6/19/13
 * Time: 2:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class TreeNode {
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    int value;

    public TreeNode(int value){
        this.value = value;

    }

    @Override
    public String toString() {

        //String result = "";
          //  loop(this,result);
       // System.out.println("re" + result);
        return this.value +"";
    }

    private void loop(TreeNode treeNode,String result) {
        System.out.println("treeNOde val : " + treeNode.value);
        result+=". " +  treeNode.value + " ." ;
            if(treeNode.right!=null)
                loop(treeNode.right,result);
            if(treeNode.left!=null)
                loop(treeNode.left,result) ;
    }


}
