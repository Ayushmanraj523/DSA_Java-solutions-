//5. Remove All Whitespaces from a string

public class RemoveSpaces {
    public static void main(String[] args) {
        String str = "Java Programming Language";
        String result = "";
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') { // Skip spaces
                result += str.charAt(i);
            }
        }
        
        System.out.println("Original: " + str);
        System.out.println("Without spaces: " + result);
    }

}
