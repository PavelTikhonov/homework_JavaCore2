package homework.lesson1.main;

import homework.lesson1.main.Marathon.*;
import homework.lesson1.main.Participants.*;


public class Main {
    public static void main(String[] args) {

        Team team = new Team("DreamTeam", new Human("Дейнерис Таргариен"), new Human("Джон Сноу"),
                    new Cat("Драккарис"), new Dog("Визерион"));
        Course course = new Course(new Cross(80), new Wall(2), new Water(100), new Cross(120));
        course.doIt(team.getCompetitors());

        System.out.println();
        team.showResult();
        System.out.println();
        team.showInfoAboutTeam();
    }
}