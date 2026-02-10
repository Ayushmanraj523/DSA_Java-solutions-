import java.util.HashMap;
import java.util.Map;

public class FrequencyCounter {
    public static void main(String[] args) {
        System.out.println("=== FREQUENCY COUNTER USING HASH MAP ===\n");
        
        System.out.println("1. WORD FREQUENCY IN SENTENCE:");
        String sentence = "the cat and the dog and the mouse";
        String[] words = sentence.split(" ");
        
        HashMap<String, Integer> wordFreq = new HashMap<>();
        
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }
        
        System.out.println("Sentence: " + sentence);
        System.out.println("Word frequencies:");
        for (Map.Entry<String, Integer> entry : wordFreq.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
        
        System.out.println("\n2. CHARACTER FREQUENCY:");
        String str = "programming";
        HashMap<Character, Integer> charFreq = new HashMap<>();
        
        for (char c : str.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }
        
        System.out.println("String: " + str);
        System.out.println("Character frequencies:");
        for (Map.Entry<Character, Integer> entry : charFreq.entrySet()) {
            System.out.println("  '" + entry.getKey() + "': " + entry.getValue());
        }
        
        System.out.println("\n3. FIRST NON-REPEATING CHARACTER:");
        String test = "aabbccdeeffg";
        HashMap<Character, Integer> freqMap = new HashMap<>();
        
    
        for (char c : test.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        char firstNonRepeat = ' ';
        for (char c : test.toCharArray()) {
            if (freqMap.get(c) == 1) {
                firstNonRepeat = c;
                break;
            }
        }
        
        System.out.println("String: " + test);
        System.out.println("First non-repeating character: '" + firstNonRepeat + "'");
        
    
        System.out.println("\n4. MOST FREQUENT ELEMENT:");
        int[] numbers = {1, 2, 3, 2, 4, 2, 5, 2, 6, 2};
        HashMap<Integer, Integer> numFreq = new HashMap<>();
        
        for (int num : numbers) {
            numFreq.put(num, numFreq.getOrDefault(num, 0) + 1);
        }
        
        int mostFrequent = -1;
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : numFreq.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }
        
        System.out.print("Array: ");
        for (int num : numbers) System.out.print(num + " ");
        System.out.println("\nMost frequent element: " + mostFrequent + " (appears " + maxCount + " times)");
    }
}
