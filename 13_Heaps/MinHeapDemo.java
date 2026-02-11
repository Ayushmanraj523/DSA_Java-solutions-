
class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;
    
    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    private int parent(int i) { return (i - 1) / 2; }
    
    private int leftChild(int i) { return 2 * i + 1; }
    
    private int rightChild(int i) { return 2 * i + 2; }
    
    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full! Cannot insert " + value);
            return;
        }
        
        heap[size] = value;
        size++;
        
        heapifyUp(size - 1);
        System.out.println("Inserted: " + value);
    }
    
    private void heapifyUp(int i) {
        while (i > 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }
    
    
    public int extractMin() {
        if (size <= 0) {
            System.out.println("Heap is empty!");
            return -1;
        }
        
        if (size == 1) {
            size--;
            return heap[0];
        }
        
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        
        heapifyDown(0);
        
        System.out.println("Extracted minimum: " + root);
        return root;
    }
    
    private void heapifyDown(int i) {
        int smallest = i;
        int left = leftChild(i);
        int right = rightChild(i);
        
        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }
        
        if (smallest != i) {
            swap(i, smallest);
            heapifyDown(smallest);
        }
    }
    
    public int getMin() {
        if (size == 0) {
            System.out.println("Heap is empty!");
            return -1;
        }
        return heap[0];
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    

    public void printHeap() {
        System.out.print("Heap array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
    
    public void printHeapTree() {
        System.out.println("\nHeap as tree (parent <= children):");
        printTree(0, "", true);
    }
    
    private void printTree(int i, String prefix, boolean isLeft) {
        if (i >= size) return;
        
        System.out.println(prefix + (isLeft ? "├── " : "└── ") + heap[i]);
        
        if (leftChild(i) < size || rightChild(i) < size) {
            printTree(leftChild(i), prefix + (isLeft ? "│   " : "    "), true);
            printTree(rightChild(i), prefix + (isLeft ? "│   " : "    "), false);
        }
    }
}


public class MinHeapDemo {
    public static void main(String[] args) {
        System.out.println("=== MIN-HEAP IMPLEMENTATION ===\n");
        
        MinHeap minHeap = new MinHeap(10);
        
        System.out.println("Inserting elements:");
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(5);
        minHeap.insert(30);
        minHeap.insert(1);
        minHeap.insert(15);
        
        minHeap.printHeap();
        minHeap.printHeapTree();
        
        System.out.println("\nCurrent minimum: " + minHeap.getMin());
        
        System.out.println("\nExtracting elements:");
        minHeap.extractMin();
        minHeap.printHeap();
        
        System.out.println("\nExtracting all elements:");
        while (minHeap.getMin() != -1) {
            minHeap.extractMin();
        }
    }
}