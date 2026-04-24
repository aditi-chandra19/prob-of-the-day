public class FurthestDistanceFromOrigin {

    public static int furthestDistanceFromOrigin(String moves) {
        int l = 0, r = 0, blank = 0;

        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'L') {
                l++;
            } else if (moves.charAt(i) == 'R') {
                r++;
            } else {
                blank++;
            }
        }

        return Math.abs(l - r) + blank;
    }

    public static void main(String[] args) {

        String moves = "L_RL__R";

        int result = furthestDistanceFromOrigin(moves);

        System.out.println("Furthest Distance From Origin: " + result);
    }
}