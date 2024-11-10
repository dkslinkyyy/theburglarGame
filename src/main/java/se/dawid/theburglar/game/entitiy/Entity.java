package se.dawid.theburglar.game.entitiy;

public abstract class Entity {

    private String role;
    private int health;
    protected int damage;

    public Entity(String role, int health, int damage) {
        this.role = role;
        this.health = health;
        this.damage = damage;
    }

    public void punch(Entity target) {
        target.takeHit(getDamage());
    }

    private void takeHit(int damage) {
        health -= damage;
    }

    public void addDamage(int damage) {
        this.damage += damage;
    }

    public boolean isConscious() {
        return health > 0;
    }

    public String getRole() {
        return role;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }
}
