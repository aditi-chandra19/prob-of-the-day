public class FindtheStringwithLCP {

    public static String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] word = new char[n];
        char current = 'a';

        // construct the string starting from 'a' to 'z'
        for (int i = 0; i < n; i++) {
            if (word[i] == 0) {
                if (current > 'z') {
                    return "";
                }
                word[i] = current;
                for (int j = i + 1; j < n; j++) {
                    if (lcp[i][j] > 0) {
                        word[j] = word[i];
                    }
                }
                current++;
            }
        }

        // verify the constructed string
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word[i] != word[j]) {
                    if (lcp[i][j] != 0) {
                        return "";
                    }
                } else {
                    if (i == n - 1 || j == n - 1) {
                        if (lcp[i][j] != 1) {
                            return "";
                        }
                    } else {
                        if (lcp[i][j] != lcp[i + 1][j + 1] + 1) {
                            return "";
                        }
                    }
                }
            }
        }

        return new String(word);
    }

    public static void main(String[] args) {

        int[][] lcp = {
            {3, 0, 1},
            {0, 2, 0},
            {1, 0, 1}
        };

        String result = findTheString(lcp);

        if (result.isEmpty()) {
            System.out.println("No valid string can be formed.");
        } else {
            System.out.println("Constructed String: " + result);
        }
    }
}