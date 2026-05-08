public class MaximumValueArray {

    public static int[] maxValue(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];
        int[] preMax = new int[n];

        // Prefix maximum
        preMax[0] = nums[0];

        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], nums[i]);
        }
MinimumJumpsUsingPrimeConnections.cpp
        int sufMin = Integer.MAX_VALUE;

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            if (i < n - 1 && preMax[i] > sufMin)
                ans[i] = ans[i + 1];
            else
                ans[i] = preMax[i];

            sufMin = Math.min(sufMin, nums[i]);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {3, 1, 4, 2, 5};

        int[] result = maxValue(nums);

        System.out.println("Result Array:");

        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}