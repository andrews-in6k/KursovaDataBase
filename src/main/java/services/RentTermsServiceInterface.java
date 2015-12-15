package services;

import entity.Goods;
import entity.RentTerms;

import java.util.List;

/**
 * Created by ANRI on 15.12.2015.
 */
public interface RentTermsServiceInterface {
    List<RentTerms> getRentTerms();
    void addRentTerms(RentTerms rentTerms);
    void updateRentTerms(RentTerms rentTerms);
    void removeRentTerms(RentTerms rentTerms);
    RentTerms getRentTermsById(int id);
    void removeRentTermsById(int id);
}
