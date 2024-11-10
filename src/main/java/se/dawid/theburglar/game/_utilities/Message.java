package se.dawid.theburglar.game._utilities;

public enum Message {

    TEST_MESSAGE("Test Message");

    private String description;

    Message(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
