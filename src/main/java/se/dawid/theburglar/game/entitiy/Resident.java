package se.dawid.theburglar.game.entitiy;

public class Resident extends Entity{

    private boolean fryingPan;

    public Resident(String role, int health, int damage) {
        super(role, health, damage);
    }

    public void setDamage(int damage) {
        super.damage = damage;
    }

    public void setFryingPan(boolean fryingPan) {
        this.fryingPan = fryingPan;
    }

    public boolean hasFryingPan() {
        return fryingPan;
    }

}
