package m3;

import m3.character.Character;
import m3.character.ICharacterController;
import m3.cmd.IInterpreter;
import m3.cmd.MovementInterpreter;

/**
 * Created by Ejdems on 03/11/2016.
 */
public class Game {
    private final IInterpreter movementInterpreter;
    private final ICharacterController player;

    public Game(ICharacterController player, IInterpreter movementInterpreter) {
        this.movementInterpreter = movementInterpreter;
        movementInterpreter.interpret(player.getCommand());
        this.player = player;
    }

    public void run() {

    }
}
