package m3.cmd;

import m3.character.ICharacter;

/**
 * Created by Ejdems on 03/11/2016.
 */
public class FightInterpreter implements IInterpreter {
    private final ICharacter monster;
    private final ICharacter player;

    public FightInterpreter(ICharacter monster, ICharacter player) {
        this.monster = monster;
        this.player = player;
    }

    @Override
    public String interpret(String command) {
        return null;
    }
}
