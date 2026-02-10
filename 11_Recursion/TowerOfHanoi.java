public class TowerOfHanoi {
    static int moveCount = 0;
    
    public static void main(String[] args) {
        System.out.println("=== TOWER OF HANOI USING RECURSION ===\n");
        
        int[] disksList = {1, 2, 3, 4};
        
        for (int disks : disksList) {
            moveCount = 0;
            System.out.println("Solving Tower of Hanoi with " + disks + " disks:");
            towerOfHanoi(disks, 'A', 'C', 'B', 0);
            System.out.println("Total moves required: " + moveCount);
            System.out.println("-------------------\n");
        }
    }
    
    static void towerOfHanoi(int n, char fromRod, char toRod, char auxRod, int depth) {
        String indent = "  ".repeat(depth);
        
        if (n == 1) {
            moveCount++;
            System.out.println(indent + "Move disk 1 from rod " + fromRod + " to rod " + toRod);
            return;
        }
        
        System.out.println(indent + "To move " + n + " disks from " + fromRod + " to " + toRod + ":");
        
        
        System.out.println(indent + "1. First move top " + (n-1) + " disks from " + 
                         fromRod + " to " + auxRod + ":");
        towerOfHanoi(n - 1, fromRod, auxRod, toRod, depth + 1);
        
        
        moveCount++;
        System.out.println(indent + "2. Move disk " + n + " from " + fromRod + " to " + toRod);
        
        
        System.out.println(indent + "3. Now move " + (n-1) + " dsisks from " + 
                         auxRod + " to " + toRod + ":");
        towerOfHanoi(n - 1, auxRod, toRod, fromRod, depth + 1);
    }
}
