package services;

import dao.RoomsDAO;
import entity.Rooms;

import java.util.List;

/**
 * Created by ANRI on 16.12.2015.
 */
public class RoomsService implements RoomsServiceInterface {
    private RoomsDAO roomsDAO;

    public RoomsService(RoomsDAO roomsDAO) {
        this.roomsDAO = roomsDAO;
    }

    @Override
    public List<Rooms> getRooms() {
        return roomsDAO.getTableRows();
    }

    @Override
    public void addRooms(Rooms rooms) {
        roomsDAO.save(rooms);
    }

    @Override
    public void updateRooms(Rooms rooms) {
        roomsDAO.update(rooms);
    }

    @Override
    public void removeRooms(Rooms rooms) {
        roomsDAO.delete(rooms);
    }

    @Override
    public Rooms getRoomsById(int id) {
        return roomsDAO.getById(id);
    }

    @Override
    public void removeRoomsById(int id) {
        roomsDAO.delete(roomsDAO.getById(id));
    }
}
