package se.dawid.theburglar.game._utilities;

public class Utils {

    public static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void print(Message msg, boolean spacing, String... values) {
        String formatted = msg.getDescription();

        for(String value : values) {

                formatted = formatted.replaceAll("%r", value);
        }
        if(spacing) {
            System.out.println();
        }
        System.out.println(formatted);

    }

    public static void print(String text) {
        if(!text.isEmpty()) {
            System.out.println(text);
        }
    }
}
