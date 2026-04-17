import java.util.*;

class Solution {
    public static int heightChecker(int[] heights) {
        int[] expected = heights.clone();  // copy array

        Arrays.sort(expected);  // sort to get expected order

        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] heights = {1, 1, 4, 2, 1, 3};
        System.out.println(heightChecker(heights));  // Output: 3
    }
}