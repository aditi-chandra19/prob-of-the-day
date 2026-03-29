public class MadeEqualWithOperationsI {

    public static boolean check(String s1, String s2, int[] order) {
        return s1.charAt(0) == s2.charAt(order[0]) &&
               s1.charAt(1) == s2.charAt(order[1]) &&
               s1.charAt(2) == s2.charAt(order[2]) &&
               s1.charAt(3) == s2.charAt(order[3]);
    }

    public static boolean canBeEqual(String s1, String s2) {
        if (check(s1, s2, new int[]{0, 1, 2, 3})) return true;
        if (check(s1, s2, new int[]{2, 1, 0, 3})) return true;
        if (check(s1, s2, new int[]{0, 3, 2, 1})) return true;
        if (check(s1, s2, new int[]{2, 3, 0, 1})) return true;
        return false;
    }

    public static void main(String[] args) {

        String s1 = "abcd";
        String s2 = "cdab";

        boolean result = canBeEqual(s1, s2);

        if (result) {
            System.out.println("Yes, strings can be made equal.");
        } else {
            System.out.println("No, strings cannot be made equal.");
        }
    }
}