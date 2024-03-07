package lab3;
public class MergeStrings {
    public static String mergeStrings(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) {
                merged.append(word1.charAt(i));
                i++;
            }
            if (j < word2.length()) {
                merged.append(word2.charAt(j));
                j++;
            }
        }
        return merged.toString();
    }

    public static void main(String[] args) {
        // Example 1
        String word1 = "abc";
        String word2 = "pqr";
        System.out.println(mergeStrings(word1, word2)); 

        // Example 2
        word1 = "ab";
        word2 = "pqrs";
        System.out.println(mergeStrings(word1, word2)); 

        // Example 3
        word1 = "abcd";
        word2 = "pq";
        System.out.println(mergeStrings(word1, word2)); 
    }
}
