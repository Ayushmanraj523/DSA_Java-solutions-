public class FibonacciRecursion {
    static int callCount = 0;
    
    public static void main(String[] args) {
        System.out.println("=== FIBONACCI SERIES USING RECURSION ===\n");
        
        
        System.out.println("First 10 Fibonacci numbers:");
        for (int i = 0; i < 10; i++) {
            callCount = 0;
            int result = fibonacci(i);
            System.out.println("F(" + i + ") = " + result + 
                             " (Function calls: " + callCount + ")");
        }
        
        
        System.out.println("\n=== RECURSION TREE FOR F(4) ===");
        callCount = 0;
        System.out.println("\nFinal result: F(4) = " + fibonacciWithTrace(4, 0));
        System.out.println("Total function calls: " + callCount);
    }
    
    static int fibonacci(int n) {
        callCount++;
        if (n <= 1) {
            return n; 
        }
        return fibonacci(n - 1) + fibonacci(n - 2); 
    }
    
    static int fibonacciWithTrace(int n, int depth) {
        callCount++;
        String indent = "  ".repeat(depth);
        System.out.println(indent + "Calculating F(" + n + ")");
        
        if (n <= 1) {
            System.out.println(indent + "Base case: F(" + n + ") = " + n);
            return n;
        }
        
        int left = fibonacciWithTrace(n - 1, depth + 1);
        int right = fibonacciWithTrace(n - 2, depth + 1);
        int result = left + right;
        
        System.out.println(indent + "F(" + n + ") = F(" + (n-1) + ") + F(" + 
                         (n-2) + ") = " + left + " + " + right + " = " + result);
        return result;
    }
}
