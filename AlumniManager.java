import java.util.ArrayList;
import java.util.Scanner;

public class AlumniManager {
    // Lists to simulate the DataFrames for specific sessions 
    private static ArrayList<Alumni> session1819 = new ArrayList<>();
    private static ArrayList<Alumni> session1920 = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Load Sample Data into the lists [cite: 54, 55, 64]
        loadSampleData();

        while (true) {
            // Main Menu [cite: 41, 130]
            System.out.println("\nWELCOME TO ALUMNI MANAGEMENT SYSTEM");
            System.out.println("ENTER 1 : TO REGISTER ALUMNI");
            System.out.println("ENTER 2 : TO VIEW ALUMNI DETAILS");
            System.out.println("ENTER 3 : TO SEARCH ALUMNI");
            System.out.println("ENTER 4 : TO DELETE ALUMNI");
            System.out.println("ENTER 5 : TO EXIT");
            System.out.print("PLEASE ENTER YOUR CHOICE (1/2/3/4/5): ");
            
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": registerAlumni(); break; // [cite: 24, 131]
                case "2": viewAlumni(); break;     // [cite: 29, 132]
                case "3": searchAlumni(); break;   // [cite: 32, 133]
                case "4": deleteAlumni(); break;   // [cite: 35, 134]
                case "5": 
                    System.out.println("*EXITING ALUMNI MANAGEMENT SYSTEM*"); // [cite: 149]
                    return;
                default: 
                    System.out.println("INVALID CHOICE"); // [cite: 152]
            }
        }
    }

    private static void loadSampleData() {
        // Data for Session 2018-2019 [cite: 55, 59]
        session1819.add(new Alumni("ANJALI", "MATHS", "PHYSICS", "CHEMISTRY", "AT VIT", "2003-02-01", "2345678901"));
        session1819.add(new Alumni("HRITIK", "BIOLOGY", "PHYSICS", "CHEMISTRY", "AT JNU", "2003-03-04", "4323986543"));
        
        // Data for Session 2019-2020 [cite: 64, 68]
        session1920.add(new Alumni("ANJU", "HISTORY", "HISTORY", "HINDI", "AT DU", "2004-07-04", "2345678561"));
        session1920.add(new Alumni("TANYA", "BIOLOGY", "PHYSICS", "CHEMISTRY", "AT JNU", "2004-05-09", "4390986543"));
    }

    // Logic for registering a new Alumnus [cite: 24, 73]
    private static void registerAlumni() {
        System.out.print("ENTER SESSION (2018-2019/2019-2020): "); // [cite: 77]
        String s = scanner.nextLine();
        System.out.print("ENTER NAME: "); // [cite: 78]
        String name = scanner.nextLine();
        System.out.print("ENTER SUBJECT1: "); // [cite: 79]
        String s1 = scanner.nextLine();
        System.out.print("ENTER SUBJECT2: "); // [cite: 80]
        String s2 = scanner.nextLine();
        System.out.print("ENTER SUBJECT3: "); // [cite: 81]
        String s3 = scanner.nextLine();
        System.out.print("ENTER DOB: "); // [cite: 82]
        String dob = scanner.nextLine();
        System.out.print("ENTER CURRENTLY WORKING AT: "); // [cite: 83]
        String work = scanner.nextLine();
        System.out.print("ENTER PHONE NUMBER: "); // [cite: 84]
        String phone = scanner.nextLine();

        Alumni newEntry = new Alumni(name, s1, s2, s3, work, dob, phone);

        if (s.equals("2018-2019")) {
            session1819.add(newEntry);
            System.out.println("Updated List for 2018-2019:");
            for(Alumni a : session1819) System.out.println(a);
        } else if (s.equals("2019-2020")) {
            session1920.add(newEntry);
            System.out.println("Updated List for 2019-2020:");
            for(Alumni a : session1920) System.out.println(a);
        }
    }

    // Logic for viewing session records [cite: 29, 93]
    private static void viewAlumni() {
        System.out.print("ENTER SESSION: "); // [cite: 95]
        String s = scanner.nextLine();
        ArrayList<Alumni> list = s.equals("2018-2019") ? session1819 : session1920;
        
        System.out.println("\nNAME       | SUB1       | SUB2       | SUB3       | CURRENTLY  | DOB        | PHONE");
        for (Alumni a : list) {
            System.out.println(a); 
        }
    }

    
    private static void searchAlumni() {
        System.out.print("Name whose records are to be extracted: "); 
        String searchName = scanner.nextLine();
        System.out.print("ENTER SESSION: "); 
        String s = scanner.nextLine();
        ArrayList<Alumni> list = s.equals("2018-2019") ? session1819 : session1920;

        boolean found = false;
        for (Alumni a : list) {
            if (a.getName().equalsIgnoreCase(searchName)) { // [cite: 105, 108]
                System.out.println(a);
                found = true;
            }
        }
        if (!found) System.out.println("No records found.");
    }

    // Logic for deleting a record [cite: 35, 110]
    private static void deleteAlumni() {
        System.out.print("Name whose records are to be DELETED: "); // [cite: 112]
        String delName = scanner.nextLine();
        System.out.print("SESSION: "); // [cite: 113]
        String s = scanner.nextLine();
        ArrayList<Alumni> list = s.equals("2018-2019") ? session1819 : session1920;

        // Removes alumni if name matches [cite: 115, 118]
        list.removeIf(a -> a.getName().equalsIgnoreCase(delName));
        System.out.println("Record deleted if it existed. Current list:");
        for(Alumni a : list) System.out.println(a);
    }
}