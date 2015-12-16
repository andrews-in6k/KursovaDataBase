package services;

import dao.RentTermsDAO;
import entity.RentTerms;

import java.util.List;

/**
 * Created by ANRI on 16.12.2015.
 */
public class RentTermsService implements RentTermsServiceInterface {
    private RentTermsDAO rentTermsDAO;

    public RentTermsService(RentTermsDAO rentTermsDAO) {
        this.rentTermsDAO = rentTermsDAO;
    }

    @Override
    public List<RentTerms> getRentTerms() {
        return rentTermsDAO.getTableRows();
    }

    @Override
    public void addRentTerms(RentTerms rentTerms) {
        rentTermsDAO.save(rentTerms);
    }

    @Override
    public void updateRentTerms(RentTerms rentTerms) {
        rentTermsDAO.update(rentTerms);
    }

    @Override
    public void removeRentTerms(RentTerms rentTerms) {
        rentTermsDAO.delete(rentTerms);
    }

    @Override
    public RentTerms getRentTermsById(int id) {
        return rentTermsDAO.getById(id);
    }

    @Override
    public void removeRentTermsById(int id) {
        rentTermsDAO.delete(rentTermsDAO.getById(id));
    }
}
