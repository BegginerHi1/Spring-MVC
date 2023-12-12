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
        System.out.println("В случае если пользователь не ввёл параметры, то просто" +
                "добавляем в model список всех машин");

        System.out.println("----------------------------------------------------------");

        System.out.println("Внизу будет попытка извлечь значение count из параметра" +
                "И вставить это значение в метод listByCount");
        try {
            model.addAttribute("list",
                    carService.listByCount(CarServiceImpl.getCarList(), count));
        } catch (NullPointerException e) {
            System.out.println("Выше идёт проверка, ввёл ли пользователь параметры," +
                    "иначе методу listByCount нечего будет принять на место числа," +
                    "от того и выскочит ошибка");
        }
        return "cars";
    }
}
