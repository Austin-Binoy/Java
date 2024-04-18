

import java.io.File;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.PriorityQueue;

class QueueComparator implements Comparator<BinaryTree3> {
	@Override
	public int compare(BinaryTree3 bt1, BinaryTree3 bt2) {
		if(bt1.root.value < bt2.root.value) {
			return 1;
		}else if(bt1.root.value > bt2.root.value) {
			return -1;
		}
		return 0;
	}
}

public class part2 {
	public static void main(String args[]) {
		PriorityQueue <BinaryTree3> PQ = new PriorityQueue <BinaryTree3>(new QueueComparator());
		File file = new File("C:\\Users\\austi\\OneDrive\\Documents\\UNI\\University\\CS211\\lab7- Binary Translator\\EnglishFrequencies.csv");
		int inputSize = 26288;
		BinaryTree3[] btarray = new BinaryTree3[inputSize];
		String[] input = new String[inputSize];
		
		try {
			Scanner scan = new Scanner(file);

			for(int i = 0; i < inputSize; i++) {
				 String input2 = scan.nextLine();
				 String[] array = input2.split(",");
				 btarray[i] = new BinaryTree3();
				 btarray[i].root = new Node3(Long.parseLong(array[1]),array[0]);
			}
			scan.close();
		} catch (Exception e) {
			System.err.println(e);
		}
		
		for(int i = 0; i < inputSize; i++) {
			PQ.add(btarray[i]);
		}
		
        while (PQ.size() >= 2) {
          BinaryTree3 bt1 = PQ.poll();
          BinaryTree3 bt2 = PQ.poll();
          ComboTree ct = new ComboTree(bt1, bt2);
          PQ.add(ct.createComboTree());
          System.out.println(PQ.size());
        }
    
	}
}
class Node4{
	 Node3 left;
	 Node3 right;
	 public Node4() {
	 left = null;
	 right = null;
	 }
	 public Node3 ToNode4() {
		 Node3 left = this.left;
		 Node3 right = this.left;
		 Node3 newNode = new Node3();
		 newNode.left = left;
		 newNode.right = right;
		 return newNode;
	 }
	}

class Node3{
	 long value;
	 String Word;
	 Node3 left;
	 Node3 right;
	 public Node3() {
		 left = null;
		 right = null;
	 }
	 
	 public Node3(long input1, String input2) {
	 value = input1;
	 Word = input2;
	 left = null;
	 right = null;
	 }
	}

	class BinaryTree3{
	 Node3 root;
	 public BinaryTree3() {
	 root = null;
	 }
	 // Method to insert a new node into the binary tree
	 // The insertRecursive method returns what the new rootshould be
	 public void insert(long value1, String value2) {
	 root = insertRecursive(root, value1, value2);
	 }
	 // A recursive method to insert a new node into the binary	tree
	 // The method returns what the new current should be
	 private Node3 insertRecursive(Node3 current, long insertValue, String insertValue2) {
	 if (current == null) {
	 return new Node3(insertValue, insertValue2);
	 }
	 //it returns the new node up a level so its parent can	be connected to it

	 if (current.value < insertValue) { //insert value less than current value
	 current.left = insertRecursive(current.left, insertValue, insertValue2);
	 } else if (current.value > insertValue) {
	 current.right = insertRecursive(current.right, insertValue, insertValue2);
	 }
	 return current;
	 }

	 // Method to get height of the binary tree
	 public int height() {
	 return heightRecursive(root);
	 }

	 // A recursive method to get the height
	 private int heightRecursive(Node3 current) {
	 if(current==null){
	 return 0;
	 }
	 // Calculate the height of the left and right subtrees	recursively
	 int leftHeight = heightRecursive(current.left);
	 int rightHeight = heightRecursive(current.right);
	 //the height here is 1 higher than the biggest height	of the two children
	 return 1+ Math.max(leftHeight, rightHeight);
	 }
	 
	 public void insert2(int value1, String value2) {
		    Node3 newNode = new Node3(value1, value2); // make new node
		    if (root == null) { // no node in root
		        root = newNode;
		        return;
		    }

		    Node3 current = root; // start at root
		    Node3 parent;

		    while (true) {
		        parent = current;
		        if (value1 < current.value) { // go left?
		            current = current.left;
		            if (current == null) { // if end of the line,
		                // insert on left
		                parent.left = newNode;
		                return;
		            }
		        } else { // go right
		            current = current.right;
		            if (current == null) { // if end of the line
		                // insert on right
		                parent.right = newNode;
		                return;
		            }
		        }
		    }
		}




	    void printLevelOrder()
	    {
	        Queue<Node3> queue = new LinkedList<Node3>();
	        queue.add(root);
	        while (!queue.isEmpty()) {
	 
	            // poll() removes the present head.  
	            Node3 tempNode = queue.poll();
	            System.out.println(tempNode.value + " ");
	 
	            // Enqueue left child
	            if (tempNode.left != null) {
	                queue.add(tempNode.left);
	            }
	 
	            // Enqueue right child
	            if (tempNode.right != null) {
	                queue.add(tempNode.right);
	            }
	        }
	    }
	    public Node3 find(String key) {
	        Node3 current = root; // start at the root
	        while (current != null) { // while not found and not reached end
	            if (current.value < root.value) // go left?
	                current = current.left;
	            else
	                current = current.right; // or go right?
	        }
	        return current; // return either found node or null
	    }
	    
	  public  void printLevelOrder1()
	    {
	        Queue<Node3> queue = new LinkedList<Node3>();
	        queue.add(root);
	        while (!queue.isEmpty()) {
	 
	            // poll() removes the present head.  
	            Node3 tempNode = queue.poll();
	            System.out.println(tempNode.Word + " ");
	 
	            // Enqueue left child
	            if (tempNode.left != null) {
	                queue.add(tempNode.left);
	            }
	 
	            // Enqueue right child
	            if (tempNode.right != null) {
	                queue.add(tempNode.right);
	            }
	        }
	    }
	}
	
	class ComboTree {
	    BinaryTree3 left;
	    BinaryTree3 right;

	    public ComboTree(BinaryTree3 left, BinaryTree3 right) {
	        this.left = left;
	        this.right = right;
	    }
	    public BinaryTree3 createComboTree() {
	        BinaryTree3 combo = new BinaryTree3();

	        // Create a new root node for the combined tree
	        combo.root = new Node3();

	        // Assign the left subtree of the combined tree
	        if (left != null && left.root != null) {
	            combo.root.left = left.root;
	        }

	        // Assign the right subtree of the combined tree
	        if (right != null && right.root != null) {
	            combo.root.right = right.root;
	        }

	        return combo;
	    }
	}
	    
	    
