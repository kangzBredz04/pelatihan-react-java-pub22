package pertemuan2;

class Car2 {
    private String nameCar;
    String brand;
    int price;

    private void drive() {
        System.out.println("Mobil melaju...");
    }

    void stop() {
        System.out.println("Mobil berhenti.");
    }
}

public class CarApplication {
    public static void main(String[] args) {
        Car2 mobil = new Car2();
        // System.out.println(mobil.drive()); // kode berikut akan error
        // mobil.drive();
        mobil.brand = "Toyota";
    }
}
