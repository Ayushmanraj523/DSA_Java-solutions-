//2. Binary Search (Array must be sorted)
//Concept: Divide and conquer approach

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        Arrays.sort(arr); // Ensure array is sorted
        int target = 55;
        
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid overflow
            
            System.out.println("Searching between indices " + left + " to " + right);
            System.out.println("Middle index: " + mid + ", value: " + arr[mid]);
            
            if (arr[mid] == target) {
                result = mid;
                break;
            } else if (arr[mid] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        
        if (result != -1) {
            System.out.println(target + " found at index: " + result);
        } else {
            System.out.println(target + " not found");
        }
    }
}

