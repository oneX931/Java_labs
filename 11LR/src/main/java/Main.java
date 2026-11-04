import org.example.Car;
import org.example.Plane;
import org.example.Vehicle;

void main() {
    var vehicle = new Vehicle("Generic", 2015, 60);
    var car = new Car("Toyota", 2022, 120, 4);
    var plane = new Plane("Boeing 737", 2020, 450, 12000);

    IO.println("Vehicle:");
    IO.println(vehicle.move());
    IO.println(vehicle.move(150));
    IO.println(vehicle.move("Минск"));

    IO.println(car.move());
    IO.println(car.move(200));
    IO.println(car.move("Гродно"));
    IO.println(car.move(200, 3));
    IO.println(car.move("Минск", "Брест"));

    IO.println(plane.move());
    IO.println(plane.move(900));
    IO.println(plane.move("Варшава"));
    IO.println(plane.move("Варшава", 10000));
    IO.println(plane.move(900, 11000));

    List<Vehicle> fleet = List.of(
            vehicle,
            car,
            plane,
            new Car("BMW", 2019, 180, 2),
            new Plane("Airbus A320", 2018, 480, 11800)
    );

    for (var v : fleet) {
        IO.println("%-28s %-28s %6.1f км/ч".formatted(v, v.move(), v.getSpeed()));
    }


    Vehicle ref = new Car("Honda", 2021, 110, 4);
    IO.println("Тип ссылки: Vehicle, тип объекта: " + ref.getClass().getSimpleName());
    IO.println(ref.move());
    IO.println(ref.move(100));
    IO.println(ref.move("Витебск"));
    IO.println("Скорость: " + ref.getSpeed());

    if (ref instanceof Car c) {
        IO.println(c.move(100, 2));
        IO.println("Дверей: " + c.getDoors());
    }

    Vehicle flying = new Plane("Embraer 190", 2017, 400, 11000);
    IO.println("Тип ссылки: Vehicle, тип объекта: " + flying.getClass().getSimpleName());
    IO.println(flying.move());
    IO.println("Скорость: " + flying.getSpeed());

    for (var v : fleet) {
        String info = switch (v) {
            case Car c -> "автомобиль, дверей: " + c.getDoors();
            case Plane p -> "самолёт, потолок: " + p.getMaxAltitude() + " м";
            default -> "обычное транспортное средство";
        };
        IO.println(v.getBrand() + " -> " + info);
    }

    Vehicle base = new Vehicle("Generic", 2010, 50);
    IO.println("Vehicle instanceof Car -> " + (base instanceof Car));
    IO.println("Car instanceof Vehicle -> " + (car instanceof Vehicle));
}