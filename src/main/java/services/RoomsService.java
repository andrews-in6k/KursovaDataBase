package services;

import dao.RoomsDAO;
import entity.Goods;
import entity.RentTerms;
import entity.Rooms;

import java.util.List;

/**
 * Created by ANRI on 16.12.2015.
 */
public class RoomsService implements RoomsServiceInterface {
    private RoomsDAO roomsDAO;
    private GoodsService goodsService;
    private RentTermsService rentTermsService;

    public RoomsService(
            RoomsDAO roomsDAO,
            GoodsService goodsService,
            RentTermsService rentTermsService
    ) {
        this.roomsDAO = roomsDAO;
        this.goodsService = goodsService;
        this.rentTermsService = rentTermsService;
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
        for (RentTerms rentTerm : rooms.getRentTerms()){
            rentTermsService.removeRentTerms(rentTerm);
        }

        for (Goods goods : rooms.getGoods()){
            goodsService.removeGoods(goods);
        }

        roomsDAO.delete(rooms);
    }

    @Override
    public Rooms getRoomsById(int id) {
        return roomsDAO.getById(id);
    }

    @Override
    public void removeRoomsById(int id) {
        for (RentTerms rentTerm : getRoomsById(id).getRentTerms()){
            rentTermsService.removeRentTerms(rentTerm);
        }

        for (Goods goods : getRoomsById(id).getGoods()){
            goodsService.removeGoods(goods);
        }

        roomsDAO.delete(roomsDAO.getById(id));
    }
}
