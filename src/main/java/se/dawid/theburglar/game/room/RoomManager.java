package se.dawid.theburglar.game.room;

import se.dawid.theburglar.game.Game;

import java.util.*;
import java.util.stream.Collectors;

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

    public RoomManager setup(Room... rooms) {
        this.rooms.addAll(Arrays.asList(rooms));
        return this;
    }

    public RoomManager setStartingRoom(RoomType roomType) {
        currentRoom = rooms.stream()
                .filter(room -> room.getName().equalsIgnoreCase(roomType.getName()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Hittade int rummet."));
        return this;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
