package broker;

import java.util.ArrayList;
import component.subscriber.Subscriber;

public class Broker {
    public Broker() {
        topics = new ArrayList<Topic>();
    }
    public Topic createTopic (String topicName){
        Topic topic;
        if ((topic=findTopic(topicName))==null) {
            topic = new Topic(topicName);
            topics.add(topic);
            return topic;
        } else {
            return null; // topic already exists.
        }
    }
    public boolean subscribe (Subscriber sub){
        String topicName = sub.getTopicName();
        Topic topic;
        if ((topic=findTopic(topicName))!=null) {
            topic.subscribe(sub);
            return true;
        } else
            return false; // topic does not exist.
    }
    private Topic findTopic (String topicName) {
        for(Topic topic:topics){
            if(topic.hasThisName(topicName)){
                return topic;
            }
        }
        return null;  // topic not found
    }
    private ArrayList<Topic> topics;
}
