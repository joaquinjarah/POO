import java.util.ArrayList;

public class Topic {
    private String topico;
    private ArrayList<Subscriber> suscribers;

    public Topic(String topico) {
        this.topico = topico;
        this.suscribers = new ArrayList<>();
    }

    public void suscribe(Subscriber sub) {
        suscribers.add(sub);
    }

    public void notify(String mensaje) {
        for (Subscriber s : suscribers) {
            s.actualizar(mensaje);
        }
    }

    public boolean hasThisName(String nombre) {
        return topico.equals(nombre);
    }
}


