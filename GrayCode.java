package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhaos on 8/30/14.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
//        if (n == 0) return null;

        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
//        result.add(1);

        for (int i=1; i<=n; i++) {
            int addition = 1 << (i-1);
            //System.out.println(addition);
            for (int j=result.size()-1; j>=0; j--) {
                result.add(result.get(j) + addition);
            }
        }

        return result;
    }

    public static void main(String [] args) {
        GrayCode thisClass = new GrayCode();
        System.out.print(thisClass.grayCode(2));
    }
}
