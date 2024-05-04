import java.io.File;
import java.util.Scanner;
// import java.util.LinkedList;
// import java.util.Queue;

public class binarytreelab {
    public static void main(String[] args) {
        // import file
        TranslationTree mytree = new TranslationTree();

        File file = new File("C:\\Users\\austi\\OneDrive\\Documents\\UNI\\University\\CS211\\Lab 7\\EnglishSpanish.csv");
        int inputSize = 28636;
        String[] input = new String[inputSize];
        String[] englishWords = new String[inputSize];
        String[] spanishWords = new String[inputSize];
        try {
            Scanner scan = new Scanner(file);

            // Splitting the input into arrays containing english and spanish words
            // respectively
            for (int i = 0; i < inputSize; i++) {
                input[i] = scan.nextLine();
                String[] words = input[i].split(",");
                englishWords[i] = words[0];
                spanishWords[i] = words[1];
            }
            scan.close();
        } catch (Exception e) {
            System.err.println(e);
        }

        // Does not work as intended, midpoint insertion is not perfect
        mytree.insertMidpoints(englishWords, spanishWords, 0, inputSize - 1);
        System.out.println("Tree height: " + mytree.height());
        // mytree.printLevelByLevel();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text in English to translate to Spanish: ");
        String inputString = sc.nextLine();
        sc.close();

        //translate sentances
        String [] inputStrings = inputString.split(" ");
        for (int i = 0; i < inputStrings.length; i++) {
            System.out.print(mytree.translate(inputStrings[i]) + " ");
        }
        System.out.println("\nSteps: " + mytree.steps(inputStrings.length));
        System.out.println("\nAvgSteps: " + mytree.avgsteps(inputStrings.length));
    }
}

class Node {
    String english;
    String spanish;
    Node left, right;

    public Node(String eng, String esp) {
        english = eng;
        spanish = esp;
        left = null;
        right = null;
    }
}

class TranslationTree {
    Node root;
    int steps = 0;
    public TranslationTree() {
        root = null;
    }

    public void insert(String english, String spanish) {
        root = insertRecursive(root, english, spanish);
    }
    private Node insertRecursive(Node current, String english, String spanish) {
        if (current == null) {
            return new Node(english, spanish);
        }

        if (english.compareTo(current.english) < 0) {
            current.left = insertRecursive(current.left, english, spanish);
        } else if (english.compareTo(current.english) > 0) {
            current.right = insertRecursive(current.right, english, spanish);
        }
        return current;
    }
    public void insertMidpoints(String[] english, String[] spanish, int start, int end) {
        if (start <= end) {
            int middle = (start + end) / 2;
            insert(english[middle], spanish[middle]);
            insertMidpoints(english, spanish, start, middle - 1);
            insertMidpoints(english, spanish, middle + 1, end);
        }
    }


    public int height() {
        return heightRecursive(root);
    }
    private int heightRecursive(Node current) {
        if (current == null) {
            return 0;
        }
        int leftHeight = heightRecursive(current.left);
        int rightHeight = heightRecursive(current.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
 

    public String translate (String key){
        Node current = root;
        while(current.english != key){
            steps++;
            if (key.equals(current.english)) return current.spanish;
            else if(key.compareTo(current.english) < 0) current=current.left;
            else current=current.right;
            if(current == null) return null;
            }
        return current.english;
    }
    public double avgsteps (int size) {
        return steps/(double)size;
    }
    public int steps (int size) {
        return steps;
    }
}