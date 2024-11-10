package se.dawid.theburglar.game.room;

public enum RoomLayout {
    LIVING_ROOM("Vardagsrummet"),
    KITCHEN("Köket"),
    BEDROOM("Sovrummet"),
    OFFICE("Kontoret"),
    HALLWAY("Hall");

    private final String name;
    RoomLayout(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
