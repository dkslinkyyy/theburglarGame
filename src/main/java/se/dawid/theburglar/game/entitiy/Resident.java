package se.dawid.theburglar.game.entitiy;

public class Resident extends Entity{

    public Resident(String role, int health, int damage) {
        super(role, health, damage);
    }

    public void setDamage(int damage) {
        super.damage = damage;
    }

}
