package se.dawid.theburglar;

public class Game {

    private static Game instance;

    private boolean running = false;

    public Game start() {
        while(running) {
            run();
        }
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
