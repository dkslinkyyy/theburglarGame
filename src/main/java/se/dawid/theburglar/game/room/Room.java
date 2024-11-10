package se.dawid.theburglar.game.room;

import se.dawid.theburglar.game.entitiy.Entity;

import java.util.Scanner;

public interface Room {

     RoomLayout getLayout();

     RoomLayout[] getAvailableRooms();

     String getMessage();

     void onEnter(Scanner scanner, Entity... entities);
}
