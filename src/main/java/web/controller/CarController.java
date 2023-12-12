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

        System.out.println("В начале проверка в случае если пользователь не ввёл параметры," +
                " то просто добавляем в model список всех машин");
        model.addAttribute("list", CarServiceImpl.getCarList());


        System.out.println("----------------------------------------------------------");

        System.out.println("В случае если параметр был введён то, " +
                "вставляем его в метод listByCount, и так как метод listByCount ждёт" +
                "на вход этот параметр, то приходится оборачивать его в блок try," +
                "так как в случае если пользователь не ввёл параметры, то методу " +
                "listByCount нечего будет подставить в его второй параметр, и в таком" +
                " случает выскочит ошибка");
        try {
            model.addAttribute("list",
                    carService.listByCount(CarServiceImpl.getCarList(), count));
        } catch (NullPointerException e) {
            e.fillInStackTrace();
        }
        return "cars";
    }
}
