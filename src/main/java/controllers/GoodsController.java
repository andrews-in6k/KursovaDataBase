package controllers;

import entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import services.GeneralServiceInterface;

/**
 * Created by ANRI on 16.12.2015.
 */
@Controller
@RequestMapping(value = "/goods")
public class GoodsController {

    @Autowired
    private GeneralServiceInterface generalService;

    @RequestMapping(method = RequestMethod.GET)
    public String outputGoods(ModelMap model) {
        model.addAttribute("goods", generalService.getGoods());
        return "goods";
    }

    @RequestMapping(value = "/{goodId}/edit", method = RequestMethod.GET)
    public String turnOnEditGoods(
            @PathVariable int goodId,
            ModelMap model
    ) {
        model.addAttribute("edit", goodId);
        model.addAttribute("goods", generalService.getGoods());
        model.addAttribute("rooms", generalService.getRooms());

        return "goods";
    }

    @RequestMapping(value = "/{goodId}", method = RequestMethod.PUT)
    public String editGoods(
            @PathVariable int goodId,
            @RequestParam("goodsName") String goodsName,
            @RequestParam("measureValue") String measureValue,
            @RequestParam("roomSelect") String roomId
    ) {
        Goods goods = generalService.getGoodsById(goodId);

        goods.setName(goodsName);
        goods.setMeasureValue(measureValue);
        goods.setRoom(generalService.getRoomsById(Integer.parseInt(roomId)));

        generalService.updateGoods(goods);

        return "redirect:/goods";
    }

    @RequestMapping(value = "/{goodId}", method = RequestMethod.DELETE)
    public String deleteGoods(@PathVariable int goodId) {
        generalService.removeGoodsById(goodId);

        return "redirect:/goods";
    }
}
