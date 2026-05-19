// https://www.hackerrank.com/challenges/java-priority-queue/problem?isFullScreen=true

import java.util.*;

class StudentForQueue {
    private final int id;
    private final String name;
    private final double cgpa;

    public StudentForQueue(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getCGPA()  {
        return this.cgpa;
    }
}

class CheckerForStudentQueue implements Comparator<StudentForQueue> {
    @Override
    public int compare(StudentForQueue a, StudentForQueue b) {
        int compareCGPA = Double.compare(a.getCGPA(), b.getCGPA());
        if (compareCGPA != 0) {
            return -compareCGPA;
        }
        int compareName = a.getName().compareTo(b.getName());
        if (compareName!= 0) {
            return compareName;
        }
        return Integer.compare(a.getID(), b.getID()); 
    }
}

public class Solution_15 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of testcases
        sc.nextLine();

        CheckerForStudentQueue checker = new CheckerForStudentQueue();
        Comparator<StudentForQueue> comparator = (a, b) -> {
            return checker.compare(a, b);
        };
        PriorityQueue<StudentForQueue> queue = new PriorityQueue<>(10, comparator);
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            if (input.compareTo("SERVED") == 0) {
                if (!queue.isEmpty()) {
                    queue.poll();
                }
            } else {
                String[] tokens = input.split(" ");
                if (tokens[0].compareTo("ENTER") == 0) {
                    String name = tokens[1];
                    double cgpa = Double.parseDouble(tokens[2]);
                    int id = Integer.parseInt(tokens[3]);
                    queue.add(new StudentForQueue(id, name, cgpa));
                }
            }
        }
        if (queue.isEmpty()) {
            System.out.println("EMPTY");
        }
        while (!queue.isEmpty()) {
            StudentForQueue s = queue.poll();
            System.out.println(s.getName());
        }
        sc.close();
    }
}
