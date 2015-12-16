package services;

import dao.RentersDAO;
import entity.Renters;

import java.util.List;

/**
 * Created by ANRI on 16.12.2015.
 */
public class RentersService implements RentersServiceInterface {
    private RentersDAO rentersDAO;

    public RentersService(RentersDAO rentersDAO) {
        this.rentersDAO = rentersDAO;
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
        rentersDAO.delete(renters);
    }

    @Override
    public Renters getRentersById(int id) {
        return rentersDAO.getById(id);
    }

    @Override
    public void removeRentersById(int id) {
        rentersDAO.delete(rentersDAO.getById(id));
    }
}
