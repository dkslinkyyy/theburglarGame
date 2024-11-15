package se.dawid.theburglar.game._utilities;

public enum Command {
    GO_TO_CMD("gå till"),
    EXIT_CMD("EXIT"),
    AGREE_CMD("Y"),
    DENY_CMD("N"),
    FIGHT_CMD("fight"),
    LEAVE_CMD("leave");

    private String message;

    public String getMessage() {
        return message;
    }

    Command(String message) {
        this.message = message;
    }
}
