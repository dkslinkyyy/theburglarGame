package se.dawid.theburglar.game.input;

import se.dawid.theburglar.game._utilities.Command;
import se.dawid.theburglar.game._utilities.Message;
import se.dawid.theburglar.game._utilities.Utils;
import se.dawid.theburglar.game.entitiy.Burglar;
import se.dawid.theburglar.game.entitiy.Entity;
import se.dawid.theburglar.game.entitiy.Resident;
import se.dawid.theburglar.game.room.Room;
import se.dawid.theburglar.game.room.RoomLayout;
import se.dawid.theburglar.game.room.RoomManager;

import java.util.Objects;
import java.util.Optional;
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
        Utils.print(Message.WHERE_NEXT, true);
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase(Command.EXIT_CMD.getMessage())) {
            Utils.print(Message.ENDING_GAME, true);
            System.exit(0);

        } else if (input.startsWith(Command.GO_TO_CMD.getMessage())) {
            String roomName = input.substring(Command.GO_TO_CMD.getMessage().length()).trim();
            Optional<Room> roomOpt = roomManager.findMatching(roomName);

            if (roomOpt.isPresent()) {
                Room targetRoom = roomOpt.get();
                if (isRoomAccessible(currentRoom, targetRoom)) {
                    changeRoom(targetRoom);
                } else {
                    Utils.print(Message.ROOM_NOT_AVAILABLE, true);
                }
            } else {
                Utils.print(Message.ROOM_NOT_FOUND, true);
            }

        } else {
            currentRoom.onEnter(scanner, (Resident) entities[1], (Burglar) entities[0]);
        }
    }

    private boolean isRoomAccessible(Room currentRoom, Room targetRoom) {
        for (RoomLayout layout : currentRoom.getAvailableRooms()) {
            if (layout.equals(targetRoom.getLayout())) {
                return true;
            }
        }
        return false;
    }

    private void changeRoom(Room newRoom) {
        Room currentRoom = roomManager.getCurrentRoom();

        if (newRoom.equals(currentRoom)) {
            Utils.print(Message.ALREADY_IN_ROOM, true, newRoom.getLayout().getName());
            return;
        }

        roomManager.setCurrentRoom(newRoom);
        Utils.print(Message.MOVED_TO_ROOM, true, newRoom.getLayout().getName());
        System.out.println(newRoom.getMessage());

        newRoom.onEnter(scanner, (Resident) entities[1], (Burglar) entities[0]);
    }
}
