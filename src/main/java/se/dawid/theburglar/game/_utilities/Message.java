package se.dawid.theburglar.game._utilities;

public enum Message {

    WHERE_NEXT("Vart vill du gå? ex. 'gå till <rum>'"),
    ENDING_GAME("Avslutar spelet...'"),
    ROOM_NOT_AVAILABLE("Du kan inte gå direkt till det här rummet från din nuvarande plats."),
    MOVED_TO_ROOM("Flyttade till %r"),
    ALREADY_IN_ROOM("Du är redan i %r"),
    ROOM_NOT_FOUND("Rummet hittades inte.");

    private String description;

    Message(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
