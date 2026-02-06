// 1. Node Class (Ye missing tha!)
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// 2. Helper Class (Reverse Logic)
class ReverseLinkedList {
    Node head;
    
    // Insert function
    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }
    
    // --- MAIN LOGIC: Reverse Function ---
    void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next; // 1. Agla node pakad ke rakho
            current.next = prev; // 2. Current ka teer (pointer) piche ghuma do
            prev = current;      // 3. Prev ko aage badhao
            current = next;      // 4. Current ko aage badhao
        }
        head = prev; // Last node ab naya head ban gaya
    }
    
    // Print function
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

// 3. Main Class
public class ReverseList {
    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        
        // Create list: 1 -> 2 -> 3 -> 4 -> 5
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        
        System.out.println("Original list:");
        list.printList();
        
        System.out.println("\nReversing list...");
        list.reverse();
        
        System.out.println("Reversed list:");
        list.printList();
        
        System.out.println("\nReversing again (Back to original)...");
        list.reverse();
        
        System.out.println("Restored list:");
        list.printList();
    }
}