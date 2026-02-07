import java.util.Stack;

public class ReverseStringStack {
    public static void main(String[] args) {
        String str = "HelloWorld";
        System.out.println("Original: " + str);
        System.out.println("Reversed: " + reverseString(str));
        
        String str2 = "12345";
        System.out.println("\nOriginal: " + str2);
        System.out.println("Reversed: " + reverseString(str2));
    }
    
    static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();
        
        
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        
        
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        
        return reversed.toString();
    }
}
