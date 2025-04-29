package broker;

import java.util.ArrayList;
import component.subscriber.Subscriber;

public class Topic {
    public Topic(String topicName) {
        this.topicName = topicName;
        this.subscribers = new ArrayList<Subscriber>();
    }
    public void subscribe(Subscriber sub){
        subscribers.add(sub);
    }
    public void notify(String message) {
        for (Subscriber s:subscribers) {
            s.update(message);
        }
    }
    public boolean hasThisName(String name) {
        return topicName.equals(name);
    }

    private String topicName;
    private ArrayList<Subscriber> subscribers;
}
