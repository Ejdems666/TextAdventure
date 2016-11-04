package m3;

import m3.character.ICharacterController;
import m3.cmd.IInterpreter;
import m3.cmd.InterpreterException;

/**
 * Created by Ejdems on 03/11/2016.
 */
public class Game {
    private final IInterpreter movementInterpreter;
    private final ICharacterController player;

    public Game(ICharacterController player, IInterpreter movementInterpreter) {
        this.movementInterpreter = movementInterpreter;
        this.player = player;
    }

    public void run() {
        try {
            String description = movementInterpreter.interpret(player.getCommand());
            if(description == null) {
                System.exit(1);
            }
        } catch (InterpreterException e) {
            e.getMessage();
        }
    }
}
