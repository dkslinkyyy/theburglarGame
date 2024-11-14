package se.dawid.theburglar.game.room.layout;

import se.dawid.theburglar.game.entitiy.Burglar;
import se.dawid.theburglar.game.entitiy.Resident;
import se.dawid.theburglar.game.room.Room;
import se.dawid.theburglar.game.room.RoomLayout;

import java.util.Scanner;

public class Kitchen implements Room {
    @Override
    public RoomLayout getLayout() {
        return RoomLayout.KITCHEN;
    }

    @Override
    public RoomLayout[] getAvailableRooms() {
        return new RoomLayout[] {
                RoomLayout.LIVING_ROOM // center
        };
    }

    @Override
    public String getMessage() {
        return "";
    }

    @Override
    public void onEnter(Scanner scanner, Resident resident, Burglar burglar) {

        while (!resident.hasFryingPan()) {
            System.out.println("Du har hittat en stekpanna i köket! Skriv Y|N för att ta upp den");
            String action = scanner.nextLine();

            if (action.equalsIgnoreCase("Y")) {
                resident.addDamage(3);
                resident.setFryingPan(true);
                System.out.println("Du valde att ta upp stekpannan.");
                break;
            } else if (action.equalsIgnoreCase("N")) {
                System.out.println("Du valde att undvika stekpannan. Det här kan ha konsekvenser...");
                break;
            } else {
                System.out.println("Ogiltigt val. " + getMessage());
            }
        }
    }
}
