package services;

import entity.*;

import java.util.List;

/**
 * Created by ANRI on 16.12.2015.
 */
public class GeneralService implements GeneralServiceInterface {

    private CirculationService circulationService;
    private GoodsService goodsService;
    private RentersService rentersService;
    private RentTermsService rentTermsService;
    private RoomsService roomsService;

    public GeneralService(
            CirculationService circulationService,
            GoodsService goodsService,
            RentersService rentersService,
            RentTermsService rentTermsService,
            RoomsService roomsService
    ) {
        this.circulationService = circulationService;
        this.goodsService = goodsService;
        this.rentersService = rentersService;
        this.rentTermsService = rentTermsService;
        this.roomsService = roomsService;
    }

    /*
        CirculationService Methods
    */

    @Override
    public List<Circulation> getCirculation() {
        return circulationService.getCirculation();
    }

    @Override
    public void addCirculation(Circulation circulation) {
        circulationService.addCirculation(circulation);
    }

    @Override
    public void updateCirculation(Circulation circulation) {
        circulationService.updateCirculation(circulation);
    }

    @Override
    public void removeCirculation(Circulation circulation) {
        circulationService.removeCirculation(circulation);
    }

    @Override
    public Circulation getCirculationById(int id) {
        return circulationService.getCirculationById(id);
    }

    @Override
    public void removeCirculationById(int id) {
        circulationService.removeCirculationById(id);
    }

    /*
        GoodsService Methods
    */

    @Override
    public List<Goods> getGoods() {
        return goodsService.getGoods();
    }

    @Override
    public void addGoods(Goods goods) {
        goodsService.addGoods(goods);
    }

    @Override
    public void updateGoods(Goods goods) {
        goodsService.updateGoods(goods);
    }

    @Override
    public void removeGoods(Goods goods) {
        goodsService.removeGoods(goods);
    }

    @Override
    public Goods getGoodsById(int id) {
        return goodsService.getGoodsById(id);
    }

    @Override
    public void removeGoodsById(int id) {
        goodsService.removeGoodsById(id);
    }

    /*
        RentersService Methods
    */

    @Override
    public List<Renters> getRenters() {
        return rentersService.getRenters();
    }

    @Override
    public void addRenters(Renters renters) {
        rentersService.addRenters(renters);
    }

    @Override
    public void updateRenters(Renters renters) {
        rentersService.updateRenters(renters);
    }

    @Override
    public void removeRenters(Renters renters) {
        rentersService.removeRenters(renters);
    }

    @Override
    public Renters getRentersById(int id) {
        return rentersService.getRentersById(id);
    }

    @Override
    public void removeRentersById(int id) {
        rentersService.removeRentersById(id);
    }

    /*
        RentTermsService Methods
    */

    @Override
    public List<RentTerms> getRentTerms() {
        return rentTermsService.getRentTerms();
    }

    @Override
    public void addRentTerms(RentTerms rentTerms) {
        rentTermsService.addRentTerms(rentTerms);
    }

    @Override
    public void updateRentTerms(RentTerms rentTerms) {
        rentTermsService.updateRentTerms(rentTerms);
    }

    @Override
    public void removeRentTerms(RentTerms rentTerms) {
        rentTermsService.removeRentTerms(rentTerms);
    }

    @Override
    public RentTerms getRentTermsById(int id) {
        return rentTermsService.getRentTermsById(id);
    }

    @Override
    public void removeRentTermsById(int id) {
        rentTermsService.removeRentTermsById(id);
    }

    /*
        RoomsService Methods
    */

    @Override
    public List<Rooms> getRooms() {
        return roomsService.getRooms();
    }

    @Override
    public void addRooms(Rooms rooms) {
        roomsService.addRooms(rooms);
    }

    @Override
    public void updateRooms(Rooms rooms) {
        roomsService.updateRooms(rooms);
    }

    @Override
    public void removeRooms(Rooms rooms) {
        roomsService.removeRooms(rooms);
    }

    @Override
    public Rooms getRoomsById(int id) {
        return roomsService.getRoomsById(id);
    }

    @Override
    public void removeRoomsById(int id) {
        roomsService.removeRoomsById(id);
    }
}
