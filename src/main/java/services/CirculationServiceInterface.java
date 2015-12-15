package services;

import entity.Circulation;

import java.util.List;

/**
 * Created by ANRI on 15.12.2015.
 */
public interface CirculationServiceInterface {
    List<Circulation> getCirculation();
    void addCirculation(Circulation circulation);
    void updateCirculation(Circulation circulation);
    void removeCirculation(Circulation circulation);
    Circulation getCirculationById(int id);
    void removeCirculationById(int id);
}
