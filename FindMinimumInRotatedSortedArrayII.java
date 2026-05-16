public class FindMinimumInRotatedSortedArrayII {

    public static int findMin(int[] nums) {

        int s = 0;
        int e = nums.length - 1;

        while (s < e) {

            int mid = s + (e - s) / 2;

            // Minimum lies in right half
            if (nums[mid] > nums[e]) {
                s = mid + 1;
            }

            // Minimum lies in left half including mid
            else if (nums[mid] < nums[e]) {
                e = mid;
            }

            // Duplicate case
            else {
                e--;
            }
        }

        return nums[s];
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 2, 0, 1};

        int result = findMin(nums);

        System.out.println("Minimum Element: " + result);
    }
}