import java.util.Random;
import java.util.Scanner;

public class TraitorSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int simulations = 1000000;
        int traitorWins = 0;
        int totalParticipants = 22; 

        System.out.println("Enter the number of traitors");
        int n = sc.nextInt();

        while(!(n <= totalParticipants)){
            System.out.println("The number of traitors must be less than or equal to the total number of participants");
            System.out.println("Enter the number of traitors");
            n = sc.nextInt();
        }
        // Run the simulation multiple times
        for(int i = 0; i < simulations; i++){
            //increment the traitorWins counter
            if(simulateGame(totalParticipants, n)){
                traitorWins++;
            }
        }

        // Probability of traitors winning
        double prob = (double) traitorWins / simulations;
        System.out.println("The probability of traitors winning is: " + (prob * 100) + "%");
        sc.close();
    }

    public static boolean simulateGame(int totalParticipants, int traitors){
        int faithful = totalParticipants - traitors;
        Random rand = new Random(); //value between 0 and 1
        // Only 2 participants are left
        while(totalParticipants > 2){
            
                // Generate a random double and compare it to the ratio of traitors to total participants
                if (rand.nextDouble() < ((double) traitors / (totalParticipants * 2))) {
                    traitors--; //less than .5
                } else {
                    faithful--; //greater than .5
                }
                // Decrease the total number of participants after each elimination
                totalParticipants--;
        }

        // At least one traitor among the final two participants
        int remainingTraitors = totalParticipants - faithful;
        return remainingTraitors > 0;
    }
}