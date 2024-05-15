package Lab11;

import java.io.*;
import java.util.Scanner;
public class LoadFile {
    public static void main(String[] args) {
        File file = new File("Lab11\\Underground.csv");
        String[] addresses = new String[100];
        int[][] distances = new int[100][100];
        try {
            Scanner scan = new Scanner(file);
            for (int i = 0; i < 100; i++) {
                String line = scan.nextLine();
                String[] parts = line.split(","); // Split the line by commas
                addresses[i] = parts[0]; //get the address
                for (int j = 0; j < 100; j++) { //get the distances
                    distances[i][j] = Integer.parseInt(parts[j + 1].trim());
                }
            }
            scan.close();
        } catch (Exception e) {
            System.err.println(e);
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(addresses[i]);

        }
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 99; j++) {
                System.out.print(distances[i][j] + ",");

            }
            System.out.println(distances[i][99]);
        }
    }
}