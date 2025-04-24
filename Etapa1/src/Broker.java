import java.util.ArrayList;

public class Broker {
    public Broker() {
        topics = new ArrayList<Topic>();
    }
    public Topic createTopic (String topico){
        Topic topic = new Topic(topico);
        topics.add(topic);
        return topic;
    }
    public boolean subscribe (Suscriber sub){
        String topicName = sub.getTopico();
        Topic topic;
        if ((topic=findTopic(topicName))!=null) {
            topic.suscribe(sub);
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
