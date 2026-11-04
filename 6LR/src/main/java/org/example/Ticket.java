package org.example;

public class Ticket {

    private String event;
    private String seatNumber;
    private double price;
    private int quanity;

    public int getQuanity() {
        return quanity;
    }

    void setQuanity(int value) {
        this.quanity = value;
    }

    Ticket(String value1, String value2, double value3, int value4) {
        this(value1, value2, value3);
        setQuanity(value4);
    }


    Ticket(String event, String seatNumber, double price) {
        this.event = event;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    String getEvent() {
        return event;
    }

    String getSeatNumber() {
        return seatNumber;
    }

    double getPrice() {
        return price;
    }

    void applyDiscount(double percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть в диапазоне от 0 до 100");
        }
        price = price - price * percent / 100;
    }

    void printInfo() {
        IO.println("Мероприятие: " + event);
        IO.println("Место: " + seatNumber);
        IO.println("Цена: " + String.format("%.2f", price));
    }


    void main() {
        Ticket ticket = null;
        boolean running = true;

        IO.println("1. Создать билет");
        IO.println("2. Показать информацию о билете");
        IO.println("3. Применить скидку");
        IO.println("0. Выход");

        while (running) {
            IO.println("");

            String choice = IO.readln("Выберите пункт меню: ");

            IO.println("");

            switch (choice) {
                case "1" -> {
                    String event = IO.readln("Название мероприятия: ");
                    String seat = IO.readln("Номер места: ");
                    try {
                        double price = Double.parseDouble(IO.readln("Цена билета: "));
                        ticket = new Ticket(event, seat, price);
                        IO.println("Билет создан.");
                    } catch (NumberFormatException e) {
                        IO.println("Цена должна быть числом. Билет не создан.");
                    }
                }
                case "2" -> {
                    if (ticket == null) {
                        IO.println("Сначала создайте билет.");
                    } else {
                        ticket.printInfo();
                    }
                }
                case "3" -> {
                    if (ticket == null) {
                        IO.println("Сначала создайте билет.");
                    } else {
                        try {
                            double percent = Double.parseDouble(IO.readln("Введите процент скидки: "));
                            ticket.applyDiscount(percent);
                            IO.println("Скидка применена.");
                            ticket.printInfo();
                        } catch (NumberFormatException e) {
                            IO.println("Процент скидки должен быть числом.");
                        } catch (IllegalArgumentException e) {
                            IO.println(e.getMessage());
                        }
                    }
                }
                case "0" -> running = false;
                default -> IO.println("Некорректный пункт меню, попробуйте снова.");
            }
        }

        IO.println("Работа программы завершена.");
    }
}


