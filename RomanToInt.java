package LeetCode;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuhaos on 8/20/14.
 */
public class RomanToInt {
    public int romanToInt(String s) {
        int [] result = {0,0,0,0};
        int numIndex = 3;
        Map<Character,Integer> decimal = new HashMap<Character, Integer>();
        decimal.put('I', 0);
        decimal.put('V', 0);
        decimal.put('X', 1);
        decimal.put('L', 1);
        decimal.put('C', 2);
        decimal.put('D', 2);
        decimal.put('M', 3);

        Map<Character,Integer> weight = new HashMap<Character, Integer>();
        weight.put('I', 1);
        weight.put('V', 5);
        weight.put('X', 1);
        weight.put('L', 5);
        weight.put('C', 1);
        weight.put('D', 5);
        weight.put('M', 1);

        for (int i=0; i<s.length(); i++) {
            char tmpChar = s.charAt(i);
            int tmpInt = weight.get(tmpChar);
            if (decimal.get(tmpChar) == numIndex) {
                if (tmpInt == 5)
                    result[numIndex] = tmpInt - result[numIndex];
                else
                    result[numIndex] += tmpInt;
            } else if (decimal.get(tmpChar) < numIndex) {
                numIndex = decimal.get(tmpChar);
                result[numIndex] = weight.get(tmpChar);
            } else if (decimal.get(tmpChar) == numIndex+1) {
                if (tmpInt == 1)
                    result[numIndex] = 10 - result[numIndex];
//                else
//                    //should be error
            }
            // else should be error
//            char tmpChar = s.charAt(i);
//            int tmpInt = 0;
//            if (tmpChar > 'A' && tmpChar < 'Z') tmpInt = tmpChar - 'A';
//            else if (tmpChar > 'a' && tmpChar < 'z') tmpInt = tmpChar - 'a';
//            result = result * 10 + s.charAt(i) - '0';
        }

        return result[3]*1000 + result[2]*100 + result[1]*10 + result[0];
    }

    public int romanToInt2(String s) {
        Map<Character,Integer> value = new HashMap<Character, Integer>();
        value.put('I', 1);
        value.put('V', 5);
        value.put('X', 10);
        value.put('L', 50);
        value.put('C', 100);
        value.put('D', 500);
        value.put('M', 1000);

        int result = 0;
        int maxValue = 0;

        for (int i=s.length()-1; i>=0; i--) {
            int tmpInt = value.get(s.charAt(i));
            if (tmpInt >= maxValue) {
                result += tmpInt;
                maxValue = tmpInt;
            } else {
                result -= tmpInt;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        RomanToInt test;
        test = new RomanToInt();
        System.out.print(test.romanToInt2("DCXXI"));
    }
}
