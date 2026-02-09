
class SimpleQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int count;

    
    public SimpleQueue(int size) {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot add " + item);
            return;
        }
        
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
        System.out.println("Enqueued: " + item);
    }

    
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int item = arr[front];
        front = (front + 1) % capacity;
        count--;
        System.out.println("Dequeued: " + item);
        return item;
    }

    
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return arr[front];
    }


    public boolean isEmpty() {
        return count == 0;
    }

    
    public boolean isFull() {
        return count == capacity;
    }


    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue (front to rear): ");
        int i = front;
        for (int j = 0; j < count; j++) {
            System.out.print(arr[i] + " ");
            i = (i + 1) % capacity;
        }
        System.out.println();
    }
}


public class SimpleQueueDemo {
    public static void main(String[] args) {
        System.out.println("=== SIMPLE QUEUE DEMO ===");
        SimpleQueue queue = new SimpleQueue(5);

        
        System.out.println("\nEnqueuing elements:");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60); 
        queue.printQueue();

        
        System.out.println("\nFront element: " + queue.peek());

        
        System.out.println("\nDequeuing elements:");
        queue.dequeue();
        queue.dequeue();
        queue.printQueue();

        
        System.out.println("\nEnqueuing more elements:");
        queue.enqueue(60);
        queue.enqueue(70);
        queue.printQueue();

        
        System.out.println("\nEmptying queue:");
        while (!queue.isEmpty()) {
            queue.dequeue();
        }
        queue.dequeue(); 
    }
}