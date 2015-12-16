package services;

import dao.RentersDAO;
import entity.RentTerms;
import entity.Renters;
import entity.Rooms;

import java.util.List;

/**
 * Created by ANRI on 16.12.2015.
 */
public class RentersService implements RentersServiceInterface {
    private RentersDAO rentersDAO;
    private RoomsService roomsService;
    private RentTermsService rentTermsService;

    public RentersService(RentersDAO rentersDAO, RoomsService roomsService, RentTermsService rentTermsService) {
        this.rentersDAO = rentersDAO;
        this.roomsService = roomsService;
        this.rentTermsService = rentTermsService;
    }

    @Override
    public List<Renters> getRenters() {
        return rentersDAO.getTableRows();
    }

    @Override
    public void addRenters(Renters renters) {
        rentersDAO.save(renters);
    }

    @Override
    public void updateRenters(Renters renters) {
        rentersDAO.update(renters);
    }

    @Override
    public void removeRenters(Renters renters) {
        for (RentTerms rentTerm : renters.getRentTerms()) {
            rentTermsService.removeRentTerms(rentTerm);
        }

        for (Rooms room : renters.getRooms()) {
            room.setRenter(null);

            roomsService.updateRooms(room);
        }

        rentersDAO.delete(renters);
    }

    @Override
    public Renters getRentersById(int id) {
        return rentersDAO.getById(id);
    }

    @Override
    public void removeRentersById(int id) {
        for (RentTerms rentTerm : getRentersById(id).getRentTerms()) {
            rentTermsService.removeRentTerms(rentTerm);
        }

        for (Rooms room : getRentersById(id).getRooms()) {
            room.setRenter(null);

            roomsService.updateRooms(room);
        }

        rentersDAO.delete(rentersDAO.getById(id));
    }
}
