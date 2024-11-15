package se.dawid.theburglar.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.dawid.theburglar.game.entitiy.Burglar;
import se.dawid.theburglar.game.entitiy.Resident;

import static org.junit.jupiter.api.Assertions.*;

public class EntityTest {

    private Resident resident;
    private Burglar burglar;

    @BeforeEach
    void setUp() {
        resident = new Resident("Boende", 12,3);
        burglar = new Burglar("Tjuv", 12,4);

    }

    @Test
    void takeHitReducesHealthTest() {
        resident.takeHit(10);
        assertEquals(2, resident.getHealth());
    }

    @Test
    void  isNotConsciousWhenHealthZeroOrBelowTest() {
        resident.takeHit(12);
        assertFalse(resident.isConscious());

        resident.takeHit(5);

        assertFalse(resident.isConscious());
    }

    @Test
    void testBattleWithoutFryingPan() {
        while (resident.isConscious() && burglar.isConscious()) {
            burglar.takeHit(resident.getDamage());
            if (!burglar.isConscious()) break;

            resident.takeHit(burglar.getDamage());
        }

        assertFalse(resident.isConscious());
        assertTrue(burglar.isConscious());
    }

    @Test
    void testBattleWithFryingPan() {
        resident.addDamage(3); //låtsas att boende får stekpana

        while (resident.isConscious() && burglar.isConscious()) {
            burglar.takeHit(resident.getDamage());
            if (!burglar.isConscious()) break;

            resident.takeHit(burglar.getDamage());
        }

        assertTrue(resident.isConscious());
        assertFalse(burglar.isConscious());
    }


    @Test
    void takeHitAndConsciousTest() {

        resident.takeHit(burglar.getDamage());

        assertEquals(8, resident.getHealth());

        assertTrue(resident.isConscious());

        resident.takeHit(burglar.getDamage());
        assertEquals(4, resident.getHealth());

        resident.takeHit(10);
        assertEquals(-6, resident.getHealth());

        assertFalse(resident.isConscious());

    }



}
