package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yuhaos on 9/5/14.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        int [] A = new int[n];
        generateArray(result, A, n-1, n);

        return result;
    }

    public String generateString(int [] A, int index) {
        StringBuffer stringResult = new StringBuffer();
        int rightParaent = 0;
        for(int i=0; i<A.length; i++) {
            stringResult.append("(");
            if (i>index) {
                while (rightParaent<A[i]) {
                    stringResult.append(")");
                    rightParaent++;
                }
            }
        }
        return stringResult.toString();
    }

    public void generateArray(List<String> result, int[] A, int nowIndex, int valueOnNowIndex) {
        if (valueOnNowIndex == 0) {
            result.add(generateString(A, nowIndex));
        } else {
            A[nowIndex] = valueOnNowIndex;
            for(int i=valueOnNowIndex; i>=0; i--){
                if (i<=nowIndex)
                    generateArray(result, A, nowIndex-1, i);
            }

        }
    }

    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<String>();
        Stack<Integer> numStack = new Stack<Integer>();
        int nowNum = n;
        boolean nowNumPoped = false;

        while (!(nowNumPoped && nowNum == n)) {
            if (!nowNumPoped) {
                if (nowNum>0) {
                    numStack.push(nowNum);
                    if (numStack.size()+nowNum == n+1)
                        nowNum--;
                } else {
                    result.add(generateString(numStack,n));
                    nowNum = numStack.pop();
                    nowNumPoped = true;
                }
            } else {
                nowNum--;
                nowNumPoped = false;
            }

        }
        return result;
    }

    public String generateString(Stack<Integer> numStack, int n) {
        int rightParentheses = 0;
        StringBuffer resultString = new StringBuffer();

        for (int i=0; i<n; i++) {
            resultString.append("(");
            int tmpIndex = n-i-1;
            if (tmpIndex<numStack.size()) {
                while (rightParentheses<numStack.get(tmpIndex)) {
                    resultString.append(")");
                    rightParentheses++;
                }
            }
        }

        return resultString.toString();
    }

    public static void main(String [] args) {
        GenerateParentheses thisClass = new GenerateParentheses();
        List<String> result = thisClass.generateParenthesis2(3);

        for (String s : result)
            System.out.println(s);
    }
}
