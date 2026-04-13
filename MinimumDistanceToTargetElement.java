public class MinimumDistanceToTargetElement {

    public static int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;

        for (int dist = 0; dist < n; dist++) {

            int left = start - dist;
            if (left >= 0 && nums[left] == target) {
                return dist;
            }

            int right = start + dist;
            if (right < n && nums[right] == target) {
                return dist;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};
        int target = 5;
        int start = 3;

        int result = getMinDistance(nums, target, start);

        System.out.println("Minimum Distance: " + result);
    }
}