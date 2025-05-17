package pertemuan2;

public class Car {
    // attribute
    private String nameCar;
    String brand;
    int price;

    // method
    void drive() {
        System.out.println("Mobil melaju...");
    }

    void stop() {
        System.out.println("Mobil berhenti.");
    }

    // membuat constructor
    Car(String text) {
        System.out.println(text + " buatan indonesia");
    }

    public static void main(String[] args) {
        // // deklarasi objek
        // Car mobil;
        // // instansiasi objek
        // new Car();
        // // inisialisasi objek
        // mobil = new Car();
        Car mobil = new Car("Mobil Baru");
        mobil.nameCar = "Avanza";
        mobil.brand = "Toyota";
        mobil.price = 20000000;

        System.out.println("Nama Mobil: " + mobil.nameCar);
        System.out.println("Merek Mobil: " + mobil.brand);
        System.out.println("Harga Mobil: " + mobil.price);

    }

}
