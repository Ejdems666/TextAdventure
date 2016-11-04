package m3.character;

import m3.Room;

/**
 * Created by Ejdems on 03/11/2016.
 */
public interface ICharacterInfo {
    public int getHealth();
    public int getStrength();
    public int getDefense();
    public String getName();
    public Room getCurrentRoom();
}
