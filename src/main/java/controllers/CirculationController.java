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
@RequestMapping(value = "/circulation")
public class CirculationController {

    @Autowired
    GeneralServiceInterface generalService;

    @RequestMapping(method = RequestMethod.GET)
    public String outputCirculations(ModelMap model) {
        model.addAttribute("circulations", generalService.getCirculation());
        return "circulation";
    }
}
