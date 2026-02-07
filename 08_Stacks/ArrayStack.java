
class CustomStack {
    private int[] arr;
    private int top;
    private int capacity;
    
    
    public CustomStack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1; 
    }
    
    
    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow! (Jagah nahi hai)");
            return;
        }
        arr[++top] = x;
        System.out.println("Pushed: " + x);
    }
    
    
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! (Stack khali hai)");
            return -1;
        }
        return arr[top--];
    }
    
    
    public int peek() {
        if (!isEmpty()) {
            return arr[top];
        }
        return -1;
    }
    
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    
    public boolean isFull() {
        return top == capacity - 1;
    }
    
    
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}


public class ArrayStack {
    public static void main(String[] args) {
        
        CustomStack stack = new CustomStack(5);
        
        System.out.println("--- Pushing Elements ---");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.printStack();
        
        System.out.println("\n--- Peeking ---");
        System.out.println("Top element: " + stack.peek());
        
        System.out.println("\n--- Popping ---");
        System.out.println("Popped: " + stack.pop());
        stack.printStack();
    }
}