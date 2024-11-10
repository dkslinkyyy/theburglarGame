package se.dawid.theburglar.game.room.layout;

import se.dawid.theburglar.game.entitiy.Burglar;
import se.dawid.theburglar.game.entitiy.Entity;
import se.dawid.theburglar.game.entitiy.Resident;
import se.dawid.theburglar.game.room.Room;
import se.dawid.theburglar.game.room.RoomLayout;

import java.util.Scanner;

public class Hallway implements Room {
    @Override
    public RoomLayout getLayout() {
        return RoomLayout.HALLWAY;
    }

    @Override
    public RoomLayout[] getAvailableRooms() {
        return new RoomLayout[0];
    }

    @Override
    public String getMessage() {
        return "Du har stött på tjuven! Skriv 'fight' för att slåss och 'leave' för att lämna.";
    }

    @Override
    public void onEnter(Scanner scanner, Entity... entities) {
        Resident resident = (Resident) entities[1];
        Burglar burglar = (Burglar) entities[0];

        while (burglar.isConscious() && resident.isConscious()) {
            System.out.print("Ditt val: ");
            String action = scanner.nextLine().trim().toLowerCase();

            if (action.equals("leave")) {
                System.out.println("Du valde att lämna korridoren.");
                return;
            }

            if (!action.equals("fight")) {
                System.out.println("Ogiltigt kommando. Skriv 'fight' eller 'leave'.");
                continue;
            }

            resident.punch(burglar);
            System.out.println("Du slog tjuven!");

            if (!burglar.isConscious()) {
                System.out.println("Tjuven är medvetslös!");
                break;
            }

            burglar.punch(resident);
            System.out.println("Tjuven slog tillbaka!");

            if (!resident.isConscious()) {
                System.out.println("Du har blivit medvetslös!");
                break;
            }
        }

        if (!burglar.isConscious()) {
            System.out.println("Tjuven är besegrad! Gå till kontoret för att ringa polisen.");
        } else if (!resident.isConscious()) {
            System.out.println("Tjuven vann! Spelet är över.");
        }
    }
}
