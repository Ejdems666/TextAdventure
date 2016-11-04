package m3.character;

import m3.room.IRoom;

/**
 * Created by Ejdems on 03/11/2016.
 */
public class ComputerPlayer extends Player {
    public ComputerPlayer(IRoom startingRoom) {
        currentRoom = startingRoom;
    }

    @Override
    public String getCommand() {
        return null;
    }
}
