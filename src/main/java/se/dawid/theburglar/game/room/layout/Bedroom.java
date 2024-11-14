package se.dawid.theburglar.game.room.layout;

import se.dawid.theburglar.game.entitiy.Burglar;
import se.dawid.theburglar.game.entitiy.Resident;
import se.dawid.theburglar.game.room.Room;
import se.dawid.theburglar.game.room.RoomLayout;

import java.util.Scanner;

public class Bedroom implements Room {
    @Override
    public RoomLayout getLayout() {
        return RoomLayout.BEDROOM;
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
    public void onEnter(Scanner scanner, Resident resident, Burglar burglar){

    }
}
