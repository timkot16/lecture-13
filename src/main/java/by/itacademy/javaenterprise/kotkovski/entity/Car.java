package by.itacademy.javaenterprise.kotkovski.entity;

public class Car {
    private Integer id;
    private String car;
    private String vin;
    private String number;
    private int year;
    private Customer customer;

    public Car() {
    }

    public Car(Integer id, String car, String vin, String number, int year, Customer customer) {
        this.id = id;
        this.car = car;
        this.vin = vin;
        this.number = number;
        this.year = year;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", car='" + car + '\'' +
                ", vin='" + vin + '\'' +
                ", number='" + number + '\'' +
                ", year=" + year +
                ", customer=" + customer +
                '}';
    }
}
