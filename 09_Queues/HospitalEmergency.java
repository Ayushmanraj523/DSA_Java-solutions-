import java.util.PriorityQueue;

class Patient implements Comparable<Patient> {
    String name;
    int severity; 
    int arrivalTime;
    
    public Patient(String name, int severity, int arrivalTime) {
        this.name = name;
        this.severity = severity;
        this.arrivalTime = arrivalTime;
    }
    
    @Override
    public int compareTo(Patient other) {
        
        if (this.severity != other.severity) {
            return this.severity - other.severity;
        }
        
        return this.arrivalTime - other.arrivalTime;
    }
    
    @Override
    public String toString() {
        String condition;
        switch(severity) {
            case 1: condition = "Critical"; break;
            case 2: condition = "Serious"; break;
            case 3: condition = "Stable"; break;
            default: condition = "Unknown";
        }
        return name + " (" + condition + ")";
    }
}

public class HospitalEmergency {
    public static void main(String[] args) {
        System.out.println("=== HOSPITAL EMERGENCY ROOM SIMULATION ===\n");
        
        PriorityQueue<Patient> emergencyQueue = new PriorityQueue<>();
        
        
        System.out.println("Patients arriving at emergency:");
        emergencyQueue.add(new Patient("Rahul", 2, 1));  // Serious, arrived 1st
        emergencyQueue.add(new Patient("Priya", 1, 2));  // Critical, arrived 2nd
        emergencyQueue.add(new Patient("Amit", 3, 3));   // Stable, arrived 3rd
        emergencyQueue.add(new Patient("Sonia", 1, 4));  // Critical, arrived 4th
        emergencyQueue.add(new Patient("Ravi", 2, 5));   // Serious, arrived 5th
        
        System.out.println("1. Rahul - Serious");
        System.out.println("2. Priya - Critical");
        System.out.println("3. Amit - Stable");
        System.out.println("4. Sonia - Critical");
        System.out.println("5. Ravi - Serious");
        
        System.out.println("\n=== TREATMENT ORDER (Priority Based) ===\n");
        int treatmentNumber = 1;
        
        while (!emergencyQueue.isEmpty()) {
            Patient patient = emergencyQueue.poll();
            System.out.println(treatmentNumber + ". Treating: " + patient);
            treatmentNumber++;
        }
        
        System.out.println("\n=== ANOTHER SCENARIO ===\n");
        
        
        PriorityQueue<Patient> queue2 = new PriorityQueue<>();
        
        queue2.add(new Patient("Patient A", 2, 3));  
        queue2.add(new Patient("Patient B", 2, 1));  
        queue2.add(new Patient("Patient C", 2, 2));  
        
        System.out.println("Patients with same severity (Serious):");
        System.out.println("Patient A - Arrived 3rd");
        System.out.println("Patient B - Arrived 1st");
        System.out.println("Patient C - Arrived 2nd");
        
        System.out.println("\nTreatment order (by arrival time):");
        int counter = 1;
        while (!queue2.isEmpty()) {
            System.out.println(counter + ". " + queue2.poll());
            counter++;
        }
    }
}
