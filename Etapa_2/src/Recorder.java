import java.io.PrintStream;
import java.util.Scanner;

public class Recorder extends Subscriber {
   private PrintStream out;

   public Recorder(String nombre, String topico, PrintStream out) {
      super(nombre, topico, out);
      this.out = out;
   }

   @Override
   public void actualizar(String mensaje) {
      Scanner in = new Scanner(mensaje);
      int x = in.nextInt();  // Coordenada X
      int y = in.nextInt();  // Coordenada Y
      out.println(getNombre() + "," + getTopico() + "," + x + "," + y);
   }
}
