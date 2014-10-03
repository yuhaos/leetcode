package LeetCode;

/**
 * Created by yuhaos on 8/19/14.
 */
public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        return maxPathSumHelper(root)[0];
    }

    public int [] maxPathSumHelper(TreeNode root) {
        int [] result = new int[2];
        //int [] leftResult = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        //int [] rightResult = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        if (root.left == null && root.right == null) {
            result[0] = root.val;
            result[1] = root.val;
            //return result;
        } else if (root.right == null) {
            int [] leftResult = maxPathSumHelper(root.left);
            result[0] = leftResult[0]>leftResult[1]+root.val? leftResult[0] : leftResult[1]+root.val;
            result[1] = leftResult[1] + root.val;
        } else if (root.left == null) {
            int [] rightResult = maxPathSumHelper(root.right);
            result[0] = rightResult[0]>rightResult[1]+root.val? rightResult[0] : rightResult[1] + root.val;
            result[1] = rightResult[1] + root.val;
        } else {
            int [] leftResult = maxPathSumHelper(root.left);
            int [] rightResult = maxPathSumHelper(root.right);
            result[0] = (leftResult[0] > rightResult[0] ? leftResult[0] : result[0]);
            int newPathSum = leftResult[1] + rightResult[1] + root.val;
            result[0] = result[0] > newPathSum ? result[0] : newPathSum;
            result[1] = (leftResult[1] > rightResult[1] ? leftResult[1] : rightResult[1]) + root.val; // path to root
        }

        System.out.print("root.val = "+root.val+"  result[0]="+result[0]+"   result[1]="+result[1]+"\n");
        return result;
    }
}
