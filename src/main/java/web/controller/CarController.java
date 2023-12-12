package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Service.CarService;
import web.Service.CarServiceImpl;

@Controller
@RequestMapping("/cars")
public class CarController {
    private CarService carService = new CarServiceImpl();

    @GetMapping
    public String Cars(Model model,
                       @RequestParam(value = "count", required = false) Integer count) {
        model.addAttribute("list", CarServiceImpl.getCarList());
        try {
            model.addAttribute("list",
                    carService.listByCount(CarServiceImpl.getCarList(), count));
        } catch (NullPointerException e) {
            e.fillInStackTrace();
        }
        return "cars";
    }
}
