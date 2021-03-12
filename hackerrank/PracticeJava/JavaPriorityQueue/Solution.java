package hackerrank.PracticeJava.JavaPriorityQueue;

import java.util.*;

class Priorities {

    public List<Student> getStudents(List<String> events) {
        Queue<Student> students = new PriorityQueue<>(Comparator.comparing(Student::getCGPA).reversed()
                .thenComparing(Student::getName)
                .thenComparing(Student::getID));
        List<Student> results = new LinkedList<>();

        for (int i = 0; i < events.size(); i++) {
            String[] event = events.get(i).replace(',', '.').split(" ");

            if ("ENTER".equals(event[0])) {
                Student student = new Student(Integer.parseInt(event[3]), event[1], Double.parseDouble(event[2]));
                students.add(student);
            } else if ("SERVED".equals(event[0])) {
                students.poll();
            }
        }

        while (!students.isEmpty()) {
            results.add(students.poll());
        }

        return results;
    }
}

class Student {
    int id;
    String name;
    double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cgpa=" + cgpa +
                '}';
    }
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}