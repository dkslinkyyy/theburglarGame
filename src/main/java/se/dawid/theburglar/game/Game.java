package se.dawid.theburglar.game;

import se.dawid.theburglar.game.room.RoomManager;
import se.dawid.theburglar.input.InputHandler;

public class Game {

    private static Game instance;

    private boolean running = false;

    private RoomManager roomManager;

    private InputHandler inputHandler;


    private Game(){}

    public void start() {
        while(running) {
            run();
        }
    }


    public Game setRoomMananger(RoomManager roomManager) {
        this.roomManager = roomManager;
        return this;
    }

    public Game setInputHandler(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
        return this;
    }



    private void run() {
        if(!running) {
            running = true;
        }
    }

    public static Game getInstance() {
        if(instance == null) {
            instance = new Game();
        }
        return instance;
    }






}
