

public class SelectionSortDemo {
    public static void main(String[] args) {
        int[] arr = {29, 10, 14, 37, 13};
        System.out.println("Original array: " + java.util.Arrays.toString(arr));
        
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            // Find index of minimum element in unsorted part
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap minimum element with first element of unsorted part
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            
            System.out.println("Pass " + (i + 1) + ": " + java.util.Arrays.toString(arr));
        }
        
        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
    }

}
