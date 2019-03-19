package homework.lesson1.main.Marathon;

public interface Competitor {
    void run(int dist);
    void swim(int dist);
    void jump(int height);
    boolean isOnDistance();
    void info();
    void infoAboutCompetitors();
}