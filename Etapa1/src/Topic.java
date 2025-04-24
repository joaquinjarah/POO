import java.util.ArrayList;

public class Topic {
    private String topico;
    private ArrayList<Suscriber> suscribers;

    public Topic(String topico){
        this.topico=topico;
        this.suscribers=new ArrayList<>();
    }
    public void suscribe(Suscriber sub){
        suscribers.add(sub);
    }
    public void notify(String mensaje){
        for(Suscriber s:suscribers){
            s.actualizar(mensaje);
        }
    }
    public boolean hasThisName(String nombre){
        return topico.equals(nombre);
    }
}
