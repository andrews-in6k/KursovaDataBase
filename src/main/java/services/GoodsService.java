package services;

import dao.GoodsDAO;
import entity.Goods;

import java.util.List;

/**
 * Created by ANRI on 16.12.2015.
 */
public class GoodsService implements GoodsServiceInterface {
    private GoodsDAO goodsDAO;

    public GoodsService(GoodsDAO goodsDAO) {
        this.goodsDAO = goodsDAO;
    }

    @Override
    public List<Goods> getGoods() {
        return goodsDAO.getTableRows();
    }

    @Override
    public void addGoods(Goods goods) {
        goodsDAO.save(goods);
    }

    @Override
    public void updateGoods(Goods goods) {
        goodsDAO.update(goods);
    }

    @Override
    public void removeGoods(Goods goods) {
        goodsDAO.delete(goods);
    }

    @Override
    public Goods getGoodsById(int id) {
        return goodsDAO.getById(id);
    }

    @Override
    public void removeGoodsById(int id) {
        goodsDAO.delete(goodsDAO.getById(id));
    }
}
