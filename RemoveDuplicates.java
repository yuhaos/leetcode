package LeetCode;

/**
 * Created by yuhaos on 8/30/14.
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] A) {

        if (A.length == 0) return 0;

        int orgIndex = 1;
        int newIndex = 0;

        while(orgIndex < A.length) {
            if (A[newIndex] != A[orgIndex]) {
                A[++newIndex] = A[orgIndex];
            }
            orgIndex++;
        }

        return newIndex+1;
    }

    public static void main(String [] args) {
        RemoveDuplicates thisClass = new RemoveDuplicates();
        int [] array = {};

        System.out.print("The new Length is "+thisClass.removeDuplicates(array));
    }
}
