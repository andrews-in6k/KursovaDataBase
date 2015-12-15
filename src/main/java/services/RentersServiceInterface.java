package services;

import entity.Goods;
import entity.Renters;

import java.util.List;

/**
 * Created by ANRI on 15.12.2015.
 */
public interface RentersServiceInterface {
    List<Renters> getRenters();
    void addRenters(Renters renters);
    void updateRenters(Renters renters);
    void removeRenters(Renters renters);
    Renters getRentersById(int id);
    void removeRentersById(int id);
}
