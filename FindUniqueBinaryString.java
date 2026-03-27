public class FindUniqueBinaryString {

    public static String findDifferentBinaryString(String[] nums) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            result.append(nums[i].charAt(i) == '1' ? '0' : '1');
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String[] nums = {"01", "10"};

        String uniqueString = findDifferentBinaryString(nums);

        System.out.println("Unique Binary String: " + uniqueString);
    }
}