package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.Model.Car;
import web.Service.CarService;
import web.Service.CarServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    private CarService carService = new CarServiceImpl();
    private List<Car> list = CarServiceImpl.getCarList();

    @GetMapping
    public String Cars(Model model, HttpServletRequest request) {
        int count = 0;
        try {
            count = Integer.parseInt(request.getParameter("count"));
        } catch (NumberFormatException e) {
            e.getCause();
        }
        if (count == 0) {
            model.addAttribute("list", list);
        } else {
            List<Car> listByCount = carService.listByCount(list, count);
            model.addAttribute("listByCount", listByCount);
        }
        return "cars";
    }
}
