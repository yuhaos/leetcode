package LeetCode;

import java.util.ArrayList;

/**
 * Created by yuhaos on 8/17/14.
 */
public class TreeTest {
    public boolean compareTrees(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) return true;
        if (tree1 == null) return false; //tree2 will not be null in this situation
        if (tree2 == null) return false;
        return compareTrees(tree1.left, tree2.left) && compareTrees(tree1.right, tree2.right) && (tree1.val == tree2.val);
    }

    public void printTree(TreeNode top) {
        if (top == null) System.out.print("null.\n");

        ArrayList<TreeNode> treeList = new ArrayList<TreeNode>();
        treeList.add(top);

        while(treeList.size() > 0) {
            ArrayList<TreeNode> tmpList = new ArrayList<TreeNode>();
            for(TreeNode s : treeList) {
                System.out.print(s.val + " ");
                if (s.left != null) tmpList.add(s.left);
                if (s.right != null) tmpList.add(s.right);
            }
            System.out.print("\n");
            treeList = tmpList;
        }
    }

    public static void main(String[] args) {
        int [] preorder = {1,2,4,8,9,5,10,11,3,6,12,13,7,14,15};
        int [] inorder = {8,4,9,2,10,5,11,1,12,6,13,3,14,7,15};
        int [] postorder = {8,9,4,10,11,5,2,12,13,6,14,15,7,3,1};
        TreeNode [] treeNodes = new TreeNode[16];
        for(int i=0; i<16; i++) {
            treeNodes[i] = new TreeNode(i);
        }
        treeNodes[1].left = treeNodes[2];
        treeNodes[1].right = treeNodes[3];
        treeNodes[2].left = treeNodes[4];
        treeNodes[2].right = treeNodes[5];
        treeNodes[3].left = treeNodes[6];
        treeNodes[3].right = treeNodes[7];
        treeNodes[4].left = treeNodes[8];
        treeNodes[4].right = treeNodes[9];
        treeNodes[5].left = treeNodes[10];
        treeNodes[5].right = treeNodes[11];
        treeNodes[6].left = treeNodes[12];
        treeNodes[6].right = treeNodes[13];
        treeNodes[7].left = treeNodes[14];
        treeNodes[7].right = treeNodes[15];

        TreeNode treeTop = treeNodes[1];

        FromTraversalTree fromTraversalTree = new FromTraversalTree();
        TreeTest treeTest = new TreeTest();

        TreeNode getTree1 = fromTraversalTree.fromPreInOrder(preorder, inorder);

        System.out.print("Using recursion:\n");
        if (treeTest.compareTrees(getTree1,treeTop))
            System.out.print("Good.\n");
        else {
            System.out.print("Bad.\n");
            treeTest.printTree(getTree1);
        }

        TreeNode getTree2 = fromTraversalTree.fromPostInorder(postorder,inorder);

        System.out.print("Using recursion:\n");
        if (treeTest.compareTrees(getTree2,treeTop))
            System.out.print("Good.\n");
        else {
            System.out.print("Bad.\n");
            treeTest.printTree(getTree2);
        }

        TreeNode getTree3 = fromTraversalTree.fromPreInorder3(preorder,inorder);
        System.out.print("Using non-recursion:\n");
        if (treeTest.compareTrees(getTree3,treeTop))
            System.out.print("Good.\n");
        else {
            System.out.print("Bad.\n");
            treeTest.printTree(getTree3);
        }

        TreeNode getTree4 = fromTraversalTree.fromPostInorder2(postorder,inorder);
        System.out.print("Using non-recursion, for post-inorder:\n");
        if (treeTest.compareTrees(getTree4,treeTop))
            System.out.print("Good.\n");
        else {
            System.out.print("Bad.\n");
            treeTest.printTree(getTree4);
        }

        //treeTest.printTree(treeTop);

        MaxPathSum maxPathSum = new MaxPathSum();
        treeNodes[1].right = null;
        treeNodes[2].left = null;
        treeNodes[2].right = null;
        System.out.print("The max path sum is " + maxPathSum.maxPathSum(treeNodes[1]));

    }
}
