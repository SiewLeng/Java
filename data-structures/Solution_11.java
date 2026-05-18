// https://www.hackerrank.com/challenges/java-comparator/problem?isFullScreen=true

import java.util.*;

class Player {
    public String name;
    public int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    @Override
    public String toString() {
        return this.name + " " + this.score;
    }
}

class Checker implements Comparator<Player> {

    @Override
    public int compare(Player a, Player b) {
        if (a.score > b.score) {
            return -1;
        }
        if (a.score == b.score) {
                return a.name.compareTo(b.name);
        }
        return 1;
    }
}

public class Solution_11 {

    static void sortPlayer(ArrayList<Player> arr) {
        Checker checker = new Checker();
        arr.sort((a, b) -> {
            return checker.compare(a, b);
        });
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] tokens = s.split(" ");
            players.add(new Player(tokens[0], Integer.parseInt(tokens[1])));
        }
        sortPlayer(players);
        sortPlayer(players);
        for (Player p: players) {
            System.out.println(p);
        }
        sc.close();
    }
}