package m3.cmd;

import m3.character.ICharacter;

/**
 * Created by Ejdems on 03/11/2016.
 */
public class MovementInterpreter implements IInterpreter {
    private final ICharacter player;

    public MovementInterpreter(ICharacter player) {
        this.player = player;
        player.takeDamage(player.getDamage());
    }

    @Override
    public String interpret(String command) {
        return null;
    }
}
