package controllers;

import entity.RentTerms;
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
@RequestMapping(value = "/rentterms")
public class RentTermsController {

    @Autowired
    private GeneralServiceInterface generalService;

    @RequestMapping(method = RequestMethod.GET)
    public String outputRentTerms(ModelMap model) {
        model.addAttribute("rentTerms", generalService.getRentTerms());
        model.addAttribute("rooms", generalService.getRooms());
        model.addAttribute("renters", generalService.getRenters());

        return "rentTerms";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addRentTerm(
            @RequestParam("startDate") String startDate,
            @RequestParam("finishDate") String finishDate,
            @RequestParam("roomSelect") String roomId,
            @RequestParam("renterSelect") String renterId
    ) {
        RentTerms rentTerms = new RentTerms();

        rentTerms.setStartDate(LocalDate.parse(startDate));
        rentTerms.setFinishDate(LocalDate.parse(finishDate));
        rentTerms.setRoom(generalService.getRoomsById(Integer.parseInt(roomId)));
        rentTerms.setRenter(generalService.getRentersById(Integer.parseInt(renterId)));

        generalService.addRentTerms(rentTerms);

        return "redirect:/rentterms";
    }
}
