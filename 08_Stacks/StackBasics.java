import java.util.Stack;

public class StackBasics {
    public static void main(String[] args) {
        // Stack Create karna
        Stack<Integer> stack = new Stack<>();
        
        // --- 1. PUSH Operation (Daalna) ---
        System.out.println("Pushing elements:");
        stack.push(10);
        System.out.println("Pushed: 10, Stack: " + stack);
        
        stack.push(20);
        System.out.println("Pushed: 20, Stack: " + stack);
        
        stack.push(30);
        System.out.println("Pushed: 30, Stack: " + stack);
        
        // --- 2. PEEK Operation (Jhankna - Top element dekhna) ---
        System.out.println("\nTop element (peek): " + stack.peek());
        System.out.println("Stack after peek: " + stack); // Stack change nahi hota
        
        // --- 3. POP Operation (Nikalna) ---
        System.out.println("\nPopping elements:");
        System.out.println("Popped: " + stack.pop() + ", Stack: " + stack);
        System.out.println("Popped: " + stack.pop() + ", Stack: " + stack);
        
        // --- 4. Other Operations ---
        System.out.println("\nIs stack empty? " + stack.isEmpty());
        System.out.println("Stack size: " + stack.size());
    }
}