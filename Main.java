import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        // Load existing students from file
        manager.loadFromFile();

        int choice;

        do {

            System.out.println("\n================================");
            System.out.println("   Student Management System");
            System.out.println("================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.println("================================");

            System.out.print("Enter your choice: ");

            // Validate menu choice
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a number.");
                scanner.next();
                System.out.print("Enter your choice: ");
            }

            choice = scanner.nextInt();
            scanner.nextLine();


            // =========================
            // ADD STUDENT
            // =========================
            switch (choice) {

                case 1:

                    System.out.println("\n--- Add Student ---");

                    // Student ID
                    System.out.print("Enter student ID: ");

                    while (!scanner.hasNextInt()) {
                        System.out.println("Student ID must be a number.");
                        scanner.next();
                        System.out.print("Enter student ID: ");
                    }

                    int id = scanner.nextInt();
                    scanner.nextLine();

                    // Duplicate ID check
                    if (manager.studentIdExists(id)) {
                        System.out.println("Student ID already exists.");
                        break;
                    }


                    // Student name
                    String name;

                    do {
                        System.out.print("Enter student name: ");
                        name = scanner.nextLine();

                        if (name.trim().isEmpty()) {
                            System.out.println("Name cannot be empty.");
                        }

                    } while (name.trim().isEmpty());


                    // Age
                    System.out.print("Enter student age: ");

                    while (!scanner.hasNextInt()) {
                        System.out.println("Age must be a number.");
                        scanner.next();
                        System.out.print("Enter student age: ");
                    }

                    int age = scanner.nextInt();
                    scanner.nextLine();


                    // Course
                    String course;

                    do {
                        System.out.print("Enter course: ");
                        course = scanner.nextLine();

                        if (course.trim().isEmpty()) {
                            System.out.println("Course cannot be empty.");
                        }

                    } while (course.trim().isEmpty());


                    // Marks
                    System.out.print("Enter marks: ");

                    while (!scanner.hasNextDouble()) {
                        System.out.println("Marks must be a number.");
                        scanner.next();
                        System.out.print("Enter marks: ");
                    }

                    double marks = scanner.nextDouble();
                    scanner.nextLine();


                    // Check marks
                    if (marks < 0 || marks > 100) {
                        System.out.println("Marks must be between 0 and 100.");
                        break;
                    }


                    // Create Student object
                    Student student =
                            new Student(
                                    id,
                                    name,
                                    age,
                                    course,
                                    marks
                            );


                    // Add student
                    manager.addStudent(student);

                    break;


                // =========================
                // VIEW STUDENTS
                // =========================
                case 2:

                    System.out.println("\n--- Student List ---");

                    manager.viewStudents();

                    break;


                // =========================
                // UPDATE STUDENT
                // =========================
                case 3:

                    System.out.println("\n--- Update Student ---");

                    System.out.print("Enter student ID to update: ");

                    while (!scanner.hasNextInt()) {
                        System.out.println("Student ID must be a number.");
                        scanner.next();
                        System.out.print("Enter student ID to update: ");
                    }

                    int updateId = scanner.nextInt();
                    scanner.nextLine();


                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();


                    System.out.print("Enter new age: ");

                    while (!scanner.hasNextInt()) {
                        System.out.println("Age must be a number.");
                        scanner.next();
                        System.out.print("Enter new age: ");
                    }

                    int newAge = scanner.nextInt();
                    scanner.nextLine();


                    System.out.print("Enter new course: ");
                    String newCourse = scanner.nextLine();


                    System.out.print("Enter new marks: ");

                    while (!scanner.hasNextDouble()) {
                        System.out.println("Marks must be a number.");
                        scanner.next();
                        System.out.print("Enter new marks: ");
                    }

                    double newMarks = scanner.nextDouble();
                    scanner.nextLine();


                    if (newMarks < 0 || newMarks > 100) {
                        System.out.println("Marks must be between 0 and 100.");
                        break;
                    }


                    manager.updateStudent(
                            updateId,
                            newName,
                            newAge,
                            newCourse,
                            newMarks
                    );

                    break;


                // =========================
                // DELETE STUDENT
                // =========================
                case 4:

                    System.out.println("\n--- Delete Student ---");

                    System.out.print("Enter student ID to delete: ");

                    while (!scanner.hasNextInt()) {
                        System.out.println("Student ID must be a number.");
                        scanner.next();
                        System.out.print("Enter student ID to delete: ");
                    }

                    int deleteId = scanner.nextInt();
                    scanner.nextLine();


                    manager.deleteStudent(deleteId);

                    break;


                // =========================
                // EXIT
                // =========================
                case 5:

                    System.out.println("Application closed.");

                    break;


                // =========================
                // INVALID CHOICE
                // =========================
                default:

                    System.out.println(
                            "Invalid choice. Please select 1 to 5."
                    );
            }

        } while (choice != 5);


        scanner.close();
    }
}