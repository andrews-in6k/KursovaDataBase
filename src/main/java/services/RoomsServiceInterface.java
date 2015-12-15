package services;

import entity.Goods;
import entity.Rooms;

import java.util.List;

/**
 * Created by ANRI on 15.12.2015.
 */
public interface RoomsServiceInterface {
    List<Rooms> getRooms();
    void addRooms(Rooms rooms);
    void updateRooms(Rooms rooms);
    void removeRooms(Rooms rooms);
    Rooms getRoomsById(int id);
    void removeRoomsById(int id);
}
