package LeetCode;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by yuhaos on 9/11/14.
 */
public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        TreeNode nowNode = root;
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        boolean popNode = false;

        while (!(nowNode==root && popNode)) {
            if (!popNode) {
                if (nowNode != null) {
                    nodeStack.push(nowNode);
                    nowNode = nowNode.left;
                } else {
                    popNode = true;
                }
            } else {
                TreeNode topNode = nodeStack.peek();
                if (nowNode == topNode.right) {
                    if (nowNode != null && nowNode.left==null && nowNode.right==null) {
                        sum += getNumber(nodeStack);
                    }
                    nowNode = nodeStack.pop();
                } else {
                    nowNode = topNode.right;
                    popNode = false;
                }
            }
        }

        return sum;
    }

    public int getNumber(Stack<TreeNode> nodeStack) {
        int num = 0;

        for(Iterator<TreeNode> itor = nodeStack.iterator() ; itor.hasNext();) {
            num = num*10 + itor.next().val;
        }

        return num;
    }
}
