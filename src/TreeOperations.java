import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Tomek
 * Date: 6/19/13
 * Time: 2:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class TreeOperations {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        TreeNode r1 = new TreeNode(5);
        treeNode.right = r1;
        TreeNode r2 = new TreeNode(55);
        r1.right = r2;
        r2.right = new TreeNode(3);
        System.out.println(treeNode);

        int[] arrayAsc = {1, 2, 3, 4, 5, 6, 7};
        TreeNode treeFromArray = createMinimalBST(arrayAsc);
        System.out.println(treeFromArray);
        // System.out.println(createTree(arrayAsc,0));


        //treeNode.right = new TreeNode(3);

        //System.out.println(treeNode);
        System.out.println(isBalanced(treeNode));

        System.out.println(maxDepth(treeNode));

        //int max = Math.max(null,2);
        // System.out.println("2 and null max :  " + max);
        TreeOperations to = new TreeOperations();
        // to.loop(treeNode, 0);
        List<List<TreeNode>> results = to.findLevelLinkList(treeFromArray);
        System.out.println(results);
        /*for(List l : results){
            for(TreeNode node : l.get(0)){

            }
        } */
        to.createListForEachLevelInTree(treeFromArray);

        //tree with paren attr
        TreeNode parentTree = new TreeNode(1);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        parentTree.left = left;
        left.parent = parentTree;
        parentTree.right = right;
        right.parent = parentTree;
        TreeNode left_left = new TreeNode(2);
        TreeNode left_right = new TreeNode(3);
        left.left = left_left;
        left_left.parent = left;
        left.right = left_right;
        left_right.parent = left;

        System.out.println(to.createListForEachLevelInTree(parentTree));
        System.out.println(inorderSucc(parentTree));
        System.out.println(to.containsTree(parentTree,treeFromArray));

        Map<Integer,Map<Integer,TreeNode>> sums = to.findSum2(parentTree, 5);
        System.out.println(sums);

        //another tree
        TreeNode thirdTree = new TreeNode(9);
        thirdTree.right = new TreeNode(10);
        TreeNode leftT = new TreeNode(1);
        thirdTree.left = leftT;
        leftT.left = new TreeNode(9);
        TreeNode left_right_ = new TreeNode(9);
        leftT.right = left_right_;
        left_right_.left = new TreeNode(1);
        left_right_.right = new TreeNode(-10);
        System.out.println(to.findLevelLinkList(thirdTree));
        System.out.println(to.findSum2(thirdTree,20));


       // ArrayList<Integer> list = new ArrayList<Integer>();
       // to.findSum(parentTree,7,list ,2);
       // to.print(list,2,1);




    }

    public Map<Integer,List<TreeNode>> findSum(TreeNode root, int sumToFind){
        //nr of path, nodes :
        Map<Integer,List<TreeNode>> map = new HashMap<Integer, List<TreeNode>>();
        loop2(root,map,sumToFind,0,0);

        return map;
    }

    private void loop2(TreeNode treeNode,Map<Integer,List<TreeNode>> map, int expectedSum, int currentSum,int nrOfPath){

        currentSum += treeNode.value;
        if(!map.containsKey(nrOfPath)){
            map.put(nrOfPath, new LinkedList<TreeNode>());
        }
            List<TreeNode> path = map.get(nrOfPath);
            path.add(treeNode);
        if(currentSum >=expectedSum)
            nrOfPath++;


        if (treeNode.right != null)
            loop2(treeNode.right, map, expectedSum, currentSum,nrOfPath) ;
        if (treeNode.left != null)
            loop2(treeNode.left, map, expectedSum, currentSum, nrOfPath) ;


    }

    void findSum(TreeNode head, int sum, ArrayList<Integer> buffer,
                  int level) {
         if (head == null) return;
         int tmp = sum;
         buffer.add(head.value);
         for (int i = level;i >- 1; i--){
             tmp -= buffer.get(i);
             if (tmp == 0) print(buffer, i, level);
             }
         ArrayList<Integer> c1 = (ArrayList<Integer>) buffer.clone();
         ArrayList<Integer> c2 = (ArrayList<Integer>) buffer.clone();
         findSum(head.left, sum, c1, level + 1);
        findSum(head.right, sum, c2, level + 1);
         }

             void print(ArrayList<Integer> buffer, int level, int i2) {
         for (int i = level; i <= i2; i++) {
             System.out.print(buffer.get(i) + "");
             }
         System.out.println();
         }


    boolean containsTree(TreeNode t1, TreeNode t2) {
         if (t2 == null) return true; // The empty tree is always a subtree
         else return subTree(t1, t2);
         }

             boolean subTree(TreeNode r1, TreeNode r2) {
         if (r1 == null)
             return false; // big tree empty & subtree still not found.
         if (r1.value == r2.value) {
             if (matchTree(r1,r2)) return true;
            }
         return (subTree(r1.left, r2) || subTree(r1.right, r2));
         }

             boolean matchTree(TreeNode r1, TreeNode r2) {
         if (r2 == null && r1 == null)
             return true; // nothing left in the subtree
         if (r1 == null || r2 == null)
             return false; // big tree empty & subtree still not found
         if (r1.value != r2.value)
             return false; // data doesn’t match
         return (matchTree(r1.left, r2.left) &&
                matchTree(r1.right, r2.right));
         }


    public static TreeNode inorderSucc(TreeNode e) {
        if (e != null) {
            TreeNode p;
            // Found right children -> return 1st inorder node on right
            if (e.parent == null || e.right != null) {
                p = leftMostChild(e.right);
            } else {
                // Go up until we’re on left instead of right (case 2b)
                while ((p = e.parent) != null) {
                    if (p.left == e) {
                        break;
                    }
                    e = p;
                }
            }
            return p;
        }
        return null;
    }

    public static TreeNode leftMostChild(TreeNode e) {
        if (e == null) return null;
        while (e.left != null) e = e.left;
        return e;
    }

    List<List<TreeNode>> findLevelLinkList(TreeNode root) {
        int level = 0;
        List<List<TreeNode>> result = new LinkedList<List<TreeNode>>();

        List<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        result.add(level, list);
        while (true) {
            list = new LinkedList<TreeNode>();
            for (int i = 0; i < result.get(level).size(); i++) {
                TreeNode n = result.get(level).get(i);
                if (n != null) {
                    if (n.left != null) list.add(n.left);
                    if (n.right != null) list.add(n.right);
                }
            }
            if (list.size() > 0) {
                result.add(level + 1, list);
            } else {
                break;
            }
            level++;
        }
        return result;
    }

    /*List<List<TreeNode>> createListForEachLevelInTree(TreeNode root){
        List<List<TreeNode>> listOfLevels = new ArrayList<List<TreeNode>>();
        while(root!=null){
            List<TreeNode> level = new LinkedList<TreeNode>();
            level.add(root);

        }
          return listOfLevels;
    }   */

    public Map<Integer, List<TreeNode>> createListForEachLevelInTree(TreeNode treeNode) {
        Map<Integer, List<TreeNode>> map = new HashMap<Integer, List<TreeNode>>();

        loop(treeNode, 0, map);
        System.out.println(map);
        return map;

    }


    public Map<Integer, Map<Integer, TreeNode>> findSum2(TreeNode treeNode, int sumToFind){
        Map<Integer, Map<Integer,TreeNode>> map = new HashMap<Integer, Map<Integer, TreeNode>>();
        loop3(map,treeNode,sumToFind,0,0,0);
        return map;

    }

    private void loop3(Map<Integer, Map<Integer, TreeNode>> map, TreeNode treeNode, int expectedSum, int currentSum, int level,int counter) {

        currentSum += treeNode.value;

        System.out.println("level : " + level);
        if (!map.containsKey(counter)) {
            Map innerMap = new HashMap<Integer,TreeNode>();
            map.put(counter, innerMap);
        }
        Map<Integer,TreeNode> mapLevel = map.get(counter);
        TreeNode node = mapLevel.get(level);
        if(node == null && currentSum <= expectedSum){
            if((treeNode.left != null || treeNode.right != null) || currentSum == expectedSum )
                mapLevel.put(level,treeNode);
        }else{
            counter++;
            Map innerMap = new HashMap<Integer,TreeNode>();
            map.put(counter,innerMap);
            Map<Integer,TreeNode> innerPreviousMap = map.get(counter-1);
            int size = innerPreviousMap.size();
            int mapCounter = 0;
            for(Map.Entry<Integer, TreeNode> nodeEntry : innerPreviousMap.entrySet()){
                if(!(mapCounter == size -1))
                innerMap.put(nodeEntry.getKey(),nodeEntry.getValue());
                mapCounter++;

            }
            innerMap.put(level,treeNode);
            //level--;
        }





        level++;

        if (treeNode.right != null)
            loop3(map, treeNode.right, expectedSum, currentSum, level, counter);
        if (treeNode.left != null)
            loop3(map, treeNode.left, expectedSum, currentSum, level, counter);

    }

    private void loop(TreeNode treeNode, int level, Map<Integer, List<TreeNode>> map) {

        System.out.println("level : " + level);
        if (!map.containsKey(level)) {
            map.put(level, new LinkedList<TreeNode>());
        }
        List<TreeNode> listLevel = map.get(level);
        listLevel.add(treeNode);


        level++;
        if (treeNode.right != null)
            loop(treeNode.right, level, map);
        if (treeNode.left != null)
            loop(treeNode.left, level, map);
    }


    public static TreeNode createTree(int array[], int nr) {

        if (nr >= array.length)
            return null;

        TreeNode root = new TreeNode(array[nr]);
        nr++;
        root.left = new TreeNode(array[nr]);
        nr++;
        root.right = new TreeNode(array[nr]);
        createTree(array, nr);
        createTree(array, nr += 2);

        return root;
    }

    public static TreeNode createMinimalBST(int array[]) {
        return addToTree(array, 0, array.length - 1);
    }

    public static TreeNode addToTree(int arr[], int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = addToTree(arr, start, mid - 1);
        n.right = addToTree(arr, mid + 1, end);
        return n;
    }

    public static int maxDepth(TreeNode root) {
        //  System.out.println("maxDepth for : " + root);
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public static boolean isBalanced(TreeNode root) {
        return (maxDepth(root) - minDepth(root) <= 1);
    }

}
