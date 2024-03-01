import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // CRUD


        String[] students = new String[20];
        int count = 0;

        while (true) {
            System.out.println("""
                    1. Add student
                    2. Get all student
                    3. Update
                    4. Delete
                    """);
            switch (new Scanner(System.in).nextLine()) {
                case "1", "add" -> {
                    System.out.println("Write student name");
                    addStudent(students, new Scanner(System.in).nextLine(), count++);
                }
                case "2", "get" -> {
                    getAllStudent(students, count);
                }
                case "3", "update" -> {
                    updateStudent(students, new Scanner(System.in).nextLine(), new Scanner(System.in).nextLine(), count);
                }
                case "4", "delete" -> {
//                    deleteStudent(students, new Scanner(System.in).nextLine(), count);
                    String name = scanner.nextLine();
                    deleteStudent(students,name,count);
                }


            }
        }
    }

    // C - Create, add
    public static String addStudent(String[] students, String studentName, int index) {
        students[index] = studentName;
        return studentName + " succesfully added!!!";
    }

    // R - Read, get
    public static void getAllStudent(String[] students, int count) {

        for (int i = 0; i < count; i++) {
            if (students[i] != null) {
                System.out.println(students[i]);
            }

        }
    }

    // U - update
    public static void updateStudent(String[] students, String oldName, String newName, int count) {
        boolean isFound = false;
        for (int i = 0; i < count; i++) {
            if (students[i].equalsIgnoreCase(oldName)) {
                students[i] = newName;
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("Student with name: " + oldName + " is not found! ");
        } else {
            System.out.println(oldName + " renamed to " + newName);
        }
    }

    // D - delete,remove
    public static void deleteStudent(String[] students, String name, int count) {
        System.out.print("Введите номер заметки, которую хотите удалить: ");
        boolean isFound = false;
        for (int i = 0; i < count; i++) {
            if (students[i].equalsIgnoreCase(name)) {
                isFound = true;
                System.arraycopy(students, i + 1, students, i, count - i - 1);
                students[count - 1] = null;
                System.out.println("Student " + name + " successfully deleted!");
            }
        }
        if (!isFound) {
            System.out.println("Student with name: " + name + " is not found! ");

            }
        }
    }

//            for (int i = 0; i < count; i++) {
//            System.out.println(students[i]);

//        for (int i = 0; i < count; i++) {
//            if (students[i].equalsIgnoreCase(name)) {
//                students[i] = null;
//                for (int j = 0; j < count; j++) {
//                    System.out.println(students[i] + "  ushul student delete boldu");
//                }
//            }