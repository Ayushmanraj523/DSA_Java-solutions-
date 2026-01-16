//3. Search in String Array
//Concept: Searching in non-numeric data

public class StringSearch {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve"};
        String target = "David";
        boolean found = false;
        
        // Linear search for string
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(target)) {
                System.out.println("Found '" + target + "' at position: " + (i + 1));
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Name not found in list");
        }
        
        // Search for names starting with specific letter
        char searchLetter = 'C';
        System.out.print("Names starting with '" + searchLetter + "': ");
        for (String name : names) {
            if (name.charAt(0) == searchLetter) {
                System.out.print(name + " ");
            }
        }
    }

}
