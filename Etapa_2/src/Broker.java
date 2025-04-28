import java.util.ArrayList;

public class Broker {
    private ArrayList<Topic> topics;

    public Broker() {
        this.topics = new ArrayList<>();
    }

    // Suscribir un suscriptor a un tema
    public void subscribe(Subscriber subscriber) {
        // Buscar si ya existe un tema con el nombre del suscriptor
        Topic topic = findTopic(subscriber.getTopico());

        if (topic == null) {
            // Si no existe el tema, crear uno nuevo
            topic = new Topic(subscriber.getTopico());
            topics.add(topic);
        }
        // Suscribir al suscriptor al tema
        topic.suscribe(subscriber);
    }

    // Publicar un mensaje en un tema
    public void publicar(String topico, String mensaje) {
        Topic topic = findTopic(topico);
        if (topic != null) {
            topic.notify(mensaje);
        }
    }

    // Buscar un tema en la lista de temas
    private Topic findTopic(String topico) {
        for (Topic t : topics) {
            if (t.hasThisName(topico)) {
                return t;
            }
        }
        return null;  // Si no se encuentra el tema, devolver null
    }
}




