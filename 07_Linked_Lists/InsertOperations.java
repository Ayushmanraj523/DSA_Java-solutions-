// 1. Node Class (Data rakhne wala dabba)
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// 2. Main Class (File ke naam se match honi chahiye)
public class InsertOperations {
    Node head; // Linked List ka starting point

    // --- Operation 1: Insert at Start ---
    public void insertAtStart(int data) {
        Node newNode = new Node(data);
        newNode.next = head; // Naye node ko purane head se jodo
        head = newNode;      // Head ko update karke naye node par lao
    }

    // --- Operation 2: Insert at End ---
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        // Agar list khali hai, toh yahi pehla node banega
        if (head == null) {
            head = newNode;
            return;
        }

        // Last node tak chal kar jao
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        
        // Last node ke aage naya node jod do
        temp.next = newNode;
    }

    // --- Print karne ka function ---
    public void printList() {
        Node temp = head;
        System.out.print("Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // --- Main Method (Run karne ke liye) ---
    public static void main(String[] args) {
        InsertOperations list = new InsertOperations();

        // Testing Insert at End
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        
        // Testing Insert at Start (40 sabse aage aana chahiye)
        list.insertAtStart(40); 

        list.printList(); // Output: 40 -> 10 -> 20 -> 30 -> NULL
    }
}