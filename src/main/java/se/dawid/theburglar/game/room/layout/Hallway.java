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
        return new RoomLayout[]
                {
                        RoomLayout.LIVING_ROOM
                };
    }

    @Override
    public String getMessage() {
        return "Du har stött på tjuven! Skriv 'fight' för att slåss och 'leave' för att lämna.";
    }

    @Override
    public void onEnter(Scanner scanner, Resident resident, Burglar burglar) {
        while (burglar.isConscious() && resident.isConscious()) {
            System.out.print("Ditt val: ");
            String action = scanner.nextLine().trim().toLowerCase();

            if (action.equals("leave")) {
                System.out.println("Du valde att lämna hallen.");
                return;
            }

            if (!action.equals("fight")) {
                System.out.println("Ogiltigt kommando. Skriv 'fight' eller 'leave'.");
                continue;
            }

            resident.punch(burglar);
            System.out.println("Du slog tjuven! tjuven har " + burglar.getHealth() + " hälsa");

            if (!burglar.isConscious()) {
                System.out.println("Tjuven är medvetslös!");
                break;
            }

            burglar.punch(resident);
            System.out.println("Tjuven slog tillbaka! du har " + resident.getHealth() + " hälsa");

            if (!resident.isConscious()) {
                System.out.println("Du har blivit medvetslös!");
                break;
            }
        }

        if (!burglar.isConscious()) {
            System.out.println("Tjuven är besegrad! Gå till kontoret för att ringa polisen.");
        } else if (!resident.isConscious()) {
            System.out.println("Tjuven vann! Spelet är över.");
            System.exit(0);
        }
    }
}
