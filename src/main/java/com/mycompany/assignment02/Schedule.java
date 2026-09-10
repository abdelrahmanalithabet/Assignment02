package com.mycompany.assignment02;
import java.util.ArrayList;

public class Schedule {
    private ArrayList<Team> teams;
    private ArrayList<Assignment02> matches;

    public Schedule() {
        this.teams = new ArrayList<>();
        this.matches = new ArrayList<>();
    }

    public void addTeam(Team team) { teams.add(team); }
    public void addMatch(Assignment02 match) { matches.add(match); }

    public void calculateLeagueStats() {
        for (Team t : teams) {
            t.resetStats();
        }

        for (Assignment02 m : matches) {
            int hGoals = m.getHomeGoals();
            int aGoals = m.getAwayGoals();

            m.getHomeTeam().addGoalsFor(hGoals);
            m.getHomeTeam().addGoalsAgainst(aGoals);
            m.getAwayTeam().addGoalsFor(aGoals);
            m.getAwayTeam().addGoalsAgainst(hGoals);

            if (hGoals > aGoals) {
                m.getHomeTeam().addPoints(3);
            } else if (aGoals > hGoals) {
                m.getAwayTeam().addPoints(3);
            } else {
                m.getHomeTeam().addPoints(1);
                m.getAwayTeam().addPoints(1);
            }
        }
    }

    public void displayLeagueTable() {
        teams.sort((t1, t2) -> {
            if (t1.getPoints() != t2.getPoints()) {
                return Integer.compare(t2.getPoints(), t1.getPoints());
            }
            return Integer.compare(t2.getGoalDifference(), t1.getGoalDifference());
        });

        System.out.println("=== LEAGUE TABLE ===");
        int rank = 1;
        for (Team t : teams) {
            System.out.println(rank++ + ". " + t.getName() + " - Points: " + t.getPoints() 
                + " | GD: " + t.getGoalDifference() + " | GF: " + t.getGoalsFor() + " | GA: " + t.getGoalsAgainst());
        }
    }

    public void displayMatchDetails() {
        System.out.println("\n=== MATCH DETAILS ===");
        for (Assignment02 m : matches) {
            System.out.println("Match " + m.getMatchId() + " (" + m.getDateTime() + "): " 
                + m.getHomeTeam().getName() + " " + m.getHomeGoals() 
                + " - " + m.getAwayGoals() + " " + m.getAwayTeam().getName());
            for (Goal g : m.getGoals()) {
                String assist = (g.getAssistPlayer() != null) ? " (Assist: " + g.getAssistPlayer().getName() + ")" : "";
                System.out.println("  -> " + g.getMinute() + "' Goal: " + g.getScorer().getName() + assist);
            }
        }
    }

    public void displayIndividualLeaderboards() {
        ArrayList<Player> allPlayers = new ArrayList<>();
        for (Team t : teams) {
            allPlayers.addAll(t.getPlayers());
        }

        allPlayers.sort((p1, p2) -> Integer.compare(p2.getTotalContribution(), p1.getTotalContribution()));
        System.out.println("\n--- Best Overall Player (Goals + Assists) ---");
        if (!allPlayers.isEmpty()) {
            Player top = allPlayers.get(0);
            System.out.println(top.getName() + " (" + top.getTotalContribution() + " contributions)");
        }

        allPlayers.sort((p1, p2) -> Integer.compare(p2.getGoalsScored(), p1.getGoalsScored()));
        System.out.println("\n--- Top Scorer ---");
        if (!allPlayers.isEmpty()) {
            Player top = allPlayers.get(0);
            System.out.println(top.getName() + " (" + top.getGoalsScored() + " goals)");
        }

        allPlayers.sort((p1, p2) -> Integer.compare(p2.getAssists(), p1.getAssists()));
        System.out.println("\n--- Top Assists Provider ---");
        if (!allPlayers.isEmpty()) {
            Player top = allPlayers.get(0);
            System.out.println(top.getName() + " (" + top.getAssists() + " assists)");
        }
    }
}
