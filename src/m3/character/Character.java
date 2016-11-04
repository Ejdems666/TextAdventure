package m3.character;

import m3.room.IRoom;

/**
 * Created by Ejdems on 03/11/2016.
 */
public abstract class Character implements ICharacter, ICharacterController {
    protected IRoom currentRoom;
    protected String name;
    protected int health;
    protected int strength;
    protected int defense;
    protected int gold;
    protected String status;

    @Override
    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public IRoom getCurrentRoom() {
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
    public int getGold() {
        return gold;
    }

    @Override
    public String getStatus() {
        return status;
    }
}
