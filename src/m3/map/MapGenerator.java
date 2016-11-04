package m3.map;

import libs.FileIO;
import m3.character.BasicMonster;
import m3.character.ICharacter;
import m3.item.HealthBoostItem;
import m3.item.Item;
import m3.room.IRoom;
import m3.room.IRoomPassages;
import m3.room.Room;
import m3.item.Weapon;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ejdems on 10/10/2016.
 */
public class MapGenerator {

    private ArrayList<Room> rooms;
    private String fileName;

    public MapGenerator(String fileName) {
        this.fileName = fileName;
    }

    public IRoom createDungeonMap() {
        ArrayList<String> mapData = getMapResource();
        createRooms(mapData);
        for (int i = 0; i < mapData.size(); i++) {
            String[] roomData = mapData.get(i).split(",");
            try {
                setRoomPassages(roomData, rooms.get(i));
                setRoomResources(roomData[0], rooms.get(i));
            } catch (MapGeneratorException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
        return rooms.get(0);
    }

    private ArrayList<String> getMapResource() {
        FileIO fileIO = new FileIO();
        ArrayList<String> map = null;
        try {
            map = fileIO.readFile(fileName);
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

    private void setRoomPassages(String[] roomData, IRoomPassages room) throws MapGeneratorException {
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
                    throw new MapGeneratorException(rooms.indexOf(room),"Non existent connection '"+direction+"'");
            }
        }
    }

    private void setRoomResources(String roomResources, IRoom room) throws MapGeneratorException {
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
        if(resources.length > 4) {
            setMonsters(room, resources[4]);
        }
    }

    private void setItems(IRoom room, String resource) throws MapGeneratorException {
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
                    throw new MapGeneratorException(rooms.indexOf(room),"Unknown item type.");
            }
            item.setName(itemResources[1]);
            item.setDamage(Integer.parseInt(itemResources[2]));
            item.setHealthBoost(Integer.parseInt(itemResources[3]));
            item.setTemporary(Boolean.parseBoolean(itemResources[4]));
            room.getInventory().addToInventory(item);
        }
    }

    private void setMonsters(IRoom room, String resource) throws MapGeneratorException {
        String[] monstersResources = resource.split(";");
        String[] monsterResources;
        for (int i = 0; i < monstersResources.length; i++) {
            monsterResources = monstersResources[i].split(":");
            ICharacter monster = null;
            switch (monsterResources[0]) {
                case "m":
                    monster = new BasicMonster(
                            room,
                            monsterResources[1],
                            Integer.parseInt(monsterResources[3]),
                            Integer.parseInt(monsterResources[4]),
                            Integer.parseInt(monsterResources[5])
                    );
                    break;
                default:
                    throw new MapGeneratorException(rooms.indexOf(room),"Unknown monster type.");
            }
            monster.setGold(Integer.parseInt(monsterResources[2]));
            room.addMonster(monster);
        }
    }
}