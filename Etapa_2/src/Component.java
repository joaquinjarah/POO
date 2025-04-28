public abstract class Component {
    protected String nombre;
    protected String topico;

    // Constructor con parámetros
    public Component(String nombre, String topico) {
        this.nombre = nombre;
        this.topico = topico;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getTopico() {
        return topico;
    }
}


