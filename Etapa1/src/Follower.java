import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class Follower extends Suscriber{
    private PrintStream out;

    public Follower(String nombre, String topico, PrintStream out){
        super(nombre, topico);
        this.out=out;
    }
    @Override
    public void actualizar(String mensaje){
        out.println(getNombre()+" "+getTopico()+" "+mensaje);
    }
}
