// 1. Node Class
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// 2. Logic Class
class MiddleLinkedList {
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

    // --- MAIN LOGIC: Fast & Slow Pointer ---
    void findMiddle() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node slow = head; // 1x Speed
        Node fast = head; // 2x Speed

        // Jab tak Fast end tak na pahunch jaye
        while (fast != null && fast.next != null) {
            slow = slow.next;       // 1 step
            fast = fast.next.next;  // 2 steps
        }

        System.out.println("Middle element: " + slow.data);
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
public class FindMiddle {
    public static void main(String[] args) {
        MiddleLinkedList list1 = new MiddleLinkedList();
        MiddleLinkedList list2 = new MiddleLinkedList();

        System.out.println("--- Odd Number of Nodes (5) ---");
        list1.insert(10);
        list1.insert(20);
        list1.insert(30);
        list1.insert(40);
        list1.insert(50);
        list1.printList();
        list1.findMiddle(); // Expected: 30

        System.out.println("\n--- Even Number of Nodes (6) ---");
        list2.insert(1);
        list2.insert(2);
        list2.insert(3);
        list2.insert(4);
        list2.insert(5);
        list2.insert(6);
        list2.printList();
        list2.findMiddle(); // Expected: 4 (Second middle)
    }
}