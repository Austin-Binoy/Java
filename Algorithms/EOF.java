import java.util.*;

public class EOF {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int count = 1;
        
        while(scanner.hasNext()){
            String input = scanner.nextLine();
            System.out.println(count + " " + input);
            count++;
        }
    }
}