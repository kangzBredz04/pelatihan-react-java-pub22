package kuis;

import java.util.ArrayList;
import java.util.Scanner;

// Superclass
class Person {
    private String nama; // wahyu
    private int umur; // 21

    public Person(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }

    public Person(String nama) {
        this.nama = nama;
    }

    // Enkapsulasi
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public void displayInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Umur: " + umur);
    }
}

class mahasiswa1 extends Person {

    void cek() {
        System.out.println("Cek");
    }

    public mahasiswa1(String nama, int umur) {

        super(nama, umur);
        // Person.nama = "Wahyu"
        // Person.umur = 21
        System.out.println(this.getNama());
        this.cek(); // mahasiswa1.cek()
    }

}

// Subclass menggunakan inheritance
class Mahasiswa extends Person {
    private String nim;

    public Mahasiswa(String nama, int umur, String nim) {
        super(nama, umur);
        this.nim = nim;
    }

    // public Mahasiswa(String nama) {
    // super(nama);
    // }

    // public Mahasiswa(String nama, int umur) {
    // super(nama, umur);
    // // Person.nama = nama;
    // // Person.umur = umur;
    // }

    // public Mahasiswa(){}

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    // Method overriding
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("NIM: " + nim);
    }
}

// Main program dengan CRUD
public class Main {
    static ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;

        mahasiswa1 x = new mahasiswa1("Wahyu", 1);

        do {
            System.out.println("\n== Menu CRUD Mahasiswa ==");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Lihat Daftar Mahasiswa");
            System.out.println("3. Update Mahasiswa");
            System.out.println("4. Hapus Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (pilihan) {
                case 1 -> tambahMahasiswa();
                case 2 -> tampilkanMahasiswa();
                case 3 -> updateMahasiswa();
                case 4 -> hapusMahasiswa();
                case 0 -> System.out.println("Program selesai.");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }

    static void tambahMahasiswa() {
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Umur: ");
        int umur = scanner.nextInt();
        scanner.nextLine();
        System.out.print("NIM: ");
        String nim = scanner.nextLine();

        daftarMahasiswa.add(new Mahasiswa(nama, umur, nim));
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }

    static void tampilkanMahasiswa() {
        if (daftarMahasiswa.isEmpty()) {
            System.out.println("Belum ada data mahasiswa.");
        } else {
            for (int i = 0; i < daftarMahasiswa.size(); i++) {
                System.out.println("\nData Mahasiswa ke-" + (i + 1));
                daftarMahasiswa.get(i).displayInfo();
            }
        }
    }

    static void updateMahasiswa() {
        tampilkanMahasiswa();
        if (daftarMahasiswa.isEmpty())
            return;

        System.out.print("\nMasukkan nomor mahasiswa yang akan diupdate: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < daftarMahasiswa.size()) {
            System.out.print("Nama baru: ");
            String nama = scanner.nextLine();
            System.out.print("Umur baru: ");
            int umur = scanner.nextInt();
            scanner.nextLine();
            System.out.print("NIM baru: ");
            String nim = scanner.nextLine();

            Mahasiswa mhs = daftarMahasiswa.get(index);
            mhs.setNama(nama);
            mhs.setUmur(umur);
            mhs.setNim(nim);

            System.out.println("Data berhasil diupdate.");
        } else {
            System.out.println("Nomor tidak valid.");
        }
    }

    static void hapusMahasiswa() {
        tampilkanMahasiswa();
        if (daftarMahasiswa.isEmpty())
            return;

        System.out.print("\nMasukkan nomor mahasiswa yang akan dihapus: ");
        int index = scanner.nextInt() - 1;

        if (index >= 0 && index < daftarMahasiswa.size()) {
            daftarMahasiswa.remove(index);
            System.out.println("Data berhasil dihapus.");
        } else {
            System.out.println("Nomor tidak valid.");
        }
    }
}
