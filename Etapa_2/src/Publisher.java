public class Publisher extends Component {
    private Broker broker;

    public Publisher(String nombre, String topico, Broker broker) {
        super(nombre, topico);
        this.broker = broker;
    }

    public void publicar(String mensaje) {
        broker.publicar(topico, mensaje);
    }
}

