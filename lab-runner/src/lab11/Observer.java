package lab11;

public interface Observer<EventType> {
    void notify(EventType event);
}
