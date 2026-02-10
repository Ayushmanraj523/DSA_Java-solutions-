public class BinarySearchRecursion {
    public static void main(String[] args) {
        System.out.println("=== BINARY SEARCH USING RECURSION ===\n");
        
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72, 91};
        System.out.print("Sorted array: ");
        for (int num : arr) System.out.print(num + " ");
        System.out.println("\n");
        
        int[] targets = {23, 2, 91, 38, 100};
        
        for (int target : targets) {
            System.out.println("Searching for " + target + ":");
            int result = binarySearch(arr, target, 0, arr.length - 1, 0);
            if (result != -1) {
                System.out.println("  Found at index " + result + "\n");
            } else {
                System.out.println("  Not found in array\n");
            }
        }
    }
    
    static int binarySearch(int[] arr, int target, int left, int right, int depth) {
        String indent = "  ".repeat(depth);
        System.out.println(indent + "Searching range [" + left + " to " + right + "]");
        
    
        if (left > right) {
            System.out.println(indent + "Range empty - element not found");
            return -1;
        }
        
        
        int mid = left + (right - left) / 2;
        System.out.println(indent + "Mid index: " + mid + ", Value: " + arr[mid]);
        
        
        if (arr[mid] == target) {
            System.out.println(indent + "Found target at index " + mid);
            return mid;
        }
        
        
        if (target < arr[mid]) {
            System.out.println(indent + "Target " + target + " < " + arr[mid] + 
                             " - Searching left half");
            return binarySearch(arr, target, left, mid - 1, depth + 1);
        } else {
            System.out.println(indent + "Target " + target + " > " + arr[mid] + 
                             " - Searching right half");
            return binarySearch(arr, target, mid + 1, right, depth + 1);
        }
    }
}
