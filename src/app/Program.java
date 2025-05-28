package app;

import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import broker.*;
import component.publisher.Publisher;
import component.subscriber.Follower;

public class Program {
    public static void main (String args[]) {
        if (args.length != 0) {
            System.out.println("Usage: make run");
            System.exit(-1);
        }



        // Hola estuve aquí



        Program stage = new Program();
        stage.setupSimulator();
        stage.runSimulation();
    }
    public void setupSimulator() {  // create main objects from code
        Broker broker = new Broker();
        streamer = new Publisher("USMGameplays", broker, "Notificaciones");
        try {
            Follower seguidor_1 = new Follower("JuancitoGamer333", "Notificaciones", new PrintStream("out/follower_1.txt"));
            broker.subscribe(seguidor_1);

            Follower seguidor_2 = new Follower("BodoqueLover", "Notificaciones", new PrintStream("out/follower_2.txt"));
            broker.subscribe(seguidor_2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File: " + "out/follower.txt");
            System.exit(-1);
        }
    }
    public void runSimulation() {
        String[] line; 
        Scanner inputEvent = new Scanner(System.in);
        while (inputEvent.hasNextLine()) {
            String message = inputEvent.nextLine();
            if (message.equals("/exit")) {
                System.out.println("End of simulation");
                inputEvent.close();
                break;
            }
            line = message.split(" ");
            if (line.length <= 2) { 
                System.out.println("Error: Invalid message format");
                continue;
            }
            if (!line[0].equals("USMGameplays")) {
                System.out.println("Unkonwn Publisher");
                continue;
            }
            streamer.publishNewEvent(line[1]);
        }
        inputEvent.close();
    }
    private Publisher streamer;
}