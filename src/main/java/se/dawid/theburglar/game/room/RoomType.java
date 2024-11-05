package se.dawid.theburglar.game.room;

public enum RoomType {
    LIVING_ROOM("Living Room"),
    KITCHEN("Kitchen"),
    BEDROOM("Bedroom");

    private final String name;
    RoomType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
