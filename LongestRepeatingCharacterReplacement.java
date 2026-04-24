public class LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {
        int n = s.length();
        int[] c = new int[26];
        int m = 0, l = 0;

        for (int r = 0; r < n; r++) {
            m = Math.max(m, ++c[s.charAt(r) - 'A']);

            if (m + k <= r - l) {
                c[s.charAt(l++) - 'A']--;
            }
        }

        return n - l;
    }

    public static void main(String[] args) {

        String s = "AABABBA";
        int k = 1;

        int result = characterReplacement(s, k);

        System.out.println("Longest Repeating Character Replacement Length: " + result);
    }
}