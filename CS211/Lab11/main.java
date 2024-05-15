import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class main {
    // Define constants for directions
    private static final int[] dx = {0, 0, 1, -1}; // North, South, East, West
    private static final int[] dy = {1, -1, 0, 0};

    // Define a class to represent a cell in the grid
    static class Cell {
        int x, y, cost;

        public Cell(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        // Load the underground map from the CSV file
        int[][] map = loadMapFromFile("Lab11\\Underground.csv");

        // Find the positions of start ('A') and end ('B')
        int startX = -1, startY = -1, endX = -1, endY = -1;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 'A') {
                    startX = i;
                    startY = j;
                } else if (map[i][j] == 'B') {
                    endX = i;
                    endY = j;
                }
            }
        }

        // Find the quickest route from start to end
        int shortestTime = findShortestRoute(map, startX, startY, endX, endY);

        // Output the result
        System.out.println("Shortest time to escape: " + shortestTime + " minutes");
    }

    // Function to load the underground map from a CSV file
    private static int[][] loadMapFromFile(String filename) {
        int[][] map = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            int numRows = lines.size();
            int numCols = lines.get(0).split(",").length;
            map = new int[numRows][numCols];
            for (int i = 0; i < numRows; i++) {
                String[] tokens = lines.get(i).split(",");
                for (int j = 0; j < numCols; j++) {
                    if (tokens[j].equals("*")) {
                        map[i][j] = -1; // Solid rock
                    } else {
                        try {
                            map[i][j] = Integer.parseInt(tokens[j]);
                        } catch (NumberFormatException e) {
                            map[i][j] = tokens[j].charAt(0); // Store 'A' or 'B' as characters
                        }
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    // Function to find the shortest route from start to end using Dijkstra's algorithm
    private static int findShortestRoute(int[][] map, int startX, int startY, int endX, int endY) {
        int numRows = map.length;
        int numCols = map[0].length;
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(cell -> cell.cost));
        boolean[][] visited = new boolean[numRows][numCols];
        pq.offer(new Cell(startX, startY, 0)); // Start from 'A'
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            if (cell.x == endX && cell.y == endY) {
                return cell.cost; // Reached 'B'
            }
            if (visited[cell.x][cell.y]) {
                continue;
            }
            visited[cell.x][cell.y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = cell.x + dx[i];
                int ny = cell.y + dy[i];
                if (nx >= 0 && nx < numRows && ny >= 0 && ny < numCols && !visited[nx][ny] && map[nx][ny] != -1) {
                    pq.offer(new Cell(nx, ny, cell.cost + map[nx][ny]));
                }
            }
        }
        return -1; // No path from start to end
    }
}