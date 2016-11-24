package tasks.manager.model.observer;

public interface Observable {
    void addObserver(java.util.Observer o);
    void removeObserver(java.util.Observer o);
    void notifyObserver();
}
