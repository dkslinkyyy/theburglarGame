package se.dawid.theburglar;

import se.dawid.theburglar.game.Game;
import se.dawid.theburglar.game.entitiy.Burglar;
import se.dawid.theburglar.game.entitiy.Resident;
import se.dawid.theburglar.game.input.GameInputController;
import se.dawid.theburglar.game.room.layout.Hallway;
import se.dawid.theburglar.game.room.layout.Kitchen;
import se.dawid.theburglar.game.room.RoomManager;
import se.dawid.theburglar.game.room.RoomLayout;
import se.dawid.theburglar.game.room.layout.LivingRoom;
import se.dawid.theburglar.game.room.layout.Office;

public class Core {

    public static void main(String[] args) {
        RoomManager roomManager = RoomManager.getInstance();
        roomManager
                .setup(new Kitchen(),
                        new Office(),
                        new Hallway(),
                        new LivingRoom())
                .setStartingRoom(RoomLayout.LIVING_ROOM);

        Game.getInstance()
                .setRoomManager(roomManager)
                .setInputHandler(new GameInputController(roomManager,
                        new Burglar("Burglar", 12, 4),
                        new Resident("Resident", 12, 3)))
                .start();


    }

}
