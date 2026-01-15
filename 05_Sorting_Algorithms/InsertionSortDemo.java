//3. Insertion Sort - Build Sorted Array One Element at a Time

public class InsertionSortDemo {
     public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        System.out.println("Original array: " + java.util.Arrays.toString(arr));
        
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            
            // Move elements greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
            
            System.out.println("Pass " + i + ": " + java.util.Arrays.toString(arr));
        }
        
        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
    }

}
