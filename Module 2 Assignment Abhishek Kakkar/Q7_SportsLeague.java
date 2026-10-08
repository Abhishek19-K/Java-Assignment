import java.util.Scanner;

abstract class Team {
    protected String name;
    protected int matchesPlayed, wins, draws;

    public Team(String name, int matchesPlayed, int wins, int draws) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.wins = wins;
        this.draws = draws;
    }

    public abstract int calculatePoints();
}

class CricketTeam extends Team {
    public CricketTeam(String name, int matchesPlayed, int wins, int draws) {
        super(name, matchesPlayed, wins, draws);
    }

    public int calculatePoints() {
        return wins * 2 + draws;
    }
}

class FootballTeam extends Team {
    public FootballTeam(String name, int matchesPlayed, int wins, int draws) {
        super(name, matchesPlayed, wins, draws);
    }

    public int calculatePoints() {
        return wins * 3 + draws;
    }
}

public class Q7_SportsLeague {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] p = line.split(",");
            String sport = p[0].trim();
            String name = p[1].trim();
            int matches = Integer.parseInt(p[2].trim());
            int wins = Integer.parseInt(p[3].trim());
            int draws = Integer.parseInt(p[4].trim());

            Team team = sport.equalsIgnoreCase("Cricket")
                    ? new CricketTeam(name, matches, wins, draws)
                    : new FootballTeam(name, matches, wins, draws);

            System.out.println("Team: " + name + " (" + sport + ") Points: "
                    + team.calculatePoints());
        }

        sc.close();
    }
}
