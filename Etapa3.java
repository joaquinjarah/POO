import java.util.*;

public class Etapa3 {
    private static Map<String, Publisher> publishers = new HashMap<>();
    private static Map<String, Subscriber> subscribers = new HashMap<>();

    public static void setupSimulation() {
        // Configuración inicial de publicadores y suscriptores
        Publisher streamer1 = new Publisher("Streamer_1", "Notificaciones_1");
        publishers.put("Streamer_1", streamer1);

        Subscriber follower1 = new Follower("Seguidor_1", "Notificaciones_1", "seguidor_1.txt");
        Subscriber follower2 = new Follower("Seguidor_2", "Notificaciones_1", "seguidor_2.txt");
        subscribers.put("Seguidor_1", follower1);
        subscribers.put("Seguidor_2", follower2);

        Broker broker = new Broker();
        broker.registerPublisher(streamer1);
        broker.registerSubscriber(follower1);
        broker.registerSubscriber(follower2);
    }

    public static void main(String[] args) {
        setupSimulation();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Ingrese el nombre del publicador y mensaje (o 'exit' para terminar):");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) break;

            String[] parts = input.split(" ", 2);
            if (parts.length < 2) {
                System.out.println("Entrada inválida. Debe incluir nombre del publicador y mensaje.");
                continue;
            }

            String publisherName = parts[0];
            String message = parts[1];

            Publisher publisher = publishers.get(publisherName);
            if (publisher == null) {
                System.out.println("Unknown Publisher");
            } else {
                publisher.publishMessage(message);
            }
        }

        scanner.close();
    }
}
