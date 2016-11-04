package m3;

import m3.character.Character;
import m3.character.ComputerPlayer;
import m3.character.HumanPlayer;
import m3.map.MapGenerator;
import libs.form.Form;
import m3.room.IRoom;
import m3.room.Room;

/**
 * Created by Ejdems on 03/11/2016.
 */
public class Initiator {
    public Character createPlayer(IRoom startingRoom) {
        Form form = createPlayerForm();
        form.askForAllFields();
        Character player;
        if (form.get("type").equals("c")) {
            player = new ComputerPlayer(startingRoom);
        } else {
            player = new HumanPlayer(startingRoom);
        }
        return player;
    }

    private Form createPlayerForm() {
        Form form = new Form();
        form.addText("type", "Computer or Player? c/p").setAllowedValues(new String[]{"c", "p"});
        form.addText("name", "Insert your name");
        return form;
    }

    public IRoom createMap() {
        Form form = createMapForm();
        form.askForAllFields();
        MapGenerator map = new MapGenerator(form.get("name")+".txt");
        return map.createDungeonMap();
    }

    private Form createMapForm() {
        Form form = new Form();
        form.addText("name", "Insert name of the map (without '.txt').\n" +
                "The txt file must be placed in resources/map folder in the root directory")
                .setDefaultValue("maps");
        return form;
    }
}
