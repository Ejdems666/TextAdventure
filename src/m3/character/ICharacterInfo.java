package m3.character;

import m3.room.IRoom;
import m3.room.Room;

/**
 * Created by Ejdems on 03/11/2016.
 */
public interface ICharacterInfo {
    public int getHealth();
    public int getStrength();
    public int getDefense();
    public String getName();
    public IRoom getCurrentRoom();
    public int getGold();
}
