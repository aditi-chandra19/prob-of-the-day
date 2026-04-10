import java.util.*;

public class MinimumDistanceBetweenEqualElements {

    public static int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int ans = Integer.MAX_VALUE;
        
        for (List<Integer> indices : map.values()) {
            if (indices.size() < 3) continue;
            
            for (int i = 0; i + 2 < indices.size(); i++) {
                int distance = 2 * (indices.get(i + 2) - indices.get(i));
                ans = Math.min(ans, distance);
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 1, 2, 1};

        int result = minimumDistance(nums);

        if (result == -1) {
            System.out.println("No valid triplet found.");
        } else {
            System.out.println("Minimum Distance: " + result);
        }
    }
}