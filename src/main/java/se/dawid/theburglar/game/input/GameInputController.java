package se.dawid.theburglar.game.input;

import se.dawid.theburglar.game.entitiy.Entity;
import se.dawid.theburglar.game.room.Room;
import se.dawid.theburglar.game.room.RoomLayout;
import se.dawid.theburglar.game.room.RoomManager;
import java.util.Scanner;

public class GameInputController implements InputHandler {

    private final Scanner scanner = new Scanner(System.in);
    private final RoomManager roomManager;
    private final Entity[] entities;

    public GameInputController(RoomManager roomManager, Entity... entities) {
        this.roomManager = roomManager;
        this.entities = entities;
    }

    @Override
    public void handleInput(Room currentRoom) {
        System.out.print("Enter a command (e.g., 'go to <room>', 'fight', 'leave'): ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("exit")) {
            System.out.println("Exiting game...");
            System.exit(0);
        } else if (input.startsWith("go to ")) {
            String roomName = input.substring(6).trim();
            Room room = roomManager.findMatching(roomName);
            changeRoom(room);
        } else {
            currentRoom.onEnter(scanner, entities);
        }
    }

    private void changeRoom(Room newRoom) {
        Room currentRoom = roomManager.getCurrentRoom();
        if (newRoom.equals(currentRoom)) {
            System.out.println("You are already in " + newRoom.getLayout().getName());
            return;
        }

        if (!currentRoom.getLayout().equals(RoomLayout.LIVING_ROOM)
            && !newRoom.getLayout().equals(RoomLayout.LIVING_ROOM)) {
            System.out.println("You need to be in the living room to move to another room.");
            return;
        }

        roomManager.setCurrentRoom(newRoom);
        System.out.println("Moved to " + newRoom.getLayout().getName());
        System.out.println(newRoom.getMessage());
        newRoom.onEnter(scanner, entities);
    }
}
