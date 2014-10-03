package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhaos on 9/10/14.
 */
public class PascalTriangleII {
    public List<Integer> pascalTriangle(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();

        for (int i=0; i<rowIndex; i++) {
            for (int j=i; j>=0; j--) {
                if (j==i) result.add((Integer) 1);
                else if (j>0) result.set(j, result.get(j) + result.get(j-1));
            }
        }

        return result;
    }

    public static void main(String [] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        ArrayList<Integer> B = new ArrayList<Integer>(A);

        PascalTriangleII thisClass = new PascalTriangleII();

        for (Integer s : thisClass.pascalTriangle(5))
            System.out.print(s);
    }
}

