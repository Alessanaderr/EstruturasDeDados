package estruturasdinamicagenerica.linkedstack.execercise;

import java.time.LocalDateTime;

public class Car {
    private String licensePlate;
    private String mark;
    private String model;
    private String color;
    private String owner;
    private LocalDateTime momentArrival;

    public Car(String licensePlate, String mark, String model, String color, String owner, LocalDateTime momentArrival) {
        this.licensePlate = licensePlate;
        this.mark = mark;
        this.model = model;
        this.color = color;
        this.owner = owner;
        this.momentArrival = momentArrival;
    }

    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }

    public String getMark() { return mark; }
    public void setMark(String mark) { this.mark = mark; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }

    public LocalDateTime getMomentArrival() { return momentArrival; }
    public void setMomentArrival(LocalDateTime momentArrival) { this.momentArrival = momentArrival; }

    @Override
    public String toString() {
        return String.format("Car[plate=%s, mark=%s, model=%s, color=%s, owner=%s, arrival=%s]",
                licensePlate, mark, model, color, owner, momentArrival);
    }
}
