package m3.character;

import m3.Room;

/**
 * Created by Ejdems on 03/11/2016.
 */
public class HumanPlayer extends Warrior implements ICharacterController {
    public HumanPlayer(Room startingRoom) {
        currentRoom = startingRoom;
    }
}
