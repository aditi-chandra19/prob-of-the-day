import java.util.*;

public class SurvivedRobotsHealths {

    static class Robo {
        int originalIdx;
        int pos;
        int health;
        char dir;

        Robo(int originalIdx, int pos, int health, char dir) {
            this.originalIdx = originalIdx;
            this.pos = pos;
            this.health = health;
            this.dir = dir;
        }
    }

    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {

        int n = positions.length;
        List<Robo> robotList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            robotList.add(new Robo(i, positions[i], healths[i], directions.charAt(i)));
        }

        // sort by position
        robotList.sort((a, b) -> Integer.compare(a.pos, b.pos));

        Stack<Robo> st = new Stack<>();

        for (Robo curRobo : robotList) {

            if (curRobo.dir == 'R') {
                st.push(curRobo);
            } else {
                // collision
                while (!st.isEmpty() && st.peek().dir == 'R' && curRobo.health > 0) {
                    Robo top = st.pop();

                    if (curRobo.health == top.health) {
                        curRobo.health = 0;
                        top.health = 0;
                    } else if (curRobo.health > top.health) {
                        curRobo.health--;
                    } else {
                        top.health--;
                        curRobo.health = 0;
                        st.push(top);
                    }
                }

                if (curRobo.health > 0) {
                    st.push(curRobo);
                }
            }
        }

        // sort survivors by original index
        Robo[] survivors = st.toArray(new Robo[0]);
        Arrays.sort(survivors, (a, b) -> Integer.compare(a.originalIdx, b.originalIdx));

        List<Integer> res = new ArrayList<>();
        for (Robo r : survivors) {
            res.add(r.health);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] positions = {5, 4, 3, 2, 1};
        int[] healths = {2, 17, 9, 15, 10};
        String directions = "RRRRR";

        List<Integer> result = survivedRobotsHealths(positions, healths, directions);

        System.out.println("Surviving Robots' Healths: " + result);
    }
}