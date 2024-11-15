package se.dawid.theburglar.game._utilities;

public enum Message {

    WHERE_NEXT("Vart vill du gå? ex. 'gå till <rum>'"),
    ENDING_GAME("Avslutar spelet...'"),
    ROOM_NOT_AVAILABLE("Du kan inte gå direkt till det här rummet från din nuvarande plats."),
    MOVED_TO_ROOM("Du gick till %r"),
    ALREADY_IN_ROOM("Du är redan i %r"),
    FOUND_FRYING_PAN("Du har hittat en stekpanna i köket! Skriv Y|N för att ta upp den"),
    TOOK_FRYING_PAN("Du valde att ta upp stekpannan."),
    DID_NOT_TAKE_FRYING_PAN("Du valde att undvika stekpannan. Det här kan ha konsekvenser..."),
    ROOM_NOT_FOUND("Rummet hittades inte.");

    private String description;

    Message(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
