package LeetCode;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yuhaos on 9/4/14.
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> oldLine = new ArrayList<Integer>();
        oldLine.add(1);
        result.add(oldLine);
        for (int i=1; i<numRows; i++) {
            ArrayList<Integer> newLine = new ArrayList<Integer>();
            newLine.add(1);
            for (int j=1; j<i; j++) {
                newLine.add(oldLine.get(j-1)+oldLine.get(j));
            }
            newLine.add(1);
            result.add(newLine);
            oldLine = newLine;
        }

        return result;
    }

    public static void main(String [] args) {
        PascalTriangle thisClass = new PascalTriangle();
        Stack<Integer> result = new Stack<Integer>();
        result.peek();
        System.out.print(thisClass.generate(5));
    }
}
