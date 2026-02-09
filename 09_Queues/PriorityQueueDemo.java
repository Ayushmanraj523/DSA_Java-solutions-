import java.util.PriorityQueue;
import java.util.Collections;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        System.out.println("=== PRIORITY QUEUE DEMO ===\n");
        
        
        System.out.println("1. MIN PRIORITY QUEUE (Default):");
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        
        minPQ.add(30);
        minPQ.add(10);
        minPQ.add(50);
        minPQ.add(20);
        minPQ.add(40);
        
        System.out.println("Queue: " + minPQ);
        System.out.println("Peek (highest priority): " + minPQ.peek());
        
        System.out.println("\nProcessing elements:");
        while (!minPQ.isEmpty()) {
            System.out.println("Removed: " + minPQ.poll() + ", Remaining: " + minPQ);
        }
        
        
        System.out.println("\n2. MAX PRIORITY QUEUE (Largest element has highest priority):");
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        
        maxPQ.add(30);
        maxPQ.add(10);
        maxPQ.add(50);
        maxPQ.add(20);
        maxPQ.add(40);
        
        System.out.println("Queue: " + maxPQ);
        System.out.println("Peek (highest priority): " + maxPQ.peek());
        
        System.out.println("\nProcessing elements:");
        while (!maxPQ.isEmpty()) {
            System.out.println("Removed: " + maxPQ.poll() + ", Remaining: " + maxPQ);
        }
        
        
        System.out.println("\n3. STRING PRIORITY QUEUE (Alphabetical order):");
        PriorityQueue<String> stringPQ = new PriorityQueue<>();
        
        stringPQ.add("Mango");
        stringPQ.add("Apple");
        stringPQ.add("Cherry");
        stringPQ.add("Banana");
        stringPQ.add("Dates");
        
        System.out.println("Queue: " + stringPQ);
        System.out.println("\nProcessing string elements:");
        while (!stringPQ.isEmpty()) {
            System.out.println("Removed: " + stringPQ.poll());
        }
    }
}
