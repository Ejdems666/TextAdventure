package m3.character;

import m3.room.IRoom;

/**
 * Created by Ejdems on 03/11/2016.
 */
public class BasicMonster extends Monster {
    public BasicMonster(IRoom startingRoom, String name, int health, int strength, int defense) {
        currentRoom = startingRoom;
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.defense = defense;
    }

    @Override
    public String getCommand() {
        return null;
    }

    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public void takeDamage(int damage) {

    }
}
