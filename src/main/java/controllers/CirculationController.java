package controllers;

import entity.Circulation;
import entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import services.GeneralServiceInterface;

import java.time.LocalDate;

/**
 * Created by ANRI on 16.12.2015.
 */
@Controller
@RequestMapping(value = "/circulation")
public class CirculationController {

    @Autowired
    GeneralServiceInterface generalService;

    @RequestMapping(method = RequestMethod.GET)
    public String outputCirculations(ModelMap model) {
        model.addAttribute("circulations", generalService.getCirculation());
        model.addAttribute("goods", generalService.getGoods());
        model.addAttribute("rooms", generalService.getRooms());
        return "circulation";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addCirculation(
            @RequestParam("changeDate") String changeDate,
            @RequestParam("amount") String amount,
            @RequestParam("new") String newOrNot,
            @RequestParam("goodsSelect") String goodsId,
            @RequestParam("goodsName") String goodsName,
            @RequestParam("measureValue") String measureValue,
            @RequestParam("roomSelect") String roomId
    ) {
        Circulation circulation = new Circulation();

        circulation.setChangeDate(LocalDate.parse(changeDate));
        circulation.setChangeAmount(Integer.parseInt(amount));

        if (newOrNot.equals("no")) {
            circulation.setNewOrNot(0);
            circulation.setGoods(generalService.getGoodsById(Integer.parseInt(goodsId)));
        } else {
            circulation.setNewOrNot(1);

            Goods goods = new Goods();

            goods.setName(goodsName);
            goods.setAmount(Integer.parseInt(amount));
            goods.setMeasureValue(measureValue);
            goods.setRoom(generalService.getRoomsById(Integer.parseInt(roomId)));

            generalService.addGoods(goods);

            circulation.setGoods(goods);
        }

        generalService.addCirculation(circulation);

        return "redirect:/circulation";
    }
}
