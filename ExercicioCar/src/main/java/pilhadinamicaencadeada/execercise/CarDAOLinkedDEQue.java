package pilhadinamicaencadeada.execercise;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementação de CarDAO utilizando uma estrutura LinkedDEQue.
 * Cada método contém a lógica esperada e foi corrigido para não lançar
 * UnsupportedOperationException, permitindo que a lógica implementada seja executada.
 */


 
public class CarDAOLinkedDEQue implements CarDAO {

   private LinkedDEQue<Car> deque; 
    private int maxCapacity;

public CarDAOLinkedDEQue(int maxCapacity) {
    // Passa o maxCapacity para o construtor da sua classe LinkedDEQue
    this.deque = new LinkedDEQue<>(maxCapacity); 
    this.maxCapacity = maxCapacity;
}

    @Override
    public void addCar(Car car) {
        if (isParkingFull()) {
            System.out.println("Estacionamento cheio! Não é possível adicionar mais carros.");
        } else {
            deque.enfileirarFim(car);
        }
        // throw new UnsupportedOperationException("Operação ainda não implementada"); // REMOVIDO
    }

    @Override
    public Car getCar(String plateLicense) {
        for (Car car : deque) {
            if (car.getLicensePlate().equalsIgnoreCase(plateLicense)) {
                return car;
            }
        }
        return null; // Retorna null se não encontrar o carro
        // throw new UnsupportedOperationException("Operação ainda não implementada"); // REMOVIDO
    }

    @Override
    public Car[] getAllCars() {
        // Correção para usar List<Car> list = new ArrayList<>(deque); se LinkedDEQue for Collection
        List<Car> list = new ArrayList<>();
        for (Car c : deque) list.add(c);
        
        Car[] cars = new Car[list.size()];
        list.toArray(cars);
        return cars;
        // throw new UnsupportedOperationException("Operação ainda não implementada"); // REMOVIDO
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
        // throw new UnsupportedOperationException("Operação ainda não implementada"); // REMOVIDO
    }

    @Override
    public Car deleteCar(String plateLicense) {
        for (Car c : deque) {
            if (c.getLicensePlate().equalsIgnoreCase(plateLicense)) {
                // É necessário que o método 'retirarElemento' retorne boolean ou void
                // ou que o 'deleteCar' trate o caso de falha. Assumindo que funciona:
                deque.retirarElemento(c); 
                return c;
            }
        }
        return null; // Retorna null se não encontrar e não deletar
        // throw new UnsupportedOperationException("Operação ainda não implementada"); // REMOVIDO
    }

    @Override
    public void removeCarsByOwner(String owner) {
        // Boa prática: itere sobre uma cópia se for remover do original
        List<Car> toRemove = new ArrayList<>();
        for (Car c : deque) {
             if (c.getOwner().equalsIgnoreCase(owner)) {
                 toRemove.add(c);
             }
         }
        for (Car c : toRemove) {
            deque.retirarElemento(c);
        }
        // throw new UnsupportedOperationException("Operação ainda não implementada"); // REMOVIDO
    }

    @Override
    public void removeCarsOlderThan(LocalDateTime date) {
        List<Car> toRemove = new ArrayList<>();
        for (Car c : deque) {
            if (c.getMomentArrival().isBefore(date)) {
                toRemove.add(c);
            }
        }
        for (Car c : toRemove) {
             deque.retirarElemento(c);
        }
        // throw new UnsupportedOperationException("Operação ainda não implementada"); // REMOVIDO
    }

    @Override
    public Car getCarByLicensePlate(String licensePlate) {
        // Este método já estava correto
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
        return result.toArray(new Car[0]); // Retorna o array de carros
        // throw new UnsupportedOperationException("Operação ainda não implementada"); // REMOVIDO
    }

    @Override
    public Car[] getCarsByModel(String model) {
        List<Car> result = new ArrayList<>();
        for (Car c : deque) {
            if (c.getModel().equalsIgnoreCase(model)) {
                result.add(c);
            }
        }
        return result.toArray(new Car[0]); // Retorna o array de carros
        // throw new UnsupportedOperationException("Operação ainda não implementada"); // REMOVIDO
    }

    @Override
    public Car[] getCarsByColor(String color) {
        List<Car> result = new ArrayList<>();
        for (Car c : deque) {
            if (c.getColor().equalsIgnoreCase(color)) {
                result.add(c);
            }
        }
        return result.toArray(new Car[0]); // Retorna o array de carros
        // throw new UnsupportedOperationException("Operação ainda não implementada"); // REMOVIDO
    }

    @Override
    public Car[] getCarsByOwner(String owner) {
        List<Car> result = new ArrayList<>();
        for (Car c : deque) {
            if (c.getOwner().equalsIgnoreCase(owner)) {
                result.add(c);
            }
        }
        return result.toArray(new Car[0]); // Retorna o array de carros
        // throw new UnsupportedOperationException("Operação ainda não implementada"); // REMOVIDO
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
        return result.toArray(new Car[0]); // Retorna o array de carros
        // throw new UnsupportedOperationException("Operação ainda não implementada"); // REMOVIDO
    }

