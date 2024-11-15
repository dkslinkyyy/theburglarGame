package se.dawid.theburglar.game;

import se.dawid.theburglar.game.entitiy.Entity;
import se.dawid.theburglar.game.input.InputHandler;
import se.dawid.theburglar.game.room.RoomManager;

import java.util.Arrays;

public class Game {

    private static Game instance;

    private boolean running = false;

    private RoomManager roomManager;
    private InputHandler inputHandler;

    private Game() {}

    public Game start() {
        running = true;
        while (running) {
            run();
        }
        return this;
    }

    public Game setRoomManager(RoomManager paramRoomManager) {
        this.roomManager = paramRoomManager;
        return this;
    }

    public Game setInputHandler(InputHandler paramInputHandler) {
        this.inputHandler = paramInputHandler;
        return this;
    }

    private void run() {
        inputHandler.handleInput(roomManager.getCurrentRoom());
    }

    public Game printInfo() {
        System.out.println("Spelet har påbörjat, skriv 'exit' för att avsluta");
        System.out.println();
        System.out.println("Du är i " + roomManager.getCurrentRoom().getLayout().getName());
        System.out.println();
        System.out.println("Du kan gå till: ");
        Arrays.stream(roomManager.getCurrentRoom().getAvailableRooms()).forEach(availableRoom -> System.out.println(availableRoom.getName()));
        return this;
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

}
