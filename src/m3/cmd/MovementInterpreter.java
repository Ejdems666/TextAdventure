package m3.cmd;

import m3.character.ICharacter;

/**
 * Created by Ejdems on 03/11/2016.
 */
public class MovementInterpreter implements IInterpreter {
    private final ICharacter player;
    private boolean fightMode = false;
    private ICharacter attacker;
    private ICharacter defender;

    public MovementInterpreter(ICharacter player) {
        this.player = player;
        player.takeDamage(player.getDamage());
    }

    @Override
    public String interpret(String command) throws InterpreterException {
        if(fightMode) {
            switch (command) {
                case "attack":
                    defender.takeDamage(attacker.getDamage());
                    break;
                case "defend":
                    attacker.defend();
            }
            if(defender.getStatus().equals("dead")) {
                // do stuff
                return null;
            }
            ICharacter swap = defender;
            defender = attacker;
            attacker = swap;
            return null;
        }
        switch (command) {
            case "fight":
                defender = player.getCurrentRoom().getMonster();
                attacker = player;
                fightMode = true;
                break;
        }
        return null;
    }
}
