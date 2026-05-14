import java.util.BitSet;

public class CheckIfArrayIsGood {

    public static boolean isGood(int[] nums) {

        int n = nums.length - 1;

        BitSet seen = new BitSet(201);

        boolean dup = false;

        for (int num : nums) {

            if (num > n) {
                return false;
            }

            if (seen.get(num)) {

                if (num < n || dup) {
                    return false;
                }

                dup = true;

                continue;
            }

            seen.set(num);
        }

        return true;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 3, 2};

        boolean result = isGood(nums);

        if (result) {
            System.out.println("Array is Good.");
        } else {
            System.out.println("Array is Not Good.");
        }
    }
}