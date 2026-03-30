//Class to represent an individual Alumnus record.

public class Alumni {
    private String name;
    private String sub1, sub2, sub3;
    private String currently;
    private String dob;
    private String phoneNumber;

    // Constructor to initialize data [cite: 25, 26]
    public Alumni(String name, String sub1, String sub2, String sub3, String currently, String dob, String phoneNumber) {
        this.name = name;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
        this.currently = currently;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
    }

    // Getter for searching by name [cite: 33]
    public String getName() {
        return name;
    }

    // Formatted output for viewing details [cite: 31]
    @Override
    public String toString() {
        return String.format("%-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-12s", 
            name, sub1, sub2, sub3, currently, dob, phoneNumber);
    }
}