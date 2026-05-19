// https://www.hackerrank.com/challenges/java-sort/problem?isFullScreen=true

import java.util.*;

class Student {
    public int id;
    public String name;
    public double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
}

class CheckStudent implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        int compareCGPA = Double.compare(a.cgpa, b.cgpa);
        if (compareCGPA != 0) {
            return -compareCGPA;
        }
        int compareName = a.name.compareTo(b.name);
        if (compareName!= 0) {
            return compareName;
        }
        return Integer.compare(a.id, b.id); 
    }
}

public class Solution_12 {

    static void sortStudent(ArrayList<Student> students) {
        CheckStudent checker = new CheckStudent();
        students.sort(checker);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split(" ");
            int id = Integer.parseInt(tokens[0]);
            String name = tokens[1];
            double cgpa = Double.parseDouble(tokens[2]);
            students.add(new Student(id, name, cgpa));
        }
        sortStudent(students);
        for (Student student: students) {
            System.out.println(student.name);
        }
    }
}
