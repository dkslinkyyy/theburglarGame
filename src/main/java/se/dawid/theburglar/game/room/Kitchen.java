package se.dawid.theburglar.game.room;

public class Kitchen implements Room {
    @Override
    public String getName() {
        return "Kitchen";
    }

    @Override
    public RoomType[] getAvailableRooms() {
        return new RoomType[] {
                RoomType.LIVING_ROOM //center
        };
    }


    @Override
    public String getMessage() {
        return "";
    }

    @Override
    public void onEnter() {

    }




}
