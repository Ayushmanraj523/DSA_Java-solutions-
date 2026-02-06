// Node class (Dabba jisme data aur next pointer hota hai)
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Main Class
public class LinkedListBasics {
    public static void main(String[] args) {
        // 1. Nodes banana (Dabbe create karna)
        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        // 2. Link karna (Dabbo ko zanjeer se jodna)
        head.next = second;     // 10 -> 20
        second.next = third;    // 20 -> 30
        third.next = fourth;    // 30 -> 40

        // 3. Print karna (Linked List traverse karna)
        System.out.print("Linked List: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("NULL");

        // 4. Count karna
        int count = 0;
        current = head; // Wapas start par aao
        while (current != null) {
            count++;
            current = current.next;
        }
        System.out.println("Number of nodes: " + count);
    }
}