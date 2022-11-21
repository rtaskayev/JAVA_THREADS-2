import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();
        final int timeToCheckCarAvailability = 500;
        final int timeToGetCarFromSalon = 1000;
        final int timeToProduceNewCar = 900;
        final int numberOfCarsToProduce = 12;
        final int numberOfAttemptsToBuyCar = 4;

        ReentrantLock lock = new ReentrantLock();

        // Thread to simulate first customer
        new Thread(() -> {
            for (int i = 0; i < numberOfAttemptsToBuyCar; i++) {
                System.out.println("Покупатель1 зашел в салон");
                try {
                    Thread.sleep(timeToCheckCarAvailability);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                try {
                    while(true) {
                        if (!cars.isEmpty()) {
                            cars.remove(0);
                            System.out.println("Покупатель1 уехал на новеньком авто");
                            Thread.sleep(timeToGetCarFromSalon);
                            break;
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        // Thread to simulate second customer
        new Thread(() -> {
            for (int i = 0; i < numberOfAttemptsToBuyCar; i++) {
                System.out.println("Покупатель2 зашел в салон");
                try {
                    Thread.sleep(timeToCheckCarAvailability);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                try {
                    while(true) {
                        if (!cars.isEmpty()) {
                            cars.remove(0);
                            System.out.println("Покупатель2 уехал на новеньком авто");
                            Thread.sleep(timeToGetCarFromSalon);
                            break;
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        // Thread to simulate third customer
        new Thread(() -> {
            for (int i = 0; i < numberOfAttemptsToBuyCar; i++) {
                System.out.println("Покупатель3 зашел в салон");
                try {
                    Thread.sleep(timeToCheckCarAvailability);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                try {
                    while(true) {
                        if (!cars.isEmpty()) {
                            cars.remove(0);
                            System.out.println("Покупатель3 уехал на новеньком авто");
                            Thread.sleep(timeToGetCarFromSalon);
                            break;
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();


        // Thread to simulate cars production
        new Thread(() -> {
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