
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// 2. Helper Class (Operations)
class DeleteLinkedList {
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
    
    // Delete by Value function
    void deleteByValue(int key) {
        Node temp = head, prev = null;
        
        // Case 1: Agar Head node hi delete karna ho
        if (temp != null && temp.data == key) {
            head = temp.next;
            System.out.println("Deleted head node with value " + key);
            return;
        }
        
        // Case 2: Key ko search karo
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
        
        // Case 3: Agar key nahi mili
        if (temp == null) {
            System.out.println("Value " + key + " not found in list");
            return;
        }
        
        // Case 4: Node ko list se alag (unlink) karo
        prev.next = temp.next;
        System.out.println("Deleted node with value " + key);
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

// 3. Main Class (Run yahan se hoga)
public class DeleteOperations {
    public static void main(String[] args) {
        DeleteLinkedList list = new DeleteLinkedList();
        
        // Create list: 10 -> 20 -> 30 -> 40 -> 50
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        
        System.out.println("Original list:");
        list.printList();
        
        System.out.println("\nDeleting 30:");
        list.deleteByValue(30);
        list.printList();
        
        System.out.println("\nDeleting 10 (head):");
        list.deleteByValue(10);
        list.printList();
        
        System.out.println("\nTrying to delete 100 (not in list):");
        list.deleteByValue(100);
        list.printList();
        
        System.out.println("\nDeleting 50 (end):");
        list.deleteByValue(50);
        list.printList();
    }
}