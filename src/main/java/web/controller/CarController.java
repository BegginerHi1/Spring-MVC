package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Model.Car;
import web.Service.CarService;
import web.Service.CarServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class CarController {
    CarService carService = new CarServiceImpl();
    List<Car> list = CarServiceImpl.getCarList();

    @GetMapping("/cars")
    public String Cars(ModelMap modelMap, HttpServletRequest request) {
        int count = 0;
        try {
            count = Integer.parseInt(request.getParameter("count"));
        } catch (NumberFormatException e) {
            e.getCause();
        }
        if (count == 0) {
            modelMap.addAttribute("list",list);
        } else {
            List<Car> listByCount = carService.listByCount(list,count);
            modelMap.addAttribute("listByCount",listByCount);
        }
        return "cars";
    }

}