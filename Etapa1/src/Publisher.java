public class Publisher extends Component{
    private Topic topic;
    //Constructor
    public Publisher( String nombre, String topico, Broker broker){
        super(nombre, topico);
        topic = broker.createTopic(topico);
    }

    public void publicar(String mensaje){
        if(topic!=null){
            topic.notify(mensaje);
        }
    }

    public String getTopico() {
        return super.getTopico();
    }
}