package LeetCode;

/**
 * Created by yuhaos on 9/9/14.
 */
public class SearchInRotatedSortedArray {
    public int searchInRotatedSortedArray(int [] A, int target) {
        int low=0, high=A.length-1;

        while (low<high) {
            int mid=(low+high)/2;
            if (A[mid] < A[high]) {
                if (target>A[mid] && target<=A[high]) low=mid+1;
                else high=mid;
            } else {
                if (target>=A[low] && target<=A[mid]) high=mid;
                else low=mid+1;
            }
        }

        if (A[low]==target) return low;

        return -1;
    }

    public static void main(String [] args) {
        SearchInRotatedSortedArray thisClass = new SearchInRotatedSortedArray();
        int [] testArray = {3,5,-1};

        System.out.print(thisClass.searchInRotatedSortedArray(testArray, 5));
    }
}
