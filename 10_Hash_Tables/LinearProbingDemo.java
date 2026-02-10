class HashTableLinearProbing {
    private String[] keys;
    private Integer[] values;
    private int capacity;
    private int size;
    
    public HashTableLinearProbing(int capacity) {
        this.capacity = capacity;
        keys = new String[capacity];
        values = new Integer[capacity];
        size = 0;
    }
    
    
    private int hash(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }
    
    
    public void put(String key, int value) {
        if (size == capacity) {
            System.out.println("Hash table is full!");
            return;
        }
        
        int index = hash(key);
        
        
        while (keys[index] != null && !keys[index].equals(key)) {
            index = (index + 1) % capacity;
            System.out.println("  Collision at index " + (index - 1 < 0 ? capacity - 1 : index - 1) + 
                             ", probing to index " + index);
        }
        
        if (keys[index] == null) {
            // New key
            keys[index] = key;
            values[index] = value;
            size++;
            System.out.println("Inserted: " + key + " = " + value + " at index " + index);
        } else {
            
            values[index] = value;
            System.out.println("Updated: " + key + " = " + value + " at index " + index);
        }
    }
    
    
    public Integer get(String key) {
        int index = hash(key);
        int originalIndex = index;
        
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return values[index];
            }
            index = (index + 1) % capacity;
            
            
            if (index == originalIndex) {
                break;
            }
        }
        return null;
    }
    
    
    public void printTable() {
        System.out.println("\n=== HASH TABLE (Linear Probing) ===");
        System.out.println("Size: " + size + "/" + capacity);
        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null) {
                System.out.println("Index " + i + ": [" + keys[i] + "=" + values[i] + "]");
            } else {
                System.out.println("Index " + i + ": [EMPTY]");
            }
        }
    }
}

public class LinearProbingDemo {
    public static void main(String[] args) {
        System.out.println("=== LINEAR PROBING HASH TABLE ===\n");
        HashTableLinearProbing ht = new HashTableLinearProbing(7);
        
        System.out.println("Inserting elements:");
        ht.put("apple", 10);
        ht.put("banana", 20);
        ht.put("cherry", 30);
        
        ht.printTable();
        
        System.out.println("\nCreating collision (apple and paple have same hash):");
        
        ht.put("apelp", 40); 
        ht.put("paple", 50); 
        
        ht.printTable();
        
        System.out.println("\nGetting values:");
        System.out.println("apple: " + ht.get("apple"));
        System.out.println("paple: " + ht.get("paple"));
        System.out.println("unknown: " + ht.get("unknown"));
        
        
        System.out.println("\nUpdating existing key:");
        ht.put("apple", 100);
        ht.printTable();
    }
}