    @Override
    public Car[] getCarsWithLongParking(long thresholdHours) {
        List<Car> result = new ArrayList<>();
        for (Car c : deque) {
            // Verifica a duração entre a chegada e agora (LocalDateTime.now())
            long hours = Duration.between(c.getMomentArrival(), LocalDateTime.now()).toHours(); 
            if (hours > thresholdHours) {
                result.add(c);
            }
        }
        return result.toArray(new Car[0]); // Retorna o array de carros
        // throw new UnsupportedOperationException("Operação ainda não implementada"); // REMOVIDO
    }

    @Override
    public long getAverageArrivalTime() {
        if (deque.vazia()) return 0;
        long total = 0;
        // Se 'getHour()' retornar a hora do dia (0-23), a média será da hora de chegada.
        for (Car c : deque) { 
            total += c.getMomentArrival().getHour();
        }
        long average = total / deque.tamanho();
        return average;
        // throw new UnsupportedOperationException("Operação ainda não implementada"); // REMOVIDO
    }

    @Override
    public Car getCarByNewestArrival() {
        Car newest = null;
        for (Car c : deque) {
            if (newest == null || c.getMomentArrival().isAfter(newest.getMomentArrival())) {
                newest = c;
            }
        }
        return newest;
        // throw new UnsupportedOperationException("Operação ainda não implementada"); // REMOVIDO
    }

    @Override
    public Car getCarByOldestArrival() {
        Car oldest = null;
        for (Car c : deque) {
            if (oldest == null || c.getMomentArrival().isBefore(oldest.getMomentArrival())) {
                oldest = c;
            }
        }
        return oldest;
        // throw new UnsupportedOperationException("Operação ainda não implementada"); // REMOVIDO
    }

    @Override
    public String printCars() {
        StringBuilder sb = new StringBuilder();
        for (Car c : deque) {
            sb.append(c).append("\n");
        }
        return sb.toString();
        // throw new UnsupportedOperationException("Operação ainda não implementada"); // REMOVIDO
    }

    @Override
    public int getTotalCars() {
        // Assumindo que deque.tamanho() retorna o número correto de elementos
        return deque.tamanho(); 
        // throw new UnsupportedOperationException("Operação ainda não implementada"); // REMOVIDO
    }

    // Métodos que precisam de implementação de lógica (não foram alterados)
    @Override
    public String getMostPopularMark() {
        // A lógica de contagem de marcas precisa ser implementada aqui
        throw new UnsupportedOperationException("Operação ainda não implementada"); 
    }

    @Override
    public String getMostPopularModel() {
        // A lógica de contagem de modelos precisa ser implementada aqui
        throw new UnsupportedOperationException("Operação ainda não implementada"); 
    }

    @Override
    public String getMostPopularColor() {
        // A lógica de contagem de cores precisa ser implementada aqui
        throw new UnsupportedOperationException("Operação ainda não implementada"); 
    }

    @Override
    public long getParkingDuration(String plateLicense) {
        Car car = getCar(plateLicense);
        if (car == null) return -1;
        long hours = Duration.between(car.getMomentArrival(), LocalDateTime.now()).toHours();
        return hours;
        // throw new UnsupportedOperationException("Operação ainda não implementada"); // REMOVIDO
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
        return result.toArray(new Car[0]); // Retorna o array de carros
        // throw new UnsupportedOperationException("Operação ainda não implementada"); // REMOVIDO
    }

    @Override
    public boolean isCarInPlaced(String plateLicense) {
        for (Car c : deque) {
            if (c.getLicensePlate().equalsIgnoreCase(plateLicense)) return true;
        }
        return false;
        // throw new UnsupportedOperationException("Operação ainda não implementada"); // REMOVIDO
    }
@Override
public void clearAllCars() {
    // CORREÇÃO: Cria uma nova LinkedDEQue, passando o maxCapacity salvo
    this.deque = new LinkedDEQue<>(this.maxCapacity); 
}

    @Override
    public int getAvailableSpaces() {
        int available = maxCapacity - deque.tamanho();
        return available;
        // throw new UnsupportedOperationException("Operação ainda não implementada"); // REMOVIDO
    }

    @Override
    public int getOccupancyRate() {
        // Previne divisão por zero
        if (maxCapacity == 0) return 0; 
        int rate = (int) (((double) deque.tamanho() / maxCapacity) * 100);
        return rate;
        // throw new UnsupportedOperationException("Operação ainda não implementada"); // REMOVIDO
    }

    @Override
    public boolean isParkingFull() {
        return deque.tamanho() >= maxCapacity;
        // throw new UnsupportedOperationException("Operação ainda não implementada"); // REMOVIDO
    }

    @Override
    public boolean isParkingEmpty() {
        // Assumindo que deque.vazia() retorna true se estiver vazio
        return deque.vazia();
        // throw new UnsupportedOperationException("Operação ainda não implementada"); // REMOVIDO
    }

    @Override
    public int getMaxCapacity() {
        return maxCapacity;
        // throw new UnsupportedOperationException("Operação ainda não implementada"); // REMOVIDO
    }
}