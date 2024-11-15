package se.dawid.theburglar;

import se.dawid.theburglar.game.Game;
import se.dawid.theburglar.game.entitiy.Burglar;
import se.dawid.theburglar.game.entitiy.Resident;
import se.dawid.theburglar.game.input.GameInputController;
import se.dawid.theburglar.game.room.layout.*;
import se.dawid.theburglar.game.room.RoomManager;
import se.dawid.theburglar.game.room.RoomLayout;

public class Core {

    public static void main(String[] args) {
        RoomManager roomManager = RoomManager.getInstance();
        roomManager.setup(
                        new Kitchen(),
                        new Office(),
                        new Hallway(),
                        new Bedroom(),
                        new LivingRoom());

        roomManager.setStartingRoom(RoomLayout.LIVING_ROOM);

        Game.getInstance()
                .setRoomManager(roomManager)
                .setInputHandler(new GameInputController(roomManager,
                        new Resident("Boende", 12, 3),
                        new Burglar("Tjuv", 12, 4)
                        ))
                .printInfo()
                .start();


    }

}
