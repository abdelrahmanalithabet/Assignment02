package com.mycompany.assignment02;
import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Player> players;
    private int points;
    private int goalsFor;
    private int goalsAgainst;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
        this.points = 0;
        this.goalsFor = 0;
        this.goalsAgainst = 0;
    }

    public String getName() { return name; }
    public ArrayList<Player> getPlayers() { return players; }
    public int getPoints() { return points; }
    public int getGoalsFor() { return goalsFor; }
    public int getGoalsAgainst() { return goalsAgainst; }
    public int getGoalDifference() { return goalsFor - goalsAgainst; }

    public void addPlayer(Player player) { players.add(player); }
    public void addPoints(int pts) { this.points += pts; }
    public void addGoalsFor(int goals) { this.goalsFor += goals; }
    public void addGoalsAgainst(int goals) { this.goalsAgainst += goals; }

    public void resetStats() {
        this.points = 0;
        this.goalsFor = 0;
        this.goalsAgainst = 0;
    }
}
