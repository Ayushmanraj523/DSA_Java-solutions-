// Finding the Maximum Element in an Array
//Concept: Basic traversal and comparison.


import java.util.Arrays;
public class MaxElement {
    public static void main(String[] args) {
        int[] arr = {12, 45, 67, 23, 54};
        int max = arr[0]; // Assume first element is max
        
        // Traverse from the second element
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i]; // Update max if current element is larger
            }
        }
        System.out.println("Maximum element: " + max);
    }
}


