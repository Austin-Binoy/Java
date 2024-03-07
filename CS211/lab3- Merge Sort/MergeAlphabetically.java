package lab3;
public class MergeAlphabetically {

    public static String mergeSortedStrings(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        int i = 0, j = 0;

        while (i < word1.length() && j < word2.length()) {
            if (word1.charAt(i) <= word2.charAt(j)) {
                merged.append(word1.charAt(i));
                i++;
            } else {
                merged.append(word2.charAt(j));
                j++;
            }
        }

        while (i < word1.length()) {
            merged.append(word1.charAt(i));
            i++;
        }

        while (j < word2.length()) {
            merged.append(word2.charAt(j));
            j++;
        }

        return merged.toString();
    }

    public static void main(String[] args) {
        String word1 = "abcdhij";
        String word2 = "efg";
        System.out.println(mergeSortedStrings(word1, word2));
    }
}
