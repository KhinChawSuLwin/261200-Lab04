public class HealthRecord {
    // Instance field
    private int height;  // person's height in centimeters

    // Constants (static final)
    private static final int MIN_PERMITTED_HEIGHT = 30;
    private static final int MAX_PERMITTED_HEIGHT = 275;
    private static final int DEFAULT_HEIGHT = 165;

    // Class-level tracking (static)
    private static int tallestHeight = MIN_PERMITTED_HEIGHT;
    private static int shortestHeight = MAX_PERMITTED_HEIGHT;

    private static int counter = 0;
    private static double averageHeight = 0;


    // Constructor
    public HealthRecord(int height) {
        counter++;   //update number of patient
        setHeight(height);
    }

    // Getter for instance height
    public int getHeight() {
        return this.height;
    }

    // Setter with validation and statistic tracking
    public void setHeight(int height) {
        boolean isValid = false;

        // Validate height is within permitted range
        if (height >= MIN_PERMITTED_HEIGHT && height <= MAX_PERMITTED_HEIGHT) {
            this.height = height;
            isValid = true;
        } else {
            this.height = DEFAULT_HEIGHT;
        }

        // Update tallest and shortest heights only if input was valid
        if (isValid) {
            if (this.height > tallestHeight) {
                tallestHeight = this.height;
            }
            if (this.height < shortestHeight) {
                shortestHeight = this.height;
            }
        }

        averageHeight = ((averageHeight * (counter - 1)) + this.height) / counter;
    }

    // Getter for tallest height
    public static int getTallestHeight() {
        return tallestHeight;
    }

    // Getter for shortest height
    public static int getShortestHeight() {
        return shortestHeight;
    }

    // Getter for average height
    public static double getAverageHeight() {
        return averageHeight;
    }

    // Display individual patient's details
    public void displayDetails() {
        System.out.println("Height (cm): " + getHeight());
    }

    // Display global class statistics
    public static void displayClassDetails() {
        System.out.println("The tallest height (cm): " + getTallestHeight());
        System.out.println("The shortest height (cm): " + getShortestHeight());
        System.out.println("The average height(cm): " + getAverageHeight());
    }
}