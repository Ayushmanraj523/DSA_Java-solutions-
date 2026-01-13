




public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.print("Original: ");
        for (int num : arr) System.out.print(num + " ");
        
        int start = 0, end = arr.length - 1;
        while (start < end) {
            // Swap elements at start and end
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        
        System.out.print("\nReversed: ");
        for (int num : arr) System.out.print(num + " ");
    }

}
