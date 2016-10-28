package m1.map;

import m1.Room;

/**
 * Created by Ejdems on 28/10/2016.
 */
public class MapGeneratorException extends Exception {
    public MapGeneratorException(int roomNumber,String message) {
        super(message+" When parsing room number "+roomNumber);
    }
}
