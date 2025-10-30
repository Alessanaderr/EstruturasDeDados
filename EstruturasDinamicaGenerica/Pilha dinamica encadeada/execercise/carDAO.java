package estruturasdinamicagenerica.linkedstack.execercise;

import java.time.LocalDateTime;

public interface CarDAO {
    void addCar(Car car);
    Car getCar(String plateLicense);
    Car[] getAllCars();
    void updateCar(Car newCar);
    Car deleteCar(String plateLicense);
    void removeCarsByOwner(String owner);
    void removeCarsOlderThan(LocalDateTime date);

    Car getCarByLicensePlate(String licensePlate);
    Car[] getCarsByMark(String mark);
    Car[] getCarsByModel(String model);
    Car[] getCarsByColor(String color);
    Car[] getCarsByOwner(String owner);
    Car[] getCarsByMomentArrival(LocalDateTime initialMoment, LocalDateTime finalMoment);
    Car[] getCarsWithLongParking(long thresholdHours);
    long getAverageArrivalTime();

    Car getCarByNewestArrival();
    Car getCarByOldestArrival();

    String printCars();
    int getTotalCars();
    String getMostPopularMark();
    String getMostPopularModel();
    String getMostPopularColor();
    long getParkingDuration(String plateLicense);
    Car[] getCarsByParkingDuration(long minHours, long maxHours);

    boolean isCarInPlaced(String plateLicense);
    void clearAllCars();

    int getAvailableSpaces();
    int getOccupancyRate();
    boolean isParkingFull();
    boolean isParkingEmpty();
    int getMaxCapacity();
}
