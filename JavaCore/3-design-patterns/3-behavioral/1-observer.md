# Observer Pattern

## Intent

Define a one-to-many dependency between objects so that when one object (the subject) changes state, all its dependents (observers) are notified and updated automatically.

---

## Motivation

When an object’s state changes, other objects depending on it need to stay consistent without tightly coupling them.

---

## Structure

- **Subject:** Maintains a list of observers and sends notifications.
- **Observer:** Defines an interface for objects that should be notified.
- **ConcreteSubject:** Stores state and notifies observers on changes.
- **ConcreteObserver:** Implements reaction to updates.

---

## Example

### Observer Interface

```java
public interface Observer {
    void update(String message);
}
```

### Subject Interface

```java
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
```

### ConcreteSubject

```java
import java.util.ArrayList;
import java.util.List;

public class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String news;

    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }
}
```

### ConcreteObserver

```java
public class NewsChannel implements Observer {
    private String news;

    @Override
    public void update(String news) {
        this.news = news;
        System.out.println("NewsChannel received update: " + news);
    }
}
```

### Client Code

```java
NewsAgency agency = new NewsAgency();
NewsChannel channel1 = new NewsChannel();
NewsChannel channel2 = new NewsChannel();

agency.registerObserver(channel1);
agency.registerObserver(channel2);

agency.setNews("Breaking news: Observer pattern explained!");
```

---

## Advantages

- Promotes loose coupling between subject and observers.
- Supports broadcast communication.
- Observers can be added or removed dynamically.

---

## Disadvantages

- Can cause memory leaks if observers are not properly removed.
- Update order not guaranteed.
- Excessive notifications may affect performance.

---

## Summary

The Observer pattern allows an object to notify other objects automatically of state changes, promoting loose coupling and flexible communication.
