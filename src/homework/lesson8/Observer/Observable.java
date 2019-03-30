package homework.lesson8.Observer;

public interface Observable{
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String message);
}
