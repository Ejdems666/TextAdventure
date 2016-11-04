package m3.character;

import m3.Room;

/**
 * Created by Ejdems on 03/11/2016.
 */
public abstract class Player extends Character {
    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public void takeDamage(int damage) {

    }

    @Override
    public void moveHere(Room room) {
        currentRoom = room;
    }
}
