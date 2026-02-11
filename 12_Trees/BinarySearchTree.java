class BSTNode {
    int data;
    BSTNode left;
    BSTNode right;
    
    BSTNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree {
    static BSTNode root = null;
    
    public static void main(String[] args) {
        System.out.println("=== BINARY SEARCH TREE OPERATIONS ===\n");
        
        
        int[] values = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 65, 75, 85};
        
        System.out.println("Inserting values: ");
        for (int val : values) {
            System.out.print(val + " ");
            root = insert(root, val);
        }
        
        System.out.println("\n\n=== TREE STRUCTURE ===");
        printTree(root, "", true);
        
        System.out.println("\n=== IN-ORDER TRAVERSAL (Sorted Order) ===");
        System.out.print("  ");
        inOrder(root);
        
        System.out.println("\n\n=== SEARCH OPERATIONS ===");
        searchTest(50);
        searchTest(40);
        searchTest(90);
        searchTest(25);
        
        System.out.println("\n=== DELETE OPERATIONS ===");
        System.out.println("1. Deleting leaf node (10):");
        root = delete(root, 10);
        inOrder(root);
        
        System.out.println("\n\n2. Deleting node with one child (20):");
        root = delete(root, 20);
        inOrder(root);
        
        System.out.println("\n\n3. Deleting node with two children (50 - root):");
        root = delete(root, 50);
        inOrder(root);
        
        System.out.println("\n\n=== FINAL TREE STRUCTURE ===");
        printTree(root, "", true);
    }
    
    
    static BSTNode insert(BSTNode node, int data) {
        if (node == null) {
            return new BSTNode(data);
        }
        
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }
        
        return node;
    }
    
    
    static boolean search(BSTNode node, int data) {
        if (node == null) return false;
        
        if (data == node.data) return true;
        else if (data < node.data) return search(node.left, data);
        else return search(node.right, data);
    }
    
    
    static BSTNode delete(BSTNode node, int data) {
        if (node == null) return null;
        
        if (data < node.data) {
            node.left = delete(node.left, data);
        } else if (data > node.data) {
            node.right = delete(node.right, data);
        } else {
    
            
            
            if (node.left == null && node.right == null) {
                return null;
            }
            
            else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            
            else {

                BSTNode successor = findMin(node.right);
                node.data = successor.data;
                node.right = delete(node.right, successor.data);
            }
        }
        return node;
    }
    
    static BSTNode findMin(BSTNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    
    static void inOrder(BSTNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    
    static void searchTest(int value) {
        boolean found = search(root, value);
        System.out.println("Search " + value + ": " + (found ? "Found ✓" : "Not Found ✗"));
    }

    static void printTree(BSTNode node, String prefix, boolean isLeft) {
        if (node == null) return;
        
        System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.data);
        
        if (node.left != null || node.right != null) {
            printTree(node.left, prefix + (isLeft ? "│   " : "    "), true);
            printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }
}
