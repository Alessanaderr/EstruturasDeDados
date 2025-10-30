package estruturasdinamicagenerica.linkedstack.execercise;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementação de CarDAO utilizando uma estrutura LinkedDEQue.
 * Cada método contém a lógica esperada e lança UnsupportedOperationException
 * para indicar que ainda não está oficialmente implementado.
 */
public class CarDAOLinkedDEQue implements CarDAO {

    private LinkedDEQue<Car> deque;
    private int maxCapacity;

    public CarDAOLinkedDEQue(int maxCapacity) {
        this.deque = new LinkedDEQue<>();
        this.maxCapacity = maxCapacity;
    }

    @Override
    public void addCar(Car car) {
        if (isParkingFull()) {
            System.out.println("Estacionamento cheio! Não é possível adicionar mais carros.");
        } else {
            deque.enfileirarFim(car);
        }
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public Car getCar(String plateLicense) {
        for (Car car : deque) {
            if (car.getLicensePlate().equalsIgnoreCase(plateLicense)) {
                return car;
            }
        }
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public Car[] getAllCars() {
        List<Car> list = new ArrayList<>();
        for (Car c : deque) list.add(c);
        Car[] cars = new Car[list.size()];
        list.toArray(cars);
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public void updateCar(Car newCar) {
        for (Car c : deque) {
            if (c.getLicensePlate().equalsIgnoreCase(newCar.getLicensePlate())) {
                c.setMark(newCar.getMark());
                c.setModel(newCar.getModel());
                c.setColor(newCar.getColor());
                c.setOwner(newCar.getOwner());
                c.setMomentArrival(newCar.getMomentArrival());
                break;
            }
        }
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public Car deleteCar(String plateLicense) {
        for (Car c : deque) {
            if (c.getLicensePlate().equalsIgnoreCase(plateLicense)) {
                deque.retirarElemento(c);
                return c;
            }
        }
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public void removeCarsByOwner(String owner) {
        for (Car c : new ArrayList<>(deque)) {
            if (c.getOwner().equalsIgnoreCase(owner)) {
                deque.retirarElemento(c);
            }
        }
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public void removeCarsOlderThan(LocalDateTime date) {
        for (Car c : new ArrayList<>(deque)) {
            if (c.getMomentArrival().isBefore(date)) {
                deque.retirarElemento(c);
            }
        }
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public Car getCarByLicensePlate(String licensePlate) {
        return getCar(licensePlate);
    }

    @Override
    public Car[] getCarsByMark(String mark) {
        List<Car> result = new ArrayList<>();
        for (Car c : deque) {
            if (c.getMark().equalsIgnoreCase(mark)) {
                result.add(c);
            }
        }
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public Car[] getCarsByModel(String model) {
        List<Car> result = new ArrayList<>();
        for (Car c : deque) {
            if (c.getModel().equalsIgnoreCase(model)) {
                result.add(c);
            }
        }
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public Car[] getCarsByColor(String color) {
        List<Car> result = new ArrayList<>();
        for (Car c : deque) {
            if (c.getColor().equalsIgnoreCase(color)) {
                result.add(c);
            }
        }
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public Car[] getCarsByOwner(String owner) {
        List<Car> result = new ArrayList<>();
        for (Car c : deque) {
            if (c.getOwner().equalsIgnoreCase(owner)) {
                result.add(c);
            }
        }
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public Car[] getCarsByMomentArrival(LocalDateTime initialMoment, LocalDateTime finalMoment) {
        List<Car> result = new ArrayList<>();
        for (Car c : deque) {
            if ((c.getMomentArrival().isAfter(initialMoment) || c.getMomentArrival().isEqual(initialMoment))
                    && (c.getMomentArrival().isBefore(finalMoment) || c.getMomentArrival().isEqual(finalMoment))) {
                result.add(c);
            }
        }
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public Car[] getCarsWithLongParking(long thresholdHours) {
        List<Car> result = new ArrayList<>();
        for (Car c : deque) {
            long hours = Duration.between(c.getMomentArrival(), LocalDateTime.now()).toHours();
            if (hours > thresholdHours) {
                result.add(c);
            }
        }
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public long getAverageArrivalTime() {
        if (deque.vazia()) return 0;
        long total = 0;
        for (Car c : deque) {
            total += c.getMomentArrival().getHour();
        }
        long average = total / deque.tamanho();
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public Car getCarByNewestArrival() {
        Car newest = null;
        for (Car c : deque) {
            if (newest == null || c.getMomentArrival().isAfter(newest.getMomentArrival())) {
                newest = c;
            }
        }
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public Car getCarByOldestArrival() {
        Car oldest = null;
        for (Car c : deque) {
            if (oldest == null || c.getMomentArrival().isBefore(oldest.getMomentArrival())) {
                oldest = c;
            }
        }
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public String printCars() {
        StringBuilder sb = new StringBuilder();
        for (Car c : deque) {
            sb.append(c).append("\n");
        }
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public int getTotalCars() {
        int total = deque.tamanho();
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public String getMostPopularMark() {
        String mark = "";
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public String getMostPopularModel() {
        String model = "";
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public String getMostPopularColor() {
        String color = "";
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public long getParkingDuration(String plateLicense) {
        Car car = getCar(plateLicense);
        if (car == null) return -1;
        long hours = Duration.between(car.getMomentArrival(), LocalDateTime.now()).toHours();
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public Car[] getCarsByParkingDuration(long minHours, long maxHours) {
        List<Car> result = new ArrayList<>();
        for (Car c : deque) {
            long hours = Duration.between(c.getMomentArrival(), LocalDateTime.now()).toHours();
            if (hours >= minHours && hours <= maxHours) {
                result.add(c);
            }
        }
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public boolean isCarInPlaced(String plateLicense) {
        for (Car c : deque) {
            if (c.getLicensePlate().equalsIgnoreCase(plateLicense)) return true;
        }
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public void clearAllCars() {
        deque = new LinkedDEQue<>();
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public int getAvailableSpaces() {
        int available = maxCapacity - deque.tamanho();
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public int getOccupancyRate() {
        int rate = (int) (((double) deque.tamanho() / maxCapacity) * 100);
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public boolean isParkingFull() {
        boolean full = deque.tamanho() >= maxCapacity;
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public boolean isParkingEmpty() {
        boolean empty = deque.vazia();
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public int getMaxCapacity() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }
}
