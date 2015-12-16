package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
}
