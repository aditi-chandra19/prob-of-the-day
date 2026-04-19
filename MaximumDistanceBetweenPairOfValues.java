public class MaximumDistanceBetweenPairOfValues {

    public static int maxDistance(int[] A, int[] B) {
        int i, j;

        for (i = 0, j = 0; i < A.length && j < B.length; j++) {
            if (A[i] > B[j]) {
                i++;
            }
        }

        return Math.max(0, j - i - 1);
    }

    public static void main(String[] args) {

        int[] A = {55, 30, 5, 4, 2};
        int[] B = {100, 20, 10, 10, 5};

        int result = maxDistance(A, B);

        System.out.println("Maximum Distance: " + result);
    }
}