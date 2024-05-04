package Lab8;

import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
    char character; 
    int frequency;  
    Node left, right; 

    
    public Node(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    
    @Override
    public int compareTo(Node other) {
        return this.frequency - other.frequency;
    }
}


class Tree {
    Node root;

    
    public Tree(Node root) {
        this.root = root;
    }
}

public class Lab8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your input: ");
        String input = sc.nextLine();

        int[] asciiArr = new int[127]; 

        
        for (int i = 0; i < input.length(); i++) {
            char A = input.charAt(i);
            asciiArr[(int) A]++;
        }

        for (int i = 0; i < asciiArr.length; i++) {
            if (asciiArr[i] > 0) {
                System.out.println("'" + (char) i + "' has frequency of  " + asciiArr[i]);
            }
        }

       
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for (int i = 0; i < asciiArr.length; i++) {
            if (asciiArr[i] > 0) {
                pq.offer(new Node((char) i, asciiArr[i]));
            }
        }

        
        Tree huffmanTree = buildHuffmanTree(pq);
        printHuffmanCodes(huffmanTree.root, "");
    }

    public static Tree buildHuffmanTree(PriorityQueue<Node> pq) {
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node('\0', left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;
            pq.offer(parent);
        }
        return new Tree(pq.poll());
    }

  
    public static void printHuffmanCodes(Node root, String code) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            System.out.println("'" + root.character + "' has a huffman encoding of " + code);
        }
        
        printHuffmanCodes(root.left, code + "0");
        printHuffmanCodes(root.right, code + "1");
    }
}