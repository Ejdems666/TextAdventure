package m3;

import m3.character.Character;
import m3.cmd.MovementInterpreter;

/**
 * Created by Ejdems on 03/11/2016.
 */
public class Game {
    private final MovementInterpreter movementInterpreter;
    private final Character player;

    public Game(Character player) {
        movementInterpreter = new MovementInterpreter();
        this.player = player;
    }

    public void run() {

    }
}
