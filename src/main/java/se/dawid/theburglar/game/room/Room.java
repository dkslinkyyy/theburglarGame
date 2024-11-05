package se.dawid.theburglar.game.room;

public interface Room {

     String getName();

     RoomType[] getAvailableRooms();

     String getMessage();

     void onEnter();
}
