class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeTraversals {
    public static void main(String[] args) {
        System.out.println("=== BINARY TREE TRAVERSALS ===\n");
        
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        
        System.out.println("Tree Structure:");
        System.out.println("        1");
        System.out.println("       / \\");
        System.out.println("      2   3");
        System.out.println("     / \\   \\");
        System.out.println("    4   5   6");
        System.out.println("         \\");
        System.out.println("          7");
        
        System.out.println("\n=== TRAVERSAL RESULTS ===");
        
        System.out.println("\n1. PRE-ORDER TRAVERSAL (Root → Left → Right):");
        System.out.print("   ");
        preOrder(root);
        
        System.out.println("\n\n2. IN-ORDER TRAVERSAL (Left → Root → Right):");
        System.out.print("   ");
        inOrder(root);
        
        System.out.println("\n\n3. POST-ORDER TRAVERSAL (Left → Right → Root):");
        System.out.print("   ");
        postOrder(root);
        
        System.out.println("\n\n4. LEVEL ORDER TRAVERSAL (Breadth First):");
        System.out.print("   ");
        levelOrder(root);
        
        System.out.println("\n\n=== TRAVERSAL WITH TRACE ===");
        System.out.println("\nIn-order traversal with trace:");
        inOrderWithTrace(root, 0);
    }
    
    
    static void preOrder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    
    
    static void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    
    
    static void postOrder(TreeNode node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }
    
    
    static void levelOrder(TreeNode root) {
        if (root == null) return;
        
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.data + " ");
            
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
    

    static void inOrderWithTrace(TreeNode node, int depth) {
        if (node == null) return;
        
        inOrderWithTrace(node.left, depth + 1);
        
        String indent = "  ".repeat(depth);
        System.out.println(indent + "Visiting: " + node.data);
        
        inOrderWithTrace(node.right, depth + 1);
    }
}
