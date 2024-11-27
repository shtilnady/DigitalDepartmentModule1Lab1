import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Student inputStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name: ");
        String name = scanner.next();
        System.out.println("Enter the course: ");
        int course = scanner.nextInt();
        System.out.println("Enter the group: ");
        String group = scanner.next();
        System.out.println("Enter number of subjects: ");
        int number = scanner.nextInt();
        Student student = new Student(name, group, course);
        String subject;
        int mark;
        for (int i = 0; i < number; i++) {
            System.out.println("Enter subject: ");
            subject = scanner.next();
            System.out.println("Enter mark: ");
            mark = scanner.nextInt();
            student.setMark(subject, mark);
        }
        return student;
    }

    public static void promotion(List<Student> students) {
        int i = 0;
        Student student;
        while (i < students.size()) {
            student = students.get(i);
            if (student.getAverageMark() < 3) {
                students.remove(student);
            }
            else {
                student.setCourse(student.getCourse() + 1);
                i++;
            }
        }
    }

    public static void printStudentsOfTheCourse(List<Student> students, int course) {
        int number = 0;
        for (Student student: students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
                number++;
            }
        }
        if (number == 0) {
            System.out.println("No students on the course.");
        }
    }

    public static void printAll(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students.");
            return;
        }
        Student student;
        for (int i = 0; i < students.size(); i++) {
            student = students.get(i);
            System.out.println( i + 1 + ". " + student.getName());
            System.out.println("Course: " + student.getCourse());
            System.out.println("Group: " + student.getGroup());
            System.out.println("Marks: " + student.getMarks());
        }
    }

    public static void addMark(List<Student> students) {
        Scanner scanner = new Scanner(System.in);
        int number, mark;
        String subject;
        printAll(students);
        System.out.println("Select student (enter number): ");
        number = scanner.nextInt();
        System.out.println("Enter the name of the discipline: ");
        subject = scanner.next();
        System.out.println("Enter the mark: ");
        mark = scanner.nextInt();
        students.get(number - 1).setMark(subject, mark);
    }

    public static void changeGroup(List<Student> students) {
        Scanner scanner = new Scanner(System.in);
        int number;
        String group;
        printAll(students);
        System.out.println("Select student (enter number): ");
        number = scanner.nextInt();
        System.out.println("Enter new group: ");
        group = scanner.next();
        students.get(number - 1).setGroup(group);
    }

    public static void menu() {
        System.out.println("Menu:");
        System.out.println("1. Add student.");
        System.out.println("2. Remove Student.");
        System.out.println("3. Change student's group.");
        System.out.println("4. Add/change student's mark.");
        System.out.println("5. Expel or transfer to the next course.");
        System.out.println("6. Print students of the course.");
        System.out.println("7. Print all students.");
        System.out.println("8. Finish program.");
        System.out.println("Input number of command: ");
    }

    public static void main(String[] args) {
        boolean flag = true;
        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int command, number;
        Student student;
        while (flag) {
            menu();
            command = scanner.nextInt();
            switch (command) {
                case 1:
                    student = inputStudent();
                    students.add(student);
                    break;
                case 2:
                    printAll(students);
                    System.out.println("Select student (enter number): ");
                    number = scanner.nextInt();
                    students.remove(number - 1);
                    break;
                case 3:
                    changeGroup(students);
                    break;
                case 4:
                    addMark(students);
                    break;
                case 5:
                    promotion(students);
                    break;
                case 6:
                    System.out.println("Input number of course: ");
                    number = scanner.nextInt();
                    printStudentsOfTheCourse(students, number);
                    break;
                case 7:
                    printAll(students);
                    break;
                case 8:
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong command, try again.");
            }
        }
    }
}