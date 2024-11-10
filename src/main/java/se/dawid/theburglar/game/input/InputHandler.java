package se.dawid.theburglar.game.input;

import se.dawid.theburglar.game.room.Room;

public interface InputHandler {
    void handleInput(Room currentRoom);
}
