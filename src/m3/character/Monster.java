package m3.character;

import m3.room.Room;

/**
 * Created by Ejdems on 04/11/2016.
 */
public abstract class Monster extends Character {
    @Override
    public void moveHere(Room room) {
        currentRoom.removeMonster(this);
        room.addMonster(this);
        currentRoom = room;
    }
}
