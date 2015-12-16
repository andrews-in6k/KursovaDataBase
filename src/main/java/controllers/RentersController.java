package controllers;

import entity.Renters;
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
@RequestMapping(value = "/renters")
public class RentersController {

    @Autowired
    private GeneralServiceInterface generalService;

    @RequestMapping(method = RequestMethod.GET)
    public String outputRenters(ModelMap model) {
        model.addAttribute("renters", generalService.getRenters());
        return "renters";
    }

    @RequestMapping(value = "/{renterId}/edit", method = RequestMethod.GET)
    public String turnOnEditRenter(@PathVariable int renterId, ModelMap model) {
        model.addAttribute("edit", renterId);
        model.addAttribute("renters", generalService.getRenters());

        return "renters";
    }

    @RequestMapping(value = "/{renterId}", method = RequestMethod.PUT)
    public String editRenter(
            @PathVariable int renterId,
            @RequestParam("editRenterName") String renterName,
            @RequestParam("editRenterSurname") String renterSurname,
            @RequestParam("editRenterPhoneNumber") String renterPhoneNumber
    ) {
        Renters renter = generalService.getRentersById(renterId);

        renter.setName(renterName);
        renter.setSurname(renterSurname);
        renter.setPhoneNumber(Integer.parseInt(renterPhoneNumber));

        generalService.updateRenters(renter);

        return "redirect:/renters";
    }

    @RequestMapping(value = "/{renterId}", method = RequestMethod.DELETE)
    public String deleteRenter(@PathVariable int renterId) {
        generalService.removeRentersById(renterId);

        return "redirect:/renters";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addRenter(
            @RequestParam("renterName") String renterName,
            @RequestParam("renterSurname") String renterSurname,
            @RequestParam("renterPhoneNumber") String renterPhoneNumber
    ){
        Renters renter = new Renters();

        renter.setName(renterName);
        renter.setSurname(renterSurname);
        renter.setPhoneNumber(Integer.parseInt(renterPhoneNumber));

        generalService.addRenters(renter);

        return "redirect:/renters";
    }
}
