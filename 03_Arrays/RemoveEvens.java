import java.util.Arrays;

public class RemoveEvens {
      public static void main(String[] args) {
        int[] original = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int oddCount = 0;
        
        // First, count odd numbers to determine new array size
        for (int num : original) {
            if (num % 2 != 0) oddCount++;
        }
        
        int[] result = new int[oddCount];
        int index = 0;
        
        // Fill new array with only odd numbers
        for (int num : original) {
            if (num % 2 != 0) {
                result[index] = num;
                index++;
            }
        }
        
        System.out.println("Array without evens: " + Arrays.toString(result));
    }

}
