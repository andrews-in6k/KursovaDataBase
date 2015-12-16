package controllers;

import entity.Rooms;
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
@RequestMapping(value = "/rooms")
public class RoomsController {

    @Autowired
    private GeneralServiceInterface generalService;

    @RequestMapping(method = RequestMethod.GET)
    public String outputRooms(ModelMap model) {
        model.addAttribute("rooms", generalService.getRooms());
        return "rooms";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addRoom(
            @RequestParam("number") String number,
            @RequestParam("size") String size
    ) {
        Rooms room = new Rooms();

        room.setRoomNumber(Integer.parseInt(number));
        room.setSize(Integer.parseInt(size));

        generalService.addRooms(room);

        return "redirect:/rooms";
    }

    @RequestMapping(value = "/{roomId}", method = RequestMethod.DELETE)
    public String deleteRoom(@PathVariable int roomId) {
        generalService.removeRoomsById(roomId);

        return "redirect:/rooms";
    }
}
