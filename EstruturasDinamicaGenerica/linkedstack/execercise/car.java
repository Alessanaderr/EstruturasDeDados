import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Classe que representa um carro no sistema de estacionamento.
 * Contém informações de identificação, proprietário e momento de chegada.
 * 
 * @author alessa
 * @version 1.0
 * @since 2025-10-20
 */
public class Car {
    
    private String plateLicense;      // Placa do carro
    private String mark;              // Marca
    private String model;             // Modelo
    private String color;             // Cor
    private String owner;             // Nome do proprietário
    private LocalDateTime arrival;    // Momento de chegada no estacionamento

    /**
     * Construtor padrão (sem parâmetros).
     */
    public Car() {}

    /**
     * Construtor completo para inicialização de todos os campos.
     * 
     * @param plateLicense Placa do carro (única)
     * @param mark Marca do carro
     * @param model Modelo do carro
     * @param color Cor do carro
     * @param owner Proprietário do carro
     * @param arrival Momento de chegada no estacionamento
     */
    public Car(String plateLicense, String mark, String model, String color, String owner, LocalDateTime arrival) {
        this.plateLicense = plateLicense;
        this.mark = mark;
        this.model = model;
        this.color = color;
        this.owner = owner;
        this.arrival = arrival;
    }

    // Getters e Setters
    public String getPlateLicense() {
        return plateLicense;
    }

    public void setPlateLicense(String plateLicense) {
        this.plateLicense = plateLicense;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    /**
     * Calcula o tempo de permanência do carro (em horas).
     * 
     * @return duração em horas desde a chegada até o momento atual
     */
    public long getParkingDurationHours() {
        if (arrival == null) return 0;
        return Duration.between(arrival, LocalDateTime.now()).toHours();
    }

    @Override
    public String toString() {
        return "Car {" +
                "Placa='" + plateLicense + '\'' +
                ", Marca='" + mark + '\'' +
                ", Modelo='" + model + '\'' +
                ", Cor='" + color + '\'' +
                ", Proprietário='" + owner + '\'' +
                ", Chegada=" + (arrival != null ? arrival.toString() : "N/A") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(plateLicense, car.plateLicense);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateLicense);
    }
}
