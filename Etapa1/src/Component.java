public class Component {
    protected String nombre;
    protected String topico;

    public Component(String nombre, String topico){
        this.nombre=nombre;
        this.topico=topico;
    }
    public String getNombre(){
        return nombre;
    }

    public String getTopico() {
        return topico;
    }
}
