package m3.character;

import m3.Room;

/**
 * Created by Ejdems on 03/11/2016.
 */
public abstract class Character implements ICharacter {
    protected Room currentRoom;
    protected String name;
    protected int health;
    protected int strength;
    protected int defense;

    @Override
    public Room getCurrentRoom() {
        return currentRoom;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public void moveHere(Room room) {
        currentRoom = room;
    }
}
