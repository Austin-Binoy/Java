import java.util.*;

public class Lab4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> linkedList = new LinkedList<>();

        System.out.println("Enter a word and enter END to finish the link");
        String word = scanner.nextLine();

        while (!word.equals("END")) {
            linkedList.addFirst(word); 
            System.out.println("Enter a word: ");
            word = scanner.nextLine();
        }

        System.out.println("Words in the linked list:");
        for (String list : linkedList) {
            System.out.println(list);
        }
    }
}