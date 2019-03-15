package homework.lesson1.main.Participants;

import homework.lesson1.main.Marathon.Competitor;

public class Team {

    private String teamName;
    private Competitor[] competitors;// = new Competitor[4];

    public Competitor[] getCompetitors(){
        return competitors;
    }

    public Team(String teamName, Competitor... competitors){
        this.teamName = teamName;
        this.competitors = competitors;
    }

    public void showResult(){
        System.out.println("Результаты команды " + teamName + ":");
        for (Competitor c: this.competitors)
            c.info();
    }

    public void showInfoAboutTeam(){
        System.out.println("Информация о членах комманды " + teamName + ":");
        for (Competitor c: this.competitors)
            c.infoAboutCompetitors();
    }
}
