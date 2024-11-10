package se.dawid.theburglar.game;

import se.dawid.theburglar.game.entitiy.Entity;
import se.dawid.theburglar.game.input.InputHandler;
import se.dawid.theburglar.game.room.RoomManager;

public class Game {

    private static Game instance;

    private boolean running = false;

    private RoomManager roomManager;
    private InputHandler inputHandler;

    private Game() {}

    public void start() {
        running = true;
        System.out.println("Spelet har påbörjat, skriv 'exit' för att avsluta");
        while (running) {
            run();
        }
        System.out.println("Spelet har avslutats.");
    }

    public Game setRoomManager(RoomManager roomManager) {
        this.roomManager = roomManager;
        return this;
    }

    public Game setInputHandler(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
        return this;
    }

    private void run() {
        inputHandler.handleInput(roomManager.getCurrentRoom());
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }
}
