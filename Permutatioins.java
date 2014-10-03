package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuhaos on 9/7/14.
 */
public class Permutatioins {
    public List<List<Integer>> permute(int [] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        permute(result, num, 0);

        return result;
    }

    public void permute(List<List<Integer>> result, int [] num, int startIndex) {
        if (startIndex == num.length) {
            List<Integer> oneResult = new ArrayList<Integer>();
            for(int i=0; i<num.length; i++)
                oneResult.add(num[i]);
            result.add(oneResult);
        }
        for (int i=startIndex; i<num.length; i++) {
            swap(num, startIndex, i);
            permute(result, num, startIndex+1);
            swap(num, startIndex, i);
        }
    }

    public void swap(int [] num, int index1, int index2) {
        int tmp = num[index1];
        num[index1] = num[index2];
        num[index2] = tmp;
    }

    public List<List<Integer>> permute2(int [] num) {
        List<List<Integer>> lastList = new ArrayList<List<Integer>>();
        lastList.add(new ArrayList<Integer>());


        for (int i=0; i<num.length; i++) {
            List<List<Integer>> nowList = new ArrayList<List<Integer>>();
            for (int j=0; j<lastList.size(); j++) {
                List<Integer> oneResult = lastList.get(j);
                for (int k=0; k<=oneResult.size(); k++) {
                    ArrayList<Integer> tmpOneResult = new ArrayList<Integer>(oneResult);
                    tmpOneResult.add(k, num[i]);
                    nowList.add(tmpOneResult);
                }
            }
            lastList = nowList;
        }

        return lastList;
    }

    public static void main(String [] args) {
        Permutatioins thisClass = new Permutatioins();
        int [] stimulus = {1,2,3};
        List<List<Integer>> result = thisClass.permute2(stimulus);

        for (int i=0; i<result.size(); i++) {
            for (int j=0; j<result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.print("\n");
        }
    }
}
