package services;

import entity.Circulation;
import entity.Goods;

import java.util.List;

/**
 * Created by ANRI on 15.12.2015.
 */
public interface GoodsServiceInterface {
    List<Goods> getGoods();
    void addGoods(Goods goods);
    void updateGoods(Goods goods);
    void removeGoods(Goods goods);
    Goods getGoodsById(int id);
    void removeGoodsById(int id);
}
