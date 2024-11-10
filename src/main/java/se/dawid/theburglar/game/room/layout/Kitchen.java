package se.dawid.theburglar.game.room.layout;

import se.dawid.theburglar.game.entitiy.Entity;
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
                RoomLayout.LIVING_ROOM //center
        };
    }


    @Override
    public String getMessage() {
        return "Du har hittat en stekpana i köket! Skriv Y|N för att ta upp den";
    }

    @Override
    public void onEnter(Scanner scanner, Entity... entities){
         String action = scanner.nextLine();
         if(action.equalsIgnoreCase("Y")) {
           entities[1].addDamage(3);
           return;
         }
        System.out.println("Du valde att undvika stekpanan. Det här kan ha konsekvenser..");
    }




}
