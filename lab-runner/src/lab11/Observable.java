package lab11;

public interface Observable<EventType> {
    void addObserver(Observer<EventType> observer);
    void removeObserver(Observer<EventType> observer);

     void notifyObservers(EventType event);
}
