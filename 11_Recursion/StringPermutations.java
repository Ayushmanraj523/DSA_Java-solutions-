import java.util.ArrayList;

public class StringPermutations {
    static int permutationCount = 0;
    
    public static void main(String[] args) {
        System.out.println("=== STRING PERMUTATIONS USING RECURSION ===\n");
        
        String[] testStrings = {"A", "AB", "ABC", "123"};
        
        for (String str : testStrings) {
            permutationCount = 0;
            System.out.println("Permutations of \"" + str + "\":");
            ArrayList<String> permutations = getPermutations(str);
            
            System.out.println("All permutations:");
            for (int i = 0; i < permutations.size(); i++) {
                System.out.println("  " + (i+1) + ". " + permutations.get(i));
            }
            
            System.out.println("Total permutations: " + permutationCount);
            System.out.println("-------------------\n");
        }
        
        
        System.out.println("=== RECURSION TREE FOR \"ABC\" ===");
        permutationCount = 0;
        printPermutationsWithTrace("ABC", "", 0);
        System.out.println("\nTotal permutations: " + permutationCount);
    }
    
    static ArrayList<String> getPermutations(String str) {
        ArrayList<String> result = new ArrayList<>();
        generatePermutations(str.toCharArray(), 0, result);
        return result;
    }
    
    static void generatePermutations(char[] chars, int index, ArrayList<String> result) {
        if (index == chars.length - 1) {
            
            permutationCount++;
            result.add(new String(chars));
            return;
        }
        
        for (int i = index; i < chars.length; i++) {
            
            swap(chars, index, i);
            
            
            generatePermutations(chars, index + 1, result);
            
            
            swap(chars, index, i);
        }
    }
    
    static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    
    static void printPermutationsWithTrace(String str, String prefix, int depth) {
        String indent = "  ".repeat(depth);
        
        if (str.isEmpty()) {
            permutationCount++;
            System.out.println(indent + "FOUND PERMUTATION: \"" + prefix + "\"");
            return;
        }
        
        System.out.println(indent + "Generating permutations for string: \"" + str + 
                         "\" with prefix: \"" + prefix + "\"");
        
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            String newPrefix = prefix + currentChar;
            String remaining = str.substring(0, i) + str.substring(i + 1);
            
            System.out.println(indent + "  Choose '" + currentChar + 
                             "', New prefix: \"" + newPrefix + 
                             "\", Remaining: \"" + remaining + "\"");
            
            printPermutationsWithTrace(remaining, newPrefix, depth + 1);
        }
    }
}
