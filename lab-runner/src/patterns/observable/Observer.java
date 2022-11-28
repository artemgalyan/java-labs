package patterns.observable;

public interface Observer<EventType> {
    void update(EventType event);
}
