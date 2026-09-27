public class Student {

    // Private fields - Encapsulation
    private int id;
    private String name;
    private int age;
    private String course;
    private double marks;


    // Constructor
    public Student(
            int id,
            String name,
            int age,
            String course,
            double marks) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
    }


    // =========================
    // GETTER AND SETTER FOR ID
    // =========================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    // =========================
    // GETTER AND SETTER FOR NAME
    // =========================

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // =========================
    // GETTER AND SETTER FOR AGE
    // =========================

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    // =========================
    // GETTER AND SETTER FOR COURSE
    // =========================

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }


    // =========================
    // GETTER AND SETTER FOR MARKS
    // =========================

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }


    // =========================
    // DISPLAY STUDENT
    // =========================

    public void displayStudent() {

        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
    }
}