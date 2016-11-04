package m3.character;

import m3.Room;

/**
 * Created by Ejdems on 03/11/2016.
 */
public interface ICharacter extends ICharacterInfo{
    public void moveHere(Room room);

    public void damageThis(ICharacter character);

    public void takeDamage(int damage);
}
