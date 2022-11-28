package patterns.observable;

public interface Observable<EventType> {
    void subscribe(Observer<EventType> event);
    void unsubscribe(Observer<EventType> event);
    void notifySubscribers(EventType event);
}
