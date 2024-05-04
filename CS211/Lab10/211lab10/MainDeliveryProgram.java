import java.io.*;
import java.util.*;

public class MainDeliveryProgram {
    public static void main(String[] args) {
        // Load data from file
        File file = new File("211lab10\\deliveries.csv");
        int[][] distances = new int[100][100];
        try {
            Scanner scan = new Scanner(file);
            for (int i = 0; i < 100; i++) {
                String line = scan.nextLine();
                String[] parts = line.split(",");
                for (int j = 0; j < 100; j++) {
                    distances[i][j] = Integer.parseInt(parts[j + 1].trim());
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
            return;
        }

        // Apache Pizza is assumed to be at index 0
        int source = 0;
        List<Integer> route = nearestNeighbor(distances, source);

        // Calculate total distance
        int totalDistance = calculateTotalDistance(distances, route);
        System.out.println("Total distance for the route: " + totalDistance + " meters");
    }


    //  the algorithm iteratively selects the nearest unvisited delivery point from the current point 
    //  and updates the route accordingly until all points are visited.
    public static List<Integer> nearestNeighbor(int[][] distances, int start) {
        int n = distances.length;
        boolean[] visited = new boolean[n];
        List<Integer> route = new ArrayList<>();
        int current = start;
        visited[current] = true;
        route.add(current); 

        // Continue until all nodes are visited
        while (route.size() < n) {
            int nearest = -1;
            int shortestDistance = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (!visited[i] && distances[current][i] < shortestDistance) {
                    nearest = i;
                    shortestDistance = distances[current][i];
                }
            }

            visited[nearest] = true;
            route.add(nearest);
            current = nearest;
        }
        
        // Return to the starting point
        route.add(start);
        return route;
    }


    //total distance of the generated route
    public static int calculateTotalDistance(int[][] distances, List<Integer> route) {
        int totalDistance = 0;
        for (int i = 0; i < route.size() - 1; i++) {
            totalDistance += distances[route.get(i)][route.get(i + 1)];
        }
        return totalDistance;
    }
}
