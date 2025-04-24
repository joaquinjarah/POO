public abstract class Suscriber extends Component implements ISuscriptor{

    public Suscriber(String nombre, String topico){
        super(nombre, topico);
    }

    public String getTopico() {
        return super.getTopico();
    }
}
