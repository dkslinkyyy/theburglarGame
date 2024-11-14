package se.dawid.theburglar.game.room;

import java.util.*;

public class RoomManager {

    private static final RoomManager instance = new RoomManager();

    private Room currentRoom;

    private final List<Room> rooms = new ArrayList<>();

    private RoomManager(){}

    public static RoomManager getInstance() {
        return instance;
    }

    public void setup(Room... rooms) {
        this.rooms.addAll(Arrays.asList(rooms));
    }

    public void setStartingRoom(RoomLayout layout) {
        Optional<Room> startingRoom = findMatching(layout.getName());
        if (startingRoom.isPresent()) {
            this.currentRoom = startingRoom.get();
        } else {
            System.out.println("Starting room not found: " + layout.getName());
        }
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public Optional<Room> findMatching(String roomName) {
        return rooms.stream()
                .filter(room -> room.getLayout().getName().equalsIgnoreCase(roomName))
                .findFirst();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
