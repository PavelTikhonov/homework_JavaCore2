package homework.lesson1.main.Marathon;

public class Cross extends homework.lesson1.main.Marathon.Obstacle {
    int length;

    public Cross(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(length);
    }
}