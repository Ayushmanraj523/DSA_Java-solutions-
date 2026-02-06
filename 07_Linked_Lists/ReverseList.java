// Node Class
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Linked List Operations Class
class ReverseLinkedList {
    Node head;
    
    // Function to insert data
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
    
    // Function to reverse the list
    void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next; // Store next node
            current.next = prev; // Reverse current node's pointer
            prev = current;      // Move prev one step forward
            current = next;      // Move current one step forward
        }
        head = prev; // Update head to the last node
    }
    
    // Function to print the list
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

// Main Class
public class ReverseList {
    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        
        // Create list
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
    }
}