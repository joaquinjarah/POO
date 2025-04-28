import java.io.PrintStream;
import java.util.Scanner;

public class Ruta extends Subscriber {
    public Ruta(String nombre, String topico, PrintStream out) {
        super(nombre, topico, out); // Llamada al constructor de Subscriber
    }

    @Override
    public void actualizar(String mensaje) {
        Scanner in = new Scanner(mensaje);

        if (in.hasNextInt()) {
            int x = in.nextInt();  // Coordenada X
            int y = in.nextInt();  // Coordenada Y

            if (getOut() != null) {
                // Guardamos el mensaje en formato CSV: <nombre>,<topico>,<x>,<y>
                getOut().println(getNombre() + "," + getTopico() + "," + x + "," + y);
            }
        }
    }
}



