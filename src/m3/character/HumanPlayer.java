package m3.character;

import m3.Room;

/**
 * Created by Ejdems on 03/11/2016.
 */
public class HumanPlayer extends Player {
    public HumanPlayer(Room startingRoom) {
        currentRoom = startingRoom;
    }

    @Override
    public String getCommand() {
        return null;
    }
}
