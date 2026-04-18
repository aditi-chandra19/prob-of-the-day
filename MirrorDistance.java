public class MirrorDistance {

    public static int mirrorDistance(int n) {
        int rev = 0;

        for (int x = n; x > 0; x /= 10) {
            rev = 10 * rev + x % 10;
        }

        return Math.abs(rev - n);
    }

    public static void main(String[] args) {

        int n = 1234;

        int result = mirrorDistance(n);

        System.out.println("Mirror Distance of " + n + " is: " + result);
    }
}