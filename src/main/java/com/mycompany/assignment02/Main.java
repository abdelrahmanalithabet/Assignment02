package com.mycompany.assignment02;

public class Main {
    public static void main(String[] args) {
        Schedule schedule = new Schedule();

        Team manUnited = new Team("Man United");
        Team chelsea = new Team("Chelsea");
        Team barcelona = new Team("Barcelona");
        Team bayern = new Team("Bayern Munich");
        Team acMilan = new Team("AC Milan");

        Player p1 = new Player("Marcus Rashford");
        Player p2 = new Player("Bruno Fernandes");
        manUnited.addPlayer(p1);
        manUnited.addPlayer(p2);

        Player p3 = new Player("Cole Palmer");
        Player p4 = new Player("Enzo Fernandez");
        chelsea.addPlayer(p3);
        chelsea.addPlayer(p4);

        Player p5 = new Player("Robert Lewandowski");
        Player p6 = new Player("Pedri");
        barcelona.addPlayer(p5);
        barcelona.addPlayer(p6);

        Player p7 = new Player("Harry Kane");
        Player p8 = new Player("Jamal Musiala");
        bayern.addPlayer(p7);
        bayern.addPlayer(p8);

        Player p9 = new Player("Rafael Leao");
        Player p10 = new Player("Christian Pulisic");
        acMilan.addPlayer(p9);
        acMilan.addPlayer(p10);

        schedule.addTeam(manUnited);
        schedule.addTeam(chelsea);
        schedule.addTeam(barcelona);
        schedule.addTeam(bayern);
        schedule.addTeam(acMilan);

        Assignment02 m1 = new Assignment02("M01", manUnited, chelsea, "2026-10-10 15:00");
        Assignment02 m2 = new Assignment02("M02", barcelona, bayern, "2026-10-11 18:00");
        Assignment02 m3 = new Assignment02("M03", acMilan, manUnited, "2026-10-17 20:00");
        Assignment02 m4 = new Assignment02("M04", chelsea, barcelona, "2026-10-18 16:00");
        Assignment02 m5 = new Assignment02("M05", bayern, acMilan, "2026-10-24 19:30");

        m1.addGoal(p1, p2, 12);
        m1.addGoal(p3, p4, 34);
        m1.addGoal(p2, p1, 88);

        m2.addGoal(p7, p8, 5);
        m2.addGoal(p5, p6, 22);
        m2.addGoal(p7, null, 60);
        m2.addGoal(p8, p7, 81);

        m3.addGoal(p9, p10, 45);
        m3.addGoal(p1, null, 77);

        m4.addGoal(p5, p6, 15);
        m4.addGoal(p5, null, 50);

        m5.addGoal(p7, p8, 30);
        m5.addGoal(p8, null, 70);

        schedule.addMatch(m1);
        schedule.addMatch(m2);
        schedule.addMatch(m3);
        schedule.addMatch(m4);
        schedule.addMatch(m5);

        schedule.calculateLeagueStats();
        schedule.displayLeagueTable();
        schedule.displayMatchDetails();
        schedule.displayIndividualLeaderboards();
    }
}
