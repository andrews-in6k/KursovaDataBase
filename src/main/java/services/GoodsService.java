package services;

import dao.GoodsDAO;
import entity.Circulation;
import entity.Goods;

import java.util.List;

/**
 * Created by ANRI on 16.12.2015.
 */
public class GoodsService implements GoodsServiceInterface {
    private GoodsDAO goodsDAO;
    private CirculationService circulationService;

    public GoodsService(GoodsDAO goodsDAO, CirculationService circulationService) {
        this.goodsDAO = goodsDAO;
        this.circulationService = circulationService;
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
        for (Circulation circulation : goods.getCirculations()) {
            circulationService.removeCirculation(circulation);
        }

        goodsDAO.delete(goods);
    }

    @Override
    public Goods getGoodsById(int id) {
        return goodsDAO.getById(id);
    }

    @Override
    public void removeGoodsById(int id) {
        for (Circulation circulation : getGoodsById(id).getCirculations()) {
            circulationService.removeCirculation(circulation);
        }

        goodsDAO.delete(goodsDAO.getById(id));
    }
}
