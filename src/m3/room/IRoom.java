package m3.room;

import m3.Inventory;
import m3.character.ICharacter;

/**
 * Created by Ejdems on 04/11/2016.
 */
public interface IRoom {
    public void addMonster(ICharacter monster);

    public void removeMonster(ICharacter monster);

    public ICharacter getMonster();

    public void setDescription(String description);

    public String getDescription();

    public Room getNorth();

    public Room getEast();

    public Room getSouth();

    public Room getWest();

    public int getGold();

    public void setGold(int gold);

    public Inventory getInventory();
}
