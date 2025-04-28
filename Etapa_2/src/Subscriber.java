import java.io.PrintStream;

public abstract class Subscriber extends Component {
    private PrintStream out; // Este es el PrintStream para escribir la salida

    public Subscriber(String nombre, String topico, PrintStream out) {
        super(nombre, topico);  // Llamada al constructor de Component
        this.out = out;  // Asignamos el PrintStream
    }

    public PrintStream getOut() {
        return out;  // Devuelve el PrintStream
    }

    // Método abstracto para ser implementado por las subclases
    public abstract void actualizar(String mensaje);
}






