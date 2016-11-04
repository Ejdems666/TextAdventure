package m3.character;

import m3.Room;

/**
 * Created by Ejdems on 04/11/2016.
 */
public abstract class Monster extends Character {
    @Override
    public void moveHere(Room room) {
        currentRoom.setMonster(null);
        currentRoom = room;
        currentRoom.setMonster(this);
    }
}
