import java.util.*;

public class MinimumJumpsUsingPrimeConnections {

    static class Solution {

        static final int MAXV = 1000000;

        int[] smallestPrime = new int[MAXV + 1];

        void buildSieve() {

            for (int i = 0; i <= MAXV; i++) {
                smallestPrime[i] = i;
            }

            for (int i = 2; i * i <= MAXV; i++) {

                if (smallestPrime[i] == i) {

                    for (int j = i * i; j <= MAXV; j += i) {

                        if (smallestPrime[j] == j) {
                            smallestPrime[j] = i;
                        }
                    }
                }
            }
        }

        List<Integer> getPrimeFactors(int x) {

            List<Integer> factors = new ArrayList<>();

            while (x > 1) {

                int p = smallestPrime[x];

                factors.add(p);

                while (x % p == 0) {
                    x /= p;
                }
            }

            return factors;
        }

        public int minJumps(int[] nums) {

            buildSieve();

            int n = nums.length;

            Map<Integer, List<Integer>> factorMap = new HashMap<>();

            for (int i = 0; i < n; i++) {

                List<Integer> factors = getPrimeFactors(nums[i]);

                for (int f : factors) {

                    factorMap
                        .computeIfAbsent(f, k -> new ArrayList<>())
                        .add(i);
                }
            }

            boolean[] visited = new boolean[n];

            Set<Integer> usedFactor = new HashSet<>();

            Queue<int[]> q = new LinkedList<>();

            q.offer(new int[]{0, 0});

            visited[0] = true;

            while (!q.isEmpty()) {

                int[] cur = q.poll();

                int idx = cur[0];
                int dist = cur[1];

                if (idx == n - 1) {
                    return dist;
                }

                if (idx - 1 >= 0 && !visited[idx - 1]) {

                    visited[idx - 1] = true;

                    q.offer(new int[]{idx - 1, dist + 1});
                }

                if (idx + 1 < n && !visited[idx + 1]) {

                    visited[idx + 1] = true;

                    q.offer(new int[]{idx + 1, dist + 1});
                }

                List<Integer> factors = getPrimeFactors(nums[idx]);

                for (int f : factors) {

                    if (usedFactor.contains(f)) {
                        continue;
                    }

                    usedFactor.add(f);

                    for (int nextIdx : factorMap.getOrDefault(f, new ArrayList<>())) {

                        if (!visited[nextIdx]) {

                            visited[nextIdx] = true;

                            q.offer(new int[]{nextIdx, dist + 1});
                        }
                    }
                }
            }

            return -1;
        }
    }

    public static void main(String[] args) {

        Solution obj = new Solution();

        int[] nums = {2, 4, 8, 16, 32};

        int result = obj.minJumps(nums);

        System.out.println("Minimum Jumps: " + result);
    }
}