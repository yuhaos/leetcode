package LeetCode;

import java.util.Stack;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by yuhaos on 8/17/14.
 */
public class FromTraversalTree {

    // use recursion algorithm
    public TreeNode fromPreInOrder(int[] preorder, int[] inorder) {
        return fromPreInOrderBuilder(preorder, inorder, 0, 0, preorder.length);
    }
    // recursion algorithm
    public TreeNode fromPreInOrderBuilder(int[] preorder, int[] inorder, int prestart, int instart, int length) {
        if (length <= 0) return null;

        int topVal = preorder[prestart];
        int topInIndex = instart;
        for(int inIndexEnd=instart+length;topInIndex<inIndexEnd; topInIndex++) {
            if (inorder[topInIndex] == topVal) break;
        }
        // Should raise Exception if topInIndex is bigger than inIndexEnd
        int leftLength = topInIndex - instart;
        int rightLength = length - leftLength - 1;

        TreeNode top = new TreeNode(topVal);
        top.left = fromPreInOrderBuilder(preorder, inorder, prestart+1, instart, leftLength);
        top.right = fromPreInOrderBuilder(preorder, inorder, prestart+1+leftLength, instart+1+leftLength, rightLength);

        return top;
    }

    // using recursion algorithm
    public TreeNode fromPostInorder(int[] postorder, int[] inorder) {
        return fromPostInOrderBuilder(postorder, inorder, 0, 0, postorder.length);
    }

    // recursion algorithm
    public TreeNode fromPostInOrderBuilder(int[] postorder, int[] inorder, int poststart, int instart, int length) {
        if (length == 0) return null; //should raise exception if length < 0

        int topVal = postorder[poststart+length-1];
        int topInIndex = instart;
        for (int inIndexEnd=instart+length; topInIndex<inIndexEnd; topInIndex++)
            if (inorder[topInIndex] == topVal) break;
        int leftLength = topInIndex - instart;
        int rightLength = length -leftLength - 1;

        TreeNode top = new TreeNode(topVal);
        top.left = fromPostInOrderBuilder(postorder,inorder,poststart,instart,leftLength);
        top.right = fromPostInOrderBuilder(postorder,inorder,poststart+leftLength,instart+leftLength+1, rightLength);

        return top;
    }

    // using non-recursion algorithm
    public TreeNode fromPreInorder2(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;

        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();

        TreeTest treeTest = new TreeTest();
        TreeNode root = null;
        TreeNode top = null;
        int i = 0;
        int j = 0;
        int f = 0;

        root = new TreeNode(preorder[i++]);
        top = root;
        treeNodeStack.push(root);

        while (i < preorder.length) {
            if (treeNodeStack.size() != 0 && treeNodeStack.peek().val == inorder[j]) {
                top = treeNodeStack.pop();
                f = 1;
                j++;
                System.out.print("===================\n");
                treeTest.printTree(root);
                System.out.print("i=="+i+"  j=="+j+"  f=="+f+"\n");
            } else {
                if (f == 0) {
                    top.left = new TreeNode(preorder[i++]);
                    top = top.left;
                    treeNodeStack.push(top);
                } else {
                    f = 0;
                    top.right = new TreeNode(preorder[i++]);
                    top = top.right;
                    treeNodeStack.push(top);
                }
                System.out.print("--------------------\n");
                treeTest.printTree(root);
                System.out.print("i=="+i+"  j=="+j+"  f=="+f+"\n");
            }
        }
        System.out.print("================\n");

        return root;
    }

    // Write by myself,
    public TreeNode fromPreInorder3(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;

        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        TreeNode root = null;
        TreeNode nowNode = null;
        int i = 0; // index for the preorder array
        int j = 0; // index for the inorder arry
        boolean leftDone = false; //whether the left sub-tree is completed, if yes, the next child should be right.

        root = new TreeNode(preorder[i++]);
        nowNode = root;
        treeNodeStack.push(root);

        while (i < preorder.length) {
            if (treeNodeStack.size() != 0 && treeNodeStack.peek().val == inorder[j]) {
                j++;
                leftDone = true;
                nowNode = treeNodeStack.pop();
            } else {
                if (!leftDone) {
                    nowNode.left = new TreeNode(preorder[i++]);
                    nowNode = nowNode.left;
                    treeNodeStack.push(nowNode);
                } else {
                    nowNode.right = new TreeNode(preorder[i++]);
                    nowNode = nowNode.right;
                    treeNodeStack.push(nowNode);
                    leftDone = false; // the left sub-tree is not completed for this node
                }
            }
        }

        return root;
    }

    public TreeNode fromPostInorder2(int[] postorder, int[] inorder) {
        if (postorder.length == 0) return null;

        int postIndex = postorder.length - 1;
        int inIndex = postIndex;
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        TreeNode root = new TreeNode(postorder[postIndex--]);
        treeNodeStack.push(root);
        TreeNode nowNode = root;
        boolean rightDone = false;

        while (postIndex >= 0) {
            if (treeNodeStack.size() != 0 && treeNodeStack.peek().val == inorder[inIndex]) {
                inIndex--;
                nowNode = treeNodeStack.pop();
                rightDone = true;
            } else {
                if (!rightDone) {
                    nowNode.right = new TreeNode(postorder[postIndex--]);
                    nowNode = nowNode.right;
                    treeNodeStack.push(nowNode);
                } else {
                    nowNode.left = new TreeNode(postorder[postIndex--]);
                    nowNode = nowNode.left;
                    treeNodeStack.push(nowNode);
                    rightDone = false;
                }
            }
        }

        return root;
    }

}
