package se.dawid.theburglar.game.room.layout;

import se.dawid.theburglar.game.entitiy.Entity;
import se.dawid.theburglar.game.room.Room;
import se.dawid.theburglar.game.room.RoomLayout;

import java.util.Scanner;

public class Office implements Room {
    @Override
    public RoomLayout getLayout() {
        return RoomLayout.OFFICE;
    }

    @Override
    public RoomLayout[] getAvailableRooms() {
        return new RoomLayout[0];
    }

    @Override
    public String getMessage() {
        return "";
    }

    @Override
    public void onEnter(Scanner scanner, Entity... entities){

        if(!entities[0].isConscious()) {
            System.out.println("Du ringde polisen! Du har vunnit!");
            System.exit(0);
        }

    }
}
