package com.mycompany.assignment02;

public class Goal {
    private String matchId;
    private Player scorer;
    private Player assistPlayer;
    private int minute;

    public Goal(String matchId, Player scorer, Player assistPlayer, int minute) {
        this.matchId = matchId;
        this.scorer = scorer;
        this.assistPlayer = assistPlayer;
        this.minute = minute;
    }

    public String getMatchId() { return matchId; }
    public Player getScorer() { return scorer; }
    public Player getAssistPlayer() { return assistPlayer; }
    public int getMinute() { return minute; }
}
