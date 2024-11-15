package se.dawid.theburglar.game.room.layout;

import se.dawid.theburglar.game._utilities.Command;
import se.dawid.theburglar.game._utilities.Message;
import se.dawid.theburglar.game._utilities.Utils;
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
                RoomLayout.LIVING_ROOM
        };
    }

    @Override
    public String getMessage() {
        return "";
    }

    @Override
    public void onEnter(Scanner scanner, Resident resident, Burglar burglar) {

        while (!resident.hasFryingPan()) {
            Utils.print(Message.FOUND_FRYING_PAN, true);
            String action = scanner.nextLine();

            if (action.equalsIgnoreCase(Command.AGREE_CMD.getMessage())) {
                resident.addDamage(3);
                resident.setFryingPan(true);
                Utils.print(Message.TOOK_FRYING_PAN, true);
                break;
            } else if (action.equalsIgnoreCase(Command.DENY_CMD.getMessage())) {
                Utils.print(Message.DID_NOT_TAKE_FRYING_PAN, true);
                break;
            } else {
                System.out.println("Ogiltigt val. " + getMessage());
            }
        }
    }
}
