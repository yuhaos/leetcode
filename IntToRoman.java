package LeetCode;

/**
 * Created by yuhaos on 8/30/14.
 */
public class IntToRoman {
    public String intToRoman(int num) {
        StringBuffer result = new StringBuffer();
        int n=num;

        while (n>0) {
            if (n>=1000) {
                result.append('M');
                n -= 1000;
            } else if (n>=900) {
                result.append('C');
                n += 100;
            } else if (n>=500) {
                result.append('D');
                n -= 500;
            } else if (n>=400) {
                result.append('C');
                n += 100;
            }else if (n>=100) {
                result.append('C');
                n -= 100;
            } else if (n>=90) {
                result.append('X');
                n += 10;
            } else if (n>=50) {
                result.append('L');
                n -= 50;
            } else if (n>=40) {
                result.append('X');
                n += 10;
            } else if (n>=10) {
                result.append('X');
                n -= 10;
            } else if (n>=9) {
                result.append('I');
                n += 1;
            } else if (n>=5) {
                result.append('V');
                n -= 5;
            } else if (n>=4) {
                result.append('I');
                n += 1;
            } else {
                result.append('I');
                n -= 1;
            }
        }

        return result.toString();
    }

    public static void main(String [] args) {
        IntToRoman thisClass = new IntToRoman();

        System.out.print(thisClass.intToRoman(900));
    }
}
