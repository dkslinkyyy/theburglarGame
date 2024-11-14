package se.dawid.theburglar.game._utilities;

public enum Command {
    GO_TO_CMD("gå till"),
    EXIT_CMD("EXIT"),
    FIGHT_CMD("slå"),
    LEAVE_CMD("lämna");

    private String message;

    public String getMessage() {
        return message;
    }

    Command(String message) {
        this.message = message;
    }
}
