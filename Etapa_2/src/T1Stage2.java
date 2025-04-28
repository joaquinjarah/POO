import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class T1Stage2 {
   private Publisher gps;

   public static void main(String[] args) {
      if (args.length != 1) {
         System.out.println("Usage: java T1Stage2 <configurationFile.txt>");
         System.exit(-1);
      }

      Scanner in = null;
      try {
         in = new Scanner(new File(args[0]));
      } catch (FileNotFoundException e) {
         e.printStackTrace();
         System.out.println("File: " + args[0]);
         System.exit(-1);
      }

      T1Stage2 stage = new T1Stage2();
      stage.setupSimulator(in);
      stage.runSimulation(args[0]);  // Le pasamos el nombre del archivo para contar líneas
   }

   public void setupSimulator(Scanner in) {
      Broker broker = new Broker();
      while (in.hasNext()) {
         String component = in.next();

         if (component.equals("publicador")) {
            String nombre = in.next();
            String topico = in.next();
            Publisher pub = new Publisher(nombre, topico, broker);
            if (gps == null) {
               gps = pub;  // Solo el primer publicador se usará para leer desde teclado
            }
         } else if (component.equals("suscriptor")) {
            String tipo = in.next();
            String nombre = in.next();
            String topico = in.next();
            String archivoSalida = in.next();

            try {
               if (tipo.equals("Seguidor")) {
                  PrintStream salida = new PrintStream(archivoSalida);
                  Seguidor seguidor = new Seguidor(nombre, topico, salida);
                  broker.subscribe(seguidor);
               } else if (tipo.equals("Registrador") || tipo.equals("Ruta")) {
                     PrintStream salida = new PrintStream(archivoSalida);
                     Ruta ruta = new Ruta(nombre, topico, salida);  // Crear una instancia de Ruta con el PrintStream
                     broker.subscribe(ruta);  // Suscribir como Ruta
                  }
            } catch (FileNotFoundException e) {
               e.printStackTrace();
               System.out.println("File: " + archivoSalida);
               System.exit(-1);
            }
         } else {
            System.out.println("Tipo de componente desconocido: " + component);
         }
      }
   }


   public void runSimulation(String configFileName) {
      int cantidadEntradas = contarLineas(configFileName);

      System.out.println("Esperando " + cantidadEntradas + " entradas de coordenadas...");

      Scanner input = new Scanner(System.in);
      int count = 0;
      while (count < cantidadEntradas && input.hasNextLine()) {
         String mensaje = input.nextLine();
         gps.publicar(mensaje);
         count++;
      }

      System.out.println("Se procesaron " + count + " líneas de entrada. Fin de la simulación.");
   }

   private int contarLineas(String archivo) {
      int lineCount = 0;
      try (Scanner reader = new Scanner(new File(archivo))) {
         while (reader.hasNextLine()) {
            reader.nextLine();
            lineCount++;
         }
      } catch (FileNotFoundException e) {
         e.printStackTrace();
         System.exit(-1);
      }
      return lineCount;
   }
}


