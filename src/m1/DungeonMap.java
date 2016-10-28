package m1;

import libs.FileIO;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ejdems on 10/10/2016.
 */
public class DungeonMap {

    private ArrayList<Room> rooms;

    public void createDungeonMap() {
        // TODO: implement reading from a file
        ArrayList<String> mapResources = getMapResource();
        rooms = new ArrayList<>(mapResources.size());
        for (int i = 0; i < mapResources.size(); i++) {
            String[] roomResources = mapResources.get(i).split(",");
            if(roomResources.length > 1) {
                Room room = rooms.get(i);
                setRoom(roomResources, room);
            }
        }
    }

    private void setRoom(String[] roomResources, Room room) {
        String[] resources = roomResources[0].split("-");
        int gold = Integer.parseInt(resources[1]);
        room.setGold(gold);
        for (int ii = 1; ii < roomResources.length; ii++) {
            int connection = Integer.parseInt(roomResources[ii].substring(1));
            room.connectEast(rooms.get(connection));
        }
    }

    private ArrayList<String> getMapResource() {
        FileIO fileIO = new FileIO();
        ArrayList<String> map = null;
        try {
            map = fileIO.readFile("map.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}