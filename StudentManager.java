import java.util.ArrayList;
import java.io.*;

public class StudentManager {

    // Collection to store students
    private ArrayList<Student> students = new ArrayList<>();

    // File name for storing student data
    private final String FILE_NAME = "students.txt";


    // =========================
    // ADD STUDENT
    // =========================
    public void addStudent(Student student) {

        // Check whether ID already exists
        if (studentIdExists(student.getId())) {
            System.out.println("Student ID already exists.");
            return;
        }

        students.add(student);

        saveToFile();

        System.out.println("Student added successfully.");
    }


    // =========================
    // VIEW STUDENTS
    // =========================
    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {

            student.displayStudent();

            System.out.println("............");
        }
    }


    // =========================
    // UPDATE STUDENT
    // =========================
    public void updateStudent(
            int id,
            String name,
            int age,
            String course,
            double marks) {

        for (Student student : students) {

            if (student.getId() == id) {

                student.setName(name);
                student.setAge(age);
                student.setCourse(course);
                student.setMarks(marks);

                saveToFile();

                System.out.println("Student updated successfully.");

                return;
            }
        }

        System.out.println("Student not found.");
    }


    // =========================
    // DELETE STUDENT
    // =========================
    public void deleteStudent(int id) {

        boolean removed =
                students.removeIf(student -> student.getId() == id);

        if (removed) {

            saveToFile();

            System.out.println("Student deleted successfully.");

        } else {

            System.out.println("Student not found.");
        }
    }


    // =========================
    // CHECK DUPLICATE ID
    // =========================
    public boolean studentIdExists(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return true;
            }
        }

        return false;
    }


    // =========================
    // SAVE TO FILE
    // =========================
    private void saveToFile() {

        try {

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(FILE_NAME)
                    );

            for (Student student : students) {

                writer.write(
                        student.getId() + "|" +
                        student.getName() + "|" +
                        student.getAge() + "|" +
                        student.getCourse() + "|" +
                        student.getMarks()
                );

                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {

            System.out.println("Error saving students.");
        }
    }


    // =========================
    // LOAD FROM FILE
    // =========================
    public void loadFromFile() {

        File file = new File(FILE_NAME);

        // If file doesn't exist, simply return
        if (!file.exists()) {
            return;
        }

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(FILE_NAME)
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String course = data[3];
                double marks = Double.parseDouble(data[4]);

                Student student =
                        new Student(
                                id,
                                name,
                                age,
                                course,
                                marks
                        );

                students.add(student);
            }

            reader.close();

        } catch (IOException e) {

            System.out.println("Error loading students.");

        } catch (NumberFormatException e) {

            System.out.println("Invalid student data in file.");
        }
    }
}