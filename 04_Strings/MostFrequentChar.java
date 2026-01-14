//4. Find Most Frequent Character in a string 
public class MostFrequentChar {
     public static void main(String[] args) {
        String str = "programming";
        int[] freq = new int[256]; // Array to store frequency of each ASCII character
        
        // Count frequency of each character
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }
        
        char maxChar = ' ';
        int maxCount = 0;
        
        // Find character with maximum frequency
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > maxCount) {
                maxCount = freq[i];
                maxChar = (char) i;
            }
        }
        
        System.out.println("Most frequent character: '" + maxChar + "' appears " + maxCount + " times");
    }

}
