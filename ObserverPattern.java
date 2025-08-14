import java.util.*;
/*
 *When to use the Observer Pattern
    When multiple objects need to be notified when one object changes.
    In event-driven systems like GUIs, chat apps, or notification systems.
    When implementing publish-subscribe behavior.
 */


//all the observers will need to implement this feature
interface Observer {
    void updateObserver(String message);
}

// the subject should implement this methods
interface subject {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyAllObservers(String update);
}

// the observer
class Subscriber implements Observer {
    private String name;

    Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void updateObserver(String message) {
        System.out.println(name + " you have a new message -> " + message);
    }
}

// the subject
class YoutubeChannel implements subject {

    private List<Observer> observers;
    private String channelName;

    YoutubeChannel(String name) {
        channelName = name;
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void updateWithAEvent(String update) {
        System.out.println( update);
        notifyAllObservers(channelName + " :- " + update);
    }

    @Override
    public void notifyAllObservers(String update) {
        for (Observer obs : observers) {
            obs.updateObserver(update);
        }
    }

}

public class ObserverPattern {
    public static void main(String[] args) {
        YoutubeChannel channel = new YoutubeChannel("Coding Shuttle");
        Subscriber sam = new Subscriber("sam");
        Subscriber robin = new Subscriber("robin");
        Subscriber muler = new Subscriber("muler");
        channel.addObserver(sam);
        channel.addObserver(robin);
        channel.addObserver(muler);

        channel.updateWithAEvent("New Video of Core Java released to the channel , check it out");

        channel.removeObserver(robin);

        channel.updateWithAEvent("Spring boot playlist updated ,check it out");
    }
}
