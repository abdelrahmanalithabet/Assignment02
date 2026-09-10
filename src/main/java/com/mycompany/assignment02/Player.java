package com.mycompany.assignment02;

import java.util.Objects;

public class Player {
    private String name;
    private int goalsScored;
    private int assists;

    public Player(String name) {
        this.name = name;
        this.goalsScored = 0;
        this.assists = 0;
    }

    public String getName() { return name; }
    public int getGoalsScored() { return goalsScored; }
    public int getAssists() { return assists; }
    public int getTotalContribution() { return goalsScored + assists; }

    public void addGoal() { this.goalsScored++; }
    public void addAssist() { this.assists++; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
