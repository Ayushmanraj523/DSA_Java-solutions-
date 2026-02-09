import java.util.LinkedList;

class HashTableChaining {
    private LinkedList<Entry>[] table;
    private int capacity;
    
    // Entry class to store key-value pairs
    class Entry {
        String key;
        int value;
        
        Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    public HashTableChaining(int capacity) {
        this.capacity = capacity;
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }
    
    // Hash function
    private int hash(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }
    
    // Insert key-value pair
    public void put(String key, int value) {
        int index = hash(key);
        LinkedList<Entry> bucket = table[index];
        
        // Check if key already exists
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update existing
                System.out.println("Updated: " + key + " = " + value);
                return;
            }
        }
        
        // Add new entry
        bucket.add(new Entry(key, value));
        System.out.println("Inserted: " + key + " = " + value + " at index " + index);
    }
    
    // Get value by key
    public Integer get(String key) {
        int index = hash(key);
        LinkedList<Entry> bucket = table[index];
        
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // Key not found
    }
    
    // Remove key-value pair
    public boolean remove(String key) {
        int index = hash(key);
        LinkedList<Entry> bucket = table[index];
        
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                System.out.println("Removed: " + key);
                return true;
            }
        }
        System.out.println("Key not found: " + key);
        return false;
    }
    
    // Print hash table
    public void printTable() {
        System.out.println("\n=== HASH TABLE (Chaining) ===");
        for (int i = 0; i < capacity; i++) {
            System.out.print("Index " + i + ": ");
            if (table[i].isEmpty()) {
                System.out.println("Empty");
            } else {
                for (Entry entry : table[i]) {
                    System.out.print("[" + entry.key + "=" + entry.value + "] → ");
                }
                System.out.println("NULL");
            }
        }
    }
}

public class HashTableDemo1 {
    public static void main(String[] args) {
        System.out.println("=== HASH TABLE WITH SEPARATE CHAINING ===\n");
        HashTableChaining ht = new HashTableChaining(5);
        
        // Insert key-value pairs
        System.out.println("Inserting elements:");
        ht.put("John", 25);
        ht.put("Alice", 30);
        ht.put("Bob", 35);
        ht.put("John", 26); // Update existing
        ht.put("Charlie", 40);
        
        ht.printTable();
        
        // Get values
        System.out.println("\nGetting values:");
        System.out.println("John's age: " + ht.get("John"));
        System.out.println("Alice's age: " + ht.get("Alice"));
        System.out.println("Unknown's age: " + ht.get("Unknown"));
        
        // Test collisions - keys with same hash
        System.out.println("\nTesting collisions:");
        ht.put("Diana", 28);
        ht.put("Eve", 32);
        ht.printTable();
        
        // Remove elements
        System.out.println("\nRemoving elements:");
        ht.remove("Alice");
        ht.remove("Unknown"); // Not in table
        ht.printTable();
    }
}
