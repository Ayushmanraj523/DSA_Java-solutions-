//4. Find Minimum and Maximum in Array
//Concept: Searching for extreme values

public class MinMaxSearch {
    public static void main(String[] args) {
        int[] numbers = {45, 12, 89, 34, 67, 23, 91, 18};
        
        int min = numbers[0]; // Assume first element is min
        int max = numbers[0]; // Assume first element is max
        
        // Single pass to find both min and max
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i]; // Update min
            }
            if (numbers[i] > max) {
                max = numbers[i]; // Update max
            }
        }
        
        System.out.println("Array: " + java.util.Arrays.toString(numbers));
        System.out.println("Minimum value: " + min);
        System.out.println("Maximum value: " + max);
        
        // Find second largest
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        
        for (int num : numbers) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }
        System.out.println("Second largest: " + second);
    }

}
