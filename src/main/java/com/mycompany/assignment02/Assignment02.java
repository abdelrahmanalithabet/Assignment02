package com.mycompany.assignment02;
import java.util.ArrayList;

public class Assignment02 {
    private String matchId;
    private Team homeTeam;
    private Team awayTeam;
    private String dateTime;
    private ArrayList<Goal> goals;

    public Assignment02(String matchId, Team homeTeam, Team awayTeam, String dateTime) {
        this.matchId = matchId;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.dateTime = dateTime;
        this.goals = new ArrayList<>();
    }

    public String getMatchId() { return matchId; }
    public Team getHomeTeam() { return homeTeam; }
    public Team getAwayTeam() { return awayTeam; }
    public String getDateTime() { return dateTime; }
    public ArrayList<Goal> getGoals() { return goals; }

    public void addGoal(Player scorer, Player assistPlayer, int minute) {
        Goal goal = new Goal(matchId, scorer, assistPlayer, minute);
        goals.add(goal);
        scorer.addGoal();
        if (assistPlayer != null) {
            assistPlayer.addAssist();
        }
    }

    public int getHomeGoals() {
        int count = 0;
        for (Goal g : goals) {
            if (homeTeam.getPlayers().contains(g.getScorer())) count++;
        }
        return count;
    }

    public int getAwayGoals() {
        int count = 0;
        for (Goal g : goals) {
            if (awayTeam.getPlayers().contains(g.getScorer())) count++;
        }
        return count;
    }
}
