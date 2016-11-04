package m3;

import m3.character.Character;
import m3.cmd.IInterpreter;
import m3.cmd.MovementInterpreter;
import m3.room.IRoom;
import m3.room.Room;

/**
 * Created by Ejdems on 03/11/2016.
 */
public class Main {

    public static void main(String[] args) {
        Initiator initiator = new Initiator();
        IRoom startingRoom = initiator.createMap();
        Character player = initiator.createPlayer(startingRoom);
        IInterpreter interpreter = new MovementInterpreter(player);
        Game game = new Game(player,interpreter);
        game.run();
    }
}
