import java.util.*;

public class WordsWithinTwoEditsOfDictionary {

    public static boolean hasMatch(String query, String[] dictionary) {
        boolean found = false;

        for (String dict : dictionary) {
            int diffMax = 2;

            for (int i = 0; i < dict.length(); i++) {
                if (dict.charAt(i) != query.charAt(i)) {
                    diffMax--;
                }

                if (diffMax < 0) {
                    break;
                }
            }

            if (diffMax >= 0) {
                return true;
            }
        }

        return found;
    }

    public static List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();

        for (String query : queries) {
            if (hasMatch(query, dictionary)) {
                result.add(query);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String[] queries = {"word", "note", "ants", "wood"};
        String[] dictionary = {"wood", "joke", "moat"};

        List<String> result = twoEditWords(queries, dictionary);

        System.out.println("Words within two edits: " + result);
    }
}