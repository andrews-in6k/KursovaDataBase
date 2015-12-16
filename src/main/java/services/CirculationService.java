package services;

import dao.CirculationDAO;
import entity.Circulation;

import java.util.List;

/**
 * Created by ANRI on 16.12.2015.
 */
public class CirculationService implements CirculationServiceInterface {

    private CirculationDAO circulationDAO;

    public CirculationService(CirculationDAO circulationDAO) {
        this.circulationDAO = circulationDAO;
    }

    @Override
    public List<Circulation> getCirculation() {
        return circulationDAO.getTableRows();
    }

    @Override
    public void addCirculation(Circulation circulation) {
        circulationDAO.save(circulation);
    }

    @Override
    public void updateCirculation(Circulation circulation) {
        circulationDAO.update(circulation);
    }

    @Override
    public void removeCirculation(Circulation circulation) {
        circulationDAO.delete(circulation);
    }

    @Override
    public Circulation getCirculationById(int id) {
        return circulationDAO.getById(id);
    }

    @Override
    public void removeCirculationById(int id) {
        circulationDAO.delete(circulationDAO.getById(id));
    }
}
