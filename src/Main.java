public class Main {
    public static void main(String[] args) {
        // Create and test student records
        HealthRecord student1 = new HealthRecord(120);
        HealthRecord student2 = new HealthRecord(55);
        HealthRecord student3 = new HealthRecord(280);

        // Display individual records
        student1.displayDetails(); // Expected: 120
        student2.displayDetails(); // Expected: 55
        student3.displayDetails(); // Expected: 165 (default, as 280 is invalid)

        System.out.println(); // Space for cleaner output

        // Display class statistics
        HealthRecord.displayClassDetails(); // Expected: tallest=120, shortest=55
    }
}