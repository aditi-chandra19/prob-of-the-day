import java.util.*;

public class JumpGameIII {

    public static boolean canReach(int[] arr, int start) {

        int n = arr.length;

        boolean[] visited = new boolean[n];

        Queue<Integer> q = new ArrayDeque<>();

        q.offer(start);

        while (!q.isEmpty()) {

            int i = q.poll();

            if (i < 0 || i >= n || visited[i]) {
                continue;
            }

            if (arr[i] == 0) {
                return true;
            }

            visited[i] = true;

            q.offer(i + arr[i]);

            q.offer(i - arr[i]);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] arr = {4, 2, 3, 0, 3, 1, 2};

        int start = 5;

        boolean result = canReach(arr, start);

        if (result) {
            System.out.println("Can reach an index with value 0.");
        } else {
            System.out.println("Cannot reach an index with value 0.");
        }
    }
}