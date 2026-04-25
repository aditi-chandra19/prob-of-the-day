public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int temp = 0;

        for (int i = 0; i < nums.length; i++) {
            temp = Math.max(nums[i], temp + nums[i]);
            result = Math.max(result, temp);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int result = maxSubArray(nums);

        System.out.println("Maximum Subarray Sum: " + result);
    }
}