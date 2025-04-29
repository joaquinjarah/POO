package component.publisher;

import component.Component;
import broker.Broker;
import broker.Topic;

public class Publisher extends Component {
    protected Publisher() {} // to ban calls to this constructor
    public Publisher(String name, Broker broker, String topicName) {
        super(name, topicName);
        topic = broker.createTopic(topicName);
    }
    public void publishNewEvent(String message) {
        if(topic!=null){
            topic.notify(message);
        }
    }
    private Topic topic; 
}
