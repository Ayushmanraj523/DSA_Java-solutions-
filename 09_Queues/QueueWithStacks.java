import java.util.Stack;

class QueueUsingStacks {
    private Stack<Integer> stack1; 
    private Stack<Integer> stack2; 
    
    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    
    public void enqueue(int item) {
        stack1.push(item);
        System.out.println("Enqueued: " + item);
    }
    
    
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        
        
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        
        int item = stack2.pop();
        System.out.println("Dequeued: " + item);
        return item;
    }
    
    
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        
        return stack2.peek();
    }
    
    
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    
    
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        
        System.out.print("Queue (front to rear): ");
        

        for (int i = stack2.size() - 1; i >= 0; i--) {
            System.out.print(stack2.get(i) + " ");
        }
        
        
        for (int i = 0; i < stack1.size(); i++) {
            System.out.print(stack1.get(i) + " ");
        }
        System.out.println();
    }
}

public class QueueWithStacks {
    public static void main(String[] args) {
        System.out.println("=== QUEUE USING TWO STACKS ===\n");
        QueueUsingStacks queue = new QueueUsingStacks();
        
        System.out.println("Enqueuing elements:");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.printQueue();
        
        System.out.println("\nFront element: " + queue.peek());
        
        System.out.println("\nDequeuing elements:");
        queue.dequeue();
        queue.printQueue();
        
        System.out.println("\nEnqueuing more:");
        queue.enqueue(40);
        queue.enqueue(50);
        queue.printQueue();
        
        System.out.println("\nDequeuing all:");
        while (!queue.isEmpty()) {
            queue.dequeue();
        }
        queue.dequeue(); 
    }
}
