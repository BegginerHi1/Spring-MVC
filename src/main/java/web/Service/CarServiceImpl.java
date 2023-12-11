package web.Service;

import web.Model.Car;

import java.util.List;

public class CarServiceImpl implements CarService{
    private static final List<Car> carList = List.of(new Car(1,"BMW",5),
            new Car(2,"Mers",3),
            new Car(3,"Opel",4),
            new Car(4,"Lada",6),
            new Car(5,"Land Rover",10));
    @Override
    public List<Car> listByCount(List<Car> carList, int count) {
        return carList.stream()
                .limit(count)
                .toList();
    }

    public static List<Car> getCarList() {
        return carList;
    }
}
