package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhaos on 9/2/14.
 */
public class NQueen {
    public int totalNQueens(int n) {
        if (n<=0) return 0;
        int [] locations;
        locations = new int[n];

        return findNQueens(locations, 0);
    }

    public int findNQueens(int [] locations, int row) {
        if (row == locations.length) {
            //printNQueens(locations);
            return 1;
        }

        int result = 0;
        for(int i=0; i<locations.length; i++) {
            if (check(locations, row, i)) {
                locations[row] = i;
                result += findNQueens(locations, row+1);
            }
        }
        return result;
    }

    public boolean check(int [] locations, int row, int clom) {
        for (int i=0; i<row; i++) {
            if (locations[i] == clom) return false;
            if (locations[i]+i == row+clom) return false;
            if (i-locations[i] == row-clom) return false;
        }

        return true;
    }

    public void printNQueens(int [] locations) {
        System.out.print("=======================\n");
        for (int i=0; i<locations.length; i++) {
            int location = locations[i];
            for (int j=0; j<locations.length; j++) {
                if (j != location) {
                    System.out.print(". ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.print("\n");
        }
        System.out.print("=======================\n");
    }

    public static void main(String [] args) {
        NQueen thisClass = new NQueen();
        for (int i=0; i<10; i++) {
            //System.out.print("n="+i+"  "+"num="+thisClass.totalNQueens(i)+"\n");
        }
        System.out.print(thisClass.solveNQueens(4));
    }

    public List<String[]> solveNQueens(int n) {
        if (n==0) return null;
        int [] locations;
        locations = new int[n];
        List<String[]> result = new ArrayList<String[]>();

        getNQueens(locations, 0, result);
        return result;
    }

    public void getNQueens(int [] locations, int row, List<String[]> solutions) {
        if (row == locations.length) {
            String [] solution = new String[row];
            for(int i=0; i<locations.length; i++) {
                StringBuffer tmpRow = new StringBuffer();
                for (int j=0; j<locations.length; j++) {
                    if(j == locations[i]) tmpRow.append("Q");
                    else tmpRow.append(".");
                }
                solution[i] = tmpRow.toString();
            }
            solutions.add(solution);
        }

        for (int i=0; i<locations.length; i++) {
            if (check(locations, row, i)) {
                locations[row] = i;
                getNQueens(locations, row+1, solutions);
            }
        }
    }

}
