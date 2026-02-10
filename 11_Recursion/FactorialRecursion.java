public class FactorialRecursion {
    public static void main(String[] args) {
        System.out.println("=== FACTORIAL USING RECURSION ===\n");
        
        int[] numbers = {0, 1, 5, 7, 10};
        
        for (int n : numbers) {
            System.out.println("Factorial of " + n + " = " + factorial(n));
            System.out.println("Recursive calls trace for " + n + ":");
            factorialWithTrace(n);
            System.out.println("-------------------");
        }
    }
    
    static int factorial(int n) {
        if (n <= 1) {
            return 1; 
        }
        return n * factorial(n - 1); 
    }
    
    static int factorialWithTrace(int n) {
        System.out.println("  ".repeat(5 - n) + "Calling factorial(" + n + ")");
        
        if (n <= 1) {
            System.out.println("  ".repeat(5 - n) + "Base case reached: factorial(" + n + ") = 1");
            return 1;
        }
        
        int result = n * factorialWithTrace(n - 1);
        System.out.println("  ".repeat(5 - n) + "Returning factorial(" + n + ") = " + result);
        return result;
    }
}
