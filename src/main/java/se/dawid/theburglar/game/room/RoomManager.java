package se.dawid.theburglar.game.room;

import java.util.*;

public class RoomManager {

    private static RoomManager instance;

    private Room currentRoom;

    private List<Room> rooms = new ArrayList<>();

    private RoomManager(){}


    public static RoomManager getInstance() {
        if(instance == null) {
            instance = new RoomManager();
        }
        return instance;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public RoomManager setup(Room... rooms) {
        this.rooms.addAll(Arrays.asList(rooms));
        return this;
    }

    public void setStartingRoom(RoomLayout layout) {
        currentRoom = findMatching(layout.getName());
    }

    public Room findMatching(String roomName) throws NoSuchElementException {
        return rooms.stream()
                .filter(room -> room.getLayout().getName().equalsIgnoreCase(roomName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Hittade inte rummet."));
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
