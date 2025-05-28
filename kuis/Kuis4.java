package kuis;

import java.util.ArrayList;

// Superclass
class Barang {
    private String nama;
    private int stok;
    private int harga;

    public Barang(String nama, int stok, int harga) {
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }

    public String getNama() {
        return this.nama;
    }

    public int getStok() {
        return this.stok;
    }

    public int getHarga() {
        return this.harga;
    }

    public void tampilkanInfo() {
        System.out.println(nama + " - Stok: " + stok + " - Harga: " + harga);
    }
}

// Subclass: Inheritance dan Overriding
class BarangDiskon extends Barang {
    private int diskon; // dalam persen

    public BarangDiskon(String nama, int stok, int harga, int diskon) {
        super(nama, stok, harga);
        this.diskon = diskon;
    }

    @Override
    public void tampilkanInfo() {
        int hargaDiskon = getHarga() - (getHarga() * diskon / 100);
        System.out.println(getNama() + " - Stok: " + getStok() + " - Harga Diskon: " + hargaDiskon);
    }
}

public class Kuis4 {
    public static void main(String[] args) {
        // ArrayList
        ArrayList<Barang> daftar = new ArrayList<>();

        // Tambahkan beberapa barang
        daftar.add(new Barang("Kopi", 10, 5000));
        daftar.add(new BarangDiskon("Teh", 0, 4000, 20)); // Diskon 20%

        System.out.println("1" + 2 + 3);
        // Perulangan dan percabangan
        for (Barang b : daftar) {
            b.tampilkanInfo(); // Method Overriding jika objek BarangDiskon
            if (b.getStok() == 0) {
                System.out.println("Stok habis!");
            }
        }
    }
}
