package web.Service;

import org.springframework.stereotype.Service;
import web.Model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private List<Car> carList = List.of(new Car(1, "BMW", 5),
            new Car(2, "Mers", 3),
            new Car(3, "Opel", 4),
            new Car(4, "Lada", 6),
            new Car(5, "Land Rover", 10));

    public List<Car> listByCount(Integer count) {
        if (count == null) {
            return carList;
        } else {
            return carList.stream().limit(count).toList();
        }
    }
}
