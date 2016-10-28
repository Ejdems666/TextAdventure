package m1.map;

import libs.FileIO;
import m1.HealthBoostItem;
import m1.Item;
import m1.Room;
import m1.Weapon;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ejdems on 10/10/2016.
 */
public class DungeonMap {

    private ArrayList<Room> rooms;

    public ArrayList<Room> createDungeonMap() {
        ArrayList<String> mapData = getMapResource();
        createRooms(mapData);
        for (int i = 0; i < mapData.size(); i++) {
            String[] roomData = mapData.get(i).split(",");
            try {
                setRoom(roomData, rooms.get(i));
            } catch (MapGeneratorException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
        return rooms;
    }

    private ArrayList<String> getMapResource() {
        FileIO fileIO = new FileIO();
        ArrayList<String> map = null;
        try {
            map = fileIO.readFile("resources/map.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    private void createRooms(ArrayList<String> mapData) {
        rooms = new ArrayList<>();
        for (int i = 0; i < mapData.size(); i++) {
            rooms.add(new Room());
        }
    }

    private void setRoom(String[] roomData, Room room) throws MapGeneratorException {
        setResources(roomData[0], room);
        for (int ii = 1; ii < roomData.length; ii++) {
            int connection = Integer.parseInt(roomData[ii].substring(1));
            char direction = roomData[ii].charAt(0);
            switch (direction) {
                case 'e':
                    room.setEast(rooms.get(connection));
                    break;
                case 'w':
                    room.setWest(rooms.get(connection));
                    break;
                case 's':
                    room.setSouth(rooms.get(connection));
                    break;
                case 'n':
                    room.setNorth(rooms.get(connection));
                    break;
                default:
                    throw new MapGeneratorException(rooms.indexOf(room),"Error while adding connections. Non existent connection '"+direction+"'");
            }
        }
    }

    private void setResources(String roomResources, Room room) throws MapGeneratorException {
        String[] resources = roomResources.split("-");
        if(resources.length > 1 && !resources[1].isEmpty()) {
            int gold = Integer.parseInt(resources[1]);
            room.setGold(gold);
        }
        if(resources.length > 2 && !resources[2].isEmpty()) {
            String description = resources[2];
            room.setDescription(description);
        }
        if(resources.length > 3) {
            setItems(room, resources[3]);
        }
    }

    private void setItems(Room room, String resource) throws MapGeneratorException {
        String[] items = resource.split(";");
        String[] itemResources;
        for (int i = 0; i < items.length; i++) {
            itemResources = items[i].split(":");
            Item item = null;
            switch (itemResources[0]) {
                case "w":
                    item = new Weapon();
                    break;
                case "h":
                    item = new HealthBoostItem();
                    break;
                default:
                    throw new MapGeneratorException(rooms.indexOf(room),"You didn't specify item type.");
            }
            item.setName(itemResources[1]);
            item.setDamage(Integer.parseInt(itemResources[2]));
            item.setHealthBoost(Integer.parseInt(itemResources[3]));
            item.setTemporary(Boolean.parseBoolean(itemResources[4]));
            room.getInventory().addToInventory(item);
        }
    }
}