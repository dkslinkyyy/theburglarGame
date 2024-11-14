package se.dawid.theburglar.game.room;

import se.dawid.theburglar.game.entitiy.Burglar;
import se.dawid.theburglar.game.entitiy.Entity;
import se.dawid.theburglar.game.entitiy.Resident;

import java.util.Scanner;

public interface Room {
     RoomLayout getLayout();
     RoomLayout[] getAvailableRooms();
     String getMessage();
     void onEnter(Scanner scanner, Resident resident, Burglar burglar);
}
