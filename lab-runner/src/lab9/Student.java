package lab9;

import java.util.Scanner;

public class Student {
    private int id;
    private String surname;
    private int course;
    private int group;

    public Student(int id, String surname, int course, int group) {
        this.id = id;
        this.surname = surname;
        this.course = course;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public int getCourse() {
        return course;
    }

    public int getGroup() {
        return group;
    }

    public static Student fromString(String s) {
        Scanner scanner = new Scanner(s);
        int id = scanner.nextInt();
        String surname = scanner.next();
        int course = scanner.nextInt();
        int group = scanner.nextInt();
        return new Student(id, surname, course, group);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", course=" + course +
                ", group=" + group +
                '}';
    }
}
