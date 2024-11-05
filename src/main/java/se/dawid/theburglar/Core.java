package se.dawid.theburglar;

import se.dawid.theburglar.game.Game;
import se.dawid.theburglar.game.room.Kitchen;
import se.dawid.theburglar.game.room.RoomManager;
import se.dawid.theburglar.game.room.RoomType;
import se.dawid.theburglar.input.InputHandler;

public class Core {

    public static void main(String[] args) {


        RoomManager roomManager = RoomManager.getInstance();

        roomManager.setup(new Kitchen()).setStartingRoom(RoomType.LIVING_ROOM);

        Inpu

        Game.getInstance()
                .setRoomMananger(roomManager)
                .setInputHandler()


    }

}
