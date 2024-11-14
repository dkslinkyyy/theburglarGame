package se.dawid.theburglar.game.room.layout;

import se.dawid.theburglar.game.entitiy.Burglar;
import se.dawid.theburglar.game.entitiy.Entity;
import se.dawid.theburglar.game.entitiy.Resident;
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
        return new RoomLayout[]
                {
                        RoomLayout.LIVING_ROOM
                };
    }

    @Override
    public String getMessage() {
        return "";
    }

    @Override
    public void onEnter(Scanner scanner, Resident resident, Burglar burglar) {
        if (!burglar.isConscious()) {
            while (true) {
                System.out.print("Vill du ringa polisen? Skriv Y|N: ");
                String action = scanner.nextLine().trim();

                if (action.equalsIgnoreCase("Y")) {
                    System.out.println("Du ringde polisen i god tid! Du har vunnit!");
                    System.exit(0);
                    break;
                } else if (action.equalsIgnoreCase("N")) {
                    System.out.println("Attans! Tjuven flydde från platsen och du förlorade.");
                    System.exit(0);
                    break;
                } else {
                    System.out.println("Ogiltigt val. Skriv Y för att ringa polisen eller N för att låta tjuven fly.");
                }
            }
        }
    }

}
