package component.subscriber;

import java.io.PrintStream;

public class Follower extends Subscriber {
    public Follower(String name, String topicName, PrintStream out) {
        super(name, topicName);
        this.out = out;
    }
    @Override
    public void update(String message) {
        out.println(getName()+ " " + getTopicName() + " " + message);
    }
    private PrintStream out;
} 
