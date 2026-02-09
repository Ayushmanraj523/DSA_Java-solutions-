class CircularQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    
    public CircularQueue(int size) {
        arr = new int[size];
        capacity = size;
        front = -1;
        rear = -1;
    }
    

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Circular Queue is full! Cannot add " + item);
            return;
        }
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        System.out.println("Enqueued: " + item);
    }
    
    
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Circular Queue is empty!");
            return -1;
        }
        int item = arr[front];
        if (front == rear) {
            
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        System.out.println("Dequeued: " + item);
        return item;
    }
    
    
    public int peek() {
        if (isEmpty()) {
            System.out.println("Circular Queue is empty!");
            return -1;
        }
        return arr[front];
    }
    
    public boolean isEmpty() {
        return front == -1;
    }
    
    
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
    
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Circular Queue is empty!");
            return;
        }
        System.out.print("Circular Queue: ");
        int i = front;
        while (true) {
            System.out.print(arr[i] + " ");
            if (i == rear) break;
            i = (i + 1) % capacity;
        }
        System.out.println();
    }
}

public class CircularQueueDemo {
    public static void main(String[] args) {
        System.out.println("=== CIRCULAR QUEUE DEMO ===");
        CircularQueue cq = new CircularQueue(5);
        
        System.out.println("\nAdding elements to circular queue:");
        cq.enqueue(1);
        cq.enqueue(2);
        cq.enqueue(3);
        cq.enqueue(4);
        cq.enqueue(5);
        cq.printQueue();
        
        System.out.println("\nFront element: " + cq.peek());
        
        System.out.println("\nRemoving 2 elements:");
        cq.dequeue();
        cq.dequeue();
        cq.printQueue();
        
        System.out.println("\nAdding more elements (circular behavior):");
        cq.enqueue(6);
        cq.enqueue(7);
        cq.printQueue();
        
        System.out.println("\nTrying to add when full:");
        cq.enqueue(8); 
        
        System.out.println("\nRemoving all elements:");
        while (!cq.isEmpty()) {
            cq.dequeue();
        }
        cq.printQueue();
    }
}
