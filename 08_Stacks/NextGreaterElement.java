import java.util.Stack;

public class NextGreaterElement{
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        System.out.print("Array: ");
        for (int num : arr) System.out.print(num + " ");
        
        System.out.println("\n\nNext Greater Elements:");
        int[] result = nextGreater(arr);
        
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " -> " + result[i]);
        }
    }
    
    static int[] nextGreater(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        
        // Initialize result with -1
        for (int i = 0; i < arr.length; i++) {
            result[i] = -1;
        }
        
        // Process elements
        for (int i = 0; i < arr.length; i++) {
            // While stack not empty and current > stack top
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                int index = stack.pop();
                result[index] = arr[i];
            }
            stack.push(i); // Push current index
        }
        
        return result;
    }
}
