package kuis;

import java.util.Scanner;

public class kuis2 {
    // Atribut private
    private String nama;
    private String nim;
    private double ipk;

    // Setter dan Getter
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

    public double getIpk() {
        return ipk;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        kuis2 mhs = new kuis2();

        System.out.println("=== Input Data Mahasiswa ===");
        System.out.print("Masukkan Nama: ");
        String nama = input.nextLine();
        mhs.setNama(nama);

        System.out.print("Masukkan NIM: ");
        String nim = input.nextLine();
        mhs.setNim(nim);

        System.out.print("Masukkan IPK: ");
        double ipk = input.nextDouble();
        mhs.setIpk(ipk);

        System.out.println("\n=== Data Mahasiswa ===");
        System.out.println("Nama: " + mhs.getNama());
        System.out.println("NIM: " + mhs.getNim());
        System.out.println("IPK: " + mhs.getIpk());

        input.close();
    }
}