import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();
        final int timeToCheckCarAvailability = 500;
        final int timeToGetCarFromSalon = 1000;
        final int timeToProduceNewCar = 900;
        final int numberOfCarsToProduce = 10;

        // Thread to simulate first customer
        new Thread(() -> {
            Thread.currentThread().setName("Покупатель1");
            for (int i = 0; i < 8; i++) {
                System.out.println("Покупатель1 зашел в салон");
                try {
                    Thread.sleep(timeToCheckCarAvailability);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (cars) {
                    if (!cars.isEmpty()) {
                        cars.remove(0);
                        System.out.println("Покупатель1 уехал на новеньком авто");
                        try {
                            Thread.sleep(timeToGetCarFromSalon);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Покупатель1 - Машин нет");
                    }
                }
            }
        }).start();

        // Thread to simulate second customer
        new Thread(() -> {
            Thread.currentThread().setName("Покупатель2");
            for (int i = 0; i < 8; i++) {
                System.out.println("Покупатель2 зашел в салон");
                try {
                    Thread.sleep(timeToCheckCarAvailability);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (cars) {
                    if (!cars.isEmpty()) {
                        cars.remove(0);
                        System.out.println("Покупатель2 уехал на новеньком авто");
                        try {
                            Thread.sleep(timeToGetCarFromSalon);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Покупатель2 - Машин нет");
                    }
                }
            }
        }).start();

        // Thread to simulate third customer
        new Thread(() -> {
            Thread.currentThread().setName("Покупатель3");
            for (int i = 0; i < 8; i++) {
                System.out.println("Покупатель3 зашел в салон");
                try {
                    Thread.sleep(timeToCheckCarAvailability);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (cars) {
                    if (!cars.isEmpty()) {
                        cars.remove(0);
                        System.out.println("Покупатель1 уехал на новеньком авто");
                        try {
                            Thread.sleep(timeToGetCarFromSalon);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Покупатель3 - Машин нет");
                    }
                }
            }
        }).start();


        // Thread to simulate cars production
        new Thread(() -> {
            Thread.currentThread().setName("Производитель");
            for (int i = 0; i < numberOfCarsToProduce; i++) {
                System.out.println("Производитель Toyota выпустил 1 авто");
                cars.add(new Car(i));
                try {
                    Thread.sleep(timeToProduceNewCar);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}