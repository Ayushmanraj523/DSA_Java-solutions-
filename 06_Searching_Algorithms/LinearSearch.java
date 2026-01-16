//1. Linear Search in Array
//Concept: Sequential search through each element
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {10, 23, 45, 67, 89, 12, 34};
        int target = 67;
        boolean found = false;
        int position = -1;
        
        // Search through each element one by one
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                found = true;
                position = i;
                break; // Stop when found
            }
        }
        
        if (found) {
            System.out.println(target + " found at index: " + position);
        } else {
            System.out.println(target + " not found in array");
        }
        
        // Count occurrences of a number
        int count = 0;
        int searchNum = 45;
        for (int num : arr) {
            if (num == searchNum) {
                count++;
            }
        }
        System.out.println(searchNum + " appears " + count + " time(s)");
    }

}
