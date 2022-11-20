public class Car {

    private int id;
    private String model;
    private String color;
    private int speed;

    public Car(int id) {
        this.id = id;
    }


    public Car(int id, String model, String color, int speed) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.speed = speed;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setId(int id) {
        this.id = id;
    }
}
