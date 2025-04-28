import java.io.PrintStream;

public class Seguidor extends Subscriber {
    private PrintStream out;

    public Seguidor(String nombre, String topico, PrintStream out) {
        super(nombre, topico, out);
        this.out = out;
    }

    @Override
    public void actualizar(String mensaje) {
        out.println(getNombre() + "," + getTopico() + "," + mensaje);
    }
}




