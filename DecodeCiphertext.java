public class DecodeCiphertext {

    public static String decodeCiphertext(String s, int r) {
        if (r == 1) return s;

        int n = s.length();
        int c = (int) Math.ceil((double) n / r);

        char[][] mat = new char[r][c];
        char[] arr = s.toCharArray();
        int p = 0;

        // fill matrix row-wise
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = arr[p++];
            }
        }

        StringBuilder res = new StringBuilder();

        // traverse diagonally
        for (int k = 0; k < c; k++) {
            int x = 0, y = k;

            while (x < r && y < c) {
                res.append(mat[x][y]);
                x++;
                y++;
            }
        }

        return res.toString().stripTrailing();
    }

    public static void main(String[] args) {

        String s = "ch   ie   pr";
        int r = 3;

        String result = decodeCiphertext(s, r);

        System.out.println("Decoded String: \"" + result + "\"");
    }
}