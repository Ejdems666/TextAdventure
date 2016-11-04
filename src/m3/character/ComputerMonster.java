package m3.character;

import m3.Room;

/**
 * Created by Ejdems on 03/11/2016.
 */
public class ComputerMonster extends Character implements ICharacterController {
    public ComputerMonster(Room startingRoom) {
        currentRoom = startingRoom;
    }

    @Override
    public String getCommand() {
        return null;
    }

    @Override
    public void damageThis(ICharacter character) {

    }

    @Override
    public void takeDamage(int damage) {

    }
}
