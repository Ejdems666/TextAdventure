//package m3.cmd;
//
//import m3.character.ICharacter;
//
///**
// * Created by Ejdems on 03/11/2016.
// */
//public class FightInterpreter {
//    private final ICharacter[] fighters = new ICharacter[2];
//    private int round = 0;
//
//    public FightInterpreter(ICharacter defender, ICharacter attacker) {
//        fighters[0] = defender;
//        fighters[1] = attacker;
//    }
//
//    public String attack(ICharacter attacker, ICharacter defender) {
//        defender.takeDamage(attacker.getDamage());
//    }
//
//    public String defend(ICharacter defender) {
//        defender.defend();
//    }
//}
